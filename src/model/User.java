package model;

public class User {

    private String username;
    private String space = "7 MB";


    public User(String username) {
        this.username = username;
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpace() {
        return space;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
