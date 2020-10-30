package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import main.java.Main;
import main.java.graphics.Score;

public class PlayerActor extends Entity {

    TextureAtlas.AtlasRegion sprite;
    Score score;

    public PlayerActor(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        sprite = c_sprite;
        score = new Score();
        this.position = new Vector2(100.0f, 100.0f);
        this.setSize(20, 20);
    }

    @Override
    public void update(float deltaTime) {
        batch.draw(sprite, position.x, position.y);
        this.collisionBox.set(this.position.x, this.position.y, this.collisionBox.width, this.collisionBox.height);
    }

    private void shoot(float deltaTime) {
        Main.entities.add(new Bullet(batch, atlas, this, deltaTime));
    }

    private void move(Vector2 movement, float speed, float deltaTime) {
        movement.nor().scl(speed).scl(deltaTime);
        this.position.add(movement);
    }

    @Override
    public void collision(ArrayList<Entity> others) {
        for (Entity entity : others) {
            if (entity.getCollisionBox() != null & entity instanceof Enemy
                    & this.getCollisionBox().overlaps(entity.getCollisionBox())) {
                System.out.println("You loose");
                System.exit(0);
            }
        }
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

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            shoot(deltaTime);
        }

        move(movement, speed, deltaTime);
    }
}