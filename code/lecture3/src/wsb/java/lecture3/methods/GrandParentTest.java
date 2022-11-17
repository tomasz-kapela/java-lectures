package wsb.java.lecture3.methods;

class GrandParent{
    public void print(){
        System.out.println("GrandParent");
    }
}

class Parent extends GrandParent{
    public void print(){
        System.out.println("Parent");
    }
}

class Child extends Parent{
    public void print(){
        System.out.println("Child");
        super.print();
       // super.super.print();
       // ((GrandParent)this).print();
    }
}
public class GrandParentTest {
    public static void main(String[] args) {
        Child child = new Child();
        child.print();
    }
}
