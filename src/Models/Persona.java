package Models;

/**
 *
 * @author abiga
 */
public abstract class Persona {
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
    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.Identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

