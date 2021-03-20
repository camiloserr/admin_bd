package persistence;
import model.*;

import java.lang.Package;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{

    private final String jdbcURL;
    private final String uname;
    private final String pwd;
    public UserService()
    {
        jdbcURL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        uname = "AdminDB";
        pwd = "amendoza1";
    }
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String query = "SELECT username FROM all_users";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next())
            {
                System.out.println( resultSet.getString("USERNAME") );

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
        List<Table> tables = new ArrayList<>();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String user = u.getUsername().toUpperCase();
            String query = "SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER = '" + user + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next())
            {

                Table t = new Table(resultSet.getString("TABLE_NAME"));
                String colQuery = "select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME = '" + t.getName() + "' and OWNER = '"+ user + "'";
                Statement statement2 = dbConnection.createStatement();
                ResultSet colsResultSet = statement2.executeQuery(colQuery);
                List<Columna> columns = new ArrayList<>();
                while( colsResultSet.next() )
                {
                    System.out.println(t.getName() + " col: " + colsResultSet.getString("COLUMN_NAME"));

                    String columnName = colsResultSet.getString("COLUMN_NAME");
                    String dtQuery = "select DATA_TYPE from ALL_TAB_COLUMNS where OWNER = '"+ user + "' and TABLE_NAME = '" + t.getName() + "' and COLUMN_NAME = '" + columnName + "'";
                    String commentsQuery = "select  COMMENTS from ALL_COL_COMMENTS where OWNER = '"+ user + "' and TABLE_NAME = '" + t.getName() + "' and COLUMN_NAME = '" + columnName + "'";
                    Statement statement3 = dbConnection.createStatement();
                    ResultSet colsDTResultSet = statement3.executeQuery(dtQuery);
                    Statement statement4 = dbConnection.createStatement();
                    ResultSet colsCOMResultSet = statement4.executeQuery(commentsQuery);

                    colsDTResultSet.next();
                    colsCOMResultSet.next();

                    String dataType = colsDTResultSet.getString("DATA_TYPE");
                    String comments = colsCOMResultSet.getString("COMMENTS") ;

                    if (dataType == null) {
                        dataType = "";
                    }
                    if(comments == null)
                    {
                        comments = "";
                    }


                    System.out.println(dataType + "  .  " + comments);

                    columns.add( new Columna(columnName,dataType,comments));
                }
                t.setColumns(columns);

                tables.add(t);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error en UserService.getUserTables db: " + e.getMessage());
        }
        return tables;
    }

    @Override
    public List<Package> getPackages(User u) {
        return null;
    }

    @Override
    public List<Function> getFunctions(User u) {
        return null;
    }

    @Override
    public List<Procedure> getProcedures(User u) {
        return null;
    }
}
