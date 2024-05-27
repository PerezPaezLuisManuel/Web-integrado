
package Interfaces;

import Modelo.Persona;
import java.util.List;

public interface CRUD {
    
    //Métodos que realizará la aplicación
    public List listar();
    public Persona list(int id);
    public boolean agregar(Persona per);
    public boolean editar(Persona per);
    public boolean eliminar(int id);
}
