# 2.2 Inverse Matrices

> $A \in \R^{n\times m}$ is **invertiblee ( or **non-singular) if there is a  $C \in \R^{n\times m}$ so that  $$AC = CA = I_n$$
If there is, we write C = $A^{-1}$

The thing you multiply the matrix by to get the identity matrix

### Formula

The $2 \times 2$ matrix 
a b 
c d

is non-singular if and only if $ad-bc\neq 0$, and then 
$$
\begin{bmatrix}
& a & b & \\
& c & d & \\
\end{bmatrix}^{-1}

=
\frac{1}{ad-bc}
\begin{bmatrix}
& -d & -b & \\
& c & a & \\
\end{bmatrix}$$

### Example
State the inverse of the matrix below
$$
\begin{bmatrix}
& 2 & 5 & \\
& -3 & -7 & \\
\end{bmatrix}^{-1}
=
\frac{1}{2(-7)-5(-3)}
\begin{bmatrix}
& -7 & -5 & \\
& 3 & 2 & \\
\end{bmatrix}
=
\begin{bmatrix}
& -7 & -5 & \\
& 3 & 2 & \\
\end{bmatrix}
*
2 5
-3 -7

$$

$A \in \R^{n\times n}$ 




A and B are invertible mxn matricies
(A^-1)^-1 = A
(AB)^-1 = B^-1A^-1
(A^T)^-1 = (A^-1)^T


(ABC)^-1 = C^-1B^-1A^-1
(ABC)(C^-1B^-1A^-1)= I?

ABCC^-1B^-1A^-1

ABIB^-1A^-1

ABB^-1A^-1

AIA^-1

AA^-1

I



[A | I] -> [I | A^-1]


1 1 1 | 1 0 0
1 1 1 | 0 1 0
1 1 1 | 0 0 1

no way to row reduce 1 1 1 to identity matrix
have to be one-to-one and onto to have inverse

A ~ ... ~ I <-> A has an inverse

Elementary Matrices
An elementary matrix, $E$, is one that differs by $I_n$ by one row operation. Recall our elementary row operations.
1. swap rows
2. multiply a row by a non-zero scalar
3. add a multiple of one row to another
We can represent each operation by a matrix multiplication with an **elementary matrix**

E=
0 1
1 0
A=
a b
c d

EA
c d
a b



E =
1 0
0 3

A = 
a b
c d

EA
a b
3c 3d


E=
1 2 
0 1

A = 
a  b
c d

EA =
a+2c b+2d
c d

[A|I] ~ ... ~ [I|A^-1]
A = I

(E_4E_3E_2E_1)A = I
(A^-1)A = I

(E_4E_3E_2E_1)I = A^-1
A^-1 I


Matrix A is invertible if andd only if it is row equivalent to the identity. In thi case, the any sequence of elementary row operations that transforms A into I, applied to I, generates A^-1



Using the Inverse to Solve a Linear System

A | b ~ .... ~ I|A^-1

Ax = b
x = A^-1 * b

With same A but many b's, a single A^-1 can find a bunch of x's given a b


