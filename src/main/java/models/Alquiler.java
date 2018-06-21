package models;

import java.util.Date;

public class Alquiler {

    private int id_alquiler;
    private int id_departamento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int id_cliente;
    private int cantidad_personas;
    private float total;

    public Alquiler() {
    }

    public Alquiler(int id_alquiler, int id_departamento, Date fecha_inicio, Date fecha_fin, int id_cliente, int cantidad_personas, float total) {
        this.id_alquiler = id_alquiler;
        this.id_departamento = id_departamento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_cliente = id_cliente;
        this.cantidad_personas = cantidad_personas;
        this.total = total;
    }

    public Alquiler(int id_departamento, Date fecha_inicio, Date fecha_fin, int id_cliente, int cantidad_personas, float total) {
        this.id_departamento = id_departamento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_cliente = id_cliente;
        this.cantidad_personas = cantidad_personas;
        this.total = total;
    }

    public Alquiler(int id_departamento, Date fecha_inicio, Date fecha_fin) {
        this.id_departamento = id_departamento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Alquiler "+id_alquiler;
    }

}
