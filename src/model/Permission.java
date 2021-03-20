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


    public String getGranter() {
        return granter;
    }

    public String getTable() {
        return table;
    }

    public String getPriv() {
        return priv;
    }

    @Override
    public String toString() {
        return "Permission:\n" +
                "grantor = " + granter + '\n' +
                "object = " + table + '\n' +
                "privilege = " + priv + '\n';
    }
}
