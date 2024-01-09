package jstorra.bibliotecajuantorra;

public class Revista extends Recurso {
    private int numeroRevista;
    private TipoRevista tipo;
    
    public Revista(int id, String titulo, boolean disponible, int numeroRevista, TipoRevista tipo) {
        super(id, titulo, disponible);
        this.numeroRevista = numeroRevista;
        this.tipo = tipo;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    public TipoRevista getTipo() {
        return tipo;
    }

    public void setTipo(TipoRevista tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Revista{" + "id=" + super.getId() + ", titulo=" + super.getTitulo() + ", disponible=" + super.isDisponible() + ", numeroRevista=" + numeroRevista + ", tipo=" + tipo + '}';
    }
    
}
