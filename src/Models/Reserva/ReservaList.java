/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Reserva;

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

    public void insert(Reserva reserva) {
        reservas.add(reserva);
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

    public void delete(Reserva reserva) {
        reservas.remove(reserva);
    }

    // Otros métodos para manipulación de la lista
    // ...
}
