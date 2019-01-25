import java.util.*;

public class Game {
    private Map<String, Integer> boardSize = new HashMap();
    private int[] destinationPoint = new int[2];
    private Vehicle gameVehicle;
    private final String[] availableCommands = {"UP", "DOWN", "LEFT", "RIGHT"};

    public Game(int[] boardCoordinates) {
        boardSize.put("x", boardCoordinates[0]);
        boardSize.put("y", boardCoordinates[1]);
    }

    private int getBoardSize(String axisType) {
        return boardSize.get(axisType);
    }

    private void printBoardSize() {
        System.out.println("Game board size");
        System.out.println("x = " + this.getBoardSize("x"));
        System.out.println("y = " + this.getBoardSize("y"));
    }

    private boolean checkDestinationReached() {
        HashMap vehicleLocation = gameVehicle.getLocation();
        boolean destinationReached = false;

        if (vehicleLocation.get("x").equals(destinationPoint[0])) {
            if (vehicleLocation.get("y").equals(destinationPoint[1])) {
                destinationReached = true;
            }
        }

        return destinationReached;
    }

    private boolean fuelOffGameOver() {
        return (gameVehicle.getVehicleFuel() <= 0);
    }

    private boolean checkBoardBoarderReached(String moveCommand, int moveInterval) {
        HashMap<String, Integer> vehicleLocation = gameVehicle.getLocation();
        boolean destinationReached = false;
        boolean incorrectCommand = false;
        int xLocation = vehicleLocation.get("x");
        int yLocation = vehicleLocation.get("y");

        switch (moveCommand) {
            case "UP":
                yLocation = yLocation - moveInterval;
                break;
            case "DOWN":
                yLocation = yLocation + moveInterval;
                break;
            case "LEFT":
                xLocation = xLocation - moveInterval;
                break;
            case "RIGHT":
                xLocation = xLocation + moveInterval;
                break;
            default:
                System.out.println("Incorrect command. Enter new command.");
                incorrectCommand = true;
                return incorrectCommand;
        }

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

    private void setNewDestinationPoint() {
        Random rand = new Random();
        destinationPoint[0] = rand.nextInt(11);
        destinationPoint[1] = rand.nextInt(11);

        System.out.println("your new destination point: ");
        System.out.println("x= " + destinationPoint[0]);
        System.out.println("y= " + destinationPoint[1]);
    }

    public void printDestinationPoint() {
        System.out.println("Twój punkt docelowy: " + Arrays.toString(destinationPoint));
    }

    public void setGameVehicle(Vehicle chosenVehicle) {
        gameVehicle = chosenVehicle;
    }

    public void runGame() {
        String userDecision = "YES";
        while(userDecision.equals("YES")) {
            System.out.println("Game was run");
            setNewDestinationPoint();
            printDestinationPoint();

            while (checkDestinationReached() == false) {
                gameVehicle.printCurrentLocation();
                System.out.println("Wprowadz komende " + Arrays.toString(availableCommands));
                Scanner dataEntry = new Scanner(System.in);
                String moveCommand = dataEntry.nextLine();
                if (checkBoardBoarderReached(moveCommand, gameVehicle.getVehicleSize()) == false) {
                    gameVehicle.moveVehicle(moveCommand);
                    gameVehicle.printVehicleFuel();
                } else {
                    System.out.println("You cannot move vehicle out of the game board");
                    printBoardSize();
                    System.out.println("or command you entered is not valid");
                }

                if (fuelOffGameOver()) {
                    System.out.println("Fuel off game over");
                    System.exit(0);
                }
            }
            System.out.println("Your destination point was reached!!");
            System.out.println("WINNER");
            System.out.println("Do you want to play again?");
            System.out.println("Choose: YES or other answer to quit");
            Scanner decisionEntry = new Scanner(System.in);
            userDecision = decisionEntry.nextLine();
            gameVehicle.increaseVehicleFuel();
        }

        System.exit(0);
    }
}
