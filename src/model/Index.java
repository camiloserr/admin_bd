package model;

public class Index {

    private String indexName;
    private String columnName;

    public Index(String indexName, String columnName) {
        this.indexName = indexName;
        this.columnName = columnName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
