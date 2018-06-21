package dto;

import java.util.Date;

public class dtoCobroAlqCliTipCob {

    private int id_cobro;
    private int id_tipo_cobro;
    private String tipo_cobro;
    private int id_alquiler;
    private int id_departamento;
    private int num_departamento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String nombreApellido;
    private float monto;
    private Date fecha_cobro;

    public dtoCobroAlqCliTipCob() {
    }

    public dtoCobroAlqCliTipCob(int id_cobro, int id_tipo_cobro, String tipo_cobro, int id_alquiler, int id_departamento, int num_departamento, Date fecha_inicio, Date fecha_fin, String nombreApellido, float monto, Date fecha_cobro) {
        this.id_cobro = id_cobro;
        this.id_tipo_cobro = id_tipo_cobro;
        this.tipo_cobro = tipo_cobro;
        this.id_alquiler = id_alquiler;
        this.id_departamento = id_departamento;
        this.num_departamento = num_departamento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.nombreApellido = nombreApellido;
        this.monto = monto;
        this.fecha_cobro = fecha_cobro;
    }

    public int getNum_departamento() {
        return num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        this.num_departamento = num_departamento;
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

    public String getTipo_cobro() {
        return tipo_cobro;
    }

    public void setTipo_cobro(String tipo_cobro) {
        this.tipo_cobro = tipo_cobro;
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

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
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

}
