package persistence;

import model.User;

import java.util.List;


/**
 * Retorna datos quemados
 * Hay que implementar un userservice (no quemado) que traiga las vainas de la base de datos
 */
public class UserServiceQuemado implements IUserService{
    @Override
    public List<User> getUsers() {
        return null;
    }
}
