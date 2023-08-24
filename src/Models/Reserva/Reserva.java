package Models.Reserva;

import Models.Clientes.Clientes;
import Models.Habitación.Habitación;
import Models.Habitación.TipoHabitacion;
import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private int numeroReserva; // -> Autonúmerico
    private Clientes cliente;
    private Habitación habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double precioTotal;
    private EstadoReserva estado;
    private TipoHabitacion tipoHabitacion;

    public Reserva(Clientes cliente, Habitación habitacion, LocalDate fechaSalida, LocalDate fechaEntrada, double precioTotal, EstadoReserva estado) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
        this.estado = estado;
    }

    

    public Reserva() {
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Habitación getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitación habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
    public boolean isComplete() {
        return numeroReserva > 0 && cliente != null && tipoHabitacion != null
            && fechaEntrada != null && fechaSalida != null && precioTotal > 0.0 && estado != null;
    }
}
