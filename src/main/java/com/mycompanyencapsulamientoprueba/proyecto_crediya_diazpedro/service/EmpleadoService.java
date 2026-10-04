/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.service;

import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.dao.EmpleadoDAO;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Empleado;
import java.util.List;

/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class EmpleadoService {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void registrarEmpleado(Empleado empleado) {
        empleadoDAO.guardar(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoDAO.listar();
    }
}
