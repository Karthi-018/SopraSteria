package trainee.quizzapp;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the user's name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Select programming language category
        System.out.println("Select a programming language category:");
        System.out.println("1. Python");
        System.out.println("2. Java");
        System.out.println("3. C");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // Load questions based on the user's choice
        ArrayList<Question> questions = loadQuestionsForChoice(choice);

        // Start the quiz
        int score = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(question.getCorrectAnswer())){
                System.out.println("Correct!");
                score += question.getScore();
            } else {
                System.out.println("Incorrect!");
            }
        }

        // Display the final score
        System.out.println("Quiz complete, " + userName + "! Your total score: " + score);
    }

    private static ArrayList<Question> loadQuestionsForChoice(int choice) {
        ArrayList<Question> questions = new ArrayList<>();

        switch (choice) {
            case 1: // Python questions
                questions.add(new Question("What is the array?", "topic", 10));
                questions.add(new Question("What is the output of printf(3 + 5)?", "8", 5));
                questions.add(new Question("What does the '==' operator do in Python?", "equals", 5));
                break;
            case 2: // Java questions
                questions.add(new Question("What is java?", "language", 10));
                questions.add(new Question("which language u selectec?", "java", 5));
                questions.add(new Question("What does the '>' operator do in Java?", "greater", 5));
                break;
            case 3: // C questions
                questions.add(new Question("What is C?", "language", 10));
                questions.add(new Question("What is the output of printf(\"%d\", 3 + 5)?", "8", 5));
                questions.add(new Question("What does the '<' operator do in C?", "lessthan", 5));
                break;
            default:
                System.out.println("Invalid choice.");
        }

        return questions;
    }
}
