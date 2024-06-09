package myFoodora.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class app {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		Manager ceo=new Manager("ceo","123456789","Teddy","Olivers");
		MyFoodoraSystem.getInstance().getManagersList().put("ceo", ceo);
		
		Manager rh=new Manager("rh","2002","Labell","auli");
		MyFoodoraSystem.getInstance().getManagersList().put("rh", rh);
		
		String ConfigInitiale="my_foodora.ini";
		LecteurScenario.runFileScénario(ConfigInitiale);
		
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
			case "runTest":
				LecteurScenario.runFileScénario(parameters.get(0));
				break;
			case "help":
				System.out.println("Le système contient les commandes suivantes:");
				System.out.println(Help.getHelp());
				break;
			case "exit":
				System.out.println("Fermeture de l'application réussit !");
				scanner.close();
				break;
			default:
				System.out.println("Commande non reconnue");
				break;
				
			//Partie de code dédiée à la connexion des utilisateurs et leurs fonctionnement	
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
						case "logout":
							System.out.println("Déconnexion réussie");
							break;
						case "onDuty":
							UserInterface.onDuty((Courrier)user, parameters);
							System.out.println("changement réussie");
							break;
						case "offDuty":
							UserInterface.offDuty((Courrier)user, parameters);
							System.out.println("changement réussie");
							break;
						default :
							System.out.println("commande courrier non reconnue");
							break;
						}
					}
				}
				else if (user instanceof Restaurant) {
					Restaurant restaurant=(Restaurant)user;
					while(!command.equals("logout")) {
						System.out.println("Entrez une commande restaurant");
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
						case "addDishRestaurantMenu":
							UserInterface.addDishRestaurantMenu(restaurant.getName(), parameters);
							System.out.println("la création du dish "+parameters.get(0)+" est un succès");
							break;
						case "createMeal":
							UserInterface.createMeal(restaurant, parameters);
							System.out.println("la création du meal "+parameters.get(0)+" est un succès");
							break;
						case "addDish2Meal":
							UserInterface.addDish2Meal(restaurant, parameters);
							System.out.println("l'ajout du dish "+parameters.get(0)+" dans le meal "+ parameters.get(1)+" est un succès");
							break;
						case "showMeal":
							UserInterface.showMeal(restaurant, parameters);
							System.out.println("Affichage du meal "+parameters.get(0)+":");
							break;
						case "saveMeal":
							UserInterface.saveMeal(restaurant, parameters);
							System.out.println("Sauvegarde du meal "+parameters.get(0)+"réussie");
							break;
						case "setSpecialOffer":
							UserInterface.setSpecialOffer(restaurant, parameters);
							break;
						case "removeFromSpecialOffer":
							UserInterface.removeFromSpecialOffer(restaurant, parameters);
							break;
						default:
							System.out.println("commande restaurant non reconnue");
							break;
								
						}
					}
					
				}
				
				else if (user instanceof Customer) {
					Customer customer=(Customer)user;
					while(!command.equals("logout")) {
						System.out.println("Entrez une commande Customer");
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
						case "createOrder":
							UserInterface.createOrder(customer, parameters);
							break;
						case "addItem2Order":
							UserInterface.addItem2Order(customer, parameters);
							break;
						default:
							System.out.println("commande courrier non reconnue");
							break;
								
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
							break;
						case "registerCourrier":
							UserInterface.registerCourrier(parameters);
							break;
						case "setDeliveryPolicy":
							UserInterface.setDeliveryPolicy(parameters);
							break;
						case "setProfitPolicy":
							UserInterface.setProfitPolicy(parameters);
							break;
						case "showMenuItem":
							UserInterface.showMenuItem(parameters);
							break;
						case "showCustomers":
							UserInterface.showCustomers();
							break;
						case "associateCard":
							UserInterface.associateCard(parameters);
							break;
						case "showTotalProfit":
							if (parameters.size()==0)
								UserInterface.showtotalProfit();
							else UserInterface.showTotalProfit(parameters);
							break;
						case "showCourierDeliveries":
							UserInterface.showCourierDeliveries();
							break;
						case "showRestaurantTop":
							UserInterface.showRestaurantTop();
							break;
						}
					}	
				}
			}
		}
	}

}
