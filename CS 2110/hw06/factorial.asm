;;=============================================================
;;  CS 2110 - Spring 2023
;;  Homework 6 - Factorial
;;=============================================================
;;  Name: Isaac Song
;;============================================================

;;  In this file, you must implement the 'MULTIPLY' and 'FACTORIAL' subroutines.

;;  Little reminder from your friendly neighborhood 2110 TA staff: don't run
;;  this directly by pressing 'Run' in complx, since there is nothing put at
;;  address x3000. Instead, call the subroutine by doing the following steps:
;;      * 'Debug' -> 'Simulate Subroutine Call'
;;      * Call the subroutine at the 'MULTIPLY' or 'FACTORIAL' labels
;;      * Add the [a, b] or [n] params separated by a comma (,) 
;;        (e.g. 3, 5 for 'MULTIPLY' or 6 for 'FACTORIAL')
;;      * Proceed to run, step, add breakpoints, etc.
;;      * Remember R6 should point at the return value after a subroutine
;;        returns. So if you run the program and then go to 
;;        'View' -> 'Goto Address' -> 'R6 Value', you should find your result
;;        from the subroutine there (e.g. 3 * 5 = 15 or 6! = 720)

;;  If you would like to setup a replay string (trace an autograder error),
;;  go to 'Test' -> 'Setup Replay String' -> paste the string (everything
;;  between the apostrophes (')) excluding the initial " b' ". If you are 
;;  using the Docker container, you may need to use the clipboard (found
;;  on the left panel) first to transfer your local copied string over.

.orig x3000
    ;; You do not need to write anything here
    HALT

;;  MULTIPLY Pseudocode (see PDF for explanation and examples)   
;;  
;;  MULTIPLY(int a, int b) {
;;      int ret = 0;
;;      while (b > 0) {
;;          ret += a;
;;          b--;
;;      }
;;      return ret;
;;  }

MULTIPLY ;; Do not change this label! Treat this as like the name of the function in a function header
    ;; Code your implementation for the MULTIPLY subroutine here!

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

    ;; --- mult logic ---

    AND R0, R0, 0 ; ret = 0
    STR R0, R5, 0 ; answer = R0 = 0

    W1 
        ; load a and test for nonpositive for break
        LDR R0, R5, 4 ; R0 = a = counter
        Brnz END_W1 ; break loop when counter non-positive

        ; answer += b
        LDR R0, R5, 0 ; R0 = answer
        LDR R1, R5, 5 ;  R1 = b
        ADD R0, R0, R1 ; R0 = answer + b
        STR R0, R5, 0 ; answer = r0 = answer + b = answer += b

        ; decrement a by 1
        LDR R0, R5, 4 ; R0 = a
        ADD R0, R0, -1 ; a -= 1
        STR R0, R5, 4 ; R0 = a = old_R0 - 1
        BR W1 ; continue loop

    END_W1
        ; transfer result from local variable to reserved return memory location(R5 + 3)
        LDR R0, R5, 0
        STR R0, R5, 3

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

;;  FACTORIAL Pseudocode (see PDF for explanation and examples)
;;
;;  FACTORIAL(int n) {
;;      int ret = 1;
;;      for (int x = 2; x <= n; x++) {
;;          ret = MULTIPLY(ret, x);
;;      }
;;      return ret;
;;  }

FACTORIAL ;; Do not change this label! Treat this as like the name of the function in a function header
    ;; Code your implementation for the FACTORIAL subroutine here!

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

    ;; --- factorial logic ---
    
    AND R0, R0, 0 ; clear R0 for ret
    ADD R0, R0, 1 ; R0 = 1
    STR R0, R5, 0 ; 1 in return val

    AND R1, R1, 0 ; clear R1 for x
    ADD R1, R1, 2 ; R1 = 2

    LDR R2, R5, 4 ; get value of n
    NOT R2, R2 ; -n (step 1)
    ADD R2, R2, 1 ; -n (step 2)

    FOR_FACT ; loop if x <= n (x - n <= 0 or x - n !> 0)
        ADD R3, R1, R2 ; x - n
        BRp END_FACT; x - n > 0

        ADD R6, R6, -1 ; push arg
        STR R1, R6, 0 ; second param
        ADD R6, R6, -1 ; push arg
        LDR R0, R5, 0 ; retrieve ret
        STR R0, R6, 0 ; first param
        
        JSR MULTIPLY

        LDR R0, R6, 0 ; pop return vals
        ADD R6, R6, 1 ; pop return val
        ADD R6, R6, 2 ; pop args

        STR R0, R5, 0 ; store product back in local variable
        ADD R1, R1, 1 ; x ++
    
        BR FOR_FACT

    END_FACT
        LDR R0, R5, 0 ; retrieve local variable result
        STR R0, R5, 3 ; put in reserved result location


    
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