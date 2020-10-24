package main.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import main.java.entity.Bullet;
import main.java.entity.Entity;
import main.java.entity.PickUp;
import main.java.entity.PlayerActor;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas atlas;
	public ArrayList<Entity> entities;
	PlayerActor player;
	PickUp pickup;
	ArrayList<Bullet> bullets;
	float x;
	float y;


	@Override
	public void create() {
		entities = new ArrayList<>();
		batch = new SpriteBatch();
		atlas = new TextureAtlas("texture_atlas.atlas");
		entities.add(player = new PlayerActor( atlas.findRegion("player/DudeGuy"), batch, atlas));
		entities.add(pickup = new PickUp( atlas.findRegion("pickup"), batch, atlas));
		bullets = new ArrayList<Bullet>();

	}

	@Override
	public void render() {

		//update bullets
		ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
		for (Bullet bullet : bullets) {
			//bullet.update(delta);
			if (bullet.remove){
				bulletsToRemove.add(bullet);
			}
		}
		bullets.removeAll(bulletsToRemove);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		/*for (Bullet bullet : bullets){
			bullet.render(game.batch);
		} */

		for (Entity entity : entities) {
			entity.update();
		}

		detectInput();
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		atlas.dispose();
	}

	private void detectInput() {
		//Shooting code
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			bullets.add(new Bullet(x + 2,y - 2));
		}

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			player.setyPosition(player.getyPosition() + 1);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			player.setxPosition(player.getxPosition() - 1);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.setyPosition(player.getyPosition() - 1);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.setxPosition(player.getxPosition() + 1);
		}
	}
}
