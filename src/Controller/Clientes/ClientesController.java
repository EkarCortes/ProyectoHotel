package Controller.Clientes;

import Models.Clientes.Clientes;
import Models.Clientes.ClientesList;
import View.View;

public class ClienteController {
    private ClientesList list;
    private View view;

    public ClienteController(View view) {
        list = ClientesList.getInstance();
        this.view = view;
    }

    public void insert(Clientes cliente) {
        if (cliente.isComplete()) {
            list.insert(cliente);
            this.readAll();
        } else {
            view.displayErrorMessage("Faltan datos, No se pudo agregar el cliente.");
        }
    }

    public void update(Clientes cliente) {
        if (cliente.isComplete()) {
            list.update(cliente);
            this.readAll();
        } else {
            view.displayErrorMessage("No se puede actualizar el cliente. Faltan datos.");
        }
    }

    public void delete(Clientes cliente) {
        if (list.delete(cliente)) {
            this.readAll();
        } else {
            view.displayErrorMessage("No se puede eliminar el cliente. No se encontró en la lista.");
        }
    }

    public void read(Object id) {
        Clientes cliente = list.search(id);
        if (cliente != null) {
            view.display(cliente);
        } else {
            view.displayErrorMessage("No se encontró el cliente con el ID proporcionado.");
        }
    }

    public void readAll() {
        Clientes[] clientes = list.toArray();
        if (clientes.length > 0) {
            view.displayAll(clientes);
        }
    }
}
