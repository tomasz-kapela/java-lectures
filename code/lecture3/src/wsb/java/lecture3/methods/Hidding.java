package wsb.java.lecture3.methods;


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
        System.out.println(animal.getName());
        System.out.println(animal.getType());
        animal.print();


        Dog dog = new Dog();
        System.out.println(dog.getName());
        System.out.println(dog.getType());
        dog.print();

        Animal xx = new Dog();
        //Dog xx = new Dog();

        xx.print();
        System.out.println(xx.getName());
        System.out.println(xx.getType());
      //  System.out.println(xx.name);

    }
}
