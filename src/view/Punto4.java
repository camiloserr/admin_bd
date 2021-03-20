package view;

import model.Function;
import model.Package;
import model.Procedure;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Punto4 {
    private JComboBox comboBoxUsers;
    private JPanel panel1;
    private JButton button;
    private JList listFunctions;
    private JList listPackages;
    private JList listProcedures;

    private List<User> users;
    private View view;


    public Punto4(View view){

        this.view = view;
        users = view.getUsers();

        for(User u : users){
            comboBoxUsers.addItem(u);
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserInfo(users.get(comboBoxUsers.getSelectedIndex()));
            }
        });
    }

    private void showUserInfo(User user) {
        user = view.getUserOptions(user);

        listFunctions.setListData(new Vector(user.getFunctions()));
        listPackages.setListData(new Vector(user.getPackages()));
        listProcedures.setListData(new Vector(user.getProcedures()));
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
