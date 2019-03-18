package model;
import java.util.ArrayList;

public class Client{
	//Attributes
	private String name;
	private int id;
	private int address;
	private int telephoneContac;
	
	//Relations
	private ArrayList <Pet> pets;

	//method main
	public Client(String theName,int theId, int theAddress, int ThetelephoneContac){
		name = theName;
		id = theId;
		address = theAddress;
		telephoneContac = ThetelephoneContac; 
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
	public int getAddress(){
		return address;
	}
	public void setAddress(int address){
		this.address= address;
	}
	public int getTelephoneContac(){
		return telephoneContac;
	}
	public void setTelephoneContac(int telephoneContac){
		this.telephoneContac=telephoneContac;
	}
}