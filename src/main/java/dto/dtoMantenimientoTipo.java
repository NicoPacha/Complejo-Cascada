package dto;

import java.util.Date;

public class dtoMantenimientoTipo {

    private int id_mantenimiento;
    private int id_tipo_mantenimiento;
    String tipo_mantenimiento;
    Date fecha_mantenimiento;
    float monto;
    String agregado;

    public dtoMantenimientoTipo() {
    }

    public dtoMantenimientoTipo(int id_mantenimiento, int id_tipo_mantenimiento, String tipo_mantenimiento, Date fecha_mantenimiento, float monto, String agregado) {
        this.id_mantenimiento = id_mantenimiento;
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
        this.tipo_mantenimiento = tipo_mantenimiento;
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

    public String getTipo_mantenimiento() {
        return tipo_mantenimiento;
    }

    public void setTipo_mantenimiento(String tipo_mantenimiento) {
        this.tipo_mantenimiento = tipo_mantenimiento;
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

}
