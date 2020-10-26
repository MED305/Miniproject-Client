package main.java.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;

public class PickUp extends Entity {

    TextureAtlas.AtlasRegion truck = atlas.findRegion("pickup");

    int pickup = 0;

    public PickUp(TextureAtlas.AtlasRegion c_sprite, SpriteBatch c_batch, TextureAtlas c_atlas) {
        super(c_batch, c_atlas);
        truck = c_sprite;
    }


    @Override
    public void update(float deltaTime) {
        batch.draw(truck, 200, 200); //drawing the pickup

        if (xPosition == 200 && yPosition == 200) { //Checking if player is located on the pickup (not working)
            pickup++; //Counter of pickups achieved

            Random r = new Random(); //For next position of pickup
            int low = 10;
            int high = 100;
            int x = r.nextInt(high - low) + low;
        }
    }
}
