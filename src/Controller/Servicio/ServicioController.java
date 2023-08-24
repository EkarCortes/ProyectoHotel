package Controller.Servicio;

import Controller.Controller;
import Models.Servicio.Servicio;
import Models.Servicio.ServicioSet;
import View.Search;
import View.View;

public class ServicioController implements Controller<Servicio> {
    private ServicioSet servicioSet;
    private View<Servicio> view;
    private Search<Servicio> search;

    public void setSearch(Search<Servicio> search) {
        this.search = search;
        System.out.println("Se ha establecido el objeto Search.");
    }

    public ServicioController(View<Servicio> view) {
        servicioSet = ServicioSet.getInstance();  
        this.view = view;
    }

    @Override
    public void insert(Servicio servicio) {
        if (servicio.isComplete()) {
            servicioSet.insert(servicio); 
            System.out.println("Añadido correctamente: " + servicio.getCodigo());
        } else {
            view.displayErrorMessage("Faltan datos, no se pudo agregar el servicio.");
        }
    }

    @Override
    public void update(Servicio servicioActualizado) {
        if (servicioActualizado.isComplete()) {
            servicioSet.update(servicioActualizado);
            System.out.println("Actualizado correctamente: " + servicioActualizado.getCodigo() + " - " + servicioActualizado.getNombre());
        } else {
            view.displayErrorMessage("No se puede actualizar el servicio. Faltan datos.");
        }
    }

    @Override
    public void delete(Servicio servicio) {
        if (servicioSet.delete(servicio)) { 
            System.out.println("Eliminado correctamente: " + servicio.getCodigo() + " - " + servicio.getNombre());
        } else {
            view.displayErrorMessage("No se puede eliminar el servicio. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object id) {
        Servicio servicio = servicioSet.search((int) id);
        if (servicio != null) {
            view.display(servicio);
        } else {
            view.displayErrorMessage("No se encontró el servicio con el código proporcionado.");
        }
    }

    @Override
    public void readAll() {
     if (search == null) {
        System.out.println("El objeto Search es nulo."); // Agrega esta línea
    }
    
    Servicio[] serviciosArray = servicioSet.toArray();
    if (serviciosArray.length > 0) {
        search.displayAll(serviciosArray);
    }
    }
    public void addNewService(String nombre, String descripcion, double precio) {
        Servicio nuevoServicio = new Servicio(nombre, descripcion, precio);
        insert(nuevoServicio);
    }

    public Servicio getServiceByCode(int code) {
        return servicioSet.search(code); 
    }
}
