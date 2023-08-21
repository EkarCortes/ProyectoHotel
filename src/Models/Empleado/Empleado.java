package Models.Empleado;

import Models.Entity;
import Models.Persona;

public class Empleado extends Persona implements Entity{
    private Puesto puesto;
    private double salario;

    public Empleado(String identificacion, String nombre, String telefono, Puesto puesto) {
        super(identificacion, nombre, telefono);
        this.puesto = puesto;
        this.salario = puesto.getSalario();
    }

    public Empleado(String identificacion, String nombre, String telefono,Puesto puesto, double salario) {
        super(identificacion, nombre, telefono);
        this.puesto = puesto;
        this.salario = salario;
    }

    public Empleado(String identificacion) {
        super(identificacion,"","");
    }
    
    

    public Puesto getPuesto() { 
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
        this.salario = puesto.getSalario();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    //CAMBIAR
    @Override
    public boolean isComplete() {
        return getIdentificacion() != null && !getIdentificacion().isEmpty();
    }
    //CAMBIAR
    @Override
    public Object[] toArrayObject() {
        return new Object[] { getIdentificacion(), getNombre(),getTelefono(), getPuesto(), getSalario() };
    }
    
      @Override
    public String toString() {
        return "Empleado{" +
                super.toString() +
                ", puesto=" + puesto +
                ", salario=" + getSalario() +
                '}';
    }
}



    