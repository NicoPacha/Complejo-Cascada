package views;

import models.BalanceGeneral;
import models.GestorDB;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistrarBalance extends javax.swing.JDialog {

    GestorDB gdb;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarBalance(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    RegistrarBalance(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();

        txttitulo.setText("Modificar Balance");
        btnBalance.setVisible(false);
        btnModificar.setVisible(true);

        BalanceGeneral b = gdb.cargarBalanceId(id);
        txtId.setText(String.valueOf(b.getId_balance_general()));
        if (b != null) {
            txtConcepto.setText(b.getConcepto());
            jFechaBalance.setDate(b.getFecha());
            txtEntrada.setText(String.valueOf(b.getEntrada()));
            txtSalida.setText(String.valueOf(b.getSalida()));
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
        String año = String.valueOf(jFechaBalance.getDate().getYear());
        float saldoFinal = 0;
        float saldo = gdb.SaldoBalance("null", año);
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
        float saldo = gdb.SaldoBalanceId(id);
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
            JOptionPane.showMessageDialog(this, "Debe poner el concepto del balance", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaBalance.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir la fecha de registro del balance", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        txtConcepto.setText("");
        jFechaBalance.setDate(null);
        txtEntrada.setText("");
        txtSalida.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBalance = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtConcepto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        txtSalida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jFechaBalance = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnBalance.setBackground(new java.awt.Color(101, 71, 182));
        btnBalance.setForeground(new java.awt.Color(255, 255, 255));
        btnBalance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnBalance.setText("Registrar Balance");
        btnBalance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBalance.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar Balance");
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
        txttitulo.setText("Registrar Balance");

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
                .addGap(140, 140, 140)
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

        txtConcepto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Concepto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Fecha ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Entrada");

        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEntrada.setText("0");

        txtSalida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSalida.setText("0");
        txtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Salida");

        jFechaBalance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jFechaBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBalance))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBalance)
                    .addComponent(btnModificar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaActionPerformed

    private void btnBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceActionPerformed
        if (validar()) {
            String concepto = txtConcepto.getText();
            Date fecha = (Date) jFechaBalance.getDate();
            float entrada = v.formatearDecimales(Float.parseFloat(txtEntrada.getText()), 2);
            float salida = v.formatearDecimales(Float.parseFloat(txtSalida.getText()), 2);
            float saldo = Saldo();
            if (txtEntrada.getText().equals("")) {
                entrada = 0;
            }
            if (txtSalida.getText().equals("")) {
                salida = 0;
            }

            BalanceGeneral bg = new BalanceGeneral(concepto, fecha, entrada, salida, saldo);

            gdb.agregarBalance(bg);
            DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
            limpiar();
        }
    }//GEN-LAST:event_btnBalanceActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            String concepto = txtConcepto.getText();
            Date fecha = (Date) jFechaBalance.getDate();
            float entrada = v.formatearDecimales(Float.parseFloat(txtEntrada.getText()),2);
            float salida = v.formatearDecimales(Float.parseFloat(txtSalida.getText()),2); 
            float saldo = SaldoModificar(id);

            BalanceGeneral bg = new BalanceGeneral(concepto, fecha, entrada, salida, saldo);

            gdb.modificarBalanceGeneral(bg, id);
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
            java.util.logging.Logger.getLogger(RegistrarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarBalance dialog = new RegistrarBalance(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnBalance;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnModificar;
    private com.toedter.calendar.JCalendar jFechaBalance;
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
