import java.util.Stack;
import java.math.*;

public class Deck {
	Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	// Load the stack with 52 cards in order
	public void loadDeck(){
		for(int i = 4; i >= 1; i--) {
			for(int j = 14; j >= 2; j--) {
			Card a = new Card(i, j);
					deck.push(a);
			}
		}
		
	}

       // Print the stack - for uniformity,
       // make 13 rows in four columns, filling
       // in each row from left to right
	public String toString() {
		Stack<Card> deckToPrint = new Stack<Card>();
		String output = "";
		for(int i = 2; i <= 14; i++) {
			for(int j = 0; j < 4; j++) {
				deckToPrint.push(deck.peek());
				output+= deck.pop() + "  ";
			}
			output+="\n";
		}
		while(!deckToPrint.isEmpty()) {
			deck.push(deckToPrint.pop());
		}
		return output;
	}

	


	// Return and remove the top card
	public Card deal() {
		return deck.pop();
	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {
		Stack<Card> tempDeckEven = new Stack<Card>();
		Stack<Card> tempDeckOdd = new Stack<Card>();
		int count = 1;
		while(!deck.isEmpty()) {
			if(count%2==1)
				tempDeckOdd.push(deck.pop());
			else 
				tempDeckEven.push(deck.pop());
			count++;
		}
		while(!tempDeckEven.isEmpty()) {
			deck.push(tempDeckEven.pop());
		}
		while(!tempDeckOdd.isEmpty()) {
			deck.push(tempDeckOdd.pop());
		}
	}
	
	// Split the deck at a random spot. Put the stack of cards above the random
	// spot below the other cards
	public void cut() {
		Stack<Card> tempDeckBottom = new Stack<Card>();
		Stack<Card> tempDeckTop = new Stack<Card>();
		int num = (int)(Math.random()*52) + 1; 
		for(int i = 1; i <=num; i++) {
			tempDeckBottom.push(deck.pop());
		}
		while(!deck.isEmpty()) {
			tempDeckTop.push(deck.pop());
		}
		while(!tempDeckBottom.isEmpty()) {
			deck.push(tempDeckBottom.pop());
		}
		while(!tempDeckTop.isEmpty()) {
			deck.push(tempDeckTop.pop());
		}
	}


	// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
		int repeat = 0;
		while(repeat<7) {
			Stack<Card> tempDeckEven = new Stack<Card>();
			Stack<Card> tempDeckOdd = new Stack<Card>();
			int count = 1;
			while(!deck.isEmpty()) {
				if(count%2==1)
					tempDeckOdd.push(deck.pop());
				else 
					tempDeckEven.push(deck.pop());
				count++;
			}
			while(!tempDeckEven.isEmpty()) {
				deck.push(tempDeckEven.pop());
			}
			while(!tempDeckOdd.isEmpty()) {
				deck.push(tempDeckOdd.pop());
			}
			
			Stack<Card> tempDeckBottom = new Stack<Card>();
			Stack<Card> tempDeckTop = new Stack<Card>();
			int num = (int)(Math.random()*52) + 1; 
			for(int i = 1; i <=num; i++) {
				tempDeckBottom.push(deck.pop());
			}
			while(!deck.isEmpty()) {
				tempDeckTop.push(deck.pop());
			}
			while(!tempDeckBottom.isEmpty()) {
				deck.push(tempDeckBottom.pop());
			}
			while(!tempDeckTop.isEmpty()) {
				deck.push(tempDeckTop.pop());
			}
			repeat++;
		}
	}

       // Reverse the order of the cards in the deck
       private void reverse() {
    	   Stack<Card> tempDeck = new Stack<Card>();
    	   while(!deck.isEmpty()) {
    		   tempDeck.push(deck.pop());
    	   }
    	   deck = tempDeck;
       }

       // Given a Stack of cards as an explicit parameter,
       // reverse the order of the cards in the deck
       private Stack<Card> reverse(Stack<Card> x) {
    	   Stack<Card> tempDeck = new Stack<Card>();
    	   while(!x.isEmpty()) {
    		   tempDeck.push(x.pop());
    	   }
    	  return tempDeck;
       }

       // Combine two decks, one as the implicit 
       // parameter, the other as the explicit parameter
       public void combineDecks(Stack<Card> other) {
    	   while(!other.isEmpty()) {
    		   deck.push(other.pop());
    	   }
       }

       
	public static void main(String[] args) {
    	// example method calls - you should make your own
		
		
//		Deck a = new Deck();
//		System.out.println("Display after DECK CONSTRUCTION Ordered By Rank \n" + a + "\n\n");
//		
//		Deck b = new Deck();
//		b.cut();
//		System.out.println("Display after CUT \n" + b + "\n\n");
//
//		Deck c = new Deck();
//		c.bridgeShuffle();
//		System.out.println("Display after Birdge Shuffle \n" + c + "\n\n");
//		
//		Deck d = new Deck();
//		d.completeShuffle();
//		System.out.println("Display after Birdge Shuffle \n" + d + "\n\n");
		
		Deck a = new Deck();
		System.out.println("Display after DECK CONSTRUCTION \n" + a + "\n\n");
		
		a.cut();
		System.out.println("Display after CUT \n" + a + "\n\n");
		
		a.bridgeShuffle();
		System.out.println("Display after BRIDGE SHUFFLE \n" + a + "\n\n");

		a.completeShuffle();
		System.out.println("Display after COMPLETE SHUFFLE \n" + a + "\n\n");
//		Deck a = new Deck();
//		System.out.println(a.getDeck());
//		System.out.println(a);
//		a.bridgeShuffle();
//		System.out.println(a);
//		a.cut();
//		System.out.println(a);
//		a.completeShuffle();
//		System.out.println("After 1 bridge shuffle");
//		System.out.println(a);
//		a.reverse();

//		for (int i = 1; i <= 5; i++)
//		    System.out.println(a.deal());
	}
}
