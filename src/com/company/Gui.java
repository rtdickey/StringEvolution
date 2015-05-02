package com.company;

/**
 * Created by Daniel on 5/1/2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.*;


public class Gui {
    private boolean userWins;

    //replace goalString with Question object
    private String hint;
    private String goalString;
    private Vector<Question> questions;

    private JFrame frame;
    private User user;
    private Population city;

    private JButton startButton;

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

    private JButton resetButton;

    Thread thread;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Gui window;
        window = new Gui();
        window.frame.setVisible(true);

    }

    /**
     * Create the application.
     */
    public Gui() {
        questions = new Vector<>();
        readQuestions();
        initMenu();
    }

    private void readQuestions() {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("src\\input.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String newGoalString = line.substring(0,line.indexOf('\"')-1);
                String newHint = line.substring(line.indexOf('\"'));
                questions.add(new Question(newHint, newGoalString));
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
            System.exit(1);
        }
        /*
        for(int i=0;i<questions.size();i++){
            System.out.println(questions.elementAt(i));
        }
        */
    }

    private void initMenu() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sWidth = screenSize.width/2 - 225;
        int sHeight = screenSize.height/2 - 150;

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocation(sWidth,sHeight);

        Panel panel_menu = new Panel();
        panel_menu.setBounds(0,0,434,262);
        frame.getContentPane().add(panel_menu);

        startButton = new JButton("Start Game");
        panel_menu.add(startButton);
        startButton.addActionListener(e -> {
            System.out.println("HELLO");
            panel_menu.remove(startButton);
            frame.remove(panel_menu);

            startGame();
        });
    }

    private void startGame() {
        int index = (int) Math.floor(Math.random() * questions.size());

        userWins = false;
        goalString = questions.elementAt(index).getGoalString();
        hint = questions.elementAt(index).getHint();
        user = new User(goalString,12-goalString.length());
        city = new Population(20, goalString, .5);

        initialize();
        thread = new Thread(task);
        thread.start();
    }


    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {

        answerField = new JTextField();
        answerField.setBounds(55, 138, 316, 20);
        frame.getContentPane().add(answerField);
        answerField.setColumns(10);
        answerField.requestFocus();

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


        textPane_User.setText(hint + "\n" + user.getCurrentAnswer());
        answerField.addActionListener(e -> {
            boolean correct = user.guess(answerField.getText());
            textPane_User.setText(hint + "\n" + user.getCurrentAnswer());
            answerField.setText("");
            if (correct) {
                //System.out.println("Correct Answer");
                textPane_User.setText(textPane_User.getText() + "\n" + "Correct Answer!");
                userWins = true;
            }
        });


        textPane_1 = new JTextPane();
        textPane_1.setBounds(111, 168, 30, 30);
        frame.getContentPane().add(textPane_1);
        textPane_1.setEditable(false);

        textPane_2 = new JTextPane();
        textPane_2.setBounds(147, 168, 30, 30);
        frame.getContentPane().add(textPane_2);
        textPane_2.setEditable(false);

        textPane_3 = new JTextPane();
        textPane_3.setBounds(183, 168, 30, 30);
        frame.getContentPane().add(textPane_3);
        textPane_3.setEditable(false);

        textPane_4 = new JTextPane();
        textPane_4.setBounds(219, 168, 30, 30);
        frame.getContentPane().add(textPane_4);
        textPane_4.setEditable(false);

        textPane_5 = new JTextPane();
        textPane_5.setBounds(255, 168, 30, 30);
        frame.getContentPane().add(textPane_5);
        textPane_5.setEditable(false);

        textPane_6 = new JTextPane();
        textPane_6.setBounds(291, 168, 30, 30);
        frame.getContentPane().add(textPane_6);
        textPane_6.setEditable(false);

        textPane_7 = new JTextPane();
        textPane_7.setBounds(111, 205, 30, 30);
        frame.getContentPane().add(textPane_7);
        textPane_7.setEditable(false);

        textPane_8 = new JTextPane();
        textPane_8.setBounds(147, 205, 30, 30);
        frame.getContentPane().add(textPane_8);
        textPane_8.setEditable(false);

        textPane_9 = new JTextPane();
        textPane_9.setBounds(183, 205, 30, 30);
        frame.getContentPane().add(textPane_9);
        textPane_9.setEditable(false);

        textPane_10 = new JTextPane();
        textPane_10.setBounds(219, 205, 30, 30);
        frame.getContentPane().add(textPane_10);
        textPane_10.setEditable(false);

        textPane_11 = new JTextPane();
        textPane_11.setBounds(255, 205, 30, 30);
        frame.getContentPane().add(textPane_11);
        textPane_11.setEditable(false);

        textPane_12 = new JTextPane();
        textPane_12.setBounds(291, 205, 30, 30);
        frame.getContentPane().add(textPane_12);
        textPane_12.setEditable(false);

        resetButton = new JButton("Reset Button");
        resetButton.setBounds(327,168,70,70);
        frame.getContentPane().add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //thread.interrupt();
                System.out.println("Thread Stop");
                thread.interrupt();
                startGame();
            }
        });
        
        fillLetterPanes(user.getLetters());
    }

    private void fillLetterPanes(String letters) {
        textPane_1.setText(String.valueOf(letters.charAt(0)));
        textPane_2.setText(String.valueOf(letters.charAt(1)));
        textPane_3.setText(String.valueOf(letters.charAt(2)));
        textPane_4.setText(String.valueOf(letters.charAt(3)));
        textPane_5.setText(String.valueOf(letters.charAt(4)));
        textPane_6.setText(String.valueOf(letters.charAt(5)));
        textPane_7.setText(String.valueOf(letters.charAt(6)));
        textPane_8.setText(String.valueOf(letters.charAt(7)));
        textPane_9.setText(String.valueOf(letters.charAt(8)));
        textPane_10.setText(String.valueOf(letters.charAt(9)));
        textPane_11.setText(String.valueOf(letters.charAt(10)));
        textPane_12.setText(String.valueOf(letters.charAt(11)));
    }

    public void computerFindAnswer(){
        while(!city.generation() && (city.getGenerationNum() < 200000) && !userWins) {
            textPane_Computer.setText(String.valueOf(city.truncatePercentComplete()) + "% Complete");
            System.out.println(city.truncatePercentComplete() + "% Complete" );
            //System.out.println(city);

            //To delay the thread by 50 mills in order to allow the person to keep up.
            try {
                Thread.sleep(50);    //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            textPane_Computer.setText(city.getGoalString());
        }

        if(userWins){
            textPane_Computer.setText("Computer Loses");
        }
        else {
            textPane_Computer.setText(city.getGoalString() + "\nComputer Wins");
        }
    }

    Runnable task = () -> {
        String threadName = Thread.currentThread().getName();
        System.out.println("Hello " + threadName);
        computerFindAnswer();
        Thread.interrupted();
    };
}
