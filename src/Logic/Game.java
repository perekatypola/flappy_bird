package Logic;

import GameObjects.Obstacle;

import java.util.ArrayList;

public class Game {
    private  ArrayList <Integer> Settings = new ArrayList<>();
    public boolean gameOver;
    public boolean started;
    public static int ticks;
    public static int count;
    public  ArrayList<Obstacle>  obstacles;

    public Game()
    {
        super();
        obstacles = new ArrayList<>();
    }
    public static void AddColumn()
    {

    }
}
