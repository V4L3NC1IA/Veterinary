package model;

public class Pet{
	//attributes
	private String name;
	private String typeOfPet;
	private int age;
	private double weight;
	public final static char DOG = 'D';
	public final static char CAT = 'C';
	public final static char BIRD = 'B';
	public final static char OTHER = 'O';
	
	//Method main
	public Pet(String theName,String theTypeOfPet, int theAge, double theWeight){
		name= theName;
		typeOfPet= theTypeOfPet;
		age= theAge;
		weight= theWeight;
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
}