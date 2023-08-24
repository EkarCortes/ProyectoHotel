/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Empleado;

import Controller.Controller;
import Models.Empleado.Empleado;
import Models.Empleado.EmpleadoList;
import View.Search;
import View.View;

/**
 *
 * @author ekard
 */

public class EmpleadoController implements Controller<Empleado> {

    private EmpleadoList empleadoList;
    private View <Empleado> view;
    private Search <Empleado> search;

    public EmpleadoController(View<Empleado> view) {
        empleadoList = EmpleadoList.getInstance();
        this.view = view;   
    }

    @Override
    public void insert(Empleado empleado) {
        if (empleado.isComplete()) {
            empleadoList.insert(empleado);
           // this.readAll();
        } else {
            view.displayErrorMessage("Faltan datos. No se pudo agregar el empleado.");
        }
    }

    @Override
    public void update(Empleado empleado) {
        if (empleado.isComplete()) {
            empleadoList.update(empleado);
            //this.readAll();
        } else {
            view.displayErrorMessage("No se puede actualizar el empleado. Faltan datos.");
        }
    }

    @Override
    public void delete(Empleado empleado) {
        if (empleadoList.delete(empleado)) {
           // this.readAll();
        } else {
            view.displayErrorMessage("No se puede eliminar el empleado. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object identificacion) {
        Empleado empleado = empleadoList.search(identificacion);
        if (empleado != null) {
            view.display(empleado);
        } else {
            view.displayErrorMessage("No se encontró el empleado con la identificación proporcionada.");
        }
    }

    @Override
    public void readAll() {
        Empleado[] empleados = empleadoList.toArray();
        if (empleados.length > 0) {
            search.displayAll(empleados);
        }
    }
     public void setSearch(Search<Empleado> search) {
        this.search = search;
    }

}
