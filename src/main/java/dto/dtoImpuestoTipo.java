package dto;

import java.util.Date;

public class dtoImpuestoTipo {

    private int id_impuesto;
    private int id_tipo_impuesto;
    String tipo_impuesto;
    private String fecha_impuesto;
    Date fecha_impuesto_fin;
    float monto;
    Date fecha_pago;

    public dtoImpuestoTipo() {
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public dtoImpuestoTipo(int id_impuesto, int id_tipo_impuesto, String tipo_impuesto, String fecha_impuesto, Date fecha_impuesto_fin, float monto, Date fecha_pago) {
        this.id_impuesto = id_impuesto;
        this.id_tipo_impuesto = id_tipo_impuesto;
        this.tipo_impuesto = tipo_impuesto;
        this.fecha_impuesto = fecha_impuesto;
        this.fecha_impuesto_fin = fecha_impuesto_fin;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
    }

    public Date getFecha_impuesto_fin() {
        return fecha_impuesto_fin;
    }

    public void setFecha_impuesto_fin(Date fecha_impuesto_fin) {
        this.fecha_impuesto_fin = fecha_impuesto_fin;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    public int getId_tipo_impuesto() {
        return id_tipo_impuesto;
    }

    public void setId_tipo_impuesto(int id_tipo_impuesto) {
        this.id_tipo_impuesto = id_tipo_impuesto;
    }

    public String getTipo_impuesto() {
        return tipo_impuesto;
    }

    public void setTipo_impuesto(String tipo_impuesto) {
        this.tipo_impuesto = tipo_impuesto;
    }

    public String getFecha_impuesto() {
        return fecha_impuesto;
    }

    public void setFecha_impuesto(String fecha_impuesto) {
        this.fecha_impuesto = fecha_impuesto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

}
