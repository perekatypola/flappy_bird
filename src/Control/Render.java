package Control;
import com.prog.GameScreen;

import java.awt.*;
import javax.swing.*;
public class Render extends JPanel {
    public Render() {
        super();
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        GameScreen.repaint(g);
    }
}
