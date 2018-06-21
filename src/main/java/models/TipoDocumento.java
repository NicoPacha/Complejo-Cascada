
package models;

public class TipoDocumento {
    
    private int id_tipo_documento;
    private String tipo_documento;

    public TipoDocumento(int id_tipo_documento, String tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
        this.tipo_documento = tipo_documento;
    }

    public TipoDocumento() {
    }
    

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    @Override
    public String toString() {
        return tipo_documento ;
    }
    
    
    
    
    
    
}
