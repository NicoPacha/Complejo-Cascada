package models;

public class TipoCobro {

    private int id_tipo_cobro;
    private String tipo_cobro;

    public TipoCobro() {
    }

    public TipoCobro(int id_tipo_cobro, String tipo_cobro) {
        this.id_tipo_cobro = id_tipo_cobro;
        this.tipo_cobro = tipo_cobro;
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

    @Override
    public String toString() {
        return tipo_cobro ;
    }

}
