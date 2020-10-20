package entity;

import java.awt.event.KeyEvent;
import input.KeyBind;

public class PlayerActor extends Actor {

    private KeyBind binding;

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == binding.getKeyUp()) {
            this.direction.addY(1f);
        }

        if (key == binding.getKeyDown()) {
            this.direction.addY(-1f);
        }

        if (key == binding.getKeyLeft()) {
            this.direction.addX(-1f);
        }

        if (key == binding.getKeyRight()) {
            this.direction.addX(1f);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
