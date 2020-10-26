package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Enemy extends Entity {
    TextureAtlas.AtlasRegion sprite;
    PlayerActor target;


    public Enemy(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas, PlayerActor c_target) {
        super(c_batch, c_atlas);
        sprite = c_sprite;
        xPosition = (float) Math.random() * 800;
        yPosition = (float) Math.random() * 800;
        target = c_target;
    }

    @Override
    public void update(float deltaTime) {
        batch.draw(sprite, xPosition, yPosition);
        this.move(deltaTime);
    }

    private void move(float deltaTime) {
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
