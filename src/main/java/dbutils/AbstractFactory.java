package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractFactory {
    abstract Connection createConnection() throws SQLException;
}
