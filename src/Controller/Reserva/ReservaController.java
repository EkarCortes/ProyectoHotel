package Controller.Reserva;

import Controller.Clientes.ClientesController;
import Controller.Habitación.HabitacionController;
import Models.Clientes.Clientes;
import Models.Habitación.TipoHabitacion;
import Models.Reserva.EstadoReserva;
import Models.Reserva.Reserva;
import Models.Reserva.ReservaList;
import View.Search;
import View.View;
import java.time.LocalDate;

public class ReservaController  {
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

    public ReservaController(View<Reserva> view) {
         reservaList = ReservaList.getInstance();
        this.view = view;
    }
 
 

  public void insert(String cedulaCliente, TipoHabitacion tipoHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
     Clientes cliente = clienteController.buscarClientePorCedula(cedulaCliente);
    
    if (cliente != null) {
        // Calcular el precio total
        double total = reservaList.calcularPrecioTotal(tipoHabitacion, fechaEntrada, fechaSalida);
        
        // Crear una nueva reserva
        Reserva reserva = new Reserva(cliente, fechaEntrada, fechaSalida, total, EstadoReserva.PENDIENTE);
        
        // Agregar la reserva a la lista
        reservaList.insert(reserva);
        
        // Mostrar mensaje de éxito
        view.displayMessage("Reserva realizada exitosamente. Número de reserva: " + reserva.getNumeroReserva());
    } else {
        view.displayErrorMessage("El cliente no está registrado. Debes registrar al cliente primero.");
    }
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


     
}
   

