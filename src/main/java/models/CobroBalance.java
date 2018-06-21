package models;

public class CobroBalance {

    private int id_cobro_balance;
    private int id_cobro;
    private int id_balance_general;

    public CobroBalance() {
    }

    public CobroBalance(int id_cobro_balance, int id_cobro, int id_balance_general) {
        this.id_cobro_balance = id_cobro_balance;
        this.id_cobro = id_cobro;
        this.id_balance_general = id_balance_general;
    }

    public CobroBalance(int id_cobro, int id_balance_general) {
        this.id_cobro = id_cobro;
        this.id_balance_general = id_balance_general;
    }

    public int getId_cobro_balance() {
        return id_cobro_balance;
    }

    public void setId_cobro_balance(int id_cobro_balance) {
        this.id_cobro_balance = id_cobro_balance;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public int getId_balance_general() {
        return id_balance_general;
    }

    public void setId_balance_general(int id_balance_general) {
        this.id_balance_general = id_balance_general;
    }

}
