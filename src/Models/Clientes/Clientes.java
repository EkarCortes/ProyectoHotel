package Models.Clientes;

import Models.Entity;
import Models.Persona;

/**
 *
 * @author abiga
 */
public class Clientes extends Persona implements Entity{
    private String FechadeNacimiento;
    private String Correo;
    
    public Clientes(String identificacion, String nombre, String telefono, String fechaDeNacimiento, String correo) {
        super(identificacion, nombre, telefono); 
        this.FechadeNacimiento = fechaDeNacimiento;
        this.Correo = correo;
    }

    public Clientes() {
        super(); 
        this.FechadeNacimiento = "";
        this.Correo = "";
    }

    public Clientes(String identificacion, String nombre, String fechaDeNacimiento) {
        super(identificacion, nombre); 
        this.FechadeNacimiento = fechaDeNacimiento;
        this.Correo = "";
    }
     public String getFechaDeNacimiento() {
        return FechadeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.FechadeNacimiento = fechaDeNacimiento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    @Override
    public boolean isComplete() {
        return !getIdentificacion().isEmpty() && !getNombre().isEmpty() && !FechadeNacimiento.isEmpty();
    }


    @Override
    public Object[] toArrayObject() {
        return new Object[] {getIdentificacion(), getNombre(), getTelefono(), FechadeNacimiento, Correo};
    }
}
