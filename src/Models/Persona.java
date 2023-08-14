package Models;

/**
 *
 * @author abiga
 */
public class Persona {
   private String Identificacion;
   private String nombre;
   private String telefono;
   
    public Persona(String identificacion, String nombre, String telefono) {
        this.Identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Persona() {
        this.Identificacion = "";
        this.nombre = "";
        this.telefono = "";
    }

    public Persona(String identificacion, String nombre) {
        this.Identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = "";
    }
}
