package main.java.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import main.java.Main;

public class PlayerActor extends Entity {

    TextureAtlas.AtlasRegion sprite;

    public PlayerActor(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        sprite = c_sprite;
        this.position = new Vector2(100.0f, 100.0f);
        this.setSize(20, 20);
    }

    @Override
    public void update(float deltaTime) {
        batch.draw(sprite, position.x, position.y);
        this.collisionBox.set(this.xPosition, this.yPosition, this.collisionBox.width, this.collisionBox.height);
        System.out.println(this.position.toString());
    }

    private void shoot() {
        Main.entities.add(new Bullet(batch, atlas, this));
    }

    private void move(Vector2 movement, float speed, float deltaTime) {
        movement.nor().scl(speed).scl(deltaTime);
        this.position.add(movement);
    }

    public void detectInput(float deltaTime) {
        float speed = 100;
        Vector2 movement = new Vector2();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            movement.add(new Vector2(0.0f, 1.0f));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            movement.add(new Vector2(-1.0f, 0.0f));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            movement.add(new Vector2(0.0f, -1.0f));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            movement.add(new Vector2(1.0f, 0.0f));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            shoot();
        }

        move(movement, speed, deltaTime);
    }
}