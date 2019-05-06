package model;
public class PrescripcionMedical{

	//Attributes
	private String name;
	private double dose;
	private double costForDose;
	private double frequencyDose;
	
	/**
	* Constructor method for class ReqMed which is a prescribed medication. 
	* @param name The name of a prescribed medication. This param must not be empty.
	* @param dose The dose of a prescribed medication. This param must be greater than zero.
	* @param costForDose The price per dose of a prescribed medication. This param must be greater or equal to zero.
	* @param frequencyDose The frecuency of a prescribed medication.
	*/
	
	public PrescripcionMedical(String name, double dose, double costForDose, double frequencyDose){
		this.name = name;
		this.dose = dose;
		this.costForDose = costForDose;
		this.frequencyDose = frequencyDose;
	}

	/**
	*Allows to get the name of a prescribed medication
	*@return The name of a prescribed medication
	*/
	public String getName(){
		return name;
	}
	
	/**
	*Allows to change the name of a prescribed medication
	*post: The name of a prescribed medication is changed 
	*@param name The name of a prescribed medication. This param must not be empty
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	*Allows to get the dose of a prescribed medication
	*@return The dose of a prescribed medication
	*/
	public double getDose(){
		return dose;
	}
	/**
	*Allows to change the dose of a prescribed medication
	*post: he dose of a prescribed medication is changed
	*@param dose The dose of a prescribed medication. This param must be greater than zero
	*/
	public void setDose(double dose){
		this.dose = dose;
	}
	/**
	*Allows to get the price per dose of a prescribed medication
	*@return The price per dose of a prescribed medication
	*/
	public double getCostForDose (){
		return costForDose;
	}
	
	/**
	*Allows to change the price per dose of a prescribed medication
	*post: The price per dose of a prescribed medication is changed
	*@param costForDose The price per dose of a prescribed medication
	*/
	public void setCostForDose(double costForDose){
		this.costForDose = costForDose;
	}
	/**
	*Allows to get the frecuency of a prescribed medication
	*@return The frecuency of a prescribed medication
	*/
	public double getFrequencyDose(){
		return frequencyDose;
	}
	/**
	*Allows to change the frecuency of a prescribed medication
	*post: The frecuency of a prescribed medication is changed
	*@param frequencyDose The frecuency of a prescribed medication 
	*/
	public void setFrequencyDose(double frequencyDose){
		this.frequencyDose = frequencyDose;
	}
	
	/** 
	*This method calculates the total cost of a medication for its dose the cost per dose
	*@return double costMedicine- generates the cost of a medication
	*/
	public double costMedicine(){
		double cost= dose*costForDose;
		return cost;
	}
	
	
}

