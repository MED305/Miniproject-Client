package main.java.states;

import main.java.input.KeyHandler;
import main.java.input.MouseHandler;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;

    public GameStateManager(){
        states = new ArrayList<GameState>();

        states.add(new PlayState(this));
    }

    public void update() {
        for (int i = 0; i < states.size(); i++) {
            states.get(i).update();
        }
    }
    public void input(MouseHandler mouse, KeyHandler key){
    for (int i = 0; i < states.size(); i++) {
        states.get(i).input(mouse, key);
    }
    }
}
