package main.java.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import main.java.Main;

public class Bullet extends Entity {

    public static final int SPEED = 400;
    private static TextureAtlas.AtlasRegion texture;
    private PlayerActor player;

    float x, y;

    public boolean remove = false;

    public Bullet(SpriteBatch c_batch, TextureAtlas c_atlas, PlayerActor c_player) {
        super(c_batch, c_atlas);
        player = c_player;
        this.x = player.xPosition;
        this.y = player.yPosition;

        if (texture == null) {
            texture = atlas.findRegion("player/Bullet/Bullet1");
        }
    }

    public void update(float deltaTime) {
        batch.draw(texture, x, y);

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
