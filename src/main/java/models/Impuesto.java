package models;

import java.util.Date;

public class Impuesto {

    private int id_impuesto;
    private int id_tipo_impuesto;
    private Date fecha_impuesto;
    private Date fecha_impuesto_fin;
    private Date fecha_pago;
    private float monto;

    public Impuesto() {
    }

    public Impuesto(int id_impuesto, int id_tipo_impuesto, Date fecha_impuesto, Date fecha_impuesto_fin, Date fecha_pago, float monto) {
        this.id_impuesto = id_impuesto;
        this.id_tipo_impuesto = id_tipo_impuesto;
        this.fecha_impuesto = fecha_impuesto;
        this.fecha_impuesto_fin = fecha_impuesto_fin;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    public Impuesto(int id_tipo_impuesto, Date fecha_impuesto, Date fecha_impuesto_fin, Date fecha_pago, float monto) {
        this.id_tipo_impuesto = id_tipo_impuesto;
        this.fecha_impuesto = fecha_impuesto;
        this.fecha_impuesto_fin = fecha_impuesto_fin;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
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

    public Date getFecha_impuesto() {
        return fecha_impuesto;
    }

    public void setFecha_impuesto(Date fecha_impuesto) {
        this.fecha_impuesto = fecha_impuesto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Impuesto{" + "id_impuesto=" + id_impuesto + ", id_tipo_impuesto=" + id_tipo_impuesto + ", fecha_impuesto=" + fecha_impuesto + ", monto=" + monto + '}';
    }

}
