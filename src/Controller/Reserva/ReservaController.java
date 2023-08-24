import Controller.Clientes.ClientesController;
import Controller.Habitación.HabitacionController;
import Models.Clientes.Clientes;
import Models.Habitación.Habitación;
import Models.Habitación.TipoHabitacion;
import Models.Reserva.EstadoReserva;
import Models.Reserva.Reserva;
import Models.Reserva.ReservaList;
import View.Search;
import View.View;
import java.time.LocalDate;
import java.util.List;

public class ReservaController {
    private ReservaList reservaList;
    private ClientesController clienteController;
    private HabitacionController habitacionController;
    private View<Reserva> view;
    private Search<Reserva> search;

    public ReservaController(View<Reserva> view, ClientesController clienteController, HabitacionController habitacionController) {
        reservaList = ReservaList.getInstance();
        this.view = view;
        this.clienteController = clienteController;
        this.habitacionController = habitacionController;
    }

    public void reservar(String numeroCedula, TipoHabitacion tipoHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        Clientes cliente = clienteController.buscarClientePorCedula(numeroCedula);
        if (cliente == null) {
            view.displayMessage("Cliente no registrado. Debes registrar al cliente primero.");
            return;
        }

        Habitación habitacionDisponible = habitacionController.obtenerHabitacionDisponible(tipoHabitacion, fechaEntrada, fechaSalida);
        if (habitacionDisponible == null) {
            view.displayErrorMessage("No hay habitaciones disponibles para el tipo y fechas seleccionadas.");
            return;
        }

        int numeroReserva = obtenerProximoNumeroReserva();
        int duracionEstadia = calcularDuracionEstadia(fechaEntrada, fechaSalida);
        double precioTotal = calcularPrecioTotal(habitacionDisponible.getPrecioPorNoche(), duracionEstadia);

        Reserva reserva = new Reserva (cliente, habitacionDisponible, fechaEntrada, fechaSalida, precioTotal, EstadoReserva.PENDIENTE);
        reservaList.insert(reserva);
        view.displayMessage("Reserva creada exitosamente.");
    }

    public void activarReserva(int numeroReserva) {
        Reserva reserva = reservaList.search(numeroReserva);
        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.EN_EJECUCION);
            habitacionController.marcarHabitacionNoDisponible(reserva.getHabitacion());
            view.displayMessage("Reserva activada y habitación marcada como no disponible.");
        } else {
            view.displayErrorMessage("No se puede activar la reserva. Estado incorrecto o no encontrada.");
        }
    }

    public void finalizarReserva(int numeroReserva) {
        Reserva reserva = reservaList.search(numeroReserva);
        if (reserva != null && reserva.getEstado() == EstadoReserva.EN_EJECUCION) {
            reserva.setEstado(EstadoReserva.FINALIZADA);
            habitacionController.marcarHabitacionDisponible(reserva.getHabitacion());
            view.displayMessage("Reserva finalizada y habitación marcada como disponible.");
        } else {
            view.displayErrorMessage("No se puede finalizar la reserva. Estado incorrecto o no encontrada.");
        }
    }

    public void cancelarReserva(int numeroReserva) {
        Reserva reserva = reservaList.search(numeroReserva);
        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.CANCELADA);
            habitacionController.marcarHabitacionDisponible(reserva.getHabitacion());
            view.displayMessage("Reserva cancelada y habitación marcada como disponible.");
        } else {
            view.displayErrorMessage("No se puede cancelar la reserva. Estado incorrecto o no encontrada.");
        }
    }

    public void mostrarReservas() {
        List<Reserva> reservas = reservaList.getAllReservas();
        if (!reservas.isEmpty()) {
            search.displayAll(reservas.toArray(new Reserva[0]));
        } else {
            view.displayMessage("No hay reservas registradas.");
        }
    }

    // Implementar otros métodos necesarios

    private int obtenerProximoNumeroReserva() {
        // Implementar lógica para obtener el próximo número de reserva
    }

    private int calcularDuracionEstadia(LocalDate fechaEntrada, LocalDate fechaSalida) {
        // Implementar lógica para calcular la duración de la estadía en días
    }

    private double calcularPrecioTotal(double precioPorNoche, int duracionEstadia) {
        // Implementar lógica para calcular el precio total de la reserva
    }
}
