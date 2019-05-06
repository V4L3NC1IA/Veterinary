package model;
import java.util.ArrayList;
import java.io.IOException;

public class Veterinary{

	//Relations
	private ArrayList<clinicHistory> attachmets;
	private ArrayList<Client> humanClient;
	private miniRooms[] minis;
	
	//method Main
	
	public Veterinary(){
		minis = new miniRooms[8];
		attachmets = new ArrayList<clinicHistory>();
		humanClient = new ArrayList<Client>();
	}
	
	/** 
	*This method gives me a mini room of a miniRooms[]
	*@return minis-return in the rooms 
	*/
	public miniRooms[] getMinis(){
		return minis;
	}
	public void setMinis(miniRooms[] minis){
		this.minis = minis;
	}
	/**
	*this method gives me a medical prescription
	*@return attachmets- returns the name of a medical prescription
	*/
	public ArrayList<clinicHistory> getAttachmets(){
		return attachmets;
	}
	public void setAttachmets(ArrayList<clinicHistory> attachmets){
		this.attachmets = attachmets;
	}
	/** 
	*his method gives me a human client
	*@return humanClient- returns on a client
	*/
	public ArrayList<Client> getHumanClient(){
		return humanClient;
	}
	public void setHumanClient(ArrayList<Client> humanClient){
		this.humanClient = humanClient;
	}
	/**
	*This method allows me to add a client to a List
	*@param client1- this parameter allows me to register a client
	*/
	public void addClient(Client client1){
		humanClient.add(client1);
	}
	/**
	*this method adds a clinical history to a list
	*@param history1- this parameter allows me to add a clinical history to a list
	*/
	public void addHistorys(clinicHistory history1){
		attachmets.add(history1);
	}

	/**
	*this method looks for if a client is registered in the veterinary
	*@param Id- is the identification of a client
	*@return clientx- returns whether the client is registered or not
	*/
	public boolean findClient(String Id){
		boolean clientx = false;
		for(int i = 0;i < humanClient.size() && !clientx; i++){
			if(Id.equals(humanClient.get(i).getId())){
				clientx = true;
				}
		}
		return clientx;
	}

	/**
	*this method looks for if a client is registered in the veterinary
	*@param id- is the identification of a client
	*@return client1- returns to the client I was looking for
	*/
	public Client clint(String id){
		Client client1 = null;
		boolean clienteJ = false;
		if(findClient(id) == true){
			for(int i = 0; !clienteJ && i < humanClient.size(); i++){
				if(id.equals(humanClient.get(i).getId())){
					client1 = humanClient.get(i);
					clienteJ = true;
				}
			}
		}
		return client1;
	}

	/**
	*this method looks for the rooms that are available
	*@return isAvailable- return in available rooms
	*/
	public boolean availableRoom(){
		boolean isAvailable = false;
		for(int i = 0; !isAvailable && i < minis.length; i++){
			if(minis[i].getAvailable() == true){
				isAvailable = true;
			}
		}
		return isAvailable;
	}

	/** 
	*This method hospitalizes a pet, only if any room is available
	@param history1- is the clinical history of the pet
	*/
	public void hospitalizeAPet(clinicHistory history1){
		boolean roomAvailable = false;
		for(int i = 0; !roomAvailable && i < minis.length; i++){
			if(minis[i].getAvailable() == true){
				minis[i].setAvailable(false);
				minis[i].setHistory(history1);
				roomAvailable = true;
			}
		}
	}
	
	/**
	*This method generates a report of the pets that are hosted
	*@return msg- generate the report
	*/
	public String report(){
		String msg = "";
		if(numberRoomsAvailable() == 8){
			msg = "There is not pets hospitalized";
		}
		else{
		for(int i = 0; i < minis.length; i++){
			if(minis[i].getAvailable() == false){
				msg += minis[i].reportRooms();
			}
		}
		}
		return msg;
	}
	
	
	
	public char convertChoise2Char(int service){
		char answer = 'a';
		switch (service) {
			case 1:
			answer = 'b';
				break;
			case 2:
			answer = 'd';
				break;
			case 3:
			answer = 't';
				break;
			case 4:
			answer = 'n';
				break;
			case 5:
			answer = 's';
				break;
			default:
				break;	
		}
		return answer;
	}
	
	
	/**
	*This method searches if a room is available
	*@param number- is the number of the room you want to see if you have availability
	*@return available- returns in true and false, if the room with the parameter is available or not
	*/
	public boolean roomOccupied(int number){
		boolean available = false;
		if(minis[number].getAvailable() == false){
			available = true;
		}
		return available;
	}
	
	/** 
	*This method shows the number of rooms which are available
	*@return occupiedRooms- return in a message with the number of rooms available
	*/
	public String occupiedRooms(){
		String msg = "";
        for(int i = 0; i < minis.length; i++){
			if(minis[i].getAvailable() == false){
				msg += "\n"+minis[i].getNumberOfMiniRoom()+". "+"If the pet is in the room "+minis[i].getNumberOfMiniRoom();
			}
		}
		return msg;		
	}
	
	
	public String contactOwner(int number){
		return minis[number-1].contactOwn();
	}
	

	public String roomReport(int position){
		String msg = "";
		msg = minis[position-1].reportRooms();
		return msg;
	}
	
	
	public void statusHistory(int position, boolean status){
		minis[position-1].statusHistory(status);
	}
	

	public void exitDate(int position, Dates exitDate){
		minis[position-1].exitDate(exitDate);
	}
	
	/**
	*This method looks for the amount of hospitalization room that are available
	*@return total- returns the total of available rooms
	*/
	public int numberRoomsAvailable(){
		int total = 0;
		for(int i = 0; i < minis.length; i++){
			if(minis[i].getAvailable() == true){
				total++;
			}
		}
		return total;
	}
	
	
	public void availabilityRoom(int position, boolean available){
		minis[position-1].setAvailable(available);
	}
	/** 
	*This method allows to generate a report of the clinical histories
	*@return reportsRecord- generates a message with the report of the clinical histories, that has been given in the method of the stories
	*/
	public String reportsRecord(){
		String msg = "";
		if(attachmets.isEmpty()){
			msg += "There is not clinic histories";
		}
		else{
			for(int i = 0; i < attachmets.size(); i++){
			msg += attachmets.get(i).report();
		}
		}
		return msg;
	}
	
	/**
	*allows to eliminate a pet from the veterinary
	*@param id- is the identification of an owner
	*@param theName- is the name of pets of the owner
	*@return- the pet is eliminated
	*/
	public String eliminatePet(String id, String theName){
		String msg = "";
		for(int i = 0; i < humanClient.size(); i++){
			if(humanClient.get(i).getId().equals(id)){
				msg = humanClient.get(i).eliminatePet(theName);
			}
		}
		return msg;
	}
	
	/**
	*allows to eliminate a client from the veterinary
	*@param id- is the identification of an owner
	*@return msg- returns in a message with the customer removed
	*/
	public String eliminateClient(String id){
		String msg = "";
		for(int i = 0; i < humanClient.size(); i++){
			if(humanClient.get(i).getId().equals(id)){
				humanClient.remove(i);
				msg = "The client was eliminate successfuly";
			}
		}
		return msg;
	}
	/**
	*This method calculates the total earnings of the veterinarian
	*@return earns- returns a double with the total earnings of the veterinarian
	*/
	public double MyLittlePetEarnings(){
		double earns = 0.0;
		for(int i = 0; i < attachmets.size(); i++){
			earns += attachmets.get(i).hospitalizationCost();
		}
		return earns;
	}
	/**
	*This method searches if a client is registered in the veterinary
	*@param clients -is the name of a client
	*@param clientsId- is the identification of a client
	*@return thePerson- returns on the client you are looking for
	*/
	public Client findPerson(String clients, String clientsId){
		Client thePerson = null;

		boolean theStop = false;

		for (int i = 0; i < humanClient.size() && !theStop ; i++ ) {

			if ((humanClient.get(i).getName()).equalsIgnoreCase(clients) && (humanClient.get(i).getId()).equalsIgnoreCase(clientsId)){
				thePerson = humanClient.get(i);
				theStop = true;
			}
		}
			return thePerson;
	}
	
	/**
	*allows to display the information of one of the clients
	*@param clients - is the name of a client
	*@param clientsId - is the identification of a client
	*@return reply- returns in a report with the information of a client
	*/
	public String showClientsInfo(String clients, String clientsId){
		String reply = "*******************************************************\n";
			   reply += "* ERROR: There is not a client with that name and ID. *\n";
		 	   reply += "*******************************************************";

		Client humanClient = findPerson(clients, clientsId);

		if(humanClient != null){
			reply = humanClient.clientInfo();
		}
		return reply;		
	}
	
	/**
	*this method is given in the room a pet is hospitalized
	*@param id - is the id of the pet owner
	*@param namep - is the name of the pet
	*@return number- we return the room number that a pet is hospitalized
	*/
	public int numberRoom(String id, String namep){
		int number = 0;
		boolean finded = false;
		for(int i = 0; !finded && i < minis.length; i++){
			if(minis[i].getHistory() != null && minis[i].samePet(id, namep) == true){
				number = minis[i].getNumberOfMiniRoom();
				finded = true;
			}
		}
		return number;
	}
	/** 
	*This method returns a client
	*@param id- is the identification of a client
	*@return cliente1-returns a client
	*/
	public Client returnClient(String id){
		Client client1 = null;
		boolean clientFinded = false;
		if(findClient(id) == true){
			for(int i = 0; !clientFinded && i < humanClient.size(); i++){
				if(id.equals(humanClient.get(i).getId())){
					client1 = humanClient.get(i);
					clientFinded = true;
				}
			}
		}
		return client1;
	}

	
	/** 
	*This method generates a message with the clinical history of a pet
	*@param name  is the name of a client
	*@param identifier is the id of a client
	*@return String msg- returns in a message with the clinical report of a pet
	*/
	
	public String historyPet(String name, String identifier){
		String msg = "";
		for(int i = 0; i < attachmets.size(); i++){
			if(attachmets.get(i).nameP().equals(name) && attachmets.get(i).ownerIdentifier().equals(identifier)){
				msg += attachmets.get(i).report();
			}
		}
		for(int i = 0; i < minis.length; i++){
			if(minis[i].getHistory() != null && minis[i].getHistory().nameP().equals(name) && minis[i].getHistory().ownerIdentifier().equals(identifier)){
				msg += minis[i].getHistory().report();
			}
		}
		return msg;
	}
	
	public Pet petRelation(String name, String  id, String  petsName){
		Pet relationshipOfPet = null;

		Client own = findPerson(name, id);
			if (own != null){
				relationshipOfPet = own.givePet(petsName);
			}

		return relationshipOfPet;
	}
	/**
	*this method looks if a customer is registered with their pet
	*@param name is the name of a client
	*@param id is the id of a client
	*@param petsName is the pet name of a client
	*@return isReal- return in boolean
	*/
	public boolean checkOwner(String name, String id, String petsName){
		boolean isReal = false;
		String evaluation = showClientsInfo(name, id);

		if(evaluation.charAt(0) != '*' && evaluation.toLowerCase().contains(petsName.toLowerCase())){

			isReal = true;
		}

		return isReal;

	}
	/**
	*this method calculates the amount of earnings for a service rendered
	*@param serviceSelection -is any of the services provided
	*@return reply- is the profit for the services rendered
	*/
	public double EarningsVeterinaryServices(int serviceSelection){
		double reply = 0;
		switch (serviceSelection) {
			case 0:
				reply += RatesOwners(1);
				reply += RatesOwners(2);
				reply += RatesOwners(3);
				reply += RatesOwners(4);
				reply += RatesOwners(5);
				break;
			default:
				reply = RatesOwners(serviceSelection);	
				break;
		}
		return reply;
	}


	public double RatesOwners(int serviceSelection){
		double reply = 0.0;
		for (int i = 0; i<humanClient.size() ; i++ ) {
			reply += humanClient.get(i).petsFeeServices(serviceSelection);	
		}
		return reply;

	}
	
	
	/**
	*this method gives the total profit of a the veterinary
	*@return earnings-total earnings of a the veterinary
	*/
	public double TotalRevenue(){
		double earnings = 0.0;

		earnings += MyLittlePetEarnings();
		earnings += EarningsVeterinaryServices(0);

		return earnings;
	}
	
	public double weeklyAverageIncome(Dates Idates){
		double reply = 0;
		int counter = 0;
		
		for (int i = 0; i < humanClient.size()  ; i++ ) {
			 
			 reply += humanClient.get(i).petsServicesWeeklyIncome(Idates);
			 counter += humanClient.get(i).petServicesWeeklyIncome(Idates);	
		}

		reply = reply / counter;


		return reply;
	}
	/**
	*allows to start the veterinary service
	*@param name- is the name of a client
	*@param id- is the id of a client
	*@param clientPet- it's the mascot
	*@param newService- is the new service that is the veterinary
	*/
	public void startServiceVet(String name, String id, Pet clientPet, Service newService){
		Client humanClient = findPerson(name,id);
		if (humanClient != null){
			humanClient.startServicePets(clientPet, newService);
		}

	}

}