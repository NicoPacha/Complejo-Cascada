package models;

import java.util.ArrayList;
import java.util.List;

public class DepartamentWithRents {

    private Departamento departamento;
    private ArrayList<Alquiler> alquileres = new ArrayList<>();

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<Alquiler> alquiler) {
        this.alquileres = alquiler;
    }
}
