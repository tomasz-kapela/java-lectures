--- 
title: Java - Inheritance
author: Tomasz Kapela 
theme: Copenhagen 
date: October 17, 2022
---

[//]: # (
Inheritance 
Abstract methods and classes
Object class
Annotations
)


# Point class example

```java 
public class Point {
    private double x = 0;
    private double y = 0;

    public Point(double x, double y){
       this.x = x;
       this.y = y;
    }
    public void print() {
        System.out.println("(" + x + " ," + y + ")");
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
```

# LabelledPoint class example

We can extend class Point by adding label.
```java 
public class LabelledPoint {
    private double x = 0;
    private double y = 0;
    private String label = "A";
    
    public LabelledPoint(String label, double x, double y){
        this.x = x;
        this.y = y;
        this.label = label;
    }
    public void print() {
        System.out.println( label + "(" + x + " ," + y + ")");
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
```

There is a lot of copy-paste code in the new class!!!

Write **DRY** code - **D**on't **R**epeat **Y**ourself!!! 

# LabelledPoint with inheritance 

```java 
public class LabelledPoint extends Point {
    private String label = "A";

    public LabelledPoint(String label, double x, double y){
       super(x,y);   // Calls constructor of a base class
       this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public void print() {
        System.out.print( label) ;
        super.print(); // Calls print from the base class
    }
    
    public void printWithGet() {
        System.out.println( label + "(" + getX() + " ," + getY() + ")");
    }
}
```

# Inheritance

>  A class that is derived from another class is called a **subclass** 
> (also a **derived class**, extended class, or **child class**). 
 
> The class from which the subclass is derived is called a **superclass** 
> (also a **base class** or a **parent class**).

```java
// superclass 
class Parent{
}

// subclass
class Child extends Parent {
}
```

A subclass 

*  inherits all members (fields, methods, static methods, nested classes) from a base class.
*  does not inherit constructors (they are not members).
*  can directly use public and protected members (fields and methods).
*  can directly use package-private members if it is defined in the same package as a base class.
*  can use private members only if there are public or protected accessors.    
*  can declare new fields and methods.
*  can **hide** a field - declare a field  with the same name as the one in the superclass (not recommended).
*  can **override** a (instance) method - write a new method with the same signature as the one in the superclass.
*  can **hide** a static method -  write a new static method in the subclass that has the same signature as the one in the superclass.
*  can **overload** a method - write a new method with the same name but with different parameters.   
*  can write a subclass constructor that invokes the constructor of the superclass, 
   either implicitly or by using the keyword *super*.

# The keyword **super**

The keyword **super** is used to access constructors of a base class.

```java
    public LabelledPoint(String label, double x, double y){
       super(x,y);   // Calls constructor of a base class
       this.label = label;
    }
```

*  Invocation of a superclass constructor must be the first line in the subclass constructor.
*  If a constructor does not call superclass constructor explicitly, then the default constructor will be callled.
   If there is no default constructor in the base class, one will get compilation error.



The keyword **super**  can be used to access fields and methods of a base class (especially if they are hidden or overridden)

```java 
 public void print() {
        System.out.print( label) ;
        super.print();
 }
```

# Access to GrandParents members 

If on of the GrandParent's field or method is shadowed or overridden in the Parent class 
then it cannot be directly accessed in the Child class. 

```java 
class 
public void print() {
System.out.print( label) ;
super.print();
}
```



# BaseClass References

`LabelledPoint` is descent from `Point` (because inherits from it). 

Therefore `LabelledPoint` **is a** `Point` and can be used wherever `Point` can be used.

```java 
 Point p = new LabelledPoint("P", 1, 2);
```

The reverse is not necessarily true: a `Point` can have a label, but not always.

```java 

        LabelledPoint c = new LabelledPoint("C", 0 ,0);

        // Implicit casting
        Point p = c;
        Object o = c;

        p.getX();
        // p.getLabel(); // Compilation ERROR!

        // LabelledPoint l = p; // Compilation ERROR!

        // Explicit casting
        LabelledPoint l2 = (LabelledPoint) p;
        l2.getLabel();

        Point p3 = new Point(0., 0.);
        // LabelledPoint l3 = (LabelledPoint) p3; // Run-time error

        // We can check if p refers to and object of type LabelledPoint (or its subclass)
        if(p instanceof LabelledPoint) {
            LabelledPoint l4 = (LabelledPoint) p;
            System.out.println(l4.getLabel());
        }
```


# Circle and Rectangle class examples 

```java
public class Circle {
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

This is an example class of circle. It allows us to compute its area or perimeter when needed.

```java
public class Rectangle {
    private double a;
    private double b;
    
    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double getArea(){
        return a * b;
    }
    public double getPerimeter(){
        return 2 * (a + b);
    }
}
```

This is an example class of a rectangle.
It allows us to compute its area or perimeter when needed.

**What have those shapes in common?**

# Inheritance

```java
package pl.edu.wsb_nlu.java.lecture3.shapes;

public class Shape {

    public double getArea(){
        return 0;
    }

    public double getPerimeter(){
        return 0;
    }

}
```

We can create a 'parent' class Shape. 
Then we can inherit from this class, so we will have:

```java
public class Circle extends Shape {...}
public class Rectangle extends Shape {...}
```

# Inheritance

```java
public class Main {

    private static void prettyPrint(Shape shape){
        System.out.println("Perimeter of this shape is: " + Math.round(shape.getPerimeter()*10)/10.0);
        System.out.println("Area of this shape is: " + Math.round(shape.getArea()*10)/10.0);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(2,4);
        prettyPrint(circle);
        prettyPrint(rectangle);
    }
}

```

# Hidding vs Overring

```java 
class Animal{
public String getName(){
return "None";
}
public  static String getType(){
return "Animal";
}
public void print(){
System.out.println("I am " + getType() + " with name " + getName());
}
}

class Dog extends Animal{
public String getName(){
return "Azor";
}
public  static String getType(){
return "Dog";
}

}

public class Hidding {
public static void main(String[] args) {
Animal animal = new Animal();
animal.print();

        Dog dog = new Dog();
        dog.print();

        Animal xx = new Dog();
        //Dog xx = new Dog();

        xx.print();
        System.out.println(xx.getName());
        System.out.println(xx.getType());

    }
}
```

# Modifiers

The access specifier for an overriding method can allow more, but not less, 
access than the overridden method. For example, 
a protected instance method in the superclass can be made public, but not private, in the subclass.

You will get a compile-time error if you attempt to change an instance method in the superclass 
to a static method in the subclass, and vice versa.


# No Multiple Inheritance

>  In Java we can inherit only from one class. 
> 
>  Multiple inheritance is not allowed!

Partial solution: Interfaces




# Abstract class

We can add one small improvement to our figure classes. 
As we probably would not create any object of Shape class 
we can make this class abstract.

```java

public abstract class Shape {

    public abstract double getArea();

    public abstract double getPerimeter();

}
```
If we use keyword 'abstract' in method signature 
we make possible to not provide an implementation. 
We force programmer who want to use our base class to implement this method in child class.

# Abstract classes
```java
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(2,4);
//        Shape shape = new Shape();
    }
}
```

As we mark class Shape as abstract, we are unable to create an instance of this class.


# Object class

There exists a special class **Object** that is at the top of the class hierarchy. 
All other classes (even those created by user) inherit from it.

If you do not specify explicitly superclass then the class Object will be a direct superclass. 

```java 
class MyClass{
}
```

is equivalent to 

```java 
class MyClass extends Object{
}
```

# Object class

Since every class is child class of Object, 
it has access to all its methods. 
Some of them that are often overridden:

*  `public String toString()`

   Returns a string representation of the object.

*  `public boolean equals(Object obj)`

   Indicates whether some other object is "equal to" this one.

*  `protected Object clone() throws CloneNotSupportedException`
   
   Creates and returns a copy of this object.
*  `protected void finalize() throws Throwable`
   
   Called by the garbage collector on an object when garbage  collection determines that there are no more references to the object

*  `public final Class getClass()`
   
    Returns the runtime class of an object.

*  `public int hashCode()`
   
   Returns a hash code value for the object.


# Method toString

```java
public class CirclePositioned extends Circle {
  private double x;
  private double y;
  public CirclePositioned(double r, double x, double y) {
    super(r); //we call here a constructor of parent class
    this.x = x;
    this.y = y;
  }
  public String toString() {
    return "Circle of area: " + getArea() + " and perimeter: " + getPerimeter() 
    + " at point (" + x + "," + y + ")";
  }
}

```

Method toString() is executed when an object is casted (not always explicitly) to a String.

```java
public class Main {
  public static void main(String[] args) {
    CirclePositioned myCircle = new CirclePositioned(5, 2, 2);
    System.out.println(myCircle);
  }
}
```

# Method equals

The default method `equals` compares references

```java 
CirclePositioned a = new CirclePositioned(1,2,3);
CirclePositioned b = new CirclePositioned(1,2,3);
CirclePositioned c = a;

a.equals(b);  //false
a.equals(c);  //true
```

We can override it

```java
public boolean equals(Object o) {
  if (this == o) 
    return true;
  if (o == null || getClass() != o.getClass()) 
    return false;
  CirclePositioned that = (CirclePositioned) o;
  return Double.compare(that.x, x) == 0 
        && Double.compare(that.y, y) == 0 
        && Double.compare(that.r, r) == 0;
}
```


```java 
CirclePositioned a = new CirclePositioned(1,2,3);
CirclePositioned b = new CirclePositioned(1,2,3);
CirclePositioned c = a;

a.equals(b);  //true
a.equals(c);  //true
```

# Method hashCode

Method `hashCode()` is used by many Java builtin Collections like HashMap for performance purposes.


```java
public int hashCode() {
  return Math.round((float) (x * y * r));
}
```

>  The object equals contract indicates that when two objects are equal, 
>  their hash codes must also be the same.

If hash codes are the same, the objects do not have to be equal 
but using hashCode method allows us to know for sure that objects are not the same.
    

[More on Object class methods](https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html)


# The **`final`** keyword

```java 
class Animal{

  final public String getName(){
    return "None";
  }
  final public  static String getType(){
    return "Animal";
  }
}

final class Dog extends Animal{
  // ERROR!
  // public String getName(){
  //  return "Azor";
  // }
  
  // ERROR!
  // public  static String getType(){
  //  return "Dog";
  //} 
}

/// ERROR!
class BudDog extends Dog {
}

```

# Wrong overriding

```java 
class Animal{
public String getName(){
return "None";
}
public  static String getType(){
return "Animal";
}
public void print(){
System.out.println("I am " + getType() + " with name " + getName());
}
}

class Dog extends Animal{

  public String getNames(){
    return "Azor";  
  }
  public  static String getType(){
    return "Dog";
  }
}

public class Hidding {
public static void main(String[] args) {
Animal animal = new Animal();
animal.print();

        Dog dog = new Dog();
        dog.print();

        Animal xx = new Dog();
        //Dog xx = new Dog();

        xx.print();
        System.out.println(xx.getName());
        System.out.println(xx.getType());

    }
}
```

# Annotation @Override

```java 
class Animal{
public String getName(){
return "None";
}
public  static String getType(){
return "Animal";
}
public void print(){
System.out.println("I am " + getType() + " with name " + getName());
}
}

class Dog extends Animal{
  @Override
  public String getNames(){
    return "Azor";  
  }
  public  static String getType(){
    return "Dog";
  }
}

public class Hidding {
public static void main(String[] args) {
Animal animal = new Animal();
animal.print();

        Dog dog = new Dog();
        dog.print();

        Animal xx = new Dog();
        //Dog xx = new Dog();

        xx.print();
        System.out.println(xx.getName());
        System.out.println(xx.getType());

    }
}
```



