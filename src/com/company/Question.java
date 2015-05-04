package com.company;

/**
 * Created by Daniel on 5/2/2015.
 */
public class Question {
    private String hint;
    private String goalString;

    public Question(String hint, String goalString) {
        this.hint = hint;
        this.goalString = goalString;
    }

    public String getGoalString() {
        return goalString;
    }

    public void setGoalString(String goalString) {
        this.goalString = goalString;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "Question{" +
                "hint='" + hint + '\'' +
                ", goalString='" + goalString + '\'' +
                '}';
    }
}
