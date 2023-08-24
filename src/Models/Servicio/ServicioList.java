
package Models.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioList {
 private static ServicioList servicioList;
 private List<Servicio> servicios;
 public ServicioList() {
 servicios= new ArrayList<>();
    }
  public static ServicioList getInstance() {
        if (servicioList == null) {
            servicioList = new ServicioList();
        }
        return servicioList;
    }

    public boolean insert(Servicio servicio) {
    int newCode = getNextAvailableCode(); 
    servicio.setCodigo(newCode); 
        return servicios.add(servicio);
    }

    public boolean update(Servicio servicioActualizado) {
    for (int i = 0; i < servicios.size(); i++) {
        Servicio servicioExistente = servicios.get(i); 
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
    private int getNextAvailableCode() {
        int maxCode = 0;
        for (Servicio servicio : servicios) {
            maxCode = Math.max(maxCode, servicio.getCodigo());
        }
        return maxCode + 1; 
    }

}
