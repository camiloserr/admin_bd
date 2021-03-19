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

        assertEquals("Comentario 2 prueba de ejemplo1",res);
    }

    @Test
    void getColComments() {
        TableService tableService = new TableService();

        String res = tableService.getColComments(new Table("Ejemplo1"), "COLEJ1", new User("User1"));

        assertEquals("Comentario 2 en col1",res);


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