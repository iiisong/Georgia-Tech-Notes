# 1.3 Vector Equations 8/26

## Topics
We will cover these topics in this section
1. Vectors in $R$


> **Algebra** in Linear algebra in tterms of **geometry**

$$x - 3y = -3$$
$$2x = y = 8$$

Need interdimensional space $R^3$ and vectors in it


Recall that $T$ denotes the collection of all real number

$R$ is just decimal expansive numbers


$R^n$ =  all ordered n-**tuples** of real numbers  
**tuples** = ordered list

$n = 1$: Number Line  
$n = 2$: Plane, can be represented by ordered pair of (x,y) in 2D Cartesian  
$n = 3$: Volume, can be represented by ordered pair of (x, y, z) in 3D Cartesian


Trry to think of elements of $R^3$ as vectors 
instead of points  


**Vectors**
> arrow points out of origin with a length and direction
> (3, 2) vector points 3 units out in positive x direction and 2 out in positive y direction from origin

$\quad$

$\quad$

---

## Vector Operations
### 1. Scalar Multiplication

$$C \in R,\quad  C\bar u = \binom{Cu_1}{Cu_2}$$

### 2. Sum of Vector

$$\bar u + \bar v = \binom{u_1 + v_1}{u_2 + v_2}$$

* Subtracting is just adding negative vector
* Negative vector is just negative scalar multiple of the vector

---

### Example 1

$$u = 1, -2$$  
$$v = 2, -5$$

Find:

$$4u = 4, -8$$  
$$-3v = -6, 15$$  
$$4u + -3v = -2, 7$$

---

## Geometric Interpretation of Linear Combinations

**As long 2 vectors $u$,$v$ in $R^2$ not parallel to each other, any vector in $R^2$ can be represented with a combination of $u$ and $v$**

---
## Linear Combinations and Span
1. Given vectors $v_1, v_2, ..., v_p <- R^n$ and scalars $c_1, c_2, ... , c_p$, the vectors below

    > $y = c_1v_1 + c_2 v_2 + ... + c_pv_p$

    is called a linear combination of $v_1, v_2, ..., vp$ with weights $c_1, c_2, ... c_p$

2. The set of all linear combinations of $v_1, v_2, ..., v_p$ is calle dhte Span of v_1, v_2, ...., v_p$

$$ Span\{u, v\} =   
u_1x_1 + v_1x_2  
u_2x_2 + v_2x_2$$



$
b=
\begin{bmatrix}
b_1\\[0.4em]
b_2\\[0.4em]
\end{bmatrix}
$

b in span ${u, v}$

$u_1x_1 + v_1x_2 = b_1$  
$u_2x_1 + v_2x_2 = b_2$

B in span if there exist coeffs $x_1$, $x_2$ such that $b = x_1u + x_2v$


---

### Example 3
is $y$ in the span of vectors $v_1$ and $v_2$

$$v_1 =
\begin{bmatrix}
1\\[0.4em]
-2\\[0.4em]
-3\\[0.4em]
\end{bmatrix}
$$

$$v_2 = 
\begin{bmatrix}
2\\[0.4em]
5\\[0.4em]
6\\[0.4em]
\end{bmatrix}
$$

$$ y = 
\begin{bmatrix}
7\\[0.4em]
4\\[0.4em]
15\\[0.4em]
\end{bmatrix}
$$

$$
\begin{bmatrix}
& 1 & 2 & | & 7& \\[0.4em]
& -2 & 5 & | & 4& \\[0.4em]
& -3 & 6 & | & 15& \\[0.4em]
\end{bmatrix}
$$ 

> (2) + 2(1)
$$
\begin{bmatrix}
& 1 & 2 & | & 7& \\[0.4em]
& 0 & 9 & | & 18& \\[0.4em]
& -3 & 6 & | & 15& \\[0.4em]
\end{bmatrix}
$$

> (3) + 3(1)
$$
\begin{bmatrix}
& 1 & 2 & | & 7& \\[0.4em]
& 0 & 9 & | & 18& \\[0.4em]
& 0 & 12 & | & 36& \\[0.4em]
\end{bmatrix}
$$

> 1/9 (2)  
$$
\begin{bmatrix}
& 1 & 2 & | & 7& \\[0.4em]
& 0 & 1 & | & 2& \\[0.4em]
& 0 & 12 & | & 36& \\[0.4em]
\end{bmatrix}
$$

> 1/12 (3)
$$
\begin{bmatrix}
& 1 & 2 & | & 7& \\[0.4em]
& 0 & 1 & | & 2& \\[0.4em]
& 0 & 1 & | & 3& \\[0.4em]
\end{bmatrix}
$$

> (3) - (2)
$$
\begin{bmatrix}
& 1 & 2 & | & 7& \\[0.4em]
& 0 & 1 & | & 2& \\[0.4em]
& 0 & 0 & | & 1& \\[0.4em]
\end{bmatrix}
$$

Inconsistent

$y$ is not in the span of $v_1$ and $v_2$

**2 vectors is not enough to capture the span of $R^3$**

---

Let $w_1, W_2, w_3, u, v$ be vectors in $R^n$.  
Supposed the vectors $u$ and $v$ are in Span{$w_1, w_2, w_3$}.   
Show that $u+v$ is also in Span {$w_1, w_2, w_3$}


$u = c_1w_1, c_2w_2, c_3w_3 $
$v = v_1w_1, v_2w_2, v_3w_3$

$u + v =  c_1w_1, c_2w_2, c_3w_3 + v_1w_1, v_2w_2, v_3w_3$

$u + v = (c_1 + d_1)w_1 + (c_2 + d_2)w_2 + (c_3 + d_3)w_3$