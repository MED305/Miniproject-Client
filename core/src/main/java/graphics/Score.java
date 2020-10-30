package main.java.graphics;

public class Score {
    private int scoreCount = 0;

    
    public void addScore() {
        scoreCount++;
        System.out.println(scoreCount);
    }
    public Score(){
        scoreCount = 0;
    }
    public void displayScore(){

    }
}
