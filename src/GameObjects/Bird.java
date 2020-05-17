package GameObjects;

import javafx.scene.shape.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Bird implements Serializable {

    public int x;
    public int y;
    public final int width  = 40;
    public final int height = 40;
    private static transient ArrayList<String> Images; // для анимации
    public Rectangle bird_hitmask;
    private int key ;

    public Bird(int x , int y ,ArrayList<String> Img , int key)
    {
        super();
        this.x = x;
        this.y = y;
        Images = Img;
        this.key = key;
    }
    public int getKeyForImage()
    {
        return key;
    }
    public Image get_the_dir(char c)
    {
        Image bird = null;
        switch(c)
        {
            case 'u' :
                bird= new ImageIcon(Images.get(2)).getImage();
                break;
            case 'd':
                bird= new ImageIcon(Images.get(0)).getImage();
                break;
            case 'f':
                bird= new ImageIcon(Images.get(1)).getImage();
                break;

        }
        return bird;
    }

    public void set_the_mask(Graphics g)
    {
        Color a = new Color(0 , 0 , 0 , .0f);
        g.setColor(a);
        bird_hitmask = new Rectangle(x - 5, y, width - 10, height - 10 );
        g.fillRect(x - 5 , y  , width - 10 , width - 10);
    }




}
