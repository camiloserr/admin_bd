package model;

import java.util.List;

public class Table {
    String name;
    String comments;
    List<String> restrictions;
    List<Index> indices;
    List<Columna> columns;

    public Table(String name){
        this.name = name;
    }

    public Table(String name, String comments, List<String> restrictions, List<Index> indices, List<Columna> columns) {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<String> restrictions) {
        this.restrictions = restrictions;
    }

    public List<Index> getIndices() {
        return indices;
    }

    public void setIndices(List<Index> indices) {
        this.indices = indices;
    }

    public List<Columna> getColumns() {
        return columns;
    }

    public void setColumns(List<Columna> columns) {
        this.columns = columns;
    }

    public void addColComments(String columnName, String comments) {
        for(Columna c : this.columns)
        {
            if( c.getName().equals(columnName))
            {
                c.setComments(comments);
            }
        }
    }

    public void addColDataType(String columnName, String datatype) throws Exception {
        boolean added = false;
        for(Columna c : this.columns)
        {
            if( c.getName().equals(columnName))
            {
                added = true;
                c.setDataType(comments);
            }
        }
        if(!added)
        {
            //System.out.println("ddd");
            throw new Exception("Column not found on table" + this.name);

        }
    }
}
