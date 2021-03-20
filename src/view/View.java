package view;

import controller.AdminDB;
import controller.Controller;
import model.*;
import model.Package;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class View {

    private Controller controller;
    private MainScreen mainScreen;
    private Punto2 punto2;
    private Punto3 punto3;
    private Punto4 punto4;
    private Punto5 punto5;
    private Punto6 punto6;

    public View(Controller controller){


        this.controller = controller;

        // creates content
        mainScreen = new MainScreen(this);
        punto2 = new Punto2(this);
        punto3 = new Punto3(this);
        punto4 = new Punto4(this);
        punto5 = new Punto5(this);
        punto6 = new Punto6(this);



        // sets window
        JFrame frame = new JFrame("Admin DB uvirtual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 800);


        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        tabbedPane.addTab("Tab1", mainScreen.getPanel1());
        tabbedPane.addTab("Tab2", punto2.getPanel1());
        tabbedPane.addTab("Tab3", punto3.getPanel1());
        tabbedPane.addTab("Tab4", punto4.getPanel1());
        tabbedPane.addTab("Tab5", punto5.getPanel1());
        tabbedPane.addTab("Tab6", punto6.getPanel1());

        frame.getContentPane().add(tabbedPane);




        //frame.setContentPane(punto4.getPanel1());

    }


    public List<User> getUsers(){
        return controller.getUsers();
    }

    public List<Table> getUserTable(User u){
        return controller.getUserTables(u);
    }

    public List<Job> getJobs() {
        return controller.getJobs();
    }

    public List<Function> getFunctions(User user) {
        return controller.getFunctions(user);
    }

    public List<Procedure> getProcedures(User user) {
        return controller.getProcedures(user);

    }

    public List<Package> getPackages(User user) {
        return controller.getPackages(user);

    }

    public List<TableSpace> getTableSpaces() {
        return controller.getTablespaces();
    }

    public Table getTableInfo(Table table, User u) {

        return controller.getTableInfo(table,  u);
    }

    public Job changeJobState(Job j) {
        return controller.changeJobState( j );
    }
}
