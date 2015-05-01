package com.company;

/**
 * Created by Daniel on 5/1/2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;


public class Gui {

    private JFrame frame;
    private User user;
    private Population city;

    private JTextPane textPane_User;
    private JTextPane textPane_Computer;
    private JTextField answerField;
    private JTextPane textPane_1;
    private JTextPane textPane_2;
    private JTextPane textPane_3;
    private JTextPane textPane_4;
    private JTextPane textPane_5;
    private JTextPane textPane_6;
    private JTextPane textPane_7;
    private JTextPane textPane_8;
    private JTextPane textPane_9;
    private JTextPane textPane_10;
    private JTextPane textPane_11;
    private JTextPane textPane_12;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Gui window;
        window = new Gui();
        window.frame.setVisible(true);

        //Make new processes for computer/user
        window.computerFindAnswer();

        /*
        EventQueue.invokeLater(() -> {
            try {
                window = new Gui();
                window.frame.setVisible(true);
                Thread.sleep(5000);
                //Thread.sleep(10000);
                //window.computerFindAnswer();
            } catch (Exception e) {
                e.printStackTrace();
                window = new Gui();
                window.frame.setVisible(true);

            }
            window.textPane.setText("Hello World");
        });
        */
    }

    /**
     * Create the application.
     */
    public Gui() {
        String goalString = "Hello World";
        user = new User(goalString);
        city = new Population(20, goalString, .5);
        initialize();
}

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        answerField = new JTextField();
        answerField.setBounds(55, 138, 316, 20);
        frame.getContentPane().add(answerField);
        answerField.setColumns(10);

        textPane_User = new JTextPane();
        textPane_User.setEditable(false);
        //textPane_User.setBackground(new Color(240, 240, 240));
        textPane_User.setBounds(55, 20, 147, 103);
        frame.getContentPane().add(textPane_User);

        textPane_Computer = new JTextPane();
        textPane_Computer.setEditable(false);
        //textPane_Computer.setBackground(new Color(240, 240, 240));
        textPane_Computer.setBounds(224, 20, 147, 103);
        frame.getContentPane().add(textPane_Computer);


        textPane_User.setText(user.getLetters() + "\n" + user.getCurrentAnswer());
        answerField.addActionListener(e -> {
            boolean correct = user.guess(answerField.getText());
            textPane_User.setText(user.getLetters() + "\n" + user.getCurrentAnswer());
            if (correct) {
                //System.out.println("Correct Answer");
                textPane_User.setText(textPane_User.getText()+"\n"+"Correct Answer!");
            }
        });


        textPane_1 = new JTextPane();
        textPane_1.setBounds(111, 168, 30, 30);
        frame.getContentPane().add(textPane_1);

        textPane_2 = new JTextPane();
        textPane_2.setBounds(147, 168, 30, 30);
        frame.getContentPane().add(textPane_2);

        textPane_3 = new JTextPane();
        textPane_3.setBounds(183, 168, 30, 30);
        frame.getContentPane().add(textPane_3);

        textPane_4 = new JTextPane();
        textPane_4.setBounds(219, 168, 30, 30);
        frame.getContentPane().add(textPane_4);

        textPane_5 = new JTextPane();
        textPane_5.setBounds(255, 168, 30, 30);
        frame.getContentPane().add(textPane_5);

        textPane_6 = new JTextPane();
        textPane_6.setBounds(291, 168, 30, 30);
        frame.getContentPane().add(textPane_6);

        textPane_7 = new JTextPane();
        textPane_7.setBounds(111, 205, 30, 30);
        frame.getContentPane().add(textPane_7);

        textPane_8 = new JTextPane();
        textPane_8.setBounds(147, 205, 30, 30);
        frame.getContentPane().add(textPane_8);

        textPane_9 = new JTextPane();
        textPane_9.setBounds(183, 205, 30, 30);
        frame.getContentPane().add(textPane_9);

        textPane_10 = new JTextPane();
        textPane_10.setBounds(219, 205, 30, 30);
        frame.getContentPane().add(textPane_10);

        textPane_11 = new JTextPane();
        textPane_11.setBounds(255, 205, 30, 30);
        frame.getContentPane().add(textPane_11);

        textPane_12 = new JTextPane();
        textPane_12.setBounds(291, 205, 30, 30);
        frame.getContentPane().add(textPane_12);


    }

    public void computerFindAnswer(){
        while(!city.generation() && (city.getGenerationNum() < 200000)) {
            textPane_Computer.setText(String.valueOf(city.truncatePercentComplete()) + "%");
            //System.out.println(city.truncatePercentComplete() + "%");
            //System.out.println(city);

            //To delay the thread by 50 mills in order to allow the person to keep up.

            try {
                Thread.sleep(50);    //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            textPane_Computer.setText(city.getGoalString());
        }
    }
}
