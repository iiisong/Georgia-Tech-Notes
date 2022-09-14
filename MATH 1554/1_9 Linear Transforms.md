# Section 1.9 Linear Transforms

The **standard vectors** in $\R^n$ are the vectors $\vec{e_1}, \vec{e_2}, ...\vec{e_n}$ where 
$\vec{e_1} =
\begin{pmatrix}
1\\[0.4em]
0\\[0.4em]
\vdots\\[0.4em]
0\\[0.4em]
\end{pmatrix}$
...

For example, in $\R^3$,
$\vec{e_1} = 
\begin{bmatrix}
1\\[0.4em]
0\\[0.4em]
0\\[0.4em]
\end{bmatrix}$




if A is an m x n matrix with colums $v_1, v_2, ..., v_n$ then $Ae_i = v_i$ for $i = 1,2,..., n$

So multiplying a matrix by $e_1$ gives column i of $$A
\begin{bmatrix}
& 1 & 2 & 3 & \\[0.4em]
& 4 & 5 & 6 & \\[0.4em]
& 7 & 8 & 9 & \\[0.4em]
\end{bmatrix}$$
e2
$$
\begin{bmatrix}
& 1 & 2 & 3 & \\[0.4em]
& 4 & 5 & 6 & \\[0.4em]
& 7 & 8 & 9 & \\[0.4em]
\end{bmatrix}
$$
$$
\begin{bmatrix}
0\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{bmatrix}\= \87gbegin{bmatrix}
2\\[0.4em]
5\\[0.4em]
8\\[0.4em]
\end{bmatrix}
$$

[Extracting second column]

## Theorem
> Let $T : \R^n\rightarrow\R^m$ be a linear transformation. Then there is a unique matrix $A$ such that $$T(\vec{x}) = A\vec{x}, \quad\vec{x}\in\R^n$$

### Example 4
A linear transformation $T: \R^\rightarrow\R^3$ satisfies
T(
    1
    0
)

[
    5
    -7
    2
]

T(
    0
    1
)
[
    -3
    8
    0
]

What is the matrix that represent $T$?
A = [Te1 Te2]
5 -3
-7 8
2 0

## Rotations
### Example 1
What is the linear transform $T:\R^2\rightarrow\R^2$ defined by $T(\vec{x})=\vec{x}$ rotated counterclockwise by angle $\theta$?

$$T(\vec{x}) = A\vec{x}$$
$$A = [T(e_1) T(e_2)]$$

$$T(\vec{e_1}) = 
cos(\theta)
sin(\theta)
$$

$$T(\vec{e_2}) = 
-sin(\theta)
cos(\theta)
$$

$$A =
cos(\theta) -sin(\theta)
sin(\theta) cos(\theta)
$$



## One-to One
> A lienar transformation $T:\R^n\rightarrow\R^m$ is **one-to-one** if for all $\vec{b}\in\R^m$ there is at most one (possibly no $\vec{x}\in\R^n$ so  that $T(\vec{x})=\vec{b}$.

One to on is a uniqueness property, it does not assert exxistence for all $\vec{b}$.

Cares bout uniqueness not consistency

Useful facts
- $T$ is one-to-one if and only if the only solution to $T\vec{x}=0$ is the zero vector, $\vec{x}=\vec{0}$.
- $T$ is one-to-one if and only if the standard matrix $A$ of $T$ has no free variables
    - $A$ has to have a pivot in every column

## Onto
> A linear transformation  $T: \R^n\rightarrow\R^m$ is **onto** if for all $\vec{b}\in\R^m$ there is a $\vec{x}\in\R^n$ so that $T(\vec{x})=\vec{b}$

Onto is an **existence property**: for any $\vec{b}\in\R^3$, Ax=b has a solution.

Can have at most 2 pivots



