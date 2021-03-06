package main.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import main.java.entity.*;
//import space.earlygrey.shapedrawer.ShapeDrawer;
import main.java.Server.ConSocket;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
    static public ArrayList<Entity> entities;
    ConSocket con;
    static public ArrayList<Entity> garbage;
    static public ArrayList<Enemy> enemies;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private SpriteBatch batch;
    private TextureAtlas atlas;
    private PlayerActor player;
    private PickUpSpawn puspawner;
    private EnemyFactory spawner;
    // private ShapeDrawer shapeDrawer;
    private Guest guest1, guest2, guest3;

    private float deltaTime;

    @Override
    public void create() {
        con = new ConSocket();
        con.connection();
        entities = new ArrayList<>();
        garbage = new ArrayList<>();
        enemies = new ArrayList<>();
        batch = new SpriteBatch();
        map = new TmxMapLoader().load("textures/Maps/MAP.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        atlas = new TextureAtlas("texture_atlas.atlas");
        entities.add(player = new PlayerActor(batch, atlas));
        entities.add(spawner = new EnemyFactory(batch, atlas, 400, 400));
        entities.add(puspawner = new PickUpSpawn(batch, atlas, 400, 400));
        entities.add(guest1 = new Guest(batch, atlas));
        entities.add(guest2 = new Guest(batch, atlas));
        entities.add(guest3 = new Guest(batch, atlas));
        // shapeDrawer = new ShapeDrawer(batch, atlas.findRegion("singleWhitePixel"));
    }

    @Override
    public void render() {

        deltaTime = Gdx.graphics.getDeltaTime();
        garbage.clear();

        Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        batch.begin();

        for (Entity entity : entities) {
            entity.update(deltaTime);
            entity.collision(entities);
            // shapeDrawer.rectangle(entity.getCollisionBox());
            // Uncomment to draw collisionBoxes
        }

        for (Entity entity : garbage) {
            entities.remove(entity);
        }

        player.detectInput(deltaTime);
        con.serverSender(player);
        con.serverReceiver();
        guest1.setPosition(con.g1Pos);
        guest2.setPosition(con.g2Pos);
        guest3.setPosition(con.g3Pos);

        batch.end();
        spawner.newWave();

        puspawner.newPickUp();
    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }

}
