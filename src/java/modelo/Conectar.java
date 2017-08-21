/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Gabriel Casas
 */
public class Conectar {

    private static String servidor = "jdbc:postgresql://localhost:5432/sorteo";
    private static String user = "postgres";
    private static String pass = "postgres";
    private static String drive = "org.postgresql.Driver";
    private Connection conexion;

    public Conectar() {
        try {
            Class.forName(drive);
            conexion = DriverManager.getConnection(servidor, user, pass);
        } catch (ClassNotFoundException ce) {
            System.out.println("Error: class: " + ce.getMessage());
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getSQLState());
        }
    }
    public Connection getConnection() {
        return conexion;
    }
    public void closeConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getSQLState());
        }
    }
}
