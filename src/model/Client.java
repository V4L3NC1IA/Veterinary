package model;
import java.util.ArrayList;

public class Client{
	//Attributes
	private String name;
	private int id;
	private String address;
	private int telephoneContac;
	
	//Relations
	private ArrayList <Pet> pets;
	

	//method main
	public Client(String theName,int theId, String theAddress, int ThetelephoneContac){
		this.name = name;
		this.id = id;
		this.address = address;
		this.telephoneContac = telephoneContac;
		pets= new ArrayList<Pet>();
	}
	//Setters and Getters
	public String getName (){
		return name;
	}
	public void setName(String name){
		this.name= name;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address= address;
	}
	public int getTelephoneContac(){
		return telephoneContac;
	}
	public void setTelephoneContac(int telephoneContac){
		this.telephoneContac=telephoneContac;
	}
	public ArrayList<Pet> getPets(){
		return pets;
	}
	public void setList(ArrayList<Pet> pets){
		this.pets = pets;
	}
	
	public void addPet(Pet petsito){
		pets.add(petsito);
	}
	
	//public String addClient(){}
}