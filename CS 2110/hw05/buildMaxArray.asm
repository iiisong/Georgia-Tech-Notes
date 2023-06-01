;;=============================================================
;; CS 2110 - Spring 2023
;; Homework 5 - buildMaxArray
;;=============================================================
;; Name: 
;;=============================================================

;;  Pseudocode (see PDF for explanation)
;;  Pseudocode values are based on the labels' default values.
;;
;;	int A[] = {-2, 2, 1};
;;	int B[] = {1, 0, 3};
;;	int C[3];
;;	int length = 3;
;;
;;	int i = 0;
;;	while (i < length) {
;;		if (A[i] >= B[length - i - 1]) {
;;			C[i] = 1;
;;		}
;;		else {
;;			C[i] = 0;
;;		}
;;		i++;
;;	}

.orig x3000
	;; YOUR CODE HERE
	LD R0, A ;; int A[] = {-2, 2, 1};
	LD R1, B ;; int B[] = {1, 0, 3};
	LD R2, C ;;	int C[3];
	AND R3, R3, 0 ;; i = 0;
	LD R4, LENGTH ;; length
	WHILE BRz END ;; length > 0
	ADD R5, R0, R3 ;; A[i] addy
	LDR R5, R5, 0 ;; retrieve A[i] val
	ADD R6, R4, -1 ;; length - i - 1
	ADD R6, R6, R1 ;; A[length - i - 1] addy
	LDR R6, R6, 0 ;; retrieve A[length -i - 1] val
	NOT R6, R6 ;; negate for comp
	ADD R6, R6, 1 ;; negate
	ADD R5, R5, R6 ;; subraction
	BRn ELSE ;; if (A[i] >= B[length - i - 1]) {
	ADD R7, R2, R3 ;; add
	AND R5, R5, 0 ;; clear r5
	ADD R5, R5, 1 ;; add val in r5
	STR R5, R7, 0 ;; store val
	BR ELSE2 ;; else {
	ELSE
	ADD R7, R2, R3 ;; add
	AND R5, R5, 0 ;; clear r5
	STR R5, R7, 0 ;; store val in r5
	BR ELSE2 ;; }
	ELSE2 ;; }
	ADD R3, R3, 1 ;; i++
	ADD R4, R4, -1 ;; length --
	BR WHILE ;; }
	END
	HALT

;; Do not change these addresses! 
;; We populate A and B and reserve space for C at these specific addresses in the orig statements below.
A 		.fill x3200		
B 		.fill x3300		
C 		.fill x3400		
LENGTH 	.fill 3			;; Change this value if you decide to increase the size of the arrays below.
.end

;; Do not change any of the .orig lines!
;; If you decide to add more values for debugging, make sure to adjust LENGTH and .blkw 3 accordingly.
.orig x3200				;; Array A : Feel free to change or add values for debugging.
	.fill -2
	.fill 2
	.fill 1
.end

.orig x3300				;; Array B : Feel free change or add values for debugging.
	.fill 1
	.fill 0
	.fill 3
.end

.orig x3400
	.blkw 3				;; Array C: Make sure to increase block size if you've added more values to Arrays A and B!
.end