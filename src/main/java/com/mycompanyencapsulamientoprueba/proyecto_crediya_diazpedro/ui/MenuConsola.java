/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.ui;

import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Cliente;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Empleado;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.RolEmpleado;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.service.ClienteService;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.service.EmpleadoService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class MenuConsola {
    private final Scanner scanner;
    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;
    
    
    public MenuConsola() {
        scanner = new Scanner(System.in);
        clienteService = new ClienteService();
        empleadoService = new EmpleadoService();
    }

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n===== CREDIYA =====");
            System.out.println("1. Clientes");
            System.out.println("2. Empleados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuClientes();
                    break;

                case 2:
                    menuEmpleados();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);
    }

    private void menuClientes() {

        int opcion;

        do {
            System.out.println("\n===== CLIENTES =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);
    }

    private void registrarCliente() {

        System.out.println("\n===== REGISTRAR CLIENTE =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(
                0,
                nombre,
                documento,
                correo,
                telefono
        );

        clienteService.registrarCliente(cliente);

        System.out.println("Cliente registrado correctamente.");
    }

    private void listarClientes() {

        System.out.println("\n===== LISTA DE CLIENTES =====");

        List<Cliente> clientes = clienteService.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(
                    cliente.getId() + " | " +
                    cliente.getNombre() + " | " +
                    cliente.getDocumento() + " | " +
                    cliente.getCorreo() + " | " +
                    cliente.getTelefono()
            );
        }
    }

    private void menuEmpleados() {

        int opcion;

        do {
            System.out.println("\n===== EMPLEADOS =====");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;

                case 2:
                    listarEmpleados();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);
    }

    private void registrarEmpleado() {

        System.out.println("\n===== REGISTRAR EMPLEADO =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Roles disponibles:");
        System.out.println("1. ADMINISTRADOR");
        System.out.println("2. ASESOR");
        System.out.println("3. COBRADOR");
        System.out.print("Seleccione un rol: ");

        int opcionRol = scanner.nextInt();
        scanner.nextLine();

        RolEmpleado rol;

        switch (opcionRol) {
            case 1:
                rol = RolEmpleado.ADMINISTRADOR;
                break;

            case 2:
                rol = RolEmpleado.ASESOR;
                break;

            case 3:
                rol = RolEmpleado.COBRADOR;
                break;

            default:
                System.out.println("Rol inválido.");
                return;
        }

        Empleado empleado = new Empleado(
                0,
                nombre,
                documento,
                correo,
                rol,
                salario
        );

        empleadoService.registrarEmpleado(empleado);

        System.out.println("Empleado registrado correctamente.");
    }

    private void listarEmpleados() {

        System.out.println("\n===== LISTA DE EMPLEADOS =====");

        List<Empleado> empleados = empleadoService.listarEmpleados();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (Empleado empleado : empleados) {
            System.out.println(
                    empleado.getId() + " | " +
                    empleado.getNombre() + " | " +
                    empleado.getDocumento() + " | " +
                    empleado.getRol() + " | " +
                    empleado.getCorreo() + " | $" +
                    empleado.getSalario()
            );
        }
    }
}