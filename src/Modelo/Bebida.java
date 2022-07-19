package Modelo;


public class Bebida extends Producto{
    
    private String descripcion;
    
    public Bebida (String nombre,float precio)
    {
        super(nombre,precio);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    public String toString()
    {
        return super.toString();
    }
    
}
