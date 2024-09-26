/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprograll24grupo5a;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class login {
    public void acceder(String usuario, String contra) {
        conexion miconexion = new conexion();
        Connection conn = null;

        try {
            conn = miconexion.getConnection();

            String sql = "SELECT usuario_id, correo, nombre FROM Usuarios WHERE nombre = '" + usuario + "' AND contraseña = HashBytes('MD5', '" + contra + "')";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt("usuario_id");
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                System.out.println("Sesión iniciada: ID: " + id + ", correo: " + correo + ", nombre: " + nombre);
                
                mostrarMenuCRUD();
            } else {
                System.out.println("Credenciales Incorrectas.");
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            miconexion.closeConnection(conn);
        }
    }

    private void mostrarMenuCRUD() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("QUE OPCION DESEAS HACER EN TU SISTEMA");
            System.out.println("1. Crear");
            System.out.println("2. Leer");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Crear un nuevo registro (implementación pendiente).");
                    break;
                case 2:
                    System.out.println("Leer registros (implementación pendiente).");
                    break;
                case 3:
                    System.out.println("Actualizar un registro (implementación pendiente).");
                    break;
                case 4:
                    System.out.println("Eliminar un registro (implementación pendiente).");
                    break;
                case 5:
                    continuar = false;  
                    gestionarSalida();  
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

   private void gestionarSalida() {
    Scanner scanner = new Scanner(System.in);
    boolean salir = true;

    while (salir) {
        System.out.println("¿Qué deseas Realizar Ahora?");
        System.out.println("1. Regresar al menú del CRUD");
        System.out.println("2. Volver al inicio de sesión");
        System.out.println("3. Salir del sistema");
        System.out.print("Seleccione una opción: ");
        
        int opcionSalida = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcionSalida) { 
            case 1:
                System.out.println("Regresando al menú CRUD.");
                salir = false;  
                mostrarMenuCRUD();  
                break;
            case 2:
                System.out.println("Haz vuelto al inicio de sesion");

                salir = false;  
                ProyectoPrograll24Grupo5A menu = new ProyectoPrograll24Grupo5A();
                menu.mostrarMenu(); 
                break;
            case 3:
                System.out.println("Saliendo del Sistema,Gracias por utilizar nuestro sistema  ");
                System.exit(0);  
            default:
                System.out.println("Opción incorrecta . Intente de nuevo.");
        }
    }
   }
}
