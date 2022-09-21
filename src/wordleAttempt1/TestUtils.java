package wordleAttempt1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestUtils {
	String greenTick = Character.toString(9989);
	String questionMark = Character.toString(10134);
	String redCross = Character.toString(10062);
	
	//TESTS FOR getRandomWord METHOD
	// Tests: 
	// - should return string, 
	// - should return 5 letter string, 
	// - should return a word from wordlelist.
	
	@Test
	@DisplayName("getRandomWord should return string")
	void getRandomWordShouldReturnString() {
		assertTrue(Utils.getRandomWord() instanceof String);
	}
	@Test
	@DisplayName("getRandomWord should return 5 chars long")
	void getRandomWordShouldReturnFiveChars() {
		assertTrue(Utils.getRandomWord().length()==5);
	}
	@Test
	@DisplayName("getRandomWord should return word from wordlelist")
	void getRandomWordShouldReturnWordPresentInWordleList() {
		assertTrue(WordleList.wordlelist.contains(Utils.getRandomWord()));
		
	}
	
	
	//TESTS FOR returnFeedbackToUser METHOD
	// Tests
	// - should return string
	// - should return 5 characters
	// - should return correct output for word matching
	@Test
	@DisplayName("returnFeedbackToUser should return string")
	void returnFeedbackToUserShouldReturnString() {
		assertTrue(Utils.returnFeedbackToUser("video", "loper") instanceof String);
		assertTrue(Utils.returnFeedbackToUser("sheep", "steal") instanceof String);
	}
	
	@Test
	@DisplayName("returnFeedbackToUser should return five letters")
	void returnFeedbackToUserShouldReturnFiveChars() {
		assertEquals(5, Utils.returnFeedbackToUser("video", "mauve").length());
		assertEquals(5, Utils.returnFeedbackToUser("sheep", "pleas").length());
	}
	
	@Test
	@DisplayName("returnFeedbackToUser should return correct output")
	void returnFeedbackToUserShouldDisplayCorrectResult() {
		assertEquals(redCross+redCross+redCross+redCross+redCross, Utils.returnFeedbackToUser("sheep", "burnt"));
		assertEquals(greenTick+greenTick+greenTick+greenTick+greenTick, Utils.returnFeedbackToUser("sheep", "sheep"));
		assertEquals(greenTick+questionMark+greenTick+redCross+redCross, Utils.returnFeedbackToUser("sheep", "spear"));
		assertEquals(questionMark+questionMark+questionMark+questionMark+questionMark, Utils.returnFeedbackToUser("least", "steal"));
	}
	
	//TESTS FOR returnFailureToUser METHOD
	// Tests
	// - should return string
	// - string should include the correct word
	// - string should include German word
	// - should return correct string
	
	@Test
	@DisplayName("returnFailureToUser should return string")
	void returnFailureToUserShouldReturnString() {
		assertTrue(Utils.returnFailureToUser("anger", "die Wut") instanceof String);
		assertTrue(Utils.returnFailureToUser("speed", "die Geschwindigkeit") instanceof String);
	}
	
	@Test
	@DisplayName("returnFailureToUser should include correct word")
	void returnFailureToUserShouldIncludeCorrectWord() {
		assertTrue(Utils.returnFailureToUser("speed", "die Geschwindigkeit").contains("speed"));
		assertTrue(Utils.returnFailureToUser("brown", "braun").contains("brown"));
	}
	
	@Test
	@DisplayName("returnFailureToUser should include German word")
	void returnFailureToUserShouldIncludeGermanWord() {
		assertTrue(Utils.returnFailureToUser("speed", "die Geschwindigkeit").contains("die Geschwindigkeit"));
		assertTrue(Utils.returnFailureToUser("brown", "braun").contains("braun"));
	}	
	
	@Test
	@DisplayName("returnFailureToUser should return correct string")
	void returnFailureToUserShouldReturnCorrectString() {
		assertEquals("Sorry! You failed to guess \"green\" within 6 attempts.\nIn German, this word is \"grün\".", Utils.returnFailureToUser("green", "grün"));
		assertEquals("Sorry! You failed to guess \"cough\" within 6 attempts.\nIn German, this word is \"der Husten\".", Utils.returnFailureToUser("cough", "der Husten"));
	}
	
	//TESTS FOR returnSuccessToUser METHOD
	// Tests
	// - should return string
	// - should include correct word
	// - should include german word
	// - should include number of attempts
	// - should return correct pluralisation of attempt/s
	// - should return correct string
	
	@Test
	@DisplayName("returnSuccessToUser should return string")
	void returnSuccessToUserShouldReturnString() {
		assertTrue(Utils.returnSuccessToUser("anger", "die Wut", 1) instanceof String);
		assertTrue(Utils.returnSuccessToUser("speed", "die Geschwindigkeit", 5) instanceof String);
	}
	
	@Test
	@DisplayName("returnSuccessToUser should include correct word")
	void returnSuccessToUserShouldIncludeCorrectWord() {
		assertTrue(Utils.returnSuccessToUser("speed", "die Geschwindigkeit", 4).contains("speed"));
		assertTrue(Utils.returnSuccessToUser("brown", "braun", 3).contains("brown"));
	}
	
	@Test
	@DisplayName("returnSuccessToUser should include German word")
	void returnSuccessToUserShouldIncludeGermanWord() {
		assertTrue(Utils.returnSuccessToUser("speed", "die Geschwindigkeit", 3).contains("die Geschwindigkeit"));
		assertTrue(Utils.returnSuccessToUser("brown", "braun", 3).contains("braun"));
	}	
	
	@Test
	@DisplayName("returnSuccessToUser should include number of attempts")
	void returnSuccessToUserShouldIncludeNumberOfAttempts() {
		assertTrue(Utils.returnSuccessToUser("speed", "die Geschwindigkeit", 3).contains("3"));
		assertTrue(Utils.returnSuccessToUser("brown", "braun", 2).contains("2"));
	}
	
	@Test
	@DisplayName("returnSuccessToUser should return correct word for attempt")
	void returnSuccessToUserShouldIncludeCorrectPluralisationOfAttempt() {
		assertTrue(Utils.returnSuccessToUser("brown", "braun", 1).contains("attempt."));
		assertTrue(Utils.returnSuccessToUser("brown", "braun", 2).contains("attempts."));
	}
	
	@Test
	@DisplayName("returnSuccessToUser should return correct string")
	void returnSuccessToUserShouldReturnCorrectString() {
		assertEquals("Congratulations, you guessed \"cough\" in 3 attempts.\nIn German, this word is \"der Husten\".", Utils.returnSuccessToUser("cough", "der Husten", 3));
		assertEquals("Congratulations, you guessed \"green\" in 2 attempts.\nIn German, this word is \"grün\".", Utils.returnSuccessToUser("green", "grün", 2));
	}

}
