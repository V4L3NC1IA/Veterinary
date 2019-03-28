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

	//Main
	public clinicHistory(boolean status, String symptoms, String diagnostic, Pet pets, Dates joinDate, Dates exitDate){
		this.status = status;
		this.symptoms = symptoms;
		this.diagnostic = diagnostic;
		this.pets = pets;
		drugs = new ArrayList<PrescripcionMedical>();
		this.joinDate = joinDate;
		this.exitDate = exitDate;
	}

	//getters and setters
	public boolean getStatus(){
		return status;
	}
	public void setStatus(boolean status){
		this.status = status;
	}

	public String getSymptoms(){
		return symptoms;
	}
	public void setSymptoms(String symptoms){
		this.symptoms = symptoms;
	}

	public String getDiagnostic(){
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}

	public Pet getPets(){
		return pets;
	}
	public void setData(Pet pets){
		this.pets = pets;
	}

	public ArrayList<PrescripcionMedical> getDrugs(){
		return drugs;
	}
	public void setDrug(ArrayList<PrescripcionMedical> drugs){
		this.drugs = drugs;
	}

	public Dates getJoinDate(){
		return joinDate;
	}
	
	public void setJoinDate(Dates joinDate){
		this.joinDate = joinDate;
	}

	public Dates getExitDate(){
		return exitDate;
	}
	public void setExitDate(Dates exitDate){
		this.exitDate = exitDate;
	}

	public void addDrugs(PrescripcionMedical drugOn){
		drugs.add(drugOn);
	}
	
	/*public void addHistoryPet(Pet history){
		clinicHistory.add(history);
	}
	/*/
	
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
	public double hospitalizationCost(){
		double costTo = 0.0;
		costTo+=pets.DailyCostForHospitalization();
		for(int i = 0; i < drugs.size(); i++){
			costTo += drugs.get(i).costMedicine();
		}
		return costTo;
	}
	
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

	public String contactOwner(){
		return pets.infoOwner();
	}
	
	
	
	public String identifierOwner(){
		return pets.idOwner();
	}
	
	
	public String nameP(){
		return pets.getName();
	}
	

	public String ownerIdentifier(){
		return pets.identifierOwner();
	}
	
}