package model;

public class Function {

    private String name;
    private boolean state;

    public Function(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    @Override
    public String toString() {
        if(isState()){
            return name + " es valido";
        }
        else{
            return name + " no es valido";

        }

    }
}
