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
		Dates joinDate= new Dates(03,02,2019);
		Dates exitDate= new Dates(03,04,2019);
		Pet pets= new Pet("Sr.Cat",Pet.CAT,5,9.2);
		Client own= new Client("Adolfo",1006098649,"cra 45 # 45-64",3201254);
		own.addPet(pets);
		
		
		
		
		
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
	
	public void addClient(){
		System.out.println("Enter the name of the client (owner of the pets)");
		String name=reader.nextLine();
		System.out.println("Enter ID");
		int id = reader.nextInt();
		System.out.println("Enter your address");
		String address=reader.nextLine();
		System.out.println("Enter your telephone Contac");
		int telephoneContac= reader.nextInt();
		
		
	
	}
	public void addPet(){
		
		System.out.println("Enter the name of the Pet");
		String name=reader.nextLine();
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
		System.out.println("Enter the weight of the pet");
		double weight= reader.nextDouble();
		
	}
	

}