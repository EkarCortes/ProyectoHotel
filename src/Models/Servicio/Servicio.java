/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Servicio;

/**
 *
 * @author wendy
 */
public class Servicio {
    private int codigo;
    private String nombre;
    private String descripción;
    private double precio;

    public Servicio() {
    }

    public Servicio(int codigo, String nombre, String descripción, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    // Faltan métodos 
}
