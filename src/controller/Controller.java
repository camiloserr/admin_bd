package controller;

import model.*;
import model.Package;
import persistence.AdminServiceQuemado;
import persistence.IAdminService;
import persistence.IUserService;
import persistence.UserServiceQuemado;
import view.View;

import java.util.List;
import java.util.Vector;

public class Controller {


    private static IUserService userService;
    private static IAdminService adminService;


    public Controller(){
        userService = new UserServiceQuemado();
        adminService = new AdminServiceQuemado();
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
}
