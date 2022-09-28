# 2.8 Subspaces

## Subspace
A subspace of $\R^n$ is any set $H$ in $\R^n$ that has these 3 properties:
- The zero vector is in $H$.
- For each $u$ and $v$ in $H$, the sum $u + v$ is in $H$
- For each $u$ in $H$ and each scalar $c$, the vector $cu$ is in $H$


Given an $m \times n$ matrix $A = [\vec{a_1}, ..., \vec{a_n}]$
1. Th column space of $A$,  Col $A$, is the subspace of $\R^m$ spanned by $\vec{a_1}, ...,\vec{a_n}$
2. Th null space of $A$, Null $A$ , is the subspace of $\R^n$ spanned by the set of all vectors $\vec{x}$ that sovle $A\vec{x}=\vec{0}$

## Example 2

\vec{x} = 
-5\lambda
-3\lambda
\lambda

\lambda \in \R

A =
1 -3 -4
-4 6 -2
-3 7 6

Null(A) = {\vec{x}: A\vec{x}=\vec{0}}

A\vec{v} = \vec{0}

-5\lambda + 9\lambda -4\lambda
20\lambda - 18\lambda -2\lambda
15\lambda - 21\lambda + 6\lambda

=

0
0
0


## Basis
A basis for a subspace $H$ is a set of linearly independent vectors in $H$ that span $H$.


The set $H =
x1
x2
x3
x4
\in \R^4

x1 + x2 + x3 + 5x4 = 0

H is a nullspace for what matrix A
A = 1 2 1 5

Construct a basis for H

free = x2 , x3, x4

x = 
x_2 (
    -2
    1
    0
    0
)

x_3 (
    -1
    0
    1
    0
)
x_4 (
    -5
    0
    0
    1
)


Def of basis: LI, spanning st
Basis Null (A)  {vectors from param vctor form of solution to Ax = 0)}
Basis Col (A) = {pivot cols of A    }