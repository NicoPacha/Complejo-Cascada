package dto;

import dto.chart.models.Departament;
import models.GestorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import dto.chart.models.State;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DepartamentsRentalDaysByMonth extends ApplicationFrame {

    private static final String conexion = "jdbc:sqlserver://DESKTOP-6SGVG7R\\SQLEXPRESS2012:1433;databaseName=ComplejoCascada";
    private String usuario = "sa";
    private String contraseña = "root";
    private Connection conn;
    GestorDB gdb = new GestorDB();

    public DepartamentsRentalDaysByMonth(final String title) {
        super(title);
    }

    private void generateChart(ArrayList<Departament> departaments) {
        XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
        final int departamentStates = 2;
        String[] stateNames = new String[]{"Ocupado/Alquilado", "Libre"};

        String[] rooms = new String[departaments.size()];

        for (int i = 0; i < departaments.size(); i++) {
            rooms[i] = "Departamento " + (1 + i);
        }

        double[] startTimes = new double[departaments.size()];

        XYIntervalSeries[] series = new XYIntervalSeries[departamentStates];

        addSeriesToDataset(dataset, departamentStates, stateNames, series);

        addDepartamentsToSeries(departaments, startTimes, series);

        XYBarRenderer renderer = new XYBarRenderer();
        renderer.setUseYInterval(true);
        XYPlot plot = new XYPlot(dataset, new SymbolAxis("Departamentos", rooms), new NumberAxis(), renderer);
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart chart = new JFreeChart(plot);
        getContentPane().add(new ChartPanel(chart));
    }

    private void addSeriesToDataset(XYIntervalSeriesCollection dataset, int departamentStates, String[] stateNames, XYIntervalSeries[] series) {
        for (int i = 0; i < departamentStates; i++) {
            series[i] = new XYIntervalSeries(stateNames[i]);
            dataset.addSeries(series[i]);
        }
    }

    private void addDepartamentsToSeries(ArrayList<Departament> departaments, double[] startTimes, XYIntervalSeries[] series) {
        departaments.forEach(departament -> {
            int currentDepartament = departaments.indexOf(departament);
            int currentState;
            int days;

            for (Map.Entry<State, Integer> entry : departament.getStatesWithDays().entrySet()) {
                currentState = entry.getKey().equals(State.FREE) ? 1 : 0;
                days = entry.getValue();
                series[currentState].add(
                        currentDepartament,
                        currentDepartament - 0.3, currentDepartament + 0.3, startTimes[currentDepartament],
                        startTimes[currentDepartament] + 0.1, startTimes[currentDepartament] + days - 0.1);
                startTimes[currentDepartament] += days;
            }
        });
    }

    private void abrirConexion() throws SQLException {
        conn = DriverManager.getConnection(conexion, usuario, contraseña);
    }

    private void cerrarConexion() throws SQLException {
        conn.close();
    }

    public static void main(final String[] args) {
        final DepartamentsRentalDaysByMonth demo = new DepartamentsRentalDaysByMonth("DepartamentsRentalDaysByMonth");
        ArrayList<Departament> departaments = mockDepartaments();
        demo.generateChart(departaments);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    private static ArrayList<Departament> mockDepartaments() {
        ArrayList<Departament> departaments = new ArrayList<>();


        Map<State, Integer> quick = new TreeMap<>();
        quick.put(State.RENTED, 10);
        quick.put(State.FREE, 5);

        Departament departament = new Departament();
        departament.setStatesWithDays(quick);

        Departament departament2 = new Departament();
        departament2.setStatesWithDays(quick);

        Departament departament3 = new Departament();
        departament3.setStatesWithDays(quick);

        departaments.add(departament);
        departaments.add(departament2);
        departaments.add(departament3);

        return departaments;
    }
}
