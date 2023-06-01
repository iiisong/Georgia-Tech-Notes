;;
;; Recursive Sum
;;
;; At the end, R0 is loaded with the answer


.orig x3000

		LD R0, n

		; SAVE ARG ON STACK

		ADD R6, R6, -1
		STR R0, R6, 0

		JSR RECURSIVE_SUM

		LDR R0, R6, 0
		ADD R6, R6, 1


HALT

n .fill 5
.end





.orig x3050

RECURSIVE_SUM

	; Stack set up

	; Space for RV
	ADD R6, R6, -1

	; Push Return Address
	ADD R6, R6, -1
	STR R7, R6, 0

	; Save old frame pointer	
	ADD R6, R6, -1
	STR R5, R6, 0

	;Make space for first locals
	ADD R6, R6, -1

	; Stack and frame pointer point to first local
	; fp = sp
	ADD R5, R6, 0

	; Save space for locals


	; Save registers
	 ADD R6, R6, -3
	 STR R0, R6, 0
	 STR R1, R6, 1
	 STR R2, R6, 2


	; --------------------------------
	; ------ Do subroutine Stuff -----
	; --------------------------------

	; Load n
	LDR R0, R5, 4

	; if n == 1, return 1
	ADD R1, R0, -1

	BRnz BASECASE

	; n > 1
	
	; Make recursive call
	; We are now the callee

	; Push arguments
	ADD R6, R6, -1
	ADD R1, R0, -1
	STR R1, R6, 0

	JSR RECURSIVE_SUM

	; Pop return value
	LDR R1, R6, 0
	ADD R6, R6, 1

	; Pop arguments
	ADD R6, R6, 1

	ADD R1, R1, R0

	STR R1, R5, 3

	BR TEARDOWN



BASECASE
	
	AND R2, R2, 0
	ADD R2, R2, 1
	STR R2, R5, 3

TEARDOWN
	; Stack tear-down

	; Restore regs

	 LDR R0, R6, 0
	 LDR R1, R6, 1
	 LDR R2, R6, 2
	 ADD R6, R6, 3


	LDR R5, R6, 1
	LDR R7, R6, 2
	ADD R6, R6, 3

	RET


.end