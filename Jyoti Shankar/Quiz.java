package edu.steria.training;
import java.util.Scanner;
public class Quiz {
    private static final int TOTAL_QUESTIONS = 10;
    private static final String[] QUESTIONS = {
            "Question 1: What is the capital of France?",
            "Question 2: Which planet is known as the Red Planet?",
            "Question 3: Which is the largest animal in the world?",
            "Question 4: Which is the longest river in the world?",
            "Question 5: Which is the largest country in the world(by area)?",
            "Question 6: Which is the largest continent?",
            "Question 7: What is the national animal of India?",
            "Question 8: How many states are there in India?",
            "Question 9: Which is the tallest mountain? ",
            "Question 10: Who is the PM of India?"
    };

    private static final String[][] OPTIONS = {
            {"A) Paris", "B) Rome", "C) Berlin", "D) Madrid"},
            {"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
            {"A) Elephant", "B) Shark", "C) Giant Squid", "D) Blue Whale"},
            {"A) Amazon", "B) Nile", "C) Mississippi", "D) Congo"},
            {"A) USA", "B) Russia", "C) China", "D) Brazil"},
            {"A) Asia", "B) Africa", "C) America North", "D) Australia"},
            {"A) Bengal Tiger", "B) Lion", "C) Elephant", "D) Horse"},
            {"A) 27", "B) 28", "C) 29", "D) 30"},
            {"A) K2", "B) Kanchenjunga", "C) Mt. Everest", "D) Nanda Devi"},
            {"A) Narendra Modi", "B) Rahul Gandhi", "C) Amit Shah", "D) Rajnath Singh"},

    };

    private static final char[] CORRECT_ANSWERS = {'A', 'B', 'D', 'B', 'B', 'A', 'A', 'B', 'C', 'A'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            displayQuestion(i);
            char userAnswer = getAnswerFromUser(sc);
            if (userAnswer == CORRECT_ANSWERS[i]) {
                //System.out.println("Correct!\n");
                score++;
            }
            /*else {
                System.out.println("Incorrect. The correct answer is " + CORRECT_ANSWERS[i] + ".\n");
            }*/

            if (i < TOTAL_QUESTIONS - 1) {
                System.out.println("Do you want to move to the next question? (Y/N)");
                char choice = sc.next().charAt(0);
                if (choice != 'Y' && choice != 'y') {
                    i--; // Go back to the previous question
                }
            }
        }

        // Display results
        System.out.println("Quiz completed! Your score: " + score + " out of " + TOTAL_QUESTIONS);
        displayCorrectAnswers();
    }

    private static void displayQuestion(int index) {
        System.out.println(QUESTIONS[index]);
        for (String option : OPTIONS[index]) {
            System.out.println(option);
        }
    }

    private static char getAnswerFromUser(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.next().charAt(0);
    }

    private static void displayCorrectAnswers() {
        System.out.println("Correct Answers:");
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + CORRECT_ANSWERS[i]);
        }
    }
}