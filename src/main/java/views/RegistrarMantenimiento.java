package views;

import models.BalanceGeneral;
import models.GestorDB;
import models.Mantenimiento;
import models.MantenimientoBalance;
import models.TipoMantenimiento;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class RegistrarMantenimiento extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultComboBoxModel combo;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarMantenimiento(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    RegistrarMantenimiento(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();
        txttitulo.setText("Modificar Mantenimiento");
        btnModificar.setVisible(true);
        btnRegistrarMantenimiento.setVisible(false);

        Mantenimiento m = gdb.cargarMantenimientoId(id);
        txtId.setText(String.valueOf(m.getId_mantenimiento()));
        if (m != null) {
            int tipoMantenimiento = m.getId_tipo_mantenimiento();
            for (int i = 0; i < combo.getSize(); i++) {
                TipoMantenimiento t = (TipoMantenimiento) combo.getElementAt(i);
                if (t.getId_tipo_mantenimiento() == tipoMantenimiento) {
                    cmbTipoMantenimiento.setSelectedItem(t);
                    break;
                }
            }
            jFecha.setDate(m.getFecha_mantenimiento());
        }
        txtMonto.setText(String.valueOf(m.getMonto()));
        txtAgregado.setText(m.getAgregado());
    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbTipoMantenimiento.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        cargarComboTipoMantenimiento();
        txtId.setVisible(false);
        v.validarNumerosPuntos(txtMonto);
    }

    public void cargarComboTipoMantenimiento() {
        combo = new DefaultComboBoxModel();
        ArrayList<TipoMantenimiento> tipos = gdb.cargarTiposMantenimiento();
        for (TipoMantenimiento tm : tipos) {
            combo.addElement(tm);
        }
        cmbTipoMantenimiento.setModel(combo);
    }

    private boolean validar() {
        if (cmbTipoMantenimiento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir el tipo de mantenimiento", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una fecha de inicio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMonto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el monto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        cmbTipoMantenimiento.setSelectedIndex(0);
        jFecha.setDate(new Date());
        txtMonto.setText("");
        txtAgregado.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarMantenimiento = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAgregado = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoMantenimiento = new javax.swing.JComboBox<>();
        jFecha = new com.toedter.calendar.JCalendar();
        txtMonto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnRegistrarMantenimiento.setBackground(new java.awt.Color(101, 71, 182));
        btnRegistrarMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnRegistrarMantenimiento.setText("Registrar Mantenimiento");
        btnRegistrarMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarMantenimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMantenimientoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar Mantenimiento");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
        txttitulo.setText("Registrar Mantenimiento");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttitulo)
                .addGap(56, 56, 56)
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Fecha ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Descripcion/Agregado");

        txtAgregado.setColumns(20);
        txtAgregado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAgregado.setRows(5);
        jScrollPane1.setViewportView(txtAgregado);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Monto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tipo de Mantenimiento");

        cmbTipoMantenimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoMantenimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbTipoMantenimiento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarMantenimiento))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarMantenimiento)
                    .addComponent(btnModificar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMantenimientoActionPerformed
        if (validar()) {
            TipoMantenimiento tm = (TipoMantenimiento) cmbTipoMantenimiento.getSelectedItem();
            int id_tipo_mantenimiento = tm.getId_tipo_mantenimiento();
            Date Fecha = (Date) jFecha.getDate();
            float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            String agregado = txtAgregado.getText();
            String año = String.valueOf(jFecha.getDate().getYear());

            Mantenimiento m = new Mantenimiento(id_tipo_mantenimiento, Fecha, monto, agregado);

            gdb.agregarMantenimiento(m);

            //Balance General
            //AGARRAR ULTIMO ID INGRESADO
            int ultimoIdMantenimiento = gdb.ultimoIdMantenimiento();
            //AGREGAR A BALANCE GENERAL
            String concepto = String.valueOf("Mantenimiento de:" + cmbTipoMantenimiento.getSelectedItem().toString() + ", " + txtAgregado.getText() + " $" + monto);
            float saldo = gdb.SaldoBalance("null", año) - monto;
            BalanceGeneral bg = new BalanceGeneral(concepto, Fecha, 0, monto, saldo);
            gdb.agregarBalance(bg);
            //AGARRAR EL ULTIMO ID DEL BALANCE
            int ultimoIdBalance = gdb.ultimoIdBalanceGeneral();
            //AGREGAR A IMPUESTOBALANCE
            MantenimientoBalance mb = new MantenimientoBalance(ultimoIdMantenimiento, ultimoIdBalance);
            gdb.agregarMantenimientoBalance(mb);

            limpiar();
            DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);

        }
    }//GEN-LAST:event_btnRegistrarMantenimientoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            TipoMantenimiento tm = (TipoMantenimiento) cmbTipoMantenimiento.getSelectedItem();
            int id_tipo_mantenimiento = tm.getId_tipo_mantenimiento();
            Date Fecha = (Date) jFecha.getDate();
            float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            String agregado = txtAgregado.getText();

            Mantenimiento m = new Mantenimiento(id_tipo_mantenimiento, Fecha, monto, agregado);
            gdb.modificarMantenimiento(m, id);

            //BALANCE GENERAL
            String concepto = String.valueOf("Mantenimiento de:" + cmbTipoMantenimiento.getSelectedItem().toString() + ", " + txtAgregado.getText() + " ,$" + monto);
            int id_balance_general = gdb.balanceMantenimientoWhere(id);
            float saldoAnterior = gdb.SaldoBalanceId(id_balance_general);
            float saldo = saldoAnterior - monto;
            BalanceGeneral bg = new BalanceGeneral(concepto, Fecha, 0, monto, saldo);

            gdb.modificarBalanceGeneral(bg, id_balance_general);

            limpiar();
            DesktopNotify.showDesktopMessage("Modificado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
            this.dispose();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarMantenimiento dialog = new RegistrarMantenimiento(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrarMantenimiento;
    private javax.swing.JComboBox<String> cmbTipoMantenimiento;
    private com.toedter.calendar.JCalendar jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAgregado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
