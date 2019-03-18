package model;
public class Dates{
	//Attributes
	private int day;
	private int month;
	private int year;	
	
	
	//Method main
	public Dates(int day, int month, int year){
		this.day= day;
		this.month=month;
		this.year=year;
	}
	//Setters and getters
	
	public int getDay(){
		return day;
	}
	public void setDay(int day){
		this.day= day;
	}
	public int getMonth(){
		return month;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public int getYear(){
		return year;
	}
	public void setYear(int year){
		this.year=year;
	}
	
}