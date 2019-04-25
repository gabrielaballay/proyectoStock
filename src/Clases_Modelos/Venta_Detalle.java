package Clases_Modelos;

public class Venta_Detalle {
    private int id_detalle;
    private Venta nroFact;
    private int cantFact;
    private double impTotal;
    private Producto id_pro;

    public Venta_Detalle(Venta nroFact, int cantFact, double subTotal, Producto id_pro) {
        this.nroFact = nroFact;
        this.cantFact = cantFact;
        this.impTotal = subTotal;
        this.id_pro = id_pro;
    }

    public Venta_Detalle(int id_detalle, Venta nroFact, int cantFact, double impTotal, Producto id_pro) {
        this.id_detalle = id_detalle;
        this.nroFact = nroFact;
        this.cantFact = cantFact;
        this.impTotal = impTotal;
        this.id_pro = id_pro;
    }
 
    public Venta_Detalle() {
    }

    public Venta getNroFact() {
        return nroFact;
    }

    public void setNroFact(Venta nroFact) {
        this.nroFact = nroFact;
    }

    public int getCantFact() {
        return cantFact;
    }

    public void setCantFact(int cantFact) {
        this.cantFact = cantFact;
    }

    public double getImpTotal() {
        return impTotal;
    }

    public void setImpTotal(double subTotal) {
        this.impTotal = subTotal;
    }

    public Producto getId_pro() {
        return id_pro;
    }

    public void setId_pro(Producto id_pro) {
        this.id_pro = id_pro;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }
    
}
