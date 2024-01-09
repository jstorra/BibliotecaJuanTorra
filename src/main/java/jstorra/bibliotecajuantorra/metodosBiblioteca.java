package jstorra.bibliotecajuantorra;

import java.util.List;

public interface metodosBiblioteca {
    void agregarRecurso(Recurso recurso) throws MyException;
    void prestarRecurso(int id) throws MyException;
    List<Recurso> buscarRecursoPorTitulo(String titulo) throws MyException;
}
