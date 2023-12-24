package com.example.quiz_app;

public class QuestionAnswer
{
    public static String question [] = {
            "Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of these access specifiers can be used for an interface?",
            "What is the return type of Constructors?" };

    public static String choices [] [] = {
            {"finalize method","main method","static method","private method"},
            {"import","this","catch","abstract"},
            {"public","protected","private","All of the mentioned"},
            {"Import pkg.","import pkg.*","Import pkg.*","import pkg."},
            {"int","float","void","None of the mentioned"}
    };

    public static String correctAnswers [] = {
            "main method","this","public","import pkg.*","None of the mentioned"
    };
}
