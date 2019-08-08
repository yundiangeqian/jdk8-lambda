package com.cm.jdk8.chapter7;

import java.util.stream.Stream;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/7 13:38
 */
public class CountWords {
    private int counter;
    private boolean lastSpace;


    public CountWords(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public CountWords accumulate(Character c) {
        if (Character.isWhitespace(c) || c == ',' || c == '.' || c == '!' || c == '?') {
            return lastSpace ? this : new CountWords(counter, true);
        } else {
            return lastSpace ? new CountWords(counter + 1, false) : this;
        }
    }

    public CountWords combine(CountWords countWords) {
        return new CountWords(counter + countWords.counter, countWords.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    public static int countWords(Stream<Character> stream) {
        CountWords countWords = stream.reduce(new CountWords(0, true), CountWords::accumulate, CountWords::combine);
        return countWords.getCounter();
    }

    public static int countWords(String str) {
        int count = 0;
        boolean lastSpace = true;
        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c) || c == ',' || c == '.' || c == '!' || c == '?') {
                lastSpace = true;
            } else {
                if (lastSpace)
                    count++;
                lastSpace = false;
            }
        }
        return count;
    }
}
