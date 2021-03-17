package view;

import controller.AdminDB;
import controller.Controller;

import javax.swing.*;

public class View {

    private MainScreen mainScreen;

    public View(Controller controller){


        // creates content
        mainScreen = new MainScreen(controller.getUsers());

        // sets window
        JFrame frame = new JFrame("Admin DB uvirtual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);

        frame.setContentPane(mainScreen.getPanel1());

    }
}
