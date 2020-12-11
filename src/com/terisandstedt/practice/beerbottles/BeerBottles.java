package com.terisandstedt.practice.beerbottles;

/**
 * Exercise from: https://dev.to/samborick/100-project-ideas-oda
 * 99 Bottles of beer
 * <p>
 * - Create a program that prints out every line to the song "99 bottles of beer on the wall."
 * - Do not use a list for all of the numbers, and do not manually type them all in. Use a built-in function instead.
 * - Besides the phrase "take one down," you may not type in any numbers/names of numbers directly into your song
 * lyrics.
 * - Remember, when you reach 1 bottle left, the word "bottles" becomes singular.
 */
public class BeerBottles {

    public static void main(String[] args) {
        String[] lyrics = {
                " bottles of beer",
                " bottle of beer",
                " on the wall",
                "Take one down,",
                "Take it down,",
                " pass it around"
        };

        System.out.println("All the words to \"99 bottles of beer on the wall\"");

        for (int bottles = 99; bottles > 0; bottles--) {
            if (bottles == 1) {
                System.out.println();
                System.out.println(bottles + lyrics[1] + lyrics[2]);
                System.out.println(bottles + lyrics[1]);
                System.out.println(lyrics[4] + lyrics[5]);
                System.out.println("No more" + lyrics[0] + lyrics[2]);
            }
            else {
                System.out.println();
                System.out.println(bottles + lyrics[0] + lyrics[2]);
                System.out.println(bottles + lyrics[0]);
                System.out.println(lyrics[3] + lyrics[5]);
                if (bottles == 2) {
                    System.out.println(bottles - 1 + lyrics[1] + lyrics[2]);
                }
                else {
                    System.out.println(bottles - 1 + lyrics[0] + lyrics[2]);
                }
            }
        }
    }
}