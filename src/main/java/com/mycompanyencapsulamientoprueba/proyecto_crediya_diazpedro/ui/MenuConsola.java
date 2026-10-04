/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.ui;

import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.model.Cliente;
import com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.service.ClienteService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class MenuConsola {
    private final Scanner scanner;
    private final ClienteService clienteService;

    public MenuConsola() {
        scanner = new Scanner(System.in);
        clienteService = new ClienteService();
    }

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n===== CREDIYA =====");
            System.out.println("1. Clientes");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuClientes();
                    break;

                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 2);
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
}
