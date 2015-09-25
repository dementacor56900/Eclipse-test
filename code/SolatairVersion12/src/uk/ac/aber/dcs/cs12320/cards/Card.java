package uk.ac.aber.dcs.cs12320.cards;

public class Card {
	
	 String firstId;
	 String seacondId;

	public Card(String firstId, String seacondId) {
		
		this.firstId=firstId;
		this.seacondId=seacondId;
		
		
	}
	
	public String getFirstId() {
		return firstId;
	}
	
	public void setFirstId(String firstId){
		firstId = firstId;
	}
	
	public String getSeacondId() {
		return seacondId;
	}
	
	public void setSeacondId(String seacondId){
		seacondId = seacondId;
	}
	
public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(firstId );
		sb.append(seacondId);
		
		
		return sb.toString();
	}
	
	
	
	

}
