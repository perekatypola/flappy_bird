package com.prog;

import javax.swing.*;
import java.awt.*;

import Control.Render;
import GameObjects.Bird;

import java.awt.event.*;

public class GameScreen extends JFrame implements ActionListener
{
    private static GameScreen frame;
    private static int WIDTH = 500;
    private static int HEIGHT = 600;
    private static Render render;
    static Image backgroundImage ;
    static Image ground;
    static Image flappybird;
    public int ticks, yMotion;
    private static Bird bird;
    public GameScreen(String name)
    {

        super(name);
        Timer timer = new Timer(20 , this);
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10);
        setResizable(false);
        backgroundImage  = new ImageIcon("D:\\4sem\\КПП\\sprites\\background-day.png").getImage();
        ground = new ImageIcon("D:\\4sem\\КПП\\sprites\\base.png").getImage();
        flappybird = new ImageIcon("D:\\4sem\\КПП\\sprites\\blue_1.png").getImage();
        timer.start();
    }
    public static void repaint(Graphics g)

    {
        g.drawImage(backgroundImage, 0, 0, WIDTH , HEIGHT, null);
        g.drawImage(ground , 0 , HEIGHT - 150 , WIDTH , 100,null);
        g.drawImage(flappybird , bird.x , bird.y , bird.width , bird.height,null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        ticks++;
        if (ticks % 2 == 0 && yMotion < 15)
        {
            yMotion += 2;
        }
        bird.y+= yMotion;
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
