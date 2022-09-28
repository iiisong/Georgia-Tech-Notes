# Section 1.2 Eschelon Form 8/24

## Eschelon Form


$$
\begin{bmatrix}
& \# & * & * & *  & \\[0.4em]
& 0 & \#  & * & * & \\[0.4em]
& 0 & 0 & \# & *  & \\[0.4em]
& 0 & 0 & 0 & \#
\end{bmatrix}
$$

$$
\begin{bmatrix}
& \# & * & * & *  & \\[0.4em]
& 0 & \#  & * & * & \\[0.4em]
& 0 & 0 & 0 & \#
\end{bmatrix}
$$

\# = non zero number  
\* = any number

A rectangular matrix is in **eschelon form** if
1. All zero rows (if any are present) are at the bottom. 
2. The first non-zero entry (or **leading entry**) of a row is to the right of any leading entires in the row above it (if any)
3. All elements below a leading entry (if any) are zero

1 row matrices are always in eschelon form!

## Row Reduced Eschelon Form
**First leading non-zero entry is 1**  
**Zeroes above every leading 1**

$$
\begin{bmatrix}
& 1 & * & * & * & \\[0.4em]
& 0 & 1  & * & * & \\[0.4em]
& 0 & 0 & 1 & *\\[0.3em]
& 0 & 0 & 0 & 1
\end{bmatrix}
$$

$$
\begin{bmatrix}
& 1 & 0 & * & 0  & \\[0.4em]
& 0 & 1  & * & 0 & \\[0.4em]
& 0 & 0 & 0 & 1
\end{bmatrix}
$$

### Pivot Position
> Pivot Position in the matrix A is a location in A that corresponds to a leading 1 in the **row reduced eschelon** form of A

### Pivot Column
> Pivot column is a column of A that contains a pivot position

$$
\begin{bmatrix}
& 1 & * & * & * & \\[0.4em]
& 0 & 1  & * & * & \\[0.4em]
& 0 & 0 & 1 & *\\[0.4em]
& 0 & 0 & 0 & 1
\end{bmatrix}
$$

$$
\begin{bmatrix}
& 1 & 0 & * & 0 & \\[0.4em]
& 0 & 1  & * & 0 & \\[0.4em]
& 0 & 0 & 0 & 1
\end{bmatrix}
$$
pivot positions (1,1), (2,2), (3,3), (4,4) for top matrix  
pivot positions are (1,1) (2,2), (3,4)



## Example 1
> Starting Matrix
$$
\begin{bmatrix}
& 0 & -3 & -6 & 4 & \\[0.4em]
& -1 & 2 & -1 & 3 & \\[0.4em]
& -2 & -3 & 0 & 3 & \\[0.4em]
\end{bmatrix}
$$

> (2) <-> (1)
$$
\begin{bmatrix}
& -1 & -2 & -1 & 3 & \\[0.4em]
& 0 & -3 & -6 & 4 & \\[0.4em]
& -2 & -3 & 0 & 3 & \\[0.4em]
\end{bmatrix}
$$

> -1 * (1)
$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & 3 & 6 & -4 & \\[0.4em]
& -2 & -3 & 0 & 3 & \\[0.4em]
\end{bmatrix}
$$
> (3) + 2 * (1)
$$
\begin{bmatrix}
1 & 2 & 1 & -3 & \\[0.4em]
0 & 3 & 6 & -4 & \\[0.4em]
0 & 1 & 2 & -3 & \\[0.4em]
\end{bmatrix}
$$
> (2) <-> (3)
$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & 1 & 2 & -3 & \\[0.4em]
& 0 & 3 & 6 & -4 & \\[0.4em]
\end{bmatrix}
$$
> (3) - 3 * (2)
$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & 1 & 2 & -3 & \\[0.4em]
& 0 & 0 & 0 & 5 & \\[0.4em]
\end{bmatrix}
$$
> 1/5 * (3)
$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & 1 & 2 & -3 & \\[0.4em]
& 0 & 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$

---
## Example 2
> Starting Matrix
$$
\begin{bmatrix}
& 0 & -3 & -6 & 4 & \\[0.4em]
& -1 & -2 & -1 & 3 & \\[0.4em]
& -2 & -3 & 0 & 3 & \\[0.4em]
\end{bmatrix}
$$
> (1) <-> (2)
$$
\begin{bmatrix}
& -1 & -2 & -1 & 3 & \\[0.4em]
& 0 & -3 & -6 & 4 & \\[0.4em]
& -2 & -3 & 0 & 3 & \\[0.4em]
\end{bmatrix}
$$
> -1 * (1)
$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & -3 & -6 & 4 & \\[0.4em]
& -2 & -3 & 0 & 3 & \\[0.4em]
\end{bmatrix}
$$
> (3) + 2 * (1)
$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & -3 & -6 & 4 & \\[0.4em]
& 0 & 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$

$$
\begin{bmatrix}
& 1 & 2 & 1 & -3 & \\[0.4em]
& 0 & 1 & 2 & -3 & \\[0.4em]
& 0 & 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$
> 
$$
\begin{bmatrix}
& 1 & 2 & 1 & 0 & \\[0.4em]
& 0 & 1 & 2 & 0 & \\[0.4em]
& 0 & 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$

$$
\begin{bmatrix}
& 1 & 0 & -3 & 0 & \\[0.4em]
& 0 & 1 & 2 & 0 & \\[0.4em]
& 0 & 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$

---
## Algorithm for Eschelon Form

1. Swap the 1st row with a lower one so the leftmost nonzero entry is in the 1st row
2. Scale the 1sst row so that its leading entry is equal to 1
3. Use row replacement so all entries below this 1 are 0
4. Swap the 2nd row with a lower one so that the leftmost nonzero entry below 1st row is in the 2nd row
5. Repeat step 1 to step 4 with the 2nd row, 3rd, 4th... until no more row

**Now the matrix is in echelon form with leading entires equal to 1**


--- 
## Algorithm for RREF from EF

Start with eschelon form matrix

Use row replacement so all entries above each leading entry are 0, starting from the right

---

Consider the augmented matrix

$$
\begin{bmatrix}
& x1 & x2 & x3 & x4 & x5 & \\[0.4em]
& 1 & 3 & 0 & 7 & 0 & | & 4 & \\[0.4em]
& 0 & 0 & 1 & 4 & 0 & | & 5 & \\[0.4em]
& 0 & 0 & 0 & 0 & 1 & | & 6 & \\[0.4em]
\end{bmatrix}
$$

Leading ones are in the first and third columns

### **Pivot variables**
> the pivot variables of the system $Ax = b$ are $x_1$, $x_3$, $x_5$

### **Free variables**
> the free variables are $x_2$ and $x_4$. Any choice of the free variables leads to a solution of the system. 

### **Uniqueness**
> There is only 1 solution. Unqiue if no free variables.

# Theorem
> ### A linear system is consistent if and only if the last column of the **augmented** matrix does not have a pivot. This is the same as saying that the RREF of the augmented matrix **does not** have a row of the form.

> In other words, last column can not have leading entry 1 to be consistent

$$
\begin{bmatrix}
& x1 & x2 & x3 & x4 & x5 & \\[0.4em]
& 1 & 3 & 0 & 7 & 0 & | & 4 & \\[0.4em]
& 0 & 0 & 1 & 4 & 0 & | & 5 & \\[0.4em]
& 0 & 0 & 0 & 0 & 1 & | & 6 & \\[0.4em]
\end{bmatrix}
$$

This system does not have a leading zero in the last column [4,5,6] so it is consistent.

### Moreover, if a linear system is consistent, then it has
1. a unique solution if and only if there are no free variables
2. infinitely many solutions that are **parameterized by free variables**


---
---
$$
\begin{bmatrix}
& 1 & 0 & 0 & 1 & \\[0.4em]
& 0 & 0 & 1 & 2 & \\[0.4em]
& 0 & 0 & 0 & 0 & \\[0.4em]
\end{bmatrix}
$$

Pivot Variables: x1, x3

Free Variables: x2

Consistent: yes

Unique: No

---
$$
\begin{bmatrix}
& 1 & 0 & 0 & 0 & \\[0.4em]
& 0 & 0 & 1 & 0 & \\[0.4em]
& 0 & 0 & 0 & 1 & \\[0.4em]
\end{bmatrix}
$$

Pivot Variables: x1, x3  
Free variables: x2  
Consistent: No  
Unique: Doesn't Apply  

---
$$
\begin{bmatrix}
& 1 & 0 & 0 & 0 & \\[0.4em]
& 0 & 1 & 0 & 0 & \\[0.4em]
& 0 & 0 & 1 & 0 & \\[0.4em]
\end{bmatrix}
$$
Pivot Varriables: x1, x2, x3  
Free variables: None  
Consistent: Yes  
Unique: Yes
