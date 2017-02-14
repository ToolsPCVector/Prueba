/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Proyectos Compartidos Ltda.
 */
public class ConexionBD {

    public Connection conexion;
    private static final String bd = "sample";
    private static final String user = "app";
    private static final String password = "app";
    private static final String host = "localhost";
    private static final String server = "jdbc:derby://" + host + "/" + bd;

    public ConexionBD() throws SQLException {

        try {

            conexion = DriverManager.getConnection(server, user, password);
            //System.out.println("Conexión a base de datos " + server + " ... OK");
        } catch (Exception e) {
            System.out.println("$$$Error ConexionBD: " + e);
        }

    }

    public Connection getConexion() {
        return conexion;
    }
}
