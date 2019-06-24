package com.mayzhou.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import static java.util.Arrays.*;

/**
 * @Auther: MayZhou
 * @Date: 19/6/24 12:15
 * @Description:
 * @copyright:
 * @version:
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter"
                , "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order: ");
        //排序
        sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length");
        sort(planets, (first,second)-> {
            return -(first.length() - second.length());
        });
        System.out.println(Arrays.toString(planets));
        sort(planets,(first,second)-> first.length()-second.length());
        System.out.println(Arrays.toString(planets));
        sort(planets, Comparator.<String>comparingInt(String::length));
        System.out.println(Arrays.toString(planets));
        Timer t1 = new Timer(1000,event -> {
            System.out.printf("The time is %s%n", new Date());
        });
        Timer t2 = new Timer(1000, LambdaTest::actionPerformed);
        t1.start();
        t2.start();
        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }

    private static void actionPerformed(ActionEvent event) {
        System.out.printf("The time is %s%n", new Date());
    }
}
