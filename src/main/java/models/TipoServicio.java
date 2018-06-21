package models;

public class TipoServicio {

    private int id_tipo_servicio;
    private String tipo_servicio;

    public TipoServicio() {
    }

    public TipoServicio(int id_tipo_servicio, String tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
        this.tipo_servicio = tipo_servicio;
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

    @Override
    public String toString() {
        return  tipo_servicio ;
    }

}
