;;=======================================
;; CS 2110 - Spring 2023
;; Final Exam - GCD
;;=======================================
;; Name:
;;=======================================
;; For the LC-3 Assembly part, you must implement the GCD subroutine.
;; We've pre-implemented a helper subroutine MOD for you to use.
;; See the PDF for more detailed instructions.

;; GCD
;; Arguments
;;     a - Integer
;;     b - Integer
;; Returns
;;     GCD of a and b - Integer
;; Pseudocode
;; 
;;     gcd(a, b) {
;;         if (b == 0) {
;;             return a;
;;         }
;;         c = mod(a, b); // MOD subroutine has already been provided
;;         return gcd(b, c);
;;     }
;;
;; TODO - Complete the GCD subroutine!
.orig x3010
    GCD

        ;; YOUR CODE HERE
        
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

        ;; --- gcd logic ---
        LDR R0, R5, 4 ; R0 = a 
        LDR R1, R5, 5 ; R1 = b
        BRz BASECASE

        
        ADD R6, R6, -1 ; push arg
        STR R1, R6, 0 ; second param
        ADD R6, R6, -1 ; push arg
        STR R0, R6, 0 ; first param

        JSR MOD

        LDR R3, R6, 0 ; pop return vals
        ADD R6, R6, 1 ; pop return val
        ADD R6, R6, 2 ; pop args

        
        ADD R6, R6, -1 ; push arg
        STR R3, R6, 0 ; second param
        ADD R6, R6, -1 ; push arg
        STR R1, R6, 0 ; first param

        JSR GCD

        LDR R0, R6, 0 ; pop return vals
        ADD R6, R6, 1 ; pop return val
        ADD R6, R6, 2 ; pop args

        BR TEARDOWN

        BASECASE
        STR R0, R5, 3

        TEARDOWN
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
.end


;; PRE-IMPLEMENTED HELPER SUBROUTINE
;; MOD
;; Arguments
;;     a       - Integer
;;     modulus - Nonzero Integer
;; Returns
;;     a % modulus - Integer
;;
;; DO NOT MODIFY THIS SUBROUTINE
.orig x3100
    MOD
        ;; These are still LC-3 Assembly instructions! They are just encoded in hex. 
        ;; Treat this subroutine as a black box that you can use to help you code GCD.
        .fill x1DBC
        .fill x7F82
        .fill x7B81
        .fill x1BA0
        .fill x1DBB
        .fill x7180
        .fill x7381
        .fill x7582
        .fill x7783
        .fill x7984
        .fill x6345
        .fill x0602
        .fill x927F
        .fill x1261
        .fill x947F
        .fill x14A1
        .fill x6144
        .fill x0804
        .fill x1002
        .fill x07FE
        .fill x1001
        .fill x0E02
        .fill x1001
        .fill x09FE
        .fill x7143
        .fill x6180
        .fill x6381
        .fill x6582
        .fill x6783
        .fill x6984
        .fill x1D60
        .fill x6B81
        .fill x6F82
        .fill x1DA3
        .fill xC1C0
    RET
.end

;; We've preloaded the PDF's test case for you!
;; After pressing run in Complx, the RESULT label will contain your GCD subroutine's return value on inputs A and B.
;; To test other cases, feel free to change A and B to your liking.
;; You can also use Debug -> Simulate Subroutine Call and select the GCD label as usual. 
.orig x3000
    LD R6, STACK
    ADD R6, R6, #-2
    LD R0, A
    STR R0, R6, #0
    LD R0, B
    STR R0, R6, #1
    JSR GCD
    LDR R0, R6, #0
    ADD R6, R6, #3
    ST R0, RESULT
    HALT
    A .fill 56
    B .fill 36
    RESULT .blkw 1
    STACK .fill xF000
.end