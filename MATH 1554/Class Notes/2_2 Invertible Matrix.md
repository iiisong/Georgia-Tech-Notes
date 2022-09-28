# Section 2.2 Invertibility
When is a square matrix invertible?

### Theorem
Let $A$ be an $n \times n$ matrix. These statements are all equivalent

1. $A$ is invertible
2. $A$ is row equivalent to $I_n$
    - The RREF of A is the identity
3. $A$ has $n$ pivotal columns. (All columns are pivotal)
    - cool because can read pivots off of echelo form!
4. $A\vec{x}=\vec{0}$ has only the trivial solution
5. The columns of $A$ are linearly independent
    - Vector equation form for invertabilitty
    - has to deal with domain
    - interesting combination with (8)
6. The linear transformation $\vec{x}\rightarrow A\vec{x}$ is one-to-one
    - Linear transformation perspective on invetibility is onto.
    - onto and one-to-one both in square 
7. The equation $A\vec{x}=\vec{b}$ has a solution for all $\vec{b} \in \R^n$.
8. The columns of $A$ span $\R^n$
    - has to do with codomain
    - square matrices with non-parallel vectors span $\R^2$ and is invertible and linearly independent
10. There is $n \times n$ matrix $F$ so that $CD = I_mi
    - $A^{-1}A$ = CA = I_n$

Squarematrix either Invertible or non-invertible

Javojdmxxh    **CAUTION: NOT TRUE IF NON-SQUARE**

**Singular means non-invertible**


1 0 -2
3 1 -2
-5 -1 9


1 0 -2
0 1 4
0 -1 -1


1 0 -2
0 1 4
0 0 3


1 0 -2
0 1 4
0 0 1





---

Make Singular

1 0 1
1 0 1
0 0 1

1 _ 1
0 1 1
0 0 1
^ not possible to make singular, already got 3 pivots

1 0 0
0 1 1
0 1 1