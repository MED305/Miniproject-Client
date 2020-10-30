package main.java.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class PickUp extends Entity {

    TextureAtlas.AtlasRegion truck = atlas.findRegion("pickup");

    int pickup = 0;
    float x, y;

    public PickUp(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        truck = c_sprite;
        this.position = new Vector2((float) Math.random() * 800, (float) Math.random() * 800);
        this.setSize(20, 20);
    }

    @Override
    public void update(float deltaTime) {
        this.collisionBox = new Rectangle(position.x, position.y, this.collisionBox.width, this.collisionBox.height);
        batch.draw(truck, position.x, position.y); // drawing the pickup

        if (y > Gdx.graphics.getHeight()) {
            this.remove();
        }
    }

    @Override
    public void collision(ArrayList<Entity> others) {
        for (Entity entity : others) {
            if (entity.getCollisionBox() != null & entity instanceof PlayerActor
                    & this.getCollisionBox().overlaps(entity.getCollisionBox())) {
                this.remove();

            }
        }
    }
}
