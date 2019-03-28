package model;
public class miniRooms{

	//attributes
	
	//relations
		private clinicHistory historial;
		
		private boolean available;
		private int numberOfMiniRoom;
		private String pet;
		private String owner;


	

//METHODS
	public miniRooms(boolean available, int numberOfMiniRoom, clinicHistory historial){
		this.available = available;
		this.numberOfMiniRoom = numberOfMiniRoom;
		this.historial=historial;

	}


	public  boolean getAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public  int getNumberOfMiniRoom() {
		return numberOfMiniRoom;
	}


	public void setNumberOfMiniRoom(int numberOfMiniRoom) {
		this.numberOfMiniRoom = numberOfMiniRoom;
	}


	public clinicHistory getHistory(){
		return historial;
	}
	
	public void setHistory(clinicHistory historial){
		this.historial=historial;
	}

	public String reportRooms(){
		String msg = "";
		msg += "\nThe room "+getNumberOfMiniRoom()+":";
		msg += historial.report();
		return msg;
	}

	 
	public String contactOwn(){
		return historial.contactOwner();
	}
	
	
	public void exitDate(Dates exit){
		historial.setExitDate(exit);
	}
	
	
	public void statusHistory(boolean status){
		getHistory().setStatus(status);
	}
	
	
	public double costHospitalizacion(){
		return historial.hospitalizationCost();
	}
	
	
	public boolean samePet(String id, String namep){
		boolean same = false;
		if(id.equals(historial.identifierOwner()) && namep.equals(historial.nameP())){
			same = true;
		}
		return same;
	}

}