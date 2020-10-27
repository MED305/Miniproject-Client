package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity {
    TextureAtlas.AtlasRegion sprite;
    PlayerActor target;

    public Enemy(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas, PlayerActor c_target) {
        super(c_batch, c_atlas);
        sprite = c_sprite;
        target = c_target;
        this.position = new Vector2((float) Math.random() * 800, (float) Math.random() * 800);
    }

    @Override
    public void update(float deltaTime) {
        batch.draw(sprite, xPosition, yPosition);
        this.move(deltaTime);
    }

    private void move(float deltaTime) { // TODO: Change to use Vector2 instead
        float speed = 50;

        if (this.xPosition >= target.xPosition) {
            this.xPosition -= speed * deltaTime;
        } else {
            this.xPosition += speed * deltaTime;
        }

        if (this.yPosition >= target.yPosition) {
            this.yPosition -= speed * deltaTime;
        } else {
            this.yPosition += speed * deltaTime;
        }
    }
}
