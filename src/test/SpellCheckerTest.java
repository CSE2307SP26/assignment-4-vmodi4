package test;

import static org.junit.jupiter.api.Assertions.*;


import jdk.jfr.internal.util.SpellChecker;
import org.junit.jupiter.api.Test;


class SpellCheckerTest {

	@Test
	public void testGetWordCount() {
		SpellChecker checker = new SpellChecker();
		int words = checker.getWordCount();
		assertEquals(0, words);
	}


	@Test
	public void testWordCountIncrements() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("apple");
		checker.addWord("orange");
		int words = checker.getWordCount();
		assertEquals(2, words);
	}


	@Test
	public void testDuplicateWordDoesNotIncrementCount() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("apple");
		checker.addWord("apple");
		int words = checker.getWordCount();
		assertEquals(1, words);
	}

	@Test
	public void testCorrectSpellingReturnsTrue() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("apple");
		// isSpellCorrectly should return a boolean.
		assertTrue(checker.isSpelledCorrectly("apple"));
	}


	@Test
	public void testIncorrectSpellingReturnsFalse() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("apple");
		// should return false, since i am missing a p.
		assertFalse(checker.isSpelledCorrectly("aple"));
	}

	@Test
	public void testCaseInsensitivity() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("Apple");
		//regardless of lower/uppercase orientation, should still be spelled the same.
		assertTrue(checker.isSpelledCorrectly("aPPLe"), "Should be true regardless of casing");
	}


	@Test
	public void testRecommendationForMisspelledWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank");
		checker.addWord("zebra");
		// "bamk" is alphabetically closer to "bank" than "zebra"
		assertEquals("bank", checker.getWordRecommendation("bamk"));
	}


	@Test
	public void testRecommendationForCorrectWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank");
		assertEquals("bank", checker.getWordRecommendation("bank"));
		// get the same word
	}

	// this is the start of the optional tests

	@Test
	public void testClearRemovesAllWords() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("apple");
		checker.clear();
		// from now on I can just call the method within the check instead of storing it in a variable.
		assertEquals(0, checker.getWordCount());
	}

	@Test
	public void testIfEmptyWorldAdded() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("");
		// just an empty string.
		assertEquals(0, checker.getWordCount());
	}

}

// comment
