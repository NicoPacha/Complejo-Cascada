package models;

import java.util.Date;

public class Mantenimiento {

    private int id_mantenimiento;
    private int id_tipo_mantenimiento;
    private Date fecha_mantenimiento;
    private float monto;
    private String agregado;

    public Mantenimiento() {
    }

    public Mantenimiento(int id_mantenimiento, int id_tipo_mantenimiento, Date fecha_mantenimiento, float monto, String agregado) {
        this.id_mantenimiento = id_mantenimiento;
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
        this.fecha_mantenimiento = fecha_mantenimiento;
        this.monto = monto;
        this.agregado = agregado;
    }

    public Mantenimiento(int id_tipo_mantenimiento, Date fecha_mantenimiento, float monto, String agregado) {
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
        this.fecha_mantenimiento = fecha_mantenimiento;
        this.monto = monto;
        this.agregado = agregado;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public int getId_tipo_mantenimiento() {
        return id_tipo_mantenimiento;
    }

    public void setId_tipo_mantenimiento(int id_tipo_mantenimiento) {
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
    }

    public Date getFecha_mantenimiento() {
        return fecha_mantenimiento;
    }

    public void setFecha_mantenimiento(Date fecha_mantenimiento) {
        this.fecha_mantenimiento = fecha_mantenimiento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getAgregado() {
        return agregado;
    }

    public void setAgregado(String agregado) {
        this.agregado = agregado;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "id_mantenimiento=" + id_mantenimiento + ", id_tipo_mantenimiento=" + id_tipo_mantenimiento + ", fecha_mantenimiento=" + fecha_mantenimiento + ", monto=" + monto + ", agregado=" + agregado + '}';
    }

}
