package model;

public class TableSpace {

    private String name;
    private String availibleSpace;
    private String occupiedSpace;

    public TableSpace(String name, String availibleSpace, String occupiedSpace) {
        this.name = name;
        this.availibleSpace = availibleSpace;
        this.occupiedSpace = occupiedSpace;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailibleSpace() {
        return availibleSpace;
    }

    public void setAvailibleSpace(String availibleSpace) {
        this.availibleSpace = availibleSpace;
    }

    public String getOccupiedSpace() {
        return occupiedSpace;
    }

    public void setOccupiedSpace(String occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
    }
}
