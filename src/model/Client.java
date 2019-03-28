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
	

	//method main
	public Client(String theName,String theId, String theAddress, int ThetelephoneContac){
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
	public String getId(){
		return id;
	}
	public void setId(String id){
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
	public void addPets(Pet petsito){
	  pets.add(petsito);
	}
	
	public String owneInfo(){
		String msj="";
	
		msj += "The owners name is: "+name+"\n";
		msj += "The owners id is: "+id+"\n";
		msj += "The owners address is: "+address+"\n";
		msj += "The owners phone contac is: "+telephoneContac+"\n";
		return msj;
	}
	
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
	
	
	
	/*
	public void startHospitalizePers(String namePet, clinicHistory historyClinic, ArrayList<PrescripcionMedical> medicinePet){


		boolean loopStop = false;

		for (int i = 0; i < pets.size() && !loopStop ; i++ ) {

			if ((pets.get(i).getName()).equalsIgnoreCase(namePet)) {

				loopStop = true;

				pets.get(i).addMedRec(historyClinic, medicinePet);

			}
		}
	}	
	/*/
	
	
	
	
}