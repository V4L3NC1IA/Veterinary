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
		init();
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
		System.out.println(" | / |  5. Mini rooms of pets                                                | \\ |");
		System.out.println(" | / |  6.Earnings from hospitalization                                      | \\ |");
		System.out.println(" | / |  7. Report of the medical records of a pet that has been hospitalized | \\ |");
		System.out.println(" | / |  8. Remove client                                                     | \\ |");
		System.out.println(" | / |  9. Remove Pet                                                        | \\ |");
		System.out.println(" | / |  10.Exit                                                              | \\ |");
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
				break;
				case(2):
				hospitalizePet();
				break;
				case(3):
				ownContac();
				break;
				case(4):
				dischargePet();
				break;
				case(5):
				miniRoomPet();
				break;
				case(6):
				EarningForHos();
				break;
				case(7):
				System.out.println(MyLittlePet.report());
				break;
				case(8):
				removeClient();	
				break;
				case(9):
				removePet();
				break;
				case(10):
				System.out.println("Gracias por Usar el software");
				break;
			}
		}
	}
	
	public void EarningForHos(){
		System.out.println("The earnings from the hospitalization "+MyLittlePet.MyLittlePetEarnings());
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
				double weighp= reader.nextDouble();
				reader.nextLine();
				Pet newPet= new Pet(namePet,typeOfPet,age,weighp,newClient);
				newClient.addPets(newPet);
				MyLittlePet.addClient(newClient);
				System.out.println("-------------------------------------------\n");
				System.out.println("| New client has been successfully added  |\n");
				System.out.println("--------------------------------------------n");
				
			}
		
	}
	public void miniRoomPet(){
		System.out.println("What is the identifier of the owner");
		String Id = reader.nextLine();
		System.out.println("what is the name of the pet");
		String namePet = reader.nextLine();
		
		if(MyLittlePet.numberRoom(Id, namePet) !=0){
			System.out.println("The pet is in the room "+MyLittlePet.numberRoom(Id, namePet));
		}
		else{
			System.out.println("The pet is not in a room");
		}
	}
	public void hospitalizePet(){
		if(MyLittlePet.availableRoom() == true){
			int stop = 0;
			while (stop == 0){
			System.out.println("owner's identifier:");
			String Id = reader.nextLine();
			if(MyLittlePet.findClient(Id) == true){
				System.out.println("What pet do you want to hospitalize");
				System.out.println(MyLittlePet.clint(Id).petName());
				int option = reader.nextInt();
				reader.nextLine();
				System.out.println("¿What are the symptoms?");
				String sysmptoms = reader.nextLine();
				System.out.println("¿What is the diagnostic?");
				String diagnostic = reader.nextLine();
				Pet petsHos = MyLittlePet.clint(Id).getPets().get(option-1);
				System.out.println("Day of join:");
				int tDay = reader.nextInt();
				reader.nextLine();
				System.out.println("Month of join:");
				int tMonth = reader.nextInt();
				reader.nextLine();
				System.out.println("Year of join:");
				int tYear = reader.nextInt();
				reader.nextLine();
				Dates today = new Dates(tDay, tMonth, tYear);
				clinicHistory newClinic = new clinicHistory(true, sysmptoms, diagnostic, petsHos, today, null);
				System.out.println("How many medicines has the pet?");
				int quantityMedicines = reader.nextInt();
				reader.nextLine();
				for(int i = 0; i < quantityMedicines; i++){
					System.out.println("--------------------------------");
					System.out.println("The name of the medicine?");
					String theName = reader.nextLine();
					System.out.println("How many doses of the medicine?");
					double theDoses = reader.nextDouble();
					reader.nextLine();
					System.out.println("What is the cost by dose?");
					double costByDose = reader.nextDouble();
					reader.nextLine();
					System.out.println("What is the frequency to take the medicine?");
					double theFrequency = reader.nextDouble();
					reader.nextLine();
					PrescripcionMedical temporalDrug = new PrescripcionMedical(theName, theDoses, costByDose,theFrequency);
					newClinic.addDrugs(temporalDrug);
				}
				MyLittlePet.hospitalizeAPet(newClinic);
				System.out.println("The pet was hospitalized successfully");
				stop = 1;
			}
			else{
				System.out.println("The client wasn't finded");
			}
			}
			}
		else{
			System.out.println("All rooms are occupied");
		}
	}

	public void ownContac(){
		int pl = 0;
		while (pl == 0){
			System.out.println("in what room is the pet");
			System.out.println(MyLittlePet.occupiedRooms());
			int num = reader.nextInt();
			reader.nextLine();
			if(MyLittlePet.getMinis().length < num || MyLittlePet.roomOccupied(num-1) == false){
				System.out.println("not available");
			}
			else{
				System.out.println(MyLittlePet.contactOwner(num));
				pl = 1;
			}
		}
	}
	public void dischargePet(){
		if(MyLittlePet.numberRoomsAvailable() == 8){
			System.out.println("There is not pets hospitalized");
		}
		else{
		int error = 0;
		while (error == 0){
			System.out.println("in what room is the pet?");
			System.out.println(MyLittlePet.occupiedRooms());
			int option = reader.nextInt();
			reader.nextLine();
			if(MyLittlePet.roomOccupied(option-1) == false){
				System.out.println("There is no pet in this room");
			}
			else{
				System.out.println("Day of exit:");
				int todayDay = reader.nextInt();
				reader.nextLine();
				System.out.println("Month of exit:");
				int todayMonth = reader.nextInt();
				reader.nextLine();
				System.out.println("Year of exit:");
				int todayYear = reader.nextInt();
				reader.nextLine();
				Dates today = new Dates(todayDay, todayMonth, todayYear);
				MyLittlePet.exitDate(option, today);
				System.out.println(MyLittlePet.roomReport(option));
				MyLittlePet.statusHistory(option, false);
				MyLittlePet.addHistorys(MyLittlePet.getMinis()[option-1].getHistory());
				MyLittlePet.availabilityRoom(option, true);
				MyLittlePet.getMinis()[option-1].setHistory(null);
				System.out.println("The pet was discharge successfully");
				error = 1;
			}
		}
		}
	}
	
	public void removePet(){
		System.out.println("What is the ID of the owner");
		String ID = reader.nextLine();
		if(!MyLittlePet.findClient(ID)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println("What pet do you want to hospitalize");
			System.out.println(MyLittlePet.returnClient(ID).namePetsito());
			if(!(MyLittlePet.returnClient(ID).namePetsito().equals("\nThe client don't has pets"))){
			int option = reader.nextInt();
			reader.nextLine();
			String theName = MyLittlePet.returnClient(ID).getPets().get(option-1).getName();
			System.out.println(MyLittlePet.eliminatePet(ID, theName));
			}
		}
	}
	
	
	public void removeClient(){
		System.out.println("What is the ID of the client");
		String ID = reader.nextLine();
		if(!MyLittlePet.findClient(ID)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println(MyLittlePet.eliminateClient(ID));
		}
	}
	public void init(){
		MyLittlePet = new Veterinary();
		Client own1= new Client("Adolfo","100","cra 45 # 45-64",3201254);
		Pet pets= new Pet("srcat",Pet.CAT,5,9.2, own1);
		MyLittlePet.addClient(own1);
		own1.addPets(pets);
		pets.setOwner(own1);
		Dates dateJoin= new Dates(3, 2, 19);
		Dates dateExit= new Dates(3, 4, 19);
		clinicHistory historyC = new clinicHistory(true,"Abdominal pain","Colon cancer",pets, dateJoin, dateExit);
		MyLittlePet.addHistorys(historyC);
		PrescripcionMedical medicine1= new PrescripcionMedical("Ramipril",2.0,4300,24.0);
		PrescripcionMedical medicine2= new PrescripcionMedical("Colecalciferon",4,2300,12);
		historyC.addDrugs(medicine1);
		historyC.addDrugs(medicine2);
		
		
		miniRooms room1 = new miniRooms(true, 1, null);
		miniRooms room2 = new miniRooms(true, 2, null);
		miniRooms room3 = new miniRooms(true, 3, null);
		miniRooms room4 = new miniRooms(false, 4, historyC);
		miniRooms room5 = new miniRooms(true, 5, null);
		miniRooms room6 = new miniRooms(true, 6, null);
		miniRooms room7 = new miniRooms(true, 7, null);
		miniRooms room8 = new miniRooms(true, 8, null);
		miniRooms[] roomsT = {room1,room2, room3, room4, room5, room6, room7, room8};

		MyLittlePet.setMinis(roomsT);
		
		
	}
	
}