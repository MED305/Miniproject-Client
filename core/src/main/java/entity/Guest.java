package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import main.java.Server.*;

public class Guest extends Entity {

    ConSocket con = new ConSocket();

    public Guest(SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        sprite = c_atlas.createSprite("guest/guest1");
        this.position = new Vector2(100.0f, 100.0f);
    }

    private Vector2 getPosition() {
        return position;
    }

    @Override
    public void update(float deltaTime) {
        sprite.setCenter(this.position.x + sprite.getWidth() / 2, this.position.y + sprite.getHeight() / 2);
        sprite.draw(batch);
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
    }

    @Override
    public void collision(ArrayList<Entity> others) {
        // TODO Auto-generated method stub

    }
}
