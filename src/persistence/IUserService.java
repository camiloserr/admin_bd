package persistence;

import model.User;

import java.util.List;

/**
 * Interfaz para obtener los datos
 */
public interface IUserService {
    public List<User> getUsers();
}
