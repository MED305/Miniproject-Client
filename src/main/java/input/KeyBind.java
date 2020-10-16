package input;

import java.awt.event.KeyEvent;

public class KeyBind {

    private int keyUp, keyRight, keyLeft, keyDown, keyShoot;

    KeyBind() {
        setKeyUp(KeyEvent.VK_W);
        setKeyRight(KeyEvent.VK_D);
        setKeyLeft(KeyEvent.VK_A);
        setKeyDown(KeyEvent.VK_S);
        setKeyShoot(KeyEvent.VK_SPACE);
    }

    public int getKeyShoot() {
        return keyShoot;
    }

    public void setKeyShoot(int keyShoot) {
        this.keyShoot = keyShoot;
    }

    public int getKeyDown() {
        return keyDown;
    }

    public void setKeyDown(int keyDown) {
        this.keyDown = keyDown;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

    public void setKeyLeft(int keyLeft) {
        this.keyLeft = keyLeft;
    }

    public int getKeyRight() {
        return keyRight;
    }

    public void setKeyRight(int keyRight) {
        this.keyRight = keyRight;
    }

    public int getKeyUp() {
        return keyUp;
    }

    public void setKeyUp(int keyUp) {
        this.keyUp = keyUp;
    }
}
