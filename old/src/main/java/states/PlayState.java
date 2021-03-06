package states;

import graphics.Sprite;
import input.KeyHandler;
import input.MouseHandler;
import graphics.Font;
import math.Vector2f;

import java.awt.*;

import entity.PlayerActor;

public class PlayState extends GameState {
    private Font font;
    PlayerActor player;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("data/Font/ZeldaFont.png", 16, 16);
    }

    public void update() {

    }

    public void input(MouseHandler mouse, KeyHandler key) {

    }

    public void render(Graphics2D g) {
        Sprite.drawArray(g, font, "HELLO WORLD", new Vector2f(100, 100), 32, 32, 16, 16);
    }
}
