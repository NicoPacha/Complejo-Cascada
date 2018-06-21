package views;

import models.BalanceGeneral;
import models.GestorDB;
import models.Servicio;
import models.ServicioBalance;
import models.TipoServicio;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarServicio extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultComboBoxModel combo;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarServicio(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    RegistrarServicio(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();
        txttitulo.setText("Modificar Servicio");
        btnModificar.setVisible(true);
        btnRegistrarServicio.setVisible(false);

        Servicio s = gdb.cargarServicioId(id);
        txtId.setText(String.valueOf(s.getId_servicio()));
        if (s != null) {
            int tipoServicio = s.getId_tipo_servicio();
            for (int i = 0; i < combo.getSize(); i++) {
                TipoServicio t = (TipoServicio) combo.getElementAt(i);
                if (t.getId_tipo_servicio() == tipoServicio) {
                    cmbTipoServicio.setSelectedItem(t);
                    break;
                }
            }
            jMes.setDate(s.getFecha_servicio());
            jFechaFin.setDate(s.getFecha_servicio_fin());
            jFechaPago.setDate(s.getFecha_pago());
            txtMonto.setText(String.valueOf(s.getMonto()));
        }
    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbTipoServicio.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        cargarComboTipoServicios();
        txtId.setVisible(false);
        v.validarNumerosPuntos(txtMonto);
        ((JTextField) this.jFechaPago.getDateEditor()).setEditable(false);
        ((JTextField) this.jFechaFin.getDateEditor()).setEditable(false);
    }

    public void cargarComboTipoServicios() {
        combo = new DefaultComboBoxModel();
        ArrayList<TipoServicio> tipos = gdb.cargarTiposServicios();
        for (TipoServicio ts : tipos) {
            combo.addElement(ts);
        }
        cmbTipoServicio.setModel(combo);
    }

    private boolean validar() {
        if (cmbTipoServicio.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir el tipo de servicio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jMes.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir el mes correspondiente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir la fecha de vencimiento", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaPago.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir la fecha de pago", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMonto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el monto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        cmbTipoServicio.setSelectedIndex(0);
        //jMes.setDate(null);
        jFechaFin.setDate(null);
        jFechaPago.setDate(null);
        txtMonto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarServicio = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtMonto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        jMes = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTipoServicio = new javax.swing.JComboBox<>();
        jFechaPago = new com.toedter.calendar.JDateChooser();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnRegistrarServicio.setBackground(new java.awt.Color(101, 71, 182));
        btnRegistrarServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnRegistrarServicio.setText("Registrar Servicio");
        btnRegistrarServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarServicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarServicioActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar Servicio");
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
        txttitulo.setText("Registrar Servicio");

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
                .addGap(118, 118, 118)
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

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Monto");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Fecha de vencimiento");

        jFechaFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tipo de Servicio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Fecha de pago");

        cmbTipoServicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jFechaPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jFechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFechaPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarServicio))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addComponent(btnRegistrarServicio)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarServicioActionPerformed
        if (validar()) {
            TipoServicio ts = (TipoServicio) cmbTipoServicio.getSelectedItem();
            int id_tipo_servicio = ts.getId_tipo_servicio();
            Date Mes = (Date) jMes.getDate();
            Date FechaFin = (Date) jFechaFin.getDate();
            Date FechaPago = (Date) jFechaPago.getDate();
            Float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            String año = String.valueOf(jMes.getDate().getYear());

            Servicio s = new Servicio(id_tipo_servicio, Mes, FechaFin, FechaPago, monto);

            gdb.agregarServicio(s);

            //Balance General
            //AGARRAR ULTIMO ID INGRESADO
            int ultimoIdServicio = gdb.ultimoIdServicio();
            //AGREGAR A BALANCE GENERAL
            String concepto = "Servicio de" + cmbTipoServicio.getSelectedItem().toString() + "  $" + monto;
            float saldo = gdb.SaldoBalance("null", año) - monto;
            BalanceGeneral bg = new BalanceGeneral(concepto, Mes, 0, monto, saldo);
            gdb.agregarBalance(bg);
            //AGARRAR EL ULTIMO ID DEL BALANCE
            int ultimoIdBalance = gdb.ultimoIdBalanceGeneral();
            //AGREGAR A IMPUESTOBALANCE
            ServicioBalance sb = new ServicioBalance(ultimoIdServicio, ultimoIdBalance);
            gdb.agregarServicioBalance(sb);

            limpiar();
            DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
        }
    }//GEN-LAST:event_btnRegistrarServicioActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            TipoServicio ts = (TipoServicio) cmbTipoServicio.getSelectedItem();
            int id_tipo_servicio = ts.getId_tipo_servicio();
            Date Mes = (Date) jMes.getDate();
            Date FechaFin = (Date) jFechaFin.getDate();
            Date FechaPago = (Date) jFechaPago.getDate();
            Float monto = Float.parseFloat(txtMonto.getText());

            Servicio s = new Servicio(id_tipo_servicio, Mes, FechaFin, FechaPago, monto);
            gdb.modificarServicio(s, id);

            //BALANCE GENERAL
            String concepto = "Servicio de" + cmbTipoServicio.getSelectedItem().toString() + "  $" + monto;
            float saldoAnterior = gdb.SaldoBalanceId(id);
            float saldo = saldoAnterior - monto;
            BalanceGeneral bg = new BalanceGeneral(concepto, Mes, 0, monto, saldo);
            int id_balance_general = gdb.balanceServicioWhere(id);
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
            java.util.logging.Logger.getLogger(RegistrarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarServicio dialog = new RegistrarServicio(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnRegistrarServicio;
    private javax.swing.JComboBox<String> cmbTipoServicio;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JCalendar jMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
