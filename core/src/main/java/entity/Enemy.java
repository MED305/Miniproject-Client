package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import main.java.Main;

public class Enemy extends Entity {
    TextureAtlas.AtlasRegion sprite;
    PlayerActor target;

    public Enemy(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);

        this.sprite = c_sprite;
        this.target = findTarget();
        this.position = new Vector2((float) Math.random() * 800, (float) Math.random() * 800);
        this.setSize(20, 20);
    }

    @Override
    public void update(float deltaTime) {
        this.collisionBox = new Rectangle(position.x, position.y, this.collisionBox.width, this.collisionBox.height);
        batch.draw(sprite, position.x, position.y);
        this.findTarget();
        this.move(deltaTime);
    }

    private void move(float deltaTime) {
        float speed = 50;

        Vector2 movement = new Vector2(target.position).sub(this.position);
        movement.nor().scl(speed).scl(deltaTime);
        this.position.add(movement);
    }

    private PlayerActor findTarget() {
        for (Entity possibleTarget : Main.entities) {

            if (possibleTarget instanceof PlayerActor & possibleTarget != target) {
                if (target == null) {
                    return (PlayerActor) possibleTarget;
                }

                float dist1 = possibleTarget.position.dst(this.position);
                float dist2 = target.position.dst(this.position);

                if (dist1 < dist2) {
                    return (PlayerActor) possibleTarget;
                }
            }
        }
        return target;
    }

    @Override
    public void collision(ArrayList<Entity> others) {
    }
}
