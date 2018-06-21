package views;

import models.BalanceGeneral;
import models.Cliente;
import models.Cobro;
import models.CobroBalance;
import models.CobroMovimiento;
import models.Departamento;
import models.GestorDB;
import models.MovimientoBancario;
import models.TipoCobro;
import models.Validacion;
import com.sun.awt.AWTUtilities;
import ds.desktop.notify.DesktopNotify;
import dto.dtoAlquilerCliente;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RegistrarCobro extends javax.swing.JDialog {

    GestorDB gdb;
    DefaultComboBoxModel combo;
    DefaultComboBoxModel combo1;
    DefaultComboBoxModel combo2;
    DefaultTableModel dtm;
    Validacion v = new Validacion();
    int xMouse;
    int yMouse;
    private static DefaultTableCellRenderer tcr;

    public RegistrarCobro(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        btnModificar.setVisible(false);

    }

    RegistrarCobro(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        cargar();
        txttitulo.setText("Modificar Cobro");
        btnModificar.setVisible(true);
        btnRegistrarCobro.setVisible(false);

        Cobro c = gdb.cargarCobroId(id);
        txtId.setText(String.valueOf(c.getId_cobro()));
        if (c != null) {
            int tipoCobro = c.getId_tipo_cobro();
            for (int i = 0; i < combo.getSize(); i++) {
                TipoCobro t = (TipoCobro) combo.getElementAt(i);
                if (t.getId_tipo_cobro() == tipoCobro) {
                    cmbTipoCobro.setSelectedItem(t);
                    break;
                }
            }
            txtMonto.setText(String.valueOf(c.getMonto()));
            jFechaCobro.setDate(c.getFecha_cobro());
            int alquiler = c.getId_alquiler();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                int id_alquiler = (int) jtableAlquileres.getValueAt(i, 0);
                if (id_alquiler == alquiler) {
                    jtableAlquileres.getSelectionModel().setSelectionInterval(i, i);

                }
            }
        }

    }

    public void cargar() {
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        cmbTipoCobro.setBackground(new Color(255, 255, 255));
        cmbDepartamentos.setBackground(new Color(255, 255, 255));
        cmbClientes.setBackground(new Color(255, 255, 255));
        jAño.setBackground(new Color(255, 255, 255));
        gdb = new GestorDB();
        cargarComboTiposCobro();
        ArrayList<dtoAlquilerCliente> resultado = gdb.cargarAlquileresClientes();
        cargarTabla(resultado);
        acomodar();
        txtId.setVisible(false);
        v.validarNumerosPuntos(txtMonto);
        jtableAlquileres.getTableHeader().setReorderingAllowed(false);
        cargarComboDepartamento();
        cargarComboCliente();
        ((JTextField) this.jFechaInicio.getDateEditor()).setEditable(false);
        ((JTextField) this.jFechaFin.getDateEditor()).setEditable(false);
    }

    private void cargarTabla(ArrayList<dtoAlquilerCliente> resultado) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int nombreColumnas) {
                return false;
            }
        };
        String[] Columnas = {"Alquiler", "Depto", "Fecha inicio", "Fecha Fin", "Cliente", "Documento", "Monto total"};
        dtm.setColumnIdentifiers(Columnas);

        for (dtoAlquilerCliente c : resultado) {
            Object[] filas = {c.getId_alquiler(), c.getNum_departamento(), c.getFecha_inicio(), c.getFecha_fin(), c.getNombre_cliente(), c.getDocumento(), "$" + c.getTotal()};
            dtm.addRow(filas);
        }
        jtableAlquileres.setModel(dtm);
        jtableAlquileres.getColumnModel().getColumn(1).setMaxWidth(50);
        jtableAlquileres.getTableHeader().setFont(new Font("Cooper", 1, 13));
        jtableAlquileres.getTableHeader().setBackground(new Color(101, 71, 182));
        jtableAlquileres.getTableHeader().setForeground(Color.white);
        jtableAlquileres.setRowHeight(17);
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        jtableAlquileres.getColumnModel().getColumn(6).setCellRenderer(tcr);
    }

    private void acomodar() {
        jtableAlquileres.getColumnModel().getColumn(0).setMaxWidth(0);
        jtableAlquileres.getColumnModel().getColumn(0).setMinWidth(0);
        jtableAlquileres.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void cargarComboTiposCobro() {
        combo = new DefaultComboBoxModel();
        ArrayList<TipoCobro> tiposCobro = gdb.cargarTiposCobro();
        for (TipoCobro tc : tiposCobro) {
            combo.addElement(tc);
        }
        cmbTipoCobro.setModel(combo);
    }

    private boolean validar() {
        if (cmbTipoCobro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe elegir el tipo de cobro", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMonto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar el monto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaCobro.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una fecha de cobro", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jtableAlquileres.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe elegir el alquiler al cual quiere registrarle el cobro", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void cargarComboDepartamento() {
        combo1 = new DefaultComboBoxModel();
        ArrayList<Departamento> departamentos = gdb.cargarDepartamentos();
        combo1.addElement("Seleccione");
        for (Departamento d : departamentos) {
            combo1.addElement(d);
        }

        cmbDepartamentos.setModel(combo1);
    }

    public void cargarComboCliente() {
        combo2 = new DefaultComboBoxModel();
        ArrayList<Cliente> clientes = gdb.cargarClientes();
        for (Cliente c : clientes) {
            combo2.addElement(c);
        }
        cmbClientes.setModel(combo2);
    }

    private void limpiar() {
        cmbTipoCobro.setSelectedIndex(0);
        txtMonto.setText("");
        jFechaCobro.setDate(null);
        jtableAlquileres.getSelectionModel().clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarCobro = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txttitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFechaCobro = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        cmbTipoCobro = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAlquileres = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jAño = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnRegistrarCobro.setBackground(new java.awt.Color(101, 71, 182));
        btnRegistrarCobro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnRegistrarCobro.setText("Registrar Cobro");
        btnRegistrarCobro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCobro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCobroActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(101, 71, 182));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar cobro");
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
        txttitulo.setText("Registrar Cobro");

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
                .addGap(258, 258, 258)
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tipo de cobro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Monto");

        jFechaCobro.setBackground(new java.awt.Color(255, 255, 255));
        jFechaCobro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Fecha de cobro");

        cmbTipoCobro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoCobro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtableAlquileres.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jtableAlquileres.setModel(new javax.swing.table.DefaultTableModel(
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
        jtableAlquileres.setGridColor(new java.awt.Color(101, 71, 182));
        jtableAlquileres.setSelectionBackground(new java.awt.Color(150, 128, 209));
        jtableAlquileres.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtableAlquileres);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Seleccione el alquiler");

        jAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036" }));

        jLabel5.setText("Año");

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Cliente");

        jLabel8.setText("Fecha de fin");

        jLabel9.setText("Fecha de inicio");

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

        btnFiltrar.setBackground(new java.awt.Color(101, 71, 182));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(101, 71, 182));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiar.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbTipoCobro, javax.swing.GroupLayout.Alignment.LEADING, 0, 122, Short.MAX_VALUE))))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel1))
                                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel9)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel8)
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel6)
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnLimpiar))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnFiltrar)
                                            .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbTipoCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jFechaCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDepartamentos)
                            .addComponent(cmbClientes)
                            .addComponent(jAño))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarCobro))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addComponent(btnRegistrarCobro)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCobroActionPerformed

        if (validar()) {
            TipoCobro tc = (TipoCobro) cmbTipoCobro.getSelectedItem();
            int id_tipo_cobro = tc.getId_tipo_cobro();
            int id_alquiler = (int) jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 0);
            float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            Date fecha_cobro = (Date) jFechaCobro.getDate();
            String año = String.valueOf(jFechaCobro.getDate().getYear());

            Cobro c = new Cobro(id_tipo_cobro, id_alquiler, monto, fecha_cobro);

            //agarrar la id de cobro ultimo
            if (cmbTipoCobro.getSelectedItem().toString().equals("Seña")) {
                if (gdb.comprobarSeñaCobro(id_alquiler) == false) {
                    gdb.agregarCobro(c);
                    int ultimoIdCobro = gdb.ultimoIdCobro();
                    String concepto = String.valueOf("Depto: " + jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 1) + " " + cmbTipoCobro.getSelectedItem().toString() + "  $" + monto);
                    float saldo = gdb.SaldoMovimientos("null", año) + monto;
                    MovimientoBancario mb = new MovimientoBancario(concepto, fecha_cobro, monto, 0, saldo);
                    gdb.agregarMovimientoBancario(mb);
                    //agarrar ultimo movimiento bancario
                    int ultimoIdMovimiento = gdb.ultimoIdMovimientoBancario();
                    //agregar a cobro_Movimiento
                    CobroMovimiento cm = new CobroMovimiento(ultimoIdCobro, ultimoIdMovimiento);
                    gdb.agregarCobroMovimiento(cm);
                    DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ya se realizo una seña para ese alquiler", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (cmbTipoCobro.getSelectedItem().toString().equals("Efectivo")) {
                gdb.agregarCobro(c);
                int ultimoIdCobro = gdb.ultimoIdCobro();
                String concepto = String.valueOf("Depto: " + jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 1) + " " + cmbTipoCobro.getSelectedItem().toString() + "  $" + monto);
                float saldo = gdb.SaldoBalance("null", año) + monto;
                BalanceGeneral bg = new BalanceGeneral(concepto, fecha_cobro, monto, 0, saldo);
                gdb.agregarBalance(bg);
                //agarrar ultimo balance
                int ultimoIdBalance = gdb.ultimoIdBalanceGeneral();
                //agregar a cobro_Balance
                CobroBalance cb = new CobroBalance(ultimoIdCobro, ultimoIdBalance);
                gdb.agregarCobroBalance(cb);
                DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
                limpiar();
            }

        }

    }//GEN-LAST:event_btnRegistrarCobroActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validar()) {
            int id = Integer.parseInt(txtId.getText());
            TipoCobro tc = (TipoCobro) cmbTipoCobro.getSelectedItem();
            int id_tipo_cobro = tc.getId_tipo_cobro();
            int id_alquiler = (int) jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 0);
            float monto = v.formatearDecimales(Float.parseFloat(txtMonto.getText()), 2);
            Date fecha_cobro = (Date) jFechaCobro.getDate();

            Cobro c = new Cobro(id_tipo_cobro, id_alquiler, monto, fecha_cobro);
            gdb.modificarCobro(c, id);

            if (cmbTipoCobro.getSelectedItem().toString().equals("Seña")) {
                String concepto = String.valueOf("Depto: " + jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 1) + " " + cmbTipoCobro.getSelectedItem().toString() + "  $" + monto);
                //agarro la id_movimiento where id_cobro= id de aca  
                int id_movimiento_bancario = gdb.movimientoCobroWhere(id);
                //Agarrar el saldo anterior
                float saldoInicial = gdb.SaldoMovimientoId(id_movimiento_bancario);
                //Creo una variable saldo y le digo que al saldoInicial le sume el monto de la seña
                float saldo = saldoInicial + monto;
                MovimientoBancario mb = new MovimientoBancario(concepto, fecha_cobro, monto, 0, saldo);
                //update movimiento bancario con su id de arriba
                gdb.modificarMovimientoBancario(mb, id_movimiento_bancario);
            }
            if (cmbTipoCobro.getSelectedItem().toString().equals("Efectivo")) {
                String concepto = String.valueOf("Depto: " + jtableAlquileres.getValueAt(jtableAlquileres.getSelectedRow(), 1) + " " + cmbTipoCobro.getSelectedItem().toString() + "  $" + monto);
                //agarro la id_balance where id_cobro=id 
                int id_balance_general = gdb.balanceCobroWhere(id);
                float saldoInicial = gdb.SaldoBalanceId(id_balance_general);
                float saldo = saldoInicial + monto;
                BalanceGeneral bg = new BalanceGeneral(concepto, fecha_cobro, monto, 0, saldo);
                // update balance general con el id_balance
                gdb.modificarBalanceGeneral(bg, id_balance_general);
            }
            DesktopNotify.showDesktopMessage("Registrado con exito", "Exito", DesktopNotify.SUCCESS, 7000);
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
                ArrayList<dtoAlquilerCliente> resultado = gdb.filtrarAlquileresDeCobros(depto, cli, año, fi, ff);
                cargarTabla(resultado);
            } else {
                fechaI = "null";
                fechaF = "null";
                ArrayList<dtoAlquilerCliente> resultado = gdb.filtrarAlquileresDeCobros(depto, cli, año, fechaI, fechaF);
                cargarTabla(resultado);
            }
            acomodar();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarAlquileres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cmbDepartamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDepartamentosItemStateChanged

    }//GEN-LAST:event_cmbDepartamentosItemStateChanged

    private void cmbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentosActionPerformed

    }//GEN-LAST:event_cmbDepartamentosActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cmbDepartamentos.setSelectedIndex(0);
        jFechaInicio.setDate(null);
        jFechaFin.setDate(null);
        cmbClientes.setSelectedIndex(0);
        jAño.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarCobro dialog = new RegistrarCobro(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrarCobro;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbDepartamentos;
    private javax.swing.JComboBox<String> cmbTipoCobro;
    private javax.swing.JComboBox<String> jAño;
    private com.toedter.calendar.JCalendar jFechaCobro;
    private com.toedter.calendar.JDateChooser jFechaFin;
    private com.toedter.calendar.JDateChooser jFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAlquileres;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txttitulo;
    // End of variables declaration//GEN-END:variables
}
