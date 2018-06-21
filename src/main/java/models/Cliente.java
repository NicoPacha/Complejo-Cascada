package models;

public class Cliente {

    private int id_cliente;
    private String nombre;
    private String apellido;
    private int id_provincia;
    private String pueblo;
    private long telefono;
    private int id_tipo_documento;
    private long documento;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, int id_provincia, String pueblo, long telefono, int id_tipo_documento, long documento) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_provincia = id_provincia;
        this.pueblo = pueblo;
        this.telefono = telefono;
        this.id_tipo_documento = id_tipo_documento;
        this.documento = documento;
    }

    public Cliente(int id_cliente, String nombre, String apellido) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(int id_cliente, String nombre) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
    }

    public Cliente(String nombre, String apellido, int id_provincia, String pueblo, long telefono, int id_tipo_documento, long documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_provincia = id_provincia;
        this.pueblo = pueblo;
        this.telefono = telefono;
        this.id_tipo_documento = id_tipo_documento;
        this.documento = documento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
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

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

}
