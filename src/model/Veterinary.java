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
	
	//getters and setters
	public miniRooms[] getMinis(){
		return minis;
	}
	public void setMinis(miniRooms[] minis){
		this.minis = minis;
	}
	
	public ArrayList<clinicHistory> getAttachmets(){
		return attachmets;
	}
	public void setAttachmets(ArrayList<clinicHistory> attachmets){
		this.attachmets = attachmets;
	}
	
	public ArrayList<Client> getHumanClient(){
		return humanClient;
	}
	public void setHumanClient(ArrayList<Client> humanClient){
		this.humanClient = humanClient;
	}
	public void addClient(Client client1){
		humanClient.add(client1);
	}

	public void addHistorys(clinicHistory history1){
		attachmets.add(history1);
	}


	public boolean findClient(String Id){
		boolean clientx = false;
		for(int i = 0;i < humanClient.size() && !clientx; i++){
			if(Id.equals(humanClient.get(i).getId())){
				clientx = true;
				}
		}
		return clientx;
	}

	
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

	
	public boolean availableRoom(){
		boolean isAvailable = false;
		for(int i = 0; !isAvailable && i < minis.length; i++){
			if(minis[i].getAvailable() == true){
				isAvailable = true;
			}
		}
		return isAvailable;
	}

	
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
	

	public boolean roomOccupied(int number){
		boolean available = false;
		if(minis[number].getAvailable() == false){
			available = true;
		}
		return available;
	}
	
	
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
	
	
	public double MyLittlePetEarnings(){
		double earns = 0.0;
		for(int i = 0; i < attachmets.size(); i++){
			earns += attachmets.get(i).hospitalizationCost();
		}
		return earns;
	}
	

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

}