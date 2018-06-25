package models;

import dto.chart.models.Departament;
import dto.chart.models.State;

import java.nio.charset.MalformedInputException;
import java.util.*;

public class Middleware {

    private static Departament processDepartamentWithRentsAndReturnDepartament(DepartamentWithRents departamentWithRents) {
        Departament departament = new Departament();
        departament.setDepartamento(departamentWithRents.getDepartamento());

        Map<State, Integer> statesWithDays = new TreeMap<>();

        Integer lastEndDateDayOfMonth = null;
        Integer initialEndDateDayOfMonth;
        Map<Integer, Integer> lastEndDayAndNextDay = new TreeMap<>();

        for (Alquiler alquiler : departamentWithRents.getAlquileres()) {
            int initialDayOfMonth = obtainCalendar(alquiler.getFecha_inicio());
            int endDayOfMonth = obtainCalendar(alquiler.getFecha_fin());

            if (lastEndDateDayOfMonth == null) {
                lastEndDateDayOfMonth = endDayOfMonth;
            } else {
                initialEndDateDayOfMonth = initialDayOfMonth;
                lastEndDayAndNextDay.put(lastEndDateDayOfMonth, initialEndDateDayOfMonth);
            }

            statesWithDays.put(State.RENTED, initialDayOfMonth - endDayOfMonth);
        }

        lastEndDayAndNextDay.forEach((key, value) -> {
            if(value != (key + 1)) {
                statesWithDays.put(State.FREE, value - key);
            }
        });

        departament.setStatesWithDays(statesWithDays);

        return departament;
    }

    private static int obtainCalendar(Date fecha) {
        Calendar initialCalendar = Calendar.getInstance();
        initialCalendar.setTime(fecha);
        return initialCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        DepartamentWithRents departamentWithRents = new DepartamentWithRents();
        Departamento departamento = new Departamento();

        departamento.setNum_departamento(1);
        departamento.setId_departamento(1);
        departamentWithRents.setDepartamento(departamento);

        Alquiler alquiler = new Alquiler();
        alquiler.setCantidad_personas(5);

        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(Calendar.DAY_OF_MONTH, 1);

        alquiler.setFecha_inicio(instance.getTime());
        instance.set(Calendar.DAY_OF_MONTH, 15);
        alquiler.setFecha_fin(instance.getTime());

        Departament departament = processDepartamentWithRentsAndReturnDepartament(departamentWithRents);
    }

}
