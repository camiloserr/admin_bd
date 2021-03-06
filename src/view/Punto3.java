package view;

import model.Job;
import model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Punto3 {
    private JList listJobs;
    private JPanel panel1;
    private JTextArea textAreaInfoJob;
    private JButton buttonActivateJob;
    private JButton buttonDeactivateJob;
    private JComboBox comboBoxUsers;
    private JButton buttonUsers;

    private Vector<Job> jobs;

    private List<User> users;

    private View view;

    public Punto3(View view){

        // initialize job list

        this.view = view;


        this.users = view.getUsers();

        //initialize combobox with users
        for( User u : this.users){
            comboBoxUsers.addItem(u);
        }



        buttonUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobs = new Vector(view.getJobs( users.get(comboBoxUsers.getSelectedIndex())));
                listJobs.setListData(jobs);

            }
        });

        //System.out.println("en el constructor de 3");


        listJobs.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    showJobInfo(jobs.get(listJobs.getSelectedIndex()));
                }
            }
        });
        buttonActivateJob.addActionListener(new ActionListener() {

            // Activar Job
            @Override
            public void actionPerformed(ActionEvent e) {
                Job currentJob = jobs.get(listJobs.getSelectedIndex());
                currentJob = view.changeJobState(currentJob, users.get(comboBoxUsers.getSelectedIndex()));
                showJobInfo(currentJob);
                buttonActivateJob.setEnabled(false);
                buttonDeactivateJob.setEnabled(true);
            }
        });
        buttonDeactivateJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Job currentJob = jobs.get(listJobs.getSelectedIndex());
                currentJob = view.changeJobState(currentJob, users.get(comboBoxUsers.getSelectedIndex()));
                showJobInfo(currentJob);
                buttonActivateJob.setEnabled(true);
                buttonDeactivateJob.setEnabled(false);
            }
        });

    }

    private void showJobInfo(Job job) {
        String info = "";

        info += "\nNombre: " + job.getName();
        info += "\nDue??o: " + job.getOwner();
        info += "\nClase: " + job.getClass();
        info += "\nComentarios: " + job.getComments();





        if(job.isEnabled()){
            info += "\nEnabled";
        }
        else{
            info += "\nDisabled";
        }

        info += "\nCredential Name: " + job.getCredentialName();
        info += "\nDestination: " + job.getDestination();
        info += "\nProgram Name: " + job.getProgramName();
        info += "\nTipo: " + job.getJobType();
        info += "\nAction: " + job.getJobAction();
        info += "\nNumber of arguments: " + job.getNumberOfArguments();
        info += "\nSchedule owner: " + job.getScheduleOwner();
        info += "\nSchedule type: " + job.getScheduleType();
        info += "\nStart Date: " + job.getStartDate();
        info += "\nRepeat interval: " + job.getRepeatInterval();
        info += "\nEnd Date: " + job.getEndDate();

        textAreaInfoJob.setText(info);
        if(job.isEnabled()){
            buttonActivateJob.setEnabled(false);
            buttonDeactivateJob.setEnabled(true);
        }
        else{
            buttonActivateJob.setEnabled(true);
            buttonDeactivateJob.setEnabled(false);
        }


    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
