package berlin.boem.lotr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class game {
    // Declare an ArrayList to store quiz questions and answers
    static ArrayList<QuizClass> quizClassArrayList = new ArrayList<>();
    // Declare a Scanner object to read user input
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            // Create a File object for the quiz file
            File myObj = new File("quiz.txt");
            // Use the Scanner object to read the quiz file
            Scanner myReader = new Scanner(myObj);
            // Loop through the file, reading one line at a time
            while (myReader.hasNextLine()) {
                // Read the current line
                String data = myReader.nextLine();
                // Split the line into an array, using the semicolon as a separator
                String[] arr = data.split(";");
                // Extract the question, options, and correct answer from the array
                String questions = arr[0];
                String options = arr[1];
                String correctAnswer = arr[2];
                // Add the quiz question and answers to the QuizClass constructor
                quizToarray(questions,options,correctAnswer);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        play();
    }

    public static void quizToarray(String questions, String options, String correctAnswer) {
        QuizClass quiz = new QuizClass(questions, options, correctAnswer);
        quizClassArrayList.add(quiz);
    }
    private static void play() {
        //Score counter
        int score =0;
        //Array wird zufällig durchgemischt
        //iteriert quiz array
        for (QuizClass el : quizClassArrayList) {
            //Frage printen
            System.out.println(el.getQuestion());
            //anwortmögichkeiten Printen
            System.out.println(el.getOptions());
            System.out.println("Ihre antwort(A,B,C oder D)");
            String userAnswer;
            do {
                try {
                    //Usereingabe Antwort
                    userAnswer = sc.next().toUpperCase();
                    //Prüfung ob usereingabe A,B,C oder D ist
                    if (userAnswer.charAt(0) < 65 || userAnswer.charAt(0) > 68 || userAnswer.length() != 1) {
                        System.err.println("Ungültige eingabe");
                    }
                } catch (NoSuchElementException elementException) {
                    System.err.println("Ungültige eingabe");
                    sc.next();
                    userAnswer = "";
                }
            } while (userAnswer.charAt(0) < 65 || userAnswer.charAt(0) > 68 || userAnswer.length() != 1);
            //Prüft ob usereingabe mit richtiger antwort übereinstimmt
            if (userAnswer.equals(el.getCorrectAnswer())) {
                score += 1;
                System.out.println("Korrekt");
            }else{
                System.out.println("Falsch, die richtige Anwort war: "+el.getCorrectAnswer());
            }
        }
        System.out.println("Du hast "+score+" von "+quizClassArrayList.size()+" Punkten erreicht");

    }
}
