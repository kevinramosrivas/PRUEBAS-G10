package Modelo;



public class ListaEs<T> {
    
    
    public class Nodo<T>{
        public Nodo<T> sgte;
        public T elemento;
        
        public Nodo(T elemento)
        {
            this.elemento = elemento;
            this.sgte = null;
        }
    }
    
    public Nodo<T> padre;
    public int cantidad;
    
    public ListaEs()
    {
        this.padre = null;
        cantidad = 0;
    }
    
    public Nodo<T> crearNodo(T elemento)
    {
        Nodo<T> nodo = new Nodo<T>(elemento);
        return nodo;
    }
    
    public void insertarInicio(T elemento)
    {
        Nodo<T> nodo = crearNodo(elemento);
        if(padre==null)
        {
            padre = nodo;
            cantidad++;
            System.out.println("elemento agregado");
        }
        else
        {
            nodo.sgte = padre;
            padre = nodo;
            cantidad++;
            System.out.println("elemento agregado");
        }
    }
    
    public void insertarFinal(T elemento)
    {
        Nodo<T> nodo = crearNodo(elemento);
        if(padre==null)
        {
            padre=nodo;
            cantidad++;
            System.out.println("elemento agregado");
        }
        else
        {
            Nodo<T> aux = padre;
            while(aux.sgte!=null)
            {
                aux = aux.sgte;
            }
            aux.sgte = nodo;
            cantidad++;
            System.out.println("elemento agregado");
        }
    }
    
    public void insertarPorPosisicion(T elemento,int posicion)
    {
        
    }
    
    /*public T devolverElementoPorId(int pos)
    {
        
    }*/
    
    
    public boolean existeElemento(T elemento)
    {
        Nodo<T> aux = padre;
        boolean existe = false;
        while(aux!=null)
        {
            if(aux.elemento.equals(elemento))
            {
                existe = true;
                break;
            }
            aux = aux.sgte;
        }
        return existe;
    }
    
    public void borrarElementoConRepeticion(T elemento)
    {
        if(padre == null)
        {
            System.out.println("lista vacia");
        }
        else
        {
            if(existeElemento(elemento))
            {
                Nodo<T> auxEliminar = padre;
                Nodo<T> auxAnterior = null;
                while(auxEliminar!=null && existeElemento(elemento))
                {
                    if(auxEliminar.elemento.equals(elemento))
                    {
                        if(auxEliminar == padre)
                        {
                            auxEliminar = auxEliminar.sgte;
                            padre = auxEliminar;
                            cantidad--;
                            System.out.println("elemento eliminado");
                        }
                        else
                        {
                            auxAnterior.sgte = auxEliminar.sgte;
                            auxEliminar = auxEliminar.sgte;
                            cantidad--;
                            System.out.println("elemento eliminado");
                            
                        }
                    }
                    else
                    {
                        auxAnterior = auxEliminar;
                        auxEliminar = auxEliminar.sgte;
                    }
                }
            }
            else
            {
                System.out.println("elemento no existe");
            }
        }
    }
    
    public void borrarElementoUnaVez(T elemento)
    {
        if(padre == null)
        {
            System.out.println("lista vacia");
        }
        else
        {
            if(existeElemento(elemento))
            {
                Nodo<T> auxEliminar = padre;
                Nodo<T> auxAnterior = null;
                while(auxEliminar!=null)
                {
                    if(auxEliminar.elemento.equals(elemento))
                    {
                        if(auxEliminar == padre)
                        {
                            auxEliminar = auxEliminar.sgte;
                            padre = auxEliminar;
                            cantidad--;
                            System.out.println("elemento eliminado");
                            break;
                        }
                        else
                        {
                            auxAnterior.sgte = auxEliminar.sgte;
                            auxEliminar = auxEliminar.sgte;
                            cantidad--;
                            System.out.println("elemento eliminado");
                            break;
                        }
                    }
                    else
                    {
                        auxAnterior = auxEliminar;
                        auxEliminar = auxEliminar.sgte;
                    }
                }
            }
            else
            {
                System.out.println("elemento no existe");
            }
        }
    }
    
    public void borrarPorPosicion(int pos)
    {
        
    }
    
    public void eliminarTodo()
    {
        padre = null;
        cantidad = 0;
        System.out.println("lista vacia");
    }
    
    public void mostrarLista()
    {
        if(padre==null)
        {
            System.out.println("lista vacia");
        }
        else
        {
            Nodo<T> aux = padre;
            int i = 0;
            while(aux!=null)
            {
                i++;
                System.out.println("elemento "+i+": "+aux.elemento);
                aux = aux.sgte;
            }
        }
    }
}
