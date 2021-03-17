package controller;

import model.User;
import persistence.IUserService;
import persistence.UserServiceQuemado;
import view.View;

import java.util.List;

public class Controller {
    private static IUserService userService;


    public Controller(){
        userService = new UserServiceQuemado();
        View view = new View(this);

    }

    public List<User> getUsers(){
        return userService.getUsers();
    }
}
