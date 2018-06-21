package dto;

import java.util.Date;

public class dtoGastos {

    private String gasto;
    private String fecha;
    private String monto;
    private Date fecha_pago;
    private Date fecha_vencimiento;
    private String agregado;

    public dtoGastos() {
    }

    public dtoGastos(String gasto, String fecha, String monto, Date fecha_pago, Date fecha_vencimiento, String agregado) {
        this.gasto = gasto;
        this.fecha = fecha;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
        this.fecha_vencimiento = fecha_vencimiento;
        this.agregado = agregado;
    }

    public String getGasto() {
        return gasto;
    }

    public void setGasto(String gasto) {
        this.gasto = gasto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getAgregado() {
        return agregado;
    }

    public void setAgregado(String agregado) {
        this.agregado = agregado;
    }

}
