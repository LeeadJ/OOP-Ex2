package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class key extends JFrame implements KeyListener {
        JLabel label;
        ImageIcon icon;
    public key(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.RED);
        label.setOpaque(true);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //keytyped = invoked when a key is typed. uses keychar, char output
        switch (e.getKeyChar()) {
            case 'a' -> label.setLocation(label.getX() - 10, label.getY());
            case 'w' -> label.setLocation(label.getX(), label.getY() - 10);
            case 's' -> label.setLocation(label.getX(), label.getY() + 10);
            case 'd' -> label.setLocation(label.getX() + 10, label.getY());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = invoked when a physical key is pressed down, uses keyCode , int output
        switch (e.getKeyCode()) {
            case 37 -> label.setLocation(label.getX() - 10, label.getY());
            case 38 -> label.setLocation(label.getX(), label.getY() - 10);
            case 40 -> label.setLocation(label.getX(), label.getY() + 10);
            case 39 -> label.setLocation(label.getX() + 10, label.getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //KeyReleased = called whenever a button is released
        System.out.println("You released Key char: " + e.getKeyChar());
        System.out.println("You released Key code: " + e.getKeyCode());
    }

    public static void main(String[] args) {
        key k = new key();
    }
}
