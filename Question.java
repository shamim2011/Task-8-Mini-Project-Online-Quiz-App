package OnlineQuizApp;
import java.util.*;
public class Question {
	String questionText;
    List<String> options;
    int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int answer) {
        return answer == correctOption;
    }

}
