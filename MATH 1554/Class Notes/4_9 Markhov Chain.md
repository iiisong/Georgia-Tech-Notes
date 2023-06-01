# Markhov Chains

Small town has 2 libraries, $A$ and $B$
After one month, among books checked out at A
.8 returned to A
.2 returned to B

Checked out at B
.3 returned to A
.7 returned to B

setosa.io/markhov/index.html

books are equally divided by between the two branches, denoted by x0 = [.5, .5] What is the distribution after 1 month. call it x1. after 2 months?

to find x1 we need to multiply x0 by a matrix p.

.8 .3
.2 .7

.5
.5

.55
.45

to find the distribution after 2 months, take x2 = Px1

0.8 0.3
0.2 0.7

.55
.45

.575
.425

to find distribution after k months

p^k x1

or 

p(x_k-1) x1



## Definiitons
> A probability vector is a vector x with non-negative elements that sum to 1.

> A stochastic matrix is a square matrix P whose columns are probability vectors

> A Markov chain is a sequence of probability vectors xk and a stochastic matrix P such that
Pk+1 = Pxk

k = 0, 1, 2

A steady state vector for P is a vector q such that Pq = q

P = 
.8 .3
.2 .7

Pq - q = 0
(P - I2)q = 0

-.2 .3
.2 -.3


-.2 .3
0 0

1 -1.5
0 0

q1 = 1.5q2
q2 = q2

Steady-state vector is in Span (3/2, 1)
q must be probability vector

divide by sum

3/5 = .6
2/5 = .4



Convergence

If P is a regular stochastic matrix, then P has a unique steady-state vector q and xk+1 = Pxk converges to q as k -> infinity

In the previous example, P was regular, for k=1 , P1 has strictly positive entries


Fact: When P is an nxn matrix, P - In is never invertible. We always have a free variable

P has o be square so we can ake Px


## Example 3

                Rented from
                   A  B  C
                A .8 .1 .2
returned from   B .2 .6 .3
                C .0 .3. 5

Construct a stocchastic matrix P for this problem

P =
.8 .1 .2
.2 .6 .3
.0 .3 .5


