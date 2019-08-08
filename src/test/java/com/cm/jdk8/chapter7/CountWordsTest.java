package com.cm.jdk8.chapter7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountWordsTest {
    private final static Logger logger = LoggerFactory.getLogger(CountWordsTest.class);

    String content = "Hello! Maybe you need help? Do not worry,I can assit you in a special way.";
    String a = "{\"name\": \"gg\",\"age\": \"45\"}";

    @Test
    public void testCountWords() {
        int result = CountWords.countWords(content);
        logger.info("普通迭代单词统计数量:{}", result);

    }


    @Test
    public void testCounter() {
        Stream<Character> stream = IntStream.range(0, content.length()).mapToObj(content::charAt);
        int result = CountWords.countWords(stream);
        logger.info("流处理单词统计数量:{}", result);
    }

    @Test
    public void testWordsSpliterator() {
        Spliterator<Character> spliterator = new WordsSpliterator(content);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        int result = CountWords.countWords(stream);
        logger.info("流处理分路器单词统计数量:{}", result);
    }
}