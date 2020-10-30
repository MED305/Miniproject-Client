package main.java.graphics;

import main.java.entity.PlayerActor;

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
