package test;

import model.Columna;
import model.Table;
import model.User;
import org.junit.jupiter.api.Test;
import persistence.TableService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableServiceTest {

    @Test
    void getTabComments() {
        TableService tableService = new TableService();

        String res = tableService.getTabComments(new Table("Ejemplo1"), new User("User1"));

        assertEquals("Comentario 2 prueba de ejemplo1",res);
    }

    @Test
    void getTableRest() {
    }

    @Test
    void getIndexes() {
    }
}