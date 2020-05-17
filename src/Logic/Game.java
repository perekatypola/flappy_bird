package Logic;

import Control.GameData;
import Control.Render;
import GameObjects.Bird;
import GameObjects.Obstacle;
import com.prog.GameScreen;

import com.prog.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Runnable{
    //private  ArrayList <Integer> Settings = new ArrayList<>();
    public boolean gameOver;
    public int ticks;
    public int count;
    public int threadNum;
    public ArrayList<Obstacle>  obstacles;
    public static ArrayList<Thread> threads = new ArrayList<>(); // лист потоков
    public int x;
    private boolean resume;
    //private Bird cur_bird ;
    public GameData data;
    public User user;

    public Game(int x, User newUser , boolean resume , GameData data)
    {
        super();
        obstacles = new ArrayList<>();
        this.x = x;
        this.user = newUser;
        this.resume = resume;
        this.data = data;

        if(data!=null) {
            this.gameOver = data.gameOver;
            this.threadNum = data.threadNum;
            this.ticks = data.ticks;
         //   this.obstacles = data.obstacles;
            this.count = data.count;
        }
      //  this.cur_bird = bird;
    }

    public boolean getResume()
    {
        return resume;
    }

    public void setResume()
    {
        this.resume = true;
    }



    @Override
    public void run()
    {
        if(Thread.currentThread().isInterrupted())
            return;
        GameScreen screen = null;
        try {
            screen = new GameScreen("Game", this , resume);
        } catch (IOException e) {
            e.printStackTrace();
        }
        screen.createAndShowGui(this.x);
    }
}