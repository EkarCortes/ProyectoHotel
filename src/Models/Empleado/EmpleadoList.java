package Models.Empleado;

import Models.List;
import java.util.HashMap;

public class EmpleadoList implements List<Empleado> {

    private static EmpleadoList empleadoList;

    public static EmpleadoList getInstance() {
        if (empleadoList == null) {
            empleadoList = new EmpleadoList();
        }
        return empleadoList;
    }

    private HashMap<String, Empleado> empleados;

    public EmpleadoList() {
        empleados = new HashMap<>();
    }

    @Override
    public boolean insert(Empleado empleado) {
        if (empleado != null && empleado.isComplete()) {
            empleados.put(empleado.getIdentificacion(), empleado);
            showAll(); 
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Empleado empleado) {
        return insert(empleado);
    }

    @Override
    public boolean delete(Empleado empleado) {
        if (empleado != null && empleado.getIdentificacion() != null && !empleado.getIdentificacion().isEmpty()) {
            Empleado removedEmpleado = empleados.remove(empleado.getIdentificacion());
            return removedEmpleado != null;
        }
        return false;
    }

    @Override
    public Empleado search(Object id) {
        if (id instanceof String) {
            return empleados.get(id);
        }
        return null;
    }

    @Override
    public Empleado[] toArray() {
        return empleados.values().toArray(new Empleado[0]);
    }

    public void showAll() {
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados.values()) {
            System.out.println(empleado);
        }
    }

}
