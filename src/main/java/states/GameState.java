package main.java.states;

import java.awt.*;

public abstract class GameState {

    private GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }
    public abstract void update();
    public abstract void input();
    public abstract void render(Graphics2D g);
}
