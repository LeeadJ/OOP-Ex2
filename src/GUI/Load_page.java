package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Load_page extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    JButton myButton = new JButton("new window");
    public Load_page(){

        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        frame.add(myButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton){
            frame.dispose();
            Window mywindonw = new Window();
        }
    }

    public static void main(String[] args) {
        Load_page test = new Load_page();
    }
}
