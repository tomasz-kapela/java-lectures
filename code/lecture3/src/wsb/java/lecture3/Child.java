package wsb.java.lecture3;
// superclass
class Parent{
    public int x = 0;
    protected int y = 0;

    static int z = 1;

    private int w = 2;

    public int getW(){
        return w;
    }
    public int compute(){
        return w - z;
    }

    public static int stat(){
        return z+4;
    }
}


// subclass
public class Child extends Parent {
    int a =1;
  //  int y = 5;

    // hides
    public static int stat(){
        return z+5;
    }
    // override
    public int compute(){
        return a * getW() - z;
    }
    // overload
    public int compute(int n){
        return a * getW() - n * z;
    }

    public int f(){
        x = 10;

        z = super.y;

        z = compute();

        z = stat();

        return x + y + z + getW();
    }
    public static void main(String[] args) {

        MyClass o = new MyClass();
        System.out.println(o.getClass().getName());
        System.out.println(o.toString());

        System.out.println(o);


    }

}

class MyClass{
    @Override
    public String toString() {
        return "MyClass!!";
    }
}

