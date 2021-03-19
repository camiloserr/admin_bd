package persistence;

import model.Table;
import model.User;
import java.sql.*;
import java.util.List;

public class TableService implements ITableService{

    @Override
    public List<String> getTabComments(Table table) {
        return null;
    }

    @Override
    public List<String> getColComments(Table table, String columnName) {
        return null;
    }

    @Override
    public String getColDataType(Table table, String columnName) {
        return null;
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
