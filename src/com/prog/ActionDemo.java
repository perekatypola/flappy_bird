//package com.prog;
//import javax.swing.*;
//
//import java.awt.*;
//import java.awt.event.*;
//
//
//public class ActionDemo extends JFrame implements ActionListener {
//    JTextField text = new JTextField(20);
//    JButton b;
//    private int numClicks = 0;
//
//
//
//    public ActionDemo(String title) {
//
//        super(title);
//        setLayout(new FlowLayout());
//        WindowListener lstnr =  new Terminator();
//        addWindowListener(lstnr);
//        b = new JButton("Click me");
//        add(b);
//        add(text);
//        b.addActionListener(this);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        numClicks++;
//        text.setText("Button Clicked " + numClicks + " times");
//    }
//
//    // public void windowClosing(WindowEvent e) {
//    // dispose();
//    // System.exit(0);
//    // }
//    //
//    // public void windowOpened(WindowEvent e) {
//    // }
//    //
//    // public void windowActivated(WindowEvent e) {
//    // }
//    //
//    // public void windowIconified(WindowEvent e) {
//    // }
//    //
//    // public void windowDeiconified(WindowEvent e) {
//    // }
//    //
//    // public void windowDeactivated(WindowEvent e) {
//    // }
//    //
//    // public void windowClosed(WindowEvent e) {
//    // }
//
//    class Terminator extends WindowAdapter {
//
//        public void windowClosing(WindowEvent e) {
//            dispose();
//            System.exit(0);
//        }
//    }
//}
//


