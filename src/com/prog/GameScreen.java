package com.prog;

import javax.swing.*;
import java.awt.*;

import Control.Constants;
import Control.Render;
import Factories.ObstacleFactory;
import GameObjects.Bird;
import GameObjects.Obstacle;
import Logic.Game;

import java.awt.event.*;

public class GameScreen extends JFrame implements ActionListener
{
    private static GameScreen frame;
    private static int WIDTH = 500;
    private static int HEIGHT = 600;
    private static Render render;
    static Image backgroundImage;
    static Image ground;
    static Image flappybird;
    private static Bird bird;
    private static ObstacleFactory ofact;
    public static boolean start;
    public  Obstacle obstacle;

    public GameScreen(String name)
    {
        super(name);
        Timer timer = new Timer(20 , this);
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10);
        setResizable(false);

        backgroundImage  = new ImageIcon(".\\sprites\\day2-bgr.jpg").getImage();
        ground = new ImageIcon(".\\sprites\\base.png").getImage();
        flappybird = new ImageIcon(".\\sprites\\blue_1.png").getImage();


        Constants.Init();
        ofact = new ObstacleFactory();
        obstacle = ofact.createObstacle();
        timer.start();
    }
    public static void repaint(Graphics g)
    {
        g.drawImage(backgroundImage, 0, 0, WIDTH , HEIGHT, null);
        g.drawImage(ground , Constants.groundx , Constants.groundy, WIDTH , 100,null);
        if(Constants.WIDTH + Constants.groundx == 0)
        {
            Constants.groundx = 0;
            g.drawImage(ground , Constants.groundx , Constants.groundy, WIDTH , 100,null);
        }
        g.drawImage(ground , Constants.WIDTH + Constants.groundx , Constants.groundy , WIDTH , 100,null);
        g.drawImage(flappybird , bird.x , bird.y , bird.width , bird.height,null); //рисуется птица
        for(int i = 0; i < Game.obstacles.size();i++)
        {
            Obstacle.paintObstacle(g , Game.obstacles.get(i).obstaclen , Game.obstacles.get(i).obstacles , Game.obstacles.get(i).x , Game.obstacles.get(i).y , Game.obstacles.get(i).width , Game.obstacles.get(i).height);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Game.ticks++;
        Constants.groundx--;
        if(!start)
        {
            Game.obstacles.add(ofact.createObstacle());
            start = true;
        }

        int check =Constants.WIDTH - obstacle.width - Constants.gap;

        int size = Game.obstacles.size();

//            if (Game.obstacles.get(Game.obstacles.size() - 1).x  == check)
//            {
//
//                Game.obstacles.add(size,ofact.createObstacle());
//            }
        if(Game.obstacles.get(0).x + Obstacle.width < 0)
        {
            Game.obstacles.remove(0);
            Game.obstacles.add(ofact.createObstacle());
        }
        for(int i = 0 ; i <Game.obstacles.size();i++)
        {
            Game.obstacles.get(i).x--;
        }
        int x_ = Game.obstacles.get(Game.obstacles.size() - 1).x;

        render.repaint();
    }
    public static void createAndShowGui()
    {
        render = new Render();
        //Create and set up the window.
        frame = new GameScreen("Game");
        frame.add(render);
        //render.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //Set up the content pane.
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
