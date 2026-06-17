package com.tarea.tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/tienda";
        String user = "postgres";
        String pass = "admin123";

        return DriverManager.getConnection(url, user, pass);
    }
}