package models;

public class ImpuestoBalance {

    private int id_impuesto_balance;
    private int id_impuesto;
    private int id_balance_general;

    public ImpuestoBalance() {
    }

    public ImpuestoBalance(int id_impuesto_balance, int id_impuesto, int id_balance_general) {
        this.id_impuesto_balance = id_impuesto_balance;
        this.id_impuesto = id_impuesto;
        this.id_balance_general = id_balance_general;
    }

    public ImpuestoBalance(int id_impuesto, int id_balance_general) {
        this.id_impuesto = id_impuesto;
        this.id_balance_general = id_balance_general;
    }

    public int getId_impuesto_balance() {
        return id_impuesto_balance;
    }

    public void setId_impuesto_balance(int id_impuesto_balance) {
        this.id_impuesto_balance = id_impuesto_balance;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    public int getId_balance_general() {
        return id_balance_general;
    }

    public void setId_balance_general(int id_balance_general) {
        this.id_balance_general = id_balance_general;
    }

}
