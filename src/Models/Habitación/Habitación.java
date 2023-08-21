package Models.Habitación;

/**
 * @author abiga
 */
public class Habitación {
    private int numero;
    private String tipo;
    private String Estado;
    private double precio;

     public Habitación(int numero, String tipo, String Estado, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.Estado = Estado;
        this.precio = precio;
    }
     public Habitación() {
        this.numero = 0;
        this.tipo = "";
        this.Estado = "";
        this.precio = 0.0;
    }
   public Habitación(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.Estado = "";
        this.precio = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
     @Override
    public String toString() {
        return "Habitación [numero=" + numero + ", tipo=" + tipo + ", Estado=" + Estado + ", precio=" + precio + "]";
    }
}


