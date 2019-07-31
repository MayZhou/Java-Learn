package com.mayzhou.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;


/**
 * @author MayZhou
 */
public class CollectionResults {

    public static Stream<String> novowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\item3\\JavaLearn\\JavaCore2\\src\\main\\resources\\gutenberg\\alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replace("[aeiouAEIOU]", ""));

    }

    public static <T> void show(String label, Set<T> set) {
        out.println(label + ": " + set.getClass().getName());
        out.println("{" + set.stream().limit(10).map(Objects::toString).collect(Collectors.joining(",")) + "}");

    }

    public static void main(String[] args) {
        Iterator<Integer> integerIterator = Stream.iterate(0,n-> n+1).limit(10).iterator();
        while (integerIterator.hasNext()){
            out.println(integerIterator.next());
        }
    }
}
