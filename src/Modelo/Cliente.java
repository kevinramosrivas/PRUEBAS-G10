package Modelo;


public class Cliente extends Usuario {
                                      
    private int idCliente;
    private OrdenCompra orden;
    
    
    public Cliente(String nombre,String usuario,String password)
    {
        super(nombre,usuario,password);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public OrdenCompra getOrden() {
        return orden;
    }

    public void setOrden(OrdenCompra orden) {
        this.orden = orden;
    }
    
    public boolean equals(Object obj)
    {
        if(obj==null)
        {
            return false;
        }
        else
        {
            if(obj instanceof Cliente)
            {
                Cliente cl = (Cliente)obj;
                if(this.getUsuario().equals(cl.getUsuario()))
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
        return super.toString()+"idCliente: "+this.idCliente;
    }
    
}
