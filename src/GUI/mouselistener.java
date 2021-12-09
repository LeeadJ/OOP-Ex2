package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouselistener extends JFrame implements MouseListener {
        JLabel label;
    public mouselistener(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.addMouseListener(this);

        this.add(label);
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // invoked when the mouse button has been clicked
        System.out.println("you clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // invoked when a mouse button has been pressed
        System.out.println("you pressed the mouse");
        label.setBackground(Color.yellow);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // invoked when a mouse button has been released
        System.out.println("you released the mouse");
        label.setBackground(Color.green);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // invoked when the mouse enters the area of the component
        System.out.println("mouse entered");
        label.setBackground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // invoked when the mouse exits the area
        System.out.println("mouse exited");
        label.setBackground(Color.cyan);
    }

    public static void main(String[] args) {
        mouselistener m = new mouselistener();
    }
}
