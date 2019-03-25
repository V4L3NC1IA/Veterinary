/**
* -----------------------------------------------------------------------------------------------------
*$Id$
* Universidad Icesi (Cali-Colombia)
* Departamento TIC- Algoritmo y programación I
* Third Lab
*@Autor: Adrián Cortés <Adrianc0741@gmail.com>
*@Date: 18 march 2019
*-----------------------------------------------------------------------------------------------------
*/

package ui;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	//relation
	private Veterinary MyLittlePet;
	private Scanner reader;
	
	//creation of objects
	public Main(){
		reader = new Scanner(System.in);
		
	}

	public static void main(String[] args){
		Main m= new Main();
		m.welcomeMenssage();
		m.showMenu();
	}

	public void welcomeMenssage(){    //show welcome menssage   
	
		System.out.println(" __        __         _                                       _                 ");
		System.out.println(" \\ \\      / /   ___  | |   ___    ___    _ __ ___     ___    | |_    ___        ");
		System.out.println("  \\ \\ /\\ / /   / _ \\ | |  / __|  / _ \\  | '_ ` _ \\   / _ \\   | __|  / _ \\       ");
		System.out.println("   \\ V  V /   |  __/ | | | (__  | (_) | | | | | | | |  __/   | |_  | (_) |      ");
		System.out.println("    \\_/\\_/     \\___| |_|  \\___|  \\___/  |_| |_| |_|  \\___|    \\__|  \\___/       ");
		System.out.println("  __  __             _       _   _     _     _            ____           _      ");
		System.out.println(" |  \\/  |  _   _    | |     (_) | |_  | |_  | |   ___    |  _ \\    ___  | |_    ");
		System.out.println(" | |\\/| | | | | |   | |     | | | __| | __| | |  / _ \\   | |_) |  / _ \\ | __|   ");
		System.out.println(" | |  | | | |_| |   | |___  | | | |_  | |_  | | |  __/   |  __/  |  __/ | |_    ");
		System.out.println(" |_|  |_|  \\__, |   |_____| |_|  \\__|  \\__| |_|  \\___|   |_|      \\___|  \\__|   ");
		System.out.println("           |___/                                                             	");
	}
	
	//method to show the program options menu
	public void showOptions(){
		System.out.println(" __^__                                                                       __^__");
		System.out.println("( ___ )---------------------------------------------------------------------( ___ )");
		System.out.println(" | / |  1. Register clients and their pets                                   | \\ |");
		System.out.println(" | / |  2. Hospitalize a pet                                                 | \\ |");
		System.out.println(" | / |  3. Consult the contact details of the owner of a hospitalized pet    | \\ |");
		System.out.println(" | / |  4. Discharge an animal that has been hospitalized                    | \\ |");
		System.out.println(" | / |  5. Mini rooms                                                        | \\ |");
		System.out.println(" | / |  6.Earnings from hospitalization                                      | \\ |");
		System.out.println(" | / |  7. Report of the medical records of a pet that has been hospitalized | \\ |");
		System.out.println(" | / |  8.Exit                                                               | \\ |");
		System.out.println(" |___|                                                                       |___|");
		System.out.println("(_____)---------------------------------------------------------------------(_____)");
	}
	
	public void showMenu(){
		int userInput =0;
		  
		
			while(userInput!=8){
			showOptions();
			
			userInput=reader.nextInt();
			reader.nextLine();
			
			switch(userInput){
				case(1):
				addClientAndPet();
				case(2):
				
				case(3):
				
				case(4):
				
				case(5):
				
				case(6):
				
				case(7):
				
				case(8):
				System.out.println("Gracias por Usar el software");				
			}
		}
	}
	
	public void addClientAndPet(){
		System.out.println("Enter the name of the client (owner of the pets)");
		String name=reader.nextLine();
		System.out.println("Enter ID");
		String id = reader.nextLine();
		System.out.println("Enter your address");
		String address=reader.nextLine();
		System.out.println("Enter your telephone Contac");
		int telephoneContac= reader.nextInt();
		reader.nextLine();

			Client newClient = new Client(name, id, address, telephoneContac);

			System.out.print("How many pets will the customer register?\n"); 
			int petsitos= reader.nextInt(); 
			reader.nextLine();

			for(int i = 0; i < petsitos; ++i){
				System.out.println("Enter the name of the Pet");
				String namePet = reader.nextLine();
				System.out.println("Enter the type of pet \n1.Dog \n2.Cat \n3.Bird \n4.Other");
				int select= reader.nextInt();
				String typeOfPet="";
				if(select==1){
					typeOfPet= Pet.DOG;
				}
				else if(select==2){
					typeOfPet= Pet.CAT;
				}
				else if(select==3){
					typeOfPet = Pet.BIRD;
				}
				else if(select==4){
					typeOfPet = Pet.OTHER;
				}
				else{
					System.out.println("Enter the type of pet");
				}
				System.out.println("Enter the age of the pet");
				int age= reader.nextInt();
				reader.nextLine();
				System.out.println("Enter the weight of the pet");
				double weight= reader.nextDouble();
				reader.nextLine();
				Pet newPet= new Pet(namePet,typeOfPet,age,weight,newClient);
				newClient.addPets(newPet);
				MyLittlePet.addClients(newClient);
				System.out.println("-------------------------------------------\n");
				System.out.println("| New client has been successfully added  |\n");
				System.out.println("--------------------------------------------n");
			}
		
	}
		
		public void hospitalizeAPet(){

		if(MyLittlePet.miniRoomsAvailable()){

			System.out.println("");
			System.out.print("The name of the pet that must be hospitalized: "); 
			String petsName = reader.nextLine();
			System.out.print("The name of the pet owner: "); 
			String name = reader.nextLine();
			System.out.print("The owner's identification: ");
			int id = reader.nextInt();
			String name = reader.nextLine();
			System.out.println("");

			if(MyLittlePet.checkOwner(name, id, petsName)){


				
				System.out.println(" ▂ ▃ ▅ ▆ █ Hospitalization day information █ ▆ ▅ ▃ ▂");

				System.out.println("");
				System.out.print("Day of the hospitalization of the pet: "); 
				int day = reader.nextInt(); 
				reader.nextLine();
				System.out.print("Month of the hospitalization of the pet: "); 
				int month = reader.nextInt(); 
				reader.nextLine();
				System.out.print("Year of the hospitalization of the pet: "); 
				int year = reader.nextInt(); 
				reader.nextLine();
				Dates newJoinDate = new Dates(day, month, year);
				
				System.out.print("Type the pet's symptoms "); 
				String symptoms = reader.nextLine();
				System.out.print("Type the pet's diagnosys: "); 
				String diagnosys = reader.nextLine();
				

				clinicHistory newHospi = new clinicHistory("Open", diagnosys, symptoms, newJoinDate, null);

				System.out.println("▂ ▃ ▅ ▆ █ Medication █ ▆ ▅ ▃ ▂");
			
				System.out.println("");
				System.out.print("How many prescribed medicines does the pet have?\n");
				int quantity = reader.nextInt(); 
				reader.nextLine();

				ArrayList<PrescripcionMedical> petsMedicine = new ArrayList<PrescripcionMedical>();
				for(int i = 0; i < quantity; ++i){

					System.out.println("___________________________________________________________________");
					System.out.print("Type the medicine's name: "); 
					String nameMedicine = reader.nextLine();
					System.out.print("Type the medicine's dose: ");
					double doseMedicine = reader.nextDouble(); 
					reader.nextLine();
					System.out.print("Type the medicine's price per dose: ");
					double costMedicine = reader.nextDouble();
					reader.nextLine();
					System.out.print("Type the medicine's frecuency: ");
					String frecuencyMedicine = reader.nextLine();
					PrescripcionMedical newMedPet = new PrescripcionMedical(nameMedicine, doseMedicine, costMedicine, frecuencyMedicine);
					petsMedicine.add(newMedPet);
					
				}

				MyLittlePet.initHospitalize(name, id, petsName, historyMedical, medPets);
				System.out.println("");
				System.out.println(petsName+" was successfully hospitalized");
				System.out.println("");
				

			

			} 	else {System.out.println("");
				System.out.println("ERROR: No match found.");
				System.out.println("");}


		}	else {System.out.println("");
				System.out.println("ERROR: All rooms are occupied.");
				System.out.println("");}

	}

	public void init(){
		
		Client own= new Client("Adolfo","1006098649","cra 45 # 45-64",3201254);
		Pet pets= new Pet("Sr.Cat",Pet.CAT,5,9.2, own);
		own.addPets(pets);
		pets.setOwner(own);
		clinicHistory historyC = new clinicHistory(true,"Abdominal pain","Colon cancer",pets, null, null);
		PrescripcionMedical medicine1= new PrescripcionMedical("Ramipril",2.0,4300,24.0);
		PrescripcionMedical medicine2= new PrescripcionMedical("Colecalciferon",4,2300,12);
		historyC.addDrugs(medicine1);
		historyC.addDrugs(medicine2);
		Dates dateJoin= new Dates(3, 2, 19);
		Dates dateExit= new Dates(3, 4, 19);
		
		
		
		miniRooms room1 = new miniRooms(true, 1, null);
		miniRooms room2 = new miniRooms(true, 2, null);
		miniRooms room3 = new miniRooms(true, 3, null);
		miniRooms room4 = new miniRooms(true, 4, historyC);
		miniRooms room5 = new miniRooms(true, 5, null);
		miniRooms room6 = new miniRooms(true, 6, null);
		miniRooms room7 = new miniRooms(false, 7, null);
		miniRooms room8 = new miniRooms(true, 8, null);
		miniRooms[] roomsT = {room1,room2, room3, room4, room5, room6, room7, room8};
		MyLittlePet = new Veterinary();
		MyLittlePet.setMinis(roomsT);
		MyLittlePet.addHistorys(historyC);
		MyLittlePet.addClients(own);
		
	}
	
}