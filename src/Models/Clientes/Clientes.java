package Models.Clientes;

import Models.Persona;

/**
 *
 * @author abiga
 */
public class Clientes extends Persona{
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
}
