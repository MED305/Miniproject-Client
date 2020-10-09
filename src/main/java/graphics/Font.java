package graphics;
//Kilde: The Zero Doctor

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Font { // This class will load sprites for the game

    public  BufferedImage FONTSHEET = null; // Create our components
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private int wLetter; // Value for total number of sprites in sprite sheet (if timed together) wSprite = columns, hSprite = rows
    private int hLetter;

    public Font(String file) {
        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading " + file + "...");
        FONTSHEET = loadFont(file);

        wLetter = FONTSHEET.getWidth() / w;
        hLetter = FONTSHEET.getHeight() / h;
        loadFontArray();
    }

    public Font(String file, int w, int h) {
        this.w = w;
        this.w = w;

        System.out.println("Loading: " + file + "...");
        FONTSHEET = loadFont(file);

        wLetter = FONTSHEET.getWidth() / w;
        hLetter = FONTSHEET.getHeight() / h;
        loadFontArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) { // Might not get used
        w = i;
        wLetter = FONTSHEET.getWidth() / w;
    }

    public void setHeight(int i) {
        h = i;
        hLetter = FONTSHEET.getHeight() / h;
    }

    public int getWidth() { // Create our getters
        return w;
    }
    public int getHeight() {
        return h;
    }

    private BufferedImage loadFont(String file) { // Here we create the loadFont method
        BufferedImage sprite = null;
        try { // Create try catch so we get an error message if something doesnt load properly
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        } catch (Exception e) {
            System.out.println("Error: Could not load file: " + file);
        }

        return sprite;
    }

    public void loadFontArray() {
        spriteArray = new BufferedImage[wLetter][hLetter];

        for (int x = 0; x < wLetter; x++) { // Create a nested for loop to load the sprite array
            for (int y = 0; y < hLetter; y++) {
                spriteArray[x][y] = getLetter(x, y);
            }
        }
    }

    public BufferedImage getFontSheet() {
        return FONTSHEET;
    }

    public BufferedImage getLetter(int x, int y) {
        return FONTSHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage getFont(char letter){
    int value =  letter - 65;  // this combats ascii table bc of the font selected

    int x = value % wLetter;
    int y = value / wLetter;

    return FONTSHEET.getSubimage(x,y,w,h);
    }
}
