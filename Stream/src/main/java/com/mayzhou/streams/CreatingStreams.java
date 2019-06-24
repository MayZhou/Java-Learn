package com.mayzhou.streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * @Auther: MayZhou
 * @Date: 19/6/25 01:08
 * @Description:
 * @copyright:
 * @version:
 */
public class CreatingStreams {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\item3\\JavaLearn\\Stream\\src\\main\\resources\\gutenberg\\alice30.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words: ",words);
        Stream<String> song = Stream.of("gently","down","the","stream");
        show("song: " ,song);
        Stream<String> silence = Stream.empty();
        show("silence",silence);
        Stream<String> echos = Stream.generate(()->"Echo");
        show("echos",echos);
        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms",randoms);
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,n->n.add(BigInteger.ONE));
        show("integers",integers);
        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay",wordsAnotherWay);
        Stream<String> lines = Files.lines(path,StandardCharsets.UTF_8);
        show("lines",lines);

    }
    public static <T> void show(String title, Stream<T> stream){
        final int size = 10;
        List<T> firstElements = stream.limit(size+1).collect(Collectors.toList());
        out.println(title+ ":");
        for (int i =0;i< firstElements.size(); i++){
            if (i>0){
                out.print(", ");
            }
            if (i<size){
                out.print(firstElements.get(i));
            }
            else {
                out.print("...");
            }
        }
        out.println();
    }
}
