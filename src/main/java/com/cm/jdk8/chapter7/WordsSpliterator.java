package com.cm.jdk8.chapter7;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/7 14:53
 */
public class WordsSpliterator implements Spliterator<Character> {
    private String str;
    private int currentChar = 0;

    public WordsSpliterator(String str) {
        this.str = str;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //处理当前字符
        action.accept(str.charAt(currentChar++));
        return currentChar < str.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        //解析字符串的长度
        int size = str.length() - currentChar;
        if (size < 10) {
            return null;
        }
        for (int splitPos = size / 2 + currentChar; splitPos < str.length(); splitPos++) {
            char c = str.charAt(splitPos);
            if (Character.isWhitespace(c) || c == ',' || c == '.' || c == '!' || c == '?') {
                Spliterator<Character> spliterator = new WordsSpliterator(str.substring(currentChar, splitPos));
                currentChar = splitPos;
                return  spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return str.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
