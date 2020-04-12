package com.prog;

import Control.Constants;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame
{
    private static GameOver frame;

    public GameOver(String name)
    {
        super(name);
        setResizable(false);
    }

    public void AddComp(final Container pane)
    {
        JPanel gameOverPage  = new JPanel();

        JLabel  lblPic = new JLabel();
        JButton playAgain = new JButton("Play Again");
        JButton toMenu = new JButton("Main menu");

        gameOverPage.setLayout(null);

        lblPic.setBounds(0, 0, 500, 600);
        lblPic.setIcon(new ImageIcon(".\\sprites\\day2-bgr.jpg"));


        playAgain.setBounds(150, 300, 200, 30);
        toMenu.setBounds(150,370,200,30);

        gameOverPage.add(playAgain);
        gameOverPage.add(toMenu);
        gameOverPage.add(lblPic);

        pane.add(gameOverPage, BorderLayout.CENTER);

        playAgain.addActionListener(e-> {
            frame.setVisible(false); // закрываем текущий фрейм
            User user = new User("aa", "aa");
            GameScreen screen1 = new GameScreen("Game", user);
            GameScreen.createAndShowGui(screen1);
        });

        toMenu.addActionListener(e->{
                    frame.setVisible(false); // закрываем текущий фрейм
                    com.prog.LogIn.createAndShowGUI();
                }
        );
    }

    public static void createAndShowGUI(User user)
    {
        //Create and set up the window.
        frame = new GameOver("GameOver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        //Set up the content pane.
        frame.AddComp(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
