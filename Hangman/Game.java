package Hangman;
/* HANGMAN GAME */
/*
 * The game logic is about reading words from a text file and shows blanks
 * corresponding to the number of word's letters.
 * - display the main screen
 * - ask the user to enter a letter
 * - check if the letter exists in the secret word:
 *   if it exists, change the corresponding blank to it
 *   if not, increase the errors counter, and change the hangman state
 *   to the corresponding error counter number.
 * - loop until either the user write the whole word or the hangman reach
 *   final state.
 * - display end screen to the user.
 */

/*
 - let the user enter the name of the text file
 - 
 */
import java.util.*;

public class Game {

    private static int errors = 0;

    public void startGame() {
        clearScreen();
        int choice = Menu.displayStartingMenu();

        switch (choice) {
            case 1:
                playGame();
                break;
            case 2:
                quitGame();
                break;
        }
    }

    private static void playGame() {

        clearScreen();
        String randWord = RandomWord.generateRandomWord();

        while (errors != 6) {
            System.out.println(Menu.updateStickmanState(errors));
            RandomWord.generateDashes(randWord);
            char input = userInput();
            clearScreen();
            if (RandomWord.addGuess(input)) {
                continue;
            }
            if (!RandomWord.checkLetter(input, randWord))
                errors++;
            if (checkWin(randWord)) {
                System.out.println("You have won!");
                break;
            }
        }

        if (errors == 6) {
            clearScreen();
            System.out.println(" +---+\n O   |\n/|\\  |\n/ \\  |\n    ===\n");
            System.out.println("The word was: " + randWord +
            "\nGood luck next time");
            
        }
            
    }

    private static void quitGame() {
        System.out.println("See you next time");
    }


    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    private static char userInput() {
        Scanner input = new Scanner(System.in);
        
        char letter = ' ';
        boolean valid = false;
        while (!valid) {
            System.out.println("Guess a letter: ");
            letter = input.next().charAt(0);
            if (Character.isDigit(letter)) {
                System.out.println("please enter a letter only");
                input.nextLine();
            } else
                valid = true;
        }

        return letter;
    }

    private static boolean checkWin(String randWord) {
        int counter = 0;
        for (int i = 0; i < randWord.length(); i++) {
            if (RandomWord.playerGuesses.contains(randWord.charAt(i)))
                counter++;
        }

        if (counter == randWord.length()) return true;
        return false;

    }

    
}