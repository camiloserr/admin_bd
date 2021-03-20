package controller;

import model.*;
import model.Package;
import persistence.*;
import view.View;

import java.util.List;
import java.util.Vector;

public class Controller {


    private static IUserService userService;
    private static IAdminService adminService;
    private static ITableService tableService;


    public Controller(){
        userService = new UserServiceQuemado();
        adminService = new AdminServiceQuemado();
        tableService = new TableServiceQuemado();
        View view = new View(this);

    }

    public List<User> getUsers(){
        return userService.getUsers();
    }

    public List<Table> getUserTables(User u){
        return userService.getUSerTables(u);
    }

    public List<Job> getJobs(){
        return adminService.getJobs();
    }

    public List<Function> getFunctions(User user) {
        return userService.getFunctions(user);
    }

    public List<Procedure> getProcedures(User user) {
        return  userService.getProcedures(user);
    }

    public List<Package> getPackages(User user) {
        return userService.getPackages(user);
    }

    public List<TableSpace> getTablespaces() {
        return adminService.getTableSpaces();
    }

    public Table getTableInfo(Table table, User u) {
        table.setComments(tableService.getTabComments(table, u));
        table.setRestrictions(tableService.getTableRest(table, u));
        table.setIndices(tableService.getIndexes(table, u));
        return table;
    }

    public Job changeJobState(Job j) {
        adminService.changeJobState(j);
        if(j.isEnabled()){
            j.setEnabled(false);
        }
        else{
            j.setEnabled(true);
        }

        return j;
    }

    public User getUserOptions(User user) {
        return userService.getUserObjects(user);
    }
}
