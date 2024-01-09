package jstorra.bibliotecajuantorra;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        Biblioteca miBiblioteca = new Biblioteca();
        
        int contador = 1;
        
        while (true) {
            System.out.println("\n----------- Menu Biblioteca -----------");
            System.out.println("""
                               
                               Escoge el apartado:
                               1. Agregar revista
                               2. Agregar libro
                               3. Buscar recurso
                               4. Prestar recurso
                               5. Salir
                               """);
            System.out.print("Opcion: ");
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                try {
                    if (opcion == 5) {
                        System.out.println("Saliendo...");
                        break;
                    }
                    if (opcion == 1) {
                        System.out.println("\n----------- AGREGAR REVISTA -----------\n");
                        
                        System.out.print("Ingresa el titulo: ");
                        String tituloRevista = scanner.nextLine();
                        
                        System.out.print("Ingrese el numero de revista: ");
                        int numeroRevista = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("""
                                           
                                           Seleccione el tipo de revista: 
                                           1. Deporte
                                           2. Geografia
                                           3. Astronomia
                                           4. Ciencia
                                           5. Matematicas
                                           """);
                        
                       
                        int tipoRevistaNum = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (tipoRevistaNum < 1 || tipoRevistaNum > 5)
                            throw new MyException("\nError: La opción ingresada no es valida.");
                        
                        TipoRevista tipoRevista = null;
                        
                        if (tipoRevistaNum == 1) {
                            tipoRevista = TipoRevista.DEPORTE;
                            System.out.println(tipoRevista);
                        } else if (tipoRevistaNum == 2) {
                            tipoRevista = TipoRevista.GEOGRAFIA;
                        } else if (tipoRevistaNum == 2) {
                            tipoRevista = TipoRevista.ASTRONOMIA;
                        } else if (tipoRevistaNum == 2) {
                            tipoRevista = TipoRevista.CIENCIA;
                        } else if (tipoRevistaNum == 2) {
                            tipoRevista = TipoRevista.MATEMATICAS;
                        }
                        
                        miBiblioteca.agregarRecurso(new Revista(contador, tituloRevista, true, numeroRevista, tipoRevista));
                        contador++;
                        
                    } else if (opcion == 2) {
                        System.out.println("\n----------- AGREGAR LIBRO -----------\n");
                        
                        System.out.print("Ingresa el titulo: ");
                        String tituloLibro = scanner.nextLine();
                        
                        System.out.print("Ingrese el autor del libro: ");
                        String autorLibro = scanner.nextLine();
                        
                        miBiblioteca.agregarRecurso(new Libro(contador, tituloLibro, true, autorLibro));
                        contador++;
                        
                    } else if (opcion == 3) {
                        System.out.println("\n----------- BUSCAR RECURSO -----------\n");
                        System.out.print("Ingrese el titulo del recurso a buscar: ");
                        String tituloBuscar = scanner.nextLine();
                        
                        List<Recurso> recursosEncontrados = new ArrayList<>();
                        recursosEncontrados = miBiblioteca.buscarRecursoPorTitulo(tituloBuscar);
                        
                        System.out.println("\nRECURSOS ENCONTRADOS:\n");
                        for (Recurso recurso : recursosEncontrados) {
                            System.out.println("- " + recurso);
                        }
                        
                    } else if (opcion == 4) {
                        if (miBiblioteca.getRecursos().isEmpty())
                            throw new MyException("\nMensaje: No hay ningun recurso registrado.");
                        
                        System.out.println("\n----------- PRESTAR RECURSO -----------\n");
                        
                        System.out.println("RECURSOS REGISTRADOS:");
                        for (Recurso recurso : miBiblioteca.getRecursos()) {
                            System.out.println(recurso.getId() + ". Titulo: " + recurso.getTitulo() + " Disponible: " + recurso.isDisponible());
                        }
                        
                        System.out.print("\nIngrese el numero segun el recurso a prestar: ");
                        int seleccion = scanner.nextInt();
                        
                        if (seleccion < 1 || seleccion > miBiblioteca.getRecursos().size())
                            throw new MyException("\nError: No existe un recurso con ese ID.");
                        
                        miBiblioteca.prestarRecurso(seleccion);
                        
                    } else {
                        throw new MyException("\nError: La opción ingresada no es valida.");
                    }
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: El valor ingresado no es valido.");
            }
        }
    }
}
