package model;
import java.util.ArrayList;

public class Client{
	//Attributes
	private String name;
	private String id;
	private String address;
	private int telephoneContac;
	
	//Relations
	private ArrayList <Pet> pets;
	

	/**
	* Constructor method for class Person which is a human client of the veterinary and is the owner of as minimum of one pet
	* @param name The person's name. This param must not be empty
	* @param id The person's unique ID. This param must not be empty
	* @param address The person's address. This param must not be empty
	* @param telephoneContac The person's phone number. This param must not be empty
	*/ 
	public Client(String name,String id, String address, int telephoneContac){
		this.name = name;
		this.id = id;
		this.address = address;
		this.telephoneContac = telephoneContac;
		pets= new ArrayList<Pet>();
	}
	
	
	/**
	*Allows to get the person name
	*@return The person name
	*/
	public String getName (){
		return name;
	}
	/**
	*Allows to change the person name
	*post: The person name is changed 
	*@param name The person name
	*/
	public void setName(String name){
		this.name= name;
	}
	
	/**
	*Allows to get the person Id
	*@return The person Id
	*/
	public String getId(){
		return id;
	}
	/**
	*Allows to change the person id
	*post: The person id is changed
	*@param id The person id
	*/
	public void setId(String id){
		this.id=id;
	}
	/**
	*Allows to get the person address
	*@return The person address
	*/

	public String getAddress(){
		return address;
	}
	/**
	*Allows to change the person address
	*post: The person address is changed 
	*@param address The person address
	*/
	public void setAddress(String address){
		this.address= address;
	}
	/**
	*Allows to get the person phone number
	*@return The person phone number
	*/
	public int getTelephoneContac(){
		return telephoneContac;
	}
	/**
	*Allows to change the person phone number
	*post: The person phone number is changed 
	*@param telephoneContac The person phone number
	*/
	public void setTelephoneContac(int telephoneContac){
		this.telephoneContac=telephoneContac;
	}
	/** 
	*Allows is to get the pets of a ArrayList
	*@return pets- returns the pets of that
	*/
	public ArrayList<Pet> getPets(){
		return pets;
	}
	/** 
	*Allows to change pet of the ArrayList
	*post: The pet of the ArrayList is changed 
	*@param pets-It is a mascot of a ArrayList
	*/
	public void setList(ArrayList<Pet> pets){
		this.pets = pets;
	}
	/** 
	*Allows add a pet a Array
	*@param petsito- It is a pet which you want to add to ArrayList
	*/
	public void addPets(Pet petsito){
	  pets.add(petsito);
	}
	/** 
	*this method generates a list of the pets that a client has
	*@return String msg- returns a message with the position and name of the animal in that position
	*/
	public String namePetsito(){
		String msg = "";
		int position = 0;
		if(pets.isEmpty()){
			msg = "\nThe client don't has pet";
		}
		else{
		for(int i = 0; i < pets.size(); i++){
			position++;
			msg += "\n"+position+". "+pets.get(i).getName();
		}
		}
		return msg;
	}
	
	public double petsFeeServices(int serviceSelection){
		double reply = 0.0;
		for (int i = 0; i<pets.size() ; i++ ) {
			reply += pets.get(i).servicesFees(serviceSelection);	
		}
		return reply;
	}
	
	public double petsServicesWeeklyIncome(Dates initialDate){
		double reply = 0;

		for (int i = 0; i< pets.size() ; i++) {
			reply += pets.get(i).weeklyIncome(initialDate);
			
		}

		return reply;
	}
	public int petServicesWeeklyIncome(Dates initialDate){
		int reply = 0;

		for (int i = 0; i< pets.size() ; i++) {
			reply += pets.get(i).weeklyIncomeCounter(initialDate);
			
		}

		return reply;
	}
	
	
	
	/** 
	*Allow show the information of an owner, the name, the id, the address, the contact phone
	*@return String msj- returns in a message with the owner's information
	*/
	public String owneInfo(){
		String msj="";
	
		msj += "The owners name is: "+name+"\n";
		msj += "The owners id is: "+id+"\n";
		msj += "The owners address is: "+address+"\n";
		msj += "The owners phone contac is: "+telephoneContac+"\n";
		return msj;
	}
	/**
	*Allow show the information of a client, the name, the id, the address, the contact telephone and the animals that he / she has in the clinic
	*@return String message- return in customer information
	*/
	public String clientInfo(){
	String message = "";

		for(int i = 0; i<pets.size(); i++){

			message += "His name is" + name;
			message += "\nHis Id is:" + id;
			message += "\nHis address is" + address;
			message += "\nhis phone is" + telephoneContac;
			message += pets.get(i).showInfoPets();
		}
		return message;
	}
	/**
	*Allows to show the names of the pets that an owner has in the clinic
	*@return return in a list with the name of the animals that a client has
	*/
	public String petName(){
		String menssage = "";
		int Ps = 0;
		if(pets.isEmpty()){
			menssage = "The client dont has pet\n";
		}
		else{
			for(int i = 0; i < pets.size(); i++){
				Ps++;
				menssage += "\n"+Ps+". "+pets.get(i).getName();
			}	
		}
		
		return menssage;
	}
	
	/** 
	*Allow look for a pet and if it finds it, it eliminates a pet from the system
	*@param petName- is the name of a pet that you want to eliminate. This parameter can not be null
	*@return msg- returns in a message, if the pet was deleted or if it was not found
	*/
	public String eliminatePet(String petName){
		String msg = "";
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i).getName().equals(petName)){
				pets.remove(i);
				msg = "The pet was eliminate successfuly";
			}
			else{
				msg = "The pet doesn't exist";
			}
		}
		return msg;
	}
	/**
	*this method looks for if the name of a pet is registered in the veterinary
	*@param theName- It's the name of the mascot. This parameter can not be null
	*@return found- return in the pet´s
	*/
	public Pet givePet(String theName){

		Pet found = null;
		boolean it = false;

		for (int i = 0; i < pets.size() && !it ; i++ ) {

			if ((pets.get(i).getName()).equalsIgnoreCase(theName)) {

				it = true;
				found = pets.get(i);
			}

		}

		return found;
	}
	/**
	*this method is to add a new service provided by the veterinary
	*@param clientPet is a pet which is provided by that service. This parameter can not be null
	*@param newService It is the service that you want to provide. This parameter can not be null
	*/
	public void startServicePets(Pet clientPet, Service newService){
		clientPet.addService(newService);
	}
	
}