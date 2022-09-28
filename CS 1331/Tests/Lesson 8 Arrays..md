# Arrays

Arrays can only contain objects of single type
Uniform size

element address = base address + index * size of type

Retrieval fast

Java does autobound checking

```java
int[] scores = new int[3]

OR

int[] scores = {88, 99, 75, 100}
```

Basic **for** loop iteration
```java
Random rand = new Random();
double[] myList = new double[10]/
for(int i=0; i < myList.length; i++) {
    myList[i] = rand.nextDouble();
}
```

Basic **for each** loop iteration
```java
for (dataType varName : collection) { // varName is copy of item in collection
    // do stuff
    varName.method();
}
```

```java
void foo(dataType... parameterName);
```

Arrays of arrays could be jagged


```java
String[] foobar = {"foo", "bar"}
swap(foobar);

void swap(String[] args) {
    temp = args[0];
    args[1] = args[0];
    args[1] = temp;
}
```
