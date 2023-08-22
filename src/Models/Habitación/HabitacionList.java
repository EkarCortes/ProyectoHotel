package Models.Habitación;

import Models.List;
import java.util.HashMap;

public class HabitacionList implements List<Habitación> {

    private static HabitacionList habitacionList;

    public static HabitacionList getInstance() {
        if (habitacionList == null) {
            habitacionList = new HabitacionList();
        }
        return habitacionList;
    }

    private HashMap<Integer, Habitación> habitaciones;

    public HabitacionList() {
        habitaciones = new HashMap<>();
    }

    @Override
    public boolean insert(Habitación habitacion) {
        if (habitacion != null && habitacion.isComplete()) {
            habitaciones.put(habitacion.getNumero(), habitacion);
            showAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Habitación habitacion) {
        return insert(habitacion);
    }

    @Override
    public boolean delete(Habitación habitacion) {
        if (habitacion != null) {
            Habitación removedHabitacion = habitaciones.remove(habitacion.getNumero());
            showAll();
            return removedHabitacion != null;
        }
        return false;
    }

    @Override
    public Habitación search(Object id) {
        if (id instanceof Integer) {
            return habitaciones.get(id);
        }
        return null;
    }

    @Override
    public Habitación[] toArray() {
        return habitaciones.values().toArray(new Habitación[0]);
    }

    public void showAll() {
        System.out.println("Lista de habitaciones:");
        for (Habitación habitacion : habitaciones.values()) {
            System.out.println(habitacion);
        }
    }

}
