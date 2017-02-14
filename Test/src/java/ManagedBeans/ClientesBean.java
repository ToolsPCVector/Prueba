/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ManagedBeans.DAO.ClientesDAO;
import Persistencia.DTO.ClientesDTO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Proyectos Compartidos Ltda.
 */
public class ClientesBean extends ClientesDTO {

    private ClientesDTO cliente = new ClientesDTO();
    private ClientesDTO Selectcliente = new ClientesDTO();
    private List<ClientesDTO> clientes;

    public ClientesBean() {
    }

    public ClientesDTO getSelectcliente() {
        return Selectcliente;
    }

    /**
     * @return the producto
     */
    public void setSelectcliente(ClientesDTO Selectcliente) {
        this.Selectcliente = Selectcliente;
    }

    public ClientesDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the producto to set
     */
    public void setCliente(ClientesDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the clientes
     */
    public List<ClientesDTO> getClientes() {
        try {
            ClientesDAO dao = new ClientesDAO();
            clientes = dao.obtenerClientes();
        } catch (Exception e) {
            System.out.println("$$$Error List<ClientesDTO>" + e);
        }
        return clientes;
    }

    /**
     * @param clientes the productos to set
     */
    public void setClientes(List<ClientesDTO> clientes) {
        this.clientes = clientes;
    }

    public void insertarCli() throws SQLException {

        ClientesDAO dao = new ClientesDAO();
        /*(int id, String codDes, String zip, String nombre, String usuario,String direccion,
            String ciudad, String telefono, String fax, String correo, String credito)*/
        dao.insetarClie(getId(), getCodDesc(), getZip(), getNombre(), getDireccion(), getCiudad(), getTelefono(), getFax(), getEmail(), "555");

    }

    public void ModificarCli() throws SQLException {

        ClientesDAO dao = new ClientesDAO();

      
        if (getSelectcliente() != null) {
            dao.modificarC(getSelectcliente().getId(), getNombre(), getDireccion(), getCiudad(), getTelefono(), getFax(), getEmail());

        } else {
            JOptionPane.showMessageDialog(null, "no se seleccion registro a modificar");

        }
        //if(){}
        /*(int id, String codDes, String zip, String nombre, String usuario,String direccion,
            String ciudad, String telefono, String fax, String correo, String credito)*/

    }

    public void listar() throws SQLException {

        ClientesDAO dao = new ClientesDAO();
        /*(int id, String codDes, String zip, String nombre, String usuario,String direccion,
            String ciudad, String telefono, String fax, String correo, String credito)*/
        setClientes(dao.obtenerClientes());
        int g = getClientes().size();
    }
}
