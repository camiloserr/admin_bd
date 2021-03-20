package persistence;

import model.Index;
import model.Table;
import model.User;

import java.util.List;

public interface ITableService {

    String getTabComments(Table table, User u);
    List<String> getTableRest(Table table, User user);
    List<Index> getIndexes(Table table, User user);
}
