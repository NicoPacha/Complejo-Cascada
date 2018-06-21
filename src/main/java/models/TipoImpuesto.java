package models;

public class TipoImpuesto {

    private int id_tipo_impuesto;
    private String tipo_impuesto;

    public TipoImpuesto() {
    }

    public TipoImpuesto(int id_tipo_impuesto, String tipo_impuesto) {
        this.id_tipo_impuesto = id_tipo_impuesto;
        this.tipo_impuesto = tipo_impuesto;
    }
    
    

    public int getId_tipo_impuesto() {
        return id_tipo_impuesto;
    }

    public void setId_tipo_impuesto(int id_tipo_impuesto) {
        this.id_tipo_impuesto = id_tipo_impuesto;
    }

    public String getTipo_impuesto() {
        return tipo_impuesto;
    }

    public void setTipo_impuesto(String tipo_impuesto) {
        this.tipo_impuesto = tipo_impuesto;
    }

    @Override
    public String toString() {
        return  tipo_impuesto ;
    }

}
