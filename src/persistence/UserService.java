package persistence;
import model.Table;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserService implements IUserService{


    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
        String uname = "AdminDB";
        String pwd = "amendoza1";
        Connection dbConnection;
        try
        {
            dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String query = "SELECT username FROM all_users";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.getResultSet();

            while(resultSet.next())
            {
                User u = new User( resultSet.getString("USERNAME"));
                users.add(u);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error en UserService.getUsers db: " + e.getMessage());
        }

        return users;
    }

    @Override
    public List<Table> getUSerTables(User u) {
        return null;
    }
}
