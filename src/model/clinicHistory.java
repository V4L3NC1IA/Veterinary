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



}