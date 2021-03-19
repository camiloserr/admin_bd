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
    void getColComments() {
        TableService tableService = new TableService();

        String res = tableService.getColComments(new Table("Ejemplo1"), "COLEJ1", new User("User1"));

        assertEquals("Comentario 2 en col1",res);


    }

    @Test
    void getColDataType() {

        TableService tableService = new TableService();
        Table table = new Table("Ejemplo1");
        List<Columna> columns = new ArrayList<>();
        columns.add(new Columna("COLEJ1"));
        table.setColumns(columns);

        String res = tableService.getColDataType(table, "COLEJ1", new User("User1"));

        assertEquals("VARCHAR2",res);
    }

    @Test
    void getTableRest() {
    }

    @Test
    void getIndexes() {
    }
}