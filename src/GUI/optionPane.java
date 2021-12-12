package GUI;

import javax.swing.*;

public class optionPane {
    public static void main(String[] args) {
//        JOptionPane.showMessageDialog(null, "this is a messaege",
//                "title", JOptionPane.PLAIN_MESSAGE);
//
//        JOptionPane.showMessageDialog(null, "this is a messaege",
//                "title", JOptionPane.INFORMATION_MESSAGE);

//            JOptionPane.showMessageDialog(null, "100?",
//                    "title", JOptionPane.QUESTION_MESSAGE);
        /**
         * warning message, useful for many things
         */
//            JOptionPane.showMessageDialog(null, "Downloading Virus",
//                    "title", JOptionPane.WARNING_MESSAGE);

        /**
         *  error message good for the assingment
         */
//        JOptionPane.showMessageDialog(null, "file doesn't exist, try again",
//                "title", JOptionPane.ERROR_MESSAGE);

        /**
         * this is a dialog window
         * down bellow there is a way to edit the buttons
         */
//        JOptionPane.showConfirmDialog(null, "is this worth 100?", "EX2",
//                JOptionPane.YES_NO_CANCEL_OPTION);
        /**
         * this is an option to create a text box that we can use the text later
         */
//        String file =  JOptionPane.showInputDialog("Name of json file?");
//        System.out.println(file);
        /**
         * this is the way to create your own boxes for the dialog
         */
        String[] responses = {"Yes", "Download Virus"};

        /** add image here */
        ImageIcon image = new ImageIcon("smile.jpg");

        /** this is the biggest constructor for dialog messages */
        JOptionPane.showOptionDialog(null, "Did we get 100?", "Result",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, image,
                responses, 0);
    }
}
