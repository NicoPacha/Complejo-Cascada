package views;

import models.BalanceGeneral;
import models.GestorDB;
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

public class ConsultarBalance extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultTableModel dtm;
    int xMouse;
    int yMouse;
    private static DefaultTableCellRenderer tcr;

    public ConsultarBalance(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        jMes.setBackground(new Color(255, 255, 255));
        jAño.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        ArrayList<BalanceGeneral> balance = gdb.cargarBalances();
        cargarTabla(balance);
        acomodar();
        jTableBalance.getTableHeader().setReorderingAllowed(false);

    }

    private void cargarTabla(ArrayList<BalanceGeneral> balance) {
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id Balance", "Concepto", "Fecha", "Entrada", "Salida", "Saldo"};
        dtm.setColumnIdentifiers(nombreColumnas);

        for (BalanceGeneral m : balance) {
            Object[] filas = {m.getId_balance_general(), m.getConcepto(), m.getFecha(), "$" + m.getEntrada(), "$" + m.getSalida()};
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
        dtm.addRow(new Object[]{"", "", "", "", "", "$" + gdb.SaldoBalance(m, año)});

        jTableBalance.setModel(dtm);
        jTableBalance.getColumnModel().getColumn(1).setMinWidth(400);
        jTableBalance.getTableHeader().setFont(new Font("Cooper ", 1, 16));
        jTableBalance.getTableHeader().setBackground(new Color(101, 71, 182));
        jTableBalance.getTableHeader().setForeground(Color.white);
        jTableBalance.setRowHeight(24);
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        jTableBalance.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jTableBalance.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jTableBalance.getColumnModel().getColumn(5).setCellRenderer(tcr);
    }

    public void actualizarTabla() {
        cargarTabla(gdb.cargarBalances());
        acomodar();
    }

    public void acomodar() {
        jTableBalance.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableBalance.getColumnModel().getColumn(0).setMinWidth(0);
        jTableBalance.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEmitirReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBalance = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        jAño = new javax.swing.JComboBox<>();
        jMes = new javax.swing.JComboBox<>();
        mes = new javax.swing.JLabel();
        año = new javax.swing.JLabel();

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

        btnEmitirReporte.setBackground(new java.awt.Color(101, 71, 182));
        btnEmitirReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnEmitirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/EmitirContrato.png"))); // NOI18N
        btnEmitirReporte.setText("Emitir Reporte");
        btnEmitirReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitirReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirReporteActionPerformed(evt);
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
        txttitulo.setText("Consultar Balance");

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
                .addGap(258, 258, 258)
                .addComponent(txttitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
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

        jTableBalance.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTableBalance.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableBalance.setGridColor(new java.awt.Color(101, 71, 182));
        jTableBalance.setSelectionBackground(new java.awt.Color(150, 128, 209));
        jTableBalance.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableBalance);

        btnFiltrar.setBackground(new java.awt.Color(101, 71, 182));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036" }));

        jMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jMesItemStateChanged(evt);
            }
        });

        mes.setText("Mes");

        año.setText("Año");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(año)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitirReporte)
                .addGap(240, 240, 240)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(1, 1, 1))
                    .addComponent(btnEmitirReporte, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (jTableBalance.getSelectedRowCount() > 0) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                int id = (int) jTableBalance.getValueAt(jTableBalance.getSelectedRow(), 0);
                gdb.eliminarBalance(id);
                actualizarTabla();
            } else {
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTableBalance.getSelectedRowCount() > 0) {
            int id = (int) jTableBalance.getValueAt(jTableBalance.getSelectedRow(), 0);
            RegistrarBalance b = new RegistrarBalance(new javax.swing.JDialog(), true, id);
            b.setVisible(true);
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
        cargarTabla(gdb.filtrarBalance(m, año));
        acomodar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void jMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMesItemStateChanged

    }//GEN-LAST:event_jMesItemStateChanged

    private void btnEmitirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirReporteActionPerformed
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
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\ReporteBalance.jasper", parametros);
                Reportes.mostrar();
            }
            if (jAño.getSelectedIndex() != 0 && jMes.getSelectedIndex() != 0) {
                parametros.put("mes", mes);
                parametros.put("año", año);
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\ReporteBalance.jasper", parametros);
                Reportes.mostrar();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnEmitirReporteActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarBalance dialog = new ConsultarBalance(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnEmitirReporte;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> jAño;
    private javax.swing.JComboBox<String> jMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBalance;
    private javax.swing.JLabel mes;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
