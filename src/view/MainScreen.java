package view;

import model.Table;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class MainScreen {


    private JButton buttonSelectUser;
    private JPanel panel1;
    private JComboBox comboBoxUsers;
    private JList listUserTables;
    private JTextArea textAreaTableInfo;

    private List<User> users;
    private View view;

    public MainScreen(View view) {

        this.view = view;
        this.users = view.getUsers();

        //initialize combobox with users
        for( User u : this.users){
            comboBoxUsers.addItem(u);
        }

        // button listener
        buttonSelectUser.addActionListener(new ActionListener() {

            // llenar la lista de tablas
            @Override
            public void actionPerformed(ActionEvent e) {
                User u = (User) listUserTables.getSelectedValue();
                Vector<Table> v = new Vector<>(view.getUserTable( u ));
                listUserTables.setListData(v);
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
