package model;
public class Dates{
	//Attributes
	private int day;
	private int month;
	private int year;	
	
	
	/**
	*The constructor method of the Dates class that is a date with day, month and year
	*@param day is a Day.This param must not be empty
	*@param month is a Month.This param must not be empt
	*@param year is a Years. This param must not be empty
	*/
	public Dates(int day, int month, int year){
		this.day= day;
		this.month=month;
		this.year=year;
	}
	//Setters and getters
	
	/**
	* the method gives us the day
	@return day - it returns us in the day
	*/
	public int getDay(){
		return day;
	}
	/**
	*this method allows changing the day
	*Post: the day is changed for another day
	*@param day - it's the day
	*/
	public void setDay(int day){
		this.day= day;
	}
	/**
	* the method gives us the month
	@return month - it returns us in the month
	*/
	public int getMonth(){
		return month;
	}
	/**
	*this method allows changing the month
	*Post: the month is changed for another month
	*@param month-it's the month
	*/
	public void setMonth(int month){
		this.month=month;
	}
	/**
	* the method gives us the Year
	@return year - it returns us in the year
	*/
	public int getYear(){
		return year;
	}
	/**
	*this method allows changing the year
	*Post: the year is changed for another year
	*@param year- it's the year
	*/
	public void setYear(int year){
		this.year=year;
	}
	/**
	*this method calculate in days the months
	*@return in days the months
	*/
	public int calculateDayOfTheYear(){
		return (month * 30 - (day-30));
	}
	
	/**
	* This method converts the Dates into Strings
	@return on the date
	*/
	public String convertDateToString(){
		String aDate = "";
		aDate += Integer.toString(day);
		aDate += "/";
		aDate += Integer.toString(month);
		aDate += "/";
		aDate += Integer.toString(year);
		return aDate;
	}
}