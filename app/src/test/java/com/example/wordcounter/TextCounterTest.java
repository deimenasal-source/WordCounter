package com.example.wordcounter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextCounterTest {

    private TextCounter textCounter;

    @Before
    public void setUp() {
        textCounter = new TextCounter();
    }

    @Test
    public void testEmptyText() {
        assertEquals(0, textCounter.countWords(""));
        assertEquals(0, textCounter.countCharacters(""));
    }

    @Test
    public void testNormalText() {
        String text = "Hello world";

        assertEquals(2, textCounter.countWords(text));
        assertEquals(11, textCounter.countCharacters(text));
    }

    @Test
    public void testOnlySpaces() {
        String text = "     ";

        assertEquals(0, textCounter.countWords(text));
        assertEquals(5, textCounter.countCharacters(text));
    }

    @Test
    public void testOnlyPunctuation() {
        String text = "!!!";

        assertEquals(1, textCounter.countWords(text));
        assertEquals(3, textCounter.countCharacters(text));
    }

    @Test
    public void testMultipleSpaces() {
        String text = "Java   is   fun";

        assertEquals(3, textCounter.countWords(text));
        assertEquals(15, textCounter.countCharacters(text));
    }

    @Test
    public void testSingleWord() {
        String text = "Android";

        assertEquals(1, textCounter.countWords(text));
        assertEquals(7, textCounter.countCharacters(text));
    }

    @Test
    public void testLeadingAndTrailingSpaces() {
        String text = "  Hello world  ";

        assertEquals(2, textCounter.countWords(text));
        assertEquals(15, textCounter.countCharacters(text));
    }

    @Test
    public void testNewLine() {
        String text = "Hello\nworld";

        assertEquals(2, textCounter.countWords(text));
        assertEquals(11, textCounter.countCharacters(text));
    }

    @Test
    public void testOnlyTabs() {
        String text = "\t\t";

        assertEquals(0, textCounter.countWords(text));
        assertEquals(2, textCounter.countCharacters(text));
    }
}