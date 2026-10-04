/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.service;

import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.dao.ClienteDAO;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Cliente;
import java.util.List;

/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void registrarCliente(Cliente cliente) {
        clienteDAO.guardar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }
}
