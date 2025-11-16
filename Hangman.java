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
        int lostLives = 0;
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
                lostLives++;
                if (lostLives > 6) {
                    System.out.println("GAME OVER");
                    System.out.println("_______\r\n" + 
                                                "|/    |\r\n" + 
                                                "|     0\r\n" + 
                                                "|    -+-\r\n" + 
                                                "|    / \\\r\n" + 
                                                "|\r\n" + 
                                                "-------");
                    return;
                }
                displayGallows(lostLives);
                if (wrongGuesses.length() > 0) {
                    wrongGuesses += ", " + guess;
                }
                else {
                    wrongGuesses = guess;
                }
            }
        }
    }

    public static void displayGallows(int stage) {
        switch (stage) {
            case 1:
                System.out.println("_______\r\n" + 
                                        "|/    |\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "-------");
                break;
            case 2:
                System.out.println("_______\r\n" + 
                                        "|/    |\r\n" + 
                                        "|     0\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "-------");
                break;
            case 3:
                System.out.println("_______\r\n" + 
                                        "|/    |\r\n" + 
                                        "|     0\r\n" + 
                                        "|     +\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "-------");
                break;
            case 4:
                System.out.println("_______\r\n" + 
                                        "|/    |\r\n" + 
                                        "|     0\r\n" + 
                                        "|    -+\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "-------");
                break;
            case 5:
                System.out.println("_______\r\n" + 
                                        "|/    |\r\n" + 
                                        "|     0\r\n" + 
                                        "|    -+-\r\n" + 
                                        "|\r\n" + 
                                        "|\r\n" + 
                                        "-------");
                break;
            case 6:
                System.out.println("_______\r\n" + 
                                        "|/    |\r\n" + 
                                        "|     0\r\n" + 
                                        "|    -+-\r\n" + 
                                        "|    / \r\n" + 
                                        "|\r\n" + 
                                        "-------");
        }
    }
}
