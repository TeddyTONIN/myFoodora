package myFoodora.model;

import java.util.ArrayList;
import java.util.Scanner;
public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Manager ceo=new Manager("ceo","123456789","Teddy","Olivers");
		MyFoodoraSystem.getInstance().getManagersList().put("ceo", ceo);
		
		Scanner scanner=new Scanner(System.in);
		String command="";
		String line="";
		while(!command.equals("exit")) {
			System.out.println("Entrez une commande ou fermez le système:");
			line =scanner.nextLine();
			String []listMots= line.split(" ");
			command=listMots[0];
			ArrayList<String> parameters=new ArrayList<String>();
			
			if (listMots.length>=2){
				for (int i=1 ;i<listMots.length; i++) {
					parameters.add(listMots[i]);
				}
			}
			switch(command) {
			case "exit":
				System.out.println("Fermeture de l'application réussit !");
				scanner.close();
				break;
			default:
				System.out.println("Commande non reconnue");
				break;
			case "login" :
				User user=UserInterface.login(parameters);
				if (user==null) {
					break;
					}
				if (user instanceof Courrier) {
					user=(Courrier)user;
					while(!command.equals("logout")) {
						System.out.println("Mettre à jour votre état dans l'application ?");
						line =scanner.nextLine();
						listMots= line.split(" ");
						command=listMots[0];
						parameters=new ArrayList<String>();
						
						if (listMots.length>=2){
							for (int i=1 ;i<listMots.length; i++) {
								parameters.add(listMots[i]);
							}
						}
						
						switch(command) {
						case "onDuty":
							UserInterface.onDuty((Courrier)user, parameters);
							System.out.println("changement réussie");
							break;
						case "offDuty":
							UserInterface.offDuty((Courrier)user, parameters);
							System.out.println("changement réussie");
							break;
						default :
							UserInterface.onDuty((Courrier)user, parameters);
							System.out.println("commande courrier non reconnue");
						}
					}
				}
				else if (user instanceof Manager) {
					user=(Manager)user;
					while(!command.equals("logout")) {
						System.out.println("Entrez une commande Manager :");
						line =scanner.nextLine();
						listMots= line.split(" ");
						command=listMots[0];
						parameters=new ArrayList<String>();
						
						if (listMots.length>=2){
							for (int i=1 ;i<listMots.length; i++) {
								parameters.add(listMots[i]);
							}
						}
						
						switch(command) {
						case "logout":
							System.out.println("Déconnexion réussie");
							break;
						default:
							System.out.println("Commande non reconnue.");
			                break;
						case "registerRestaurant":
							UserInterface.registerRestaurant(parameters);
							break;	
						case "registerCustomer":
							UserInterface.registerCustomer(parameters);
						case "registerCourrier":
							UserInterface.registerCourrier(parameters);
							break;
						}
					}	
				}
			}
		}
	}

}
