package com.abc.steph.stores;

public class FaultsStore {

	private String Faultid;
	private String FaultSummary;
	private String FaultDetails;
	private String FaultAuthor;
	private String FaultSection;

	public FaultsStore(){

	}
	
	public String getFaultDetails() {
		return FaultDetails;
	}

	public String getFaultAuthor() {
		return FaultAuthor;
	}

	public String getFaultSection() {
		return FaultSection;
	}

	public void setFaultDetails(String faultDetails) {
		FaultDetails = faultDetails;
	}

	public void setFaultAuthor(String faultAuthor) {
		FaultAuthor = faultAuthor;
	}

	public void setFaultSection(String faultSection) {
		FaultSection = faultSection;
	}

	public void setFaultid(String id){
		Faultid=id;
	}

	public void setFaultSummary(String Summary){
		FaultSummary=Summary;
	}

	public String getFaultid(){
		return Faultid;
	}

	public String getFaultSummary(){
		return FaultSummary;
	}
}
