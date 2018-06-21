package models;

import java.util.Date;

public class MovimientoBancario {

    private int id_movimiento_bancario;
    private String concepto;
    private Date fecha_movimiento;
    private float entrada;
    private float salida;
    private float saldo;

    public MovimientoBancario() {
    }

    public MovimientoBancario(int id_movimiento_bancario, String concepto, Date fecha_movimiento, float entrada, float salida, float saldo) {
        this.id_movimiento_bancario = id_movimiento_bancario;
        this.concepto = concepto;
        this.fecha_movimiento = fecha_movimiento;
        this.entrada = entrada;
        this.salida = salida;
        this.saldo = saldo;
    }

    public MovimientoBancario(String concepto, Date fecha_movimiento, float entrada, float salida, float saldo) {
        this.concepto = concepto;
        this.fecha_movimiento = fecha_movimiento;
        this.entrada = entrada;
        this.salida = salida;
        this.saldo = saldo;
    }
    
    

    public int getId_movimiento_bancario() {
        return id_movimiento_bancario;
    }

    public void setId_movimiento_bancario(int id_movimiento_bancario) {
        this.id_movimiento_bancario = id_movimiento_bancario;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(Date fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public float getEntrada() {
        return entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

    public float getSalida() {
        return salida;
    }

    public void setSalida(float salida) {
        this.salida = salida;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    

    @Override
    public String toString() {
        return "MovimientoBancario{" + "id_movimiento_bancario=" + id_movimiento_bancario + ", concepto=" + concepto + ", fecha_movimiento=" + fecha_movimiento + ", entrada=" + entrada + ", salida=" + salida + ", saldo=" + saldo + '}';
    }

}
