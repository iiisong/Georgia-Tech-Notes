
# **Worksheet 1.5, Solution Sets of Linear Systems**
*The worksheet for this week si shorter; we are assuming that there will be a quiz this week.

**Worksheet Exercises**
1. **Written Explanation Exercise**
    1. When does a homogeneous system has a nontrivial solution, what properties does that system have? List at least two.

        - **There is a free variable**
        - **It has infinite solutions**
2. Indicate whether the statements are true or false.

    1. A non-trivial solution $\vec{x}$ to $A\vec{x}=\vec{0}$ has all non-zero entries.
        - **False. Non-trivial is all-zero entries**
        <br>
        <br>
    
    2. If $A\vec{x}=\vec{b}$ and $A\vec{y}=\vec{b}$ = 0.

        - **True. Linear matrix multiplication. $A(\vec{x}-\vec{y}) = A\vec{x} - A\vec{y}$**

    <br>

    3. Any 3 x 2 matrix $A$ with two pivotal positions has a non-trivial solution to $A\vec{x}=0$
        - **False. No free variables**

<br>
<br>

3. **Example Construction**
    1. Give an example of a non-zero 2 x 3 matrix $A$ such that $\vec{x}
\begin{pmatrix}
1\\[0.4em]
2\\[0.4em]
1\\[0.4em]
\end{pmatrix}$
    is a solution of $A\vec{x}=\vec{0}$
    <br>
    <br>

    $$
    \begin{bmatrix}
    & 1 & -1 & 1& \\[0.4em]
    & 1 & -1 & 1& \\[0.4em]
    \end{bmatrix}\begin{bmatrix}
    1\\[0.4em]
    2\\[0.4em]
    1\\[0.4em]
    \end{bmatrix} = \begin{bmatrix}
    0\\[0.4em]
    0\\[0.4em]
    \end{bmatrix}$$


    <br>
    <br>


    2. Give an example of a non-trivial solution to $A\vec{x}=\vec{0}$, where $A = 
    \begin{pmatrix}
    2 & 5 \\[0.4em]
    0 & 0\\[0.4em]
    4 & 10 \\[0.4em]
    \end{pmatrix}$
    <br>
    <br>
    <br>
$$
\begin{bmatrix}
& 2 & 5& \\[0.4em]
& 0 & 0& \\[0.4em]
& 4 & 10& \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{bmatrix}
=

\begin{bmatrix}
0\\[0.4em]
0\\[0.4em]
0\\[0.4em]
\end{bmatrix}

$$
<br>

$$x=
\begin{bmatrix}
-5\\[0.4em]
2\\[0.4em]
\end{bmatrix}
$$

<br>
<br>

4. Express the solution to $A\vec{x}=\vec{0}$ in parametric vector form, where $A=
\begin{pmatrix}
& 1 & 3 & 4 & 1& \\[0.4em]
& 0 & 0 & 1 & 1& \\[0.4em]
\end{pmatrix}$

<br>

$$x_1 = -3x_2 + 4x_3 + 1x_4 = 0$$
$$x_3 = -x_4$$
<br>

$$x_1 = -3x_2 -3x_4$$
$$x_2 = x_2$$
$$x_3 = -x_4$$
$$x_4 = -x_4$$
<br>

$$x = x_2
\begin{bmatrix}
-3\\[0.4em]
0\\[0.4em]
4\\[0.4em]
0\\[0.4em]
\end{bmatrix}
+x_4
\begin{bmatrix}
-3\\[0.4em]
0\\[0.4em]
-1\\[0.4em]
1\\[0.4em]
\end{bmatrix}
$$


<br>
<br>

# Worksheet 1.8
**Worksheet Exercises**
1. **Written Explanation Exercise**
Suppose $T(x)=A(x)$ for all $x$ where $A$ is a matrix and $T$ is onto.  
    1. What can we say about pivotal rows of $A$?

        > Each row of A has a pivot variable because if there is a row on A with all zeros, there may be a non-zero in the corresponding row of b that would make the system inconsistent.
    
    <br>
    
    2. What can we say about the existence of solutions to $Ax=b$

        > The transformations of x by A is the same set as the solutions of $Ax=b$

    <br>
    <br>

2. Let $A$ be an $3\times4$. What must $c$ and $d$ be if we define the linear transformation $T : \R^c\rightarrow\R^d$ by $T(\vec{x})=A\vec{x}$?

    > c = 4, d = 3
    
    <br>
    <br>

3. Let $T : \R^2\rightarrow\R^d$ be a linear transformation such that 
$$T(   
\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{bmatrix})= x_1 \begin{bmatrix}
-1\\[0.4em]
3\\[0.4em]
\end{bmatrix} + x_2
\begin{bmatrix}
4\\[0.4em]
-1\\[0.4em]
\end{bmatrix}
$$

$\quad$ Construct a matrix $A$ so that $T(\vec{x})=A(\vec{x})$ for all vectors $\vec{x}$.
> $$T(\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{bmatrix}) =\begin{bmatrix}
        & -1 & 4& \\[0.4em]
        & 3 & -1& \\[0.4em]
        \end{bmatrix}\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{bmatrix}
        $$

<br>
<br>

4. Let $T : \R^5\rightarrow\R^4$ be a linear transformation such that
$$T
\begin{bmatrix}
4\\[0.4em]
0\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{bmatrix}
= T
\begin{bmatrix}
0\\[0.4em]
0\\[0.4em]
1\\[0.4em]
4\\[0.4em]
\end{bmatrix} \neq 0
$$
$\quad$ Identify a nontrivial solution $\vec{x}$ to $T\vec{x}=\vec{0}$.

> $$T(
\begin{bmatrix}
4\\[0.4em]
0\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{bmatrix}) - T(\begin{bmatrix}
0\\[0.4em]
0\\[0.4em]
1\\[0.4em]
4\\[0.4em]
\end{bmatrix}) = 0$$ 
> 
> $$T(
\begin{bmatrix}
4\\[0.4em]
0\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{bmatrix} - \begin{bmatrix}
0\\[0.4em]
0\\[0.4em]
1\\[0.4em]
4\\[0.4em]
\end{bmatrix}) = \vec{0}$$ 
> 
> $$T(
\begin{bmatrix}
4\\[0.4em]
0\\[0.4em]
0\\[0.4em]
-4\\[0.4em]
\end{bmatrix}) = \vec{0}$$ 
>
> $$\vec{x}= \begin{bmatrix}
4\\[0.4em]
0\\[0.4em]
0\\[0.4em]
-4\\[0.4em]
\end{bmatrix}$$

<br>
<br>

5. Let $T_A$ be the linear transformation with the matrix below. Match each choice of $A$ on the left with the geometric description of the action of $%T_A$.

$\quad$ Rotation by $90\degree$, A shear, Projection onto $y$ axis, Dilation by 1/2


$$
\begin{bmatrix}
& .5 & 0& \\[0.4em]
& 0 & .5& \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
& 0 & 0& \\[0.4em]
& 0 & 1& \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
& 0 & -1& \\[0.4em]
& 1 & 0& \\[0.4em]
\end{bmatrix}

\begin{bmatrix}
& 1 & 1& \\[0.4em]
& 0 & 1& \\[0.4em]
\end{bmatrix}
$$

> $\quad$ 1/2 dilation $\quad$ projection $\quad$ rotation 90  $\quad\quad$ shear  

<br>
<br>
<br>
