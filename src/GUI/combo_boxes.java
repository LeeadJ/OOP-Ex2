package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class combo_boxes extends JFrame implements ActionListener {

    JComboBox comboBox;

    public combo_boxes(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // set an array that we will pass on, if we want to use int or double
        // then we use Integer Double etc.
        String [] animals = {"dog", "cat", "bird"};
        // initiation the combo box, and using a global variable
        comboBox = new JComboBox(animals);
        // adding action listener
        comboBox.addActionListener(this);
        // we can edit the box or not
        comboBox.setEditable(true);
        // we can add items to the box
        comboBox.addItem("horse");
        // we can add items at a certain place
        comboBox.insertItemAt("pig", 0);
        // we can select which item will be first in the drop menu
        comboBox.setSelectedIndex(3);
        // we can remove item
        comboBox.removeItem("cat");
        // we can remove item at
        comboBox.removeItemAt(0);
        // and we can remove all
        comboBox.removeAll();
        // adding the comboBox to the frame
        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox){
            System.out.println(comboBox.getSelectedItem());
        }
    }

    public static void main(String[] args) {

        combo_boxes combo = new combo_boxes();
    }
}
