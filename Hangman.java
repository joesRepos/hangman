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

    public static String maskAnswer(String answer) {
        return "*".repeat(answer.length());
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String answer = getAnswer();
        String maskedAnswer = maskAnswer(answer);
        String guess = "";
        while (!guess.equals("EXIT")) {
            System.out.println(maskedAnswer);
            guess = scanner.nextLine();

            if (guess.equals(answer)) {
                System.out.println("WINNER");
                return;
            }
        }
    }
}
