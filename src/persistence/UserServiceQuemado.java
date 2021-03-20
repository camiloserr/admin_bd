package persistence;

import model.Function;
import model.Package;
import model.Procedure;
import model.Table;
import model.User;
import java.sql.*;
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
        usuarios.add(new User("juan", "7 MB"));
        usuarios.add(new User("pedro", "14 GB"));
        usuarios.add(new User("SYSTEM", "4 KB"));

        return usuarios;

    }

    @Override
    public List<User> getUsersSpace() {
        return null;
    }

    @Override
    public List<Table> getUSerTables(User u) {
        List<Table> tables = new ArrayList<>();

        tables.add(new Table("Notas"));
        tables.add(new Table("Estudiantes"));
        tables.add(new Table("semestres"));
        tables.add(new Table("Clases"));

        return tables;

    }

    @Override
    public List<Package> getPackages(User u) {
        List<Package> pack = new ArrayList<>();

        pack.add(new Package("paquete 1", true));
        pack.add(new Package("paquete 2", false));
        pack.add(new Package("paquete 3", false));
        pack.add(new Package("paquete 4", true));
        return pack;
    }


    @Override
    public List<Function> getFunctions(User u) {
        List<Function> func = new ArrayList<>();

        func.add(new Function("calcular promedio", true));
        func.add(new Function("eliminar estudiantes", false));
        func.add(new Function("cerrar semestre", true));

        return func;
    }

    @Override
    public List<Procedure> getProcedures(User u) {
        List<Procedure> proc = new ArrayList<>();

        proc.add(new Procedure("procedimiento 1", false));
        proc.add(new Procedure("procedimiento 2", false));
        proc.add(new Procedure("procedimiento 3", true));
        return proc;

    }

    @Override
    public User getUserObjects(User u) {
        u.setProcedures(this.getProcedures(u));
        u.setPackages(this.getPackages(u));
        u.setFunctions(this.getFunctions(u));

        return u;
    }


}
