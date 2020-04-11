package Logic;

import Control.Render;
import GameObjects.Obstacle;
import com.prog.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class Game implements Runnable{
    private  ArrayList <Integer> Settings = new ArrayList<>();
    public boolean gameOver;
    public int ticks;
    public int count;
    public int threadNum;
    public ArrayList<Obstacle>  obstacles;
    public static ArrayList<Thread> threads = new ArrayList<>(); // лист потоков
    private int x;
    public Game(int x)
    {
        super();
        obstacles = new ArrayList<>();
        this.x = x;
    }

    @Override
    public void run() {
           if(Thread.currentThread().isInterrupted())
                return;
            GameScreen screen = new GameScreen("Game", this);
            screen.createAndShowGui(this.x);
    }
}
