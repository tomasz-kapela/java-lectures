--- 
title: Java - Interfaces
author: Tomasz Kapela
theme: Copenhagen
date: November 17, 2022
---

[//]: # (
Interfaces
Polymorphism
Final, sealed method and classes
Exceptions, Files
)


# Materials
https://dev.java/learn/interfaces/

# Some class examples




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

We can create a 'parent' class Shape. Then we can inherit by this class, so we will have:

```java
public class Circle extends Shape
public class Rectangle extends Shape
```

# Inheritance

```java
package pl.edu.wsb_nlu.java.lecture3.shapes;

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




# Inheritance

At slide before we saw an advantage of using inheritance but remember: in Java we can inherit only by one class. Multiple inheritance is not allowed!




# Abstract class

We can add one small improvement to our figure classes. As we probably would not create any object of Shape class we can make this class abstract.

```java
package pl.edu.wsb_nlu.java.lecture3.abstractShapes;

public abstract class Shape {

    public abstract double getArea();

    public abstract double getPerimeter();

}
```
If we use keyword 'abstract' in method signature we make possible to not provide an implementation. We force programmer who want to use our base class to implement this method in child class.



# Abstract classes
```java
package pl.edu.wsb_nlu.java.lecture3.abstractShapes;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(2,4);
//        Shape shape = new Shape();
}
}
```

As we mark class Shape as abstract, we are unable to create an instance of this class.



# Inheritance and Object class

    There exists a special class called Object. All other classes (even those created by user) inherit by it.

```java
package pl.edu.wsb_nlu.java.lecture3.object;

import pl.edu.wsb_nlu.java.lecture3.abstractShapes.Circle;
import pl.edu.wsb_nlu.java.lecture3.abstractShapes.Shape;

public class IsInstance {
public static void main(String[] args) {
Circle circle = new Circle(5);
System.out.println(Circle.class.isInstance(circle));
System.out.println(Shape.class.isInstance(circle));
System.out.println(String.class.isInstance(circle));
System.out.println(Object.class.isInstance(circle));
}
}
```

# Inheritance and Object class

Since every class is child class of Object, it has access to all its methods. Some of them are often overriden:

*  toString()
*  equals()
*  hashCode()





# Inheritance and Object class

```java
package pl.edu.wsb_nlu.java.lecture3.object;
import pl.edu.wsb_nlu.java.lecture3.abstractShapes.Circle;
public class CirclePositioned extends Circle {
private double x;
private double y;
public CirclePositioned(double r, double x, double y) {
super(r); //we call here a constructor of parent class
this.x = x;
this.y = y;
}
public String toString() {
return "Circle of area: " + getArea() + " and perimeter: " + getPerimeter() + " at point (" + x + "," + y + ")";
}
}

```


# Inheritance and Object class

Method toString() is executed when an object is casted (not always explicitly) to a String.

```java
package pl.edu.wsb_nlu.java.lecture3.object;

public class Main {
public static void main(String[] args) {
CirclePositioned myCircle = new CirclePositioned(5, 2, 2);
System.out.println(myCircle);
}
}
```




# Inheritance and Object class

    Let's look at custom implementation of methods hashCode() and equals() (CirclePositioned).

```java
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
CirclePositioned that = (CirclePositioned) o;
return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && Double.compare(that.r, r) == 0;
}

    public int hashCode() {
        return Math.round((float) (x * y * r));
    }
```

# Inheritance and Object class
The object equals contract indicates that when two objects are equal, their hash codes must also be the same.

    If hash codes are the same, the objects do not have to be equal but using hashCode method allows us to know for sure that objects are not the same.
    
    This is used by many Java builtin Collections like HashMap for performance purposes.


