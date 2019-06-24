//package com.mayzhou.streams;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Auther: MayZhou
// * @Date: 19/6/24 11:47
// * @Description:
// * @copyright:
// * @version:
// */
//public class CountLongWords {
//    public static void main(String[] args) throws IOException {
//        String contents = new String(Files.readAllBytes(Paths.get("gutenberg/alice30.txt")), StandardCharsets.UTF_8);
//        List<String> words = Arrays.asList(contents.split("\\PL+"));
//        long count = 0 ;
//        for(String w:words){
//            if(w.length()>12){
//                count++;
//                System.out.print(w+"   ");
//            }
//        }
//        System.out.println(count);
//        count = words.parallelStream().filter((w)->{
//
//            if (w.length()>12){
//                System.out.println(w);
//            }
//        }).count();
//
//    }
//}
