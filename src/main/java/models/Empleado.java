package models;

public class Empleado {

    private int id_empleado;
    private int id_tipo_mantenimiento;
    private String nombreCompleto;
    private long telefono;
    private long documento;
    private String direccion;
    private String tipo_edilicio;

    public Empleado() {
    }

    public Empleado(int id_empleado, int id_tipo_mantenimiento, String nombreCompleto, long telefono, long documento, String direccion, String tipo_edilicio) {
        this.id_empleado = id_empleado;
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.documento = documento;
        this.direccion = direccion;
        this.tipo_edilicio = tipo_edilicio;
    }

    public Empleado(int id_tipo_mantenimiento, String nombreCompleto, long telefono, long documento, String direccion, String tipo_edilicio) {
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.documento = documento;
        this.direccion = direccion;
        this.tipo_edilicio = tipo_edilicio;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_tipo_mantenimiento() {
        return id_tipo_mantenimiento;
    }

    public void setId_tipo_mantenimiento(int id_tipo_mantenimiento) {
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_edilicio() {
        return tipo_edilicio;
    }

    public void setTipo_edilicio(String tipo_edilicio) {
        this.tipo_edilicio = tipo_edilicio;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", id_tipo_mantenimiento=" + id_tipo_mantenimiento + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", documento=" + documento + ", direccion=" + direccion + ", tipo_edilicio=" + tipo_edilicio + '}';
    }

}
