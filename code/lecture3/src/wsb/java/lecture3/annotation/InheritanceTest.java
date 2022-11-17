package wsb.java.lecture3.annotation;


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

public class InheritanceTest {
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
