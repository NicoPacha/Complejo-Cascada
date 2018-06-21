package views;

import models.GestorDB;
import models.Reportes;
import com.sun.awt.AWTUtilities;
import dto.dtoGastos;
import dto.dtoImpuestoTipo;
import dto.dtoMantenimientoTipo;
import dto.dtoServicioTipo;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.HashMap;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultarGastos extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultTableModel dtm;
    DefaultTableModel dtm2;
    DefaultTableModel dtm3;
    int xMouse;
    int yMouse;
    private static DefaultTableCellRenderer tcr;

    public ConsultarGastos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        jMes.setBackground(new Color(255, 255, 255));
        cmbTipoGasto.setBackground(new Color(255, 255, 255));
        jAño.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        jTableGastos.getTableHeader().setReorderingAllowed(false);
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        cargarComboTipoGasto();

    }

    private void cargarComboTipoGasto() {
        cmbTipoGasto.addItem("Seleccione");
        cmbTipoGasto.addItem("Impuestos");
        cmbTipoGasto.addItem("Servicios");
        cmbTipoGasto.addItem("Mantenimiento");
    }

    private void setearColumnas() {
        jTableGastos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableGastos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableGastos.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableGastos.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableGastos.getColumnModel().getColumn(1).setMinWidth(0);
        jTableGastos.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    private void cargarTablaGastosDto(ArrayList<dtoGastos> gastos) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Gasto de:", "Fecha", "Monto", "Fecha de Pago", "Fecha Vencimiento", "Agregado"};
        dtm.setColumnIdentifiers(nombreColumnas);

        for (dtoGastos g : gastos) {
            Object[] filas = {g.getGasto(), g.getFecha(), g.getMonto(), g.getFecha_pago(), g.getFecha_vencimiento(), g.getAgregado()};
            dtm.addRow(filas);
        }
        jTableGastos.setModel(dtm);
        jTableGastos.getColumnModel().getColumn(0).setMinWidth(250);
        jTableGastos.getColumnModel().getColumn(5).setMinWidth(150);
        jTableGastos.getTableHeader().setFont(new Font("Cooper ", 1, 16));
        jTableGastos.getTableHeader().setBackground(new Color(101, 71, 182));
        jTableGastos.getTableHeader().setForeground(Color.white);
        jTableGastos.setRowHeight(22);
        jTableGastos.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    private void cargarTablaImpuestos(ArrayList<dtoImpuestoTipo> impuestos) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id", "ID TipImp", "Mes", "Impuesto", "Fecha de Pago", "Fecha Vencimiento", "Monto"};
        dtm.setColumnIdentifiers(nombreColumnas);

        for (dtoImpuestoTipo i : impuestos) {
            Object[] filas = {i.getId_impuesto(), i.getId_tipo_impuesto(), i.getFecha_impuesto(), i.getTipo_impuesto(), i.getFecha_pago(), i.getFecha_impuesto_fin(), "$" + i.getMonto()};
            dtm.addRow(filas);
        }
        jTableGastos.setModel(dtm);
        setearColumnas();
        jTableGastos.getColumnModel().getColumn(2).setMinWidth(100);
        jTableGastos.getColumnModel().getColumn(3).setMinWidth(250);
        jTableGastos.getColumnModel().getColumn(6).setCellRenderer(tcr);
    }

    private void cargarTablaServicios(ArrayList<dtoServicioTipo> servicios) {
        dtm2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id", "ID TipSer", "Mes", "Servicio", "Fecha de pago", "Fecha de Vencimiento", "Monto"};
        dtm2.setColumnIdentifiers(nombreColumnas);

        for (dtoServicioTipo s : servicios) {
            Object[] filas = {s.getId_servicio(), s.getId_tipo_servicio(), s.getFecha_servicio(), s.getTipo_servicio(), s.getFecha_pago(), s.getFecha_servicio_fin(), "$" + s.getMonto()};
            dtm2.addRow(filas);
        }
        jTableGastos.setModel(dtm2);
        setearColumnas();
        jTableGastos.getColumnModel().getColumn(6).setCellRenderer(tcr);
    }

    private void cargarTablaMantenimientos(ArrayList<dtoMantenimientoTipo> mantenimientos) {
        dtm3 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };

        String[] nombreColumnas = {"Id", "ID TipMan", "Fecha", "Mantenimiento", "Monto", "Agregado"};
        dtm3.setColumnIdentifiers(nombreColumnas);

        for (dtoMantenimientoTipo m : mantenimientos) {
            Object[] filas = {m.getId_mantenimiento(), m.getId_tipo_mantenimiento(), m.getFecha_mantenimiento(), m.getTipo_mantenimiento(), "$" + m.getMonto(), m.getAgregado()};
            dtm3.addRow(filas);
        }
        jTableGastos.setModel(dtm3);
        setearColumnas();
        jTableGastos.getColumnModel().getColumn(4).setCellRenderer(tcr);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEmitir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGastos = new javax.swing.JTable();
        jAño = new javax.swing.JComboBox<>();
        año = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        cmbTipoGasto = new javax.swing.JComboBox<>();
        jMes = new javax.swing.JComboBox<>();

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

        btnEmitir.setBackground(new java.awt.Color(101, 71, 182));
        btnEmitir.setForeground(new java.awt.Color(255, 255, 255));
        btnEmitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/EmitirContrato.png"))); // NOI18N
        btnEmitir.setText("Emitir Reporte");
        btnEmitir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
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
        txttitulo.setText("Consultar Gastos");

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
                .addGap(150, 150, 150)
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

        mes.setText("Mes");

        jLabel2.setText("Tipo de Gasto");

        jTableGastos.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTableGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableGastos.setGridColor(new java.awt.Color(101, 71, 182));
        jTableGastos.setSelectionBackground(new java.awt.Color(150, 128, 209));
        jTableGastos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableGastos);

        jAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036" }));

        año.setText("Año");

        btnFiltrar.setBackground(new java.awt.Color(101, 71, 182));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        cmbTipoGasto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoGastoItemStateChanged(evt);
            }
        });
        cmbTipoGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoGastoActionPerformed(evt);
            }
        });

        jMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jMesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(cmbTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(mes)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(año))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar)))
                .addGap(29, 29, 29))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mes)
                    .addComponent(año)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitir)
                .addGap(256, 256, 256)
                .addComponent(btnActualizar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEmitir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoGastoActionPerformed
        String año = jAño.getSelectedItem().toString();
        String m = String.valueOf(jMes.getSelectedIndex());
        if (jAño.getSelectedIndex() == 0) {
            Calendar cal = Calendar.getInstance();
            año = String.valueOf(cal.get(Calendar.YEAR));
        }
        if (jMes.getSelectedIndex() == 0) {
            m = "null";
        }
        if (cmbTipoGasto.getSelectedIndex() == 0) {
            //jTableGastos.setModel(new DefaultTableModel());
            ArrayList<dtoGastos> gastos = gdb.cargarGastosDto(m, año);
            cargarTablaGastosDto(gastos);
        }
        if (cmbTipoGasto.getSelectedIndex() == 1) {
            ArrayList<dtoImpuestoTipo> impuestos = gdb.cargarImpuestoDto();
            cargarTablaImpuestos(impuestos);
        }
        if (cmbTipoGasto.getSelectedIndex() == 2) {
            ArrayList<dtoServicioTipo> servicios = gdb.cargarServicioDto();
            cargarTablaServicios(servicios);
        }
        if (cmbTipoGasto.getSelectedIndex() == 3) {
            ArrayList<dtoMantenimientoTipo> mantenimientos = gdb.cargarMantenimientoDto();
            cargarTablaMantenimientos(mantenimientos);
        }

    }//GEN-LAST:event_cmbTipoGastoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (jTableGastos.getSelectedRowCount() > 0) {
            DefaultTableModel tb = (DefaultTableModel) jTableGastos.getModel();

            if (cmbTipoGasto.getSelectedIndex() > 0 && tb.getRowCount() > 0) {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    int id = (int) jTableGastos.getValueAt(jTableGastos.getSelectedRow(), 0);
                    if (cmbTipoGasto.getSelectedIndex() == 1) {
                        {
                            int id_balance_general = gdb.balanceImpuestoWhere(id);
                            gdb.eliminarImpuestoBalance(id, id_balance_general);
                            gdb.eliminarBalance(id_balance_general);
                            gdb.eliminarImpuesto(id);
                            cargarTablaImpuestos(gdb.cargarImpuestoDto());
                        }
                    }
                    if (cmbTipoGasto.getSelectedIndex() == 2) {
                        {
                            // int id = (int) jTableGastos.getValueAt(jTableGastos.getSelectedRow(), 0);
                            int id_balance_general = gdb.balanceServicioWhere(id);
                            gdb.eliminarServicioBalance(id, id_balance_general);
                            gdb.eliminarBalance(id_balance_general);
                            gdb.eliminarServicio(id);
                            cargarTablaServicios(gdb.cargarServicioDto());
                        }
                    }
                    if (cmbTipoGasto.getSelectedIndex() == 3) {
                        {
                            //int id = (int) jTableGastos.getValueAt(jTableGastos.getSelectedRow(), 0);
                            int id_balance_general = gdb.balanceMantenimientoWhere(id);
                            gdb.eliminarMantenimientoBalance(id, id_balance_general);
                            gdb.eliminarBalance(id_balance_general);
                            gdb.eliminarMantenimiento(id);
                            cargarTablaMantenimientos(gdb.cargarMantenimientoDto());
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jTableGastos.getSelectedRowCount() > 0) {
            DefaultTableModel tb = (DefaultTableModel) jTableGastos.getModel();

            if (cmbTipoGasto.getSelectedIndex() > 0 && tb.getRowCount() > 0) {
                if (cmbTipoGasto.getSelectedIndex() == 1) {
                    {
                        int id = (int) jTableGastos.getValueAt(jTableGastos.getSelectedRow(), 0);
                        RegistrarImpuesto rc = new RegistrarImpuesto(new javax.swing.JDialog(), true, id);
                        rc.setVisible(true);
                    }
                }
                if (cmbTipoGasto.getSelectedIndex() == 2) {
                    {
                        int id = (int) jTableGastos.getValueAt(jTableGastos.getSelectedRow(), 0);
                        RegistrarServicio rs = new RegistrarServicio(new javax.swing.JDialog(), true, id);
                        rs.setVisible(true);
                    }
                }
                if (cmbTipoGasto.getSelectedIndex() == 3) {
                    {
                        int id = (int) jTableGastos.getValueAt(jTableGastos.getSelectedRow(), 0);
                        RegistrarMantenimiento rm = new RegistrarMantenimiento(new javax.swing.JDialog(), true, id);
                        rm.setVisible(true);
                    }
                }
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String año = jAño.getSelectedItem().toString();
        String m = String.valueOf(jMes.getSelectedIndex());
        if (jAño.getSelectedIndex() == 0) {
            Calendar cal = Calendar.getInstance();
            año = String.valueOf(cal.get(Calendar.YEAR));
        }
        if (jMes.getSelectedIndex() == 0) {
            m = "null";
        }

        if (cmbTipoGasto.getSelectedIndex() == 0) {
            {
                cargarTablaGastosDto(gdb.cargarGastosDto(m, año));
            }
        }
        if (cmbTipoGasto.getSelectedIndex() == 1) {
            {
                cargarTablaImpuestos(gdb.cargarImpuestoDto());
                setearColumnas();
            }
        }
        if (cmbTipoGasto.getSelectedIndex() == 2) {
            {
                cargarTablaServicios(gdb.cargarServicioDto());
                setearColumnas();
            }
        }
        if (cmbTipoGasto.getSelectedIndex() == 3) {
            {
                cargarTablaMantenimientos(gdb.cargarMantenimientoDto());
                setearColumnas();
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMesItemStateChanged

    }//GEN-LAST:event_jMesItemStateChanged


    private void cmbTipoGastoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoGastoItemStateChanged
        if (cmbTipoGasto.getSelectedIndex() == 0) {
            btnModificar.setVisible(false);
            btnEliminar.setVisible(false);
            btnEmitir.setVisible(true);
        } else {
            btnModificar.setVisible(true);
            btnEliminar.setVisible(true);
            btnEmitir.setVisible(false);
        }

    }//GEN-LAST:event_cmbTipoGastoItemStateChanged

    private void conexionReporteGastos() {

    }


    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
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
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\ReporteGastos.jasper", parametros);
                Reportes.mostrar();
            }
            if (jAño.getSelectedIndex() != 0 && jMes.getSelectedIndex() != 0) {
                parametros.put("mes", mes);
                parametros.put("año", año);
                Reportes.crearReporte(conn, "C:\\Users\\Nico\\Desktop\\Tesis 2018\\ProyectoComplejoCascada\\ReporteGastos\\ReporteGastos.jasper", parametros);
                Reportes.mostrar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGastos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmitirActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String año = jAño.getSelectedItem().toString();
        String mes = jMes.getSelectedItem().toString();
        String m = String.valueOf(jMes.getSelectedIndex());

        if (jMes.getSelectedIndex() != 0 && jAño.getSelectedIndex() == 0) {
            JOptionPane.showConfirmDialog(null, "Debe elegir el año si quiere filtrar por mes", "Alerta!", JOptionPane.CLOSED_OPTION);
        } else {
            if (jAño.getSelectedIndex() == 0) {
                año = "null";
            }
            if (jMes.getSelectedIndex() == 0) {
                mes = "null";
            } else {
                mes = "'" + mes + "'";
            }

            if (cmbTipoGasto.getSelectedIndex() == 1) {
                cargarTablaImpuestos(gdb.filtrarImpuestos(mes, año));
                setearColumnas();
            }
            if (cmbTipoGasto.getSelectedIndex() == 2) {
                cargarTablaServicios(gdb.filtrarServicios(mes, año));
                setearColumnas();
            }
            if (jMes.getSelectedIndex() == 0) {
                m = "null";
            }
            if (cmbTipoGasto.getSelectedIndex() == 3) {
                cargarTablaMantenimientos(gdb.filtroMantenimiento(m, año));
                setearColumnas();
            }
            if (cmbTipoGasto.getSelectedIndex() == 0) {
                cargarTablaGastosDto(gdb.cargarGastosDto(m, año));
            }
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarGastos dialog = new ConsultarGastos(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnEmitir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbTipoGasto;
    private javax.swing.JComboBox<String> jAño;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGastos;
    private javax.swing.JLabel mes;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
