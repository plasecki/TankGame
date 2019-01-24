
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Vehicle {
    private HashMap<String, Integer> location = new HashMap();
    private int fuel;
    private int fuelDecreaseInterval;

    public Vehicle(int[] initialLocation, int initialFuel, int initialFuelInterval) {
        System.out.println("Vehicle created");
        this.location.put("x",initialLocation[0]);
        this.location.put("y",initialLocation[1]);
        this.fuel = initialFuel;
        this.fuelDecreaseInterval = initialFuelInterval;
    };

    public HashMap<String, Integer> getLocation() {
        return this.location;
    }

    public void printCurrentLocation() {
        System.out.println("You current location: ");
        System.out.println("x = " + this.getCoordinateX());
        System.out.println("y = " + this.getCoordinateY());
    }

    private int getCoordinateX() {
        return location.get("x");
    };

    private int getCoordinateY() {
        return location.get("y");
    }

    public int getFuel() {
        return fuel;
    }

    private void increaseCoordinateX(int increaseInterval) {
        int x = this.getCoordinateX();
        this.location.put("x", x + increaseInterval);
    };

    private void increaseCoordinateY(int increaseInterval) {
        int y = this.getCoordinateY();
        this.location.put("y", y + increaseInterval);
    };

    private void decreaseCoordinateX(int decreaseInterval) {
        int x = this.getCoordinateX();
        this.location.put("x", x - decreaseInterval);
    };

    private void decreaseCoordinateY(int decreaseInterval) {
        int y = this.getCoordinateY();
        this.location.put("y", y - decreaseInterval);
    }

    private void decreaseFuel() {
        this.fuel = this.fuel - fuelDecreaseInterval;
    }

    public void moveVehicle(String moveCommand) {

        switch (moveCommand) {
            case "UP":
                System.out.println("Command correct. Vehicle moved");
                this.decreaseCoordinateY(1);
                break;
            case "DOWN":
                System.out.println("Command correct. Vehicle moved");
                this.increaseCoordinateY(1);
                break;
            case "LEFT":
                System.out.println("Command correct. Vehicle moved");
                this.decreaseCoordinateX(1);
                break;
            case "RIGHT":
                System.out.println("Command correct. Vehicle moved");
                this.increaseCoordinateX(1);
                break;
            default: System.out.println("Incorrect command");
                break;
        }

        this.decreaseFuel();
    }


}
