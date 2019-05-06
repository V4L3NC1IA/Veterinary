package model;
import java.util.*;

public class Pet{
	//attributes
	private String name;
	private String typeOfPet;
	private int age;
	private double weight;
	
	private double height;
	
	public final static String DOG = "Dog";
	public final static String CAT = "Cat";
	public final static String BIRD = "Bird";
	public final static String OTHER = "Other";
	// 
	public Client own;
	private ArrayList<Service> services;
	
	
	
	/**
	*Constructor method for class Pet which is a pet offered by the veterinary
	*@param theName The pet's name. This param must not be empty
	*@param theTypeOfPet The pet's species. This param can only be "Dog", "Cat", "Bird" or "Other"
	*@param theAge The pet's age
	*@param theWeight The pet's weight. This param must be greater than zero
	*@param theHeight The pet's height. This param must be greater than zero
	*@param own The person (object) who is the pet's owner. This param must not be null
	*/
	
	public Pet(String theName,String theTypeOfPet, int theAge, double theWeight, double theHeight, Client own){
		name= theName;
		typeOfPet= theTypeOfPet;
		age= theAge;
		height= theHeight;
		weight= theWeight;
		this.own=own;
		services = new ArrayList<Service>();
	}
	
	//Setters and Getters
	/**
	*Allows to get the pet's name. 
	*@return The pet's name
	*/
	public String getName(){
		return name;
	}
	
	/**
	*Allows to change the pet's name
	*post:The pet's name is changed
	*@param name The pet's name
	*/
	public void setName(String name){
		this.name= name;
	}
	
	/**
	*Allows to get the pet's type
	*@return The pet's type
	*/

	public String getTypeOfPet(){
		return typeOfPet;
	}
	/**
	*Allows to change the pet's type
	*post: The pet's type is changed
	*@param typeOfPet type The pet's type
	*/
	public void setTypeOfPet(String typeOfPet){
		this.typeOfPet= typeOfPet;
	}
	/**
	*Allows to get the pet's age
	*@return The pet's age
	*/
	public int getAge(){
		return age;
	}
	/**
	*Allows to change the pet's age
	*post: The pet's age is changed
	*@param age The pet's age
	*/
	public void setAge(int age){
		this.age=age;
	}
	/**
	*Allows to get the pet's weight
	*@return The pet's weight
	*/
	public double getWeight(){
		return weight;
	}
	/**
	*Allows to change the pet's weight
	*post: The pet's weight is changed
	*@param weight The pet's weight
	*/
	public void setWeight(double weight){
		this.weight=weight;
	}
	
	/**
	*Allows to get the pet's height
	*@return The pet's height
	*/
	public double getHeight(){
		return height;
	}
	
	/**
	*Allows to change the pet's height
	*post: The pet's height is changed 
	*@param height The pet's height
	*/
	public void setHeight(double height){
		this.height=height;
	}
	
	/**
	*Allows to get the own of the Pet
	*@return The own of the pet´s
	*/
	public Client getOwn(){
		return own;
	}
	/**
	*Allows to change the pet's own
	*post: The pet's own is changed 
	*@param own The pet's own
	*/
	public void setOwner(Client own){
		this.own = own;
	}
	/**
	*Allows to get the name of the owner of the pet
	*@return the name of the owner of the pet
	*/
	public String nameOwner(){
		return own.getName();
	}
	/**
	*Allows to get the id of the owner of the pet
	*@return the id of the owner of the pet
	*/
	public String idOwner(){
		return own.getId();
	}
	/**
	*Allows to get the informations of the owner of the pet
	*@return the informations of the owner of the pet
	*/
	public String infoOwner(){
		return own.owneInfo();
	}
	/** 
	*This method calculates the cost per day of the hospitalization of a pet according to the type of animal
	*@return int DayliCost - returns in the cost of hospitalization per day of a pet
	*/
	public double DailyCostForHospitalization(){
		double DailyCost = 0;
		if(typeOfPet.equals(Pet.DOG)){
			if(weight > 1 && weight <=3 ){
				DailyCost= 15000;
			}
			else if(weight > 3 && weight <=10){
				DailyCost = 17000;
			}
			else if(weight > 10 && weight <=20){
				DailyCost = 20000;
			}
			else
				DailyCost=25000;
		}
		else if(typeOfPet.equals(Pet.CAT)){
			if(weight > 1 && weight <=3 ){
				DailyCost= 10000;
			}
			else if(weight > 3 && weight <=10){
				DailyCost = 12000;
			}
			else if(weight > 10 && weight <=20){
				DailyCost = 15000;
			}
			else
				DailyCost=20000;
		}
		else if(typeOfPet.equals(Pet.BIRD)){
			if(weight > 1 && weight <=3 ){
				DailyCost= 10000;
			}
			else if(weight > 3 && weight <=10){
				DailyCost = 12000;
			}
			else if(weight > 10 && weight <=20){
				DailyCost = 20000;
			}
			else
				DailyCost=25000;
		}
		else if(typeOfPet.equals(Pet.OTHER)){
			if(weight > 1 && weight <=3 ){
				DailyCost= 10000;
			}
			else if(weight > 3 && weight <=10){
				DailyCost = 17000;
			}
			else if(weight > 10 && weight <=20){
				DailyCost = 30000;
			}
			else
				DailyCost=33000;
		}
		
		return DailyCost;
	
	}
	
	public double weeklyIncome(Dates initialDate){
		double reply = 0;
		int dayOfYearGiven = initialDate.calculateDayOfTheYear();
		int dayOfYearCase = 0;

		for (int i = 0; i < services.size() ; i++ ) {
			Service serviceInMatter = services.get(i);

			if(initialDate.getYear() == serviceInMatter.getDatesR().getYear()){
				dayOfYearCase = services.get(i).dateJobDayOfYear();
				if((dayOfYearCase - dayOfYearGiven) <= 7){

					reply += services.get(i).getPrice();

				}
			}
			
		}

		return reply;
	}
	
	public int weeklyIncomeCounter(Dates initialDate){
		int reply = 0;
		int dayOfYearGiven = initialDate.calculateDayOfTheYear();
		int dayOfYearCase = 0;

		for (int i = 0; i < services.size() ; i++ ) {
			Service serviceInMatter = services.get(i);

			if(initialDate.getYear() == serviceInMatter.getDatesR().getYear()){
				dayOfYearCase = services.get(i).dateJobDayOfYear();
				if((dayOfYearCase - dayOfYearGiven) <= 7){

					++reply;

				}
			}
			
		}

		return reply;
	}

	/**
	*This method allows to get the added price for a specific service or the price of every service added
	*@param serviceSelection Means what service's price is needed, 0 means the price of all services added
	*@return The added price of a specific service or the price of every service 
	*/

	public double servicesFees(int serviceSelection){
		double reply = 0.0;
		switch (serviceSelection) {
			case 0:
				reply += feeServices(Service.BATH);
				reply += feeServices(Service.BATHDOM);
				reply += feeServices(Service.TEETH);
				reply += feeServices(Service.NAILS);
				reply += feeServices(Service.SHOT);
				break;
			case 1:
				reply = feeServices(Service.BATH);
				break;
			case 2:
				reply = feeServices(Service.BATHDOM);
				break;
			case 3:
				reply = feeServices(Service.TEETH);
				break;
			case 4:
				reply = feeServices(Service.NAILS);
				break;
			case 5:
				reply = feeServices(Service.SHOT);
				break;	
		}
		return reply;
	}

	
	

	/**
	*This method allows to get the added price of all services rendered of a specific type of service
	*@param serviceChar The type of service
	*@return The price of a specific service or the price of every service added
	*/

	public double feeServices(char serviceChar){
		double reply = 0.0;

		for (int i = 0; i<services.size() ; i++ ) {
			if(serviceChar == services.get(i).getType()){
				reply += services.get(i).getPrice();
			}	
		}
		return reply;
	}
	
	/** 
	*This method shows the information of a pet
	*@return String message- returns in a message with the information of the pet, name, age, weight and type of animal
	*/
	public String showInfoPets(){
		String message ="";
		message +="My name is:" + name;
		message +="\nMy age is:" + age;
		message +="\nMy weight is:" + weight;
		
		if(typeOfPet.equals(Pet.DOG)){
			message+="\nI'm a " +typeOfPet;
		}
		else if(typeOfPet.equals(Pet.CAT)){
			message+="\nI'm a " +typeOfPet;
		}
		else if(typeOfPet.equals(Pet.BIRD)){
			message+="\nI'm a " +typeOfPet;
		}
		else if(typeOfPet.equals(Pet.OTHER)){
			message+="\nI'm a "+ typeOfPet;
		}
		
		return message;
	}
	
	public String identifierOwner(){
		return own.getId();
	}


	
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The BMI is calculated.
	*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
	*/
	public int IMC(){
		int imc=0;
		if(height<=0){
			imc+= -1;
		}
		else{
			imc+=(weight/Math.pow(height,2));
		}
		return imc;
	}
	
	
	/**
	*When registering a new service, this method allows to add a service to the Array that a pet has
	*pre: The service has been created before invocating this method
	*post: The service is added to the Array that a pet has
	*@param newService The service. This param must not be null
	*/
	public void addService(Service newService){
		services.add(newService);
	}

	
}
