package GUI;

import javax.swing.*;
import java.awt.*;

public class Load extends JPanel {
    public Load(){
        this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setPaint(Color.BLACK);
//        g2D.drawLine(0,0,500,500);
//        g2D.drawRect(0,0,100,200);
//        g2D.fillRect(0,0,100,200);
        g2D.fillOval(0,0,100,100);
        g2D.fillOval(100,100,100,100);
    }
}
