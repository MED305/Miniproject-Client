package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;

public class EnemySpawner extends Entity {
    private float spawnRadius;

    public EnemySpawner(SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void collision(ArrayList<Entity> others) {

    }
}
