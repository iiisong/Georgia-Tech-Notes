### Lesson 2: Concepts
## Syntax vs Semantics

### Syntax
What is the **syntax** of a language
> the arrangement of words and phrases to create well-formed sentences in a language

### Semantics
> the branch of linquistics and logic concerned with meaning. There are a number of branches and subbranches of semantics, including formal semantics, which studies the logical aspects of meaning, such as sense, reference, implication, and logical form, lexical semantics, which studies word meanings and word relations, and conceptual semantics, which studies the cognitive structure of meaning.


### Class
- "Blueprint" of an object
- more of a collection of **states** and **behaviors**
    - **states**
        - variables
        - states
        - charge
        - quantities
        - values
        - etc
    - **behaviors**
        - connection
        - playing music
        - input
        - open/closer
        - raise/lower
        - etc
- very natural for humans

---

### Variables Declarations
States are stored through variables.  
Unlike in math where variables are unknowns, variable in programming are often known and keep track of information at memory addresses.  

> Java is **strongly-typed**, one variable can only hold 1 type (vs Python which is **weakly-typed**)

Programmers should always know what type of variable we are working with

> Variable declaration syntax: **\<type>\<indentifer>;**
- identifiers must start with a letter and can be followed by letters, numbers, and underscores
    - int num; // fine
    - double num2; // fine
    char a_Letter; // ffine
    - long 123abc; // won't compile

> Names are **case-sensitive**.

- numofPeople != numofpeople

A couple different conventions for naming variables: 
- **Camel-case**
    - Shortens variable names to eliminate underscores
    - Capitalize every word in the name after the first word
    - int numberOfPeople = 10

- **Underscores as spaces (for regular variable, not common)**
    - int number_of_people = 10;

- **Constants**
    - Often portrayed with all caps and underscores for spaces
    - uses **final** keyword to indicate no change after initialization
        - immutable (unchanging)
    - **final** double PI = 3.141592653;
    - **final** int TOTAL_GAMES_IN_SEASON = 13;

Java is **strongly** typed so cannot assign an inappropriate/incompatible type to a variable

---

## Primitive Data Types

**byte**
- $-2^7 <-> 2^7 -1$ 
- (-128 to 127) 
- 8 bit signed

**short**
- $2^{15} <-> 2^{15} -1$
- -32768 to 32767
- 16 bit signed

**int**
- $2^{31} <-> 2^{31} -1$
- 32 bit signed

**long**
- $2^{63} <-> 2^{63} -1$
- 64 bit signed

**float**
- Negative Range: -3.4E+38 to -1.4E-45
- Positive Range: 1.4E-45 to 3.4E+38
- 6-9 sig figs
- 32 bit IEEE 754

**doubles**
- Negative Range: -1.8E+308 to -4.9E-324
- Positive Range: 4.9-324 to 1.8E+308
- 15-17 significant digits
- 64 bit IEEE 754

**char**
- a single character ('q', 'Q', 'x', '@', etc)
- 16 bits

**boolean**
- true/false
- 1 bit

## "Literal" values
- "hardcoded" or "magic" numbers
- RHS (right hand side) of assignment
- int num = 10; // 10 is an integer literal
- double pi = 3.1415; // 3.1415 is a double literal
- float f = 3.1415f; // or 3.1415F (f/F indicates float literal)
- long l = 10L; // or 10l (l/L indicates long literal)
- char c = 'Q'; // enclose char literal in single quotes
- String s = "hello!"; // Encloses String literals in double quotes
boolean b = true; // **true** and **false** are boolean literals




