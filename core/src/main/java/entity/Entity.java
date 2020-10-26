package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public abstract class Entity {
    protected SpriteBatch batch;
    protected TextureAtlas atlas;

    protected float xPosition, yPosition;

    protected float maxSpeed, acceleration, deacceleration;

    public Entity(SpriteBatch c_batch, TextureAtlas c_atlas) {
        batch = c_batch;
        atlas = c_atlas;
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
}
