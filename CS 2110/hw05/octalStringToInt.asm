;;=============================================================
;; CS 2110 - Spring 2023
;; Homework 5 - octalStringToInt
;;=============================================================
;; Name: 
;;=============================================================

;;  Pseudocode (see PDF for explanation)
;;  Pseudocode values are based on the labels' default values.
;;
;;  String octalString = "2110";
;;  int length = 4;
;;  int value = 0;
;;  int i = 0;
;;  while (i < length) {
;;      int leftShifts = 3;
;;      while (leftShifts > 0) {
;;          value += value;
;;          leftShifts--;
;;      }
;;      int digit = octalString[i] - 48;
;;      value += digit;
;;      i++;
;;  }
;;  mem[mem[RESULTADDR]] = value;

.orig x3000
    ;; YOUR CODE HERE
    LD R0, OCTALSTRING ;; int octalstring
    LD R1, LENGTH ;; int length = 4
    AND R2, R2, 0 ;; value
    AND R4, R4, 0 ;; i = 0
    ADD R1, R1, 0 ;; set cc
    WHILE1 BRz END1
    AND R3, R3, 0 ;; leftShifts = 0
    ADD R3, R3, 3 ;; leftShifts = 3
    WHILE2 BRz END2
    ADD R2, R2, R2 ;; value += value
    ADD R3, R3, -1 ;; leftShifts--
    BR WHILE2
    END2
    LDR R6, R0, 0
    LD R3, ASCII ;; store ascii
    ADD R6, R6, R3 ;; octalstring[i] - 48
    ADD R2, R2, R6 ;; value += digit
    ADD R0, R0, 1 ;; octalstring[i++]
    ADD R1, R1, -1 ;; length--
    BR WHILE1
    END1 
    LD R3, RESULTADDR
    STR R2, R3, 0
    HALT
    
;; Do not change these values! 
;; Notice we wrote some values in hex this time. Maybe those values should be treated as addresses?
ASCII           .fill -48
OCTALSTRING     .fill x5000
LENGTH          .fill 4
RESULTADDR      .fill x4000
.end

.orig x5000                    ;;  Don't change the .orig statement
    .stringz "2110"            ;;  You can change this string for debugging!
.end
