package main.java.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class PlayerActor extends Entity {

    TextureAtlas.AtlasRegion sprite = atlas.findRegion("player/DudeGuy");

    public PlayerActor(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        sprite = c_sprite;
        xPosition = 100;
        yPosition = 100;
    }

    @Override
    public void update() {
        batch.draw(sprite, xPosition, yPosition);
    }

    public void detectInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.setyPosition(this.getyPosition() + 1);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.setxPosition(this.getxPosition() - 1);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.setyPosition(this.getyPosition() - 1);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.setxPosition(this.getxPosition() + 1);
        }
    }
}