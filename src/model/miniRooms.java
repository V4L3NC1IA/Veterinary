package model;
public class miniRooms{

	//attributes
	
	//relations
		private clinicHistory historial;
		
		private boolean available;
		private int numberOfMiniRoom;
		private String pet;
		private String owner;


	

	/**
	*Constructor method for class MiniRoom which is mini room of the veterinary where pets are hospitalized, there are only 8 mini rooms
	*@param available The mini room availability
	*@param numberOfMiniRoom The mini room number
	*@param historial is the clinical history of a pet
	*/
	public miniRooms(boolean available, int numberOfMiniRoom, clinicHistory historial){
		this.available = available;
		this.numberOfMiniRoom = numberOfMiniRoom;
		this.historial=historial;

	}

	/**
	*Allows to get mini room's availability
	*@return Mini room's availability 
	*/
	public  boolean getAvailable() {
		return available;
	}
	/**
	*Allows to change mini room's availability
	*post: The mini room's availability is changed 
	*@param available Mini room's availability
	*/

	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	*Allows to get the mini room's number
	*@return Mini room's number 
	*/
	public  int getNumberOfMiniRoom() {
		return numberOfMiniRoom;
	}
	/**
	*Allows to change mini room's number
	*post: The mini room's number is changed
	*@param numberOfMiniRoom Mini room's number
	*/

	public void setNumberOfMiniRoom(int numberOfMiniRoom) {
		this.numberOfMiniRoom = numberOfMiniRoom;
	}

	/**
	*Allows to get mini room's availability
	*@return Mini room's availability 
	*/
	public clinicHistory getHistory(){
		return historial;
	}
	/**
	*Allows to change mini room's number
	*post: The mini room's number is changed
	*@param historial numberOfMiniRoom Mini room's number
	*/
	public void setHistory(clinicHistory historial){
		this.historial=historial;
	}
	
	/** 
	*This method gives the report of a room where a pet is hospitalized
	*@return String reportRooms- gives a report of the rooms that are occupied
	*/
	public String reportRooms(){
		String msg = "";
		msg += "\nThe room "+getNumberOfMiniRoom()+":";
		msg += historial.report();
		return msg;
	}

	/**
	*This method gives the name of a client
	*@return String name- I returned the name of a client
	*/
	public String contactOwn(){
		return historial.contactOwner();
	}
	
	
	public void exitDate(Dates exit){
		historial.setExitDate(exit);
	}
	
	
	public void statusHistory(boolean status){
		getHistory().setStatus(status);
	}
	
	/** 
	*This method gives the cost of hospitalization for a pet
	*@return double costHospitalizacion- the cost of a hospitalization returns
	*/
	public double costHospitalizacion(){
		return historial.hospitalizationCost();
	}
	
	/** 
	*This method searches if a pet is registered, through the owner's Id and the name of the pet
	*@param id - is the id of a client different from null
	*@param namep - is the name of a pet different from null
	*@return same- returns in a true or false boolean, if the pet or registered client is
	*/
	public boolean samePet(String id, String namep){
		boolean same = false;
		if(id.equals(historial.identifierOwner()) && namep.equals(historial.nameP())){
			same = true;
		}
		return same;
	}

}