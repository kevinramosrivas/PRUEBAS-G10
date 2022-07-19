package Modelo;


public class Producto {
    
    private int idProducto;
    private String nombre;
    private float precio;
    private int cantidad;
    private int idOrdenCompra;
    private int idCliente;
    private int idCategoria;
    
    
    public Producto(String nombre, float precio)
    {
        this.nombre = nombre;
        this.precio = precio;
    }
    
   
    
    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }
    
    
    
    public float getPrecio()
    {
        return this.precio;
    }
    
    public void setPrecio(float precio)
    {
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
    public boolean equals(Object obj)
    {
        if(obj==null)
        {
            return false;
        }
        else
        {
            if(obj instanceof Producto)
            {
                Producto p = (Producto) obj;
                if(this.nombre.equals(p.nombre))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
    
    public String toString()
    {
        return "nombre: "+this.nombre+
                ", precio: "+this.precio;
    }
}
