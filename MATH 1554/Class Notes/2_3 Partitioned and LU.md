Partitioned Matrix
Matrix can be made out of different matrices

1 0 0 0 | * ... *
0 1 0 0 | * ... *
0 0 1 0 | * ... *
0 0 0 1 | * ... *
0 0 0 0 | 0 0 0 0

=

I_4 F
0 0



# LU Factorzation

A = L(lower) U(upper) triangular matrices

Upper traingular

1 5 0
0 2 4

1 0 0 1
0 2 1 0
0 0 1 0
0 0 0 1

2
0
0
0



Lower Triangular

1 0 0
3 2 0

3 0 0 0
1 1 0 0
0 0 1 0
0 2 0 1

1
2
1
2

Both Upper and Lower
1 0
0 1

0 0 
0 0

1 0
0 7
0 1

1 0 0 0

2
0
0
0

1


A = LU
= 
1 0 0
* 1 0
* * 1

* *
0 *
0 0

A(mxn) -> L(mxm) u(mxn)

matrices in eschelon form auto upper triangular

1 0 0 0
1 1 0 0
0 2 1 0
0 0 1 1

## Forward Solve
1 0 0
0 2 1
0 0 2
0 0 0

2
3
2
0



1 0 0 0
1 1 0 0
0 2 1 0 
0 0 1 1 

y_1
y_1 + y_2
2y_2 + y_3
y_3 + y_4

2
3
2
0

y_1 = 2
y_2 = 1
y_3 = 0
y_4 = 0

2
1
0
0



## Back solve

1 0 0
0 2 1
0 0 2
0 0 0

x_1
x_2
x_3

2
1
0
0

x_3 = 0
x_2 = .5
x_1 = 2

## Exmaple 2

A = 
4 -3 -1 5
-16 12 2 -17
8 -6 -12 22

row reduce
4 -3 -1 5
0 0 -2 3
0 0 -10 12

4 -3 -1 5
0 0 -2 3
0 0 0 -3


U = 
4 -3 -1 5
0 0 -2 3
0 0 0 -3

L = 
1 0 0
a 1 0
b c 1

A = LU
4a = -16
a = -4
4b = 8
b = 2
-b -2c = -12
c = -5


1 0 0
-4 1 0
2 -5 1