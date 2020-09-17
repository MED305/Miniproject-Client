package entity;

public abstract class Actor {

    private final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    protected int currentAnimation;

    protected Animation actorAnimation;
    protected Sprite actorSprite;
    protected Vector2f actorPosition;

    protected boolean movingUp, movingDown, movingLeft, movingRight, isAttacking;
    protected int attackSpeed;

    protected float directionX, directionY;

    protected float maxSpeed, acceleration, deacceleration;

    public Actor(Sprite sprite, Vector2f origin) {
        this.actorSprite = sprite;
        this.actorPosition = origin;
    }
}