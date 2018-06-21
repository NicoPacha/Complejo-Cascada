package dto;

import java.util.Date;

public class dtoContratoAlquiler {

    private int id_contrato;
    private int id_alquiler;
    private Date fecha_contrato;
    private int num_departamento;
    private String cliente;
    private long documento;
    private Date fecha_inicio;
    private Date fecha_fin;

    public dtoContratoAlquiler() {
    }

    public dtoContratoAlquiler(int id_contrato, int id_alquiler, Date fecha_contrato, int num_departamento, String cliente, long documento, Date fecha_inicio, Date fecha_fin) {
        this.id_contrato = id_contrato;
        this.id_alquiler = id_alquiler;
        this.fecha_contrato = fecha_contrato;
        this.num_departamento = num_departamento;
        this.cliente = cliente;
        this.documento = documento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public int getNum_departamento() {
        return num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        this.num_departamento = num_departamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
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

}
