package persistence;

import model.Table;
import model.User;

import java.util.List;

/**
 * Interfaz para obtener los datos
 */
public interface IUserService {
    List<User> getUsers();
    List<Table> getUSerTables(User u);
}
