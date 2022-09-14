# MATH 1554 Midterm 1 Study Guide (IN PROGRESS)

## 1.2
### Pivot Position
- Leftmost non-zero entry in each row
- also known as Leading Coefficient

### Pivot Column
- A column that contains a pivot position

### Row Echelon Form (REF)
- All zero rows at the very bottom
- Pivots are always to the right of the leading coeeficient above it
    - Only zeros below each pivot

 <br>
 
 $$ \begin{bmatrix}
    & 1 & 2 & 2 &\\
    & 0 & 8 & 5 &\\
    & 0 & 0 & 3 &\\
    \end{bmatrix},
    \begin{bmatrix}
    & 1 & 2 & 2 & 3 &\\
    & 0 & 8 & 5 & 7 &\\
    & 0 & 0 & 3 & 9 &\\
    \end{bmatrix},
    \begin{bmatrix} 
    & 1 & 2 & 2 & 3 &\\
    & 0 & 8 & 5 & 7 &\\
    & 0 & 0 & 0 & 9 &\\
    \end{bmatrix},\cdots$$ 
<p align="center"><i> these are some matrices in row echelon form</i></p> 

<br>
<br>

### Reduced Row Echelon Form (RREF)
- A special form of row echelon form
- Pivots are all 1 ("leading 1")
- All pivot columns have zeros in all other entries apart from the pivot
- **Each matrix has only one equivalent matrix in RREF form**

 <br>
 
 $$ \begin{bmatrix}
    & 1 & 0 & 0 &\\
    & 0 & 1 & 0 &\\
    & 0 & 0 & 1 &\\
    \end{bmatrix},
    \begin{bmatrix}
    & 1 & 0 & 0 & 3 &\\
    & 0 & 1 & 0 & 7 &\\
    & 0 & 0 & 1 & 9 &\\
    \end{bmatrix},
    \begin{bmatrix} 
    & 1 & 0 & 2 & 0 &\\
    & 0 & 1 & 5 & 0 &\\
    & 0 & 0 & 0 & 1 &\\
    \end{bmatrix}, \cdots$$ 
<p align="center"><i> these are some matrices in reduced row echelon form</i></p> 
<br>
<br>

### Solving Linear Systems with RREF
- Linear equations can be represented by matrices
 <br> 

 $$
\begin{cases}
x_1 + 2x_2 = 3\\
\\
\\
\end{cases}
$$




---
## 1.9
<br>

### Matrix Transformation
- Every linear transformation can be represented by a matrix transformation
- Matrix transformations can be in the form (where A is the transformation vector): 
$$\quad T(\vec{x}) = b \quad\rightarrow\quad A\vec{x} =b$$
<br>
<br>

### Identity Matrix
- Square matrix where the diagonal elements are 1's while the rest are 0's
- Each row represents a dimension

 
    <br>
 
    
 
$$
    \begin{bmatrix}
    & 1 & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}, \quad
    \begin{bmatrix}
    & 1 & 0 & 0 & \\
    & 0 & 1 & 0 & \\
    & 0 & 0 & 1 & \\
    \end{bmatrix}, \quad
    \begin{bmatrix}
    & 1 & 0 & 0 & 0 & \\
    & 0 & 1 & 0 & 0 & \\
    & 0 & 0 & 1 & 0 & \\
    & 0 & 0 & 0 & 1 & \\
    \end{bmatrix} \cdots$$
 
<p align="center"><i> these are all identity matrices</i></p>
<br>

- Can also be represented in *e* form
<br>

$$ M = \begin{bmatrix} & e_1 & e_2 & \cdots & e_n & \end{bmatrix}$$
     
$$e_1 = \begin{bmatrix}
    1 \\
    0 \\
    0 \\
    \vdots \\
    \end {bmatrix}, \quad
e_2 = \begin{bmatrix}
    0 \\
    1 \\
    0 \\
    \vdots \\
    \end {bmatrix}, \quad\cdots, \quad
e_n = \begin{bmatrix}
    \vdots \\
    0 \\
    0 \\
    1 \\
    \end {bmatrix}$$
     
<p align="center"><i> Representing identity matrix through e vectors</i></p>
<br>

- When you transform a vector by an identity matrix it results in the original vector 

$$\begin{bmatrix}
    & 1 & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & x_1 + 0x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}$$
 
<p align="center"><i>Identity matrices does not change vector when transformed</i></p>
<br>
<br>

### Scaling
- Multiply a dimension by certain amount to stretch or condense it 
    - also referred as expansion and condensing
    - Scaling without a direction specified implies all directions
    <br>
    <br>
 
$$\begin{bmatrix}
    & 3 & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 3x_1 + 0x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    3x_1  \\
    x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>Horizontal stretching by a factor of 3</i></p>
    <br>
 
    
 
$$\begin{bmatrix}
    & \frac{1}{3} & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & \frac{1}{3}x_1 + 0x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    \frac{1}{3}x_1  \\
    x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>Horizontal compression by a factor of 1/3</i></p>

<br>


<br>
 
    
 
$$\begin{bmatrix}
    & 3 & 0 & \\
    & 0 & 3 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 3x_1 + 0x_2 & \\
    & 0x_1 + 3x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    3x_1  \\
    3x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i> Scale by a factor of 3</i></p>

<br>
<br>

### Reflection
- Reflect across axis by negating the dimensions of the direction we are reflecting 
    - **Reflection is just scaling in a direction by -1**
    - note: the axis we are reflecting across is not the dimension we are negating
        - reflecting $y$ means negating $x$ 
    <br>
    <br>

 
    <br>
 
    
 
$$\begin{bmatrix}
    & 1 & 0 & \\
    & 0 & -1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & -x_1 + 0x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_1  \\
    -x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>reflection across the x axis</i></p>
    <br>

 
    
 
$$\begin{bmatrix}
    & -1 & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & -x_1 + 0x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    -x_1  \\
    x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>reflection across the y axis</i></p>
    <br>
    <br>

### Reflection along y = x
- $y$ dimensions switch with $x$ dimension
-  equivalent to swapping the $x_1$ row with $x_2$ row
- [Interactive Reflection off y=x](https://www.desmos.com/calculator/9iubjjzpu6)

 
    <br>
 
    
 
$$\begin{bmatrix}
    & 0 & 1 & \\
    & 1 & 0 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 0x_1 + x_2 & \\
    & x_1+0x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_2  \\
    x_1  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>reflection over y=x</i></p>
    <br>
    <br>

### Projection
- Project on axis by making the dimension be 0
    - **Projection is just scaling in a direction by 0**
    - note: the axis we are projecting to is not the dimension we are zeroing
        - projecting on $y$ means scaling $x$ by 0
    <br>
    <br>

 
    <br>
 
    
 
$$\begin{bmatrix}
    & 1 & 0 & \\
    & 0 & 0 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & -x_1 + 0x_2 & \\
    & 0x_1+0x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_1  \\
    0  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>projection on the x axis</i></p>
    <br>
    <br>
 
    
 
$$\begin{bmatrix}
    & 0 & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 0x_1 + 0x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    0  \\
    x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>projection on the y axis</i></p>

<br>
<br>

### Shears
- "A transformation in which all points along a given line remain fixed while other points are shifted parallel to by a distance proportional to their perpendicular distance from the line"
    - [Interactive Shear Example](https://www.desmos.com/calculator/vzd5yaflsa)
    <br>
    <br>

<p align="center"><img src="https://external-preview.redd.it/pGst_f94SvVkquxfA5kg-BgjJbIqJM8eseJhYZkKvu0.jpg?width=640&crop=smart&auto=webp&s=8851eb22ab7affc57ab65079f234e971a40aecf1" width=200></p>
    <br>
    <br>
 
    
 
$$\begin{bmatrix}
    & 1 & 3 & \\
    & 0 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 1x_1 + 3x_2 & \\
    & 0x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_1 + 3x_2  \\
    x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>shear of 3 along the x direction</i></p>
    <br>
    <br>
 
    
 
$$\begin{bmatrix}
    & 1 & 0 & \\
    & 3 & 1 & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 1x_1 + 0x_2 & \\
    & 3x_1+x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_1  \\
    3x_1 + x_2  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>shear of 3 along the y direction</i></p>
    <br>

### Rotation
- Rotating each vector counterclockwise
- Transformation matrix follows the form:

$$\begin{bmatrix}
    & cos(\theta) & -sin(\theta) & \\
    & sin(\theta) & cos(\theta) & \\
\end{bmatrix}
$$
<br>
<br>

- At 0 degrees, the transformation is equal to the unit vector

$$\begin{bmatrix}
    & cos(0) & -sin(0) & \\
    & sin(0) & cos(0) & \\
    \end{bmatrix} = 
    \begin{bmatrix}
    & 1 & 0 & \\
    & 0 & 1 & \\
    \end{bmatrix}
$$
<br>
 
    
 
$$\begin{bmatrix}
    & cos(\pi) & -sin(\pi) & \\
    & sin(\pi) & cos(\pi) & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & -x_1 + 0x_2 & \\
    & 0x_1+1x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    -x_1  \\
    x_2  \\
    \end{bmatrix} $$  
 
<p align="center"><i>rotation of pi clockwise </i></p>
    <br>
    <br>
 
    
 
$$\begin{bmatrix}
    & cos(\frac{3\pi}{2}) & -sin(\frac{3\pi}{2}) & \\
    & sin(\frac{3\pi}{2}) & cos(\frac{3\pi}{2}) & \\
    \end{bmatrix}
    \begin{bmatrix}
    x_1  \\
    x_2  \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    & 0 + x_2 & \\
    & -x_1+0x_2 & \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    x_2  \\
    -x_1  \\
    \end{bmatrix} $$ 
 
<p align="center"><i>rotation of 3pi/2 clockwise</i></p>
    <br>
    <br>

### Onto
- For every $b$ in the codomain, there exist a vector $\vec{x}$ that transforms into it
    - Every $b$ has at least one $x$ that satisfies the equation $A\vec{x}=b$
- **Pivot in every row**
    - Derivation
        - 1. If there is not a pivot in every row of $A$, then $A$ has an empty row
            
        <br>
            
        $$A = \begin{bmatrix}
                & 1 & 3 & 2 & \\
                & 0 & 1 & 4 & \\
                & 0 & 0 & 0 & \\
            \end{bmatrix}
        $$
        <p align="center"><i>zero bottom row</i></p>
            <br>

        - 2. If $A$ has an empty row, there exist a $b$ where the pivot entry is in the last column of its augmented matrix
                
            <br>
            <br>
            
        $$b=\begin{bmatrix} 2 \\ 4 \\ 3 \end{bmatrix}$$
                
        $$A|b=\quad\begin{bmatrix}
        & 1 & 3 & 2 & | & 2 &\\
        & 0 & 1 & 4 & | & 4 &\\
        & 0 & 0 & 0 & | & 3 &\\
        \end{bmatrix}$$
                
        <p align="center"><i>pivot entry in last column</i></p>
        <br>

        - 3. If the solution vector contains a pivot, then the equation is inconsistent, making it **not** onto.         
        <br>     
        <br>
         
    
         
$$ A|b =\quad\begin{bmatrix}
            & 1 & 3 & 2 & | & 2 &\\
            & 0 & 1 & 4 & | & 4 &\\
            & \textbf0 & \textbf0 & \textbf0 & | & \textbf3 &\\
            \end{bmatrix} $$
         
    
         
<p align="center"><i>No vector exists that when transformed by A will result in the b, making it <b>not</b> onto</i></p>
        <br>
        <br>
        <br>


### One-To-One
- For every $b$ in the codomain, there can exist either one or no vector $\vec{x}$ that can transform into it
    - At most only one $x$ exists satisfies the equation $A\vec{x}=b$
- **Pivot in every column**
    - Derivation
        - 1. If there is not a pivot in every column of $A$, then $A$ has an free variable
            <br>
            <br>
                
        
                
        $$A = \begin{bmatrix}
                    & 1 & 0 & 0 & 1 & \\
                    & 0 & 1 & 0 & 0 &\\
                    & 0 & 0 & 1 & 2 &\\
                    \end{bmatrix}$$
                
        <p align="center"><i>right most vector is a free variable</i></p>
        <br>

        - 2. If $A$ has a column without pivot, the solution is non-unique      
            <br>

        $$b=\begin{bmatrix} 
        2 \\
        4 \\ 
        3 \\
        \end{bmatrix}$$

        $$ A|b =\quad\begin{bmatrix}
        & 1 & 0 & 0 & 1 & | & 2 &\\
        & 0 & 1 & 0 & 0 &| & 4 &\\
        & 0 & 0 & 1 & 2 & | & 3 &\\
        \end{bmatrix}$$ 
                
        $$ \begin{bmatrix}
            x_1 \\
            x_2 \\
            x_3 \\
            x_4 \\
            \end {bmatrix}=
            x_4 \begin{bmatrix}
            -1 \\
            0 \\
            -2 \\
            1 \\
            \end{bmatrix}
            + \begin{bmatrix}
            2 \\
            4 \\
            3 \\
            0 \\
            \end{bmatrix} 
        $$
                
        <p align="center"><i>infinite possiblities for vector x as x4 can be anything</i></p>
        <br>
        <br>

        - 3. If the solution vector is non-unique, then the equation is inconsistent, making it **not** one-to-one.      
            <br>
            <br> 
         
    
         
$$ m = \begin{bmatrix}
            1 \\
            4 \\
            1 \\
            1 \\
            \end{bmatrix},\quad 
            n= \begin{bmatrix}
            -3 \\
            4 \\
            -7 \\
            5 \\
            \end{bmatrix} $$
         
   
         
   $$ \begin{bmatrix}
            & 1 & 0 & 0 & 1 & \\
            & 0 & 1 & 0 & 0 &\\
            & 0 & 0 & 1 & 2 &\\
            \end{bmatrix}
            \begin{bmatrix}
            1 \\
            4 \\
            1 \\
            1 \\
            \end{bmatrix} 
            = \begin{bmatrix}
            2 \\
            4 \\
            3 \\
            0 \\
            \end{bmatrix} $$
         
$$ \begin{bmatrix}
            & 1 & 0 & 0 & 1 & \\
            & 0 & 1 & 0 & 0 &\\
            & 0 & 0 & 1 & 2 &\\
            \end{bmatrix}
            \begin{bmatrix}
            -3 \\
            4 \\
            -7 \\
            5 \\
            \end{bmatrix} 
            = \begin{bmatrix}
            2 \\
            4 \\
            3 \\
            0 \\
            \end{bmatrix} $$
         
   
         
<p align="center"><i>At least 2 vectors (ex. m, n) can be transformed into b, making it <b>not</b> one-to-one</i></p>
            <br>

---
## 2.1 Matrix Transformation


