package org.example;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String[] questions = new String[10];
    static String[] correctAnswers = new String[10];
    static String[] userAnswers = new String[10];
    static int score = 0;
    static int currentQuestionIndex = 0;

    public static void displayQuestion(int index) {
        System.out.println(questions[index]);
        System.out.println("Enter your answer or choose an option:\n0 - Previous question\n1 - Next question\n2 - Edit answer");
        userAnswers[index] = scan.nextLine();
    }

    public static void checkAnswer(int index) {
        if (userAnswers[index].equals(correctAnswers[index])) {
            score++;
        }
    }

    public static void previousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayQuestion(currentQuestionIndex);
        } else {
            System.out.println("You are already on the first question.");
        }
    }

    public static void nextQuestion() {
        if (currentQuestionIndex < questions.length - 1) {
            currentQuestionIndex++;
            displayQuestion(currentQuestionIndex);
        } else {
            System.out.println("You have reached the last question.");
        }
    }

    public static void editAnswer() {
        System.out.println("Enter new answer:");
        userAnswers[currentQuestionIndex] = scan.nextLine();
    }

    public static void main(String[] args) {

        questions[0] = "Question 1.....\na)\nb)\nc)\nd)";
        questions[1] = "Question 2.....\na)\nb)\nc)\nd)";
        questions[2] = "Question 3.....\na)\nb)\nc)\nd)";
        questions[3] = "Question 4.....\na)\nb)\nc)\nd)";
        questions[4] = "Question 5.....\na)\nb)\nc)\nd)";
        questions[5] = "Question 6.....\na)\nb)\nc)\nd)";
        questions[6] = "Question 7.....\na)\nb)\nc)\nd)";
        questions[7] = "Question 8.....\na)\nb)\nc)\nd)";
        questions[8] = "Question 9.....\na)\nb)\nc)\nd)";
        questions[9] = "Question 10.....\na)\nb)\nc)\nd)";

        correctAnswers[0] = "a";
        correctAnswers[1] = "a";
        correctAnswers[2] = "a";
        correctAnswers[3] = "a";
        correctAnswers[4] = "a";
        correctAnswers[5] = "a";
        correctAnswers[6] = "a";
        correctAnswers[7] = "a";
        correctAnswers[8] = "a";
        correctAnswers[9] = "a";

        for (currentQuestionIndex = 0; currentQuestionIndex < questions.length; currentQuestionIndex++) {
            displayQuestion(currentQuestionIndex);
            switch (userAnswers[currentQuestionIndex]) {
                case "0":
                    previousQuestion();
                    break;
                case "1":
                    nextQuestion();
                    break;
                case "2":
                    editAnswer();
                    break;
                default:
                    checkAnswer(currentQuestionIndex);
            }
        }
        System.out.println("Your final score is: " + score);
    }
}