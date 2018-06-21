package views;

import models.Cliente;
import models.GestorDB;
import models.Provincia;
import models.TipoDocumento;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class RegistrarCliente extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultComboBoxModel combo;
    DefaultComboBoxModel combo2;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarCliente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    //MODIFICAR
    RegistrarCliente(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();

        txttitulo.setText("Modificar Cliente");
        btnCliente.setVisible(false);
        btnModificar.setVisible(true);

        Cliente c = gdb.cargarClienteId(id);

        if (c != null) {
            txtId.setText(String.valueOf(c.getId_cliente()));
            txtNombre.setText(c.getNombre());
            txtApellido.setText(c.getApellido());
            int prov = c.getId_provincia();
            for (int i = 0; i < combo.getSize(); i++) {
                Provincia p = (Provincia) combo.getElementAt(i);
                if (p.getId_provincia() == prov) {
                    cmbProvincia.setSelectedItem(p);
                    break;
                }
            }
            txtPueblo.setText(c.getPueblo());
            txtTelefono.setText(String.valueOf(c.getTelefono()));
            int doc = c.getId_tipo_documento();
            for (int n = 0; n < combo2.getSize(); n++) {
                TipoDocumento t = (TipoDocumento) combo2.getElementAt(n);
                if (t.getId_tipo_documento() == doc) {
                    cmbTipoDocumento.setSelectedItem(t);
                    break;
                }
            }
            txtDocumento.setText(String.valueOf(c.getDocumento()));
        }

    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbProvincia.setBackground(new Color(255, 255, 255));
        cmbTipoDocumento.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        cargarComboProvincias();
        cargarComboTiposDocumento();
        txtId.setVisible(false);
        v.validarSoloLetras(txtNombre);
        v.validarSoloLetras(txtApellido);
        v.validarSoloNumeros(txtTelefono);
        v.validarSoloNumeros(txtDocumento);
    }

    public void cargarComboProvincias() {
        combo = new DefaultComboBoxModel();
        ArrayList<Provincia> provincias = gdb.cargarProvincias();
        for (Provincia p : provincias) {
            combo.addElement(p);
        }
        cmbProvincia.setModel(combo);
    }

    public void cargarComboTiposDocumento() {
        combo2 = new DefaultComboBoxModel();
        ArrayList<TipoDocumento> tiposDocumento = gdb.cargarTiposDocumento();
        for (TipoDocumento td : tiposDocumento) {
            combo2.addElement(td);
        }
        cmbTipoDocumento.setModel(combo2);
    }

    private boolean validar() {
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe poner el nombre del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            // DesktopNotify.showDesktopMessage("Error","Debe poner el nombre del cliente", DesktopNotify.ERROR, 5000);
            return false;
        }
        if (txtApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe poner el apellido del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cmbProvincia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir una provincia", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtPueblo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe poner el pueblo/ciudad del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el numero de telefono del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cmbTipoDocumento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir el tipo de documento", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtDocumento.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el numero de documento del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        cmbProvincia.setSelectedIndex(0);
        txtPueblo.setText("");
        txtTelefono.setText("");
        cmbTipoDocumento.setSelectedIndex(0);
        txtDocumento.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCliente = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtPueblo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox<>();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnCliente.setBackground(new java.awt.Color(101, 71, 182));
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnCliente.setText("Registrar Cliente");
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar Cliente");
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
        txttitulo.setText("Registrar Cliente");

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
                .addGap(153, 153, 153)
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

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPueblo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDocumento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cmbProvincia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTipoDocumento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Provincia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ciudad/Pueblo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tipo de documento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Num. Documento");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPueblo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPueblo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCliente)
                    .addComponent(btnModificar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        if (validar()) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            Provincia p = (Provincia) cmbProvincia.getSelectedItem();
            int id_provincia = p.getId_provincia();
            String pueblo = txtPueblo.getText();
            long telefono = Long.parseLong(txtTelefono.getText());
            TipoDocumento td = (TipoDocumento) cmbTipoDocumento.getSelectedItem();
            int id_tipo_documento = td.getId_tipo_documento();
            long documento = Long.parseLong(txtDocumento.getText());

            Cliente c = new Cliente(nombre, apellido, id_provincia, pueblo, telefono, id_tipo_documento, documento);

            if (documento == gdb.traerDocumento()) {
                JOptionPane.showMessageDialog(this, "Ya hay un cliente registrado con ese numero de documento", "Error", JOptionPane.ERROR_MESSAGE);
                DesktopNotify.showDesktopMessage("No se puede registrar", "Ya hay un cliente registrado con ese numero de documento", DesktopNotify.FAIL, 7000);
            } else {
                gdb.agregarCliente(c);
                limpiar();
                DesktopNotify.showDesktopMessage("Exito", "Se registro el cliente con exito:" + nombre + " " + apellido + "", DesktopNotify.SUCCESS, 7000);
            }
        }

    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            Provincia p = (Provincia) cmbProvincia.getSelectedItem();
            int id_provincia = p.getId_provincia();
            String pueblo = txtPueblo.getText();
            long telefono = Long.parseLong(txtTelefono.getText());
            TipoDocumento td = (TipoDocumento) cmbTipoDocumento.getSelectedItem();
            int id_tipo_documento = td.getId_tipo_documento();
            long documento = Long.parseLong(txtDocumento.getText());

            Cliente c = new Cliente(nombre, apellido, id_provincia, pueblo, telefono, id_tipo_documento, documento);

            gdb.modificarCliente(c, id);
            limpiar();
            DesktopNotify.showDesktopMessage("Exito", "Se modifico el cliente con exito:" + nombre + " " + apellido + "", DesktopNotify.SUCCESS, 7000);
            this.dispose();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cmbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocumentoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarCliente dialog = new RegistrarCliente(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbProvincia;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPueblo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
