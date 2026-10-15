package com.example.wordcounter;

public class TextCounter {

    public int countWords(String text) {
        String trimmedText = text.trim();

        if (trimmedText.isEmpty()) {
            return 0;
        }

        String[] words = trimmedText.split("\\s+");
        return words.length;
    }

    public int countCharacters(String text) {
        return text.length();
    }
}
