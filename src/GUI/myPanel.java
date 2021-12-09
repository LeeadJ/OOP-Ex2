package GUI;

import javax.swing.*;
import java.awt.*;

public class myPanel extends JPanel {

    public myPanel(){
        this.setPreferredSize(new Dimension(500,500));
//        this.setBackground(Color.RED);
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setPaint(Color.PINK);
//        g2D.drawLine(0,0,500,500);
//        g2D.drawRect(0,0,100,200);
//        g2D.fillRect(0,0,100,200);
        g2D.fillOval(0,0,100,100);
        g2D.fillOval(100,100,100,100);
    }

    public static void main(String[] args) {

    }
}
