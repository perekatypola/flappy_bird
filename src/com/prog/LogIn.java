package com.prog;

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

        final JButton  lblPic = new JButton();
        final JButton Log = new JButton("LogIn");
        final JButton Sign = new JButton("SignUp");

//        JButton b = new JButton("Just fake button");
//        Dimension buttonSize = b.getPreferredSize();
//        logpage.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+20,
//                (int)(buttonSize.getHeight() * 3.5)+20 * 2));
        logpage.setLayout(new GridLayout(4,3));
        logpage.add(new Label(" "));
        logpage.add(new Label(" "));
        logpage.add(new Label(" "));
        logpage.add(new Label(" "));
        logpage.add(lblPic);
        logpage.add(new Label(" "));
        logpage.add(new Label(" "));
        logpage.add(new Label(" "));
        logpage.add(new Label(" "));
        logpage.add(Log);
        logpage.add(new Label(" "));
        logpage.add(Sign);

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
        frame.setPreferredSize(new Dimension(500, 500));
        //Set up the content pane.
        frame.AddComp(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
