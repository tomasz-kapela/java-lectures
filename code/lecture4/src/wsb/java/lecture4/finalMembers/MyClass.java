package wsb.java.lecture4.finalMembers;

public class MyClass {
    static final int staticValue = 5;
    final int finalValue;
    //  final int finalValue = 1;   // ERROR: Two initializations

    final int finalWithDefaultValue = 2;
    //  final int finalValueUnitialized;  // ERROR: Unitialized


    MyClass(int value){
        this.finalValue = value;
    }

    final void printValue(){
        System.out.println(finalValue);
    }
}