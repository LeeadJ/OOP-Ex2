package GUI;

import javax.swing.*;
import java.awt.*;

public class progress_bar extends JFrame  {

    JProgressBar bar;

    public progress_bar(){
        bar = new JProgressBar(0,500);
        bar.setValue(0);
        bar.setBounds(0,0,420,50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.GREEN);
        bar.setBackground(Color.RED);


        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);
        this.add(bar);

        fill();
    }
    public void fill(){
        int counter = 500;
        while(counter>=0){
            bar.setValue(counter);
            try{
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter--;
        }
        bar.setString("Done!");
    }



    public static void main(String[] args) {
        progress_bar bar = new progress_bar();
    }

}
