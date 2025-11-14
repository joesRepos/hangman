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

    public static String makeGuess(String maskedAnswer, String answer, char guess) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                maskedAnswer = maskedAnswer.substring(0, i) + guess + maskedAnswer.substring(i + 1);
            }
        }
        return maskedAnswer;
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String answer = getAnswer();
        String maskedAnswer = maskAnswer(answer);
        String guess = "";
        String wrongGuesses = "";
        while (!guess.equals("EXIT")) {
            System.out.println(maskedAnswer);
            if (wrongGuesses.length() > 0) {
                System.out.println("Wrong guesses: " + wrongGuesses);
            }
            guess = scanner.nextLine();
            if (guess.length() > 1 && guess.equals(answer)) {
                System.out.println("WINNER");
                return;
            }
            else if (answer.contains(guess)) {
                maskedAnswer = makeGuess(maskedAnswer, answer, guess.charAt(0));
            }
            else if (!wrongGuesses.contains(guess)) {
                if (wrongGuesses.length() > 0) {
                    wrongGuesses += ", " + guess;
                }
                else {
                    wrongGuesses = guess;
                }
            }
        }
    }
}
