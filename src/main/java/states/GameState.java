package main.java.states;

import main.java.input.KeyHandler;
import main.java.input.MouseHandler;

import java.awt.*;

public abstract class GameState {

    private GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }
    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g);
}
