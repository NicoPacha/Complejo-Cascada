package views;

import models.Departamento;
import models.GestorDB;
import models.Reportes;
import com.sun.awt.AWTUtilities;
import dto.dtoContratoAlquiler;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarContratos extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultTableModel dtm;
    DefaultComboBoxModel combo;
    int xMouse;
    int yMouse;

    public ConsultarContratos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbDepartamentos.setBackground(new Color(255, 255, 255));
        jAño.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        ArrayList<dtoContratoAlquiler> contratos = gdb.cargarContratosDto();
        cargarTabla(contratos);
        acomodar();
        jTableContratos.getTableHeader().setReorderingAllowed(false);
        cantidadContratos();
        cargarComboDepartamento();
    }

    private void cargarTabla(ArrayList<dtoContratoAlquiler> contratos) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id Contrato", "Id alquiler", "Fecha de Contrato", "Depto", "Cliente", "Documento", "Fecha inicio", "Fecha Fin"};
        dtm.setColumnIdentifiers(nombreColumnas);

        for (dtoContratoAlquiler c : contratos) {
            Object[] filas = {c.getId_contrato(), c.getId_alquiler(), c.getFecha_contrato(), c.getNum_departamento(), c.getCliente(), c.getDocumento(), c.getFecha_inicio(), c.getFecha_fin()};
            dtm.addRow(filas);
        }
        jTableContratos.setModel(dtm);
        acomodar();
        jTableContratos.getColumnModel().getColumn(3).setMaxWidth(50);
        jTableContratos.getTableHeader().setFont(new Font("Cooper ", 1, 16));
        jTableContratos.getTableHeader().setBackground(new Color(101, 71, 182));
        jTableContratos.getTableHeader().setForeground(Color.white);
        jTableContratos.setRowHeight(22);
    }

    public void actualizarTabla() {
        cargarTabla(gdb.cargarContratosDto());
        acomodar();
    }

    public void acomodar() {
        jTableContratos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableContratos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableContratos.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableContratos.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableContratos.getColumnModel().getColumn(1).setMinWidth(0);
        jTableContratos.getColumnModel().getColumn(1).setPreferredWidth(0);

    }

    private void cantidadContratos() {
        int c = jTableContratos.getRowCount();
        jCantidad.setText(String.valueOf(c));
    }

    public void cargarComboDepartamento() {
        combo = new DefaultComboBoxModel();
        ArrayList<Departamento> departamentos = gdb.cargarDepartamentos();
        combo.addElement("Seleccione");
        for (Departamento d : departamentos) {
            combo.addElement(d);
        }

        cmbDepartamentos.setModel(combo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnVerContrato = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jCantidad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        jAño = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContratos = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

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

        btnVerContrato.setBackground(new java.awt.Color(101, 71, 182));
        btnVerContrato.setForeground(new java.awt.Color(255, 255, 255));
        btnVerContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/verContrato.png"))); // NOI18N
        btnVerContrato.setText("Ver contrato");
        btnVerContrato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerContrato.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVerContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerContratoActionPerformed(evt);
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
        txttitulo.setText("Consultar Contratos");

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
                .addGap(273, 273, 273)
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

        jLabel1.setText("Cantidad de contratos");

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

        jLabel2.setText("Año");

        cmbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Departamento");

        jTableContratos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableContratos.setGridColor(new java.awt.Color(101, 71, 182));
        jTableContratos.setSelectionBackground(new java.awt.Color(150, 128, 209));
        jTableContratos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableContratos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerContrato)
                .addGap(271, 271, 271)
                .addComponent(btnActualizar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerContrato)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (jTableContratos.getSelectedRowCount() > 0) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este contrato?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                int id = (int) jTableContratos.getValueAt(jTableContratos.getSelectedRow(), 0);
                gdb.eliminarContrato(id);
                actualizarTabla();
                cantidadContratos();
            } else {
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String depto = cmbDepartamentos.getSelectedItem().toString();
        //Departamento d = (Departamento) cmbDepartamentos.getSelectedItem();
        // String depto = String.valueOf(d.getId_departamento());
        String año = jAño.getSelectedItem().toString();
        if (jAño.getSelectedIndex() == 0) {
            año = "null";
        }
        if (cmbDepartamentos.getSelectedIndex() == 0) {
            depto = "null";
        }
        ArrayList<dtoContratoAlquiler> contratos = gdb.filtroContratos(depto, año);
        cargarTabla(contratos);
        acomodar();
        cantidadContratos();

    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnVerContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerContratoActionPerformed
        if (jTableContratos.getSelectedRowCount() > 0) {
            int id_alquiler = (int) jTableContratos.getValueAt(jTableContratos.getSelectedRow(), 1);
            try {
                Connection conn = Reportes.conectar();
                Map<String, Object> parametros = new HashMap();

                parametros.put("id_alquiler", id_alquiler);
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\Contrato.jasper", parametros);
                Reportes.mostrar();
                actualizarTabla();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            actualizarTabla();
        }


    }//GEN-LAST:event_btnVerContratoActionPerformed

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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cmbDepartamentos.setSelectedIndex(0);
        jAño.setSelectedIndex(0);
        actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarContratos dialog = new ConsultarContratos(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnVerContrato;
    private javax.swing.JComboBox<String> cmbDepartamentos;
    private javax.swing.JComboBox<String> jAño;
    private javax.swing.JLabel jCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContratos;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
