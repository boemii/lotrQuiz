package berlin.boem.lotr;

public class QuizClass {
    private final String question;
    private final String options;
    private final String correctAnswer;

    public QuizClass(String question, String options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }
    public String getOptions() {
        return this.options;
    }
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

}
