package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class PickUp extends Entity {

    public PickUp(SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        this.position = new Vector2((float) Math.random() * 800, (float) Math.random() * 800);
        this.setCollisionSize(20, 20);
        sprite = c_atlas.createSprite("pickup");
    }

    @Override
    public void update(float deltaTime) {
        this.collisionBox.set(this.position.x, this.position.y, this.collisionBox.width, this.collisionBox.height);
        sprite.setCenter(this.position.x + sprite.getWidth() / 2, this.position.y + sprite.getHeight() / 2);
        sprite.draw(batch);
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
