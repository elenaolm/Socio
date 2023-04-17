/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10.SOCIO;

/**
 *
 * @author Elena Oliva
 */
import java.time.LocalDate;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Club club = new Club();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Listado por DNI");
            System.out.println("5. Listado por antigüedad");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el DNI del socio: ");
                    String dni = scanner.next();
                    System.out.print("Ingrese el nombre del socio: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese la fecha de alta (formato: AAAA-MM-DD): ");
                    String fecha = scanner.next();
                    LocalDate fechaAlta = LocalDate.parse(fecha);
                    club.alta(new Socio(dni, nombre, fechaAlta));
                    break;
                case 2:
                    System.out.print("Ingrese el DNI del socio a dar de baja: ");
                    dni = scanner.next();
                    club.baja(dni);
                    break;
                case 3:
                    System.out.print("Ingrese el DNI del socio a modificar: ");
                    dni = scanner.next();
                    System.out.print("Ingrese el nuevo nombre del socio: ");
                    nombre = scanner.next();
                    System.out.print("Ingrese la nueva fecha de alta (formato: AAAA-MM-DD): ");
                    fecha = scanner.next();
                    fechaAlta = LocalDate.parse(fecha);
                    club.modificar(new Socio(dni, nombre, fechaAlta));
                    break;
                case 4:
                    System.out.println("Listado de socios por DNI:");
                    for (Socio socio : club.listarPorDNI()) {
                        System.out.println("DNI: " + socio.getDni() + ", Nombre: " + socio.getNombre() + ", Fecha de alta: " + socio.getFechaAlta());
                    }
                    break;
                case 5:
                    System.out.println("Listado de socios por antigüedad:");
                    for (Socio socio : club.listarPorAntiguedad()) {
                        System.out.println("DNI: " + socio.getDni() + ", Nombre: " + socio.getNombre() + ", Fecha de alta: " + socio.getFechaAlta());
                    }
                    break;
                case 6:
                    club.guardarSocios();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
