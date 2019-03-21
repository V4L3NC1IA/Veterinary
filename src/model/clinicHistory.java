package model;
import java.util.ArrayList;


public class clinicHistory{

	//Attributes
	private boolean status;
	private String diagnostic;
	private String symptoms;
	private double costForDay;

	//Relations
	private ArrayList<PrescripcionMedical>	drugs;
	private ArrayList<Pet> historyPet;
	private Dates joinDate;
	private Dates exitDate;

	//method Main
	public clinicHistory(boolean status, String diagnostic, String symptoms, double costForDay, Dates joinDate, Dates exitDate){
		this.historyPet = historyPet;
		this.status= status;
		this.diagnostic = diagnostic;
		this.symptoms = symptoms;
		this.costForDay = costForDay;
		this.joinDate=joinDate;
		this.exitDate=exitDate;
		this.drugs= drugs;
		historyPet= new ArrayList<Pet>();
		drugs= new ArrayList<PrescripcionMedical>();
	}
	//Setters and Getters
	public boolean getStatus(){
		return status;
	}
	public void setStatus(boolean status){
		this.status=status;
	}
	public String getDiagnostic(){
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic){
		this.diagnostic=diagnostic;
	}
	public String getSymptoms(){
		return symptoms;
	}
	public void setSymptoms(String symptoms){
		this.symptoms=symptoms;
	}
	public double getCostForDay(){
		return costForDay;
	}
	public void setCostForDay(double costForDay){
		this.costForDay=costForDay;
	}
	public ArrayList<PrescripcionMedical> getDrugs(){
		return drugs;
	}
	public void setDrugs(ArrayList<PrescripcionMedical> drugs){
		this.drugs=drugs;
	}
	
	public void addHistoryPet(Pet history){
		historyPet.add(history);
	}
	public void addDrugs(PrescripcionMedical Drugs){
		drugs.add(Drugs);
	}
}