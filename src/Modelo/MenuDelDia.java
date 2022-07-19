
package Modelo;

//Menu del dia, se actualiza o crea cada dia una diferente lista de menus
public class MenuDelDia {
    
    private int idMenuDelDia;
    private String idAdministrador; // id del administrador que creo el menu del dia
    private static MenuDelDia instancia = null;
    private ListaEs<Producto> listaProductos;
    
    public static MenuDelDia instancia()
    {
        if(instancia==null)
        {
            instancia = new MenuDelDia();
        }
        return instancia;
    }
    
    private MenuDelDia()
    {
        this.listaProductos = new ListaEs<Producto>();
    }

    public static MenuDelDia getInstancia() {
        return instancia;
    }

    public static void setInstancia(MenuDelDia instancia) {
        MenuDelDia.instancia = instancia;
    }

    public ListaEs<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaEs<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getIdMenuDelDia() {
        return idMenuDelDia;
    }

    public void setIdMenuDelDia(int idMenuDelDia) {
        this.idMenuDelDia = idMenuDelDia;
    }
    
    
    
    
    public String getIdAdministrador()
    {
        return this.idAdministrador;
    }
    
    public void setIdAdministrador(String idAdministrador)
    {
        this.idAdministrador = idAdministrador;
    }
    
    public boolean equals(Object obj)
    {
        if(obj==null)
        {
            return false;
        }
        else
        {
            if(obj instanceof MenuDelDia)
            {
                MenuDelDia lm = (MenuDelDia)obj;
                if(this.idMenuDelDia == lm.idMenuDelDia)
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
    
}