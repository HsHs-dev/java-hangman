package Hangman;

import java.util.*;
import java.io.*;

class RandomWord {


    private final static ArrayList<String> WORDS = new ArrayList<>();
    static ArrayList<Character> playerGuesses = new ArrayList<>();


    static void initiateWords() throws FileNotFoundException {

        Scanner input = new Scanner(new File("words.txt"));

        // store the words from the file in a list
        while (input.hasNext())
            WORDS.add(input.nextLine());

        input.close();
    }

    static String generateRandomWord() {

        try {
            RandomWord.initiateWords();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Random random = new Random();
        String randomWord = WORDS.get(random.nextInt(WORDS.size()));
        
        return randomWord;
    }

    static void generateDashes(String randWord) {
        
        for (int i = 0; i < randWord.length(); i++) {
            if (playerGuesses.contains(randWord.charAt(i)))
                System.out.print(randWord.charAt(i) + " ");
            else
                System.out.print("_ ");
        }
        System.out.println();
    }

    static boolean addGuess(char guess) {
        if (!playerGuesses.contains(guess)) {
            playerGuesses.add(guess);
            return false;
        }
        else {
            System.out.println("You already guessed this letter\n");
            return true;
        }
        
    }

    static boolean checkLetter(char guess, String randWord) {

        for (int i = 0; i < randWord.length(); i++) {
            if (guess == randWord.charAt(i)) {
                System.out.println("CORRECT!\n");
                return true;
            } else
                continue;
        }

        System.out.println("TRY AGAIN\n");
        return false;
        
    }

   
}
