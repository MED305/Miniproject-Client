package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import main.java.graphics.Score;

public class Bullet extends Entity {

    private Vector2 movement;
    public static final int SPEED = 500;
    private static TextureAtlas.AtlasRegion texture;
    private final PlayerActor player;

    float x, y;

    public boolean remove = false;

    public Bullet(SpriteBatch c_batch, TextureAtlas c_atlas, PlayerActor c_player, float deltaTime) {
        super(c_batch, c_atlas);
        player = c_player;
        this.position = new Vector2(player.position.x, player.position.y);
        this.setSize(5, 5);

        if (texture == null) {
            texture = atlas.findRegion("player/Bullet/Bullet1");
        }

        movement = new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()).sub(this.position);
        movement.nor().scl(SPEED).scl(deltaTime);
    }

    public void update(float deltaTime) {
        batch.draw(texture, position.x, position.y);
        this.position.add(movement);
        this.collisionBox.set(position.x, position.y, this.collisionBox.width, this.collisionBox.height);

        if (y > Gdx.graphics.getHeight()) {
            this.remove();
        }
    }

    @Override
    public void collision(ArrayList<Entity> others) {
        for (Entity entity : others) {
            if (entity.getCollisionBox() != null & entity instanceof Enemy
                    & this.getCollisionBox().overlaps(entity.getCollisionBox())) {
                this.remove();
                entity.remove();
                player.score.addScore();
            }
        }
    }
}
