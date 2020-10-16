package graphics;

import javax.swing.JFrame;

public class Window extends JFrame {

    public Window() {
        setTitle("test1"); // title of window / game
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // standard close action
        setContentPane(new GamePanel(1280, 720)); // panel size

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
