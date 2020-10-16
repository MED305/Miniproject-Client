package graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import states.*;

public class GamePanel extends JPanel implements Runnable {

    public static int width;
    public static int height;

    private Thread thread;
    private boolean running = false;
    private BufferedImage img;
    private Graphics2D g;

    GameStateManager gsm;
    PlayState game;

    public GamePanel(int width, int height) {
        GamePanel.width = width;
        GamePanel.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void init() {
        running = true;

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();

        gsm = new GameStateManager();
        game = new PlayState(gsm);
    }

    public void run() {
        init();

        final double GAME_HERTZ = 60.0;
        final double TIME_BEFORE_UPDATE = 1000000000 / GAME_HERTZ;

        final int MUST_UPDATE_BEFORE_RENDER = 5;

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60; // desired frame rate
        final double TOTAL_TIME_FOR_RENDER = 1000000000 / TARGET_FPS; // total time before render

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;

        while (running) {
            double now = System.nanoTime();
            int updateCount = 0;
            while (((now - lastUpdateTime) > TIME_BEFORE_UPDATE) && (updateCount < MUST_UPDATE_BEFORE_RENDER)) {
                update();
                input();
                lastUpdateTime += TIME_BEFORE_UPDATE;
                updateCount++;
            }

            if (now - lastUpdateTime > TIME_BEFORE_UPDATE) {
                lastUpdateTime = now - TIME_BEFORE_UPDATE;
            }

            input(); // to future inputs
            render(); // TBA
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    System.out.println("New Second" + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < TOTAL_TIME_FOR_RENDER && now - lastUpdateTime < TIME_BEFORE_UPDATE) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("ERROR: yielding thread");
                }
                now = System.nanoTime();
            }
        }
    }

    private int x = 0;

    public void update() {
        game.update();
        x++;
        // System.out.println(x + "test 2");
    }

    public void input() {

    }

    public void render() {
        if (g != null) { // If no picture is rendered / background
            g.setColor(new Color(120, 255, 5));
            g.fillRect(0, 0, width, height);
        }
    }

    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
    }
}
