# Loops


- for loops
    - pre-test iterator
    ```java
    for (
    initialization; 
    loop-contination-condition;action-after-each-iteration) {
        // statement
    }
    ```
    - can always be represented as a while loop
    - common
        - ```java
            for (i=0; i<N,i++>) // iterates N times
            ```
        - ```java
            for (i=1; i<N,i++>) // iterates N-1 times
            ```
        - ```java
            for (i=0; i<=N,i++>) // iterates N+1 times
            ```
        - ```java
            for (i=1; i<=N,i++>) // iterates N times
            ```
- while loops
    - post-test iterator
- do while loops
    - check condition aftter running it first
    ```java 
    do {
        // loop body;
        // statements
    } while (loop-continuation-condition);
    ```

- break, continue
    - break leaves the loop
        - goes to outside of the closing curly brace
    - continue jumps to next cycle

    ```java
    for (int i = 0; i < 10; i += 1) {
        System.out.println(i);
        // other loop body statements(s)
    }

    int i = 0;
    while (i < 10) {
        System.out.println(i)
        // other loop body statement(s)
        System.out.println(i)
        i += 1;
    }

    int i = 0;
    do {
        System.out.println(i);
        i += 1;
    } while (i < 10);
    ```