package DataBase_Utils;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory extends AbstractFactory {
    public Connection createConnection() throws SQLException {
        PGSimpleDataSource dataSource= DataBase_Utils.Connection.getInstance();
        Connection connection= dataSource.getConnection();
        return connection;
    }
}
