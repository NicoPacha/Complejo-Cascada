package dto.chart.models;

import models.Departamento;

import java.util.Map;

public class Departament {

    private Map<State, Integer> statesWithDays;
    private Departamento departamento;

    public Map<State, Integer> getStatesWithDays() {
        return statesWithDays;
    }

    public void setStatesWithDays(Map<State, Integer> statesWithDays) {
        this.statesWithDays = statesWithDays;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "statesWithDays=" + statesWithDays +
                ", departamento=" + departamento +
                '}';
    }
}
