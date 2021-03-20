package persistence;

import model.Function;
import model.Procedure;
import model.Table;
import model.User;
import model.Package;

import java.util.List;

/**
 * Interfaz para obtener los datos
 */
public interface IUserService {

    //TODO: traer el espcacio utilizado
    List<User> getUsers();
    List<Table> getUSerTables(User u);
    List<Package> getPackages(User u);
    List<Function> getFunctions(User u);
    List<Procedure> getProcedures(User u);
    void getUserObjects(User u);

    //TODO: punto 2

}
