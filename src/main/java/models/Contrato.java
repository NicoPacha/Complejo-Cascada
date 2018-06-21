package models;

import java.util.Date;

public class Contrato {

    private int id_contrato;
    private int id_alquiler;
    private Date fecha_contrato;

    public Contrato() {
    }

    public Contrato(int id_contrato, int id_alquiler, Date fecha_contrato) {
        this.id_contrato = id_contrato;
        this.id_alquiler = id_alquiler;
        this.fecha_contrato = fecha_contrato;
    }

    public Contrato(int id_alquiler, Date fecha_contrato) {
        this.id_alquiler = id_alquiler;
        this.fecha_contrato = fecha_contrato;
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

    @Override
    public String toString() {
        return "Contrato{" + "id_contrato=" + id_contrato + ", id_alquiler=" + id_alquiler + ", fecha_contrato=" + fecha_contrato + '}';
    }

}
