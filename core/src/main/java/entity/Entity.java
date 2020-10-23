package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public abstract class Entity {
    protected SpriteBatch batch;
    protected TextureAtlas atlas;

    protected int xPosition, yPosition;

    protected float maxSpeed, acceleration, deacceleration;

    public Entity(SpriteBatch c_batch, TextureAtlas c_atlas) {
        batch = c_batch;
        atlas = c_atlas;
    }

    public abstract void update();

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
