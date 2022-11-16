--- 
title: Java - Classes 
author: Tomasz Kapela 
theme: Copenhagen 
date: October 17, 2022
---

# JAVA is OOP language

### Structured Programming (Procedural Programming):
- functions perform operations on the data
- data are separated from functions

### **OOP** = *Object-Oriented Programming*
- objects contain both data and methods.
- objects model real-word objects: they have attributes (states) and behaviours.
- classes are blueprints (templates) used to create objects.
- objects are instances of a class.

---

# Advantages of OOP

- better model of a real world.
- helps writing reusable code.
- bigger classes are composed from smaller classes. 
- makes the code easier to maintain, modify and debug.

---

# Classes

A class is an extensible template for creating objects,
providing initial values for state (member variables) and 
implementations of behavior (member functions or methods).




---


# Creating a class

**Java source files may contain only one top public class.**

Example: Car.java file:
```java
public class Car {
    // Fields - attributes
    String brand = "??";
    double mileage = 0;

    public static void main(String[] args) {
        // We create an object of Car using default constructor
        Car volvo = new Car();
        System.out.println("Car " + volvo.brand + " with mileage " + volvo.mileage + " km.");
        volvo.brand = "Volvo";
        System.out.println("Car " + volvo.brand + " with mileage " + volvo.mileage + " km.");
    }
}
```

In Java we cannot create a function without a class, what was possible in C++.

---

# Constructors
```java
ublic class Car {
    // Fields - attributes
    String brand = "??";
    double mileage = 0;

    // Constructor with two parameters
    public Car(String brand, double initialMileage){
        // we use this.brand to refer to field that is hidden by parameter
        this.brand = brand;  
        mileage = initialMileage;
    }

    public void showInfo(){
        System.out.println("Car " + brand + " with mileage " + mileage + " km.");
    }
    public static void main(String[] args) {
        // We create an object of Car
        Car volvo = new Car("Volvo", 0);
        volvo.showInfo();
        volvo.brand = "Ford";
        volvo.showInfo();
        // Car fiat = new Car(); // ERROR
    }
}
```
**If we add our own constructor then the default constructor is not auto generated.**

# Constructors

We can define any number of constructors, but they need to have different parameters list.

```java

public class Car {
    // Fields - attributes
    String brand = "??";
    double mileage = 0;

    public Car(){
    }
    public Car(String brand){
        this.brand = brand;
    }
    public Car(String brand, double mileage){
        this.brand = brand;
        this.mileage = mileage;
    }
    public void showInfo(){
        System.out.println("Car " + brand + " with mileage " + mileage + " km.");
    }

    public static void main(String[] args) {
        // We create an object of Car1
        Car volvo = new Car("Volvo");
        volvo.showInfo();

        Car fiat = new Car();
        fiat.showInfo();
        fiat.brand = "Fiat";
        fiat.showInfo();
    }
}
```

# Constructors - delegation

```java 
public class Car {
    // Fields - attributes
    String brand = "??";
    double mileage = 0;

    public Car(){
        // we call more general constructor
        this("Unknown", 0.0);
    }
    public Car(String brand){
        // we call more general constructor
        this(brand, 1000.0);
    }
    public Car(String brand, double mileage){
        this.brand = brand;
        this.mileage = mileage;
    }
    public void showInfo(){
        System.out.println("Car " + brand + " with mileage " + mileage + " km.");
    }

    public static void main(String[] args) {
        // We create an object of Car1
        Car volvo = new Car("Volvo");
        volvo.showInfo();


        Car fiat = new Car();
        fiat.showInfo();
        fiat.brand = "Fiat";
        fiat.showInfo();
    }
}
```

# Initialization blocks

Initialization blocks are blocks of code inside class without any constructor or method header. 
```java
public class MyClass{
   {
     // Initialization block
   }
}
```

Initialization blocks are executed whenever the class is initialized and before constructors are invoked.
```java
public class Car {
    // Fields - attributes
    String brand = "??";
    double mileage = 0;
    
    {
        System.out.println("Setting up car.");
        brand = "Unknown";
    }
    public Car(){}
    public Car(String brand){
        this.brand = brand;
    }
    public Car(String brand, double mileage){
        this.brand = brand;
        this.mileage = mileage;
    }
    public void showInfo(){
        System.out.println("Car " + brand + " with mileage " + mileage + " km.");
    }

    public static void main(String[] args) {
        // We create an object of Car1
        Car volvo = new Car("Volvo");
        volvo.showInfo();


        Car fiat = new Car();
        fiat.showInfo();
        fiat.brand = "Fiat";
        fiat.showInfo();
    }
}
```
[More on initialization blocks](https://www.geeksforgeeks.org/instance-initialization-block-iib-java/#:~:text=Initialization%20blocks%20are%20executed%20whenever,include%20them%20in%20your%20classes.)

---

# Methods


---

# Methods parameters

In Java all parameters are passed by value. 

* Built-in types are copied.
* Reference types: we pass by value its reference.

```java 
class Int{
    private int x = 0;
    public Int(int x){
        this.x = x;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return ""+x;
    }
}

public class Methods {
    public static int f(int x){
        x+= 10;
        return x+5;
    }
    public static Int f(Int x){
        x.setX(x.getX() + 10);
        return new Int(x.getX()+5);
    }
    public static void main(String[] args) {

        {
            int x = 5;
            var fx = f(x);
            System.out.println("int x = " + x + "  f(x) = " + fx);
        }
        {
            Int x = new Int(5);
            var fx = f(x);
            System.out.println("Int x = " + x + "  f(x) = " + fx);
        }
    }
}
```

---

# Example 

```java 
package lecture2;

public class Car {
    //
    private String brand = "??";
    private double mileage = 0;
    private double fuel = 0;
    private double fuelConsumption = 10; // liters per km

    public Car(String brand, double fuel){
        this.brand = brand;
        this.fuel = fuel;
    }
    public Car(String brand){
        this.brand = brand;
        this.fuel = 0;
    }
    public void drive(double distance) {
       if(distance>0) {
           double fuelNeeded = distance * getFuelConsumption() / 100.0;
           if(getFuel() >= fuelNeeded) {
               fuel = getFuel() - fuelNeeded;
           } else {
               distance = getFuel() / getFuelConsumption() * 100;
               fuel = 0;
           }
           mileage = getMileage() + distance;
       }
    }
    public void refuel(double amount){
        if(amount>0){
            fuel = getFuel() + amount;
        }
    }
    public void showInfo(){
        System.out.println("Car " + getBrand()
                + ", mileage :" + getMileage() + " km, fuel : "+ getFuel() + " l.");
    }
    public String getBrand() {
        return brand;
    }
    public double getMileage() {
        return mileage;
    }
    public double getFuel() {
        return fuel;
    }
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public static void main(String[] args) {
        Car mycar = new Car("Volvo", 70);
        mycar.showInfo();
        mycar.drive(100);
        mycar.showInfo();
    }
}
```

---

# Static keyword

To run program we need main static method. 
Keyword 'static' means that it is a method not connected to any object of this class.

---

# Static fields - class variables

Static fields are used to represent attibutes that are common for all objects of given class.

Static fields are called also class variables. 

```java 
public class FordMustang {
    // common name for all objects, cannot be changed
    public final static String brand="Ford Mustang";
    // individual serial number for each object
    private int serialNumber;
    // class variable that stores last serial number used
    private static int lastSerialNumber = 0;
    // initialization block (common for all constructors)
    {
        serialNumber = ++lastSerialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNumberOfCars() {
        return lastSerialNumber;
    }

    @Override
    public String toString() {
        return brand + " no. " + serialNumber;
    }

    public static void main(String[] args) {
        FordMustang ford1 = new FordMustang();
        var ford2 = new FordMustang();
        new FordMustang();
        FordMustang ford3 = null;

        System.out.println("" + ford1);
        System.out.println("Number of cars : " + ford1.getNumberOfCars());

        for(int i=0; i<20; i++){
            ford3 = new FordMustang();
        }

        System.out.println("" + ford3);
        // Static fields and methods can be accessed through class name
        System.out.println("Number of " + FordMustang.brand + " : " 
                            + FordMustang.getNumberOfCars());
    }
}
```

---

# Static methods

**Static methods** do not have reference *this* that point to current object
and cannot use any non-static field or method of a given class.

```java 
public class MyClass{
   public int number = 4;
   public int getNumber() { return number; }
   public static int staticMethod() {
       int x = number;     /// ERROR: use of non-static field
       return x + getNumber();  /// ERROR: getNumber is not static
   }
}
```

Static methods can be called without any object of a class. 
```java 
public class MyClass{
   public static void staticMethod() {}
}
// Static method can be called using class name
MyClass.staticMethod();

// Or any object of a class
MyClass object = null;
object.staticMethod();
```

---

# Packages

A package in Java is used to group related classes. We can think of it as a folder in a file directory. We use packages to avoid name conflicts, and to write a better maintainable code.

It is good practice to name your user-defined package with the domain of your company 
or organisation you represent. 

For example in this lecture all example packages and classes could be inside package:
```java
pl.edu.wsb_nlu.java
```

---

# How to import class?

This practice is common in majority of open source projects, which helps us to avoid name conflicts. There are also build-in packages, we can use, like Scanner:

```java
package pl.edu.wsb_nlu.java.lecture3;

// Import single class 
import java.util.Scanner;

// or import all classes present in java.util package.
// import java.util.*;

class UseScanner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}
```

---

# How to import class?

We do not need to import classes from the same package:

```java
package pl.edu.wsb_nlu.java.lecture3;

//Line below is not needed
//import pl.edu.wsb_nlu.java.lecture3.Hello;

// But we need to import classes for subpackage
import pl.edu.wsb_nlu.java.lecture3.subpackage1.HelloSubpackage1;

public class UseHello {
  public static void main(String[] args) {
    Hello.main(args);
    HelloSubpackage1.main(args);
  }
}
```


---

# How to import class?

Every Java file behaves as if there is 'import java.lang.*' in the import section. There are 3 classes: Math, String and System.

```java
package pl.edu.wsb_nlu.java.lecture3;

// There is no 'import java.lang.Math;' needed

public class MathExample {
  public static void main(String[] args) {
    System.out.println(Math.cos(0));
    System.out.println(Math.min(10,-999.1));
  }
}
```




---

# Access modifiers

Main method needs to be public. It refers to that, it can be used by any other class. 

In java we have 4 access modifiers:

*  public
*  protected
*  default (no keyword)
*  private

```java
package pl.edu.wsb_nlu.java.lecture3.subpackage2;

public class AccessModifiers {

    public static void testPublic(){
        System.out.println("Public method test");
    }
    protected static void testProtected(){
        System.out.println("Protected method test");
    }
    static void testDefault(){
        System.out.println("'Default' method test");
    }
    private static void testPrivate(){
        System.out.println("Private method test");
    }
}
```

Public method or field can be accessed from any other class or package.

Protected method can be accessed in the same package or via inheritance (which will be described later).

Method with 'default' access modifier can be accesed only by classes in the same package.

Private method can be accessed only in class where they are defined.

---

# Access withing the same package
```java
/// File AccessModifiers.java
package pl.edu.wsb_nlu.java.lecture3.subpackage2;
public class AccessModifiers {
    public static void testPublic(){}
    protected static void testProtected(){}
    static void testDefault(){}
    private static void testPrivate(){}
}
```
Class in the same package
```java
File AccessModifiers.java
package pl.edu.wsb_nlu.java.lecture3.subpackage2;

public class AccessModifiersSamePackage {

    public static void main(String[] args) {
        AccessModifiers.testPublic();
        AccessModifiers.testProtected();
        AccessModifiers.testDefault();
//        AccessModifiers.testPrivate();
}
}

```

---


# Access from other package
```java
/// File AccessModifiers.java
package pl.edu.wsb_nlu.java.lecture3.subpackage2;
public class AccessModifiers {
    public static void testPublic(){}
    protected static void testProtected(){}
    static void testDefault(){}
    private static void testPrivate(){}
}
```
Class in the other package
```java
package pl.edu.wsb_nlu.java.lecture3.subpackage3;

import pl.edu.wsb_nlu.java.lecture3.subpackage2.AccessModifiers;

public class AccessModifiersAnotherPackage {

    public static void main(String[] args) {
        AccessModifiers.testPublic();
//        AccessModifiers.testProtected();
//        AccessModifiers.testDefault();
//        AccessModifiers.testPrivate();
    }
}
```


---

# Access from subclass in the other package
```java
/// File AccessModifiers.java
package pl.edu.wsb_nlu.java.lecture3.subpackage2;
public class AccessModifiers {
    public static void testPublic(){}
    protected static void testProtected(){}
    static void testDefault(){}
    private static void testPrivate(){}
}
```
Subclass in the other package

```java
package pl.edu.wsb_nlu.java.lecture3.subpackage3;

import pl.edu.wsb_nlu.java.lecture3.subpackage2.AccessModifiers;

public class AccessModifiersChildAnotherPackage extends AccessModifiers {
  public static void main(String[] args) {
  AccessModifiers.testPublic();
  AccessModifiers.testProtected();
  //        AccessModifiers.testDefault();
  //        AccessModifiers.testPrivate();
 }
}
```


# Accessors - Getters and Setters

```java
package pl.edu.wsb_nlu.java.lecture3.accessors;

public class MyClass {
    private int field;

    public int getField() {
        return field;
    }
    public void setField(int value) {
        this.field = value;
    }
}
```

Making all the fields as private is a good practice. 
Usually we create the several public methods called accessors 
which allows us to manipulate the field's value. 
Methods which return value are called getters. 
The ones which change values are called setters.

Common practice is to name accessors of the field `xxx`
*  `getXxx` - for getter.
*  `setXxx` - for setter.

---

# Accessors

```java
package pl.edu.wsb_nlu.java.lecture3.accessors;

public class MyClass {
private int j;

    public double getJ() {
        return j;
    }
    public void setJ(double j) {
        this.j = j;
    }

}
```

For instance, intellij IDE can generate setters and getters for us automatically.

---
