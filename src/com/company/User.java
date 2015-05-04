package com.company;

/**
 * Created by Daniel on 5/1/2015.
 */
public class User {
    private String goalString;
    private String currentAnswer;
    private String letters;
    private int tries;
    private int numOfRandomLetters;

    public User(String goalString) {
        this.goalString = goalString;
        numOfRandomLetters = 3;
        tries = 0;
        initializeLetters();
        initializeCurrentAnswer();
    }

    public User(String goalString, int numOfRandomLetters) {
        this.goalString = goalString;
        this.numOfRandomLetters = numOfRandomLetters;
        tries = 0;
        initializeLetters();
        initializeCurrentAnswer();
    }

    public String getGoalString() {
        return goalString;
    }

    public void setGoalString(String goalString) {
        this.goalString = goalString;
    }

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getNumOfRandomLetters() {
        return numOfRandomLetters;
    }

    public void setNumOfRandomLetters(int numOfRandomLetters) {
        this.numOfRandomLetters = numOfRandomLetters;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    private void initializeLetters() {
        String stringLetters = goalString;
        //add random letters to letters
        for(int i=0;i<numOfRandomLetters;i++){
            stringLetters += Character.toString((char) Math.floor(Math.random()*26+65));
        }

        //convert letters to uppercase
        stringLetters = stringLetters.toUpperCase();
        //System.out.println(stringLetters);

        //Now randomize the characters
        StringBuilder sb = new StringBuilder(stringLetters);
        letters = "";
        int index;
        for(int i=0;i<stringLetters.length();i++){
            index = (int)Math.floor(Math.random()*sb.length());
            letters += sb.charAt(index);
            sb.deleteCharAt(index);
        }
        //System.out.println(letters);
    }

    private void initializeCurrentAnswer(){
        this.currentAnswer = "";
        for(int i=0;i<goalString.length();i++){
            if(this.goalString.charAt(i)==' ')
                this.currentAnswer += " ";
            else
                this.currentAnswer += "_";
        }
    }

    public boolean guess(String answer){
        int size;
        boolean correctAnswer;
        String newCurrentAnswer = this.currentAnswer;

        if(answer.length()<=goalString.length()){
            size = answer.length();
        }else{
            size = goalString.length();
        }

        //this.currentAnswer = "";
        for(int i=0;i<size;i++){
            if((Character.toUpperCase(answer.charAt(i)) == Character.toUpperCase(this.goalString.charAt(i))) ||
                    (newCurrentAnswer.charAt(i)!='_')){
                //System.out.println("Correct letter: " + answer.charAt(i));
                newCurrentAnswer = newCurrentAnswer.substring(0, i) + this.goalString.charAt(i) + newCurrentAnswer.substring(i + 1);
            }
            else {
                newCurrentAnswer = newCurrentAnswer.substring(0,i) + "_" + newCurrentAnswer.substring(i+1);
            }
        }

        if(newCurrentAnswer.equals(this.goalString))
            correctAnswer = true;
        else
            correctAnswer = false;

        this.tries++;
        this.currentAnswer = newCurrentAnswer;
        return correctAnswer;
    }
}
