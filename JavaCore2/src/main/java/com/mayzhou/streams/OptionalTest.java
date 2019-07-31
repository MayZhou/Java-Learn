package com.mayzhou.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @Auther: MayZhou
 * @Date: 19/6/25 02:21
 * @Description:
 * @copyright:
 * @version:
 */
public class OptionalTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\item3\\JavaLearn\\Stream\\src\\main\\resources\\gutenberg\\alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Optional<String> optionalValue = wordList.stream().filter(s -> s.contains("fred")).findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);
        try {
            result = optionalString.orElseThrow(IllegalAccessException::new);
            System.out.println("result: " + result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
