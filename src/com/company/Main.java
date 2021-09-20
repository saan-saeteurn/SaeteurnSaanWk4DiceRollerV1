/*
 Let the user set both number of dice and the number of sides, using XdY syntax
 i.e., user enters 5d8, meaning five 8-sided dice.  Then output dice rolls.

 Use a while() loop to let the user continue to roll dice until they decide to
 stop. You *do not* need to keep track of all of the rolls.  Output each dice rolls.

 These can be done in one project.
 */

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please input your dice roll in the format of \"XdY\" to play ('Quit' to exit): ");
        String userInput = input.nextLine();

        while(userInput.equalsIgnoreCase("quit") != true) {
            String[] tokens = userInput.split("d");
            int numSides = Integer.parseInt(tokens[1]);
            int numDice = Integer.parseInt(tokens[0]);
            int total = 0;
            int[] dice = new int[numDice];

            for (int i = 0; i < numDice; i++) {
                Random rand = new Random();
                dice[i] = rand.nextInt(numSides) + 1;
            }

            String msg = "";
            for (int die : dice) {
                msg += "You rolled a " + die + " on a " + numSides + " sided dice \n";
                System.out.println(msg);
                total += die;
            }

            System.out.println("Your total is " + total);
            System.out.printf("\nPlease input your dice roll in the format \"XdY\" to play ('Quit' to exit): ");
            userInput = input.nextLine();
        }

        System.out.println("You've ended the dice roller");
    }
}
