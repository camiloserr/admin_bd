package model;

public class Table {
    String name;


    public Table(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                '}';
    }
}
