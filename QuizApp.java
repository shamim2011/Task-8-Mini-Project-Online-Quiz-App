package OnlineQuizApp;
import java.util.*;
public class QuizApp {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quizQuestions = new ArrayList<>();

        // Step 1: Take number of questions from user
        System.out.print("Enter the number of questions for the quiz: ");
        int numQuestions = sc.nextInt();
        sc.nextLine(); // consume newline

        // Step 2: Input each question
        for (int i = 0; i < numQuestions; i++) {
            System.out.println("\nEnter details for Question " + (i + 1) + ":");
            System.out.print("Enter question text: ");
            String questionText = sc.nextLine();

            List<String> options = new ArrayList<>();
            for (int j = 0; j < 4; j++) { // 4 options per question
                System.out.print("Enter option " + (j + 1) + ": ");
                options.add(sc.nextLine());
            }

            int correctOption;
            while (true) {
                System.out.print("Enter correct option number (1-4): ");
                correctOption = sc.nextInt();
                sc.nextLine(); // consume newline
                if (correctOption >= 1 && correctOption <= 4) break;
                System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }

            quizQuestions.add(new Question(questionText, options, correctOption));
        }

        // Step 3: Start Quiz
        int score = 0;
        System.out.println("\n=== Starting the Quiz ===");

        for (int i = 0; i < quizQuestions.size(); i++) {
            Question q = quizQuestions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer = sc.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.options.get(q.correctOption - 1));
            }
        }

        // Step 4: Show Result
        System.out.println("\n🎯 Final Score: " + score + "/" + quizQuestions.size());
        if (score == quizQuestions.size()) {
            System.out.println("🏆 Excellent! Perfect Score!");
        } else if (score >= quizQuestions.size() / 2) {
            System.out.println("👍 Good job!");
        } else {
            System.out.println("📚 Keep practicing!");
        }

        sc.close();
    }
}
