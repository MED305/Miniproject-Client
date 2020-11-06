package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import main.java.Main;

public class PickUpSpawn extends Entity {

    private float spawnTimer = 20;
    private int pickUpsToSpawn = 1;

    public PickUpSpawn(SpriteBatch c_batch, TextureAtlas c_atlas, float c_x, float c_y) {
        super(c_batch, c_atlas);
        this.position = new Vector2(c_x, c_y);
    }

    public void newPickUp() {
        for (int i = 0; i < pickUpsToSpawn; i++) {
            Main.entities.add(new PickUp(batch, atlas));
        }
    }

    @Override
    public void update(float deltaTime) {
        pickUpsToSpawn = 0;

        if (Main.enemies.size() == 0) {
            spawnTimer += deltaTime;
        }

        if (spawnTimer > 5) {
            pickUpsToSpawn += 1;
            spawnTimer = 0;
        }
    }

    @Override
    public void collision(ArrayList<Entity> others) {
    }
}
