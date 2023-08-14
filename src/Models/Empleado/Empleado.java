package Models.Empleado;

import Models.Persona;

public class Empleado extends Persona {
    private Puesto puesto;
    private double salario;

    public Empleado(String identificacion, String nombre, String telefono, Puesto puesto) {
        super(identificacion, nombre, telefono);
        this.puesto = puesto;
        this.salario = puesto.getSalario();
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
    public boolean isComplete() {
        return getIdentificacion() != null && !getIdentificacion().isEmpty();
    }

    public Object[] toArrayObject() {
        return new Object[] { getIdentificacion(), getNombre(), getPuesto(), getSalario() };
    }

}

    