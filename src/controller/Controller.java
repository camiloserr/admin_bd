package controller;

import model.*;
import model.Package;
import persistence.*;
import view.View;

import java.util.List;

public class Controller {


    private static IUserService userService;
    private static IAdminService adminService;
    private static ITableService tableService;


    public Controller(){
        userService = new UserService();//Quemado();
        adminService = new AdminService();//Quemado();
        tableService = new TableService();//Quemado();
        View view = new View(this);

    }

    public List<User> getUsers(){
        return userService.getUsers();
    }

    public List<Table> getUserTables(User u){
        return userService.getUSerTables(u);
    }

    public List<Job> getJobs(User u){
        return adminService.getJobs( u);
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

    public Job changeJobState(Job j, User u) {
        if(adminService.changeJobState(j,u))
        {
            if(j.isEnabled()){
                j.setEnabled(false);
            }
            else{
                j.setEnabled(true);
            }
        }
        else
        {
            System.out.println("Camilo la cagó");
        }

        return j;
    }

    public User getUserOptions(User user) {
        return userService.getUserObjects(user);
    }
}
