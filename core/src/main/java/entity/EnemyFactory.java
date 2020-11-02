package main.java.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import main.java.Main;

public class EnemyFactory extends Entity {

    private float spawnTimer = 0;
    private int enemiesToSpawn = 0;

    public EnemyFactory(SpriteBatch c_batch, TextureAtlas c_atlas, float c_x, float c_y) {
        super(c_batch, c_atlas);
        this.position = new Vector2(c_x, c_y);
    }

    public void newWave() {
        for (int i = 0; i < enemiesToSpawn; i++) {
            Main.entities.add(new Enemy(batch, atlas));
        }
    }

    @Override
    public void update(float deltaTime) {
        enemiesToSpawn = 0;

        if (Main.enemies.size() == 0) {
            spawnTimer += deltaTime;
        }

        if (spawnTimer > 5) {
            enemiesToSpawn += 0;
            spawnTimer = 0;
        }
    }

    @Override
    public void collision(ArrayList<Entity> others) {

    }
}
