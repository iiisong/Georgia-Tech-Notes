# Section 1.5 Solution Sets of Linear Systems 8/31

## We now have four equivalent ayys of expressing linear systems
1. A system of equations
$$ 2x_1 + 3x_2 = 7$$
$$x_1-x_2=5$$
2. An augmented matrix
$$
\begin{bmatrix}
& 2 & 3 & | & 7& \\[0.4em]
& 1 & -1 & | & 5& \\[0.4em]
\end{bmatrix}
$$
3. A vector equation
$x_1
\begin{pmatrix}
2\\[0.4em]
1\\[0.4em]
\end{pmatrix}+ x_2
\begin{pmatrix}
3\\[0.4em]
-1\\[0.4em]
\end{pmatrix}
$

4. As a matrix equation

## Topics
We will cover these topics in this section
1. Homogenous systems
2. Parametric **vector** forms of solutions to linear systems

## Objectives
Students expected to be able to do the following in topics in this section
1. Express the solution set of linear in parametric form

## Homogenous Systems
> Linear systems of the form $A\vec{x} = \vec{0}$ are **homogenous**

> Linear systems of the form $A\vec{x} \neq \vec{0}$ are inhomogenous

Because homogenous systems always have the **trivial solution**, $\vec{x} =\vec{0}$ they are always consistent. Interesting question whether they have nontrivial solutions ($\neq\vec{0}$)

$A\vec{x}=\vec{0}$ has a nontrivial solution  
== there is a free variable  
== A has a column with no pivot  

### a Homogenous System
$$x_1+3x_2+x_3=0$$
$$2x_1-x_2-5x_3=0$$
$$x_1-2x_3=0$$
<br>
<br>


$$
\begin{bmatrix}
& 1 & 3 & 1 & | & 0& \\[0.4em]
& 2 & -1 & -5 & | & 0& \\[0.4em]
& 1 & 0 & -2 & | & 0& \\[0.4em]
\end{bmatrix}
$$

zero vector, last column never change

only need to row reduce A
$$
\begin{bmatrix}
& 1 & 3 & 1& \\[0.4em]
& 2 & -1 & -5& \\[0.4em]
& 1 & 0 & 2& \\[0.4em]
\end{bmatrix}
$$

> (2) - 2(1), (3) - (1)
$$
\begin{bmatrix}
& 1 & 3 & 1& \\[0.4em]
& 0 & -7 & -7& \\[0.4em]
& 0 & -3 & -3& \\[0.4em]
\end{bmatrix}
$$

> -1/7 (2), -1/3 (3)
$$
\begin{bmatrix}
& 1 & 3 & 1& \\[0.4em]
& 0 & 1 & 1& \\[0.4em]
& 0 & 1 & 1& \\[0.4em]
\end{bmatrix}
$$

> (3) - (2)
$$
\begin{bmatrix}
& 1 & 3 & 1& \\[0.4em]
& 0 & 1 & 1& \\[0.4em]
& 0 & 0 & 0& \\[0.4em]
\end{bmatrix}
$$

> $x_3$ is free  
> $x_1, x_2$ basic 

> (1) - 3(2)
$$
\begin{bmatrix}
& 1 & 0 & -2& \\[0.4em]
& 0 & 1 & 1& \\[0.4em]
& 0 & 0 & 0& \\[0.4em]
\end{bmatrix}
$$


more accurately
$$
\begin{bmatrix}
& 1 & 0 & -2 & | & 0 & \\[0.4em]
& 0 & 1 & 1 & | & 0 & \\[0.4em]
& 0 & 0 & 0 & | & 0 & \\[0.4em]
\end{bmatrix}
$$

> $x_1 = 2x_3$  
> $x_2 = -x_3$


## Parametric Forms, Homogeneous Case
Suppose free variables for $A\vec{x}=\vec{0}$ are $x_k, ..., x_n$. Then all solutions to Ax=0 can be written as 


### Example: a Homogeneous System
Parametric Vector Form
$$x_1=2x_3$$
$$x_2=-x_3$$
$$x_3 = x_3$$

<br>

$$\vec{x}=
\begin{pmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
x_3\\[0.4em]
\end{pmatrix}
= x_3
\begin{pmatrix}
2\\[0.4em]
-1\\[0.4em]
1\\[0.4em]
\end{pmatrix}
= 
\begin{pmatrix}
2x_3\\[0.4em]
-x_3\\[0.4em]
x_3\\[0.4em]
\end{pmatrix}
$$

### Example 2 (non-homogeneous system)

$$x_1+3x_2+x_3=9$$
$$2x_1-x_2-5x_3=11$$
$$x_1-2x_3=6$$
$$
\begin{bmatrix}
& 1 & 3 & 1 & | & 9& \\[0.4em]
& 2 & -1 & -5 & | & 11& \\[0.4em]
& 1 & 0 & -2 & | & 6& \\[0.4em]
\end{bmatrix}
$$

choices of row operation remains the same

> (2) - 2(1), (3) - (1)
$$
\begin{bmatrix}
& 1 & 3 & 1 & | & 9& \\[0.4em]
& 0 & -7 & -7 & | & -7& \\[0.4em]
& 0 & -3 & -3 & | & -3& \\[0.4em]
\end{bmatrix}
$$

> -1/7 (2), 1/3(3)
$$
\begin{bmatrix}
& 1 & 3 & 1 & | & 9& \\[0.4em]
& 0 & 1 & 1 & | & 1& \\[0.4em]
& 0 & 1 & 1 & | & 1& \\[0.4em]
\end{bmatrix}
$$

> (3) - (2)
$$
\begin{bmatrix}
& 1 & 3 & 1 & | & 9& \\[0.4em]
& 0 & 1 & 1 & | & 1& \\[0.4em]
& 0 & 0 & 0 & | & 0& \\[0.4em]
\end{bmatrix}
$$

> (1) - 3(2)

$$
\begin{bmatrix}
& 1 & 0 & -2 & | & 6& \\[0.4em]
& 0 & 1 & 1 & | & 1& \\[0.4em]
& 0 & 0 & 0 & | & 0& \\[0.4em]
\end{bmatrix}
$$

> $x_1=2x_3+6$  
> $x_2=-x_3+1$  
> $x_3$ free


Express in parametric vector form
$$\vec{x}=x_3
\begin{pmatrix}
2\\[0.4em]
-1\\[0.4em]
1\\[0.4em]
\end{pmatrix}
+ 
\begin{pmatrix}
6\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{pmatrix}
$$


Linear Combination, free variables as weights
$$x_3
\begin{pmatrix}
2\\[0.4em]
-1\\[0.4em]
1\\[0.4em]
\end{pmatrix}$$

<br>
<br>

Constant vector! 
$$
\begin{pmatrix}
6\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{pmatrix}
$$

$$\vec{x}=x_3
\begin{pmatrix}
2\\[0.4em]
-1\\[0.4em]
1\\[0.4em]
\end{pmatrix}
+ 
\begin{pmatrix}
6\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{pmatrix}
= 
\begin{pmatrix}
2x_3\\[0.4em]
-x_3\\[0.4em]
x_3\\[0.4em]
\end{pmatrix}
+ 
\begin{pmatrix}
6\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{pmatrix}
= 
\begin{pmatrix}
2x_3+6\\[0.4em]
-x_3+ 1\\[0.4em]
x_3\\[0.4em]
\end{pmatrix}
$$

<img src="https://cdn.discordapp.com/attachments/1013967568610001027/1014603020023111751/unknown.png" width=500>



## Theorem 6
> Suppose the equation $Ax=b$ is consistent for some given $b$, and let $p$ be a solution. Then the solution set of $Ax=b$ is the set of all vectors of the form $w=p+v_h$, where vh is any solution of the homogeneous equation $Ax=0$

if the homogenous problem has free variables, inhomogeneous has free variables.

if the inhomogeneous solution has no free variables, neither does homogeneous, assuming inhomogeneous solution is consistent

Free and basic variables true for homogeneous or inhomogeneous as long as both consistent.

<img src="https://cdn.discordapp.com/attachments/1013967568610001027/1014605346301558894/unknown.png" width=500>


**Q**: Wrote the line thru $\vec{a}$ parallel to $\vec{b}$ if $\vec{a} =
\begin{pmatrix}
0\\[0.4em]
1\\[0.4em]
3\\[0.4em]
\end{pmatrix}
\vec{b}
\begin{pmatrix}
1\\[0.4em]
1\\[0.4em]
1\\[0.4em]
\end{pmatrix}= tb+a = t
\begin{pmatrix}
1\\[0.4em]
1\\[0.4em]
1\\[0.4em]
\end{pmatrix}+\begin{pmatrix}
0\\[0.4em]
1\\[0.4em]
3\\[0.4em]
\end{pmatrix}, t\in\R$

Describe and compare the solution sets of $x_1+0x_2-4x_3=0$ and $x_1+9x_2-4_x3=-2$


Homogeneous


$
\begin{bmatrix}
& 1 & 9 & -4 & | & -2& \\[0.4em]
\end{bmatrix}
$

$x_1$ basic   
$x_2, x_3$ free

<br>

$x_1 = -9x_2 + 4x_3$  

$x = x_2
\begin{pmatrix}
9\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{pmatrix}+ x_3 = 
\begin{pmatrix}
4\\[0.4em]
0\\[0.4em]
1\\[0.4em]
\end{pmatrix}
$


**When multiple free variables, put 0's soo they dont cross paths

$
\begin{bmatrix}
& 1 & 9 & -4 & | & -2& \\[0.4em]
\end{bmatrix}
$  
$x_1 = -9x_2 + 4x_3 - 2$

$x_1$ basic
$x_2, x_3$ free

$\vec{x}=x_2
\begin{pmatrix}
-9\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{pmatrix}+ x_3
\begin{pmatrix}
4\\[0.4em]
0\\[0.4em]
1\\[0.4em]
\end{pmatrix}+\begin{pmatrix}
-2\\[0.4em]
0\\[0.4em]
0\\[0.4em]
\end{pmatrix}$ 

<img src="https://cdn.discordapp.com/attachments/1013967568610001027/1014608191247634432/unknown.png">