package entity;

import graphics.Sprite;
import math.Vector2f;

public abstract class Actor {
    private final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    protected int currentAnimation;

    protected boolean movingUp, movingDown, movingLeft, movingRight, isAttacking;
    protected int attackSpeed;

    protected Vector2f position, direction;
    protected Sprite sprite;

    protected float maxSpeed, acceleration, deacceleration;

    public Actor() {
        position = new Vector2f(30, 30);
    }
}