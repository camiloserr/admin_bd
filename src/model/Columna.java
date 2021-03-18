package model;

import java.util.List;

public class Columna {
    String name;
    String dataType;
    List<String> comments;

    public Columna(String name, String dataType, List<String> comments) {
        this.name = name;
        this.dataType = dataType;
        this.comments = comments;
    }
}
