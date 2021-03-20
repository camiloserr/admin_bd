package view;

import model.Permission;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Punto2 {

    // GUI
    private JComboBox comboBoxUsers;
    private JPanel panel1;
    private JButton buttonGetInfo;
    private JTextArea textAreaInfoObjects;

    private View view;
    private List<User> users;


    public Punto2(View view){
        this.users = view.getUsers();
        this.view = view;
        //initialize combobox with users
        for( User u : this.users){
            comboBoxUsers.addItem(u);
        }

        // listeners
        buttonGetInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showObjecsInfo();
            }
        });
    }


    //TODO: implement
    /**
     * gets tables and objects from DB and shows the info in textAreaInfoObjects
     */
    private void showObjecsInfo() {
        textAreaInfoObjects.setText("cargando....");
        List<Permission> permissionList = view.getPermissions(users.get(comboBoxUsers.getSelectedIndex()));

        String info = "";

        for(Permission p : permissionList){
            info += p.toString();
            info += "==============================\n";
        }

        textAreaInfoObjects.setText(info);
    }


    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

}
