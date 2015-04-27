package com.company;

/**
 * Created by Daniel on 4/26/2015.
 */
public class Computer {
    private Population city;

    public Computer(int size, String goalString, double chance) {
        this.city = new Population(size, goalString, chance);
    }

    public void findGoalString(){
        while(!city.generation()){
            System.out.println(city.truncatePercentComplete() + "%");
            //System.out.println(city);

            //To delay the thread by 50 mills in order to allow the person to keep up.

            try {
                Thread.sleep(50);    //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
