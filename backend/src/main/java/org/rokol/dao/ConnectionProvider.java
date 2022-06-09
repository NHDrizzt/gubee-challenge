package org.rokol.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionProvider {
    public Connection establishConnection() throws SQLException;
}
