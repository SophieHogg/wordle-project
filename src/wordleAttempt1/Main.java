package wordleAttempt1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String randomWord = Utils.getRandomWord();
		String germanWord = Translations.getGermanTranslation(randomWord);
		
		Scanner userInput = new Scanner(System.in);
		
		for (int i = 1; i<7; i++) {
			System.out.println("Please enter your guess");
			String userGuess = userInput.nextLine();
			
			//ensures only 5 values are inputted by user
			if (userGuess.length() != 5) {
				System.out.println("Please ensure you enter a 5 letter word.");
				i--;
			}
			
			//ensures all inputted values are letters
			else if (!userGuess.chars().allMatch(Character::isLetter)) {
				System.out.println("Please only enter letters.");
				i--;
			}
			
			// if word is correct, print success output
			else if (userGuess.toLowerCase().equals(randomWord)){
				System.out.println(Utils.returnSuccessToUser(randomWord, germanWord, i));
				break;
			}
			
			// if 6th guess, print failure output
			else if (i == 6) {
				System.out.println(Utils.returnFailureToUser(randomWord, germanWord));
			}
			
			//print feedback regarding correct/incorrect guesses
			else {
			System.out.println(Utils.returnFeedbackToUser(randomWord, userGuess));
			}
		}		
		userInput.close();
}
}
