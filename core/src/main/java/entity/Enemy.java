package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity {
    TextureAtlas.AtlasRegion sprite;
    PlayerActor target;

    public Enemy(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas, PlayerActor c_target) {
        super(c_batch, c_atlas);

        this.sprite = c_sprite;
        this.target = c_target;
        this.position = new Vector2((float) Math.random() * 800, (float) Math.random() * 800);
        this.setSize(20, 20);
    }

    @Override
    public void update(float deltaTime) {
        batch.draw(sprite, position.x, position.y);
        this.move(deltaTime);
        this.collisionBox.set(position.x, position.y, this.collisionBox.width, this.collisionBox.height);
    }

    private void move(float deltaTime) {
        float speed = 50;

        Vector2 movement = new Vector2(target.position).sub(this.position);
        movement.nor().scl(speed).scl(deltaTime);
        this.position.add(movement);
    }

    public void kill(float deltaTime) {
        this.sprite = null;
        this.collisionBox = null;
        this.target = null;
        System.out.println("Hit");
    }
}
