package com.prog;

import Control.Constants;
import Data.WorkWithData;
import Exeptions.EmptyString;
import Exeptions.TooLong;
import Exeptions.WrongUser;

import javax.swing.*;
import java.awt.*;

import static Control.Constants.*;

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
    public void Init(JLabel log , JButton oklog,  JTextField name, JPasswordField pasw , JPanel Pan, JButton back, JButton records)
    {
        Pan.setVisible(false);
        Pan.setLayout(null);
        Pan.setLocation(0,0);

        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(".\\sprites\\day2-bgr.jpg"));
        img.setBounds(0,0, 500, 600);

        log.setBackground(Color.white);
        log.setOpaque(true);
        Font font = new Font("Verdana", Font.BOLD, 13);
        log.setFont(font);
        log.setBounds(50, 100, 60, 30);

        JLabel username = new JLabel("Username: ");
        username.setBackground(Color.white);
        username.setOpaque(true);
        username.setBounds(47, 162, 80, 25);

        name.setBounds(130, 160, 200, 30);
        name.setText("");

        JLabel password = new JLabel("Password: ");
        password.setBackground(Color.white);
        password.setOpaque(true);
        password.setBounds(47, 197, 80, 25);

        pasw.setBounds(130, 195, 200, 30);
        pasw.setText("");

        oklog.setBounds(258, 240, 80, 20);

        back.setBounds(10, 10, 80, 20);

        if(Pan == logp)
        {
            records.setBounds(90, 240, 150, 20);
            Pan.add(records);
        }

        Pan.add(log);
        Pan.add(username);
        Pan.add(name);
        Pan.add(password);
        Pan.add(pasw);
        Pan.add(oklog);
        Pan.add(img);
        Pan.add(back);
        Pan.setSize(Constants.WIDTH,Constants.HEIGHT);
    }
    public void AddComp(final Container pane)
    {
        JButton oklog = new JButton("LogIn");
        JTextField name = new JTextField(20);
        JPasswordField pasw = new JPasswordField(20);
        JLabel log = new JLabel("LogIn");
        JButton back = new JButton("Back");
        JButton records = new JButton("View records");

        Init(log, oklog, name, pasw, logp, back, records);

        JButton oksign = new JButton("SignUp");
        JTextField names = new JTextField(20);
        JPasswordField pasws = new JPasswordField(20);
        JLabel sign = new JLabel("SignUp");
        JButton back1 = new JButton("Back");

        Init(sign, oksign, names, pasws, signp, back1, records);

        pane.add(signp);
        pane.add(logp);

        back.addActionListener(e ->
        {
            frame.setVisible(false);
            LogIn.createAndShowGUI();
        });

        back1.addActionListener(e ->
        {
            frame.setVisible(false);
            LogIn.createAndShowGUI();
        });

        oklog.addActionListener(e -> {
                    try {
                        String pass = new String(pasw.getPassword());

                        if (name.getText().isEmpty() || pass.isEmpty()) throw new EmptyString("The name field is empty!");
                        if (pass.isEmpty()) throw new EmptyString("The password field is empty!");
                        if(name.getText().length() > 25) throw new TooLong("The name is too long");
                        if(pass.length() > 25) throw new TooLong("The password is too long");
                        WorkWithData.getData();
                        if(!Data.WorkWithData.checkUserLog(name.getText(), new String(pasw.getPassword()))) throw new WrongUser("User doesn't exist!");

                        User user = new User(name.getText(), pass);
                        frame.setVisible(false);
                        GameScreen screen = new GameScreen("Game", user);
                        GameScreen.createAndShowGui(screen);
                    } catch (EmptyString er) {
                        JOptionPane.showMessageDialog(frame, er.getMesage());
                    }
                    catch(TooLong err)
                    {
                        JOptionPane.showMessageDialog(frame, err.getMesage());
                    }
                    catch(WrongUser eror)
                    {
                        JOptionPane.showMessageDialog(frame, eror.getMesage());
                    }
                }
        );

        oksign.addActionListener(e -> {
            try {
                String passs = new String(pasws.getPassword());

                if (names.getText().isEmpty() || passs.isEmpty()) throw new EmptyString("The name field is empty!");
                if (passs.isEmpty()) throw new EmptyString("The password field is empty!");
                if(names.getText().length() > 25) throw new TooLong("The name is too long");
                if(passs.length() > 25) throw new TooLong("The password is too long");
                WorkWithData.getData();
                if(Data.WorkWithData.checkUserSign(names.getText())) throw new WrongUser("User already exists!");

                User user = new User(names.getText(), passs);
                Data.WorkWithData.addUser(names.getText(), new String(pasws.getPassword()));
                frame.setVisible(false);
                GameScreen screen = new GameScreen("Game", user);
                GameScreen.createAndShowGui(screen);

            } catch (EmptyString er) {
                JOptionPane.showMessageDialog(frame, er.getMesage());
            }
            catch(TooLong err)
            {
                JOptionPane.showMessageDialog(frame, err.getMesage());
            }
            catch(WrongUser eror)
            {
                JOptionPane.showMessageDialog(frame, eror.getMesage());
            }
            }
        );

        records.addActionListener(e -> {
                    try {
                        String pass = new String(pasw.getPassword());

                        if (name.getText().isEmpty() || pass.isEmpty()) throw new EmptyString("The name field is empty!");
                        if (pass.isEmpty()) throw new EmptyString("The password field is empty!");
                        if(name.getText().length() > 25) throw new TooLong("The name is too long");
                        if(pass.length() > 25) throw new TooLong("The password is too long");
                        WorkWithData.getData();
                        if(!Data.WorkWithData.checkUserLog(name.getText(), new String(pasw.getPassword()))) throw new WrongUser("User doesn't exist!");

                        User user = new User(name.getText(), pass);
                        JOptionPane.showMessageDialog(frame, "Your record is " + user.getRecord());

                    } catch (EmptyString er) {
                        JOptionPane.showMessageDialog(frame, er.getMesage());
                    }
                    catch(TooLong err)
                    {
                        JOptionPane.showMessageDialog(frame, err.getMesage());
                    }
                    catch(WrongUser eror)
                    {
                        JOptionPane.showMessageDialog(frame, eror.getMesage());
                    }
                }
        );

    }

    public static void createAndShowGui(String pane)
    {
        //Create and set up the window.
        frame = new Log("LogIn/SignUp Page");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        //Set up the content pane.
        frame.AddComp(frame.getContentPane());
        frame.setLayout(null);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        if(pane == "Log") setLogPan();
        if(pane == "Sign") setSignPan();
    }
}
