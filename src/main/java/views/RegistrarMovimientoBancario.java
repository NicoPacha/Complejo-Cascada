package views;

import models.GestorDB;
import models.MovimientoBancario;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistrarMovimientoBancario extends javax.swing.JDialog {

    GestorDB gdb;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarMovimientoBancario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    RegistrarMovimientoBancario(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();
        txttitulo.setText("Modificar Movimiento Bancario");
        btnMovimientoBancario.setVisible(false);
        btnModificar.setVisible(true);

        MovimientoBancario mb = gdb.cargarMovimientoId(id);
        txtId.setText(String.valueOf(mb.getId_movimiento_bancario()));
        if (mb != null) {
            txtConcepto.setText(mb.getConcepto());
            jFechaMovimiento.setDate(mb.getFecha_movimiento());
            txtEntrada.setText(String.valueOf(mb.getEntrada()));
            txtSalida.setText(String.valueOf(mb.getSalida()));
        }
    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        gdb = new GestorDB();
        txtId.setVisible(false);
        v.validarNumerosPuntos(txtEntrada);
        v.validarNumerosPuntos(txtSalida);
    }

    public float Saldo() {
        String año = String.valueOf(jFechaMovimiento.getDate().getYear());
        float saldoFinal = 0;
        float saldo = gdb.SaldoMovimientos("null", año);
        float entrada = v.formatearDecimales(Float.parseFloat(txtEntrada.getText()), 2);
        float salida = v.formatearDecimales(Float.parseFloat(txtSalida.getText()), 2);

        if (salida == 0) {
            saldoFinal = saldo + entrada;
        } else {
            saldoFinal = saldo - salida;
        }
        return saldoFinal;
    }

    public float SaldoModificar(int id) {
        float saldoFinal = 0;
        float saldo = gdb.SaldoMovimientoId(id);
        float entrada = v.formatearDecimales(Float.parseFloat(txtEntrada.getText()), 2);
        float salida = v.formatearDecimales(Float.parseFloat(txtSalida.getText()), 2);

        if (salida == 0) {
            saldoFinal = saldo + entrada;
        } else {
            saldoFinal = saldo - salida;
        }
        return saldoFinal;
    }

    private boolean validar() {
        if (txtConcepto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe poner el concepto del movimiento bancario", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaMovimiento.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir la fecha del movimiento bancario", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        txtConcepto.setText("");
        jFechaMovimiento.setDate(null);
        txtEntrada.setText("");
        txtSalida.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMovimientoBancario = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        jFechaMovimiento = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnMovimientoBancario.setBackground(new java.awt.Color(101, 71, 182));
        btnMovimientoBancario.setForeground(new java.awt.Color(255, 255, 255));
        btnMovimientoBancario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnMovimientoBancario.setText("Registrar Movimiento Bancario");
        btnMovimientoBancario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMovimientoBancario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMovimientoBancario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientoBancarioActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modficar movimiento bancario");
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
        txttitulo.setText("Registrar Movimiento Bancario");

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
                .addGap(45, 45, 45)
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Concepto");

        txtConcepto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Fecha de movimiento");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Entrada");

        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEntrada.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Salida");

        txtSalida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSalida.setText("0");
        txtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaActionPerformed(evt);
            }
        });

        jFechaMovimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFechaMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtConcepto))
                        .addGap(108, 108, 108))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFechaMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnMovimientoBancario))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMovimientoBancario)
                    .addComponent(btnModificar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovimientoBancarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientoBancarioActionPerformed
        if (validar()) {
            String concepto = txtConcepto.getText();
            Date fechaMovimiento = (Date) jFechaMovimiento.getDate();
            float entrada = v.formatearDecimales(Float.parseFloat(txtEntrada.getText()), 2);
            float salida = v.formatearDecimales(Float.parseFloat(txtSalida.getText()), 2);
            float saldo = Saldo();
            if (txtEntrada.getText().equals("")) {
                entrada = 0;
            }
            if (txtSalida.getText().equals("")) {
                salida = 0;
            }

            MovimientoBancario mb = new MovimientoBancario(concepto, fechaMovimiento, entrada, salida, saldo);

            gdb.agregarMovimientoBancario(mb);
            DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
            limpiar();
        }

    }//GEN-LAST:event_btnMovimientoBancarioActionPerformed

    private void txtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaActionPerformed

    }//GEN-LAST:event_txtSalidaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            String concepto = txtConcepto.getText();
            Date fechaMovimiento = (Date) jFechaMovimiento.getDate();
            float entrada = v.formatearDecimales(Float.parseFloat(txtEntrada.getText()), 2);
            float salida = v.formatearDecimales(Float.parseFloat(txtSalida.getText()), 2);
            float saldo = SaldoModificar(id);
            if (txtEntrada.getText().equals("")) {
                entrada = 0;
            }
            if (txtSalida.getText().equals("")) {
                salida = 0;
            }

            MovimientoBancario mb = new MovimientoBancario(concepto, fechaMovimiento, entrada, salida, saldo);

            gdb.modificarMovimientoBancario(mb, id);
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
            java.util.logging.Logger.getLogger(RegistrarMovimientoBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarMovimientoBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarMovimientoBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarMovimientoBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarMovimientoBancario dialog = new RegistrarMovimientoBancario(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnMovimientoBancario;
    private com.toedter.calendar.JCalendar jFechaMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
