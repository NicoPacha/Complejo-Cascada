package views;

import models.Cliente;
import models.Contrato;
import models.Departamento;
import models.GestorDB;
import models.Reportes;
import com.sun.awt.AWTUtilities;
import dto.dtoAlquilerCliente;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConsultarAlquileres extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultTableModel dtm;
    DefaultComboBoxModel combo;
    DefaultComboBoxModel combo2;
    int xMouse;
    int yMouse;
    private static DefaultTableCellRenderer tcr;

    public ConsultarAlquileres(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        gdb = new GestorDB();
        ArrayList<dtoAlquilerCliente> alquileres = gdb.cargarAlquileres();
        cargarTabla(alquileres);
        acomodar();
        cmbClientes.setBackground(new Color(255, 255, 255));
        cmbDepartamentos.setBackground(new Color(255, 255, 255));
        jAño.setBackground(new Color(255, 255, 255));
        jtableAlquileres.getTableHeader().setReorderingAllowed(false);
        cargarComboDepartamento();
        cargarComboCliente();
        ((JTextField) this.jFechaInicio.getDateEditor()).setEditable(false);
        ((JTextField) this.jFechaFin.getDateEditor()).setEditable(false);
    }

    private void cargarTabla(ArrayList<dtoAlquilerCliente> alquiler) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id", "ID DEPTO", "Depto", "Fecha inicio", "Fecha fin", "ID CLIENTE", "Cliente", "Cant. Personas", "Total"};
        dtm.setColumnIdentifiers(nombreColumnas);

        for (dtoAlquilerCliente dac : alquiler) {
            Object[] filas = {dac.getId_alquiler(), dac.getId_departamento(), dac.getNum_departamento(), dac.getFecha_inicio(), dac.getFecha_fin(), dac.getId_cliente(), dac.getNombre_cliente(), dac.getCantidad_personas(), "$" + dac.getTotal()};
            dtm.addRow(filas);
        }
        //jtableAlquileres.getColumnModel().getColumn(2).setMaxWidth(20);
        jtableAlquileres.setModel(dtm);
        jtableAlquileres.getColumnModel().getColumn(2).setMaxWidth(50);
        jtableAlquileres.getColumnModel().getColumn(7).setMaxWidth(85);
        jtableAlquileres.getTableHeader().setFont(new Font("Cooper ", 1, 16));
        jtableAlquileres.getTableHeader().setBackground(new Color(101, 71, 182));
        jtableAlquileres.getTableHeader().setForeground(Color.white);
        jtableAlquileres.setRowHeight(22);
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        jtableAlquileres.getColumnModel().getColumn(8).setCellRenderer(tcr);
        acomodar();
    }

    public void actualizarTabla() {
        cargarTabla(gdb.cargarAlquileres());
        acomodar();
    }

    public void acomodar() {
        jtableAlquileres.getColumnModel().getColumn(0).setMaxWidth(0);
        jtableAlquileres.getColumnModel().getColumn(0).setMinWidth(0);
        jtableAlquileres.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtableAlquileres.getColumnModel().getColumn(1).setMaxWidth(0);
        jtableAlquileres.getColumnModel().getColumn(1).setMinWidth(0);
        jtableAlquileres.getColumnModel().getColumn(1).setPreferredWidth(0);
        jtableAlquileres.getColumnModel().getColumn(5).setMaxWidth(0);
        jtableAlquileres.getColumnModel().getColumn(5).setMinWidth(0);
        jtableAlquileres.getColumnModel().getColumn(5).setPreferredWidth(0);
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

    public void cargarComboCliente() {
        combo2 = new DefaultComboBoxModel();
        ArrayList<Cliente> clientes = gdb.cargarClientes();
        for (Cliente c : clientes) {
            combo2.addElement(c);
        }
        cmbClientes.setModel(combo2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jAño = new javax.swing.JComboBox<>();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAlquileres = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEmitirContrato = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFiltrar.setBackground(new java.awt.Color(101, 71, 182));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Año");

        jAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036" }));

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Cliente");

        jLabel3.setText("Fecha de fin");

        jLabel2.setText("Fecha de inicio");

        cmbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDepartamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDepartamentosItemStateChanged(evt);
            }
        });
        cmbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentosActionPerformed(evt);
            }
        });

        jLabel1.setText("Departamento");

        jtableAlquileres.setAutoCreateRowSorter(true);
        jtableAlquileres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtableAlquileres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableAlquileres.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtableAlquileres.setGridColor(new java.awt.Color(101, 71, 182));
        jtableAlquileres.setSelectionBackground(new java.awt.Color(150, 128, 209));
        jtableAlquileres.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtableAlquileres);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDepartamentos)
                    .addComponent(cmbClientes)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFiltrar)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jAño))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnEliminar.setBackground(new java.awt.Color(101, 71, 182));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar Alquiler");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
        txttitulo.setText("Consultar Alquileres");

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
                .addGap(269, 269, 269)
                .addComponent(txttitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar Alquiler");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEmitirContrato.setBackground(new java.awt.Color(101, 71, 182));
        btnEmitirContrato.setForeground(new java.awt.Color(255, 255, 255));
        btnEmitirContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/EmitirContrato.png"))); // NOI18N
        btnEmitirContrato.setText("Emitir Contrato");
        btnEmitirContrato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitirContrato.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitirContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirContratoActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmitirContrato)
                .addGap(244, 244, 244)
                .addComponent(btnActualizar))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmitirContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (jtableAlquileres.getSelectedRowCount() > 0) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                int id = (int) jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 0);
                gdb.eliminarAlquiler(id);
                actualizarTabla();
            } else {
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtableAlquileres.getSelectedRowCount() > 0) {
            int id = (int) jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 0);
            RegistrarAlquiler ra = new RegistrarAlquiler(new javax.swing.JDialog(), true, id);
            ra.setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEmitirContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirContratoActionPerformed
        if (jtableAlquileres.getSelectedRowCount() > 0) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea emitir un contrato a este alquiler?", "Contrato", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                int id_alquiler = (int) jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 0);
                int id_cliente = (int) jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 5);
                if (gdb.comprobarContrato(id_alquiler) == false) {
                    if (gdb.consultarSeñaContrato(id_cliente, id_alquiler) == true) {
                        Date fecha = new Date();
                        Contrato c = new Contrato(id_alquiler, fecha);
                        gdb.agregarContrato(c);
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
                        JOptionPane.showMessageDialog(null, "El alquiler debe estar señado para realizar el contrato", "Contrato", JOptionPane.CLOSED_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ya hay un contrato para ese alquiler", "Contrato", JOptionPane.CLOSED_OPTION);
                }
            } else {
                actualizarTabla();
            }
        }


    }//GEN-LAST:event_btnEmitirContratoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTabla();
        cmbDepartamentos.setSelectedIndex(0);
        jFechaInicio.setDate(null);
        jFechaFin.setDate(null);
        cmbClientes.setSelectedIndex(0);
        jAño.setSelectedIndex(0);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

        if (jFechaInicio.getDate() != null && jFechaFin.getDate() != null && jAño.getSelectedIndex() != 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir el año o las fechas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (jFechaInicio.getDate() != null && jFechaFin.getDate() == null || jFechaInicio.getDate() == null && jFechaFin.getDate() != null) {
            JOptionPane.showMessageDialog(this, "Debe elegir el conjunto de fechas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            filtro();
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void filtro() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            SimpleDateFormat otroFormato2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);

            String depto = cmbDepartamentos.getSelectedItem().toString();
            Cliente c = (Cliente) cmbClientes.getSelectedItem();
            String cli = String.valueOf(c.getId_cliente());
            String fechaI = String.valueOf(jFechaInicio.getDate());
            String fechaF = String.valueOf(jFechaFin.getDate());
            String año = String.valueOf(jAño.getSelectedItem().toString());

            if (depto.equals("Seleccione")) {
                depto = "null";
            }
            if (cli.equals("0")) {
                cli = "null";
            }
            if (año.equals("Seleccione")) {
                año = "null";
            }
            if (fechaI != "null" || fechaF != "null") {
                Date fecha_inicio = (Date) sdf.parse(fechaI);
                String fi = String.valueOf("'" + otroFormato2.format(fecha_inicio) + "'");
                Date fecha_fin = (Date) sdf.parse(fechaF);
                String ff = String.valueOf("'" + otroFormato2.format(fecha_fin) + "'");
                ArrayList<dtoAlquilerCliente> resultado = gdb.filtrarAlquileres(depto, cli, año, fi, ff);
                cargarTabla(resultado);
            } else {
                fechaI = "null";
                fechaF = "null";
                ArrayList<dtoAlquilerCliente> resultado = gdb.filtrarAlquileres(depto, cli, año, fechaI, fechaF);
                cargarTabla(resultado);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void filtoPorCliente(String cli,JTable tabla) {
//        //List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
//        //filters.add(RowFilter.regexFilter(num, 1));
//        dtm = (DefaultTableModel) jtableAlquileres.getModel();
//        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dtm);
//        jtableAlquileres.setRowSorter(tr);
//        //RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
//        tr.setRowFilter(RowFilter.regexFilter(cli, 5));
//    }

    private void cmbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentosActionPerformed

    }//GEN-LAST:event_cmbDepartamentosActionPerformed

    private void cmbDepartamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDepartamentosItemStateChanged


    }//GEN-LAST:event_cmbDepartamentosItemStateChanged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultarAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarAlquileres dialog = new ConsultarAlquileres(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnEmitirContrato;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbDepartamentos;
    private javax.swing.JComboBox<String> jAño;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAlquileres;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
