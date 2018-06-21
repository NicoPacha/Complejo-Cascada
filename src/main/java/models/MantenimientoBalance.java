package models;

public class MantenimientoBalance {

    private int id_mantenimiento_balance;
    private int id_mantenimiento;
    private int id_balance_general;

    public MantenimientoBalance() {
    }

    public MantenimientoBalance(int id_mantenimiento_balance, int id_mantenimiento, int id_balance_general) {
        this.id_mantenimiento_balance = id_mantenimiento_balance;
        this.id_mantenimiento = id_mantenimiento;
        this.id_balance_general = id_balance_general;
    }

    public MantenimientoBalance(int id_mantenimiento, int id_balance_general) {
        this.id_mantenimiento = id_mantenimiento;
        this.id_balance_general = id_balance_general;
    }

    public int getId_mantenimiento_balance() {
        return id_mantenimiento_balance;
    }

    public void setId_mantenimiento_balance(int id_mantenimiento_balance) {
        this.id_mantenimiento_balance = id_mantenimiento_balance;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public int getId_balance_general() {
        return id_balance_general;
    }

    public void setId_balance_general(int id_balance_general) {
        this.id_balance_general = id_balance_general;
    }

}
