package Control;
import com.prog.GameScreen;

import java.awt.*;
import javax.swing.*;
public class Render extends JPanel {
    private GameScreen screen;
    public Render(GameScreen screen) {
        super();
        this.screen = screen;
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        screen.repaint(g);
    }
}

