***1.Project Structure***  


  You have two classes in the package OnlineQuizApp:  
Question → a simple class that stores a question, its multiple-choice options, and the correct answer.  

QuizApp → the main program that:  

Takes quiz questions from the user.  

Stores them in a list.  

Runs the quiz.  

Calculates and displays the score.   

***2.The Question Class***  
public class Question {  
    String questionText;    // The actual question  
    List<String> options;   // The 4 answer choices  
    int correctOption;      // The correct option number (1–4)  

    // Constructor to initialize a question  
    public Question(String questionText, List<String> options, int correctOption) {  
        this.questionText = questionText;  
        this.options = options;  
        this.correctOption = correctOption;  
    }  

    // Method to check if the given answer is correct  
    public boolean isCorrect(int answer) {  
        return answer == correctOption;  
    }  
}  

Purpose:   

Encapsulates a single quiz question.  

Provides a method isCorrect() to easily check if the user’s answer matches the correct one.  

***3.The QuizApp Main Class***  
public class QuizApp {  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        List<Question> quizQuestions = new ArrayList<>();  
.    
Creates a scanner for user input.  

Creates a list to store all quiz questions.  
  
***Step 1: Asking how many questions***  
System.out.print("Enter the number of questions for the quiz: ");  
int numQuestions = sc.nextInt();  
sc.nextLine(); // consume leftover newline  
The quiz creator specifies how many questions they will add.  
***Step 2: Inputting questions***  
for (int i = 0; i < numQuestions; i++) {  
    System.out.println("\nEnter details for Question " + (i + 1) + ":");  
    System.out.print("Enter question text: ");  
    String questionText = sc.nextLine();  

    List<String> options = new ArrayList<>();  
    for (int j = 0; j < 4; j++) {  
        System.out.print("Enter option " + (j + 1) + ": ");  
        options.add(sc.nextLine());  
    }  

    For each question:  

Get the question text.  

Get 4 answer choices from the user.  
***Step 3: Choosing the correct answer***  
int correctOption;  
while (true) {  
    System.out.print("Enter correct option number (1-4): ");  
    correctOption = sc.nextInt();  
    sc.nextLine(); // consume newline  
    if (correctOption >= 1 && correctOption <= 4) break;  
    System.out.println("Invalid choice! Please enter a number between 1 and 4.");  
}  
quizQuestions.add(new Question(questionText, options, correctOption));  
Ensures the correct answer number is valid (1–4).  

Adds the new question to the list quizQuestions.  
***Step 4: Running the quiz***  
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
Loops through each stored question.  

Displays the question and options.  

Gets the user's answer.  

Uses isCorrect() from Question class to check if the answer is correct.  

Updates the score.  

***Step 5: Displaying the result***  
System.out.println("\n🎯 Final Score: " + score + "/" + quizQuestions.size());  
if (score == quizQuestions.size()) {  
    System.out.println("🏆 Excellent! Perfect Score!");  
} else if (score >= quizQuestions.size() / 2) {  
    System.out.println("👍 Good job!");  
} else {  
    System.out.println("📚 Keep practicing!");  
}  
Shows the total score.  

Gives a motivational message based on performance.  
***How It Works in Practice***  

Enter the number of questions for the quiz: 2  

Enter details for Question 1:  
Enter question text: What is the capital of France?  
Enter option 1: Paris  
Enter option 2: Rome  
Enter option 3: Madrid  
Enter option 4: Berlin  
Enter correct option number (1-4): 1  

Enter details for Question 2:  
Enter question text: Which planet is known as the Red Planet?  
Enter option 1: Earth  
Enter option 2: Mars  
Enter option 3: Venus  
Enter option 4: Jupiter  
Enter correct option number (1-4): 2  

=== Starting the Quiz ===  

Q1: What is the capital of France?  
1. Paris  
2. Rome  
3. Madrid  
4. Berlin  
Your answer (1-4): 1  
✅ Correct!  

Q2: Which planet is known as the Red Planet?  
1. Earth  
2. Mars  
3. Venus  
4. Jupiter  
Your answer (1-4): 3  
❌ Wrong! Correct answer: Mars    
  
🎯 Final Score: 1/2    
👍 Good job!  



