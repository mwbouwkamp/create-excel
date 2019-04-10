import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MailExcel {

    public static void main(String[] args) {
        Quiz mQuiz = new Quiz();
        mQuiz.quizName = "Excel-quiz";
        Question question1 = new Question("Where do you find the best answers?", "Stack-Overflow");
        Question question2 = new Question("Who to ask?", "mwb");
        mQuiz.addQuestion(question1);
        mQuiz.addQuestion(question2);

        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("Quiz");
        Row row1 = sheet.createRow(0);
        Row row2 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Quiz");
        row2.createCell(0).setCellValue(mQuiz.quizName);
        int col = 1;
        for (Question question: mQuiz.questions) {
            row1.createCell(col).setCellValue("Question " + col);
            row2.createCell(col).setCellValue(question.question);
            col++;
        }
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("quiz.xlsx");
            workbook.write(file);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
