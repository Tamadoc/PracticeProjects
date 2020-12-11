package com.terisandstedt.practice.magic8;

import java.util.Random;
import java.util.Scanner;

/**
 * Exercise from: https://dev.to/samborick/100-project-ideas-oda
 * Magic 8 Ball
 *
 * Simulate a magic 8-ball.
 * - Allow the user to enter their question.
 * - Display an in progress message(i.e. "thinking").
 * - Create 20 responses, and show a random response.
 * - Allow the user to ask another question or quit.
 *
 * Bonus: Add a gui.
 * - It must have a box for users to enter the question.
 * - It must have at least 4 buttons:
 *    - ask
 *    - clear (the text box)
 *    - play again
 *    - quit (this must close the window)
 *
 *    Simple console version
 */

public class Magic8Console {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String input;
        String[] answers = {
                "Yes",
                "Absolutely",
                "No doubt about it",
                "Of course",
                "Always",
                "The outlook is good",
                "Almost certainly",
                "Maybe",
                "The truth is unclear",
                "There's a 50/50 chance",
                "You know the truth already",
                "Possibly",
                "Unlikely",
                "No",
                "Not at this time",
                "Never",
                "It's doubtful",
                "Not a chance",
                "Sorry, not gonna happen",
                "Probably not"
        };

        do {
            System.out.println("Ask a question");
            scanner.next();

            System.out.println("Thinking...");

            int index = random.nextInt(answers.length);
            System.out.println(answers[index]);

            while (true){
                System.out.println("Do you have another question? (Y/N)");
                input = scanner.next().toLowerCase();
                if (input.equals("n") || input.equals("y")) {
                    break;
                } else {
                    System.out.println("That is not a valid option");
                }
            }
        } while (input.equals("y"));
    }
}
