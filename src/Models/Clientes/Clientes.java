package Models.Clientes;

import Models.Entity;
import Models.Persona;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Clientes(String identificacion) {
        super(identificacion, "", ""); 
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
    public int getEdad() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaNacimiento = dateFormat.parse(FechadeNacimiento);
            Date fechaActual = new Date();
            
            long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();
            long yearsInMillis = 1000L * 60L * 60L * 24L * 365L;
            int edad = (int) (diferencia / yearsInMillis);
            
            return edad;
        } catch (Exception e) {
            return -1; }
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
