package model;

public class User {

    private String username;
    private String space;


    public User(String username) {
        this.username = username;
    }
    public User(String username, String space) {
        this.username = username;
        this.space = space;
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
