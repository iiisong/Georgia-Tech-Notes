# 1.7 Linear Independence

Span{(1,2), (3,6)} = Span{(1,2)} line

## Linear Independence

> A set of vectors {$\vec{v_1}, ..., \vec{v_k}$} in $\R^n$ are **linearly independent** if
$$c_1\vec{v_1}+c_2\vec{v_2}+...+c_k\vec{v_k}=\vec{0}$$

has only **trivial**\* solution. It is **linearly dependent** otherwise.

In other words, {$\vec{v_1}, ..., \vec{v_k}$} are **linearly dependent** if there are real numbers $c_1, c_2, ..., c_k$ not all zero so that
$$c_1\vec{v_1}+ c2\vec{v_2}+... c_k\vec{v_k} = 0$$


\* all c's = 0

---

### Example 2 (One vector)

Suppose $\vec{v} \in \R^n$. When is the set {$\vec{v}$} linearly dependent?

<br>

{$\vec{v}$} Linearly Dependent if there exists a $c \neq 0$ solving $c\vec{v}=\vec{0}$

$\vec{v}=\vec{0}$: Check if there are $c\neq0 $ such that $c\vec{0}=\vec{0}$ 

$c=1$ works -> $c\vec{0}=\vec{0}$ always so LD

<br> 

$\vec{v}\neq\vec{0}$: Are there non-zero c solution $c\vec{v}=\vec{0}$?

No, $c\neq0$ and $\vec{v}\neq\vec{0}$ -> $c\vec{v}\neq\vec{0}$

<br>
<br>


---

### Example 3 (Two Vectors)

Suppose $\vec{v_1}, \vec{v_2} \in \R^n$. When is the set {$\vec{v_1}, \vec{v_2}$} linearly dependent?  
Provide a geometric interpretation


LD -> there is a nontrivial (c1, c2) such that c1v1+c2v2=0
Suppose $c_1 != 0$ Then $c_1\vec{v_1} =c_2\vec{v_2}$ -> $\vec{v_1}=(c_2/c_1)\vec{v_2}$ -> $\vec{v_1} || \vec{v_2}$

Because parallel, span redudant!

<br>

When is it linearly independent?

Linearly independent when the vectors are not parallel.

<img src="https://cdn.discordapp.com/attachments/1013967568610001027/1015325088956031046/unknown.png" width=400>

---

### If any one or more of $v_1, ... v_k$ is 0, then $v_1, ..., v_k$ is linearly dependent

Suppose $\vec{v_1}=\vec{0}$

$c_1\vec{v_1} + c_2\vec{v_2}+...+c_k\vec{v_k} = 0$

Linearly dependent if there's a nontrivial solution.

Set $c_1 = 1,\quad c_2=...= c_k = 0$

This is NONTRIVIAL since at least one weight is nonzero

<br>
<br>

---

Conser the vectors
$$\vec{v_1}, \vec{v_2}, .... \vec{v_k}$$

To determine whether the vectors are linearly independent, we can set the linear combination to the zero vector

$$c_1\vec{v_1}+c_2\vec{v_2}+...+c_k\vec{v_k}=
\begin{bmatrix}
&
\vec{v_1} &
\vec{v_2} & ... &
\vec{v_k}& \\[0.4em]
\end{bmatrix}
\begin{bmatrix}
c_1\\[0.4em]
c_2\\[0.4em]
\vdots\\[0.4em]
c_k\\[0.4em]
\end{bmatrix}
= 0$$

> The columns of a marix $A$ are linearly independent if and only if the euqation $A\vec{x}=\vec{0}$ has *only* the trivial solution.

> Columns are linearly dependent exactly when $A\vec{x}=\vec{0}$ has nontrivial solutions!

Free variables in $A\vec{x}=\vec{0}$ <-> nontrivial solutions <-> linear dependence

---

Is $\{
\begin{pmatrix}
2\\[0.4em]
3\\[0.4em]
\end{pmatrix}, 
\begin{pmatrix}
4\\[0.4em]
6\\[0.4em]
\end{pmatrix}\}$ linearly independent?

form augemented matrix of homogeneous problem
$$\begin{bmatrix}
& 2 & 4& \\[0.4em]
& 3 & 6& \\[0.4em]
\end{bmatrix}$$

> 1/2(1), 1/3(2)
$$
\begin{bmatrix}
& 1 & 2& \\[0.4em]
& 1 & 2& \\[0.4em]
\end{bmatrix}$$

> (2) - (1)
$$
\begin{bmatrix}
& 0 & 0& \\[0.4em]
& 0 & 0& \\[0.4em]
\end{bmatrix}$$

$x_1$ basic
$x_2$ free

Free variables <-> $\vec{0}$ solution non unique in $A\vec{x}=\vec{0}$ <-> nontrivial solutions <-> linearly dependent



---
$$
\begin{bmatrix}
1\\[0.4em]
1\\[0.4em]
h\\[0.4em]
\end{bmatrix},

\begin{bmatrix}
1\\[0.4em]
h\\[0.4em]
1\\[0.4em]
\end{bmatrix},

\begin{bmatrix}
h\\[0.4em]
1\\[0.4em]
1\\[0.4em]
\end{bmatrix}
$$
<br>
<br>

$$
\begin{bmatrix}
& 1 & 1 & h& \\[0.4em]
& 1 & h & 1& \\[0.4em]
& h & 1 & 1& \\[0.4em]
\end{bmatrix}
$$

> (2)-(1), (3)-h(1)
$$
\begin{bmatrix}
& 1 & 1 & h& \\[0.4em]
& 0 & h-1 & 1-h& \\[0.4em]
& 0 & 1-h & 1-h^2& \\[0.4em]
\end{bmatrix}
$$

> (2) + (3)
$$
\begin{bmatrix}
& 1 & 1 & h& \\[0.4em]
& 0 & h-1 & 1-h& \\[0.4em]
& 0 & 0 & -h^2-h-2& \\[0.4em]
\end{bmatrix}
$$

> (3) factorization
$$
\begin{bmatrix}
& 1 & 1 & h& \\[0.4em]
& 0 & h-1 & 1-h& \\[0.4em]
& 0 & 0 & -(h-1)(h+2)& \\[0.4em]
\end{bmatrix}
$$


Linearly independent so no free variables, pivot in every row

<br>

if $h=1$
$$
\begin{bmatrix}
& 1 & 1 & 1& \\[0.4em]
& 0 & 0 & 0& \\[0.4em]
& 0 & 0 & 0& \\[0.4em]
\end{bmatrix}
$$

1 pivot, 2 free variable -> LD

<br>


if $h=-2$
$$
\begin{bmatrix}
& 1 & 1 & -2& \\[0.4em]
& 0 & -3 & 3& \\[0.4em]
& 0 & 0 & 0& \\[0.4em]
\end{bmatrix}
$$

2 pivots, 1 free variable -> LD

<Br>

if $h \neq -2$

$$
\begin{bmatrix}
& 1 & 1 & -2& \\[0.4em]
& 0 & h-1 & 1-h& \\[0.4em]
& 0 & 0 & -(h+2)(h-1)& \\[0.4em]
\end{bmatrix}
$$

<Br>
3 pivots, 0 free variables -> ID

Therefore $h\neq 1, -2$

<br>

---

Suppose $\vec{v_1}, ..., \vec{v_k}$ are vectors in $\R^n$. If $k>n$ then $\vec{v_1}, ..., \vec{v_k}$ is independent

$\{
\begin{pmatrix}
1\\[0.4em]
1\\[0.4em]
\end{pmatrix}, 
\begin{pmatrix}
2\\[0.4em]
1\\[0.4em]
\end{pmatrix}, 
\begin{pmatrix}
3\\[0.4em]
1\\[0.4em]
\end{pmatrix}\}$ $k=4$ in $\R^2$, $n=2$, $k>n$


In augmented matrix at most 2 pivots
at least 2 free variables
LD


n x k matrix, $k > n$ (fat and wide matrix)

at most n pivots, at least $k - n$ free variabls

