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
    public String getColComments(Table table, String columnName, User u) {

        String comments = "";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String username = u.getUsername().toUpperCase();
            String tablename = table.getName().toUpperCase();

            String query = "select  COMMENTS from ALL_COL_COMMENTS where OWNER = '"+ username + "' and TABLE_NAME = '" + tablename + "' and COLUMN_NAME = '" + columnName + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                comments = resultSet.getString("COMMENTS");
                table.addColComments(columnName,comments);
            }

        }catch (Exception e){

        }

        return comments;
    }

    @Override
    public String getColDataType(Table table, String columnName, User u) {


        String datatype = "";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String username = u.getUsername().toUpperCase();
            String tablename = table.getName().toUpperCase();
            String query = "select DATA_TYPE from ALL_TAB_COLUMNS where OWNER = '"+ username + "' and TABLE_NAME = '" + tablename + "' and COLUMN_NAME = '" + columnName + "'";
            //String query = "select  COMMENTS from ALL_COL_COMMENTS where OWNER = '"+ username + "' and TABLE_NAME = '" + tablename + "' and COLUMN_NAME = '" + columnName + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                datatype = resultSet.getString("DATA_TYPE");
                table.addColDataType(columnName,datatype);//TODO: HANDLEAR ERRORES
            }

        }catch (Exception e){

        }

        return datatype;
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
