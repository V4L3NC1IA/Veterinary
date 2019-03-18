package model;
public class PrescripcionMedical{

	//Attributes
	private String name;
	private double dose;
	private double costForDose;
	private double frequencyDose;
	
	//method main
	public PrescripcionMedical(String name, double dose, double costForDose, double frequencyDose){
		this.name = name;
		this.dose = dose;
		this.costForDose = costForDose;
		this.frequencyDose = frequencyDose;
	}

	//Setters and getters
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public double getDose(){
		return dose;
	}
	public void setDose(double dose){
		this.dose = dose;
	}
	public double getCostForDose (){
		return costForDose;
	}
	public void setCostForDose(double costForDose){
		this.costForDose = costForDose;
	}
	public double getFrequencyDose(){
		return frequencyDose;
	}
	public void setFrequencyDose(double frequencyDose){
		this.frequencyDose = frequencyDose;
	}
}