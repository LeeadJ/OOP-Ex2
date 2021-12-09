package GUI;

import javax.swing.*;

public class frame extends JFrame {
    DragAndDrop dragPanel = new DragAndDrop();
    public frame(){

        this.add(dragPanel);
        this.setTitle("Drag & Drop demo");
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
