package models;

import java.util.Date;

public class BalanceGeneral {

    private int id_balance_general;
    private String concepto;
    private Date fecha;
    private float entrada;
    private float salida;
    private float saldo;

    public BalanceGeneral() {
    }

    public BalanceGeneral(int id_balance_general, String concepto, Date fecha, float entrada, float salida, float saldo) {
        this.id_balance_general = id_balance_general;
        this.concepto = concepto;
        this.fecha = fecha;
        this.entrada = entrada;
        this.salida = salida;
        this.saldo = saldo;
    }

    public BalanceGeneral(String concepto, Date fecha, float entrada, float salida, float saldo) {
        this.concepto = concepto;
        this.fecha = fecha;
        this.entrada = entrada;
        this.salida = salida;
        this.saldo = saldo;
    }

    public int getId_balance_general() {
        return id_balance_general;
    }

    public void setId_balance_general(int id_balance_general) {
        this.id_balance_general = id_balance_general;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        return "BalanceGeneral{" + "id_balance_general=" + id_balance_general + ", concepto=" + concepto + ", fecha=" + fecha + ", entrada=" + entrada + ", salida=" + salida + ", saldo=" + saldo + '}';
    }

}
