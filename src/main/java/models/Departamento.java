package models;

public class Departamento {

    private int id_departamento;
    private int num_departamento;

    public Departamento() {
    }

    public Departamento(int id_departamento, int num_departamento) {
        this.id_departamento = id_departamento;
        this.num_departamento = num_departamento;
    }
    

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getNum_departamento() {
        return num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        this.num_departamento = num_departamento;
    }

    @Override
    public String toString() {
        return ""+num_departamento ;
    }

//    public String Estado() {
//        String estadoString;
//        if (estado == true) {
//            estadoString = "Ocupado";
//        } else {
//            estadoString = "Desocupado";
//        }
//
//        return estadoString;
//    }

}
