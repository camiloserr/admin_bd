package view;

import model.TableSpace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Punto5 {
    private JTextArea textAreaInfoTablespaces;
    private JPanel panel1;
    private JButton buttonRefresh;
    private View view;

    public Punto5(View view){
        this.view = view;

        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshInfo();
            }
        });
    }

    private void refreshInfo() {

        List<TableSpace> tablespaces = view.getTableSpaces();

        String info = "";

        for( TableSpace ts : tablespaces){
            info += ts.getName() + ":\n";
            info += "  -" + ts.getAvailibleSpace() + " disponibles\n";
            info += "  -" + ts.getOccupiedSpace() + " ocupados\n\n";
        }

        textAreaInfoTablespaces.setText(info);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
