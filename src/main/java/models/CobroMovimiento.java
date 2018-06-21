package models;

public class CobroMovimiento {

    private int id_cobro_movimiento;
    private int id_cobro;
    private int id_movimiento_bancario;

    public CobroMovimiento() {
    }

    public CobroMovimiento(int id_cobro_movimiento, int id_cobro, int id_movimiento_bancario) {
        this.id_cobro_movimiento = id_cobro_movimiento;
        this.id_cobro = id_cobro;
        this.id_movimiento_bancario = id_movimiento_bancario;
    }

    public CobroMovimiento(int id_cobro, int id_movimiento_bancario) {
        this.id_cobro = id_cobro;
        this.id_movimiento_bancario = id_movimiento_bancario;
    }

    public int getId_cobro_movimiento() {
        return id_cobro_movimiento;
    }

    public void setId_cobro_movimiento(int id_cobro_movimiento) {
        this.id_cobro_movimiento = id_cobro_movimiento;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public int getId_movimiento_bancario() {
        return id_movimiento_bancario;
    }

    public void setId_movimiento_bancario(int id_movimiento_bancario) {
        this.id_movimiento_bancario = id_movimiento_bancario;
    }

}
