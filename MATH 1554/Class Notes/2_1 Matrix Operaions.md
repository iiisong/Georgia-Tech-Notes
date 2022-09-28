# Section 2.1 Matrix Operations
Identity and zero matrices
Matrix Algebra (sums and products, scalar multiples, matrix powers)
Transpose of the matrix

## Definitions
### Zero Matrix
> A zero matrix is any matrix whose every entry is 0

### Identity Matrix
> The n x n identity matrix has ones on the main diagonal, otherwise all zeros. Square matrix

Identity Matrix must be square, doesn't mean zero


---
Suppose $A\in\R^{m\times n}$, and $A_{ij}$ is the element of $A$ in row $i$ and column $j$

1. If $A$ and $B$ are $m \times n$ matricies, then the elements of $A + B$ are $a_{i,j} + b_{i,j}$. "Component-wise addition"
2. If $c\in\R$, then the elements of $cA$ are $ca_{i,j}$ "Component-wise scaling"

For example, if 
$$
\begin{bmatrix}
& 1 & 2 & 3 & \\[0.4em]
& 4 & 5 & 6 & \\[0.4em]
\end{bmatrix}
+
c
\begin{bmatrix}
& 7 & 4 & 7 & \\[0.4em]
& 0 & 0 & k & \\[0.4em]
\end{bmatrix}
=
\begin{bmatrix}
& 15 & 10 & 17 & \\[0.4em]
& 4 & 5 & 16 & \\[0.4em]
\end{bmatrix}
$$
$$
c
\begin{bmatrix}
& 7 & 4 & 7 & \\[0.4em]
& 0 & 0 & k & \\[0.4em]
\end{bmatrix}
=
\begin{bmatrix}
& 14 & 8 & 14 & \\[0.4em]
& 0 & 0 & 10 & \\[0.4em]
\end{bmatrix}
$$
$$
c = 
\begin{bmatrix}
& 2 & 2 & 2 & \\[0.4em]
& 0 & 0 & \frac{10}{k} & \\[0.4em]
\end{bmatrix}
$$

---
## MAtrix Multiplication
> Let $A$ be a $m\times n$ matrix, and $B$ be a $n \times p $ matrix. The product is $AB$ a $m \times p$ matrix, equal to 
$$ AB = A \begin{bmatrix}
& \vec{b_1} & ... & \vec{b_p} & \\[0.4em]
\end{bmatrix} = \begin{bmatrix}
& A\vec{b_1}... & A\vec{b_p} & \\[0.4em]
\end{bmatrix}$$

Note, the dimensions of A and B determine whether AB is defined, and what its dimensions will be

\# col's of A  = \# row's of B

If not, say AB is UNDEFINED


### Row Column Method
> If $A\in R^{m\times n}$  has rows $\vec{d_i}$, and $B \in R^{n\times p } $ has columns $\vec{b_3}$, each element of product $C =AB$ is $c_i,j$ is $c_{i, j} = \vec{a_2} *\vec{b_j}*$

Let A, B, C be matrices of the size  neeed fort  the mitrix mulitplication
1. Associative $a(AB)(C) = A(BC)$
2. Left Distributive$ A(B+C) = AB + AC$
3. Right Distributive (B+C)A = BA + CA$

**Warnings**
1. Non-commnutative, $AB\neq BA$
2. Non-cancellation$AB = AC $ does nt $\nga4
3. Zero ddevisors

---
### Example

Give an exmaple of a 2x2 matrix B that is non-commutative with A
$$
A = 
\begin{bmatrix}
& 1 & 1 & \\[0.4em]
& 0 & 0 & \\[0.4em]
\end{bmatrix}

B = 
\begin{bmatrix}
& a & b & \\[0.4em]
& c & d & \\[0.4em]
\end{bmatrix}
$$
$$
AB =
\begin{bmatrix}
& 1 & 1 & \\[0.4em]
& 0 & 0 & \\[0.4em]
\end{bmatrix}
\begin{bmatrix}
& a & b & \\[0.4em]
& c & d & \\[0.4em]
\end{bmatrix}=
\begin{bmatrix}
& a+c & b+d & \\[0.4em]
& 0 & 0 & \\[0.4em]
\end{bmatrix}$$
$$
BA =

\begin{bmatrix}
& a & b & \\[0.4em]
& c & d & \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
& 1 & 1 & \\[0.4em]
& 0 & 0 & \\[0.4em]
\end{bmatrix}
=
\begin{bmatrix}
& a & a & \\[0.4em]
& c & c & \\[0.4em]
\end{bmatrix}
$$
$$
\begin{bmatrix}
& a+c & b+d & \\[0.4em]
& 0 & 0 & \\[0.4em]
\end{bmatrix} \neq 
\begin{bmatrix}
& a & a & \\[0.4em]
& c & c & \\[0.4em]
\end{bmatrix} $$
$$
$$
$$AB \neq BA $$

---

## The Transpose of a Matrix

$A^T$ is the matrix whose columns are the rows of $A$.

$A^T
\begin{bmatrix}
& 1 & 2 & 3 & 4 & 5 & \\[0.4em]
& 0 & 1 & 0 & 2 & 0 & \\[0.4em]
\end{bmatrix}=
\begin{bmatrix}
& 1 & 0 & \\[0.4em]
& 2 & 1 & \\[0.4em]
& 3 & 5 & \\[0.4em]
& 4 & 2 & \\[0.4em]
& 5 & 0 & \\[0.4em]
\end{bmatrix}
$

${(A^T)}^T = A$  
${(A+B)}^T = A^T + B^T$  
${(rA)}^T = rA^T$  
${(AB)}^T = B^TA^T$

## Matrix Powers
For any $n \times n$ matrix and positive integer $k$, $A^k$ is the product of $k$ copies of $A$

$$ A^k = AA...A$$

Compute $C^8$
$$ C = 
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 2 & 0 & \\[0.4em]
& 0 & 0 & 2 & \\[0.4em]
\end{bmatrix}$$

$$
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 2 & 0 & \\[0.4em]
& 0 & 0 & 2 & \\[0.4em]
\end{bmatrix}
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 2 & 0 & \\[0.4em]
& 0 & 0 & 2 & \\[0.4em]
\end{bmatrix} = 
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 4 & 0 & \\[0.4em]
& 0 & 0 & 4 & \\[0.4em]
\end{bmatrix}$$

$$
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 2 & 0 & \\[0.4em]
& 0 & 0 & 2 & \\[0.4em]
\end{bmatrix}^8 =  
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 2^8 & 0 & \\[0.4em]
& 0 & 0 & 2^8 & \\[0.4em]
\end{bmatrix}
=
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 256 & 0 & \\[0.4em]
& 0 & 0 & 256 & \\[0.4em]
\end{bmatrix}$$

### Example
Define