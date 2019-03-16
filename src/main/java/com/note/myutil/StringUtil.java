package com.note.myutil;

import org.apache.tomcat.util.http.fileupload.util.Streams;

import javax.validation.constraints.Null;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-14 11:35
 **/
public class StringUtil {
    public int countWordsIteratively(String s){
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()){
            if (Character.isWhitespace(c)){
                ++counter;
            }
        }
        return counter;
    }

    /**
     * 生成随机汉字 utf-8
     * @return
     */
    public static char getRandomFontChinese(){
        return (char) (0x4e00+(int)(Math.random() * (0x9fa5 - 0x4e00 +1)));
    }
static class WordCounter{
        private final int counter;
        private final boolean lastSpace;
        public WordCounter(int counter, boolean lastSpace){
            this.counter =counter;
            this.lastSpace = lastSpace;
        }
        public WordCounter accumulate(Character c)  {
            if (Character.isWhitespace(c)){
                return lastSpace ? this : new WordCounter(counter + 1, false);
            }else {
                return lastSpace ? new WordCounter(counter + 1, false)
                        : this;
            }
        }
        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter,wordCounter.lastSpace);
        }
        public int getCounter(){
            return counter;
        }
        public int countWords(Stream<Character> stream){
            WordCounter reduce = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
            return reduce.getCounter();
        }
}
static class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar=0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) return null;
        //拆分并避免拆分单词
        for (int splitPos = currentSize/2 + currentChar;splitPos<string.length();splitPos++){
            if (Character.isWhitespace(string.charAt(splitPos))){
                WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return wordCounterSpliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED+SIZED + SUBSIZED + NONNULL
                + IMMUTABLE;
    }
}
    public static void main(String[] args) {
        String SENTENCE="everyone should love animals because they are delicious";
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        WordCounter wordCounter = new WordCounter(0,false);
        //顺序流
        System.out.println(" Found " + wordCounter.countWords(characterStream));

        System.out.println("---------------");
        //使用并行流会出错，因为原始的String在任意
        //位置拆分，所以有时一个词会被分为两个词，然后数了两次。这就说明，拆分流会影响结果，而
        //把顺序流换成并行流就可能使结果出错，解决方案为Character 实现一个Spliterator
//        System.out.println(" Found " + wordCounter.countWords(characterStream.parallel()));
        //并行解决方案
        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(wordCounterSpliterator, true);
        System.out.println("found "+ wordCounter.countWords(stream)+" words in parallel");
        //Spliterator还有最后一
        //个值得注意的功能，就是可以在第一次遍历、第一次拆分或第一次查询估计大小时绑定元素的数
        //据源，而不是在创建时就绑定。这种情况下，它称为延迟绑定（late-binding）的Spliterator
        System.out.println(getRandomFontChinese());


    }
}
