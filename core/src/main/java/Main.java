package main.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import main.java.entity.*;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
    static public ArrayList<Entity> entities;
    static public ArrayList<Bullet> bulletsToRemove;

    SpriteBatch batch;
    TextureAtlas atlas;
    PlayerActor player;
    PickUp pickup;
    Enemy enemy;

    float deltaTime;

    @Override
    public void create() {
        entities = new ArrayList<>();
        bulletsToRemove = new ArrayList<>();
        batch = new SpriteBatch();
        atlas = new TextureAtlas("texture_atlas.atlas");

        entities.add(player = new PlayerActor(atlas.findRegion("player/DudeGuy"), batch, atlas));
        entities.add(enemy = new Enemy(atlas.findRegion("zombie/zombie"), batch, atlas, player));
        entities.add(pickup = new PickUp(atlas.findRegion("pickup"), batch, atlas));
    }

    @Override
    public void render() {
        deltaTime = Gdx.graphics.getDeltaTime();
        bulletsToRemove.clear();

        Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for (Entity entity : entities) {
            entity.update(deltaTime);
        }

        for (Bullet bullet : bulletsToRemove) {
            bullet.remove();
        }

        player.detectInput(deltaTime);

        System.out.println(bulletsToRemove.size());

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }
}