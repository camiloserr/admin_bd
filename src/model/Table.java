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
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<String> restrictions) {
        this.restrictions = restrictions;
    }

    public List<String> getIndices() {
        return indices;
    }

    public void setIndices(List<String> indices) {
        this.indices = indices;
    }

    public List<Columna> getColumns() {
        return columns;
    }

    public void setColumns(List<Columna> columns) {
        this.columns = columns;
    }
}
