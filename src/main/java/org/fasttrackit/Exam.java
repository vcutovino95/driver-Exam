package org.fasttrackit;

public class Exam
{
    private String [ ] correctAnswers = { "B", "D", "A", "A", "C", "A","B", "A","C", "D", "B", "C", "D",
            "A", "D", "C", "C", "B", "D", "A", "B", "D", "A", "A", "C", "A"};
    private String [ ] studentAnswers;
    private int numberOfQuestions = correctAnswers.length;

    public Exam(String [] studentArrayGiven)
    {
        studentAnswers = studentArrayGiven;
    }

    public int totalCorrect()
    {
        int totalCorrectAnswers = 0;
        for(int index = 0; index < numberOfQuestions; index++)
        {
            if(correctAnswers[index].equalsIgnoreCase(studentAnswers[index]))
            {
                totalCorrectAnswers = totalCorrectAnswers + 1;
            }
        }
        return totalCorrectAnswers;
    }

    public int totalIncorrect()
    {
        int incorrectAnswers = 0;
        for(int index = 0; index < numberOfQuestions; index++)
        {
            if(!(correctAnswers[index].equalsIgnoreCase(studentAnswers[index])))
            {
                incorrectAnswers = incorrectAnswers + 1;
            }
        }
        return incorrectAnswers;
    }

    public boolean passed()
    {
        int passingScore = 22;
        if(totalCorrect() >= passingScore)
        {
            return true;
        }
        return false;
    }

    public int [ ] questionsMissed()
    {
        int [] questionsMissedArray = new int [numberOfQuestions];
        int questionsMissedArrayIndex = 0;
        for(int index = 0; index < numberOfQuestions; index++)
        {
            if(!(correctAnswers[index].equalsIgnoreCase(studentAnswers[index])))
            {
                questionsMissedArray[questionsMissedArrayIndex] = index + 1;
                questionsMissedArrayIndex++;
            }
        }
        return questionsMissedArray;
    }
}