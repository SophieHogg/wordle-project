package wordleAttempt1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestWordleList {
	@Test
	@DisplayName("getWordAtIndex should retrieve correct word at index")
	void getWordAtIndexReturnsCorrectWordForIndexEntered() {
		assertEquals("abuse", WordleList.getWordAtIndex(0));
		assertEquals("dream", WordleList.getWordAtIndex(43));
	}

}
