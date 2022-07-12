package org.rokol.quarkus.adapter.repository.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionProvider {
    public Connection establishConnection() throws SQLException;
}
