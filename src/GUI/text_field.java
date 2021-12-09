package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class text_field extends JFrame implements ActionListener {
    // global constructors
    JButton button;
    JTextField textField;
    public text_field(){
        // general way to start a JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //creating a button and action listener
        //there is a way of using lambda for it
        button = new JButton("Submit");
        button.addActionListener(this);

        //creating a text field and setting the size
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,250));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(0x00ff00));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setText("username");


        // adding everything to the frame and making it visible
        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }


    @Override
    // this will look out for the actions preformed and act according to what we tell it to do
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Welcome " + textField.getText());
            // disabling button after using it
            button.setEnabled(false);
            textField.setEditable(false);
        }
    }


    public static void main(String[] args) {
        text_field text = new text_field();
    }
}
