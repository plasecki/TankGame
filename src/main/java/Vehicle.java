
import java.util.HashMap;


public class Vehicle {
    private HashMap<String, Integer> location = new HashMap();
    private int fuel;
    private int fuelDecreaseInterval;
    private int fuelAward;
    private int vehicleSize;

    public Vehicle(int[] initialLocation, int initialFuel, int initialFuelInterval, int size, int award) {
        System.out.println("Vehicle created");
        location.put("x",initialLocation[0]);
        location.put("y",initialLocation[1]);
        fuel = initialFuel;
        fuelAward = award;
        fuelDecreaseInterval = initialFuelInterval;
        vehicleSize = size;
    };

    private int getCoordinateX() {
        return location.get("x");
    };

    private int getCoordinateY() {
        return location.get("y");
    }

    private void increaseCoordinateX(int increaseInterval) {
        int x = getCoordinateX();
        location.put("x", x + increaseInterval);
    };

    private void increaseCoordinateY(int increaseInterval) {
        int y = getCoordinateY();
        location.put("y", y + increaseInterval);
    };

    private void decreaseCoordinateX(int decreaseInterval) {
        int x = getCoordinateX();
        location.put("x", x - decreaseInterval);
    };

    private void decreaseCoordinateY(int decreaseInterval) {
        int y = getCoordinateY();
        location.put("y", y - decreaseInterval);
    }

    private void decreaseFuel() {
        fuel = fuel - fuelDecreaseInterval;
    }

    public HashMap<String, Integer> getLocation() {
        return location;
    }

    public void printCurrentLocation() {
        System.out.println("You current location: ");
        System.out.println("x = " + getCoordinateX());
        System.out.println("y = " + getCoordinateY());
    }

    public int getVehicleFuel() {
        return fuel;
    }

    public void printVehicleFuel() {
        System.out.println("Current fuel: " + fuel + " liters");
    }

    public void increaseVehicleFuel() {
        System.out.println("Fuel award: " + fuelAward);
        fuel = fuel + fuelAward;
        System.out.println("Vehicle fuel: " + fuel);
    }


    public void moveVehicle(String moveCommand) {
        switch (moveCommand) {
            case "UP":
                System.out.println("Command correct. Vehicle moved");
                decreaseCoordinateY(vehicleSize);
                break;
            case "DOWN":
                System.out.println("Command correct. Vehicle moved");
                increaseCoordinateY(vehicleSize);
                break;
            case "LEFT":
                System.out.println("Command correct. Vehicle moved");
                decreaseCoordinateX(vehicleSize);
                break;
            case "RIGHT":
                System.out.println("Command correct. Vehicle moved");
                increaseCoordinateX(vehicleSize);
                break;
            default: System.out.println("Incorrect command");
                break;
        }

        decreaseFuel();
    }


}
