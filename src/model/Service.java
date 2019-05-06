package model;

public class Service{

	public final static double BATHP = 20000 ;
	public final static double BATHDOMP = 3000;
	public final static double TEETHP = 12000;
	public final static double NAILSP = 8000;
	public final static double SHOTP = 45000;

	public final static char BATH = 'b';
	public final static char BATHDOM = 'd';
	public final static char TEETH = 't';
	public final static char NAILS = 'n';
	public final static char SHOT = 's';


	
	private char type;
	private double price;
	private String ownerId;
	private String petId;


	private Pet petService;
	private Dates dateR;



	

	/**
	* Constructor method for class Service which is a service offered by the veterinary.
	* @param type The type of service. This param can only be 'b', 'd', 't', 'n' or 's'. It won't get any other char
	* @param ownerId The pet's owner ID. This param must not be empty
	* @param petId The pet's name. This param must not be empty
	* @param petService The pet (object). This param must not be null
	* @param dateR The date (object) when the service took place. This param must not be null
	*/

	public Service(char type, String ownerId, String petId, Pet petService, Dates dateR){
		this.type = type;
		this.ownerId = ownerId;
		this.petId = petId;
		this.petService = petService;
		this.dateR = dateR;
		price = setInitialPrice();
	}

	/**
	* Allows to get the type of a service
	* @return The type of a service
	*/

	public  char getType() {
		return type;
	}


	/**
	* Allows to change the type of service for a service 
	* post: The type of service for a service is changed. 
	* @param type The type of service
	*/

	public void setType(char type) {
		this.type = type;
	}

	/**
	* Allows to get the price of a service
	* @return The price of a service
	*/
	public  double getPrice() {
		return price;
	}

	/**
	* Allows to get the pet's owner ID of the service
	* @return The pet owner ID
	*/
	public  String getOwnerId() {
		return ownerId;
	}


	/**
	*Allows to change the pet's owner ID of the service
	*post: The pet's owner ID for a service is changed. 
	*@param ownerId The pet owner ID
	*/

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}



	/**
	* Allows to get the pet's name from a service 
	* @return The pet's name
	*/
	public  String getPetId() {
		return petId;
	}


	/**
	* Allows to change the pet's name of the service 
	* post: The pet's name for a service is changed. 
	* @param petId The pet's name
	*/

	public void setPetId(String petId) {
		this.petId = petId;
	}


	/**
	* Allows to get the pet from a service
	* @return The pet 
	*/

	public  Pet getPetService() {
		return petService;
	}


	/**
	* Allows to change the pet of the service 
	* post: The pet  for a service is changed. 
	* @param petService The pet 
	*/

	public void setPetService(Pet petService) {
		this.petService = petService;
	}


	/**
	* Allows to get the date when a service took place
	* @return The date  when a service took place
	*/
	public Dates getDatesR() {
		return dateR;
	}


	/**
	* Allows to change the date when the service took place of the service 
	* post: The date when the service took place for a service is changed. 
	* @param dateR The date  when the service took place
	*/

	public void setDater(Dates dateR) {
		this.dateR = dateR;
	}

	/**
	* Allows to assign the cost of a service depending on the type of service
	* @return The cost of a service
	*/
	public double setInitialPrice(){
		double cost = 0.0;

		switch (type) {
			case 'b':
				cost = BATHP;
				break;
			case 'd':
				cost = BATHDOMP;
				break;
			case 't':
				cost = TEETHP;
				break;
			case 'n':
				cost = NAILSP;
				break;
			case 's':
				cost = SHOTP;
				break;	
		}

		return cost;
	}


	/**
	* Information of a serviced such as: type of service, service's price, pet's owner ID, pet who got the service's name and date when the service took place
	* pre: This method must be invocated over an existing service 
	* @return The information of a service in a format to be shown to the final user
	*/

	public String toString(){
		String reply = "\n";
			   reply += "\n";
			   reply += "+-----------------------------------------------------------------------------+\n";
			   reply += "| Service: "+type2String(type)+"\n";
			   reply += "| Price: "+price+" COP\n";
			   reply += "| Owner ID: "+ownerId+"\n";
			   reply += "| Pet's name: " +petId+ "\n";
			   reply += "| Date of the service: " +dateR.convertDateToString()+"\n";
			   reply += "+-----------------------------------------------------------------------------+\n";
		return reply;

	}

	/**
	* This method "translates" the type of service from a char to String so it can be understood to the final user
	* pre: This method must be invocated over an existing service
	* @param type This param can only be 'b', 'd', 't', 'n' or 's'. It won't get any other char.
	* @return The type of service 
	*/
	public String type2String(char type){
		String word = "";
		switch (type) {
			case BATH:
				word = "Bath";
				break;
			case BATHDOM:
				word = "Bath to go";
				break;
			case TEETH:
				word = "Dental prophylaxis";
				break;
			case NAILS:
				word = "Cutting nails";
				break;
			case SHOT:
				word = "Vaccination";
				break;	
		}
		return word;
	}

	
	/**
	*this method calculates the day of the year
	*@return the month or year in days
	*/
	public int dateJobDayOfYear(){
		return (dateR.calculateDayOfTheYear());
	}



} 