package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class menu extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    ImageIcon loadicon;
    ImageIcon saveicon;
    ImageIcon exiticon;

    public menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        loadicon = new ImageIcon("loading.png");
        saveicon = new ImageIcon("floppy-disk.png");
        exiticon = new ImageIcon("exit.png");

         menuBar = new JMenuBar();
         fileMenu = new JMenu("file");
         editMenu = new JMenu("edit");
         helpMenu = new JMenu("help");

         loadItem = new JMenuItem("Load");
         saveItem = new JMenuItem("Save");
         exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setIcon(loadicon);
        saveItem.setIcon(saveicon);
        exitItem.setIcon(exiticon);

        fileMenu.setMnemonic(KeyEvent.VK_F);// alt + f for file
        editMenu.setMnemonic(KeyEvent.VK_E);// alt + e for edit
        helpMenu.setMnemonic(KeyEvent.VK_H);// alt + h for help
        loadItem.setMnemonic(KeyEvent.VK_L);// l for load
        saveItem.setMnemonic(KeyEvent.VK_S);// s for save
        exitItem.setMnemonic(KeyEvent.VK_E);// e for edit


        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loadItem){
            System.out.println("you loaded a file");
        }
        else if(e.getSource() == saveItem){
            System.out.println("you saved and item");
        }
        else if(e.getSource() == exitItem){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        menu bar = new menu();
    }
}
