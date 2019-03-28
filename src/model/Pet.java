package model;

public class Pet{
	//attributes
	private String name;
	private String typeOfPet;
	private int age;
	private double weight;
	public final static String DOG = "Dog";
	public final static String CAT = "Cat";
	public final static String BIRD = "Bird";
	public final static String OTHER = "Other";
	// 
	public Client own;
	
	//Method main
	public Pet(String theName,String theTypeOfPet, int theAge, double theWeight, Client own){
		name= theName;
		typeOfPet= theTypeOfPet;
		age= theAge;
		weight= theWeight;
		this.own=own;
	}
	
	//Setters and Getters
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name= name;
	}
	public String getTypeOfPet(){
		return typeOfPet;
	}
	public void setTypeOfPet(String typeOfPet){
		this.typeOfPet= typeOfPet;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	public Client getOwn(){
		return own;
	}
	public void setOwner(Client own){
		this.own = own;
	}
	
	public String nameOwner(){
		return own.getName();
	}

	public String idOwner(){
		return own.getId();
	}
	
	public String infoOwner(){
		return own.owneInfo();
	}
	
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

	
}
