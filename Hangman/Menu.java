package Hangman;
import java.util.*;

class Menu {

    final static String[] STICKMAN_STATES = {
        " +---+\n     |\n     |\n     |\n    ===\n",
        " +---+\n O   |\n     |\n     |\n    ===\n",
        " +---+\n O   |\n |   |\n     |\n    ===\n",
        " +---+\n O   |\n/|   |\n     |\n    ===\n",
        " +---+\n O   |\n/|\\  |\n     |\n    ===\n",
        " +---+\n O   |\n/|\\  |\n/    |\n    ===\n",
        " +---+\n O   |\n/|\\  |\n/ \\  |\n    ===\n"
    };

    static int displayStartingMenu() {
        System.out.println("\n Welcome to Hassan's HANGMAN!");
        System.out.print("|----------------------------|\n");
        System.out.print("|        1- Start Game       |\n");
        System.out.print("|        2- Quit             |\n");
        System.out.print("|----------------------------|\n");

        return validateChoice();
    }

    private static int validateChoice() {

        Scanner input = new Scanner(System.in);

        int choice = 0;
        boolean valid = false;
        do {    
            
            try {
            
                System.out.println("Enter choice: ");
                choice = input.nextInt();
                if (choice == 1 || choice == 2)
                    valid = true;
                else
                    System.out.println("Enter only 1 or 2");
            
            } catch (InputMismatchException ex) {
                System.out.println("Enter only 1 or 2");
                input.nextLine();
            }

        } while (!valid);

        return choice;

    }

    static String updateStickmanState(int errors) {
        return STICKMAN_STATES[errors];
    }
    


}
