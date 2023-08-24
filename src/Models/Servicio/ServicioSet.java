
package Models.Servicio;

import java.util.HashSet;
import java.util.Set;
public class ServicioSet {
 private static ServicioSet servicioSet;
    private Set<Servicio> servicios;
    private ServicioSet() {
        servicios = new HashSet<>();
    }
    public static ServicioSet getInstance() {
        if (servicioSet == null) {
            servicioSet = new ServicioSet();
        }
        return servicioSet;
    }

    public boolean insert(Servicio servicio) {
        int newCode = getNextAvailableCode();
        servicio.setCodigo(newCode);
        return servicios.add(servicio);
    }

    public boolean update(Servicio servicioActualizado) {
        for (Servicio servicioExistente : servicios) {
            if (servicioExistente.getCodigo() == servicioActualizado.getCodigo()) {
                servicios.remove(servicioExistente);
                servicios.add(servicioActualizado);
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

    private int getNextAvailableCode() {
        int maxCode = 0;
        for (Servicio servicio : servicios) {
            maxCode = Math.max(maxCode, servicio.getCodigo());
        }
        return maxCode + 1;
    }
}
