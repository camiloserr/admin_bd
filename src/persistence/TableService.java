package persistence;

import model.Table;
import model.User;
import java.sql.*;
import java.util.List;

public class TableService implements ITableService{

    private final String jdbcURL;
    private final String uname;
    private final String pwd;
    public TableService()
    {
        jdbcURL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        uname = "AdminDB";
        pwd = "amendoza1";
    }

    @Override
    public String getTabComments(Table table, User u) {
        String comments = "";

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String username = u.getUsername().toUpperCase();
            String tablename = table.getName().toUpperCase();

            String query = "select  COMMENTS from ALL_TAB_COMMENTS where OWNER = '"+ username + "' and TABLE_NAME = '" + tablename + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                comments = resultSet.getString("COMMENTS");
                table.setComments(comments);
            }

        }catch (Exception e){

        }

        return comments;
    }

    @Override
    public List<String> getTableRest(Table table, User user) {
        return null;
    }

    @Override
    public List<String> getIndexes(Table table) {
        return null;
    }
}
