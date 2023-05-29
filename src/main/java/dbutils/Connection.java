package dbutils;


import org.postgresql.ds.PGSimpleDataSource;

public class Connection {
    private static PGSimpleDataSource pgSimpleDataSource;

    private Connection(PGSimpleDataSource pgSimpleDataSource) {
        Connection.pgSimpleDataSource = pgSimpleDataSource;
    }

    public static PGSimpleDataSource getInstance() {
        if (pgSimpleDataSource == null) {
            pgSimpleDataSource = new PGSimpleDataSource();
            pgSimpleDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
            pgSimpleDataSource.setUser("postgres");
            pgSimpleDataSource.setPassword("postgres");
        }
        return pgSimpleDataSource;
    }
}
