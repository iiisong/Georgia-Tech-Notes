;;=============================================================
;;  CS 2110 - Spring 2023
;;  Homework 6 - Preorder Traversal
;;=============================================================
;;  Name: Isaac Song
;;============================================================

;;  In this file, you must implement the 'PREORDER_TRAVERSAL' subroutine.

;;  Little reminder from your friendly neighborhood 2110 TA staff: don't run
;;  this directly by pressing 'Run' in complx, since there is nothing put at
;;  address x3000. Instead, call the subroutine by doing the following steps:
;;      * 'Debug' -> 'Simulate Subroutine Call'
;;      * Call the subroutine at the 'PREORDER_TRAVERSAL' label
;;      * Add the [root (addr), arr (addr), index] params separated by a comma (,) 
;;        (e.g. x4000, x4020, 0)
;;      * Proceed to run, step, add breakpoints, etc.
;;      * Remember R6 should point at the return value after a subroutine
;;        returns. So if you run the program and then go to 
;;        'View' -> 'Goto Address' -> 'R6 Value', you should find your result
;;        from the subroutine there (e.g. Node 8 is found at x4008)

;;  If you would like to setup a replay string (trace an autograder error),
;;  go to 'Test' -> 'Setup Replay String' -> paste the string (everything
;;  between the apostrophes (')) excluding the initial " b' ". If you are 
;;  using the Docker container, you may need to use the clipboard (found
;;  on the left panel) first to transfer your local copied string over.

.orig x3000
    ;; You do not need to write anything here
    HALT

;;  PREORDER_TRAVERSAL Pseudocode (see PDF for explanation and examples)
;;  - Nodes are blocks of size 3 in memory:
;;      * The data is located in the 1st memory location (offset 0 from the node itself)
;;      * The node's left child address is located in the 2nd memory location (offset 1 from the node itself)
;;      * The node's right child address is located in the 3rd memory location (offset 2 from the node itself)

;;  PREORDER_TRAVERSAL(Node root (addr), int[] arr (addr), int index) {
;;      if (root == 0) {
;;          return index;
;;      }
;;
;;      arr[index] = root.data;
;;      index++;
;;
;;      index = PREORDER_TRAVERSAL(root.left, arr, index);
;;      return PREORDER_TRAVERSAL(root.right, arr, index);
;;  }


PREORDER_TRAVERSAL ;; Do not change this label! Treat this as like the name of the function in a function header
    ;; Code your implementation for the PREORDER_TRAVERSAL subroutine here!
    
    ;; -- build up stackframe --
    ADD R6, R6, -4 ; push 4 wds, set rv later
    STR R7, R6, 2 ; save return address
    STR R5, R6, 1 ; save old frame pointer, lv later
    ADD R5, R6, 0 ; fp = sp
    ADD R6, R6, -5 ; push 5 words
    STR R0, R5, -1 ; save SR1
    STR R1, R5, -2 ; save SR2
    STR R2, R5, -3 ; save SR3
    STR R3, R5, -4 ; save SR4
    STR R4, R5, -5 ; save SR5

    ;; -- preorder traversal logic --

    LDR R0, R5, 4 ; root address
    BRz BASECASE

    LDR R1, R5, 5 ; arr
    LDR R2, R5, 6 ; index
    ADD R3, R1, R2 ; arr[index] address
    LDR R4, R0, 0 ;
    STR R4, R3, 0 ; arr[index] = root

    ADD R2, R2, 1 ; index ++


    ;; index = PREORDER_TRAVERSAL(root.left, arr, index);
        ADD R6, R6, -1 ; push arg
        STR R2, R6, 0  ; third param (index)
        ADD R6, R6, -1 ; push arg
        STR R1, R6, 0 ; second param (arr)
        ADD R6, R6, -1 ; push arg
        ADD R3, R0, 1 ; left node address
        LDR R3, R3, 0 ; left node locattion
        STR R3, R6, 0 ; third param (node.left)

        JSR PREORDER_TRAVERSAL

        LDR R2, R6, 0 ; index = result value 
        ADD R6, R6, 1 ; pop result value
        ADD R6, R6, 3 ; pop args
    
    ;; PREORDER_TRAVERSAL(root.right, arr, index);
        ADD R6, R6, -1 ; push arg
        STR R2, R6, 0  ; third param (modded index)
        ADD R6, R6, -1 ; push arg
        STR R1, R6, 0 ; second param (arr)
        ADD R6, R6, -1 ; push arg
        ADD R3, R0, 2 ; right node address
        LDR R3, R3, 0 ; right node locattion
        STR R3, R6, 0 ; third param (node.left)

        JSR PREORDER_TRAVERSAL
        
        LDR R2, R6, 0 ; result value
        ADD R6, R6, 1 ; pop result value
        ADD R6, R6, 3 ; pop args
    
    STR R2, R5, 3 ; store  in result value

    BR TEARDOWN

    BASECASE    
        LDR R0, R5, 6 ; index
        STR R0, R5, 3 ; store in result value
    
    TEARDOWN
    LDR R4, R5, -5 ; restore SR5
    LDR R3, R5, -4 ; restore SR4
    LDR R2, R5, -3 ; restore SR3
    LDR R1, R5, -2 ; restore SR2
    LDR R0, R5, -1 ; restore SR1
    ADD R6, R5, 0 ; pop saved regs and locals
    LDR R7, R5, 2 ; R7 = result address
    LDR R5, R5, 1 ; fp = old_fp
    ADD R6, R6, 3 ; pop 3 words
    RET

; Needed to Simulate Subroutine Call in Complx
STACK .fill xF000
.end

;;  Assuming the tree starts at address x4000, here's how the tree (see below and in the PDF) is represented in memory
;;
;;              4
;;            /   \
;;           2     8 
;;         /   \
;;        1     3 

.orig x4000 ;; 4    ;; node itself lives here at x4000
    .fill 4         ;; node.data (4)
    .fill x4004     ;; node.left lives at address x4004
    .fill x4008     ;; node.right lives at address x4008
.end

.orig x4004	;; 2    ;; node itself lives here at x4004
    .fill 2         ;; node.data (2)
    .fill x400C     ;; node.left lives at address x400C
    .fill x4010     ;; node.right lives at address x4010
.end

.orig x4008	;; 8    ;; node itself lives here at x4008
    .fill 8         ;; node.data (8)
    .fill 0         ;; node does not have a left child
    .fill 0         ;; node does not have a right child
.end

.orig x400C	;; 1    ;; node itself lives here at x400C
    .fill 1         ;; node.data (1)
    .fill 0         ;; node does not have a left child
    .fill 0         ;; node does not have a right child
.end

.orig x4010	;; 3    ;; node itself lives here at x4010
    .fill 3         ;; node.data (3)
    .fill 0         ;; node does not have a left child
    .fill 0         ;; node does not have a right child
.end

;;  Another way of looking at how this all looks like in memory
;;              4
;;            /   \
;;           2     8 
;;         /   \
;;        1     3 
;;  Memory Address           Data
;;  x4000                    4          (data)
;;  x4001                    x4004      (4.left's address)
;;  x4002                    x4008      (4.right's address)
;;  x4003                    Don't Know
;;  x4004                    2          (data)
;;  x4005                    x400C      (2.left's address)
;;  x4006                    x4010      (2.right's address)
;;  x4007                    Don't Know
;;  x4008                    8          (data)
;;  x4009                    0(NULL)
;;  x400A                    0(NULL)
;;  x400B                    Don't Know
;;  x400C                    1          (data)
;;  x400D                    0(NULL)
;;  x400E                    0(NULL)
;;  x400F                    Dont't Know
;;  x4010                    3          (data)
;;  x4011                    0(NULL)
;;  x4012                    0(NULL)
;;  x4013                    Don't Know
;;  
;;  *Note: 0 is equivalent to NULL in assembly

.orig x4020 ;; Result Array : You can change the block size for debugging!
    .blkw 5
.end