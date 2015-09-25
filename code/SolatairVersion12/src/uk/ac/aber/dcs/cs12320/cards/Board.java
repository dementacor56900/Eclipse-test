package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;

public class Board extends CardInfo {
	
	
	ArrayList<Card> cards;
	
	public Board(){
		cards = new ArrayList<Card>();
		displayCards();
		getSize();
	}

	public void addCard(Card card) {
	
		cards.add(card);
		
	}
	public void displayCards(){
			System.out.print(cards);

}
	public Card getFirstCard(){ //get first card and remove from deck
		Card card1 = cards.get(0);
		cards.remove(card1);
		return card1;
	}
	
	public Card getFirstCard2(){ //get first card and remove from deck
		Card card1 = cards.get(0);
		return card1;
	}
	
	public int getSize (){
		return cards.size();
	}
	
	
}
