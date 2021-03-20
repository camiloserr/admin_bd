package model;

public class Permission {

    private String granter;
    private String table;
    private String priv;

    public Permission(String granter, String table, String priv){
        this.granter = granter;
        this.table = table;
        this.priv = priv;
    }
}
