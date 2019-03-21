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
	public void setCustomer(ArrayList<Client> humanClient){
		this.humanClient = humanClient;
	}
	


}