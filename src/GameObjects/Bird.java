package GameObjects;

import javafx.scene.shape.*;

import java.util.ArrayList;

public class Bird {

    public int x;
    public int y;
    public final int width  = 40;
    public final int height = 40;
    private static ArrayList<String> Images; // для анимации

    public Bird(int x , int y)
    {
       super();
       this.x = x;
       this.y = y;
    }


}
