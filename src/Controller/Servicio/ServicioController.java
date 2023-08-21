package Controller.Servicio;

import Controller.Controller;
import Models.Servicio.Servicio;
import Models.Servicio.ServicioList;
import View.View;

public class ServicioController implements Controller<Servicio> {
    private ServicioList servicioList;
    private View<Servicio> view;

    public ServicioController(View<Servicio> view) {
        servicioList = ServicioList.getInstance();
        this.view = view;
    }

    @Override
    public void insert(Servicio servicio) {
        if (servicio.isComplete()) {
            servicioList.insert(servicio);
            view.displayAll(servicioList.toArray());
        } else {
            view.displayErrorMessaje("Faltan datos, no se pudo agregar el servicio.");
        }
    }

    @Override
    public void update(Servicio servicioActualizado) {
        if (servicioActualizado.isComplete()) {
            servicioList.update(servicioActualizado);
            view.displayAll(servicioList.toArray());
        } else {
            view.displayErrorMessaje("No se puede actualizar el servicio. Faltan datos.");
        }
    }

    @Override
    public void delete(Servicio servicio) {
        if (servicioList.delete(servicio)) {
            view.displayAll(servicioList.toArray());
        } else {
            view.displayErrorMessaje("No se puede eliminar el servicio. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object id) {
        Servicio servicio = servicioList.search(id);
        if (servicio != null) {
            view.display(servicio);
        } else {
            view.displayErrorMessaje("No se encontró el servicio con el código proporcionado.");
        }
    }

    @Override
    public void readAll() {
        Servicio[] serviciosArray = servicioList.toArray();
        if (serviciosArray.length > 0) {
            view.displayAll(serviciosArray);
        }
    }
}
