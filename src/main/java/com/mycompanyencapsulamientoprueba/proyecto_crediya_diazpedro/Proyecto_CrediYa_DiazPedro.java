/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro;

import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.dao.ClienteDAO;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Cliente;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.persistence.ConexionBD;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.ui.MenuConsola;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class Proyecto_CrediYa_DiazPedro {

    public static void main(String[] args) throws SQLException{
        /*
        Connection conexion = ConexionBD.MysConnection();

        if (conexion != null) {
            System.out.println("Prueba de conexión exitosa.");
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
    */
        /*
    ClienteDAO clienteDAO = new ClienteDAO();

    Cliente cliente = new Cliente(
        0,
        "Pedro Diaz",
        "123456789",
        "pedro@gmail.com",
        "3001234567"
    );

    clienteDAO.guardar(cliente);

    System.out.println("Clientes registrados:");

    for (Cliente c : clienteDAO.listar()) {
        System.out.println(
            c.getId() + " - " +
            c.getNombre() + " - " +
            c.getCorreo()
        );
    }
    */
        
        MenuConsola menu = new MenuConsola();
    menu.iniciar();
    }}
