package entity;

import java.awt.event.KeyEvent;
import input.KeyBind;
import math.Vector2f;

public class PlayerActor extends Actor {

    private KeyBind binding;

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == binding.getKeyUp()) {
            this.direction = new Vector2f(0f, 1f);
            this.position.add(this.direction);
        }

        if (key == binding.getKeyDown()) {
            this.direction = new Vector2f(0f, -1f);
            this.position.add(this.direction);
        }

        if (key == binding.getKeyLeft()) {
            this.direction = new Vector2f(-1f, 0f);
            this.position.add(this.direction);
        }

        if (key == binding.getKeyRight()) {
            this.direction = new Vector2f(1f, 0f);
            this.position.add(this.direction);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
