package input;

import java.awt.event.*;

public class PlayerController implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Keycode =" + e.getKeyCode() + ", character =" + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        PlayerController test = new PlayerController();

    }
}
