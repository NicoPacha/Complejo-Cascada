package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public abstract class Reportes {

    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;

    public static void crearReporte(Connection conn, String ruta, Map parametros) {
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            reportFilled = JasperFillManager.fillReport(report, parametros, conn);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public static void mostrar() {
        viewer = new JasperViewer(reportFilled,false);
        viewer.setVisible(true);
        
    }

    public static Connection conectar() throws SQLException {

            String conexion = "jdbc:sqlserver://DESKTOP-6SGVG7R\\SQLEXPRESS2012:1433;databaseName=ComplejoCascada";
            String usuario = "sa";
            String contraseña = "root";
            Connection conn;

        return conn = DriverManager.getConnection(conexion, usuario, contraseña);
    }

}
