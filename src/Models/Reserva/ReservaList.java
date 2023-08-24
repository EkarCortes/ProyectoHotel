/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Reserva;

import Models.Habitación.TipoHabitacion;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wendy
 */
public class ReservaList {
     private static ReservaList instance;
    private List<Reserva> reservas;

    private ReservaList() {
        reservas = new ArrayList<>();
    }

    public static ReservaList getInstance() {
        if (instance == null) {
            instance = new ReservaList();
        }
        return instance;
    }

    public boolean insert(Reserva reserva) {
        int newCode = getNextAvailablenumber();
        reserva.setNumeroReserva(newCode);
        return reservas.add(reserva);

    }

    public Reserva search(int numeroReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroReserva() == numeroReserva) {
                return reserva;
            }
        }
        return null;
    }

    public void update(Reserva reservaActualizada) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getNumeroReserva() == reservaActualizada.getNumeroReserva()) {
                reservas.set(i, reservaActualizada);
                break;
            }
        }
    }


     private int getNextAvailablenumber() {
        int maxCode = 0;
        for (Reserva reserva : reservas) {
            maxCode = Math.max(maxCode, reserva.getNumeroReserva());
        }
        return maxCode + 1;
    }

     public double calcularPrecioTotal(TipoHabitacion tipoHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
    
    long duracion = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);

    // Calcular el precio por noche según el tipo de habitación
    double precioPorNoche = 0.0;
    switch (tipoHabitacion) {
        case INDIVIDUAL -> precioPorNoche = 45000.0;
        case DOBLE -> precioPorNoche = 80000.0;
        case SUITE -> precioPorNoche = 140000.0;
    }

    // Calcular el precio total
    double subtotal = precioPorNoche * duracion;
    double impuestos = subtotal * 0.13; // Suponiendo una tasa de impuestos del 13%
    double total = subtotal + impuestos;
    
    return total;
}
}
