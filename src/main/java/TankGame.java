import java.util.Arrays;
import java.util.Scanner;

public class TankGame {

    public static void main(String [] args)
    {
        int[] gameBoardSize = {10,10};
        int[] gameDestinationPoint = {7,7};
        int[] vehicleInitialLocation = {0,0};
        String[] availableVehicles = {"Car", "Tank"};
        String[] availableCommands = {"UP", "DOWN", "LEFT", "RIGHT"};


        System.out.println("Witaj w grze Tank");
        System.out.println("Twoim celem jest dotarcie do miejsca docelowego na planszy o wymiarach: ");
        System.out.println(gameBoardSize[0] + " na " + gameBoardSize[1]);
        System.out.println("Do wyboru masz pojazdy: ");
        System.out.println(availableVehicles[0] + " oraz " + availableVehicles[1]);
        System.out.println("Aby przemieszczać się pojazdem możesz używać komend: ");
        System.out.println(Arrays.toString(availableCommands));
        System.out.println("Milej zabawy!");
        System.out.println("");
        System.out.println("");

        Game game = new Game(gameBoardSize, gameDestinationPoint);
        Scanner dataEntry = new Scanner(System.in);
        System.out.println("Który pojazd wybierasz?");
        System.out.println("1. Car - Wybierz A");
        System.out.println("2. Tank - Wybierz B");
        String carChoice = dataEntry.nextLine();

        loop: while (carChoice != "A" &&  carChoice != "B") {

            switch(carChoice) {
                case "A":
                    Car carInGame = new Car(vehicleInitialLocation,1000, 10 );
                    game.setGameVehicle(carInGame);
                    break loop;
                case "B":
                    Tank tankInGame = new Tank(vehicleInitialLocation, 1000, 20);
                    game.setGameVehicle(tankInGame);
                    break loop;
                default:
                    System.out.println("Zly wybór. Dokonaj wyboru jeszcze raz.");
                    System.out.println("Który pojazd wybierasz?");
                    System.out.println("1. Car - Wybierz A");
                    System.out.println("2. Tank - Wybierz B");
                    carChoice = dataEntry.nextLine();
                    break loop;
            }
         }

        game.runGame();
    }

}
