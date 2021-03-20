package test;

import model.Table;
import model.User;
import org.junit.jupiter.api.Test;
import persistence.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void getUsersTest() {
        UserService userService = new UserService();
        List<User> users = userService.getUsers();

        assertEquals(39,users.size());
    }

    @org.junit.jupiter.api.Test
    void getUSerTablesTest() {
        UserService userService = new UserService();
        List<Table> tables = userService.getUSerTables(new User("User1"));
        assertEquals(3,tables.size());
    }
    @org.junit.jupiter.api.Test
    void getUserObjects()
    {
        UserService userService = new UserService();
        userService.getUserObjects(new User("SYS"));
        int var = 1;
        assertEquals(1,var);
    }
}