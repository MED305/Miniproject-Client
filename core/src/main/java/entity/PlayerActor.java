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

    public float PAFloatX;
    public float PAFloatY;


    PickUpSpawn puspawner;

    int hp = 100;
    Score score;

    public PlayerActor(SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        sprite = c_atlas.createSprite("player/DudeGuy");
        score = new Score();
        this.position = new Vector2(100.0f, 100.0f);
        this.setCollisionSize(sprite.getWidth(), sprite.getHeight());
        vecortofloat(position);
    }

    @Override
    public void update(float deltaTime) {
        this.collisionBox.set(this.position.x, this.position.y, this.collisionBox.width, this.collisionBox.height);
        sprite.setCenter(this.position.x + sprite.getWidth() / 2, this.position.y + sprite.getHeight() / 2);
        sprite.draw(batch);
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

                hp += -1;
                System.out.println("Dit liv er: " + hp);
                if (hp < 0) {
                    System.out.println("You loose");
                    System.exit(0);
                }
            }
        }
        for (Entity entity : others) {
            if (entity.getCollisionBox() != null & entity instanceof PickUp
                    & this.getCollisionBox().overlaps(entity.getCollisionBox())) {
                System.out.println("You gained 50 HP!");
                if (hp < 50) {
                    hp += 50;
                } else {
                    hp = 100;
                }
                System.out.println("Dit HP er: " + hp);

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
            if (!sprite.isFlipX()) {
                sprite.flip(true, false);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            movement.add(new Vector2(0.0f, -1.0f));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            movement.add(new Vector2(1.0f, 0.0f));
            if (sprite.isFlipX()) {
                sprite.flip(true, false);
            }
        }

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            shoot(deltaTime);
        }

        move(movement, speed, deltaTime);
    }


    public void vecortofloat (Vector2 position){
        PAFloatX = this.position.x;
        PAFloatY = this.position.y;
    }


    /*public void floatToVector (float netfloatx, float netfloaty){
        netpos = new Vector2(netfloatx, netfloaty);
    }*/

}