package myFoodora.model;

import java.util.ArrayList;
import java.util.Scanner;
public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String command="";
		
		while(!command.equals("exit")) {
			System.out.println("Entrez une commande :");
			String line =scanner.nextLine();
			String []listMots= line.split(" ");
			command=listMots[0];
			
			ArrayList<String> parameters=new ArrayList<String>();
			for (int i=1 ;i<args.length; i++) {
				parameters.add(args[i]);
			}
			switch(command) {
			case "setup" :
				break;
			case "registerRestaurant":
				UserInterface.registerRestaurant(parameters);
				break;	
			case "registerCustomer":
				UserInterface.registerCustomer(parameters);
			case "exit":
				break;
			case "registerCourrier":
				UserInterface.registerCourrier(parameters);
            default:
                System.out.println("Commande non reconnue.");
                break;
			}
		}
		System.out.println("Fermeture de l'application réussit !");
		scanner.close();
	}

}
