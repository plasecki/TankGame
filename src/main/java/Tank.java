public class Tank extends Vehicle {
    public Tank(int[] initialLocation, int initialFuel) {
        super(initialLocation, initialFuel, 10, 1, 80);
    }

    public void printCurrentLocation() {
        System.out.println("");
        System.out.println("Current Tank location: ");
        System.out.println("x = " + getCoordinateX());
        System.out.println("y = " + getCoordinateY());
        System.out.println("");
    }

    public void printVehicleDetails() {
        System.out.println("Tank: engine 5.0, fauel: diesel");
        System.out.println("");
    }
}
