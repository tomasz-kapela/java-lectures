

Experiment

```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class Experiment {
public static void main(String[] args) {
String a = null;
System.out.println(a.toLowerCase());
}
}
```

What will happen when we try to compile and execute this program?


Experiment

The code will compile but during runtime we get the following:
```java
Exception in thread "main" java.lang.NullPointerException
at pl.edu.wsb_nlu.java.lecture4.exceptions.Experiment.main(Experiment.java:6)
```

An exception is thrown.


Exceptions
An exception (or exceptional event) is a problem that arises during the execution of a program. When an Exception occurs the normal flow of the program is disrupted.

    More precisely, in Java, exceptions are objects of child class of Exception class - they can be used with throw clause.
    
    The exception can be cached in try-catch clause. If we do not catch them, the execution of program will be terminated and we get then stack trace printed.



Experiment part 2

```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class Experiment2 {
public static void main(String[] args) {
String a = null;
try {
System.out.println(a.toLowerCase());
} catch (NullPointerException e) {
System.out.println("String is null!");
}
}
}
```

What will happen when we try to compile and execute this program?


Try-catch clause
```java
try {
// Here should be code where an exception can be thrown
} catch (ExceptionClass e) {
// This will be run after throwing an exception
} finally {
// This will be run at the end of try-catch clause, no matter whether the exception has been thrown, catched or neither of them
}
```



Try-catch clause example
```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class Experiment3 {
public static void main(String[] args) {
String a = null;
try {
System.out.println(a.toLowerCase());
System.out.println("String1");
} catch (ArithmeticException e) { // It is not NullPointerException!
System.out.println("String2");
} finally {
System.out.println("String3");
}
System.out.println("String4");
}
}
```
What will be written to the standard output by this program?


Multiple catch block
```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class MultipleCatch {
public static void main(String[] args) {
String a = null;
try {
System.out.println(a.toLowerCase());
System.out.println("String1");
} catch (ArithmeticException e) {
System.out.println("String2");
} catch (NullPointerException e) {
System.out.println("String2a");
} finally {
System.out.println("String3");
}
System.out.println("String4");
}
}
```
We can catch different exceptions based on its class and perform different actions then.


Multiple exceptions in one catch block
```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class MultipleCatch2 {
public static void main(String[] args) {
String a = null;
try {
System.out.println(a.toLowerCase());
System.out.println("String1");
}catch(ArithmeticException|NullPointerException e) {
System.out.println("String2");
}
System.out.println("String4");
}
}
```
We can catch different exception instances in one catch block.


Multiple exceptions in one catch block
```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class CatchParent {
public static void main(String[] args) {
String a = null;
try {
System.out.println(a.toLowerCase());
System.out.println("String1");
} catch (RuntimeException e) {
//        } catch (RuntimeException | NullPointerException e) {
// Line above will not compile because RuntimeException is parentClass of NullPointerException
System.out.println("String2");
}
System.out.println("String4");
}
}
```
Or we can use parent class (RuntimeException is parent class of both ArithmeticException and NullPointerException).

Exception hierarchy

\begin{figure}
\centering
\includegraphics{exceptions1.jpg}
\label{fig:my_label}
\end{figure}

'Other' exceptions are also called as checked exceptions.


Checked exceptions

Checked exceptions are those which are instances of child class of Exception class but not the child of RuntimeException class.

We are (as programmers) forced to handle checked exceptions. Let's look at the example.


Reading a file

We can use Scanner class to read a file.

```java
package pl.edu.wsb_nlu.java.lecture4.files;
// imports

public class FileReadingScanner {
public static void main(String[] args) {
try {
Scanner scanner = new Scanner(new File("file.txt"));
while (scanner.hasNext())
System.out.println(scanner.nextLine());
} catch (IOException e) {
System.out.println("File not found!");
}
}
}
```
IOException is checked exception - if we simply put a 'new Scanner(fileobject)' without try-catch clause, the program will not be compiled.    


Reading a file

```java
package pl.edu.wsb_nlu.java.lecture4.files;
// imports

public class FileReadingNIO {
public static void main(String[] args) {
Path path = Paths.get("file.txt");
try {
List<String> stringList = Files.readAllLines(path);
for (String s: stringList)
System.out.println(s);
} catch (IOException e) {
System.out.println("File not found!");
}
}
}
```
Here is shown an alternative way of reading files using java NIO package.


Reading a file

```java
package pl.edu.wsb_nlu.java.lecture4.files;
// imports

public class FileReadingScannerThrows {
public static void main(String[] args) throws IOException {
Scanner scanner = new Scanner(new File("file.txt"));
while (scanner.hasNext())
System.out.println(scanner.nextLine());
}
}
```
There is an alternative to add 'throws' keyword with exception class to the method's signature. Then we delegate the exception handling to the upper method. If we use it in the main method, the try-catch clause will not be needed (what is not recommended to do).    


Throwing an exception

```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class Throwing {

    public static void throwException(){
        try {
            throw new Exception("This is message");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        throwException();
    }
}
```



Throwing an exception

```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class Throwing2 {

    public static void throwException() throws Exception{
        throw new Exception("This is message");
    }

    public static void main(String[] args) {
        try {
            throwException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```
We can delegate the exception handling to upper method.


Throwing an exception

```java
package pl.edu.wsb_nlu.java.lecture4.exceptions;

public class Throwing3 {

    public static void throwException() throws Exception {
        throw new Exception("This is message");
    }

    public static void main(String[] args) throws Exception{
        throwException();
    }
}
```

This is not recommended, but it compiles.



Writing to file

```java
package pl.edu.wsb_nlu.java.lecture4.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingBufferedWriter {
public static void main(String[] args) throws IOException {
BufferedWriter writer = new BufferedWriter(new FileWriter("file2.txt"));
writer.write("My message");
writer.close();
}
}
```



An alternative way of writing to file

```java
package pl.edu.wsb_nlu.java.lecture4.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWritingNIO {
public static void main(String[] args) throws IOException {
Path path = Paths.get("file3.txt");
Files.write(path, "I love Java!".getBytes());
}
}
```



Interfaces

An interface in the Java programming language is an abstract type that is used to specify a behavior that classes must implement. Let's recall our Rectangle and Circle classes from last lecture.



Interfaces

```java
package pl.edu.wsb_nlu.java.lecture4.interfaces;

public interface Shape{

    double getArea();
    double getPerimeter();

}
```

We can create an interface of Shape instead of abstract class. What are the differences between them?



Interfaces

```java
package pl.edu.wsb_nlu.java.lecture4.interfaces;

public class Circle implements Shape {
private double r;

    public Circle(double r){
        this.r = r;
    }
    public double getArea(){
        return Math.PI * r * r;
    }
    public double getPerimeter(){
        return 2 * Math.PI * r;
    }

}
```

We can create an interface of Shape instead of abstract class. What are the differences between them?



Interface and abstract class

 *  A java class can implement multiple interfaces but extend only one abstract class.
 *  Implementation: Abstract class can provide the implementation of the interface. Interface can’t provide the implementation of an abstract class.
 *  Multiple implementations: An interface can extend another Java interface only, an abstract class can extend another Java class and implement multiple Java interfaces.
 *  Accessibility of Data Members: Members of a Java interface are public by default. A Java abstract class can have class members like private, protected, etc.


Source: \href{https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/}{https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/}

As we see, an interface and abstract class are very similar - they differs in details.


Implementation of multiple interfaces

```java
package pl.edu.wsb_nlu.java.lecture4.interfaces;

public interface Drawable {
void draw();
}
```

```java
package pl.edu.wsb_nlu.java.lecture4.interfaces;

public class Circle2 implements Shape, Drawable {
private double r;

    public Circle2(double r){
        this.r = r;
    }
    public double getArea(){return Math.PI * r * r;}
    public double getPerimeter(){return 2 * Math.PI * r;}
    public void draw() {
// implementation
}
}
```



Default implementation of method
```java
package pl.edu.wsb_nlu.java.lecture4.interfaces_default_method;

public interface Drawable {
default void draw(){
System.out.println("------------");
}
}
```

Since Java 8 interfaces can contain a default implementation of the method. In this case we do not have to implement this kind of method in class which implements the interface.




Default implementation of method
```java
package pl.edu.wsb_nlu.java.lecture4.interfaces_default_method;

public class Circle implements Shape, Drawable {
private double r;

    public Circle(double r){this.r = r;}
    public double getArea(){return Math.PI * r * r;}
    public double getPerimeter(){return 2 * Math.PI * r;}
    public void draw() {
        Drawable.super.draw();
        // additional code
        }
    }
}
```

In class which implements the interface we can call methods which have default implementations.


Final fields and methods
```java
package pl.edu.wsb_nlu.java.lecture4.final_keyword;

public class MyClass {
static final int myValue = 5;
final int myValue3;

    MyClass(int value){
        this.myValue3 = value;
    }

    final void printValue3(){
        System.out.println(myValue3);
    }

}
```

Final fields can be set only once. Final method cannot be overridden.




Final fields and methods
```java
package pl.edu.wsb_nlu.java.lecture4.final_keyword;

public class MainFinal {
public static void main(String[] args) {
//        MyClass.myValue = 10;
System.out.println(MyClass.myValue);
MyClass myClass = new MyClass(1);
//        myClass.myValue3 = 2;
System.out.println(myClass.myValue3);
}
}
```

Final fields can be set only once. After uncommenting any of the commented lines the code will not compile.



Final fields and methods
```java
package pl.edu.wsb_nlu.java.lecture4.final_keyword;

public class MyClassChild extends MyClass {

    MyClassChild(){super(10);}

//    void printValue3(){
//        System.out.println("Value3 will be printed");
//        System.out.println(myValue3);
//    }
}
```

Final methods cannot be overridden. After uncommenting the commented lines the code will not compile.

By keyword 'super' we access the parent class (its constructor in this case).



Fields in interfaces

```java
package pl.edu.wsb_nlu.java.lecture4.final_keyword;

public interface MyInterface {
double pi = 3.14;
// It's the same as: final static double pi = 3.14;
}
```

Interfaces can contain only final static fields. If we do not provide those keywords, the field will be threaten as if they are present.



Interface inheritance

```java
package pl.edu.wsb_nlu.java.lecture4.final_keyword;

public interface MyChildInterface extends MyInterface /*, OtherInterface*/ {
double e = 2.78;
}
```

An interface can extend another interface (or several interfaces separated by commas).



Example Exam Question
(Multiple choice)

A,B are classes, C,D are interfaces. Proper definition of E can start with the following:

 *  class E extends A, B
 *  class E extends A implements C
 *  class E implements C, D
 *  interface E extends A
 *  interface E extends C, D




Diamond problem

\begin{figure}
\centering
\includegraphics[width=0.25\linewidth]{diamond.png}
\end{figure}

If A,B,C are interfaces, B,C can each provide a different implementation to an abstract method of A, causing the diamond problem. Class D must reimplement the method (the body of which can simply call one of the parent implementations), or we will get a compile error.



\end{document}
