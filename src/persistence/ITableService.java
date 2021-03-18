package persistence;

import model.Table;
import model.User;

import java.util.List;

public interface ITableService {

    List<String> getTabComments(Table table);
    List<String> getColComments(Table table);
    List<String> getTableRest(Table table, User user);
    List<String> getIndexes(Table table);
}
