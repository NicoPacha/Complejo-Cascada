package models;

import java.util.Date;

public class Cobro {

    private int id_cobro;
    private int id_tipo_cobro;
    private int id_alquiler;
    private float monto;
    private Date fecha_cobro;

    public Cobro() {
    }

    public Cobro(int id_cobro, int id_tipo_cobro, int id_alquiler, float monto, Date fecha_cobro) {
        this.id_cobro = id_cobro;
        this.id_tipo_cobro = id_tipo_cobro;
        this.id_alquiler = id_alquiler;
        this.monto = monto;
        this.fecha_cobro = fecha_cobro;
    }

    public Cobro(int id_tipo_cobro, int id_alquiler, float monto, Date fecha_cobro) {
        this.id_tipo_cobro = id_tipo_cobro;
        this.id_alquiler = id_alquiler;
        this.monto = monto;
        this.fecha_cobro = fecha_cobro;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public int getId_tipo_cobro() {
        return id_tipo_cobro;
    }

    public void setId_tipo_cobro(int id_tipo_cobro) {
        this.id_tipo_cobro = id_tipo_cobro;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha_cobro() {
        return fecha_cobro;
    }

    public void setFecha_cobro(Date fecha_cobro) {
        this.fecha_cobro = fecha_cobro;
    }

    @Override
    public String toString() {
        return "Cobro{" + "id_cobro=" + id_cobro + ", id_tipo_cobro=" + id_tipo_cobro + ", id_alquiler=" + id_alquiler + ", monto=" + monto + ", fecha_cobro=" + fecha_cobro + '}';
    }

}
