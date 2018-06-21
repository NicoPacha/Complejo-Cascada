package dto;

public class dtoClienteProvDoc {

    private int id_cliente;
    private String nombreCompleto;
    private int id_provincia;
    private String provincia;
    private String pueblo;
    private long telefono;
    private int id_tipo_documento;
    private String tipo_documento;
    private long documento;

    public dtoClienteProvDoc() {
    }

    public dtoClienteProvDoc(int id_cliente, String nombreCompleto, int id_provincia, String provincia, String pueblo, long telefono, int id_tipo_documento, String tipo_documento, long documento) {
        this.id_cliente = id_cliente;
        this.nombreCompleto = nombreCompleto;
        this.id_provincia = id_provincia;
        this.provincia = provincia;
        this.pueblo = pueblo;
        this.telefono = telefono;
        this.id_tipo_documento = id_tipo_documento;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
    }


    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }





}
