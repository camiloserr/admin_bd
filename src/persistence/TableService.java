package persistence;

import model.Index;
import model.Table;
import model.User;
import java.sql.*;
import java.util.ArrayList;
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
    public List<Index> getIndexes(Table table, User user) {

        List<Index> indexList = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);

            String indexQuery = "select INDEX_NAME,COLUMN_NAME from ALL_IND_COLUMNS where TABLE_NAME = '" + table.getName() + "' and INDEX_OWNER = '" + user.getUsername() + "'";

            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(indexQuery);
            while(resultSet.next())
            {
                indexList.add(new Index(resultSet.getString("INDEX_NAME"), resultSet.getString("COLUMN_NAME")));
            }

        }catch (Exception e){

            System.out.println( "On TableService.getIndexes: " + e.getMessage() );

        }


        return indexList;
    }
}
