package model;

import java.util.List;

public class Table {
    String name;
    List<String> comments;
    List<String> restrictions;
    List<String> indices;
    List<Columna> columns;

    public Table(String name){
        this.name = name;
    }

    public Table(String name, List<String> comments, List<String> restrictions, List<String> indices, List<Columna> columns) {
        this.name = name;
        this.comments = comments;
        this.restrictions = restrictions;
        this.indices = indices;
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                '}';
    }
}
