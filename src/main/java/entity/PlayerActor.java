package entity;

import java.awt.event.KeyEvent;
import input.KeyBind;

public class PlayerActor extends Actor {

    private KeyBind binding;

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == binding.getKeyUp()) {

        }

        if (key == binding.getKeyDown()) {

        }

        if (key == binding.getKeyLeft()) {

        }

        if (key == binding.getKeyRight()) {

        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
