package model;
import java.util.*;

public class clinicHistory {

	//attributes
	private boolean status;//if the pet is hospitalized is true
	private String symptoms;
	private String diagnostic;

	//relations
	private Pet pets;
	private ArrayList<PrescripcionMedical> drugs;
	private Dates joinDate;
	private Dates exitDate;

	/**
	* Constructor method for class clinicHistory which is a medical record for the veterinary
	* @param status It is the state of the pet whether or not it is hospitalized
	* @param symptoms The symptoms of the pet for the medical record
	* @param pets is the pet which is in the clinical history
	* @param diagnostic The diagnosys of the pet for the medical record. 
	* @param joinDate The date when the hospitalization started. This param must not be null
	* @param exitDate The pet in matter for the medical record. This param must not be null
	*/
	
	public clinicHistory(boolean status, String symptoms, String diagnostic, Pet pets, Dates joinDate, Dates exitDate){
		this.status = status;
		this.symptoms = symptoms;
		this.diagnostic = diagnostic;
		this.pets = pets;
		drugs = new ArrayList<PrescripcionMedical>();
		this.joinDate = joinDate;
		this.exitDate = exitDate;
	}

	/**
	*Allows to get the status (open or closed) of a medical record
	*@return The status of a medical record
	*/
	public boolean getStatus(){
		return status;
	}
	/**
	*Allows to change the status of a hospitalization
	*post: The status of a hospitalization is changed 
	*@param status The status (open/closed) of a hospitalization
	*/
	public void setStatus(boolean status){
		this.status = status;
	}
	
	/**
	*Allows to get the symptoms of a medical record
	*@return The symptoms of a medical record
	*/
	public String getSymptoms(){
		return symptoms;
	}
	/**
	*Allows to change the symptoms of a hospitalization
	*post:The symptoms of a hospitalization is changed 
	*@param symptoms The symptoms of a hospitalization
	*/
	
	public void setSymptoms(String symptoms){
		this.symptoms = symptoms;
	}
	/**
	*Allows to get the diagnostic of a medical record
	*@return The diagnostic of a medical record
	*/
	public String getDiagnostic(){
		return diagnostic;
	}
	
	/**
	*Allows to change the diagnostic of a hospitalization
	*post: The diagnostic of a hospitalization is changed
	*@param diagnostic The diagnostic of a hospitalization
	*/

	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}
	
	
	public Pet getPets(){
		return pets;
	}
	
	//public void setData(Pet pets){
	//	this.pets = pets;
	//}
	
	/**
	*This method gives the pet's medicines
	@return drugs- return in a pet's medicine
	*/
	public ArrayList<PrescripcionMedical> getDrugs(){
		return drugs;
	}
	public void setDrug(ArrayList<PrescripcionMedical> drugs){
		this.drugs = drugs;
	}
	
	/**
	* Allows to get the date when the veterinary created the medical record
	* @return The date when the veterinary created the medical record
	*/
	public Dates getJoinDate(){
		return joinDate;
	}
	/**
	*Allows to change the date when the hospitalization started
	*post: The date when the hospitalization started is changed
	*@param joinDate The date when the hospitalization started
	*/
	public void setJoinDate(Dates joinDate){
		this.joinDate = joinDate;
	}	
	/**
	*Allows to get the date when the veterinary discharged the medical record
	*@return The date when the veterinary discharged the medical record
	*/
	public Dates getExitDate(){
		return exitDate;
	}
	/**
	*Allows to change the date  when the hospitalization ended
	*post: The date  when the hospitalization ended is changed 
	*@param exitDate The date  when the hospitalization ended
	*/
	public void setExitDate(Dates exitDate){
		this.exitDate = exitDate;
	}
	
	
	public void addDrugs(PrescripcionMedical drugOn){
		drugs.add(drugOn);
	}
	
	
	/**
	*This method calculates the days of hospitalization that a pet takes
	@return int day - returns an entire with the days the pet has been hospitalized
	*/
	public int daysforHospitalized(){
		int days = 0;
		if(exitDate == null){
			GregorianCalendar date = new GregorianCalendar(joinDate.getYear(), joinDate.getMonth() - 1, joinDate.getDay());
			GregorianCalendar actualDate = new GregorianCalendar();
			while (true) {
				if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
					&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
				    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
					break;
				}
				date.add(Calendar.DAY_OF_MONTH, 1);
				days++;
			}
		}
		else{
			GregorianCalendar date = new GregorianCalendar(joinDate.getYear(), joinDate.getMonth() - 1, joinDate.getDay());
			GregorianCalendar actualDate = new GregorianCalendar(exitDate.getYear(), exitDate.getMonth() - 1, exitDate.getDay());
			while (true) {
				if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
					&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
				    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
					break;
				}
				date.add(Calendar.DAY_OF_MONTH, 1);
				days++;
			}
		}
		return days;
	}
	
	/**
	*This method calculates the cost of hospitalization of a pet
	@return double CostTo- returns in a decimal the cost of hostimization of a pet
	*/
	public double hospitalizationCost(){
		double costTo = 0.0;
		costTo+=pets.DailyCostForHospitalization();
		for(int i = 0; i < drugs.size(); i++){
			costTo += drugs.get(i).costMedicine();
		}
		return costTo;
	}
	/**
	*This method generates a report of the name of the owner of the pet, the name of the pet, the type of animal, the symptoms, the diagnosis, the name of the prescription drugs
	@return String msg- returns in a message with the report of the data of the hopitalization of the pet
	*/
	public String report(){
		String msg = "";
		msg += "The owner is "+pets.nameOwner()+"\n";
		msg += "The pet is "+pets.getName()+"\n";
		msg += pets.getTypeOfPet()+"\n";
		msg += "The symptoms are "+getSymptoms()+"\n";
		msg += "The diagnostic is "+getDiagnostic()+"\n";
		msg += "The medicines are:"+"\n";
		for(int i = 0; i < drugs.size(); i++){
			msg += drugs.get(i).getName()+"\n";
		}
		if(exitDate == null){
			msg += "The cost of the hospitalization until now is "+hospitalizationCost()+"\n";
		}
		else{
			msg += "The cost of the hospitalization is "+hospitalizationCost()+"\n";
		}
		msg += "and the pet was admitted on "+joinDate.getDay()+"/"+joinDate.getMonth()+"/"+joinDate.getYear()+"\n";
		return msg;
	}

	/**
	*This method the information of a client
	*@return String infoOwner- return in a client's information
	*/
	public String contactOwner(){
		return pets.infoOwner();
	}
	/**
	*This method gives the identification of a client
	*@return String identifierOwner- returns in the identification of a client
	*/
	public String identifierOwner(){
		return pets.idOwner();
	}
	/**
	*This method gives the name of a pet
	*@return Strign nameP- return in the name of a pet
	*/
	public String nameP(){
		return pets.getName();
	}
	
	/** 
	*This method gives the identification of a client
	*@return String ownerIdentifier- return in the identification of a client
	*/
	public String ownerIdentifier(){
		return pets.identifierOwner();
	}
	
}	