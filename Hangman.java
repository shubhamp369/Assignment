package com.aurionpro.model;

import java.util.*;

public class Hangman {
    static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "grape", "orange", "mango"};
        String word = words[new Random().nextInt(words.length)];
        char[] blanks = new char[word.length()];
        Arrays.fill(blanks, '_');

        int lives = MAX_LIVES;
        Scanner sc = new Scanner(System.in);
        Set<Character> guessedLetters = new HashSet<>();

        while (lives > 0) {
            System.out.println("\nWord: " + String.valueOf(blanks));
            System.out.println("Lives left: " + lives);
            System.out.print("Guess a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);

            if (word.contains(String.valueOf(guess))) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        blanks[i] = guess;
                    }
                }
                if (String.valueOf(blanks).equals(word)) {
                    System.out.println("\nWord: " + word);
                    System.out.println(" Congratulations! You guessed the word.");
                    return;
                }
            } else {
                lives--;
                if (lives == 0) {
                    System.out.println(" Game Over! The word was: " + word);
                }
            }
        }

       
    }
}
