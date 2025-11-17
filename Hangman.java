package hangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    public static void main(String[] args) {
        play();
    }  
     

    public static String maskAnswer(String answer) {
        return "_".repeat(answer.length());
    } 

    public static String makeGuess(String maskedAnswer, String answer, char guess) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                maskedAnswer = maskedAnswer.substring(0, i) + guess + maskedAnswer.substring(i + 1);
            }
        }
        return maskedAnswer;
    }

    public static String getAnswer() {
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("hangman/wordList.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(";") && !line.isEmpty()) {
                    String[] parts = line.split(";");
                    String word = parts[1];
                    if (word.length() > 3) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static void play() {
        System.out.println("Welcome to Hangman");
        Scanner scanner = new Scanner(System.in);
        String answer = getAnswer();
        String maskedAnswer = maskAnswer(answer);
        String guess = "";
        String wrongGuesses = "";
        int lostLives = 0;
        while (!guess.equals("EXIT")) {
            System.out.println("******************");
            System.out.println(maskedAnswer);
            if (wrongGuesses.length() > 0) {
                System.out.println("Wrong guesses: " + wrongGuesses);
            }
            System.out.println("Make a guess:");
            guess = scanner.nextLine();
            if (guess.length() > 1 && guess.equals(answer)) {
                System.out.println("WINNER");
                return;
            }
            else if (answer.contains(guess)) {
                maskedAnswer = makeGuess(maskedAnswer, answer, guess.charAt(0));
            }
            else if (!wrongGuesses.contains(guess)) {
                System.out.println("WRONG");
                System.out.println("The answer was " + answer);
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
