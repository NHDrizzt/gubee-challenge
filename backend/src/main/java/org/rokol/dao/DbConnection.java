package org.rokol.dao;

import io.agroal.api.AgroalDataSourceMetrics;
import io.agroal.api.AgroalPoolInterceptor;
import io.agroal.api.configuration.AgroalDataSourceConfiguration;

import javax.enterprise.context.RequestScoped;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class DbConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        if(conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc?useSSL=false", "root", "root");
            }
            catch(SQLException e) {
                System.out.println("Could not connect to database: " + e.getMessage());
            }
            catch(ClassNotFoundException ex) {
                System.out.println("Class not found: "+ ex.getMessage());
            }
        }
        return conn;
    }
}

