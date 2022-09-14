
## What is Machine Learning?
> A computer program is said to learn from experience *E* wit respect to some class of tasks *T* and performance measure *P* if its performance at tasks in *T*, as measured by *P*, improves with experience *E*. - Tom M Mitchell

# Key Terms
## Data
> Typically the input data, which has an associated label

## Label
> Ground truth for each data point. What we want to predict. Actual data.

## Features
> Some variable that control or manipulate data

## Hypothesis
> Candidate "function" mapping from data to labels

## Loss/Cost Function
> Measure of how good a given hypothesis is (larger cost or loss is worse, we want to minimize). Inverse of accuracy

## Ground Truth

# Supervised Learning
Given input data and labels y, find $f$ that f(x) ~= y

### Example: Predicting house price based on size
x: house size  
y: house price

Univariate regression, one variable and one feature

## Regression
- Type of supervised learning where output is numeric
- Input data could be of any type

Features
- size  
- \# bedrooms  
- \# bathrooms  
- location

Regressor
- math

Output
- price

^ is multivariate regression


# Classification
- Type of supervised learning where output is **categorical**
- input can be any type
- Binary Classificatin: choosing between two classes
- differentiable by practice not by literal, probability of events occuring are classification
- MNIST

# Unspervised Learning
- input data x but no labels
- need to find pattern in data

### Example: Group people in sizes
Data: Height and weight

## Clustering
- Type of unsupervised laerning
- Need to group similar points together
- Loss Functions:


# Reinforcemant Learning
- Different paradigm for supervision
- **Agent** is given **rewards** based on **actions**
- Example
    - AlphaZero vs Stockfish
- Reward functions

# Dimensionality Reduction
- Dimensionality = number of dimensions
- Goal: reduce dimensionality of input data
- Focus on "important" features, get rid of other ones
        