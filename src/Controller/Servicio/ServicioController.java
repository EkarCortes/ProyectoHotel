package Controller.Servicio;

import Controller.Controller;
import Models.Servicio.Servicio;
import Models.Servicio.ServicioList;
import View.Search;
import View.View;

public class ServicioController implements Controller<Servicio> {
    private ServicioList servicioList;
    private View<Servicio> view;
    private Search<Servicio> search;

    public void setSearch(Search<Servicio> search) {
        this.search = search;
    }
    
    

    public ServicioController(View<Servicio> view) {
        servicioList = ServicioList.getInstance();
        this.view = view;
    }

    @Override
    public void insert(Servicio servicio) {
        if (servicio.isComplete()) {
        servicioList.insert(servicio);
            System.out.println("Añadido correctamente: " + servicio.getCodigo());
    } else {
        view.displayErrorMessage("Faltan datos, no se pudo agregar el servicio.");
    }
}

    @Override
    public void update(Servicio servicioActualizado) {
        if (servicioActualizado.isComplete()) {
            servicioList.update(servicioActualizado);
            System.out.println("Actualizado correctamente: " + servicioActualizado.getCodigo() + " - " + servicioActualizado.getNombre());
        } else {
            view.displayErrorMessage("No se puede actualizar el servicio. Faltan datos.");
        }
    }

    @Override
    public void delete(Servicio servicio) {
         if (servicioList.delete(servicio)) {
            System.out.println("Eliminado correctamente: " + servicio.getCodigo() + " - " + servicio.getNombre());
            //view.displayAll(servicioList.toArray()); 
        } else {
            view.displayErrorMessage("No se puede eliminar el servicio. No se encontró en la lista.");
        }
    }
    
    @Override
    public void read(Object id) {
        Servicio servicio = servicioList.search((int) id);
        if (servicio != null) {
            view.display(servicio);
        } else {
            view.displayErrorMessage("No se encontró el servicio con el código proporcionado.");
        }
    }

    @Override
    public void readAll() {
        Servicio[] serviciosArray = servicioList.toArray();
        if (serviciosArray.length > 0) {
            search.displayAll(serviciosArray);
        }
    }
    public void addNewService(String nombre, String descripcion, double precio) {
    Servicio nuevoServicio = new Servicio(nombre, descripcion, precio);
    insert(nuevoServicio);
}
    public Servicio getServiceByCode(int code) {
        return servicioList.search(code);
    }
 
}
