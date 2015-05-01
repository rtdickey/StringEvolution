package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Computer computer = new Computer(20, "ABCDEFGHIJKLMNOPQRSTUVWXYZzyxwvutsrqponmlkjihgfedbca", .5);
        //computer.findGoalString();
        User user = new User("Hello world",3);
        String guess;
        boolean correct;
        Scanner cin = new Scanner(System.in);

        do{
            System.out.println("\"" + user.getLetters() + "\"");
            guess = cin.nextLine();
            correct = user.guess(guess);
            System.out.println(user.getCurrentAnswer());
        }while(!correct);
    }

    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
}
