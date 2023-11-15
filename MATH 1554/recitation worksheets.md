# **Worksheet 1.3, Vector Equations**
**Worksheet Exercises**
1. **Written Explanation Exercise**

    a) What does the span of a set of vectors represent?

    b) How do we determine whether a vector is in the span of a set of vectors?

2. Suppose A = 
2 -1 3
4 -2 6

    a) Sketch the span of the columns of the matrix. *Remember to label your axes. Also, arrows should be use d for coordinate axes and vectors, because they are quantities with direction. But do not sketch the span of a set of vectors using arrows.*

    b) On the same graph, sketch vectors u = 
1
2

v = 
3
1

c) Using your graph, which of the following systems is consistent?

- $Ax = u$
- $Ax = v$

# **Worksheet 1.4, The Matrix Equation**
**Worksheet Exercises
1. Span{$v_1,v_2$} isequal to which of the expressions below?  
    1. Span{$v_1, v_2, 3v_1$}
    2. Span{$v_1, 3v_1$}
    3. Span{$v_1, v_2, 3v_1 + 2v_2$}
2. For what values of $h$ is $\vec{b}$ in the plane spanned by $\vec{a_1}$ and $\vec{a_2}$?

$$
\vec{a_1} = \begin{pmatrix}
1\\[0.4em]
4\\[0.4em]
-1\\[0.4em]
\end{pmatrix}, \quad
\vec{a_2} = \begin{pmatrix}
-6\\[0.4em]
-17\\[0.4em]
2\\[0.4em]
\end{pmatrix}, \quad
\vec{b} =
\begin{pmatrix}
4\\[0.4em]
2\\[0.4em]
h\\[0.4em]
\end{pmatrix}
$$

3. Indicate whether the statements are true or false.
    1. If the equation $A\vec{x} = \vec{b}$ is inconsistent, then $\vec{b}$ is not in the set spanned by the columns of $A$.
    2. If the augmented matrix $\begin{bmatrix}
 A & \vec{b} \end{bmatrix}$  has a pivot position in every row, then the equation $A\vec{x} = \vec{b}$ must be consistent.
    3. There are exactly three vecors in Span{$\vec{a_1}, \vec{a_2},\vec{a_3}$}

<br>
<br>

# **Worksheet 1.5, Solution Sets of Linear Systems**
*The worksheet for this week si shorter; we are assuming that there will be a quiz this week.

**Worksheet Exercises**
1. **Written Explanation Exercise**
    1. When does a homogeneous system has a nontrivial solution, what properties does that system have? List at least two.
2. Indicate whether the statements are true or false.
    1. A non-trivial solution $\vec{x}$ to $A\vec{x}=\vec{0}$ has all non-zero entries.
    2. If $A\vec{x}=\vec{b}$ and $A\vec{y}=\vec{b}$ = 0.
    3. Any 3 x 2 matrix $A$ with two pivotal positions has a non-trivial solution to $A\vec{x}=0$

3. **Example Construction**
    1. Give an example of a non-zero 2 x 3 matrix $A$ such that $\vec{x}
\begin{pmatrix}
1\\[0.4em]
2\\[0.4em]
1\\[0.4em]
\end{pmatrix}$
    is a solution of $A\vec{x}=\vec{0}$.

    2. Give an example of a non-trivial solution to $A\vec{x}=\vec{0}$, where $A = 
\begin{pmatrix}
 2 & 5 \\[0.4em]
 0 & 0\\[0.4em]
 4 & 10 \\[0.4em]
\end{pmatrix}$.

4. Express the solution to $A\vec{x}=\vec{0}$ in parametric vector form, where $A=
\begin{pmatrix}
& 1 & 3 & 4 & 1& \\[0.4em]
& 0 & 0 & 1 & 1& \\[0.4em]
\end{pmatrix}$.

<br>
<br>
<br>


# Worksheet 1.8
**Worksheet Exercises**
1. **Written Explanation Exercise**
Suppose $T(x)=A(x)$ for all $x$ where $A$ is a matrix and $T$ is onto.  
    1. What can we say about pivotal rows of $A$?
    
    2. What can we say about the existence of solutions to $Ax=b$

2. Let $A$ be an $3\times4$. What must $c$ and $d$ be if we defien the linear transformation $T : \R^c\rightarrow\R^d$ by $T(\vec{x})=A\vec{x}$?

3. Let $T : \R^2\rightarrow\R^d$ be a linear transformation such that 
$$T(   
\begin{bmatrix}
x_1\\[0.4em]
x_2\\[0.4em]
\end{bmatrix})=

x_1
\begin{bmatrix}
-1\\[0.4em]
3\\[0.4em]
\end{bmatrix}
+
x_2
\begin{bmatrix}
4\\[0.4em]
-1\\[0.4em]
\end{bmatrix}
$$
Construct a matrix $A$ so that $T(\vec{x})=A(\vec{x})$ for all vectors $\vec{x}$.

4. Let $T : \R^5\rightarrow\R^4$ be a linear transformation such that
$$T
\begin{bmatrix}
4\\[0.4em]
0\\[0.4em]
1\\[0.4em]
0\\[0.4em]
\end{bmatrix}
=

T
\begin{bmatrix}
0\\[0.4em]
0\\[0.4em]
1\\[0.4em]
4\\[0.4em]
\end{bmatrix}
\neq
0
$$
Identify a nontrivial solution $\vec{x}$ to $T\vec{x}=\vec{0}$.

5. Let $T_A$ be the linear transformation with the matrix below. Match each choice of $A$ on the left with the geometric description of the action of $%T_A$.

Rotation by $90\degree$, A shear, Projection onto $y$ axis, Dilation by 1/2


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
