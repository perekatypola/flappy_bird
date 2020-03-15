package GameObjects;

import Control.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle {

    private static ArrayList<String> Images; // картинки для нижней и верхней преграды
    public static int x;
    public static int y;
    public static final int min_height = 50;
    public static final int max_height = 300;
    public static final int width = 50;
    public static int height;
    public static Random rand;

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
    public static void paintObstacle(Graphics g , Image name , Image names, int xx , int yy,  int width , int height)
    {
        g.drawImage(name , xx , yy , width , height ,  null); //рисуется верхняя труба
        g.drawImage(names , xx  , height + 60 , width , Constants.HEIGHT - height - 60 - 100,  null);
    }
}
