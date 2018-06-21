package views;

import models.GestorDB;
import models.MovimientoBancario;
import models.Reportes;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConsultarMovimientosBancarios extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultTableModel dtm;
    int xMouse;
    int yMouse;
    private static DefaultTableCellRenderer tcr;

    public ConsultarMovimientosBancarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        jMes.setBackground(new Color(255, 255, 255));
        jAño.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        ArrayList<MovimientoBancario> movimientos = gdb.cargarMovimientos();
        cargarTabla(movimientos);
        acomodar();
        jTableMovimientos.getTableHeader().setReorderingAllowed(false);

    }

    private void cargarTabla(ArrayList<MovimientoBancario> movimientos) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id Movimiento", "Concepto", "Fecha de movimiento", "Entrada", "Salida", "Saldo"};
        dtm.setColumnIdentifiers(nombreColumnas);

        for (MovimientoBancario m : movimientos) {
            Object[] filas = {m.getId_movimiento_bancario(), m.getConcepto(), m.getFecha_movimiento(), "$" + m.getEntrada(), "$" + m.getSalida()};
            dtm.addRow(filas);
        }
        String año = jAño.getSelectedItem().toString();
        String m = String.valueOf(jMes.getSelectedIndex());
        if (jAño.getSelectedIndex() == 0) {
            Calendar cal = Calendar.getInstance();
            año = String.valueOf(cal.get(Calendar.YEAR));
        }
        if (jMes.getSelectedIndex() == 0) {
            m = "null";
        }
        dtm.addRow(new Object[]{"", "", "", "", "", "$" + gdb.SaldoMovimientos(m, año)});

        jTableMovimientos.setModel(dtm);
        jTableMovimientos.getColumnModel().getColumn(1).setMinWidth(200);

        jTableMovimientos.getTableHeader().setFont(new Font("Cooper ", 1, 16));
        jTableMovimientos.getTableHeader().setBackground(new Color(101, 71, 182));
        jTableMovimientos.getTableHeader().setForeground(Color.white);
        jTableMovimientos.setRowHeight(24);
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        jTableMovimientos.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jTableMovimientos.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jTableMovimientos.getColumnModel().getColumn(5).setCellRenderer(tcr);
    }

    public void actualizarTabla() {
        cargarTabla(gdb.cargarMovimientos());
        acomodar();
    }

    public void acomodar() {
        jTableMovimientos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableMovimientos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableMovimientos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEmitir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovimientos = new javax.swing.JTable();
        mes = new javax.swing.JLabel();
        jMes = new javax.swing.JComboBox<>();
        jAño = new javax.swing.JComboBox<>();
        año = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnEliminar.setBackground(new java.awt.Color(101, 71, 182));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(101, 71, 182));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEmitir.setBackground(new java.awt.Color(101, 71, 182));
        btnEmitir.setForeground(new java.awt.Color(255, 255, 255));
        btnEmitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/EmitirContrato.png"))); // NOI18N
        btnEmitir.setText("Emitir Reporte");
        btnEmitir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(101, 71, 182));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        txttitulo.setBackground(new java.awt.Color(255, 255, 255));
        txttitulo.setFont(new java.awt.Font("Tekton Pro", 1, 36)); // NOI18N
        txttitulo.setForeground(new java.awt.Color(255, 255, 255));
        txttitulo.setText("Consultar Movimientos Bancarios");

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/close.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(txttitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttitulo))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableMovimientos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTableMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMovimientos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMovimientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMovimientos);

        mes.setText("Mes");

        jMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jMesItemStateChanged(evt);
            }
        });

        jAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036" }));

        año.setText("Año");

        btnFiltrar.setBackground(new java.awt.Color(101, 71, 182));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(mes)
                        .addGap(69, 69, 69)
                        .addComponent(año)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mes)
                    .addComponent(año))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnEmitir)
                            .addComponent(btnEliminar))))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMovimientosMouseClicked

    }//GEN-LAST:event_jTableMovimientosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (jTableMovimientos.getSelectedRowCount() > 0) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                int id = (int) jTableMovimientos.getValueAt(jTableMovimientos.getSelectedRow(), 0);
                gdb.eliminarMovimiento(id);
                actualizarTabla();
            } else {
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTableMovimientos.getSelectedRowCount() > 0) {
            int id = (int) jTableMovimientos.getValueAt(jTableMovimientos.getSelectedRow(), 0);
            RegistrarMovimientoBancario mb = new RegistrarMovimientoBancario(new javax.swing.JDialog(), true, id);
            mb.setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String año = jAño.getSelectedItem().toString();
        String m = String.valueOf(jMes.getSelectedIndex());
        if (jAño.getSelectedIndex() == 0) {
            Calendar cal = Calendar.getInstance();
            año = String.valueOf(cal.get(Calendar.YEAR));
        }
        if (jMes.getSelectedIndex() == 0) {
            m = "null";
        }
        cargarTabla(gdb.filtrarMovimientos(m, año));
        acomodar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void jMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMesItemStateChanged

    }//GEN-LAST:event_jMesItemStateChanged

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
        try {
            Connection conn = Reportes.conectar();

            String año = jAño.getSelectedItem().toString();
            String mes = String.valueOf(jMes.getSelectedIndex());
            Map<String, Object> parametros = new HashMap();

            if (jAño.getSelectedIndex() == 0) {
                JOptionPane.showConfirmDialog(null, "Debe elegir el año", "Alerta!", JOptionPane.CLOSED_OPTION);
            }
            if (jMes.getSelectedIndex() == 0 && jAño.getSelectedIndex() != 0) {
                parametros.put("año", año);
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\ReporteMovimientos.jasper", parametros);
                Reportes.mostrar();
            }
            if (jAño.getSelectedIndex() != 0 && jMes.getSelectedIndex() != 0) {
                parametros.put("mes", mes);
                parametros.put("año", año);
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\ReporteMovimientos.jasper", parametros);
                Reportes.mostrar();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnEmitirActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

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
            java.util.logging.Logger.getLogger(ConsultarMovimientosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarMovimientosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarMovimientosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarMovimientosBancarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarMovimientosBancarios dialog = new ConsultarMovimientosBancarios(new java.awt.Frame(), true);
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
    private javax.swing.JLabel año;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> jAño;
    private javax.swing.JComboBox<String> jMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMovimientos;
    private javax.swing.JLabel mes;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
