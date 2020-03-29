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

public class GameScreen extends JFrame implements ActionListener , MouseListener
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
    public static boolean start;
    private BirdFactory bfact;
    private static Timer timer;
    private static Game game;
    private static boolean flag = true;
    public GameScreen(String name)
    {
        super(name);
        timer = new Timer(30 , this);

        setResizable(false);

        backgroundImage  = new ImageIcon(".\\sprites\\day2-bgr.jpg").getImage();
        ground = new ImageIcon(".\\sprites\\base.png").getImage();

        game = new Game();



        Constants.Init();
        bfact = new BirdFactory();
        bird = bfact.createBird();
        bird_hitmask = new Rectangle();
       // flappybird = new ImageIcon().getImage();
        ofact = new ObstacleFactory();
        addMouseListener(this);
        timer.start();
    }
    public static void repaint(Graphics g)
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

          g.drawImage(flappybird, bird.x, bird.y, bird.width, bird.height, null); //рисуется птица
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
        Game.ticks++;
        Constants.groundx-=5;
        if(Game.ticks%2 == 0 )
        {
            flappybird = bird.get_the_dir('f');

        }
        if(Game.ticks%3 == 0)
        {
            flappybird = bird.get_the_dir('d');
        }
        if(Game.ticks%5 == 0)
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
       // int x_ = Game.obstacles.get(Game.obstacles.size() - 1).x;

        render.repaint();
    }
    public static void createAndShowGui(GameScreen screen)
    {
        render = new Render();
        //Create and set up the window.
        screen.add(render);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //Set up the content pane.
        //Display the window.
        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        Constants.Gravity = 1;
        Constants.vyp = 9;
        Constants.vyn = -20;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

}
