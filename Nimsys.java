/* Nimsys.java
 * This class controls the overall Nim game process
 * Author: Yuting Feng
 * Student ID:896336
 * Created on 22/3/18
 */
import java.util.Scanner;

public class Nimsys {
	int upperBound = 0;
	int stone = 0;
	int theRestOfstoneCount = 0;
	Boolean isPlayer1Turn = true;
	Boolean isPlaying = true;
	
	public static void main(String[]args) {
		Nimsys nimsys = new Nimsys();
		nimsys.playGame();
	}
	
	public void playGame() {
		System.out.println("Welcome to Nim");
		System.out.println();
		Scanner keyboard = new Scanner(System.in);	
		
		//create player1
		System.out.println("Please enter Player 1's name:");
		Nimplayer player1 = new Nimplayer();
		player1.setName(keyboard.next());
		System.out.println();
		
		//create player2
		System.out.println("Please enter Player 2's name:");
		Nimplayer player2 = new Nimplayer();
		player2.setName(keyboard.next());
	  	System.out.println();
	  	
	  	while(isPlaying) {
	  	//set the upper bound of removing stones
		System.out.println("Please enter upper bound of stone removal:");
	 	upperBound = keyboard.nextInt();
		this.setUpperBound(upperBound);
		System.out.println();

		//set the number of initial stones
		System.out.println("Please enter initial number of stones:");
		stone = keyboard.nextInt();
		this.setTheRestOfStoneCount(stone);
		System.out.println();

		//game begins
		while(theRestOfstoneCount > 0) {
			System.out.print(theRestOfstoneCount + " stones left:");
			this.displayStone(theRestOfstoneCount);
			System.out.println();
			if(isPlayer1Turn) {
				theRestOfstoneCount -= player1.removeStone(keyboard);
				System.out.println();
				isPlayer1Turn = false;		
			}else {
				theRestOfstoneCount -= player2.removeStone(keyboard);
				System.out.println();
				isPlayer1Turn = true;
			}
		}
		
		//game has finished, print result
		System.out.println("Game Over");
		if(isPlayer1Turn) {
			player1.win();
		}else {
			player2.win();
		}
		System.out.println();
		
		//whether play again
		System.out.print("Do you want to play again (Y/N):");
		this.playAgain(keyboard.next());
		System.out.println();
		isPlayer1Turn = true;
		}
	}
	
		//the upper bound of stones
		public int getUpperBound() {
	    		return upperBound; 
	    	}
		public void setUpperBound(int upperBound){
			this.upperBound = upperBound;
		}
		
		//the number of initial stones
		public int getTheRestOfStoneCount() {
			return theRestOfstoneCount;
		}
		public void setTheRestOfStoneCount(int theRestOfstoneCount) {
			this.theRestOfstoneCount = theRestOfstoneCount;
		}
		
		//whether is playing
		public boolean isPlaying() {
			return isPlaying;
		}
		public void setPlaying(boolean isPlaying) {
			this.isPlaying = isPlaying;
		}
		
		//display stones
		public void displayStone(int StoneCount){
			int asterisks = theRestOfstoneCount;
			while(asterisks > 0) {
				System.out.print(" *");
				asterisks --;
			}
		}
		
		//whether play again
		public void playAgain(String answer) {
			if(!answer.equals("Y")) {
				System.exit(0);
			}else;
		}
}
