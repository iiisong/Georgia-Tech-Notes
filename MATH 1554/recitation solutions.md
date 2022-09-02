
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
