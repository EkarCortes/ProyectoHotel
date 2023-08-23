package Controller.Clientes;

import Controller.Controller;
import Models.Clientes.Clientes;
import Models.Clientes.ClientesList;
import View.Search;
import View.View;

public class ClientesController implements Controller<Clientes> {
    private ClientesList list;
    private View <Clientes> view;
    private Search <Clientes> search;

    public ClientesController(View<Clientes> view) {
        list = ClientesList.getInstance();
        this.view = view;
    }

    @Override
    public void insert(Clientes cliente) {
        if (cliente.isComplete()) {
            list.insert(cliente);
        } else {
            view.displayErrorMessage("Faltan datos, No se pudo agregar el cliente.");
        }
    }

    @Override
    public void update(Clientes cliente) {
        if (cliente.isComplete()) {
            list.update(cliente);
        } else {
            view.displayErrorMessage("No se puede actualizar el cliente. Faltan datos.");
        }
    }

    @Override
    public void delete(Clientes cliente) {
        if (list.delete(cliente)) {
        } else {
            view.displayErrorMessage("No se puede eliminar el cliente. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object id) {
        Clientes cliente = list.search(id);
        if (cliente != null) {
            view.display(cliente);
        } else {
            view.displayErrorMessage("No se encontró el cliente con el ID proporcionado.");
        }
    }

    @Override
    public void readAll() {
        Clientes[] clientes = list.toArray();
        if (clientes.length > 0) {
            search.displayAll(clientes);
        }
        
    }
    public void setSearch(Search<Clientes> search) {
        this.search = search;
    }
    
}
