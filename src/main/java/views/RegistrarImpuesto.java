package views;

import models.BalanceGeneral;
import models.GestorDB;
import models.Impuesto;
import models.ImpuestoBalance;
import models.TipoImpuesto;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarImpuesto extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultComboBoxModel combo;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarImpuesto(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    RegistrarImpuesto(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();
        txttitulo.setText("Modificar Impuesto");
        btnModificar.setVisible(true);
        btnRegistrarImpuesto.setVisible(false);

        Impuesto i = gdb.cargarImpuestoId(id);
        txtId.setText(String.valueOf(i.getId_impuesto()));
        if (i != null) {
            int tipoImpuesto = i.getId_tipo_impuesto();
            for (int o = 0; o < combo.getSize(); o++) {
                TipoImpuesto t = (TipoImpuesto) combo.getElementAt(o);
                if (t.getId_tipo_impuesto() == tipoImpuesto) {
                    cmbTipoImpuesto.setSelectedItem(t);
                    break;
                }
            }
            jMes.setDate(i.getFecha_impuesto());
            jFechaPago.setDate(i.getFecha_pago());
            jFechaFin.setDate(i.getFecha_impuesto_fin());
            txtMonto.setText(String.valueOf(i.getMonto()));
        }
    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbTipoImpuesto.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        cargarComboTipoImpuesto();
        txtId.setVisible(false);
        v.validarNumerosPuntos(txtMonto);
        ((JTextField) this.jFechaPago.getDateEditor()).setEditable(false);
        ((JTextField) this.jFechaFin.getDateEditor()).setEditable(false);
    }

    public void cargarComboTipoImpuesto() {
        combo = new DefaultComboBoxModel();
        ArrayList<TipoImpuesto> tipos = gdb.cargarTiposImpuestos();
        for (TipoImpuesto ti : tipos) {
            combo.addElement(ti);
        }
        cmbTipoImpuesto.setModel(combo);
    }

    private boolean validar() {
        if (cmbTipoImpuesto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir el tipo de impuesto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaPago.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una fecha de inicio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una fecha de finalizado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMonto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el monto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        cmbTipoImpuesto.setSelectedIndex(0);
        jFechaPago.setDate(null);
        jFechaFin.setDate(null);
        txtMonto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarImpuesto = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMes = new com.toedter.calendar.JCalendar();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoImpuesto = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        jFechaPago = new com.toedter.calendar.JDateChooser();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnRegistrarImpuesto.setBackground(new java.awt.Color(101, 71, 182));
        btnRegistrarImpuesto.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarImpuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnRegistrarImpuesto.setText("Registrar Impuesto");
        btnRegistrarImpuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarImpuesto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarImpuestoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar Impuesto");
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
        txttitulo.setText("Registrar Impuesto");

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
                .addGap(120, 120, 120)
                .addComponent(txttitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tipo de impuesto");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Fecha de pago");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mes");

        jMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Monto");

        cmbTipoImpuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jFechaPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jFechaFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Fecha vencimiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(37, Short.MAX_VALUE))
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
                .addComponent(btnRegistrarImpuesto))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarImpuesto)
                    .addComponent(btnModificar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarImpuestoActionPerformed
        if (validar()) {
            TipoImpuesto ti = (TipoImpuesto) cmbTipoImpuesto.getSelectedItem();
            int id_tipo_impuesto = ti.getId_tipo_impuesto();
            Date Fecha = (Date) jMes.getDate();
            float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            Date FechaFin = (Date) jFechaFin.getDate();
            Date FechaPago = (Date) jFechaPago.getDate();
            String año = String.valueOf(jMes.getDate().getYear());

            Impuesto i = new Impuesto(id_tipo_impuesto, Fecha, FechaFin, FechaPago, monto);

            gdb.agregarImpuesto(i);

            //AGARRAR ULTIMO ID INGRESADO
            int ultimoIdImpuesto = gdb.ultimoIdImpuesto();
            //AGREGAR A BALANCE GENERAL
            String concepto = String.valueOf("Impuesto de:" + cmbTipoImpuesto.getSelectedItem().toString() + "  $" + monto);
            float saldo = gdb.SaldoBalance("null", año) - monto;
            BalanceGeneral bg = new BalanceGeneral(concepto, FechaPago, 0, monto, saldo);
            gdb.agregarBalance(bg);
            //AGARRAR EL ULTIMO ID DEL BALANCE
            int ultimoIdBalance = gdb.ultimoIdBalanceGeneral();
            //AGREGAR A IMPUESTOBALANCE
            ImpuestoBalance ib = new ImpuestoBalance(ultimoIdImpuesto, ultimoIdBalance);
            gdb.agregarImpuestoBalance(ib);

            limpiar();
            DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
        }
    }//GEN-LAST:event_btnRegistrarImpuestoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            TipoImpuesto ti = (TipoImpuesto) cmbTipoImpuesto.getSelectedItem();
            int id_tipo_impuesto = ti.getId_tipo_impuesto();
            Date Fecha = (Date) jMes.getDate();
            float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            Date FechaFin = (Date) jFechaFin.getDate();
            Date FechaPago = (Date) jFechaPago.getDate();

            Impuesto i = new Impuesto(id_tipo_impuesto, Fecha, FechaFin, FechaPago, monto);
            gdb.modificarImpuesto(i, id);

            //BALANCE GENERAL
            String concepto = String.valueOf("Impuesto de:" + cmbTipoImpuesto.getSelectedItem().toString() + " $" + monto);
            float saldoAnterior = gdb.SaldoBalanceId(id);
            float saldo = saldoAnterior - monto;
            BalanceGeneral bg = new BalanceGeneral(concepto, FechaPago, 0, monto, saldo);
            int id_balance_general = gdb.balanceImpuestoWhere(id);
            gdb.modificarBalanceGeneral(bg, id_balance_general);

            DesktopNotify.showDesktopMessage("Modificado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
            limpiar();
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
            java.util.logging.Logger.getLogger(RegistrarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarImpuesto dialog = new RegistrarImpuesto(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnRegistrarImpuesto;
    private javax.swing.JComboBox<String> cmbTipoImpuesto;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JCalendar jMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
