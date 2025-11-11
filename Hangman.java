package hangman;
import java.util.Scanner;

public class Hangman {
    
    public static void main(String[] args) {
        System.out.println("Hangman Game");
        play();
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String guess = "";
        while (!guess.equals("EXIT")) {
            guess = scanner.nextLine();
        }
    }
}
