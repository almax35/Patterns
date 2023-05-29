package DataBase_Utils;


import org.postgresql.ds.PGSimpleDataSource;

public class Connection {
    private static  PGSimpleDataSource pgSimpleDataSource;

    private Connection(PGSimpleDataSource pgSimpleDataSource) {
        this.pgSimpleDataSource = pgSimpleDataSource;
    }
    public static PGSimpleDataSource getInstance() {
        if (pgSimpleDataSource == null) {
            pgSimpleDataSource.setUrl("");
            pgSimpleDataSource.setUser("postgres");
            pgSimpleDataSource.setPassword("");
        }
        return pgSimpleDataSource;
    }
}
