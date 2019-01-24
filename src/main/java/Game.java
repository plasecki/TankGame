import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
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

    private int getBoardSize(String axisType) {
        return boardSize.get(axisType);
    }

    private void printBoardSize() {
        System.out.println("Game board size");
        System.out.println("x = " + this.getBoardSize("x"));
        System.out.println("y = " + this.getBoardSize("y"));
    }

    public void setGameVehicle(Vehicle chosenVehicle) {
        this.gameVehicle = chosenVehicle;
    }

    private void setNewDestinationPoint() {
        Random rand = new Random();
        this.destinationPoint[0] = rand.nextInt(11);
        this.destinationPoint[1] = rand.nextInt(11);

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

    private boolean checkBoardBoarderReached(String moveCommand) {
        HashMap<String, Integer> vehicleLocation = this.gameVehicle.getLocation();
        boolean destinationReached = false;
        boolean incorrectCommand = false;
        int xLocation = vehicleLocation.get("x");
        int yLocation = vehicleLocation.get("y");

        switch (moveCommand) {
            case "UP":
                yLocation = yLocation - 1;
                break;
            case "DOWN":
                yLocation = yLocation + 1;
                break;
            case "LEFT":
                xLocation = xLocation - 1;
                break;
            case "RIGHT":
                xLocation = xLocation + 1;
                break;
            default:
                System.out.println("Incorrect command. Enter new command.");
                incorrectCommand = true;
                return incorrectCommand;
        }

        System.out.println("x=" + xLocation);
        System.out.println("y=" + yLocation);

        if (xLocation > this.getBoardSize("x")) {
            destinationReached = true;
        }

        if (xLocation < 0) {
            destinationReached = true;
        }

        if (yLocation > this.getBoardSize("y")) {
            destinationReached = true;
        }

        if (yLocation < 0) {
            destinationReached = true;
        }

        return destinationReached;
    }

    public void runGame() {
        String userDecision = "YES";
        while(userDecision.equals("YES")) {
            System.out.println("Game was run");
            this.setNewDestinationPoint();
            this.printDestinationPoint();

            while (this.checkDestinationReached() == false) {
                this.gameVehicle.printCurrentLocation();
                System.out.println("Wprowadz komende " + Arrays.toString(availableCommands));
                Scanner dataEntry = new Scanner(System.in);
                String moveCommand = dataEntry.nextLine();
                if (this.checkBoardBoarderReached(moveCommand) == false) {
                    gameVehicle.moveVehicle(moveCommand);
                } else {
                    System.out.println("You cannot move vehicle out of the game board");
                    this.printBoardSize();
                    System.out.println("or command you entered is not valid");
                }

            }
            System.out.println("Your destination point was reached!!");
            System.out.println("WINNER");
            System.out.println("Do you want to play again?");
            System.out.println("Choose: YES or other answer to quit");
            Scanner decisionEntry = new Scanner(System.in);
            userDecision = decisionEntry.nextLine();
        }

    }

}
