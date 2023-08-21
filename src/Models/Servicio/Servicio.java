/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Servicio;

public class Servicio {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;

    public Servicio(int codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Precio: " + precio;
    }

    public boolean isComplete() {
        return codigo > 0 && !nombre.isEmpty() && !descripcion.isEmpty();
    }

    public Object[] toArrayObject() {
        return new Object[]{codigo, nombre, descripcion, precio};
    }
}
