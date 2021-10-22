package adrianHangman;
import java.util.Scanner;
/*
 * Adrian Yu
 * Hangman
 * June 13, 2020
 */

import java.util.Scanner;

public class draft1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name1, name2;//for the names of the players
		instructions();
		
		System.out.println("Player 1 please enter your name:");//for the players to enter their names
		name1 = input.nextLine();
		System.out.println("Player 2 please enter your name:");
		name2 = input.nextLine();
		System.out.println();
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
}
