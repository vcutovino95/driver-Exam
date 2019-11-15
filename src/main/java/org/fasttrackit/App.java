package org.fasttrackit;

import java.util.Scanner;

class Main {
    private static void fillStudentAnswersArray(String[] studentAnswers)
    {
        Scanner keyboard = new Scanner(System.in);
        for(int index = 0; index < studentAnswers.length; index++)
        {
            String userResponse;
            System.out.println("Care este raspunsul la intrebarea " + (index + 1) + "?");
            userResponse = keyboard.nextLine();
            while(!userResponse.equalsIgnoreCase( "A" ) && !userResponse.equalsIgnoreCase( "B" ) && !userResponse.equalsIgnoreCase( "C" ) && !userResponse.equalsIgnoreCase( "D" ))
            {
                System.out.println("Te rog sa introduci un raspuns valid la intrebarea " + (index + 1) + ":");
                userResponse = keyboard.nextLine();
            }
            studentAnswers[index] = userResponse;
        }
    }

    private static void showTestResults(Exam driverExamObject)
    {
        System.out.println("Ai raspuns corect la " + driverExamObject.totalCorrect() + " intrebari si ai " + driverExamObject.totalIncorrect() + " raspunsuri incorecte.");
        System.out.print("Ai gresit intrebarea ");
        for (int index = 0; index < driverExamObject.questionsMissed().length; index++)
        {
            if(driverExamObject.questionsMissed()[index] != 0)
            {
                System.out.print(driverExamObject.questionsMissed()[index] + " ");
            }
        }
        if(driverExamObject.passed())
        {
            System.out.println("Esti admis!");
        }
        else
        {
            System.out.println("Esti respins");
        }
    }

    public static void main (String [] args)
    {
        final int NUMBER_OF_QUESTIONS = 26;
        String [] studentAnswers = new String[NUMBER_OF_QUESTIONS];
        fillStudentAnswersArray(studentAnswers);
        Exam drivingTest = new Exam(studentAnswers);
        showTestResults(drivingTest);
    }
}