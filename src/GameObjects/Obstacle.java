package GameObjects;

import Control.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle {

    private static ArrayList<String> Images; // картинки для нижней и верхней преграды
    public int x;
    public int y;
    public static final int min_height = 50;
    public static final int max_height = 300;
    public static final int width = 50;
    public  int height;
    public static Random rand;
    public Rectangle obstacles_hitmask;
    public Rectangle obstaclen_hitmask;

    String south;
    String north;

    public Image  obstacles ;
    public Image  obstaclen ;

    public Obstacle(String s , String n , int height_ , int a)
    {
        super();
        x = a;
        y = 0;
        south = s;
        north  = n;
        obstacles = new ImageIcon(south).getImage(); // нижняя труба
        obstaclen = new ImageIcon(north).getImage();// верхняя труба
        rand  = new Random();
        height = height_;
    }
//    Image name , Image names, int xx , int yy,  int width , int height
   public void paintObstacle(Graphics g )
    {
        g.drawImage(obstaclen , x , y , width , height ,  null); //рисуется верхняя труба
        g.drawImage(obstacles, x  , height + 100 , width , Constants.HEIGHT - height - 100 - 100,  null);
    }

    public void set_the_mask(Graphics g)
    {
        Color a= new Color(0 , 0 , 0 , .0f);
        g.setColor(a);
        obstaclen_hitmask = new Rectangle(x , y , width, height);
        g.fillRect(x , y , width  , height - 10);
        obstacles_hitmask = new Rectangle(x , height + 100 + 5, width , Constants.HEIGHT - height - 100 - 15 );
        g.fillRect(x , height + 100 +15  , width - 10 , Constants.HEIGHT - height - 100 - 15);
    }
}
