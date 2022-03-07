
package logica;

import persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearPersona(Persona pers){
        controlPersis.crearPersona(pers);
    }
    
    public void eliminarPersona(int id){
        controlPersis.eliminarPersona(id);
    }
    
    public void eliminarPersona(Persona pers){
        controlPersis.eliminarPersona(pers);
    }
    
    public List<Persona> traerPersonas(){
        return controlPersis.traerPersonas();
    }
    
    
    
}
