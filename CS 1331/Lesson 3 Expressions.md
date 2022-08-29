# Expressions
- Expressions allow us to crunch the numbers
- Order of Precedence, Parentheses happen first
    - Binary operators are ordered left-to-right
    - Assignmentt operators are ordered left to right
- Similar to PEMDAS in math

## Operators in Java
<img src="https://i.stack.imgur.com/O6UXN.png" size=200>
<br>
<br>

### Unary operators (Operates on 1 operand)
- postfix
    - expr++ | expr--
        - post-increment | post-decrement
- unary
    - ++expr | --expr
        - pre-increment | pre-decrement
    - +expr | -expr
        - stays same (useless) | negate
    - ~ | !
        - bitwise not | logical not
            - bitwise flips the bits
            - b = byte(00001011) = 11
            - ~b = byte(11110100) = -12
                - -128 + 64 + 32 + 16 + 4 = -12
### Binary operrator (Operates on 2 operands)
- multiplicative
    - \* | / | %
        - multiplication | division | modulo
        - 9 / 2 = 4
            - int / int =  int
        - 9.0 / 2 = 4.5
            - double / int = double
            - implicit arithmetic conversion of int to double 
        - 9.0 / 2.0 = 4.5
            - double / double = double
- additiive
    - \+ | -
        - additiive | subtractive
- shift
    - << | >> | >>>
        - shift bits around
        - byte(01011) << 1 == byte(10110) 
            - 11 << 1 == 22
            - effectively multiply small numbers by 2 because binary shift left by 1
        - byte(10110) >> 1 == byte(01011)
            - 22 >> 1 == 11
            - effectively divide small numbers by 2 because binary shift right by 1
        - byte(011) >> 1 == byte(001)
            - 3 >> 1 == 1
            - 3 / 1, drop 1 remainder
- relational
    - < | > | <= | >= | instanceof
        - less than | greater than | less equal than | greater equal than | an instnce of class

- equality
    - == | !=
        - equal | not equal

### Bits boolean 
- bits
    - & | ^ | "|" |
        - bitwise and | bitwise xor | bitwise or
        - 11 & 12 = byte(1011) & byte(1100) = byte(1000) = 8
- boolean
    - && | "||"
        - logical and | logical or

### Ternary Operator (Operates on 3 operands) 
- Ternary Operator
    - ? : 
        - (boolean expression) ? (return if true) : (return if false)
        - > System.out.println(lightOn ? "light is on" : "light is off")
        - same thing as
        - > if (lightOn) {
            <br> System.out.println(print
            ("light is on") 
            > <br>
            >} else { 
            > <br>System.out.println("light is off")
            <br>}

### Compound Assignment
- Assignment
    - = | += | -= | *= | /= | ...
        - assign binary operator output to itself
            - > int a = 2;
                ><br>
                > a += 2;
                ><br>
                > // a == 4
        - compact way of writing
            - > int a = 2;
                ><br>
                > a = a + 2;
                ><br>
                > // a == 4
        - same form for nearly any binary operator
        - **In Java more efficient to use compound operators**

### Assignment works from right to left, rest works left to right
    
---

# Type Conversions

- Narrowing Conversions
    - going from larger type to smaller type
    - lose data
    - data truncated
- Widening Conversions
    - going from smaller type to larger type
    - increase data