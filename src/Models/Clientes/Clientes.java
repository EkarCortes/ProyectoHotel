package Models.Clientes;

import Models.Entity;
import Models.Persona;
import java.util.Date;

/**
 *
 * @author abiga
 */
public class Clientes extends Persona implements Entity{
    private Date fechaNacimiento;
    private String Correo;
    
    public Clientes(String identificacion, String nombre, String telefono, Date fechaDeNacimiento, String correo) {
        super(identificacion, nombre, telefono); 
        this.fechaNacimiento = fechaDeNacimiento;
        this.Correo = correo;
    }

    public Clientes(String identificacion) {
        super(identificacion, "", ""); 
    }

    public Clientes(String identificacion, String nombre, Date fechaDeNacimiento) {
        super(identificacion, nombre); 
        this.fechaNacimiento = fechaDeNacimiento;
        this.Correo = "";
    }

    public Clientes(int identificacion, String nombre, int telefono, Date fechaNacimiento, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public Date getFechaDeNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaNacimiento = fechaDeNacimiento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }
    public int getEdad() {
        Date fechaActual = new Date();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaActual.getMonth() < fechaNacimiento.getMonth()
                || (fechaActual.getMonth() == fechaNacimiento.getMonth()
                && fechaActual.getDay() < fechaNacimiento.getDay())) {
            edad--;
        }
        return edad;
    }
    @Override
    public boolean isComplete() {
        return !getIdentificacion().isEmpty() && !getNombre().isEmpty();
    }


    @Override
   public Object[] toArrayObject() {
    return new Object[] {
        getIdentificacion(),
        getNombre(),
        getTelefono(),
        fechaNacimiento,
        getEdad(), // Incluir la edad aquí, ya que getEdad() devuelve la edad correctamente
        Correo
    };
}
}





