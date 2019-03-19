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
	private Dates date;

	//method Main
	public clinicHistory(ArrayList<Pet> historyPet, boolean status, String diagnostic, String symptoms, double costForDay, Dates date, ArrayList<PrescripcionMedical> drugs){
		this.historyPet = historyPet;
		this.status= status;
		this.diagnostic = diagnostic;
		this.symptoms = symptoms;
		this.costForDay = costForDay;
		this.date= date;
		this.drugs= drugs;
	}

}