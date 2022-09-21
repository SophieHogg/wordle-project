package wordleAttempt1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class TestTranslations {
	@Test
	@DisplayName("getGermanTranslation should retrieve correct German word")
		void getGermanTranslationReturnsCorrectGermanWordForInputString() {
			assertEquals("die Wut", Translations.getGermanTranslation("anger"));
			assertEquals("der Klang", Translations.getGermanTranslation("sound"));
			assertEquals("das Blatt", Translations.getGermanTranslation("sheet"));
	}
}
