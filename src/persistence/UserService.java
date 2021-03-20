package persistence;
import model.*;
import model.Package;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{

    private final String jdbcURL;
    private final String uname;
    private final String pwd;
    public UserService()
    {
        jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
        uname = "CAMILOADMIN";
        pwd = "basesdedatos2021";
    }

    @Override
    public List<User> getUsers() {
        //System.out.println("Init function");
        List<User> users = new ArrayList<>();
        Connection dbConnection;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);

            String query =  "SELECT username FROM all_users";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next())
            {

                User u = new User( resultSet.getString(1));

                users.add(u);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error en UserService.getUsers db: " + e.getMessage());
        }

        return users;
    }

    @Override
    public List<User> getUsersSpace() {
        //System.out.println("Init function");
        List<User> users = new ArrayList<>();
        Connection dbConnection;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);

            String query = "select owner, sum(BYTES)/1024/1024 MB from DBA_EXTENTS group by OWNER order by OWNER";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next())
            {

                User u = new User( resultSet.getString(1));
                u.setSpace(resultSet.getString(2));

                users.add(u);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
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
               // System.out.println( resultSet.getString("TABLE_NAME") );

                Table t = new Table(resultSet.getString("TABLE_NAME"));
                String colQuery = "select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME = '" + t.getName() + "' and OWNER = '"+ user + "'";
                Statement statement2 = dbConnection.createStatement();
                ResultSet colsResultSet = statement2.executeQuery(colQuery);
                List<Columna> columns = new ArrayList<>();
                while( colsResultSet.next() )
                {
                    //System.out.println(t.getName() + " col: " + colsResultSet.getString("COLUMN_NAME"));

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


                    //System.out.println(dataType + "  .  " + comments);

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

    @Override
    public User getUserObjects(User u) {
        Connection dbConnection;
        List<Package> packages = new ArrayList<>();
        List<Function> functions = new ArrayList<>();
        List<Procedure> procedures = new ArrayList<>();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String query = "Select OBJECT_NAME, STATUS, OBJECT_TYPE from ALL_OBJECTS where OWNER = '" + u.getUsername() + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                boolean status = false;
                if( resultSet.getString("STATUS").equals("VALID"))
                {
                    status = true;
                }
                if(resultSet.getString("OBJECT_TYPE").equals("FUNCTION"))
                {
                    functions.add( new Function( resultSet.getString("OBJECT_NAME"), status));
                }
                if(resultSet.getString("OBJECT_TYPE").equals("PACKAGE"))
                {
                    packages.add( new Package( resultSet.getString("OBJECT_NAME"), status));
                }
                if(resultSet.getString("OBJECT_TYPE").equals("PROCEDURE"))
                {
                    procedures.add( new Procedure( resultSet.getString("OBJECT_NAME"), status));
                }
                //System.out.println(resultSet.getString( "OBJECT_TYPE" ) + "    +    " + resultSet.getString("OBJECT_NAME") + "    +    " + resultSet.getString( "STATUS" ));
            }

            u.setFunctions(functions);
            u.setPackages(packages);
            u.setProcedures(procedures);
        }
        catch (Exception e)
        {
            System.out.println("Error en UserService.getUserObjetcs db: " + e.getMessage());
        }
        return u;
    }

    @Override
    public List<Permission> getPermissions(User u){
        List<Permission> per = new ArrayList<>();
        Connection dbConnection;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String query = "select * from DBA_TAB_PRIVS WHERE GRANTEE = '" +  u.getUsername() + "'" ;
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String granter = resultSet.getString("GRANTOR");
                String tableName = resultSet.getString("TABLE_NAME");
                String type = resultSet.getString("PRIVILEGE");
                Permission permi = new Permission(granter, tableName, type);

                per.add(permi);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return per;
    }
}
