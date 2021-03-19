package persistence;

import model.Table;
import model.User;

import java.util.List;

public interface ITableService {

    String getTabComments(Table table, User u);
    String getColComments(Table table, String columnName, User u);
    String getColDataType(Table table, String columnName, User u);
    List<String> getTableRest(Table table, User user);
    List<String> getIndexes(Table table);
}
