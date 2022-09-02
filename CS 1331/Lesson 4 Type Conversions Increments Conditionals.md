# Type Conversions, Increments, and Conditionals
- Java is strongly typed
When converting numbers, be mindful of differences in size of the types. Size influence the range/precision that a type can hold
- **Narrowing Conversions** - going from a larger type to a smaller type (with respect to precision)
    - short s = 12345678L; // short <-- Long is bad
- **Widening Conversions** - going from a smaller type to a larger type (with respect to precision)
    - short s = 1234;
    - long l = s; // long <-- short is OK because short's value fits in long

- Few ways that conversions occur between differing types
    - Assignment conversions (implicit)
        - Examples
            - double num1 = 3; // this is OK becaue we can represent 3 as 3.0
            - int i;   
            double d;  
            d = i; // OK double <-- int
            i = d; // won't compile int <-- double


## Increment Decrement Operators
```java
int res1, res2;
int total = 5;

res1 = total++; 
// 1) increment total 
// 2) substitute original value
// 
// 1) store orig value in temp
// 2) increment value
// 3) returns temp

System.out.println(res1); // prints 5

total = 5;
res2 = ++total;
// 1) increment total
// 2) substitute new value
// 
// 1) increment total
// return new

System.out.println(res2); // prints 6
```

# Conditionals
**Java does not care about spacing**

