package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    protected SpriteBatch batch;
    protected TextureAtlas atlas;
    protected Rectangle collisionBox;
    protected Vector2 position;

    protected float xPosition, yPosition;

    protected double maxSpeed, acceleration, deacceleration;

    public Entity(SpriteBatch c_batch, TextureAtlas c_atlas) {
        batch = c_batch;
        atlas = c_atlas;
        collisionBox = new Rectangle(xPosition, yPosition, 0, 0);
    }

    public abstract void update(float deltaTime);

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    protected void setSize(float xSize, float ySize) {
        collisionBox.width = xSize;
        collisionBox.height = ySize;
    }

    public Rectangle getCollisionBox() {
        return this.collisionBox;
    }
}
