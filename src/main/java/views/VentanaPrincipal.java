package views;

import com.sun.awt.AWTUtilities;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    public VentanaPrincipal() {
        initComponents();

        this.setLayout(null);
        this.setSize(759, 500);
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        
        panelAlquileres.setVisible(false);
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        panelMenu = new javax.swing.JPanel();
        btnCobros = new javax.swing.JLabel();
        btnAlquileres = new javax.swing.JLabel();
        btnContratos = new javax.swing.JLabel();
        btnClientes = new javax.swing.JLabel();
        btnMovimientos = new javax.swing.JLabel();
        btnBalance = new javax.swing.JLabel();
        btnEmpleados = new javax.swing.JLabel();
        btnGastos = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelClientes = new javax.swing.JPanel();
        btnConsultarClientes = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JLabel();
        panelAlquileres = new javax.swing.JPanel();
        btnConsultarAlquileres = new javax.swing.JLabel();
        btnRegistrarAlquiler = new javax.swing.JLabel();
        panelCobros = new javax.swing.JPanel();
        btnConsultarCobros = new javax.swing.JLabel();
        btnRegistrarCobro = new javax.swing.JLabel();
        panelGastos = new javax.swing.JPanel();
        btnRegistrarServicio = new javax.swing.JLabel();
        btnConsultarGastos = new javax.swing.JLabel();
        btnRegistrarImpuesto = new javax.swing.JLabel();
        btnRegistrarMantenimiento = new javax.swing.JLabel();
        panelBalance = new javax.swing.JPanel();
        btnRegistrarBalance = new javax.swing.JLabel();
        btnConsultarBalance = new javax.swing.JLabel();
        panelMovimientos = new javax.swing.JPanel();
        btnRegistrarMovimiento = new javax.swing.JLabel();
        btnConsultarMovimientos = new javax.swing.JLabel();
        panelContratos = new javax.swing.JPanel();
        btnConsultarContratos = new javax.swing.JLabel();
        panelEmpleados = new javax.swing.JPanel();
        btnRegistrarEmpleado = new javax.swing.JLabel();
        btnConsultarEmpleados = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        panelMenu.setBackground(new java.awt.Color(101, 71, 182));
        panelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCobros.setBackground(new java.awt.Color(255, 255, 255));
        btnCobros.setForeground(new java.awt.Color(255, 255, 255));
        btnCobros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCobros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cobros.png"))); // NOI18N
        btnCobros.setText("Cobros");
        btnCobros.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnCobros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCobros.setIconTextGap(5);
        btnCobros.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCobros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCobrosMouseClicked(evt);
            }
        });

        btnAlquileres.setBackground(new java.awt.Color(255, 255, 255));
        btnAlquileres.setForeground(new java.awt.Color(255, 255, 255));
        btnAlquileres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlquileres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/alquileres.png"))); // NOI18N
        btnAlquileres.setText("Alquileres");
        btnAlquileres.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnAlquileres.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlquileres.setIconTextGap(5);
        btnAlquileres.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlquileresMouseClicked(evt);
            }
        });

        btnContratos.setBackground(new java.awt.Color(255, 255, 255));
        btnContratos.setForeground(new java.awt.Color(255, 255, 255));
        btnContratos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contratos.png"))); // NOI18N
        btnContratos.setText("Contratos");
        btnContratos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnContratos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContratos.setIconTextGap(5);
        btnContratos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContratosMouseClicked(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setIconTextGap(5);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
        });

        btnMovimientos.setBackground(new java.awt.Color(255, 255, 255));
        btnMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        btnMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/mov.png"))); // NOI18N
        btnMovimientos.setText("Movimientos");
        btnMovimientos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMovimientos.setIconTextGap(5);
        btnMovimientos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMovimientosMouseClicked(evt);
            }
        });

        btnBalance.setBackground(new java.awt.Color(255, 255, 255));
        btnBalance.setForeground(new java.awt.Color(255, 255, 255));
        btnBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBalance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/balance.png"))); // NOI18N
        btnBalance.setText("Balance");
        btnBalance.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnBalance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBalance.setIconTextGap(5);
        btnBalance.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBalanceMouseClicked(evt);
            }
        });

        btnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/empleados.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpleados.setIconTextGap(5);
        btnEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadosMouseClicked(evt);
            }
        });

        btnGastos.setBackground(new java.awt.Color(255, 255, 255));
        btnGastos.setForeground(new java.awt.Color(255, 255, 255));
        btnGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/gastos.png"))); // NOI18N
        btnGastos.setText("Gastos");
        btnGastos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnGastos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGastos.setIconTextGap(5);
        btnGastos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGastosMouseClicked(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/close.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/minimizar.png"))); // NOI18N
        btnMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });

        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/config.png"))); // NOI18N
        btnConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(101, 71, 182));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(btnAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCobros, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfiguracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMinimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar)
                        .addGap(40, 40, 40))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCobros, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAlquileres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnContratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu);
        panelMenu.setBounds(0, 0, 750, 110);

        panelClientes.setBackground(new java.awt.Color(255, 255, 255));

        btnConsultarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarClientes.png"))); // NOI18N
        btnConsultarClientes.setText("Consultar Clientes");
        btnConsultarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarClientesMouseClicked(evt);
            }
        });

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarCliente.png"))); // NOI18N
        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelClientes);
        panelClientes.setBounds(20, 120, 191, 120);

        panelAlquileres.setBackground(new java.awt.Color(255, 255, 255));

        btnConsultarAlquileres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarAlquileres.png"))); // NOI18N
        btnConsultarAlquileres.setText("Consultar Alquileres");
        btnConsultarAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarAlquileresMouseClicked(evt);
            }
        });

        btnRegistrarAlquiler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarAlquiler.png"))); // NOI18N
        btnRegistrarAlquiler.setText("Registrar Alquiler");
        btnRegistrarAlquiler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarAlquilerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAlquileresLayout = new javax.swing.GroupLayout(panelAlquileres);
        panelAlquileres.setLayout(panelAlquileresLayout);
        panelAlquileresLayout.setHorizontalGroup(
            panelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlquileresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultarAlquileres, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAlquileresLayout.setVerticalGroup(
            panelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlquileresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelAlquileres);
        panelAlquileres.setBounds(0, 120, 180, 120);

        panelCobros.setBackground(new java.awt.Color(255, 255, 255));

        btnConsultarCobros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarCobros.png"))); // NOI18N
        btnConsultarCobros.setText("Consultar Cobros");
        btnConsultarCobros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarCobrosMouseClicked(evt);
            }
        });

        btnRegistrarCobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarCobro.png"))); // NOI18N
        btnRegistrarCobro.setText("Registrar Cobro");
        btnRegistrarCobro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarCobroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCobrosLayout = new javax.swing.GroupLayout(panelCobros);
        panelCobros.setLayout(panelCobrosLayout);
        panelCobrosLayout.setHorizontalGroup(
            panelCobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCobrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarCobros, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelCobrosLayout.setVerticalGroup(
            panelCobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCobrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarCobros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelCobros);
        panelCobros.setBounds(100, 120, 209, 120);

        panelGastos.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarServicio.png"))); // NOI18N
        btnRegistrarServicio.setText("Registrar Servicio");
        btnRegistrarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarServicioMouseClicked(evt);
            }
        });

        btnConsultarGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarGastos.png"))); // NOI18N
        btnConsultarGastos.setText("Consultar Gastos");
        btnConsultarGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarGastosMouseClicked(evt);
            }
        });

        btnRegistrarImpuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarImpuesto.png"))); // NOI18N
        btnRegistrarImpuesto.setText("Registrar Impuesto");
        btnRegistrarImpuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarImpuestoMouseClicked(evt);
            }
        });

        btnRegistrarMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarMantenimiento.png"))); // NOI18N
        btnRegistrarMantenimiento.setText("Registrar Mantenimiento");
        btnRegistrarMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMantenimientoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelGastosLayout = new javax.swing.GroupLayout(panelGastos);
        panelGastos.setLayout(panelGastosLayout);
        panelGastosLayout.setHorizontalGroup(
            panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGastosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGastosLayout.createSequentialGroup()
                        .addGroup(panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGastosLayout.setVerticalGroup(
            panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGastosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelGastos);
        panelGastos.setBounds(270, 120, 210, 230);

        panelBalance.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrarBalance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarBalance.png"))); // NOI18N
        btnRegistrarBalance.setText("Registrar Balance");
        btnRegistrarBalance.setIconTextGap(8);
        btnRegistrarBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarBalanceMouseClicked(evt);
            }
        });

        btnConsultarBalance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarBalance.png"))); // NOI18N
        btnConsultarBalance.setText("Consultar Balance");
        btnConsultarBalance.setIconTextGap(8);
        btnConsultarBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarBalanceMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBalanceLayout = new javax.swing.GroupLayout(panelBalance);
        panelBalance.setLayout(panelBalanceLayout);
        panelBalanceLayout.setHorizontalGroup(
            panelBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBalanceLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panelBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelBalanceLayout.setVerticalGroup(
            panelBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBalanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(panelBalance);
        panelBalance.setBounds(430, 120, 190, 130);

        panelMovimientos.setBackground(new java.awt.Color(255, 255, 255));
        panelMovimientos.setPreferredSize(new java.awt.Dimension(255, 133));

        btnRegistrarMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarMovimiento.png"))); // NOI18N
        btnRegistrarMovimiento.setText("Registrar Movimiento Bancario");
        btnRegistrarMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMovimientoMouseClicked(evt);
            }
        });

        btnConsultarMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarMovimientos.png"))); // NOI18N
        btnConsultarMovimientos.setText("Consultar Movimientos Bancarios");
        btnConsultarMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarMovimientosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMovimientosLayout = new javax.swing.GroupLayout(panelMovimientos);
        panelMovimientos.setLayout(panelMovimientosLayout);
        panelMovimientosLayout.setHorizontalGroup(
            panelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMovimientosLayout.setVerticalGroup(
            panelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovimientosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnRegistrarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelMovimientos);
        panelMovimientos.setBounds(330, 120, 270, 130);

        panelContratos.setBackground(new java.awt.Color(255, 255, 255));
        panelContratos.setPreferredSize(new java.awt.Dimension(200, 72));

        btnConsultarContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarContratos.png"))); // NOI18N
        btnConsultarContratos.setText("Consultar Contratos");
        btnConsultarContratos.setIconTextGap(8);
        btnConsultarContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarContratosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelContratosLayout = new javax.swing.GroupLayout(panelContratos);
        panelContratos.setLayout(panelContratosLayout);
        panelContratosLayout.setHorizontalGroup(
            panelContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContratosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsultarContratos, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelContratosLayout.setVerticalGroup(
            panelContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContratosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsultarContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelContratos);
        panelContratos.setBounds(190, 120, 200, 72);

        panelEmpleados.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarEmpleado.png"))); // NOI18N
        btnRegistrarEmpleado.setText("Registrar Empleado");
        btnRegistrarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarEmpleadoMouseClicked(evt);
            }
        });

        btnConsultarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ConsultarEmpleados.png"))); // NOI18N
        btnConsultarEmpleados.setText("Consultar Empleados");
        btnConsultarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarEmpleadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEmpleadosLayout = new javax.swing.GroupLayout(panelEmpleados);
        panelEmpleados.setLayout(panelEmpleadosLayout);
        panelEmpleadosLayout.setHorizontalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultarEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelEmpleadosLayout.setVerticalGroup(
            panelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelEmpleados);
        panelEmpleados.setBounds(530, 120, 200, 128);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrosMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(true);
    }//GEN-LAST:event_btnCobrosMouseClicked

    private void btnAlquileresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlquileresMouseClicked
        panelAlquileres.setVisible(true);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnAlquileresMouseClicked

    private void btnContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContratosMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(true);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnContratosMouseClicked

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(true);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientosMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(true);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnMovimientosMouseClicked

    private void btnBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBalanceMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(true);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnBalanceMouseClicked

    private void btnEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(true);
        panelGastos.setVisible(false);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnEmpleadosMouseClicked

    private void btnGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGastosMouseClicked
        panelAlquileres.setVisible(false);
        panelContratos.setVisible(false);
        panelClientes.setVisible(false);
        panelMovimientos.setVisible(false);
        panelBalance.setVisible(false);
        panelEmpleados.setVisible(false);
        panelGastos.setVisible(true);
        panelCobros.setVisible(false);
    }//GEN-LAST:event_btnGastosMouseClicked

    private void btnConsultarAlquileresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarAlquileresMouseClicked
        ConsultarAlquileres v = new ConsultarAlquileres(this, false);
        v.setVisible(true);
    }//GEN-LAST:event_btnConsultarAlquileresMouseClicked

    private void btnRegistrarAlquilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarAlquilerMouseClicked
        RegistrarAlquiler v = new RegistrarAlquiler(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarAlquilerMouseClicked

    private void btnConsultarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarClientesMouseClicked
        ConsultarClientes v = new ConsultarClientes(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnConsultarClientesMouseClicked

    private void btnRegistrarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarClienteMouseClicked
        RegistrarCliente v = new RegistrarCliente(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarClienteMouseClicked

    private void btnConsultarCobrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarCobrosMouseClicked
        ConsultarCobros v = new ConsultarCobros(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnConsultarCobrosMouseClicked

    private void btnRegistrarCobroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarCobroMouseClicked
        RegistrarCobro v = new RegistrarCobro(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarCobroMouseClicked

    private void btnRegistrarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarServicioMouseClicked
        RegistrarServicio v = new RegistrarServicio(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarServicioMouseClicked

    private void btnConsultarGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarGastosMouseClicked
        ConsultarGastos v = new ConsultarGastos(this, false);
        v.setVisible(true);
    }//GEN-LAST:event_btnConsultarGastosMouseClicked

    private void btnRegistrarImpuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarImpuestoMouseClicked
        RegistrarImpuesto v = new RegistrarImpuesto(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarImpuestoMouseClicked

    private void btnRegistrarMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMantenimientoMouseClicked
        RegistrarMantenimiento v = new RegistrarMantenimiento(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarMantenimientoMouseClicked

    private void btnRegistrarMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMovimientoMouseClicked
        RegistrarMovimientoBancario v = new RegistrarMovimientoBancario(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarMovimientoMouseClicked

    private void btnConsultarMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMovimientosMouseClicked
        new ConsultarMovimientosBancarios(this, false).setVisible(true);
    }//GEN-LAST:event_btnConsultarMovimientosMouseClicked

    private void btnRegistrarBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarBalanceMouseClicked
        RegistrarBalance v = new RegistrarBalance(new javax.swing.JDialog(), true);
        v.setVisible(true);
    }//GEN-LAST:event_btnRegistrarBalanceMouseClicked

    private void btnConsultarBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarBalanceMouseClicked
        ConsultarBalance v = new ConsultarBalance(this, false);
        v.setVisible(true);
    }//GEN-LAST:event_btnConsultarBalanceMouseClicked

    private void btnConsultarContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarContratosMouseClicked
        ConsultarContratos v = new ConsultarContratos(this, false);
        v.setVisible(true);
    }//GEN-LAST:event_btnConsultarContratosMouseClicked

    private void btnRegistrarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoMouseClicked
        RegistrarEmpleado e = new RegistrarEmpleado(new javax.swing.JDialog(), true);
        e.setVisible(true);
    }//GEN-LAST:event_btnRegistrarEmpleadoMouseClicked

    private void btnConsultarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarEmpleadosMouseClicked
        ConsultarEmpleados e = new ConsultarEmpleados(new javax.swing.JDialog(), true);
        e.setVisible(true);
    }//GEN-LAST:event_btnConsultarEmpleadosMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        int c = JOptionPane.showConfirmDialog(null, "¿Seguro desea salir del sistema?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (c == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseClicked
        new Configuracion(this,true).setVisible(true);
    }//GEN-LAST:event_btnConfiguracionMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAlquileres;
    private javax.swing.JLabel btnBalance;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnClientes;
    private javax.swing.JLabel btnCobros;
    private javax.swing.JLabel btnConfiguracion;
    private javax.swing.JLabel btnConsultarAlquileres;
    private javax.swing.JLabel btnConsultarBalance;
    private javax.swing.JLabel btnConsultarClientes;
    private javax.swing.JLabel btnConsultarCobros;
    private javax.swing.JLabel btnConsultarContratos;
    private javax.swing.JLabel btnConsultarEmpleados;
    private javax.swing.JLabel btnConsultarGastos;
    private javax.swing.JLabel btnConsultarMovimientos;
    private javax.swing.JLabel btnContratos;
    private javax.swing.JLabel btnEmpleados;
    private javax.swing.JLabel btnGastos;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel btnMovimientos;
    private javax.swing.JLabel btnRegistrarAlquiler;
    private javax.swing.JLabel btnRegistrarBalance;
    private javax.swing.JLabel btnRegistrarCliente;
    private javax.swing.JLabel btnRegistrarCobro;
    private javax.swing.JLabel btnRegistrarEmpleado;
    private javax.swing.JLabel btnRegistrarImpuesto;
    private javax.swing.JLabel btnRegistrarMantenimiento;
    private javax.swing.JLabel btnRegistrarMovimiento;
    private javax.swing.JLabel btnRegistrarServicio;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelAlquileres;
    private javax.swing.JPanel panelBalance;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelCobros;
    private javax.swing.JPanel panelContratos;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JPanel panelGastos;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMovimientos;
    // End of variables declaration//GEN-END:variables
}
