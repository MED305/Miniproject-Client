package input;

import java.awt.event.*;

import entity.PlayerActor;

public class PlayerController implements KeyListener {

    PlayerActor actor;

    public PlayerController(PlayerActor c_actor) {
        this.actor = c_actor;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        actor.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        actor.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        actor.keyReleased(e);
    }
}
