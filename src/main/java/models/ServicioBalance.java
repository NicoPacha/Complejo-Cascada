package models;

public class ServicioBalance {

    private int id_servicio_balance;
    private int id_servicio;
    private int id_balance_general;

    public ServicioBalance() {
    }

    public ServicioBalance(int id_servicio_balance, int id_servicio, int id_balance_general) {
        this.id_servicio_balance = id_servicio_balance;
        this.id_servicio = id_servicio;
        this.id_balance_general = id_balance_general;
    }

    public ServicioBalance(int id_servicio, int id_balance_general) {
        this.id_servicio = id_servicio;
        this.id_balance_general = id_balance_general;
    }

    public int getId_servicio_balance() {
        return id_servicio_balance;
    }

    public void setId_servicio_balance(int id_servicio_balance) {
        this.id_servicio_balance = id_servicio_balance;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_balance_general() {
        return id_balance_general;
    }

    public void setId_balance_general(int id_balance_general) {
        this.id_balance_general = id_balance_general;
    }

}
