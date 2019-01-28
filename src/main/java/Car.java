public class Car extends Vehicle {

    public Car(int[] initialLocation, int initialFuel) {
        super(initialLocation, initialFuel, 5, 1, 50);
    }

    public void printCurrentLocation() {
        System.out.println("");
        System.out.println("Current Car location: ");
        System.out.println("x = " + getCoordinateX());
        System.out.println("y = " + getCoordinateY());
        System.out.println("");
    }

    public void printVehicleDetails() {
        System.out.println("Car: engine 2.0, fauel: diesel");
        System.out.println("");
    }

}
