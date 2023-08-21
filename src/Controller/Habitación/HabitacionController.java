package Controller.Habitación;

import Models.Exceptions.HabitacionOcupadaException;
import Models.Habitación.Habitación;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author abiga
 */

public class HabitacionController {
    private Map<Integer, Habitación> habitaciones;  // Almacena las habitaciones por número

    public HabitacionController() {
        habitaciones = new HashMap<>();
    }

    public void agregarHabitacion(int numero, String tipo) {
        double precioSugerido = obtenerPrecioSugeridoPorTipo(tipo);
        Habitación habitacion = new Habitación(numero, tipo, "Libre", precioSugerido);
        habitaciones.put(numero, habitacion);
    }

    public void actualizarTipoHabitacion(int numero, String nuevoTipo) {
        if (habitaciones.containsKey(numero)) {
            Habitación habitacion = habitaciones.get(numero);
            habitacion.setTipo(nuevoTipo);
        }
    }

   public void eliminarHabitacion(int numero) throws HabitacionOcupadaException {
        if (habitaciones.containsKey(numero)) {
            Habitación habitacion = habitaciones.get(numero);
            if (habitacion.getEstado().equals("Ocupada")) {
                throw new HabitacionOcupadaException(numero);
            }
            habitaciones.remove(numero);
        }
    }

    public List<Habitación> buscarHabitaciones(String tipo) {
        List<Habitación> habitacionesFiltradas = new ArrayList<>();
        for (Habitación habitacion : habitaciones.values()) {
            if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        return habitacionesFiltradas;
    }

    private double obtenerPrecioSugeridoPorTipo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "individual":
                return 45000;
            case "doble":
                return 80000;
            case "suite":
                return 140000;
            default:
                return 0;
        }
    }
}


