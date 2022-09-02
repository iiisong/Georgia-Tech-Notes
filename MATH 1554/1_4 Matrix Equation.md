# 1.4 Matrix Equation 8/29
## Another way to formulate linear systems

1.Equations  
    - Algebraic Stucture
    - 
2x_1 + 3x_2 = 7
x_1 - x_2 = 5

2. Augmented Matrix  
    - Algorithmic structure
2 3 | 7
1 -1 | 5

3. Vector equation
    - Geometric Structure

# 4th Representation: **Matrix Equation Formulation**
Taking a table and spitting a vector

Topics:
1. Matrix notation for system of equations
2. The matrix product Ax

## Notations
> $\in$ = belongs to
> $R^n$ = the set of vectors with $n$ real-valued elements
> $R^{m*n}$ - the set of real-valued matrices with $m$ rows and $n collumns

> > > > > insert onenote here

## Definition
Matrix Vector product $Ax$ is a linear combination of the columns of A

Col's of A as column vectos

$$Ax = 
\begin{pmatrix}
& 1 & 3 & 4& \\[0.4em]
& 2 & 8 & 4& \\[0.4em]
& 0 & 1 & -2& \\[0.4em]
\end{pmatrix}
$$

x1
x2
...
x4 

= x1a1 + xx2a2 + ... xnan


Note that $A\vec{x}$ is in the span of the columns of $A4

### Example
$$
\begin{bmatrix}
& 1 & 0 & -1& \\[0.4em]
& 0 & -3 & 3& \\[0.4em]
\end{bmatrix}
\begin{bmatrix}
4\\[0.4em]
3\\[0.4em]
7\\[0.4em]
\end{bmatrix}
= 
4(
1
0
)3 (
0 -3
)7 (
-1
3
)= (
4
0
)(
0
-9
)(
-7
21
)= (
-3
12
)
$$

### This is not defined
$$
\begin{bmatrix}
& 1 & 0 & 2 & 0 & 3& \\[0.4em]
& 0 & 1 & 0 & 2 & 0& \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
x_3\\[0.4em]
x_4\\[0.4em]
\end{bmatrix}
$$

> right vector has 4 elements while left matrix has 5 columns

### This is defined
$$
\begin{bmatrix}
& 1 & 0 & 2 & 0 & \\[0.4em]
& 0 & 1 & 0 & 2 & \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
x_3\\[0.4em]
x_4\\[0.4em]
\end{bmatrix}
=
\begin{bmatrix}
x_1+2x_3\\[0.4em]
x_2+2x_4\\[0.4em]
\end{bmatrix}
= 
\begin{pmatrix}
x_1+2x_3\\[0.4em]
x_2+2x_4\\[0.4em]
\end{pmatrix}
$$
> this is defined and has a solution

## Theorem 5 
> If $A$ is an $m x n$ matrix, $u$ and $v$ are vectors in $R^n$, and $c$ is a scalar, then:  
a. $A(u + v) = Au + Av$  
b. $A(cu) = c(Au)$

-  Matrix products distribute across vector addition

## Example
solutions to $$A\vec{x} = b$$ has the same set of solutions as the vector equation $$x_1\vec{a}_1+...+x_n\vec{a}_n = b$$

# Theorem
> The equation $Ax = b$ has a solution\* if and only if b is a linear combination of the columns of A\*\*.

\* Algebraic connotation  
\*\* Geometric connotation


### Example
Let $A = 
\begin{bmatrix}
& 2 & -1& \\[0.4em]
& -6 & 3& \\[0.4em]
\end{bmatrix}$
and $b = 
\begin{bmatrix}
b1\\[0.4em]
b2\\[0.4em]
\end{bmatrix}
$
. Show that the equation $Ax = b$ does not have a solution for all possible $b$, and describe the set of all $b$ for which $Ax = b$ *does* have a solution
$$
\begin{bmatrix}
& 2 & -1 & | & b_1& \\[0.4em]
& -6 & 3 & | & b_2& \\[0.4em]
\end{bmatrix}
$$

> (2) + 3(1)
$$
\begin{bmatrix}
& 2 & -1 & | & b_1& \\[0.4em]
& 0 & 0 & | & b_2 +  3b_1& \\[0.4em]
\end{bmatrix}
$$

> Inconsistent <-> pivot in last column  
> Consistent <-> pivot not in last column

if $b_2 + 3b_1 = 0$, system is consistent  
if $b_2+3b_1 \neq 0$, system is **not-consistent**

$b_2 + 3b_1 = 0$ is a line.  
**Span {$
\begin{pmatrix}
2\\[0.4em]
-6\\[0.4em]
\end{pmatrix}$, $
\begin{pmatrix}
-1\\[0.4em]
3\\[0.4em]
\end{pmatrix}$} is a line in this case**

### Simpler way to solve that problem
$
\begin{pmatrix}
2\\[0.4em]
-6\\[0.4em]
\end{pmatrix}
$ and $
\begin{pmatrix}
-1\\[0.4em]
3\\[0.4em]
\end{pmatrix}
$ is parallel vector

Span therefore has to be a line

## Example 2
for what vectors b =
$\begin{pmatrix}
b_1\\[0.4em]
b_2\\[0.4em]
b_3\\[0.4em]
\end{pmatrix}$ does the equation have a solution

$$
\begin{pmatrix}
& 1 & 3 & 4& \\[0.4em]
& 2 & 8 & 4& \\[0.4em]
& 0 & 1 & -2& \\[0.4em]
\end{pmatrix} x = b
$$

$$
\begin{bmatrix}
& 1 & 3 & 4 & | & b_1& \\[0.4em]
& 2 & 8 & 4 & | & b_2& \\[0.4em]
& 0 & 1 & -2 & | & b_3& \\[0.4em]
\end{bmatrix}
$$

> (2) - 2(1)
$$
\begin{bmatrix}
& 1 & 3 & 4 & | & b_1& \\[0.4em]
& 0 & 2 & -4 & | & b_2 - 2b_1 & \\[0.4em]
& 0 & 1 & -2 & | & b_3& \\[0.4em]
\end{bmatrix}
$$

> (3) - 1/2(2)
$$
\begin{bmatrix}
& 1 & 3 & 4 & | & b_1& \\[0.4em]
& 0 & 2 & -4 & | & b_2 - 2b_1 & \\[0.4em]
& 0 & 0 & 0 & | & b_3 + b_1 - .5b_2 & \\[0.4em]
\end{bmatrix}
$$

> Consistent if $\quad  b_1 - .5b_2 + b_3 = 0$  
> Inconsistent if $\quad  b_1 - .5b_2 + b_3 \neq 0$

**The solution is a plane if consistent**

Think of $\quad  b_1 - .5b_2 + b_3 = 0\quad$ as a linear system of 1 equation.

$$
\begin{bmatrix}
& 1 & -.5 & 1 & 0 & \\[0.4em]
\end{bmatrix}
$$

Only one possible pivot and 2 free variables, therefore it can only be a plane.

## Review

### **Theorem 4**
> Let $A$ be an $mxn$ matrix. Then the following statements are logically equivalent. That is, for a particular $A$, **either they are all true statements or they are all false**.  
> 
> a. For each **b** in $R^m$, the equation $Ax = b$ has a solution.  
b. Each **b** in $R^m$ is a linear combination of the columns of $A$
c. The columns of $A$ span $R^m$  
d. *A* has a pivot position in every row.

## **Pivots in every row of reduced row eschelon form of A prevents pivots in B.**
<br>

u = RREF(A)

 RREF(A | b) = (u | c)


<br>
<br>
<br>

# Recitation
Set of vectors represent every possibile linear combination of the vectors.

Check whether a vector in a span of a set of vector by checking augmented matrix.



