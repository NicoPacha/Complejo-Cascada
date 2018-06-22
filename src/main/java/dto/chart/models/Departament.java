package dto.chart.models;

import java.util.Map;

public class Departament {

    private Map<State, Integer> statesWithDays;
    private String numero;

    public Map<State, Integer> getStatesWithDays() {
        return statesWithDays;
    }

    public void setStatesWithDays(Map<State, Integer> statesWithDays) {
        this.statesWithDays = statesWithDays;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
