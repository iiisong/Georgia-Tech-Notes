# 1.8 An Introduction to Linear Transforms

Last equivalent form of linear system

## Linear Transformation


$T: \R^n -> \R^m, \quad T(\vec{v}) = A\vec{v}$

## Matrix Transformation
- **Domain** of $T$ is $\R^n$  
- **Co-domain** or **target** of $T$ is $\R$  
- The vector $T(\vec{x})$ is the **image** of $\vec{x}$ under $T$
- The set of all possible images $T(\vec{x})$ is the **range**

Range is subset of co-domain

$f: \R->\R \quad\quad f(x)=sin(x)$

In calculus, x axis is domain, y axis is codomain, range is [-1,1]

Domain of $\R^2$ and codomain of $\R^3$ require 5 dmensions

---

### Example 1

Let $A = \begin{bmatrix}
& 1 & 1& \\[0.4em]
& 0 & 1& \\[0.4em]
& 1 & 1& \\[0.4em]
\end{bmatrix}$

$u = 
\begin{bmatrix}
3\\[0.4em]
4\\[0.4em]
\end{bmatrix}$

$b =
\begin{bmatrix}
7\\[0.4em]
5\\[0.4em]
7\\[0.4em]
\end{bmatrix}$

Compute $T(\vec{u}) = Au = T = \R^2->\R^3$


$$
\begin{bmatrix}
3+4\\[0.4em]
0+4\\[0.4em]
3+4\\[0.4em]
\end{bmatrix}
=

\begin{bmatrix}
7\\[0.4em]
4\\[0.4em]
7\\[0.4em]
\end{bmatrix}
$$

image of $\vec{u}$ under $T$


Calculate $\vec{v}\in\R^2$ so that $T(\vec{v}) = \vec{b}$
$$
\begin{bmatrix}
& 1 & 1& \\[0.4em]
& 0 & 1& \\[0.4em]
& 1 & 1& \\[0.4em]
\end{bmatrix}
\begin{bmatrix}
v_1\\[0.4em]
v_3\\[0.4em]
\end{bmatrix}
=
\begin{bmatrix}
7\\[0.4em]
5\\[0.4em]
7\\[0.4em]
\end{bmatrix}
$$
> Convert to augmented matrix form
$$
\begin{bmatrix}
& 1 & 1 & | & 7& \\[0.4em]
& 0 & 1 & | & 5& \\[0.4em]
& 1 & 1 & | & 7& \\[0.4em]
\end{bmatrix}
$$
> Solve 
$$
\begin{bmatrix}
& 1 & 0 & | & 2 & \\[0.4em]
& 0 & 1 & | & 5 & \\[0.4em]
& 0 & 0 & | & 0 & \\[0.4em]
\end{bmatrix}
$$

<br>
<br>

Both basic, unique, and consistent

$v_1 = 2$  
$v_2 = 5$

Check $T(\begin{bmatrix}
2\\[0.4em]
5\\[0.4em]
\end{bmatrix}) =
\begin{bmatrix}
& 1 & 1 & \\[0.4em]
& 0 & 1 & \\[0.4em]
& 1 & 1 & \\[0.4em]
\end{bmatrix}\begin{bmatrix}
2\\[0.4em]
5\\[0.4em]
\end{bmatrix}=
\begin{bmatrix}
2+5\\[0.4em]
0+5\\[0.4em]
2+5\\[0.4em]
\end{bmatrix}=
\begin{bmatrix}
7\\[0.4em]
5\\[0.4em]
7\\[0.4em]
\end{bmatrix}$

Give $Ac \rightarrow \R^3$ so there is no $v$ with $T(v) = c$  
Give a $c$ that is not in the range of $T$  
Give a $c$ that is not the span of the columns of $A$

$$T(v) = A\vec{v} = \vec{v_1}a_1 +\vec{v_2}a_2\vdots$$
A = (a1, a2)

$c$ not in range(T) is same as $A\vec{v} = c$ is inconsistent

Augmented matrix 
$$
\begin{bmatrix}
& 1 & 1 & | & c_1 & \\[0.4em]
& 0 & 1 & | & c_2 & \\[0.4em]
& 1 & 1 & | & c_3 & \\[0.4em]
\end{bmatrix}
$$
$$
\begin{bmatrix}
& 1 & 0 & | & c_1 -c_2 & \\[0.4em]
& 0 & 1 & | & c_2 & \\[0.4em]
& 0 & 0 & | & c_3 -c_1 & \\[0.4em]
\end{bmatrix}
$$

inconsistent if $c_3 - c_1 \neq 0$

$c$ could not be $
\begin{bmatrix}
1\\[0.4em]
1\\[0.4em]
3\\[0.4em]
\end{bmatrix}$ or any other vector where $c_3 \neq c_1$

## Principle of Superposition
> The idea is that if we know $T(e_1), \vdots T(e_n)$ then we know every $T(v)$

Every matrix transformation $T$

FACT: Every matrix transformation $T_a$ is linear

## Standard Basis
$$e_1 = \begin{bmatrix}
1\\[0.4em]
0\\[0.4em]
\vdots\\[0.4em]
0\\[0.4em]
\end{bmatrix}$$

$$e_2 = \begin{bmatrix}
0\\[0.4em]
1\\[0.4em]
\vdots\\[0.4em]
0\\[0.4em]
\end{bmatrix}
$$

$$e_n =\begin{bmatrix}
1\\[0.4em]
0\\[0.4em]
\vdots\\[0.4em]
n\\[0.4em]
\vdots\\[0.4em]
e_N\\[0.4em]
\end{bmatrix}$$


e_N

---

### Example 2

$$A = \begin{bmatrix}
& 0 & 1 & \\[0.4em]
& 1 & 0 & \\[0.4em]
\end{bmatrix}$$

$$A
\begin{pmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{pmatrix} = \begin{pmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{pmatrix}$$

> Reflect over axis $x_1 = x_2$


$$A = 
\begin{pmatrix}
& 1 & 0& \\[0.4em]
& 0 & 0& \\[0.4em]
\end{pmatrix}$$

$$A
\begin{pmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{pmatrix}= 
\begin{pmatrix}
x_1\\[0.4em]
0\\[0.4em]
\end{pmatrix}$$

> Projection on $x_1$ axis

$$A
\begin{pmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{pmatrix}=
\begin{pmatrix}
k_1\\[0.4em]
k_2\\[0.4em]
\end{pmatrix}
$$

> Scaling by a factor of k
$$
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & 1 & 0 & \\[0.4em]
& 0 & 0 & 0 & \\[0.4em]
\end{bmatrix}
$$

> Projection on $x_1, x_2$ plane
$$
\begin{bmatrix}
& 1 & 0 & 0 & \\[0.4em]
& 0 & -1 & 0 & \\[0.4em]
& 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$

> Reflection on $x_2$

