package views;

import models.Alquiler;
import models.Cliente;
import models.Departamento;
import models.GestorDB;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import java.text.ParseException;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ds.desktop.notify.DesktopNotify;

import java.awt.Color;
import javax.swing.JTextField;

public class RegistrarAlquiler extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultComboBoxModel combo;
    DefaultComboBoxModel combo2;
    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
    SimpleDateFormat otroFormato = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
    SimpleDateFormat otroFormato2 = new SimpleDateFormat("yyyy/dd/MM", Locale.ENGLISH);
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;

    public RegistrarAlquiler(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();//Siempre arriba de todo
        cargar();
        btnModificarAlquiler.setVisible(false);

    }

    public RegistrarAlquiler(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();
        txttitulo.setText("Modificar Alquiler");
        btnRegistrarAlquiler.setVisible(false);
        btnModificarAlquiler.setVisible(true);

        Alquiler a = gdb.cargarAlquilerId(id);

        if (a != null) {
            txtId.setText(String.valueOf(a.getId_alquiler()));
            int departamento = a.getId_departamento();
            for (int i = 0; i < combo.getSize(); i++) {
                Departamento d = (Departamento) combo.getElementAt(i);
                if (d.getId_departamento() == departamento) {
                    cmbDepartamentos.setSelectedItem(d);
                    break;
                }
            }
            jFechaInicio.setDate(a.getFecha_inicio());
            jFechaFin.setDate(a.getFecha_fin());
            int cliente = a.getId_cliente();
            for (int n = 0; n < combo2.getSize(); n++) {
                Cliente c = (Cliente) combo2.getElementAt(n);
                if (c.getId_cliente() == cliente) {
                    cmbClientes.setSelectedItem(c);
                    break;
                }
            }
            txtCantPersonas.setText(String.valueOf(a.getCantidad_personas()));
            txtMontoTotal.setText(String.valueOf(a.getTotal()));
        }

    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbDepartamentos.setBackground(new Color(255, 255, 255));
        cmbClientes.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        cargarComboDepartamento();
        cargarComboCliente();
        v.validarSoloNumeros(txtCantPersonas);
        v.validarNumerosPuntos(txtMontoTotal);
        v.limitarCaracteres(txtCantPersonas, 2);
        txtId.setVisible(false);
        ((JTextField) this.jFechaInicio.getDateEditor()).setEditable(false);
        ((JTextField) this.jFechaFin.getDateEditor()).setEditable(false);

    }

    public void cargarComboDepartamento() {
        combo = new DefaultComboBoxModel();
        ArrayList<Departamento> departamentos = gdb.cargarDepartamentos();
        //combo.addElement("Seleccione");
        for (Departamento d : departamentos) {
            combo.addElement(d);
        }
        cmbDepartamentos.setModel(combo);
    }

    public void cargarComboCliente() {
        combo2 = new DefaultComboBoxModel();
        ArrayList<Cliente> clientes = gdb.cargarClientes();
        for (Cliente c : clientes) {
            combo2.addElement(c);
        }
        cmbClientes.setModel(combo2);
    }

    public boolean validar() {
        if (jFechaInicio.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una fecha de inicio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una fecha de finalizado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaInicio.getDate().after(jFechaFin.getDate())) {
            JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser mayor a la fecha de finalizado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cmbClientes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtCantPersonas.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar una cantidad de personas", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Integer.parseInt(txtCantPersonas.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "La cantidad de personas no puede ser mas de 10 ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMontoTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el monto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void limpiar() {
        jFechaInicio.setDate(null);
        jFechaFin.setDate(null);
        cmbClientes.setSelectedIndex(0);
        cmbDepartamentos.setSelectedIndex(0);
        txtCantPersonas.setText("");
        txtMontoTotal.setText("");
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantPersonas = new javax.swing.JTextField();
        txtMontoTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblDias = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnModificarAlquiler = new javax.swing.JButton();
        btnRegistrarAlquiler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Fecha de inicio");

        jFechaInicio.setBackground(new java.awt.Color(102, 255, 102));
        jFechaInicio.setForeground(new java.awt.Color(0, 255, 51));
        jFechaInicio.setToolTipText("");
        jFechaInicio.setDateFormatString("yyyy-MMM-dd");
        jFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFechaInicio.setMaxSelectableDate(new java.util.Date(253370779302000L));
        jFechaInicio.setMinSelectableDate(new java.util.Date(631162902000L));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Fecha de fin");

        jFechaFin.setBackground(new java.awt.Color(255, 51, 51));
        jFechaFin.setForeground(new java.awt.Color(255, 0, 0));
        jFechaFin.setDateFormatString("yyyy-MMM-dd");
        jFechaFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFechaFin.setMinSelectableDate(new java.util.Date(631162902000L));
        jFechaFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFechaFinFocusLost(evt);
            }
        });
        jFechaFin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jFechaFinMouseExited(evt);
            }
        });
        jFechaFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFechaFinPropertyChange(evt);
            }
        });

        cmbClientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad de personas");

        txtCantPersonas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtMontoTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Departamento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Monto total");

        cmbDepartamentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbDepartamentos.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Dias");

        lblDias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMontoTotal)
                            .addComponent(jFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblDias, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)))
                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDias, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(37, 37, 37))
        );

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
        txttitulo.setText("Registrar Alquiler");

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
                .addGap(128, 128, 128)
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

        btnModificarAlquiler.setBackground(new java.awt.Color(101, 71, 182));
        btnModificarAlquiler.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAlquiler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificarAlquiler.setText("Modificar Alquiler");
        btnModificarAlquiler.setToolTipText("");
        btnModificarAlquiler.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarAlquiler.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAlquilerActionPerformed(evt);
            }
        });

        btnRegistrarAlquiler.setBackground(new java.awt.Color(101, 71, 182));
        btnRegistrarAlquiler.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarAlquiler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnRegistrarAlquiler.setText("Registrar Alquiler");
        btnRegistrarAlquiler.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarAlquiler.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAlquilerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarAlquiler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarAlquiler)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarAlquiler)
                    .addComponent(btnRegistrarAlquiler)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAlquilerActionPerformed

        try {
            if (validar()) {
                Departamento d = (Departamento) cmbDepartamentos.getSelectedItem();
                int id_departamento = d.getId_departamento();
                int num_departamento = d.getNum_departamento();
                //Fecha Inicio
                String fechaI = String.valueOf(jFechaInicio.getDate());
                Date fecha_inicio = (Date) sdf.parse(fechaI);
                String fi = String.valueOf(otroFormato2.format(fecha_inicio));
                Date fechaInicio = (Date) jFechaInicio.getDate();
                //Fecha fin
                String fechaF = String.valueOf(jFechaFin.getDate());
                Date fecha_fin = (Date) sdf.parse(fechaF);
                String ff = String.valueOf(otroFormato2.format(fecha_fin));
                Date fechaFin = (Date) jFechaFin.getDate();
                Cliente c = (Cliente) cmbClientes.getSelectedItem();
                int id_cliente = c.getId_cliente();
                int cantPersonas = Integer.parseInt(txtCantPersonas.getText());
                Float total = v.formatearDecimales(Float.parseFloat(txtMontoTotal.getText()),2);

                Alquiler a = new Alquiler(id_departamento, fechaInicio, fechaFin, id_cliente, cantPersonas, total);

                if (gdb.consultarAlquilerComprobante(num_departamento, fi, ff) == false) {
                    gdb.agregarAlquiler(a);
                    DesktopNotify.showDesktopMessage("Registrado con exito", "Para la fecha " + fi + " a la fecha " + ff + " para el departamento " + num_departamento + "", DesktopNotify.SUCCESS, 7000);
                    limpiar();
                } else {
                    // JOptionPane.showMessageDialog(this, "Ya hay un alquiler para esa fecha", "No se puede registrar", JOptionPane.ERROR_MESSAGE);
                    DesktopNotify.showDesktopMessage("Ya hay un alquiler para esa fecha", "No se puede registrar", DesktopNotify.FAIL, 5000);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarAlquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRegistrarAlquilerActionPerformed

    private void btnModificarAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAlquilerActionPerformed
        try {
            if (validar()) {
                int id = Integer.parseInt(txtId.getText());
                Departamento d = (Departamento) cmbDepartamentos.getSelectedItem();
                int id_departamento = d.getId_departamento();
                int num_departamento = d.getNum_departamento();
                //Fecha Inicio
                String fechaI = String.valueOf(jFechaInicio.getDate());
                Date fecha_inicio = (Date) sdf.parse(fechaI);
                String fi = String.valueOf(otroFormato2.format(fecha_inicio));
                Date fechaInicio = (Date) jFechaInicio.getDate();
                //Fecha fin
                String fechaF = String.valueOf(jFechaFin.getDate());
                Date fecha_fin = (Date) sdf.parse(fechaF);
                String ff = String.valueOf(otroFormato2.format(fecha_fin));
                Date fechaFin = (Date) jFechaFin.getDate();
                Cliente c = (Cliente) cmbClientes.getSelectedItem();
                int id_cliente = c.getId_cliente();
                int cantPersonas = Integer.parseInt(txtCantPersonas.getText());
                Float total = v.formatearDecimales(Float.parseFloat(txtMontoTotal.getText()),2);

                Alquiler a = new Alquiler(id_departamento, fechaInicio, fechaFin, id_cliente, cantPersonas, total);

                if (gdb.consultarAlquilerComprobante(num_departamento, fi, ff) == false) {
                    gdb.modificarAlquiler(a, id);
                    DesktopNotify.showDesktopMessage("Modificado con exito", "Para la fecha " + fi + " a la fecha " + ff + " para el departamento " + num_departamento + "", DesktopNotify.SUCCESS, 7000);
                    limpiar();
                    this.dispose();
                } else {
                    if (id == gdb.traerAlquilerComprobante(num_departamento, fi, ff)) {
                        gdb.modificarAlquiler(a, id);
                        DesktopNotify.showDesktopMessage("Modificado con exito", "Para la fecha " + fi + " a la fecha " + ff + " para el departamento " + num_departamento + "", DesktopNotify.SUCCESS, 7000);
                        limpiar();
                        this.dispose();
                    } else {
                        DesktopNotify.showDesktopMessage("Ya hay un alquiler para esa fecha", "No se puede modificar", DesktopNotify.FAIL, 5000);
                    }
                }
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnModificarAlquilerActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked


    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();

    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jFechaFinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFechaFinMouseExited
    }//GEN-LAST:event_jFechaFinMouseExited

    private void jFechaFinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFechaFinFocusLost
    }//GEN-LAST:event_jFechaFinFocusLost

    private void cmbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientesActionPerformed

    }//GEN-LAST:event_cmbClientesActionPerformed

    private void jFechaFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFechaFinPropertyChange
        if (jFechaFin.getDate() != null && jFechaInicio.getDate() != null) {
            int dias = (int) ((jFechaFin.getDate().getTime() - jFechaInicio.getDate().getTime()) / 86400000);
            lblDias.setText(String.valueOf(dias));
        }
    }//GEN-LAST:event_jFechaFinPropertyChange

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
            java.util.logging.Logger.getLogger(RegistrarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarAlquiler dialog = new RegistrarAlquiler(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnModificarAlquiler;
    private javax.swing.JButton btnRegistrarAlquiler;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbDepartamentos;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDias;
    private javax.swing.JTextField txtCantPersonas;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
