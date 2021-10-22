package adrianHangman;
import java.util.Scanner;
/*
 * Adrian Yu
 * Hangman game
 */

public class Hangman {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputtedWord, hint, wordDisplay;
		String letterGuessed = " ";//all the letters guessed put together
		String name1, name2;//for the names of the players
		char letters;//when player 2 guesses a letter
		int lives = 6;//number of lives player 2 has
		boolean solved = false;//when the word or phrase is not fully revealed
		boolean letterCheck = false; //when the letter is found in the word
		
		instructions();
		
		System.out.println("Player 1 please enter your name:");//for the players to enter their names
		name1 = input.nextLine();
		System.out.println("Player 2 please enter your name:");
		name2 = input.nextLine();
		System.out.println();
		
		System.out.println(name1+ ", Please input the word:");
		inputtedWord = input.nextLine();//the word for player 2 to guess
		System.out.println("input the category/hint:");
		hint = input.nextLine();//the hint for the guesser
		
		for(int a=0; a<100;a++) {//to push the screen 100 spaces down so it seems like a blank page
			System.out.println("");
		}
		
		wordDisplay=word(inputtedWord);
		
		while(lives>0 && solved==false) {//the word/phrase is not solved yet and will continue to output the display
			display(wordDisplay, hint, lives, letterGuessed);	
			do {
				System.out.print(name2 + ", Input a letter:");
				letters = input.next().charAt(0);
					if(letterGuessed.indexOf(letters)==-1) {//to check if the player has already guessed that letter
						letterCheck = true;
					}
					else {
						letterCheck = false;
					}
				if(letterCheck == false) {
					System.out.println("This letter has been already used, Try again");
				}
			}
			while(letterCheck==false); 
			
			letterGuessed = letterGuess(letterGuessed,letters);
	
			if(search(inputtedWord,letters)==true) {//letter is found in the word
				System.out.println("You have revealed part of the word, Please continue");
				wordDisplay = wordReplace(inputtedWord, wordDisplay, letters);
				if (wordDisplay.indexOf('-') == -1) {
		    		solved = true;
				}
		    	else {
		    		solved = false;
				}
			}
			else {
				System.out.println("The letter of your word does not match");
				lives--;	
			}
		}
		endScreen(solved,inputtedWord, name1, name2);
		input.close();
		
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
	/*
	 * Method to add a letter to the display to show the letter is used
	 * pre: letters that was guessed plus new letter guessed
	 * post: all the letters guessed
	 */
	public static String letterGuess(String letterGuess, char letters) {
		String replaceLetter;
		replaceLetter = letterGuess + " " + letters;
		return replaceLetter;
		
	}
	/*
	 * Method to search if the letter inputted if found in the word
	 * pre:The word that is being guessed, and the letter inputted by player 2
	 * post: true, or false depending if the word is found
	 */
	public static boolean search(String inputtedWord, char letters) {
		if (inputtedWord.indexOf(letters) > -1) //if letter corresponds to the word/phrase
    		return true;
    	else
    		return false;
	}
	/*
	 * Method to replace the - with a letter to show the word is being revealed by each guess
	 * pre: word that is being guessed, the word display that is -, and the letter that player 2 is using to guess
	 * post: returns the word with it being slightly revealed by the guessed letter
	 */
	public static String wordReplace (String inputtedWord, String wordDisplay, char letter){
	    	
	    	 char[] displayArray = wordDisplay.toCharArray(); //converts the String to an char array
	    	 char[] wordArray = inputtedWord.toCharArray();
	         int counter=0;
	         
	         for(int a=0; a<wordArray.length; a++){
	             if(wordArray[a] == letter) //if the character is a letter
	                 counter++;
	         }
	         
	         int charArray[] = new int[counter];
	         int b = -1; //where the previous space was
	         for(int a=0; a<counter; a++){
	             int c = inputtedWord.indexOf(letter,b+1); //finds the index value of the space
	             b = c; 
	             charArray[a] = c;
	         }
	         
	         //replaces the - with the letter
	         for(int a=0; a<counter; a++){
	             displayArray[charArray[a]] = letter;  
	         }
	         
	         wordDisplay = String.valueOf(displayArray); //converts character array back into string
	         
	     return wordDisplay;
	    }
	/*
	 * Method to determine who wins the game
	 * pre:boolean to see if the word is solved, the word that is being guessed, and the names of the two players
	 * post:outputs a bunch of stars and shows which player wins the game
	 */
	public static void endScreen(boolean solved, String inputtedWord, String name1, String name2) {
		if(solved == true) {
			for(int a=0; a<100;a++) {
				for(int b=0; b<100;b++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("The word was: "+ inputtedWord);
			System.out.println("CONGRATULATIONS, " + name2 + " has won the game!");
			System.out.println();
			for(int a=0; a<20;a++) {
				for(int b=0; b<100;b++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else {
			for(int a=0; a<100;a++) {
				for(int b=0; b<100;b++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("The word was: "+ inputtedWord);
			System.out.println("CONGRATULATIONS, " + name1 +  " has won the game!");
			System.out.println();
			for(int a=0; a<20;a++) {
				for(int b=0; b<100;b++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
	}
}

