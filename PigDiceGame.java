package com.aurionpro.model;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {
    private static final int WINNING_SCORE = 100;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        int player1Score = 0;
        int player2Score = 0;
        boolean player1Turn = true;

        System.out.println(" Welcome to the PIG Dice Game!");
        System.out.println("First player to reach 100 points wins!\n");

        while (player1Score < WINNING_SCORE && player2Score < WINNING_SCORE) {
            int turnScore = 0;
            String currentPlayer = player1Turn ? "Player 1" : "Player 2";
            System.out.println(" " + currentPlayer + "'s turn");

            boolean keepRolling = true;

            while (keepRolling) {
                System.out.print("Roll or Hold? (r/h): ");
                String choice = scanner.nextLine().toLowerCase();

                if (choice.equals("r")) {
                    int roll = random.nextInt(6) + 1;
                    System.out.println("You rolled: " + roll);

                    if (roll == 1) {
                        System.out.println("Oops! Rolled a 1. No points this turn.\n");
                        turnScore = 0;
                        keepRolling = false;
                    } else {
                        turnScore += roll;
                        System.out.println("Current turn score: " + turnScore);
                    }
                } else if (choice.equals("h")) {
                    if (player1Turn) {
                        player1Score += turnScore;
                        System.out.println("Player 1 total score: " + player1Score + "\n");
                    } else {
                        player2Score += turnScore;
                        System.out.println("Player 2 total score: " + player2Score + "\n");
                    }
                    keepRolling = false;
                } else {
                    System.out.println("Invalid input! Type 'r' to roll or 'h' to hold.");
                }
            }

            // Check for winner
            if (player1Score >= WINNING_SCORE) {
                System.out.println(" Player 1 wins with " + player1Score + " points!");
            } else if (player2Score >= WINNING_SCORE) {
                System.out.println(" Player 2 wins with " + player2Score + " points!");
            }

            // Switch player
            player1Turn = !player1Turn;
        }

       
    }
}
