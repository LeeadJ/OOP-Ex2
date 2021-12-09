package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class jslider extends JFrame implements ChangeListener {

    JPanel panel;
    JLabel label;
    JSlider slider;

    public jslider(){
        this.setTitle("Slider Demo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0,100, 50);

        slider.setPreferredSize(new Dimension(400,200));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 25));
        label.setFont(new Font("MV Boli", Font.PLAIN, 25));

        slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("C = "+slider.getValue());
        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(label);
        this.add(panel);
        this.setSize(420,420);
        this.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("C = "+slider.getValue());
    }


    public static void main(String[] args) {
        jslider slider = new jslider();
    }

}
