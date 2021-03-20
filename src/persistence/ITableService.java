package persistence;

import model.Table;
import model.User;

import java.util.List;

public interface ITableService {

    String getTabComments(Table table, User u);
    List<String> getTableRest(Table table, User user);
    List<String> getIndexes(Table table, User user);
}
