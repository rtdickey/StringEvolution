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
    private JTextField answerField;
    private User user;
    private Population city;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Gui window = new Gui();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(new Color(240, 240, 240));
        textPane.setBounds(55, 20, 316, 103);
        frame.getContentPane().add(textPane);



        /*
        textPane.setText(user.getLetters() + "\n" + user.getCurrentAnswer());
        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correct = user.guess(answerField.getText());
                textPane.setText(user.getLetters() + "\n" + user.getCurrentAnswer());
                if (correct) {
                    //System.out.println("Correct Answer");
                    textPane.setText(textPane.getText()+"\n"+"Correct Answer!");
                }
            }
        });
        */

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setBounds(111, 168, 30, 30);
        frame.getContentPane().add(textPane_1);

        JTextPane textPane_2 = new JTextPane();
        textPane_2.setBounds(147, 168, 30, 30);
        frame.getContentPane().add(textPane_2);

        JTextPane textPane_3 = new JTextPane();
        textPane_3.setBounds(183, 168, 30, 30);
        frame.getContentPane().add(textPane_3);

        JTextPane textPane_4 = new JTextPane();
        textPane_4.setBounds(219, 168, 30, 30);
        frame.getContentPane().add(textPane_4);

        JTextPane textPane_5 = new JTextPane();
        textPane_5.setBounds(255, 168, 30, 30);
        frame.getContentPane().add(textPane_5);

        JTextPane textPane_6 = new JTextPane();
        textPane_6.setBounds(291, 168, 30, 30);
        frame.getContentPane().add(textPane_6);

        JTextPane textPane_7 = new JTextPane();
        textPane_7.setBounds(111, 205, 30, 30);
        frame.getContentPane().add(textPane_7);

        JTextPane textPane_8 = new JTextPane();
        textPane_8.setBounds(147, 205, 30, 30);
        frame.getContentPane().add(textPane_8);

        JTextPane textPane_9 = new JTextPane();
        textPane_9.setBounds(183, 205, 30, 30);
        frame.getContentPane().add(textPane_9);

        JTextPane textPane_10 = new JTextPane();
        textPane_10.setBounds(219, 205, 30, 30);
        frame.getContentPane().add(textPane_10);

        JTextPane textPane_11 = new JTextPane();
        textPane_11.setBounds(255, 205, 30, 30);
        frame.getContentPane().add(textPane_11);

        JTextPane textPane_12 = new JTextPane();
        textPane_12.setBounds(291, 205, 30, 30);
        frame.getContentPane().add(textPane_12);

        computerFindAnswer(textPane);
    }

    public void computerFindAnswer(JTextPane textPane){
        while(!city.generation()&&(city.getGenerationNum()<200000)){
            textPane.setText(String.valueOf(city.truncatePercentComplete())+"%");
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
