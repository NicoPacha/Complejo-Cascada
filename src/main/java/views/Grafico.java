package views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends javax.swing.JDialog {

    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
    SimpleDateFormat otroFormato2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static final String conexion = "jdbc:sqlserver://DESKTOP-6SGVG7R\\SQLEXPRESS2012:1433;databaseName=ComplejoCascada";
    private String usuario = "sa";
    private String contraseña = "root";
    private Connection conn;

    public Grafico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    private void abrirConexion() throws SQLException {
        conn = DriverManager.getConnection(conexion, usuario, contraseña);
    }

    private void cerrarConexion() throws SQLException {
        conn.close();
    }

    private void generarGrafico() {
        try {
            String fechaI = String.valueOf(jFechaInicio.getDate());
            Date fecha_inicio = (Date) sdf.parse(fechaI);
            String fi = String.valueOf(otroFormato2.format(fecha_inicio));
            String fechaF = String.valueOf(jFechaFin.getDate());
            Date fecha_fin = (Date) sdf.parse(fechaF);
            String ff = String.valueOf(otroFormato2.format(fecha_fin));
            //int num_departamento = Integer.parseInt(txtDepartamento.getText());
            try {
                abrirConexion();
                Statement state = conn.createStatement();
                //ResultSet consulta = state.executeQuery("SELECT num_departamento,fecha_inicio,fecha_fin FROM Alquileres a join Departamentos d on d.id_departamento=a.id_departamento WHERE ((fecha_inicio <= DATEADD(day,1,'" + fi + "') and fecha_fin >= DATEADD(day,1,'" + fi + "')) or (fecha_inicio <= DATEADD(day,-1,'" + ff + "') and fecha_fin >= DATEADD(day,-1,'" + ff + "')) or (fecha_inicio between DATEADD(day,1,'" + fi + "') and DATEADD(day,-1,'" + ff + "')) or (fecha_fin between DATEADD(day,1,'" + fi + "') and DATEADD(day,-1,'" + ff + "')))");  
                ResultSet consulta = state.executeQuery("declare @fechaI varchar(50)='" + fi + "',\n"
                        + "@fechaF varchar(50)='" + ff + "'\n"
                        + "SELECT id_alquiler,num_departamento,fecha_inicio,fecha_fin \n"
                        + "FROM Alquileres a join Departamentos d on d.id_departamento=a.id_departamento\n"
                        + " WHERE \n"
                        + "  ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or\n"
                        + "   (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or \n"
                        + "   (fecha_inicio between @fechaI and @fechaF) or\n"
                        + "    (fecha_fin between @fechaI and @fechaF))");
                DefaultCategoryDataset d = new DefaultCategoryDataset();
               // d.setValue(30, "", "");
                while (consulta.next()) {
                    int id_alquiler = consulta.getInt("id_alquiler");
                    int num_departamento_consulta = consulta.getInt("num_departamento");
                    Date fecha_inicio_consulta = consulta.getDate("fecha_inicio");
                    Date fecha_fin_consulta = consulta.getDate("fecha_fin");

                    int dias = (int) ((fecha_fin_consulta.getTime() - fecha_inicio_consulta.getTime()) / 86400000);

                    d.setValue(dias, String.valueOf(id_alquiler), String.valueOf(num_departamento_consulta));
                }
                JFreeChart cha = ChartFactory.createBarChart("Alquileres", "Departamentos", "Fecha", d, PlotOrientation.HORIZONTAL, true, true, true);
                ChartPanel panel = new ChartPanel(cha);
                grafico.setLayout(new java.awt.BorderLayout());
                grafico.add(panel);
                grafico.validate();

                consulta.close();
                state.close();
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFechaInicio = new com.toedter.calendar.JDateChooser();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        grafico = new javax.swing.JPanel();
        txtDepartamento = new javax.swing.JTextField();
        btnGraficar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout graficoLayout = new javax.swing.GroupLayout(grafico);
        grafico.setLayout(graficoLayout);
        graficoLayout.setHorizontalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficoLayout.setVerticalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        btnGraficar.setText("Generar Grafico");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(btnGraficar)))
                .addContainerGap(477, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGraficar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        generarGrafico();
    }//GEN-LAST:event_btnGraficarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Grafico dialog = new Grafico(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JPanel grafico;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaInicio;
    private javax.swing.JTextField txtDepartamento;
    // End of variables declaration//GEN-END:variables
}
