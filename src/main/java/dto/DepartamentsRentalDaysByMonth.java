package dto;

import models.Departamento;
import models.GestorDB;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;

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
    private void generateChart(ArrayList<Departamento> departaments) {
        XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
        //6 different rooms      DEPARTAMENTOS SELECT A LA BASE DE DATOS
        //ArrayList<String> rooms = null ;
        int departamentsSize = departaments.size();
        String[] rooms = new String[departamentsSize];
        for (int i = 0; i < departamentsSize; i++) {
            rooms[i] = "Departamento " + (1+i);
        }

        //la departamentStates define cuales son los estados de un departamento, en este caso es Ocupado/Libre (2 estados)
        final int departamentStates = 2;
        String[] courseNames = new String[]{"Ocupado/Alquilado","Libre"};

        //totalStatesCount corresponde a los cambios de estado totales que va a tener ese alquiler en un periodo de tiempo
        //Ejemplo: En el mes de mayo va a estar alquilado 2 veces y el resto del mes desocupado. eso son 3 estados.
        int totalStatesCount = 10;

        //RANDOM FOR TEST
        Random r = new Random();

        //Time, until thn e respective room is occupied
        double[] startTimes = new double[departamentsSize];

        //Create series. Start and end times are used as y intervals, and the room is represented by the x value
        XYIntervalSeries[] series = new XYIntervalSeries[departamentStates];
        for (int i = 0; i < departamentStates; i++) {
            series[i] = new XYIntervalSeries(courseNames[i]);
            dataset.addSeries(series[i]);
        }

        for (int k = 0; k < totalStatesCount; k++) {
            //get a random room
            int currentRoom = r.nextInt(departamentsSize);
            //get a random course
            int currentCourse = r.nextInt(departamentStates);
            //get a random course duration (1-3 h)
            int time = r.nextInt(3) + 1;
            //Encode the room as x value. The width of the bar is only 0.6 to leave a small gap. The course starts 0.1 h/6 min after the end of the preceding course.
            series[currentCourse].add(currentRoom, currentRoom - 0.3, currentRoom + 0.3, startTimes[currentRoom], startTimes[currentRoom] + 0.1, startTimes[currentRoom] + time - 0.1);
            //Increase start time for the current room
            startTimes[currentRoom] += time;
        }
        XYBarRenderer renderer = new XYBarRenderer();
        renderer.setUseYInterval(true);
        XYPlot plot = new XYPlot(dataset, new SymbolAxis("Departamentos", rooms), new NumberAxis(), renderer);
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart chart = new JFreeChart(plot);
        getContentPane().add(new ChartPanel(chart));
    }

    private ArrayList<Departamento> mockDepartaments() {
        ArrayList<Departamento> departaments = new ArrayList<>();

        Departamento departament = new Departamento();
        departament.setId_departamento(1);
        departament.setNum_departamento(2);
        Departamento departament2 = new Departamento();
        departament2.setId_departamento(2);
        departament2.setNum_departamento(3);
        Departamento departament3 = new Departamento();
        departament3.setId_departamento(3);
        departament3.setNum_departamento(1);
//        departaments.add(departament);
//        departaments.add(departament2);
        departaments.add(departament3);
        return departaments;
    }

    private void abrirConexion() throws SQLException {
        conn = DriverManager.getConnection(conexion, usuario, contraseña);
    }

    private void cerrarConexion() throws SQLException {
        conn.close();
    }

    public static void main(final String[] args) {
        final DepartamentsRentalDaysByMonth demo = new DepartamentsRentalDaysByMonth("DepartamentsRentalDaysByMonth");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
