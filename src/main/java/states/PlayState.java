package main.java.states;

import main.java.graphics.Sprite;
import main.java.input.Vector2f;

import java.awt.*;

public class PlayState extends GameState {
    private Font font;

    public PlayState(GameStateManager gsm){
        super(gsm);
        font = new Font("data/Font/ZeldaFont.png", 16,16);
    }

    public void update() {

    }

    public void input(){

    }

    public void render(Graphics2D g){
        Sprite.drawArray(g, font, "HELLO WORLD", new Vector2f( 100, 100, 32, 32, 64, 0));
    }
}
