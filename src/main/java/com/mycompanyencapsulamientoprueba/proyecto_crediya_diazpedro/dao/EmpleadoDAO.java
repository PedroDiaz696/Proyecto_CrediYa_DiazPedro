/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.dao;

import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Empleado;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.RolEmpleado;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.persistence.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class EmpleadoDAO {
    
    public void guardar(Empleado empleado) {
        
    
    String sql = "INSERT INTO empleados (nombre, documento, rol, correo, salario) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.MysConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDocumento());
            ps.setString(3, empleado.getRol().name());
            ps.setString(4, empleado.getCorreo());
            ps.setDouble(5, empleado.getSalario());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar empleado: " + e.getMessage());
        }
    }

    public List<Empleado> listar() {

        List<Empleado> empleados = new ArrayList<>();

        String sql = "SELECT * FROM empleados";

        try (Connection con = ConexionBD.MysConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Empleado empleado = new Empleado();

                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDocumento(rs.getString("documento"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setRol(RolEmpleado.valueOf(rs.getString("rol")));
                empleado.setSalario(rs.getDouble("salario"));

                empleados.add(empleado);
            }

        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }

        return empleados;
    }
}
