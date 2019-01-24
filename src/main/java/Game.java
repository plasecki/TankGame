import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private HashMap<String, Integer> boardSize = new HashMap();
    private int[] destinationPoint = {5,5};
    private Vehicle gameVehicle;
    private String[] availableCommands = {"UP", "DOWN", "LEFT", "RIGHT"};

    public Game(int[] boardCoordinates, int[] initialDestination) {
        this.boardSize.put("x", boardCoordinates[0]);
        this.boardSize.put("y", boardCoordinates[1]);
        this.destinationPoint = initialDestination;
    }
    public void printDestinationPoint() {
        System.out.println("Twój punkt docelowy: " + Arrays.toString(destinationPoint));
    }

    public void setGameVehicle(Vehicle chosenVehicle) {
        this.gameVehicle = chosenVehicle;
    }

    private void increaseDestinationPoint(int increase) {
        this.destinationPoint[0] = this.destinationPoint[0] + increase;
        this.destinationPoint[1] = this.destinationPoint[1] + increase;
        System.out.println("your new destination point: ");
        System.out.println("x= " + this.destinationPoint[0]);
        System.out.println("y= " + this.destinationPoint[1]);
    }

    private boolean checkDestinationReached() {
        HashMap vehicleLocation = this.gameVehicle.getLocation();
        boolean destinationReached = false;

        if (vehicleLocation.get("x").equals(this.destinationPoint[0])) {
            if (vehicleLocation.get("y").equals(this.destinationPoint[1])) {
                destinationReached = true;
            }
        }

        return destinationReached;
    }

    public void runGame() {
        System.out.println("Game was run");
        this.printDestinationPoint();

        while(this.checkDestinationReached() == false) {
            this.gameVehicle.printCurrentLocation();
            System.out.println("Wprowadz komende " + Arrays.toString(availableCommands));
            Scanner dataEntry = new Scanner(System.in);
            String moveCommand = dataEntry.nextLine();
            gameVehicle.moveVehicle(moveCommand);
        }
        System.out.println("Your destination point was reached!!");
        System.out.println("WINNER");
        this.increaseDestinationPoint(2);
    }

}
