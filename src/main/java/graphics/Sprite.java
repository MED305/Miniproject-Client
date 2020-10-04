package graphics;
//Kilde: The Zero Doctor

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sprite { // This class will load sprites for the game

    public final BufferedImage SPRITESHEET; // Create our components
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private int wSprite; // Value for total number of sprites in sprite sheet (if timed together) wSprite
                         // = columns, hSprite = rows
    private int hSprite;

    public Sprite(String file) {
        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public Sprite(String file, int w, int h) {
        this.w = w;
        this.w = w;

        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) { // Might not get used
        w = i;
        wSprite = SPRITESHEET.getWidth() / w;
    }

    public void setHeight(int i) {
        h = i;
        hSprite = SPRITESHEET.getHeight() / h;
    }

    public int getWidth() { // Create our getters
        return w;
    }

    public int getHeight() {
        return h;
    }

    private BufferedImage loadSprite(String file) { // Here we create the loadsprite method
        BufferedImage sprite = null;
        try { // Create try catch so we get an error message if something doesnt load properly
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        } catch (Exception e) {
            System.out.println("Error: Could not load file: " + file);
        }

        return sprite;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[wSprite][hSprite];

        for (int x = 0; x < wSprite; x++) { // Create a nested for loop to load the sprite array
            for (int y = 0; y < hSprite; y++) {
                spriteArray[x][y] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSPRITESHEET() {
        return SPRITESHEET;
    }

    public BufferedImage getSprite(int x, int y) {
        return SPRITESHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage[] getSpriteArray(int i) { // returns buffered image array ( mainly for animations )
        return spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(int i) {
        return spriteArray;
    }

    // This will be used for lives ( heart images )
    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset){
    float x = pos.x;    

    for (int i = 0; i < img.size(); i++) {
     

     null);
        }
        x += xOffset;
        y += yOffset;
    }

    // This is used for fonts and stuff like that
    public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xOffset,
            int yOffset) {
        float x = pos.x;
        float y = pos.y;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != 32)
                g.draw(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
        }
        x += xOffset;
        y += yOffset;
    }
}
