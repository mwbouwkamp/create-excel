import java.util.ArrayList;
import java.util.List;

public class Quiz {

    String quizName;
    List<Question> questions;

    void addQuestion(Question question) {
        if (null == questions) {
            questions = new ArrayList<>();
        }
        questions.add(question);
    }
}
