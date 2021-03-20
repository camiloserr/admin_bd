package model;

import java.util.List;

public class Columna {
    String name;
    String dataType;
    String comments;

    public Columna(String name) {
        this.name = name;
    }

    public Columna(String name, String dataType, String comments) {
        this.name = name;
        this.dataType = dataType;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
