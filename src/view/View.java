package view;

import controller.AdminDB;
import controller.Controller;
import model.Table;
import model.User;

import javax.swing.*;
import java.util.List;

public class View {

    private Controller controller;
    private MainScreen mainScreen;

    public View(Controller controller){


        this.controller = controller;

        // creates content
        mainScreen = new MainScreen(this);

        // sets window
        JFrame frame = new JFrame("Admin DB uvirtual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 800);

        frame.setContentPane(mainScreen.getPanel1());

    }


    public List<User> getUsers(){
        return controller.getUsers();
    }

    public List<Table> getUserTable(User u){
        return controller.getUserTables(u);
    }
}
