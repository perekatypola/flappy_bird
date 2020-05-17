package com.prog;

import javax.swing.*;
import java.awt.*;

import Control.Constants;
import Control.GameData;
import Control.Render;
import Data.WorkWithData;
import Factories.BirdFactory;
import Factories.ObstacleFactory;
import GameObjects.Bird;
import GameObjects.Obstacle;
import Logic.Game;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameScreen extends JFrame implements ActionListener
{
    //private static GameScreen frame;
    private  int WIDTH = 500;
    private int HEIGHT = 600;
    private  Render render;
    private Image backgroundImage;
    private  Image ground;
    private  Image flappybird;
    private  Image gameOver;
    private  Bird bird;
    private Rectangle bird_hitmask;
    private ObstacleFactory ofact;
    public  boolean start;
    private BirdFactory bfact;
    private  Timer timer;
    private Game game;
    private  boolean flag = true;
    private  JButton pause;
    private Constants constants;

    public GameScreen(String name , Game game_ , boolean resume) throws IOException {

        super(name);
        setResizable(false);
        constants = new Constants();
        KeyListener keylstnr = new KeyPress();
        addKeyListener(keylstnr);
        WindowListener lstnr = new Terminator();
        addWindowListener(lstnr);
        MouseListener mouselstnr = new MousePres();
        addMouseListener(mouselstnr);
        pause = new JButton("" , null);
        timer = new Timer(30, this);
        backgroundImage = new ImageIcon(".\\sprites\\day2-bgr.jpg").getImage();
        constants.Init();
        ground = new ImageIcon(".\\sprites\\base.png").getImage();
        bfact = new BirdFactory();
        ofact = new ObstacleFactory();
        this.game = game_;
        if(resume!=true) {
            //initialise fields
            bird = bfact.createBird(0);
            bird_hitmask = new Rectangle();
        }
        else
        {
            String path = "D://КПП//" + game.user.getName() + "_saved.txt";
            FileWriter fstream1 = new FileWriter(path);// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close();  // закрываем
            GameData data = game.data;
            bird = bfact.createBird(data.bird_key);
            bird.y = data.bird_y;
            constants.groundx = data.ground_x;
            bird_hitmask = new Rectangle();
            for(int i = 0 ; i < data.ob_coord.size(); i++)
            {
                game.obstacles.add(new Obstacle(data.ob_s.get(i) , data.ob_n.get(i) , data.ob_height.get(i) , data.ob_coord.get(i)));
            }
            start = true;
        }
        timer.start();
    }
    public void repaint(Graphics g)
    {
        g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);
        g.drawImage(ground, constants.groundx, constants.groundy, WIDTH, 100, null);
        if (constants.WIDTH + constants.groundx == 0) {
            constants.groundx = 0;
            g.drawImage(ground, constants.groundx, constants.groundy, WIDTH, 100, null);
        }
        g.drawImage(ground, constants.WIDTH + constants.groundx, constants.groundy, WIDTH, 100, null);

        bird.y += constants.vyn++;//- Constants.Gravity;

        bird.y += constants.vyp + constants.Gravity;

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
            game.user.addRecord(game.count);
            timer.stop();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        game.ticks++;
        constants.groundx-=5;
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
        render.setLayout(null);
        this.add(render);
        this.setFocusable( true );
        ImageIcon pause_ = new ImageIcon(".\\sprites\\pause.png");
        pause.setIcon(pause_);
        pause.setBounds(10 , 10 , 40 , 40);
        render.add(pause);
        pause.setLocation(0 , 0);
        Color a= new Color(0 , 0 , 0 , .0f);
        pause.setBackground(a);
        pause.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked( MouseEvent aEv )
            {
                GameData temp = new GameData();
                game.setResume();
                temp.gameOver= game.gameOver;
                temp.ticks = game.ticks;
                temp.count = game.count;
                temp.threadNum = game.threadNum;
                temp. user = game.user;
                temp.x = game.x;
                temp.bird_y = bird.y;
                temp.resume = game.getResume();
                // public int bird_x;
                temp.bird_key = bird.getKeyForImage();
                temp.ground_x = constants.groundx;
                temp.ground_y = constants.groundy;
                for (int i = 0; i < game.obstacles.size(); i++) {
                    temp.ob_coord.add(game.obstacles.get(i).x);
                    temp.ob_height.add(game.obstacles.get(i).height);
                    temp.ob_s.add(game.obstacles.get(i).south);
                    temp.ob_n.add( game.obstacles.get(i).north);
                }
                WorkWithData.saveGame(game.user.getName() , temp);
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
                timer.stop();
                dispose();
            }
        } );

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
        public void keyPressed(KeyEvent e) {
           // super.keyPressed(e);
            constants.Gravity = 1;
            constants.vyp = 9;
            constants.vyn = -20;
        }
    }

    class MousePres extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) {
            constants.Gravity = 1;
            constants.vyp = 9;
            constants.vyn = -20;
        }
    }

}
