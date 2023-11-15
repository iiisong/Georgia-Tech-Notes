## Theorems

Let $A$ be a square matrix
1. If a multiple of a row of $A$ is added to anohter row to produce $B$, then det $B=$ det $A$
2. If two rows are interchanged to produced $B$, then det $B = -$ det $A$
3. If one row of $A$ is multiplied by a scalar $k$ to produce $B$, then det $B = k$ det $A$


1 -4 2
-2 8 -9
-1 7 0

det A

1 -4 2
0 0 -5
0 -3 2

det B = det A

1 -4 2
0 -3 2
0 0 -5

det B = -det A

det B = -15

det A = 15


A ~~ B using just row swaps + adding row to another

det A = (-1)^r * det B  

(r = number of row swaps)



5 * *
0 -1 3
0 0 2



0 1 2 -1
2 5 -8 3
0 3 6 2
-2 -5 4 2

det B = -detA

2 5 -7 3
0 1 2 -1
0 3 6 2
-2 -5 4 2

2 5 -7 3
0 1 2 -1
0 0 0 -1
0 0 -4 5

det B = -det A

2 5 -8 3
0 1 2 -1
0 0 -4 5
0 0 0 5

det B = det A

det B = -30

# Properties
For any square matrices $A$ and $B$, we can show the following
1. det $A =$ det $A^T$
2. $A$ is invertible if and only if det $A\neq0$.
3. det($AB$) = det $A -$ det $B$


A ~ B by 2 -> 2 + 3(1)

B = E* A
det E = 1

Row swap: det = -1
Scalig  det = k
