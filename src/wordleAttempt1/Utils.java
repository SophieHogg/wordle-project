package wordleAttempt1;

public class Utils {
	static int min = 0;
	static int max = 211;
	static String greenTick = Character.toString(9989);
	static String questionMark = Character.toString(10134);
	static String redCross = Character.toString(10062);
	// Should select one word at random from the JSON list

	public static String getRandomWord () {
	int randomInteger = (int) (Math.floor(Math.random()*(max-min+1)+min));
	String outputWord = WordleList.getWordAtIndex(randomInteger);
	return outputWord;
	}
	
	// Should take in user guess and return correct/incorrect guesses
	public static String returnFeedbackToUser (String correctWord, String userInput) {
		String userInputLower = userInput.toLowerCase();
		String outputString = "";
			for (int i = 0; i<5; i++){
				if (userInputLower.charAt(i)==correctWord.charAt(i)) {
					outputString += greenTick;
				}
				else if (correctWord.contains(""+userInputLower.charAt(i))) {
					outputString+=questionMark;
					// check if word contains only one of the letter?
				}
				else {
					outputString+=redCross;
				}
			}
		return outputString;
	}
	
	public static String returnFailureToUser(String correctWord, String germanWord) {
		return String.format("Sorry! You failed to guess \"%s\" within 6 attempts.\nIn German, this word is \"%s\".", correctWord, germanWord);
	}
	
	// Should return word and translation of word
	public static String returnSuccessToUser (String correctWord, String germanWord,int attempt) {
		String attemptWord = "";
		if (attempt == 1) {
			attemptWord = "attempt";
		}
		else {
			attemptWord = "attempts";
		}
		return String.format("Congratulations, you guessed \"%s\" in %d %s.\nIn German, this word is \"%s\".", correctWord, attempt, attemptWord, germanWord);
	}

}
