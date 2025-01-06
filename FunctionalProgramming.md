Functional programming is a programming paradigm where computation is treated as the evaluation of mathematical functions. It emphasizes immutability, first-class functions, and declarative code.

Key Concepts in Functional Programming
Pure Functions:

Functions that always produce the same output for the same input without side effects.
Example:
java
int add(int a, int b) {
    return a + b;
}
First-Class Functions:

Functions are treated as first-class citizens (can be passed as arguments, returned from other functions, or assigned to variables).
Immutability:

Data does not change once created; new data structures are created instead.
Higher-Order Functions:

Functions that take other functions as parameters or return them as results.
Declarative Programming:

Focuses on what to do, rather than how to do it (e.g., using map and filter).
Focus Topics
1. Lambdas (Lambda Expressions)
Lambdas are anonymous functions (functions without a name) introduced in Java 8.

Syntax:

java
(parameters) -> expression
Examples:

Basic Lambda:
java
(int a, int b) -> a + b
With Type Inference:
java
(a, b) -> a * b
Single Parameter:
java
name -> name.toUpperCase()
Use Cases:

Simplify syntax for passing behavior as an argument.
Often used with functional interfaces like Predicate, Function, and Consumer.
2. Method References
A shorthand for writing lambdas that call an existing method.
Syntax:
java
ClassName::methodName
Types of Method References:
Static Method Reference:
java
list.forEach(System.out::println); // Equivalent to x -> System.out.println(x)
Instance Method Reference (on a specific object):
java
obj::methodName
Instance Method Reference (on any object of a type):
java
String::toUpperCase // Equivalent to x -> x.toUpperCase()
Constructor Reference:
java
ArrayList::new // Equivalent to () -> new ArrayList<>();
3. Map
Definition: A transformation operation that applies a function to each element of a stream and produces a new stream.

Syntax:

java
stream.map(function)
Use Cases:

Transform elements of a collection or stream.
Example:

java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<Integer> nameLengths = names.stream()
                                 .map(String::length)
                                 .collect(Collectors.toList());
4. Filter
Definition: An operation that selects elements of a stream based on a condition.

Syntax:

java
stream.filter(predicate)
Use Cases:

Remove unwanted elements based on a condition.
Example:

java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> shortNames = names.stream()
                               .filter(name -> name.length() <= 3)
                               .collect(Collectors.toList());
Combining Map and Filter
Map and filter can be combined in a stream pipeline for powerful data processing:

java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
List<String> result = names.stream()
                           .filter(name -> name.length() > 3)  // Filter names longer than 3 characters
                           .map(String::toUpperCase)          // Convert to uppercase
                           .collect(Collectors.toList());
System.out.println(result); // Output: [ALICE, CHARLIE, DAVID]
