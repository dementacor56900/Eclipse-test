package uk.ac.aber.dcs.cs12320.cards;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import uk.ac.aber.dcs.cs12320.cards.gui.TheFrame;

public class TestFrame {
	int numCards = 52;
	private String filename = "scoreboard.txt";
	private String filename2 = "textOutput.txt";
	String textOutput;
	String stuff;
	String response1;
	int score=0;
	Board board = new Board();
	Pile pile = new Pile();
	uk.ac.aber.dcs.cs12320.cards.gui.TheFrame frame = new uk.ac.aber.dcs.cs12320.cards.gui.TheFrame();
	ArrayList<String> cardStrings = new ArrayList<String>(); //create array list for GUI
	private Scanner scan; // so we can read from keyboard
	
	public static void main(String[] args) {
		TestFrame game = new TestFrame();
		
	}
		
		private TestFrame() {
			initialise(); //scan in cards
			runMenu();
			
			//below simply there currently to check whether it runs all the way through
			frame.cardDisplay(cardStrings); //displays array  list of cards on GUI
			score =(score+(numCards*10))+(score+pile.getSize());
			save();
			
		}
		
		private void printPack(){
			board.displayCards(); // display array list of entire pack
			if(textOutput=="On"){
				stuff = "printPack";
				textOutput();
				System.out.println(stuff);	
			}
		}
		
		private void printPile(){
			pile.displayCards(); // display array list of all cards on board
			if(textOutput=="On"){
				stuff = "printPile";
				textOutput();
				System.out.println(stuff);	
			}
		}
		
		private void dealCard(){
			while(pile.getSize()>=0){
				if(numCards==0){
					System.out.println("No more cards available");
					break;
				}
			cardStrings.add(board.getFirstCard2()+".gif");
			pile.addCard(board.getFirstCard());
			pile.displayCards();
			frame.cardDisplay(cardStrings);
			numCards=numCards-1;
			if(textOutput=="On"){
				stuff = "dealCard";
				textOutput();
				System.out.println(stuff);	
			}
			break;
		}
		}
		
		private void shuffle(){
			
			List<Card> list = board.cards;
		    Collections.shuffle(list);
		    if(textOutput=="On"){
				stuff = "shufflePack";
				textOutput();
				System.out.println(stuff);	
			}
		}
		

		private void autoPlaySingle(){
			
			int countNumber1 = 0;
			int countNumber2 = 0;
			if(textOutput=="On"){
				stuff = "autoPlaySingle";
				textOutput();
				System.out.println(stuff);	
			}
			
				
				while (countNumber2==0){
					if(pile.getSize()==1){
						if(numCards==0){
							Win();
							break;
						}
					}
					while(pile.getSize()>=4){
				Card card1 = pile.getCard(pile.getSize()-4);
				Card card2 = pile.getCard(pile.getSize()-1);
				
				if(card1.getFirstId().equals(card2.getFirstId())){
					cardStrings.remove(pile.removeCard6()+".gif");
					cardStrings.set(pile.getSize()-4, pile.removeCard6()+".gif");
					frame.cardDisplay(cardStrings);
					pile.removeCard1();
					pile.cards.set(pile.getSize()-3,card2);
					score=score+1;
					score=score+2;
					countNumber1 = countNumber1+1;
					countNumber2 = countNumber2+1;
					break;
				}
				if(card1.getSeacondId().equals(card2.getSeacondId())){
					cardStrings.remove(pile.removeCard6()+".gif");
					cardStrings.set(pile.getSize()-4, pile.removeCard6()+".gif");
					frame.cardDisplay(cardStrings);
					pile.removeCard1();
					pile.cards.set(pile.getSize()-3,card2);
					score=score+1;
					score=score+2;
					countNumber1 = countNumber1+1;
					countNumber2 = countNumber2+1;
					break;
				}
				else
					dealCard();
				score=score+1;
				score=score+2;
				countNumber1 = countNumber1+1;
				countNumber2 = countNumber2+1;
					break;
				}
					while (countNumber2==0){
						if( pile.getSize()-2<0){
							dealCard();
							score=score+1;
							score=score+2;
							countNumber1 = countNumber1+1;
							countNumber2 = countNumber2+1;
								break;
						}

					Card card1 = pile.getCard(pile.getSize()-2);
					Card card2 = pile.getCard(pile.getSize()-1);
					
					if(card1.getFirstId().equals(card2.getFirstId())){
						cardStrings.remove(pile.removeCard3()+".gif");
						frame.cardDisplay(cardStrings);
						pile.removeCard2();
						score=score+1;
						score=score+2;
						countNumber1 = countNumber1+1;
						countNumber2 = countNumber2+1;
						break;
					}
					else if(card1.getSeacondId().equals(card2.getSeacondId())){
						cardStrings.remove(pile.removeCard3()+".gif");
						frame.cardDisplay(cardStrings);
						pile.removeCard2();
						score=score+1;
						score=score+2;
						countNumber1 = countNumber1+1;
						countNumber2 = countNumber2+1;
						break;
					}
					else
						dealCard();
					score=score+1;
					score=score+2;
					countNumber1 = countNumber1+1;
					countNumber2 = countNumber2+1;
						break;
				
					}
				
				
				} 
				}
					
				
					

			

				
		
		private void autoPlayMultiple(){
			if(textOutput=="On"){
				stuff = "autoPlayMultiple";
				textOutput();
				System.out.println(stuff);	
			}
			int countNumber1 = 0;
			int countNumber2 = 0;
			System.out.println("Enter how many times you want the program to run");
			int nTNumber = scan.nextInt();
				
				while (countNumber2<=nTNumber){
	
					if(pile.getSize()==1){
						if(numCards<=0){
							Win();
							break;
						}
					}
					while(pile.getSize()>=4){
						Card card1 = pile.getCard(pile.getSize()-4);
						Card card2 = pile.getCard(pile.getSize()-1);
						
						if(card1.getFirstId().equals(card2.getFirstId())){
							cardStrings.remove(pile.removeCard6()+".gif");
							cardStrings.set(pile.getSize()-4, pile.removeCard6()+".gif");
							frame.cardDisplay(cardStrings);
							pile.removeCard1();
							pile.cards.set(pile.getSize()-3,card2);
							score=score+1;
							score=score+2;
							countNumber1 = countNumber1+1;
							countNumber2 = countNumber2+1;
							break;
						}
						if(card1.getSeacondId().equals(card2.getSeacondId())){
							cardStrings.remove(pile.removeCard6()+".gif");
							cardStrings.set(pile.getSize()-4, pile.removeCard6()+".gif");
							frame.cardDisplay(cardStrings);
							pile.removeCard1();
							pile.cards.set(pile.getSize()-3,card2);
							score=score+1;
							score=score+2;
							countNumber1 = countNumber1+1;
							countNumber2 = countNumber2+1;
							break;
						}
						else
							dealCard();
						score=score+1;
						score=score+2;
						countNumber1 = countNumber1+1;
						countNumber2 = countNumber2+1;
							break;
						}
							while (countNumber2>=0){
								if( pile.getSize()-2<0){
									dealCard();
									score=score+1;
									score=score+2;
									countNumber1 = countNumber1+1;
									countNumber2 = countNumber2+1;
										break;
								}

							Card card1 = pile.getCard(pile.getSize()-2);
							Card card2 = pile.getCard(pile.getSize()-1);
							
							if(card1.getFirstId().equals(card2.getFirstId())){
								cardStrings.remove(pile.removeCard3()+".gif");
								frame.cardDisplay(cardStrings);
								pile.removeCard2();
								score=score+1;
								score=score+2;
								countNumber1 = countNumber1+1;
								countNumber2 = countNumber2+1;
								break;
							}
							else if(card1.getSeacondId().equals(card2.getSeacondId())){
								cardStrings.remove(pile.removeCard3()+".gif");
								frame.cardDisplay(cardStrings);
								pile.removeCard2();
								score=score+1;
								score=score+2;
								countNumber1 = countNumber1+1;
								countNumber2 = countNumber2+1;
								break;
							}
							else
								dealCard();
							score=score+1;
							score=score+2;
							countNumber1 = countNumber1+1;
							countNumber2 = countNumber2+1;
								break;
						
							}
						
						
						} 
					
				
				}
		
		
		
		private void move1LeftPlayer(){
			//Card test = cards.get(0);
			if(textOutput=="On"){
				stuff = "MoveOneLeft";
				textOutput();
				System.out.println(stuff);	
			}
			while(pile.getSize()>=2){
			if(pile.getSize()==1){
				if(numCards==1){
					if(numCards==0){
						Win();
						break;
					}
					
				}
				
				
			}
			Card card1 = pile.getCard(pile.getSize()-2);
			Card card2 = pile.getCard(pile.getSize()-1);
		
			if(card1.getFirstId().equals(card2.getFirstId())){
				cardStrings.remove(pile.removeCard3()+".gif");
				frame.cardDisplay(cardStrings);
				pile.removeCard2();
				score=score+1;
			}
			else if(card1.getSeacondId().equals(card2.getSeacondId())){
				cardStrings.remove(pile.removeCard3()+".gif");
				frame.cardDisplay(cardStrings);
				pile.removeCard2();
				score=score+1;
			}
			else
			System.out.println("Invalid move");
			score=score+1;
			break;
			
		}
		}
		
		private void move2LeftPlayer(){
			if(textOutput=="On"){
				stuff = "moveTwoleft";
				textOutput();
				System.out.println(stuff);	
			}
				while(pile.getSize()>=4){
			
			if(pile.getSize()==1){
				if(numCards==0){
					Win();
					break;
				}
			}
			Card card1 = pile.getCard(pile.getSize()-2);
			Card card2 = pile.getCard(pile.getSize()-1);
			
			if(card1.getFirstId().equals(card2.getFirstId())){
				cardStrings.remove(pile.removeCard6()+".gif");
				cardStrings.set(pile.getSize()-4, pile.removeCard6()+".gif");
				frame.cardDisplay(cardStrings);
				pile.removeCard1();
				pile.cards.set(pile.getSize()-3,card2);
				score=score+1;
			}
			else if(card1.getSeacondId().equals(card2.getSeacondId())){
				cardStrings.remove(pile.removeCard6()+".gif");
				cardStrings.set(pile.getSize()-4, pile.removeCard6()+".gif");
				frame.cardDisplay(cardStrings);
				pile.removeCard1();
				pile.cards.set(pile.getSize()-3,card2);
				score=score+1;
			}
			else
			System.out.println("Invalid move");
			score=score+1;
			break;
			}
		}
		
		
		private void moveFromAnywhere1(){
			if(textOutput=="On"){
				stuff = "AmalgamateInMiddle";
				textOutput();
				System.out.println(stuff);	
			}
			while(pile.getSize()>=2){
				if(pile.getSize()==1){
					if(numCards==0){
						Win();
						break;
					}
				}
			System.out.println("Enter which card you wish to move (starting from 0):");
			int number1 = scan.nextInt();
			pile.getCard(number1);
			System.out.println("Enter which card you wish to remove (starting from 0):");
			int number2 = scan.nextInt();
			pile.getCard(number2);
			if(number1==number2){
				System.out.println("Invalid move");
				score=score+1;
				break;
			}
			if((pile.getCard(number1).getFirstId().equals(pile.getCard(number2).getFirstId()))){
				cardStrings.set(number2, pile.getCard(number1)+".gif");
				cardStrings.remove(pile.getCard(number1)+".gif");
				frame.cardDisplay(cardStrings);
				pile.cards.set(number2,pile.getCard(number1));
				pile.cards.remove(number1);
				score=score+1;
			}
			else if((pile.getCard(number1).getSeacondId().equals(pile.getCard(number2).getSeacondId()))){
				cardStrings.set(number2, pile.getCard(number1)+".gif");
				cardStrings.remove(pile.getCard(number1)+".gif");
				frame.cardDisplay(cardStrings);
				pile.cards.set(number2,pile.getCard(number1));
				pile.cards.remove(number1);
				score=score+1;
			}
			else
			System.out.println("Invalid move");
			score=score+1;
			break;
			}
		}
		
		private void textOutputOn(){
			textOutput="On";
			
		}
		
		private void Win(){
			System.out.println("You have won the game!");
			System.out.println("Your score is: ");
			System.out.println(score);
			save();
			System.out.println("Exit game when you are ready....");
			
			
		}
		
		private void textOutput(){
			try(FileWriter fw = new FileWriter(filename2, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outfile = new PrintWriter(bw);){
				outfile.println(stuff);	
				
		}catch (IOException e) {
			System.err.println("Problem when trying to write to file: " + filename2);
		}
		}
		
		
		private void save(){
			if(textOutput=="On"){
				stuff = "save";
				textOutput();
				System.out.println(stuff);	
			}
			if(response1=="Y"){
			System.out.println("Enter player name:");
			}
			scan = new Scanner(System.in);
			String player = scan.nextLine().toUpperCase();
			try(FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outfile = new PrintWriter(bw);){
				outfile.println("");
				outfile.println(player);	
				outfile.println(score);	
				
		}catch (IOException e) {
			System.err.println("Problem when trying to write to file: " + filename);
		}
		}
		
		private void load() {
			if(textOutput=="On"){
				stuff = "load";
				textOutput();
				System.out.println(stuff);	
			}
			// Using try-with-resource (see my slides from session 15)
			try(FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				Scanner infile = new Scanner(br)){
				String player = infile.nextLine();
				System.out.println(player);
				int score = infile.nextInt();
				System.out.println(score);
				
			}catch (IOException e) {
				System.err.println("Problem when trying to load file: " + filename);
			}
		}
			
		
		
		
		private void initialise() {
			String filename = "cards.txt"; //sets card text file 
			Scanner scan;
			
			
			// Using try-with-resource (see my slides from session 15)
			try(FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr); 
				Scanner infile = new Scanner(br)){
				//Read text file
				
				for(int i=0; i < numCards; i++){
					
					String firstId = infile.nextLine(); //searches for value before type of card e.g. 1,3,j,q,k ect...
					String seacondId = infile.nextLine();//searches for type of card e.g. heart, diamonds, hearts ect...
					Card card = new Card(firstId, seacondId);
					board.addCard(card);
					
				
				} 
				
			}catch (FileNotFoundException e) {
				System.err.println("The file: " + " does not exist. Assuming first use and an empty file." +
	                    " If this is not the first use then have you accidentally deleted the file?");
			} catch (IOException e) {
				System.err.println("An unexpected error occurred when trying to open the file " + filename);
				System.err.println(e.getMessage());
			}
	
	
	}
		
		private void runMenu() {
		if(textOutput=="On"){
			stuff = "runMenu";
			textOutput();
			System.out.println(stuff);	
		}
		
			System.out.println("Do you want to play a game? (Y/N)");
			scan = new Scanner(System.in);
			response1 = scan.nextLine().toUpperCase();
			System.out.println(response1);
			switch (response1) {
			case "Y":
				do {
				System.out.println("What would you like to do:");
				printMenu();
				response1 = scan.nextLine().toUpperCase();
				
				switch (response1) {
				case "1":
					printPack();
					break;
				case "2":
					shuffle();
					break;
				case "3":
					dealCard();
					break;
				case "4":
					move1LeftPlayer();
					break;
				case "5":
					move2LeftPlayer();
					break;
				case "6":
					moveFromAnywhere1();
					break;
				case "7":
					autoPlaySingle();
					break;
				case "8":
					autoPlayMultiple();
					break;
				case "9":
					load();
					break;
				case "10":
					pile.displayCards();
					break;
				case "A":
					textOutputOn();
					break;
				case "Q":
					score=score+1;
					System.out.println("Score saved");
					break;
				default:
					System.out.println("Try again");
				} 
			}while (!(response1.equals("Q")));
		}
		}
		
		private void printMenu() {
			System.out.println("1 -  Print pack out ");
			System.out.println("2 -  Shuffle");
			System.out.println("3 -  Deal a card");
			System.out.println("4 -  Make a move, move last pile onto previous one");
			System.out.println("5 -  Make a move, move last pile over 2 piles");
			System.out.println("6 -  Amalgamate piles in the middle (by giving their numbers starting with 1)");
			System.out.println("7 -  Play for me once (will cost you 2 score)");
			System.out.println("8 -  Play for me many times (will cost you 3 score for each move (will do 2 moves))");
			System.out.println("9 -  Show low scores");
			System.out.println("10 - Display current board");
			System.out.println("A - turnTextOutputOn");
	
			System.out.println("q - Quit");
		}

		
		
		

		
		
}


	
	

