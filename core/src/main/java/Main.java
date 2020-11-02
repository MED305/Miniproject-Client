package main.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import main.java.entity.*;
import main.java.Server.ConSocket;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
    static public ArrayList<Entity> entities;
    ConSocket con = new ConSocket ();
    static public ArrayList<Entity> garbage;
    static public ArrayList<Enemy> enemies;


    ShapeDrawer collisionDrawer;
    SpriteBatch batch;
    TextureAtlas atlas;
    PlayerActor player;
    PickUp pickup;
    Enemy enemy;
    EnemySpawn spawner;

    float deltaTime;

    @Override
    public void create() {

        con.connection();
        entities = new ArrayList<>();
        garbage = new ArrayList<>();
        enemies = new ArrayList<>();
        batch = new SpriteBatch();
        atlas = new TextureAtlas("texture_atlas.atlas");
        collisionDrawer = new ShapeDrawer(batch, atlas.findRegion("singleWhitePixel"));
        entities.add(player = new PlayerActor(atlas.findRegion("player/DudeGuy"), batch, atlas));
        entities.add(enemy = new Enemy(atlas.findRegion("zombie/zombie"), batch, atlas));
        entities.add(pickup = new PickUp(atlas.findRegion("pickup"), batch, atlas));
        entities.add(spawner = new EnemySpawn(batch, atlas, 400, 400));

    }

    @Override
    public void render() {

        deltaTime = Gdx.graphics.getDeltaTime();
        garbage.clear();

        Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for (Entity entity : entities) {
            entity.update(deltaTime);
            collisionDrawer.rectangle(entity.getCollisionBox());
            entity.collision(entities);
        }

        for (Entity entity : garbage) {
            entities.remove(entity);
        }

        player.detectInput(deltaTime);
        //con.update();
        batch.end();
        spawner.newWave();
        con.serverUpdate();
    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }
}



