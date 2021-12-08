package Ex2;

import api.DirectedWeightedGraphAlgorithms;
import api.GeoLocation;
import api.NodeData;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    public static void main(String[] args) {
        String path = "C:\\Users\\Leead\\IdeaProjects\\OOP-Ex2\\G1.json";
        DirectedWeightedGraphAlgorithms algo = new DWGalgo();
        DWG g = new DWG();
        algo.init(g);
        algo.load(path);
        JFrame w = new Window(algo);
        w.setVisible(true);
    }
    ArrayList<GeoLocation> pointList = new ArrayList<>();
    DirectedWeightedGraphAlgorithms algo;
    GeoLocation mPivot_point = null;
    boolean mDraw_pivot = false;
    boolean mMoving_point = false;
    private int kRADIUS = 5;
    private int window_H = 1000;
    private int window_W = 1000;
    private Image mBuffer_image;
    private Graphics mBuffer_graphics;

    public Window(DirectedWeightedGraphAlgorithms algorithm) {
        this.algo = algorithm;
        Iterator<NodeData> itr = algo.getGraph().nodeIter();
        while (itr.hasNext()){
            NodeData temp = itr.next();
            GeoLocation p = temp.getLocation();
            this.pointList.add(p);
        }

        initGUI();
    }

    private void initGUI() {
        //initializing the window size:
        this.setSize(window_H, window_W);
        //exit GUI when pressing the close button.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MENU BAR
        //initializing the menu bar.
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        menuBar.add(menu);
        this.setMenuBar(menuBar);

        //adding a button that loads a graph.
        MenuItem item1 = new MenuItem("Load-Graph");
        item1.addActionListener(this);

        //adding a button that cleans the window.
        MenuItem item2 = new MenuItem("Save-Graph");
        item2.addActionListener(this);

        //adding a button that cleans the window.
        MenuItem item3 = new MenuItem("Edit-Graph"); //includes running the algorithms on the graph.
        item3.addActionListener(this);

        //adding a button that cleans the window.
        MenuItem item4 = new MenuItem("Clean-up");
        item4.addActionListener(this);

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        //tracks the position of the mouse if over window or not.
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

//    @Override
//    //paint the window.
//    public void paintComponents(Graphics g) {
//        Point3D prev = null;
//        //looping through the points and painting them.
//        //---We want our point to be filled with the key value.---
//        for (Point3D p : pointList) {
//            g.setColor(Color.BLUE);
//            g.fillOval((int) p.x() - kRADIUS, (int) p.y() - kRADIUS,
//                    2 * kRADIUS, 2 * kRADIUS);
//
//            if (prev != null) {
//                g.setColor(Color.RED);
//                g.drawLine((int) p.x(), (int) p.y(),
//                        (int) prev.x(), (int) prev.y());
//
//                // --- We want the weight of the edge.---
//                double dist = prev.distance3D(p);
//                g.drawString(String.format("%.2f", dist),
//                        (int) ((p.x() + prev.x()) / 2),
//                        (int) ((p.y() + prev.y()) / 2));
//            }
//
//            prev = p;
//        }
//
//        if (mDraw_pivot && !mMoving_point) {
//            g.setColor(Color.BLUE);
//            g.fillOval((int) mPivot_point.x() - kRADIUS, (int) mPivot_point.y() - kRADIUS,
//                    2 * kRADIUS, 2 * kRADIUS);
//            if (prev != null) {
//                g.setColor(Color.RED);
//                g.drawLine((int) mPivot_point.x(), (int) mPivot_point.y(),
//                        (int) prev.x(), (int) prev.y());
//
//
//                float dist = (float)prev.distance3D(mPivot_point);
//                float font_size = (float) Math.max(10.0f, Math.pow(dist,1.5f) / 100);
//                font_size = Math.min(40.0f, font_size);
//
//                Font font = g.getFont().deriveFont(font_size);
//                g.setFont(font);
//                g.drawString(String.format("%.2f", dist), (int) ((mPivot_point.x() + prev.x()) / 2), (int) ((mPivot_point.y() + prev.y()) / 2));
//            }
//
//        }
//    }

    public void paint(Graphics g) {
        // Create a new "canvas"
        mBuffer_image = createImage(window_W,window_H );
        mBuffer_graphics = mBuffer_image.getGraphics();

        // Draw on the new "canvas"
        paintComponents(mBuffer_graphics);

        // "Switch" the old "canvas" for the new one
        g.drawImage(mBuffer_image, 0, 0, this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        //---remove the simoletriangle, add load graph, save, edit graph.
        if (str.equals("Load-Graph")) {
            pointList.clear();
            Iterator<NodeData> itr = algo.getGraph().nodeIter();
            while (itr.hasNext()){
                NodeData temp = itr.next();
                GeoLocation p = temp.getLocation();
                pointList.add(p);
            }
            repaint();
        } else if (str.equals("clean-up")) {
            pointList.removeAll(pointList);
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Point3D tmp = new Point3D(x, y, 0);
        int min_dist = (int) (kRADIUS * 1.);
        double best_dist = 1000000;

        for (GeoLocation p : pointList) {
            double dist = tmp.distance(p);
            if (dist < min_dist
                    && dist < best_dist) {
                mPivot_point = p;
                best_dist = dist;
                mMoving_point = true;
            }
        }

        if (mPivot_point == null) {
            mPivot_point = tmp;
        }
        mDraw_pivot = true;
        repaint();
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        if (!mMoving_point) {
            pointList.add(new Point3D(mPivot_point.x(),mPivot_point.y(), mPivot_point.z()) {
            });
        }
        mMoving_point = false;
        mPivot_point = null;
        mDraw_pivot = false;

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        if (mDraw_pivot) {
            GeoLocation temp = new Point3D(x, y, 0);
            mPivot_point=temp;
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
