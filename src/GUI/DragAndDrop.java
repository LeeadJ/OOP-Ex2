package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragAndDrop  extends JPanel {
    ImageIcon image = new ImageIcon("laughing.png");
    ImageIcon image2 = new ImageIcon("sad.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPt;
    public DragAndDrop(){
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        image2.paintIcon(this, g, 50, 50);
    }


    private  class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }
    }

    private  class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point curr = e.getPoint();

            imageCorner.translate(
                    (int)(curr.getX()-prevPt.getX()),
                    (int)(curr.getY()-prevPt.getY())
            );
            prevPt = curr;
            repaint();
        }
    }




    public static void main(String[] args) {
        frame myframe = new frame();
    }
}
