package input;

import java.awt.event.*;

public class PlayerController implements KeyListener, Runnable {

    private boolean running = false;
    private boolean exit = false;

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

    @Override
    public void run() {
        running = true;

        if (this.keyPressed())


    }

    public boolean isRunning() {
        return running;
    }

    public boolean shouldExit() {
        return exit;
    }

    public static void main(String[] args) {

    }
}
