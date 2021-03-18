package test;

import model.Table;
import model.User;
import persistence.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void getUsersTest() {
        UserService userService = new UserService();
        List<User> users = userService.getUsers();

        assertEquals(13,users.size());
    }

    @org.junit.jupiter.api.Test
    void getUSerTablesTest() {
        UserService userService = new UserService();
        List<Table> tables = userService.getUSerTables(new User("User1"));
        assertEquals(1,tables.size());
    }
}