package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import main.java.Main;

public abstract class Entity {
    protected SpriteBatch batch;
    protected TextureAtlas atlas;
    protected Sprite sprite;
    protected Rectangle collisionBox;
    protected Vector2 position;

    public Entity(SpriteBatch c_batch, TextureAtlas c_atlas) {
        batch = c_batch;
        atlas = c_atlas;
        this.collisionBox = new Rectangle();
    }

    public abstract void update(float deltaTime);

    public abstract void collision(ArrayList<Entity> others);

    public void remove() {
        Main.garbage.add(this);
    }

    public float getXPosition() {
        return this.position.x;
    }

    public float getYPosition() {
        return this.position.y;
    }

    protected void setCollisionSize(float xSize, float ySize) {
        collisionBox.width = xSize;
        collisionBox.height = ySize;
    }

    public Rectangle getCollisionBox() {
        return this.collisionBox;
    }
}
