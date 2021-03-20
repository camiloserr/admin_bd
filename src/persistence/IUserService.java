package persistence;

import model.*;
import model.Package;

import java.util.List;

/**
 * Interfaz para obtener los datos
 */
public interface IUserService {

    List<User> getUsers();
    List<User> getUsersSpace();
    List<Table> getUSerTables(User u);
    List<Package> getPackages(User u);
    List<Function> getFunctions(User u);
    List<Procedure> getProcedures(User u);
    User getUserObjects(User u);
    List<Permission> getPermissions(User u);



}
