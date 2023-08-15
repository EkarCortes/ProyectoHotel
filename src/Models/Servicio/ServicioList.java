/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioList {
 private List<Servicio> servicios;
 public ServicioList() {
 servicios= new ArrayList<>();
    }

    public boolean insert(Servicio servicio) {
        return servicios.add(servicio);
    }

    public boolean update(Servicio servicioActualizado) {
    for (int i = 0; i < servicios.size(); i++) {
        Servicio servicioExistente = servicios.get(i); // Cambia el nombre aquí
        if (servicioExistente.getCodigo() == servicioActualizado.getCodigo()) {
            servicios.set(i, servicioActualizado);
            return true;
        }
    }
    return false;
}

    public boolean delete(Servicio servicio) {
        return servicios.remove(servicio);
    }

    public Servicio search(int codigo) {
        for (Servicio servicio : servicios) {
            if (servicio.getCodigo() == codigo) {
                return servicio;
            }
        }
        return null;
    }

    public Servicio[] toArray() {
        return servicios.toArray(new Servicio[0]);
    }
}
