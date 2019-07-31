package com.mayzhou.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author MayZhou
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\item3\\JavaLearn\\JavaCore2\\src\\main\\resources\\gutenberg\\alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0 ;
        for(String w:words){
            if(w.length()>12){
                count++;
                System.out.print(w+"   ");
            }

        }
        System.out.println();
        System.out.println(count);
        
        System.out.println("-------------------------------");
        count = words.stream().filter(w->w.length()>12).count();

        Stream<String> stream = words.stream();
        stream.forEach(s -> {
            System.out.println(s);
        });


    }
}
