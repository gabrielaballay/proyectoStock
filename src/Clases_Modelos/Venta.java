package Clases_Modelos;

import java.time.LocalDate;

public class Venta {
    private int nro_Factura;
    private String Fecha;
    private float in_tarjeta;
    private float descuento;
    private double sub_total;
    private double total;
    private Usuario id_emp;
    private Cliente cl;

    public Venta(int nro_Factura, String Fecha, float in_tarjeta, float descuento,double sub_total, double total, Usuario id_emp,Cliente cl) {
        this.nro_Factura = nro_Factura;
        this.Fecha = Fecha;
        this.in_tarjeta = in_tarjeta;
        this.descuento = descuento;
        this.sub_total=sub_total;
        this.total = total;
        this.id_emp = id_emp;
        this.cl=cl;
    }

    public Venta() {
    }

    public int getNro_Factura() {
        return nro_Factura;
    }

    public void setNro_Factura(int nro_Factura) {
        this.nro_Factura = nro_Factura;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public float getIn_tarjeta() {
        return in_tarjeta;
    }

    public void setIn_tarjeta(float in_tarjeta) {
        this.in_tarjeta = in_tarjeta;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getId_emp() {
        return id_emp;
    }

    public void setId_emp(Usuario id_emp) {
        this.id_emp = id_emp;
    }

    public Cliente getCl() {
        return cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    }
    
}
