package myFoodora.model;

import java.util.Scanner;

public class myfoodora_app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String command = "";
        UserInterface userInterface = new UserInterface();
        
        while (!command.equals("exit")) {
            System.out.println("Entrez une commande :");
            command = scanner.nextLine();

            switch (command) {
                case "setup":
                    System.out.println("Entrez le nombre de restaurants :");
                    String numRestaurants = scanner.nextLine();
                    userInterface.setup(numRestaurants);
                    System.out.println("Configuration terminée avec " + numRestaurants+" restaurants.");
                    break;
                case "exit":
                    System.out.println("Fermeture du programme.");
                    break;
                default:
                    System.out.println("Commande non reconnue.");
                    break;
            }
        }

        scanner.close();
    }		
}

