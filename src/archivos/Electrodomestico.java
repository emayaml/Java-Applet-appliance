package archivos;

public class Electrodomestico {

    private int codigo;
    private String nombre;
    private Dimension tam;

    public Electrodomestico(int codigo, String nombre, Dimension tam) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tam = tam;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dimension getTam() {
        return tam;
    }

    public void setTam(Dimension tam) {
        this.tam = tam;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "codigo=" + codigo + ", nombre=" + nombre + ", tam=" + tam + '}';
    }

}
