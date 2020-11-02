package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class Guest extends Entity {

    public Guest(SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        sprite = c_atlas.createSprite("guest/guest1");
        this.position = getPosition();
    }

    private Vector2 getPosition() {
        return null;
    }

    @Override
    public void update(float deltaTime) {
        this.position = getPosition();
    }

    @Override
    public void collision(ArrayList<Entity> others) {
        // TODO Auto-generated method stub

    }
}
