/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haylton.devmedia.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Haylton
 */
public class AcessoJDBC {

    public Connection getConnection() {
        Connection connection = null;
        System.out.println("Chamando a conexao");
        String jdbcUrl = "jdbc:postgresql://localhost:5432/testdb";
        String username = "postgres";
        String password = "postgres";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
