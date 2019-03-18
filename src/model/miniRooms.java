package model;
public class miniRooms{

	//attributes
	private boolean available;
	private String name;
	
	//relations
	private clinicHistory historial;
	
	//method Main
	public miniRooms(boolean available, String name){
		this.available = available;
		this.name = name;
	}
	
	//Setters and getters
	public boolean getAvailable(){
		return available;
	}
	public void setAvailable(){
		this.available = available;
	}
	public String getName(){
		return name;	
	}
	public void setName(){
		this.name=name;
	}

}