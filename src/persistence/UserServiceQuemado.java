package persistence;

import model.User;

import java.util.ArrayList;
import java.util.List;


/**
 * Retorna datos quemados
 * Hay que implementar un userservice (no quemado) que traiga las vainas de la base de datos
 */
public class UserServiceQuemado implements IUserService{
    @Override
    public List<User> getUsers() {
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User("juan"));
        usuarios.add(new User("pedro"));
        usuarios.add(new User("SYSTEM"));

        return usuarios;

    }
}
