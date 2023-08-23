package Models.Habitación;

import Models.Entity;

/**
 * @author abiga
 */
public class Habitación implements Entity{
    private int numero;
    private String tipo;
    private boolean Ocupado;
    private double precio;

     public Habitación(int numero, String tipo, boolean Ocupado, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.Ocupado = Ocupado;
        this.precio = precio;
    }
     public Habitación() {
        this.numero = 0;
        this.tipo = "";
        this.Ocupado = false;
        this.precio = 0.0;
    }
   public Habitación(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.Ocupado = false;
        this.precio = 0.0;
    }

    public Habitación(int numero) {
        this.numero= numero;
    }

  

    public Habitación(int numero, String tipo, int precio, boolean ocupado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.Ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getOcupado() {
        return Ocupado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setOcupado(boolean Ocupado) {
        this.Ocupado = Ocupado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean Ocupado(){
        return Ocupado;
    }
    
    public String Estado(){
        if(this.Ocupado){
            return "Ocupada";
        }else{
            return "Disponible";
        }   
         
    }
    
   
     @Override
    public String toString() {
        return "Habitación [numero=" + numero + ", tipo=" + tipo + ", Estado=" + Ocupado + ", precio=" + precio + "]";
    }

    @Override
    public boolean isComplete() {
    return numero > 0 && !tipo.isEmpty() && precio > 0.0;
}


   @Override
    public Object[] toArrayObject() {
        return new Object[] { getNumero(), getTipo(),this.Estado(),getPrecio() };
    }
}


