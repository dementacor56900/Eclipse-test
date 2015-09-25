package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;

public class Pile extends CardInfo {
	
	int pileNumber;
	
ArrayList<Card> cards;
	
	public Pile(){
		cards = new ArrayList<Card>();
		pileNumber=0;
		displayCards();
		getSize();
	}

	public void addCard(Card card) {
	
		cards.add(card);
		pileNumber=pileNumber+1;
		
	}
	
	
	public Card getFirstCard(){
		Card pcard1 = cards.get(0);
		return pcard1;
	}
	
	public Card getSeacondCard(){
		Card pcard2 = cards.get(1);
		return pcard2;
	}
	
	public Card getForthCard(){
		Card pcard2 = cards.get(3);
		return pcard2;
	}
	
	public Card getCard(int index){
		Card pcard3 = cards.get(index);
		return pcard3;
	}
	
	public int getPileNumber(){
		
		return pileNumber;
	}
	public void displayCards(){
		System.out.print(cards);

}
	public void removeCard1(){
		pileNumber=pileNumber-1;
		Card pcards2=getCard(pileNumber);
		cards.remove(pcards2);
		
	}
	
	public void removeCard2(){
		pileNumber=pileNumber-2;
		Card pcards2=getCard(pileNumber);
		cards.remove(pcards2);
		pileNumber=pileNumber+1;
	}
	
	public Card removeCard3(){
		pileNumber=pileNumber-2;
		Card pcards2=getCard(pileNumber);
		pileNumber=pileNumber+2;
		return pcards2;
		

	}
	
	public void removeCard4(){
		pileNumber=pileNumber-4;
		Card pcards3=getCard(pileNumber);
		cards.remove(pcards3);
		pileNumber=pileNumber+3;
	}
	
	public Card removeCard5(){
		pileNumber=pileNumber-4;
		Card pcards2=getCard(pileNumber);
		pileNumber=pileNumber+4;
		return pcards2;
		

	}
	
	public Card removeCard6(){
		pileNumber=pileNumber-1;
		Card pcards2=getCard(pileNumber);
		pileNumber=pileNumber+1;
		return pcards2;
		

	}
	
	public int getSize (){
		return cards.size();
	}
		
		
	}
	


