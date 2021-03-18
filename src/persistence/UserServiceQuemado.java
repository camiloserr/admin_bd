package persistence;

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
        usuarios.add(new User("juan"));
        usuarios.add(new User("pedro"));
        usuarios.add(new User("SYSTEM"));

        return usuarios;

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


}
