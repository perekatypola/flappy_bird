package com.prog;

import Control.Constants;

import javax.swing.*;
import java.awt.*;


public class LogIn extends JFrame
{
    private static LogIn frame;
    public LogIn(String name)
    {
        super(name);
        setResizable(false);
    }
    public void AddComp(final Container pane)
    {
        final JPanel logpage  = new JPanel();

        final JLabel  lblPic = new JLabel();
        final JButton Log = new JButton("LogIn");
        final JButton Sign = new JButton("SignUp");

        logpage.setLayout(null);

        lblPic.setBounds(0, 0, 500, 600);

        lblPic.setIcon(new ImageIcon(".\\sprites\\day2-bgr.jpg"));


        Log.setBounds(150, 300, 200, 30);
        Sign.setBounds(150,370,200,30);

        logpage.add(Log);
        logpage.add(Sign);
        logpage.add(lblPic);

        pane.add(logpage, BorderLayout.CENTER);
        pane.add(logpage, BorderLayout.CENTER);

        Log.addActionListener(e-> {
                frame.setVisible(false); // закрываем текущий фрейм
                com.prog.Log.createAndShowGui();
                com.prog.Log.setLogPan();
        });

        Sign.addActionListener(e->{
                frame.setVisible(false); // закрываем текущий фрейм
                com.prog.Log.createAndShowGui();
                com.prog.Log.setSignPan();
            }
        );
    }
    public static void createAndShowGUI() {
        //Create and set up the window.
        frame = new LogIn("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        //Set up the content pane.
        frame.AddComp(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
