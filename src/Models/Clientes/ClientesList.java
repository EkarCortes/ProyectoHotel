package Models.Clientes;

import Models.List;
import java.util.HashMap;

public class ClientesList implements List<Clientes> {

    private static ClientesList clientesList;

    public static ClientesList getInstance(){
        if(clientesList==null){
            clientesList = new ClientesList();
        }
        return clientesList;
    }

    private HashMap<String, Clientes> clientes; 

    private ClientesList() {
        clientes = new HashMap<>();
    }

    @Override
    public boolean insert(Clientes obj) {
        if (obj != null && obj.getIdentificacion() != null && !obj.getIdentificacion().isEmpty()) {
           clientes.put(obj.getIdentificacion(), obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Clientes obj) {
        return insert(obj);
    }

    @Override
    public boolean delete(Clientes obj) {
        if (obj != null && obj.getIdentificacion() != null && !obj.getIdentificacion().isEmpty()) {
            Clientes removedMember = clientes.remove(obj.getIdentificacion());
            return removedMember != null;
        }
        return false;
    }

    @Override
    public Clientes search(Object id) {
        if (id instanceof String) {
            return clientes.get(id);
        }
        return null;
    }

    @Override
    public Clientes[] toArray() {
        return clientes.values().toArray(new Clientes[0]);
    }

    public void showAll(){
        for (Clientes clientes : clientes.values()){
            System.out.println(clientes);
        }
    }
}
