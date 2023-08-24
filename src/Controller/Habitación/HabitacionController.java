package Controller.Habitación;

import Controller.Controller;
import Models.Habitación.Habitación;
import Models.Habitación.HabitacionList;
import View.Search;
import View.View;

/**
 * Controlador para gestionar operaciones relacionadas con habitaciones.
 * 
 * author ekard
 */
public class HabitacionController implements Controller<Habitación> {

    private HabitacionList habitacionList;
    private View <Habitación> view;
    private Search <Habitación> search;

    public HabitacionController(View <Habitación>view) {
        habitacionList = HabitacionList.getInstance();
        this.view = view;   
    }
  

    @Override
public void insert(Habitación habitacion) {
    if (habitacion.isComplete()) {
        // Verificar si la habitación ya existe en la lista
        Habitación existingHabitacion = habitacionList.search(habitacion.getNumero());
        
        if (existingHabitacion == null) {
            habitacionList.insert(habitacion);
        } else {
            // Si la habitación ya existe, actualizar los datos, excepto el número
            existingHabitacion.setTipo(habitacion.getTipo());
            existingHabitacion.setPrecio(habitacion.getPrecio());
        }
        
        //this.readAll();
    } else {
        view.displayErrorMessage("Faltan datos. No se pudo agregar la habitación.");
    }
}

    @Override
    public void update(Habitación habitacion) {
        if (habitacionList.update(habitacion)) {
           // this.readAll();
        } else {
            view.displayErrorMessage("No se puede actualizar la habitación. No se encontró en la lista.");
        }
    } 

    @Override
    public void delete(Habitación habitacion) {
        try {
            habitacionList.delete(habitacion);
           // this.readAll();
            view.displayMessage("Habitación eliminada con éxito.");
       // } catch (HabitacionOcupadaException e) {
         //   view.displayErrorMessaje("No se puede eliminar la habitación. Está ocupada.");
        } catch (IllegalArgumentException e) {
            view.displayErrorMessage("No se puede eliminar la habitación. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object id) {
        Habitación habitacion = habitacionList.search(id);
        if (habitacion != null) {
            view.display(habitacion);
        } else {
            view.displayErrorMessage("No se encontró la habitación con el número proporcionado.");
        }
    }

    @Override
    public void readAll() {
        Habitación[] habitaciones = habitacionList.toArray();
        if (habitaciones.length > 0) {
            search.displayAll(habitaciones);
        }
    }
     public void setSearch(Search<Habitación> search) {
        this.search = search;
    }
}

