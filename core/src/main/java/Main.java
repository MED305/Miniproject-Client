package main.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import main.java.entity.Entity;
import main.java.entity.PlayerActor;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    TextureAtlas atlas;
    public ArrayList<Entity> entities;
    PlayerActor player;

    @Override
    public void create() {
        entities = new ArrayList<>();
        batch = new SpriteBatch();
        atlas = new TextureAtlas("texture_atlas.atlas");
        entities.add(player = new PlayerActor(atlas.findRegion("player/DudeGuy"), batch, atlas));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for (Entity entity : entities) {
            entity.update();
        }

        player.detectInput();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }
}
