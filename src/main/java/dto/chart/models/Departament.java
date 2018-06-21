package dto.chart.models;

import java.util.Map;

public class Departament {

    private Map<State, Integer> statesWithDays;

    public Map<State, Integer> getStatesWithDays() {
        return statesWithDays;
    }

    public void setStatesWithDays(Map<State, Integer> statesWithDays) {
        this.statesWithDays = statesWithDays;
    }
}
