;;=============================================================
;;  CS 2110 - Spring 2023
;;  Homework 6 - Insertion Sort
;;=============================================================
;;  Name: Isaac Song
;;============================================================

;;  In this file, you must implement the 'INSERTION_SORT' subroutine.

;;  Little reminder from your friendly neighborhood 2110 TA staff: don't run
;;  this directly by pressing 'Run' in complx, since there is nothing put at
;;  address x3000. Instead, call the subroutine by doing the following steps:
;;      * 'Debug' -> 'Simulate Subroutine Call'
;;      * Call the subroutine at the 'INSERTION_SORT' label
;;      * Add the [arr (addr), length] params separated by a comma (,) 
;;        (e.g. x4000, 5)
;;      * Proceed to run, step, add breakpoints, etc.
;;      * INSERTION_SORT is an in-place algorithm, so if you go to the address
;;        of the array by going to 'View' -> 'Goto Address' -> 'Address of
;;        the Array', you should see the array (at x4000) successfully 
;;        sorted after running the program (e.g [2,3,1,1,6] -> [1,1,2,3,6])

;;  If you would like to setup a replay string (trace an autograder error),
;;  go to 'Test' -> 'Setup Replay String' -> paste the string (everything
;;  between the apostrophes (')) excluding the initial " b' ". If you are 
;;  using the Docker container, you may need to use the clipboard (found
;;  on the left panel) first to transfer your local copied string over.

.orig x3000
    ;; You do not need to write anything here
    HALT

;;  INSERTION_SORT **RESURSIVE** Pseudocode (see PDF for explanation and examples)
;; 
;;  INSERTION_SORT(int[] arr (addr), int length) {
;;      if (length <= 1) {
;;        return;
;;      }
;;  
;;      INSERTION_SORT(arr, length - 1);
;;  
;;      int last_element = arr[length - 1];
;;      int n = length - 2;
;;  
;;      while (n >= 0 && arr[n] > last_element) {
;;          arr[n + 1] = arr[n];
;;          n--;
;;      }
;;  
;;      arr[n + 1] = last_element;
;;  }

INSERTION_SORT ;; Do not change this label! Treat this as like the name of the function in a function header
    ;; Code your implementation for the INSERTION_SORT subroutine here!
    ;; NOTE: Your implementation MUST be done recursively
    
    ;; --- buildup stackframe ---
    ADD	R6, R6, -4 ; push 4 wds, set rv later
	STR	R7, R6, 2  ; save RA
	STR	R5, R6, 1  ; save old FP, set local var later
	ADD	R5, R6, 0  ; FP = SP
	ADD	R6, R6, -5 ; push 5 words	
	STR	R0, R5, -1 ; save SR1
	STR	R1, R5, -2 ; save SR2
	STR	R2, R5, -3 ; save SR3
	STR	R3, R5, -4 ; save SR4
	STR	R4, R5, -5 ; save SR5

    ;; --- insertion logic ---

    LDR R0, R5, 4 ; arr
    LDR R1, R5, 5 ; length (sets cc)
    ADD R2, R1, -1 ; length - 1
    BRnz END ; return if length <= 1
    
    ADD R6, R6, -1 ; push arg
    ADD R2, R1, -1 ; length - 1
    STR R2, R6, 0 ; second param
    ADD R6, R6, -1 ; push arg
    STR R0, R6, 0 ; first param
    
    JSR INSERTION_SORT

    ADD R3, R0, R2 ; access element [length - 1]
    LDR R3, R3, 0 ; last_element = arr[length - 1]

    WHILE 
        ADD R2, R2, -1; n -= 1
        BRn END_WHILE ; break when < 0

        NOT R1, R3 ; - last element (pt 1)
        ADD R1, R1, 1 ; - last element
        ADD R4, R0, R2 ; access element
        LDR R4, R4, 0 ; arr[n]
        ADD R4, R4, R1 ; check arr[n] > last_element
        BRnz END_WHILE ; break when arr[n] - last_element <= 0

        ADD R1, R2, 1 ; n + 1
        ADD R1, R0, R1 ; arr[n + 1]
        ADD R4, R0, R2 ; arr[n]
        LDR R4, R4, 0 ; arr[n]
        STR R4, R1, 0 ; arr[n + 1] = arr[n]
        BR WHILE ; loop

    END_WHILE
        LDR R4, R5, 5 ; R5 <- length
        ADD R2, R2, 1 ; n + 1
        ADD R2, R0, R2 ; access element
        STR R3, R2, 0 ; arr[n + 1] = last element
    
    END

    ;; --- tearing stackframe ---
    LDR	R4, R5, -5	; restore R4
	LDR	R3, R5, -4	; restore R3
	LDR	R2, R5, -3	; restore R2
	LDR	R1, R5, -2	; restore R1
	LDR	R0, R5, -1	; restore R0
	ADD	R6, R5, 0  	; pop saved regs and local vars
	LDR	R7, R5, 2	; R7 = ret addr
	LDR	R5, R5, 1	; FP = Old FP
	ADD	R6, R6, 3 	; pop 3 words
    RET

;; Needed to Simulate Subroutine Call in Complx
STACK .fill xF000
.end

.orig x4000	;; Array : You can change these values for debugging!
    .fill 2
    .fill 3
    .fill 1
    .fill 1
    .fill 6
.end