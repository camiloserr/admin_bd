package view;

import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainScreen {


    private JButton buttonSelectUser;
    private JPanel panel1;
    private JComboBox comboBoxUsers;

    public MainScreen(List<User> users) {

        //initialize combobox with users
        for( User u : users){
            comboBoxUsers.addItem(u);
        }

        // button listener
        buttonSelectUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public JButton getButtonSelectUser() {
        return buttonSelectUser;
    }

    public void setButtonSelectUser(JButton buttonSelectUser) {
        this.buttonSelectUser = buttonSelectUser;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
