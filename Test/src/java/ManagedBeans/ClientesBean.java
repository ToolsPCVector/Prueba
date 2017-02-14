/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ManagedBeans.DAO.ClientesDAO;
import Persistencia.DTO.ClientesDTO;
import java.util.List;

/**
 *
 * @author Proyectos Compartidos Ltda.
 */
public class ClientesBean {

    private ClientesDTO cliente = new ClientesDTO();
    private List<ClientesDTO> clientes;

    public ClientesBean() {
    }
 

    /**
     * @return the producto
     */
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
        try{
            ClientesDAO dao = new ClientesDAO();
            clientes = dao.obtenerClientes();
        } catch(Exception e){
            System.out.println("$$$Error List<ClientesDTO>" + e );    
        }
        return clientes;
    }

    /**
     * @param clientes the productos to set
     */
    public void setClientes(List<ClientesDTO> clientes) {
        this.clientes = clientes;
    }

}
