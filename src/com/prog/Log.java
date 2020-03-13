package com.prog;

import javax.swing.*;
import java.awt.*;

public class Log extends JFrame  {
    private static Log frame;
    private final static JPanel logp = new JPanel();
    private final static JPanel signp = new JPanel();

    public Log(String name)
    {
        super(name);
        setResizable(false);
    }
    public static void setLogPan() 
    {
        signp.setVisible(false);
        logp.setVisible(true);
    }
    public static void setSignPan()
    {
        logp.setVisible(false);
        signp.setVisible(true);

    }
    //сделать функцию для инициализации двух панелей
    public void Init(JButton oklog,  JTextField name, JPasswordField pasw , JPanel Pan , GridLayout experimentLayout)
    {
        Pan.setVisible(false);
        Pan.setLayout(experimentLayout);
        Dimension Size = new Dimension(20 , 5);
        Pan.setPreferredSize(new Dimension((int)(Size.getWidth() * 2.5)+20,
                (int)(Size.getHeight() * 3.5)+20 * 2));

        Pan.setLayout(experimentLayout);
        Pan.setPreferredSize(new Dimension((int)(Size.getWidth() * 2.5)+20,
                (int)(Size.getHeight() * 3.5)+20 * 2));

        oklog.setPreferredSize(Size);
        name.setPreferredSize(Size);
        pasw.setPreferredSize(Size);
        Pan.add(new JLabel("Log in"));
        Pan.add(new JLabel(""));
        Pan.add(new JLabel("Username:"));
        Pan.add(name);
        Pan.add(new JLabel(""));
        Pan.add(new JLabel("Password:"));
        Pan.add(pasw);
        Pan.add(new JLabel(""));
        Pan.add(oklog);
    }
    public void AddComp(final Container pane)
    {
        GridLayout experimentLayout = new GridLayout(0,1);
        JButton oklog  = new JButton("LogIn");;
        JTextField name = new  JTextField(20);
        JPasswordField pasw = new JPasswordField(20);
        Init(oklog , name , pasw , logp ,experimentLayout);

        JButton oksign  = new JButton("LogIn");;
        JTextField names = new  JTextField(20);
        JPasswordField pasws = new JPasswordField(20);
        Init(oksign , names , pasws , signp ,experimentLayout);

        pane.add(signp, BorderLayout.CENTER);
        pane.add(logp, BorderLayout.CENTER);

        oklog.addActionListener(e->{
                frame.setVisible(false);
                GameScreen.createAndShowGui();
            }
        );
        oksign.addActionListener(e->{
                    frame.setVisible(false);
                    GameScreen.createAndShowGui();
                }
        );
    }
    public static void createAndShowGui()
    {
        //Create and set up the window.
        frame = new Log("LogIn/SignUp Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        //Set up the content pane.
        frame.AddComp(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
