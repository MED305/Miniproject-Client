package main.java.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import main.java.Main;

import java.lang.annotation.Target;

public class Bullet extends Entity {

    private Vector2 movement;
    public static final int SPEED = 400;
    private static TextureAtlas.AtlasRegion texture;
    private final PlayerActor player;

    float x, y;

    public boolean remove = false;

    public Bullet(SpriteBatch c_batch, TextureAtlas c_atlas, PlayerActor c_player) {

        super(c_batch, c_atlas);
        player = c_player;
        this.position = new Vector2(player.position.x, player.position.y);

        if (texture == null) {
            texture = atlas.findRegion("player/Bullet/Bullet1");
        }
     movement = new Vector2(Gdx.input.getX(), Gdx.input.getY()).sub(this.position);
        movement.nor().scl(SPEED);

    }



    public void update(float deltaTime) {
        batch.draw(texture, x, y);
        this.movement.scl(deltaTime);
        this.position.add(movement);

        y += SPEED * deltaTime;
        if (y > Gdx.graphics.getHeight()) {
            Main.bulletsToRemove.add(this);
        }
    }

    public void remove() {
        if (this.remove) {
            Main.entities.remove(this);
        }
    }
}
