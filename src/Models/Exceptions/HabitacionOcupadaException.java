package Models.Exceptions;

/**
 *
 * @author abiga
 */
public class HabitacionOcupadaException extends Exception {
     public HabitacionOcupadaException(int numeroHabitacion) {
        super("La habitación " + numeroHabitacion + " está ocupada y no puede ser eliminada.");
    }
}
