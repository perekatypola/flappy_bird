package Control;

import GameObjects.Obstacle;
import Logic.Game;
import com.prog.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameData implements Serializable {
    public GameData()
    {
        ob_s = new ArrayList<String >();
        ob_n = new ArrayList<String >();
        ob_coord = new ArrayList<Integer>();
        ob_height = new ArrayList<Integer>();
    }
    public boolean gameOver;
    public int ticks;
    public int count;
    public int threadNum;
    public User user;
   // public ArrayList<Obstacle>  obstacles;
    public int x;
    public boolean resume;
   // public int bird_x;
    public int bird_y;
    public int bird_key;
    public ArrayList<String > ob_s;
    public ArrayList<String > ob_n;
    public ArrayList<Integer> ob_coord;
    public ArrayList<Integer> ob_height;
    public int ground_x;
    public int ground_y;
}
