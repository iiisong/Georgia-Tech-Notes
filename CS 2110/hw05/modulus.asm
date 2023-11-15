;;=============================================================
;; CS 2110 - Spring 2023
;; Homework 5 - modulus
;;=============================================================
;; Name: 
;;=============================================================

;;  Pseudocode (see PDF for explanation)
;;  Pseudocode values are based on the labels' default values.
;;
;;  int x = 17;
;;  int mod = 5;
;;  while (x >= mod) {
;;      x -= mod;
;;  }
;;  mem[ANSWER] = x;

.orig x3000
    ;; YOUR CODE HERE
    LD R1, MOD
    LD R0, X

    WHILE BRn END
    NOT R2, R1
    ADD R2, R2, 1
    ADD R0, R0, R2
    BR WHILE
    END
    ADD R0, R0, R1
    ST R0, ANSWER

    HALT

    ;; Feel free to change the below values for debugging. We will vary these values when testing your code.
    X      .fill 17 
    MOD    .fill 5     
    ANSWER .blkw 1
.end