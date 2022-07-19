package Modelo;


public class Usuario {
    private String nombre;
    private String usuario;//es el usuario al crearse una cuenta
    private String password;
    

    public Usuario(String nombre, String usuario, String password) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    
        
    public String getNombre()
    {
        return nombre;
    }    
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}
