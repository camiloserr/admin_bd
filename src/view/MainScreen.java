package view;

import model.Columna;
import model.Table;
import model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private Vector<Table> userTables;
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
                User u = users.get(comboBoxUsers.getSelectedIndex());
                userTables = new Vector<>(view.getUserTable( u ));
                listUserTables.setListData(userTables);
            }
        });


        // List selection listener
        listUserTables.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    User currentUser =  users.get(comboBoxUsers.getSelectedIndex());
                    showTableInfo(userTables.get(listUserTables.getSelectedIndex()), currentUser);
                    System.out.println(listUserTables.getSelectedIndex());
                }
            }
        });
    }

    private void showTableInfo(Table table, User u) {

        table = view.getTableInfo(table, u);

        String info = "";

        info += ("NOMBRE DE LA TABLA: " + table.getName() + "\n");


        if(table.getRestrictions() == null){
            info += "Esta tabla no tiene restricciones\n";
        }
        else {

            info += "Restricciones:\n";
            for (String res : table.getRestrictions()) {
                info += ("  -" + res);
            }
        }

        if(table.getComments() == null) {
            info += "Esta tabla no tiene comentarios\n";

        }
        else {
            info += "Comentarios:\n" + table.getComments();
        }

        if(table.getIndices() == null) {
            info += "Esta tabla no tiene indices\n";

        }
        else {

            info += "Indices:\n";
            for (String ind : table.getIndices()) {
                info += ("  -" + ind);
            }
        }

        textAreaTableInfo.setText(info);


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
