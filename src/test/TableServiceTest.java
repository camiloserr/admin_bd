package test;

import model.Table;
import model.User;
import org.junit.jupiter.api.Test;
import persistence.TableService;

import static org.junit.jupiter.api.Assertions.*;

class TableServiceTest {

    @Test
    void getTabComments() {
        TableService tableService = new TableService();

        String res = tableService.getTabComments(new Table("Ejemplo1"), new User("User1"));

        assertNotEquals("",res);
    }

    @Test
    void getColComments() {



    }

    @Test
    void getColDataType() {
    }

    @Test
    void getTableRest() {
    }

    @Test
    void getIndexes() {
    }
}