package com.prog;

import javax.swing.*;
import java.awt.*;

import Control.Constants;
import Control.Render;
import Factories.BirdFactory;
import Factories.ObstacleFactory;
import GameObjects.Bird;
import GameObjects.Obstacle;
import Logic.Game;

import java.awt.event.*;

public class GameScreen extends JFrame implements ActionListener
{
    //private static GameScreen frame;
    private static int WIDTH = 500;
    private static int HEIGHT = 600;
    private static Render render;
    private static Image backgroundImage;
    private static Image ground;
    private static Image flappybird;
    private static Image gameOver;
    private static Bird bird;
    private Rectangle bird_hitmask;
    private ObstacleFactory ofact;
    public  boolean start;
    private BirdFactory bfact;
    private static Timer timer;
    private Game game;
    private static boolean flag = true;

    public GameScreen(String name , Game game)
    {
        super(name);
        setResizable(false);

        //initialise fields
        timer = new Timer(30 , this);
        backgroundImage  = new ImageIcon(".\\sprites\\day2-bgr.jpg").getImage();
        ground = new ImageIcon(".\\sprites\\base.png").getImage();
        this.game = game;
        Constants.Init();
        bfact = new BirdFactory();
        bird = bfact.createBird();
        bird_hitmask = new Rectangle();
        ofact = new ObstacleFactory();

        //add listeners
        KeyListener keylstnr = new KeyPress();
        addKeyListener(keylstnr);
        WindowListener lstnr = new Terminator();
        addWindowListener(lstnr);
        MouseListener mouselstnr = new MousePres();
        addMouseListener(mouselstnr);
        timer.start();
    }
    public void repaint(Graphics g)
    {
            g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);
            g.drawImage(ground, Constants.groundx, Constants.groundy, WIDTH, 100, null);
            if (Constants.WIDTH + Constants.groundx == 0) {
                Constants.groundx = 0;
                g.drawImage(ground, Constants.groundx, Constants.groundy, WIDTH, 100, null);
            }
            g.drawImage(ground, Constants.WIDTH + Constants.groundx, Constants.groundy, WIDTH, 100, null);

            bird.y += Constants.vyn++;//- Constants.Gravity;

            bird.y += Constants.vyp + Constants.Gravity;

            bird.set_the_mask(g);

            for (Obstacle temp : game.obstacles) {
                temp.paintObstacle(g);
                temp.set_the_mask(g);
                if (bird.bird_hitmask.intersects(temp.obstaclen_hitmask) || bird.bird_hitmask.intersects(temp.obstacles_hitmask)) {
                    game.gameOver = true;
                }

                int part = game.count;
                Image score_3 = new ImageIcon(Constants.Numbers.get(part % 10)).getImage();
                g.drawImage(score_3, WIDTH / 2, 10, 20, 30, null);

                part /= 10;
                Image score_2 = new ImageIcon(Constants.Numbers.get(part % 10)).getImage();
                g.drawImage(score_2, WIDTH / 2 - 20, 10, 20, 30, null);

                part /= 10;
                Image score_1 = new ImageIcon(Constants.Numbers.get(part % 10)).getImage();
                g.drawImage(score_1, WIDTH / 2 - 40, 10, 20, 30, null);

                if (game.obstacles.get(0).x < 0) {
                    flag = true; // разрешение на изменение счетчика
                }
            }

          g.drawImage(flappybird, bird.x, bird.y, bird.width, bird.height, null); //draw the bird

        if(game.gameOver == true)
        {
            gameOver = new ImageIcon(".\\sprites\\gameover.png").getImage();
            g.drawImage(gameOver, WIDTH/2 - 50, HEIGHT/2 - 50, 100, 100, null);
            timer.stop();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        game.ticks++;
        Constants.groundx-=5;
        if(game.ticks%2 == 0 )
        {
            flappybird = bird.get_the_dir('f');

        }
        if(game.ticks%3 == 0)
        {
            flappybird = bird.get_the_dir('d');
        }
        if(game.ticks%5 == 0)
        {
            flappybird = bird.get_the_dir('u');
        }
        if(bird.y >= HEIGHT - 140)
        {
            game.gameOver = true;
        }
        if(!start)
        {
            game.obstacles.add(ofact.createObstacle());
            start = true;
        }
        else {

            if (game.obstacles.get(0).x + Obstacle.width < 0) {
                game.obstacles.remove(0);
            }

            if(game.obstacles.get(game.obstacles.size() - 1).x + Obstacle.width == WIDTH /2)
            {
                game.obstacles.add(ofact.createObstacle());
            }
            for (int i = 0; i < game.obstacles.size(); i++) {

                game.obstacles.get(i).x -= 5;
                if(flag == true && bird.x >= game.obstacles.get(game.obstacles.size() - 1).x)
                {
                    game.count++;
                    flag = false;
                }
            }
        }
        render.repaint();
    }
    public  void createAndShowGui(int x)
    {
        render = new Render(this);
        //Create and set up the window.
        this.add(render);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLocation(x , 0);
        //Set up the content pane.
        //Display the window.
        this.pack();
        this.setVisible(true);
    }

    class Terminator extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            if(game.threadNum == 2)
                Log.wasPressedSec = true;
            if(game.threadNum == 1)
                Log.wasPressedFir = true;
             if(game.threads.size() == 2) {
                game.threads.get(game.threadNum - 1).interrupt();
                game.threads.remove(game.threadNum - 1);
            }
            else {
                game.threads.get(0).interrupt();
                game.threads.remove(0);
            }
            dispose();
        }
    }
    class KeyPress extends KeyAdapter
    {
        //@Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            Constants.Gravity = 1;
            Constants.vyp = 9;
            Constants.vyn = -20;
        }
    }

    class MousePres extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) {
            Constants.Gravity = 1;
            Constants.vyp = 9;
            Constants.vyn = -20;
        }
    }

}
