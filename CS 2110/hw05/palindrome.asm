;;=============================================================
;; CS 2110 - Spring 2023
;; Homework 5 - palindrome
;;=============================================================
;; Name: 
;;=============================================================

;;  NOTE: Let's decide to represent "true" as a 1 in memory and "false" as a 0 in memory.
;;
;;  Pseudocode (see PDF for explanation)
;;  Pseudocode values are based on the labels' default values.
;;
;;  String str = "aibohphobia";
;;  boolean isPalindrome = true
;;  int length = 0;
;;  while (str[length] != '\0') {
;;		length++;
;;	}
;; 	
;;	int left = 0
;;  int right = length - 1
;;  while(left < right) {
;;		if (str[left] != str[right]) {
;;			isPalindrome = false;
;;			break;
;;		}
;;		left++;
;;		right--;
;;	}
;;	mem[mem[ANSWERADDR]] = isPalindrome;

.orig x3000
	;; YOUR CODE HERE
	LD R0, STRING ;; str = string
	AND R1, R1, 0 ;; isPalindrome = false
	ADD R1, R1, 1 ;; isPalindrome = true
	AND R3, R3, 0 ;; lenght = 0
	LDR R2, R0, 0 ;; str[length]
	WHILE1 BRz END1 ;; str[length] != 0
	ADD R0, R0, 1 ;; length++
	ADD R3, R3, 1 ;;
	LDR R2, R0, 0 ;; str[length]
	BR WHILE1
	END1

	LD R0, STRING
	AND R2, R2, 0 ;; left = 0
	ADD R3, R3, -1 ;; right = length - 1
	NOT R4, R3 ;; right = -length 
	ADD R4, R4, 1 ;; right = - (length - 1)
	ADD R4, R2, R4 ;; left - right
	WHILE2 BRp END2 ;; left < right
	ADD R5, R0, R2
	LDR R5, R5, 0 ;; str[left]
	ADD R6, R0, R3
	LDR R6, R6, 0 ;; str[right]
	NOT R6, R6 ;; negate str[right]
	ADD R6, R6, 1
	ADD R6, R5, R6 ;; str[left] - str[right] set cc
	BRz ELSE1
	AND R1, R1, 0
	BR END2
	ELSE1
	ADD R2, R2, 1
	ADD R3, R3, -1
	NOT R4, R3 ;; right = -length 
	ADD R4, R4, 1 ;; right = - (length - 1)
	ADD R4, R2, R4 ;; left - right
	BR WHILE2
	END2 
	LD R2, ANSWERADDR 
	STR R1, R2, 0




	HALT

;; Do not change these values!
STRING	.fill x4004
ANSWERADDR 	.fill x5005
.end

;; Do not change any of the .orig lines!
.orig x4004				   
	.stringz "toast" ;; Feel free to change this string for debugging.
.end

.orig x5005
	ANSWER  .blkw 1
.end