package adrianHangman;
import java.util.Scanner;
/*
 * Adrian Yu
 * Hangman
 * June 14, 2020
 */

public class AdrianDraft2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputtedWord, hint, wordDisplay;
		String letterGuess = " ";
		String name1, name2;//for the names of the players
		
		int lives=6;
		instructions();
		
		System.out.println("Player 1 please enter your name:");//for the players to enter their names
		name1 = input.nextLine();
		System.out.println("Player 2 please enter your name:");
		name2 = input.nextLine();
		System.out.println();
		System.out.println(name1+ ", Please input the word:");
		inputtedWord = input.nextLine();
		System.out.println("input the category/hint:");
		hint = input.nextLine();
		for(int a=0; a<100;a++) {//to push the screen 100 spaces down so it seems like a blank page
			System.out.println("");
		}
		wordDisplay=word(inputtedWord);
		display(wordDisplay,hint,lives,letterGuess);
	}
	/*
	 * Method to explain instructions and rules of the game
	 * pre: none
	 */
	public static void instructions() {
		System.out.println("Welcome to Hangman");
		System.out.println("These are the instructions:");
		System.out.println("This is a two player game and each player will have a certain role");
		System.out.println("");
		System.out.println("Player 1 - the player that inputs a word or phrase and the category(hint)");
		System.out.println("Player 2 - also known as the guesser, will input letters to try to reveal the word");
		System.out.println("");
		System.out.println("Rules to the game:");
		System.out.println("Player 1 is not allowed to use special characters or caps like: #%$!");
		System.out.println("Player 2 must only enter one letter at a time");
		System.out.println("Player 2 will have 6 total lives just like a drawn stickman");
		System.out.println("Since there are only 6 lives if player 2 were to lose all their lives, player 1 will win"
				+ " but if they were to get the word, they will win");
		System.out.println("Player 2 must not scroll up or else that would be considered cheating");
		System.out.println();
		System.out.println("The game will display how many lives, the hint, and the letters used");
		System.out.println();
	}
	/*
	 * Method to put the inputted word into different index and changing the words into dashes
	 * pre: word from player one
	 * post: word replaced with -
	 */
	public static String word(String word) {
		int  wordLength=0;
		char arrayWord[] = word.toCharArray(); //putting the word into an array
			for(int a=0; a<arrayWord.length;a++) {
				if(arrayWord[a]== ' ') {
					wordLength++;
				}
			}
        int arraySpace[] = new int[wordLength];
        int b = -1; //where the previous space was
	        for(int a=0; a<wordLength; a++){
	            int c = word.indexOf(' ',b+1); //finds the index value of the space
	            b = c; 
	            arraySpace[a] = c;
	       	}
	        //replaces all characters in array to -
	        for(int a=0; a<arrayWord.length; a++){
	        	arrayWord[a] = '-';
	        }
	        //replaces the - with a space
	        for(int a=0; a<wordLength; a++){
	            arrayWord[arraySpace[a]] = ' ';  
	       	}
		word = String.valueOf(arrayWord);
		return word;
	}
	/*
	 * Method to display the covered word, hint, and lives
	 * pre: word, hint, and number of lives
	 * post: a display
	 */
	public static void display(String word, String hint, int lives, String letterGuess) {
		System.out.println(" -------------------------------------------------------------");
		System.out.println("|");
		System.out.printf("%-10s%s%-20s%n", "|", "Hint: ", hint);
		System.out.printf("%-10s%s%-20s%n","|", "Word: ", word);
		System.out.printf("%-10s%s%-20d%n", "|", "Lives: ", lives);
		System.out.printf("%-10s%s%-20s%n", "|", "Letters Used: ", letterGuess);
		System.out.println("|");
		System.out.println(" -------------------------------------------------------------");
		
	}
}
