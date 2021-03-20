package view;

import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Punto6 {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton buttonRefresh;
    private View view;


    public Punto6(View view){
        this.view = view;


        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshInfo();
            }
        });
    }

    private void refreshInfo() {
        List<User> users = view.getUsers();
        String info = "";
        for(User u : users){
            info += u.getUsername();
            info += " -> ";
            info += u.getSpace();
            info += "\n";
        }

        textArea1.setText(info);

    }

    public JPanel getPanel1() {
        return panel1;
    }
}
