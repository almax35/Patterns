package dbutils;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory extends AbstractFactory {
    public Connection createConnection() throws SQLException {
        PGSimpleDataSource dataSource = dbutils.Connection.getInstance();
        return dataSource.getConnection();
    }
}
