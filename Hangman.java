package hangman;
import java.util.Scanner;

public class Hangman {
    
    public static void main(String[] args) {
        System.out.println("Hangman Game");
        play();
    }  
     
    public static String getAnswer() {
        return "ANSWER";
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String answer = getAnswer();
        String guess = "";
        while (!guess.equals("EXIT")) {
            guess = scanner.nextLine();

            if (guess.equals(answer)) {
                System.out.println("WINNER");
                return;
            }
        }
    }
}
