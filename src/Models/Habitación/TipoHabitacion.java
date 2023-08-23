package Models.Habitación;

/**
 *
 * @author abiga
 */
public enum TipoHabitacion {
    INDIVIDUAL(45000),
    DOBLE(80000),
    SUITE(140000);

    private final double precio;

    TipoHabitacion(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
