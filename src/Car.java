public class Car {


    String brand = "??";
    double fuel = 0;
    double mileage = 0;

    public void drive(double distance) {
        double fuelNeeded = distance / 10.0;
        if (fuel > fuelNeeded)
            fuel -= fuelNeeded;
        else
            fuel = 0;
    }

    public void refuel(double amount) {

    }

    public static void main(String[] args) {

    }
}
