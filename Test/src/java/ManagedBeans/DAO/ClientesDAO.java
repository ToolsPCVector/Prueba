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

    String consul;

    public void insetarClie(int id, String codDes, String zip, String nombre, String direccion,
            String ciudad, String telefono, String fax, String correo, String credito) throws SQLException {

        Connection conexion = null;
        ConexionBD conn;
        String sql = "INSERT INTO CUSTOMER VALUES (" + id + ",'" + codDes + "','" + zip + "','" + nombre + "', 'usu', 'usuario2', '" + direccion + "','FL','" + telefono + "','" + fax + "','" + correo + "'," + credito + ")\n";
        conn = new ConexionBD();
        conexion = conn.getConexion();
        Connection conTmp = conn.conexion;
        PreparedStatement ps = conTmp.prepareStatement(sql);
        ps.executeUpdate();

    }

    public void modificarC(int id,String nombre, String direccion,
            String ciudad, String telefono, String fax, String correo) throws SQLException {

        Connection conexion = null;
        ConexionBD conn;
        String sql = "update CUSTOMER set  NAME='"+nombre+"', ADDRESSLINE1='"+direccion+"', "
                + "CITY='"+ciudad+"', PHONE='"+telefono+"', FAX='"+fax+"', EMAIL='"+correo+"'  where  CUSTOMER_ID="+id+";";
        conn = new ConexionBD();
        conexion = conn.getConexion();
        Connection conTmp = conn.conexion;
        PreparedStatement ps = conTmp.prepareStatement(sql);
        ps.executeUpdate();

    }

    public List<ClientesDTO> obtenerClientes() throws SQLException {

        ClientesDTO cliente;
        List<ClientesDTO> lista = new ArrayList<ClientesDTO>();
        Connection conexion = null;
        ConexionBD conn;
        String sql = "SELECT CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, CITY,  PHONE, FAX, EMAIL FROM CUSTOMER";
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
                cliente.setTelefono(rs.getString("PHONE"));
                cliente.setFax(rs.getString("FAX"));
                cliente.setEmail(rs.getString("EMAIL"));

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
