package trainee.quizzapp;

class Question {
    private String question;
    private String correctAnswer;
    private int score;

    public Question(String question, String correctAnswer, int score) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getScore() {
        return score;
    }
}
