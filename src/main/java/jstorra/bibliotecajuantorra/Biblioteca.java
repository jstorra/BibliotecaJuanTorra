package jstorra.bibliotecajuantorra;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements metodosBiblioteca {
    private List<Recurso> recursos = new ArrayList<>();

    public List<Recurso> getRecursos() {
        return recursos;
    }
    
    @Override
    public void agregarRecurso(Recurso recurso) throws MyException {
        recursos.add(recurso);
        System.out.println("\nMensaje: El recurso se ha agregado.");
        
    }
    
    @Override
    public void prestarRecurso(int id) throws MyException {
        for (Recurso recurso : recursos) {
            if (recurso.getId() == id && !recurso.isDisponible())
                throw new MyException("\nError: El recurso no esta disponible para prestamo.");
            if (recurso.getId() == id) {
                recurso.setDisponible(false);
                System.out.println("\nMensaje: Se ha prestado el recurso.");
                break;
            }
        }
    }

    @Override
    public List<Recurso> buscarRecursoPorTitulo(String titulo) throws MyException {
        List<Recurso> recursosEncontrados = new ArrayList<>();
        boolean existe;
        existe = recursos.stream().anyMatch(recurso -> recurso.getTitulo().equalsIgnoreCase(titulo));

        if (!existe)
            throw new MyException("\nMensaje: No existe recursos con este titulo.");

        for (Recurso recurso : recursos) {
            if (recurso.getTitulo().equalsIgnoreCase(titulo)) {
                recursosEncontrados.add(recurso);
            }
        }
        return recursosEncontrados;
    }
} 