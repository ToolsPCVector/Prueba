/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans.DAO;

import Persistencia.DTO.ClientesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Proyectos Compartidos Ltda.
 */
public class ClientesDAO {

    public List<ClientesDTO> obtenerClientes() throws SQLException {

        ClientesDTO cliente;
        List<ClientesDTO> lista = new ArrayList<ClientesDTO>();
        Connection conexion = null;
        ConexionBD conn;
        String sql = "SELECT CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, CITY FROM CUSTOMER";
        System.out.println("SQL: " + sql);    
        conn = new ConexionBD();
        conexion = conn.getConexion();
        Connection conTmp = conn.conexion;

        try {
            PreparedStatement ps = conTmp.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new ClientesDTO();
                cliente.setId(rs.getInt("CUSTOMER_ID"));
                cliente.setCodDesc(rs.getString("DISCOUNT_CODE"));
                cliente.setZip(rs.getString("ZIP"));
                cliente.setNombre(rs.getString("NAME"));
                cliente.setDireccion(rs.getString("ADDRESSLINE1"));
                cliente.setCiudad(rs.getString("CITY"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("$$$Error obtenerClientes: " + e);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("$$$Error cerrando conexión: " + e);
            }
        }
        return lista;

    }

}
