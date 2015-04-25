package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Population city = new Population(20, "One step closer to skynet", .5);
        while(!city.generation()){
            System.out.println(city.toString());
            try {
                Thread.sleep(50);    //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            clearConsole();
        }
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
