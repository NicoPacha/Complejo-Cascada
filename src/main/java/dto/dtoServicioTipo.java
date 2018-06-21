package dto;

import java.util.Date;

public class dtoServicioTipo {

    private int id_servicio;
    private int id_tipo_servicio;
    String tipo_servicio;
    String fecha_servicio;
    Date fecha_servicio_fin;
    float monto;
    Date fecha_pago;

    public dtoServicioTipo() {
    }

    public dtoServicioTipo(int id_servicio, int id_tipo_servicio, String tipo_servicio, String fecha_servicio, Date fecha_servicio_fin, float monto, Date fecha_pago) {
        this.id_servicio = id_servicio;
        this.id_tipo_servicio = id_tipo_servicio;
        this.tipo_servicio = tipo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.fecha_servicio_fin = fecha_servicio_fin;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Date getFecha_servicio_fin() {
        return fecha_servicio_fin;
    }

    public void setFecha_servicio_fin(Date fecha_servicio_fin) {
        this.fecha_servicio_fin = fecha_servicio_fin;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_tipo_servicio() {
        return id_tipo_servicio;
    }

    public void setId_tipo_servicio(int id_tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(String fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

}
