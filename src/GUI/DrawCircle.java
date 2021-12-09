package GUI;
import Ex2.DWG;
import Ex2.Point3D;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DrawCircle extends JFrame {
    DWG graph = new DWG("G1.json");
    ArrayList<Point3D> mPoints = new ArrayList<>();
    Point3D mPivot_point = null;
    boolean mDraw_pivot = false;
    boolean mMoving_point = false;
    private int kRADIUS = 5;
    private int mWin_h = 500;
    private int mWin_w = 500;
    private Image mBuffer_image;
    private Graphics mBuffer_graphics;


    public DrawCircle() throws IOException, ParseException {
        setTitle("Drawing a Circle");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

//    @Override
//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawOval(150, 150, 100, 100);
//        g2d.setColor(Color.RED);
//
//    }

    @Override
    public void paintComponents(Graphics g) {
        Point3D prev = null;

        for (Point3D p : mPoints) {
            g.setColor(Color.BLUE);
            g.fillOval((int) p.x() - kRADIUS, (int) p.y() - kRADIUS,
                    2 * kRADIUS, 2 * kRADIUS);

            if (prev != null) {
                g.setColor(Color.RED);
                g.drawLine((int) p.x(), (int) p.y(),
                        (int) prev.x(), (int) prev.y());

                double dist = prev.distance(p);
                g.drawString(String.format("%.2f", dist),
                        (int) ((p.x() + prev.x()) / 2),
                        (int) ((p.y() + prev.y()) / 2));
            }

            prev = p;
        }

        if (mDraw_pivot
                && !mMoving_point) {
            g.setColor(Color.BLUE);
            g.fillOval((int) mPivot_point.x() - kRADIUS, (int) mPivot_point.y() - kRADIUS,
                    2 * kRADIUS, 2 * kRADIUS);
            if (prev != null) {
                g.setColor(Color.RED);
                g.drawLine((int) mPivot_point.x(), (int) mPivot_point.y(),
                        (int) prev.x(), (int) prev.y());


                float dist = (float)prev.distance(mPivot_point);
                float font_size = (float) Math.max(10.0f, Math.pow(dist,1.5f) / 100);
                font_size = Math.min(40.0f, font_size);

                Font font = g.getFont().deriveFont(font_size);
                g.setFont(font);
                g.drawString(String.format("%.2f", dist), (int) ((mPivot_point.x() + prev.x()) / 2), (int) ((mPivot_point.y() + prev.y()) / 2));
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        // Create a new "canvas"
        mBuffer_image = createImage(mWin_w,mWin_h );
        mBuffer_graphics = mBuffer_image.getGraphics();

        // Draw on the new "canvas"
        paintComponents(mBuffer_graphics);

        // "Switch" the old "canvas" for the new one
        g.drawImage(mBuffer_image, 0, 0, this);
    }

    public static void main(String[] args) throws IOException, ParseException {

        new DrawCircle();

    }
}