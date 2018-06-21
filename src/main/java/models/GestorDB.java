package models;

import dto.dtoAlquilerCliente;
import dto.dtoClienteProvDoc;
import dto.dtoCobroAlqCliTipCob;
import dto.dtoContratoAlquiler;
import dto.dtoEmpleadosTipoMan;
import dto.dtoGastos;
import dto.dtoImpuestoTipo;
import dto.dtoMantenimientoTipo;
import dto.dtoServicioTipo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorDB {

    private static final String conexion = "jdbc:sqlserver://DESKTOP-6SGVG7R\\SQLEXPRESS2012:1433;databaseName=ComplejoCascada";
    private String usuario = "sa";
    private String contraseña = "root";
    private Connection conn;

    private void abrirConexion() throws SQLException {
        conn = DriverManager.getConnection(conexion, usuario, contraseña);
    }

    private void cerrarConexion() throws SQLException {
        conn.close();
    }

    //-------------------ALQUILER--------------------------------------
    public ArrayList<Departamento> cargarDepartamentos() {
        ArrayList<Departamento> departamentos = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT*FROM Departamentos");
            while (consulta.next()) {
                int id_departamento = consulta.getInt("id_departamento");
                int num_departamento = consulta.getInt("num_departamento");
                Departamento d = new Departamento(id_departamento, num_departamento);

                departamentos.add(d);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return departamentos;
    }

    public ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            //ResultSet consulta = state.executeQuery("select id_cliente, nombre,apellido from Clientes");
            ResultSet consulta = state.executeQuery("Select 0 as id_cliente, 'Seleccione' as nombre, '' as apellido union SELECT id_cliente,nombre,apellido FROM Clientes");
            while (consulta.next()) {
                int id_cliente = consulta.getInt("id_cliente");
                String nombre = consulta.getString("nombre");
                String apellido = consulta.getString("apellido");
                Cliente c = new Cliente(id_cliente, nombre, apellido);
                clientes.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return clientes;
    }

    public void agregarAlquiler(Alquiler a) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Alquileres(id_departamento,fecha_inicio,fecha_fin,id_cliente,cantidad_personas,total) VALUES(?,?,?,?,?,?)");
            pState.setInt(1, a.getId_departamento());

            java.util.Date d = a.getFecha_inicio();
            pState.setDate(2, new java.sql.Date(d.getTime()));

            java.util.Date d2 = a.getFecha_fin();
            pState.setDate(3, new java.sql.Date(d2.getTime()));

            pState.setInt(4, a.getId_cliente());
            pState.setInt(5, a.getCantidad_personas());
            pState.setFloat(6, a.getTotal());
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public java.sql.Date convertir(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public boolean consultarAlquilerComprobante(int num_departamento, String fi, String ff) {
        boolean bandera = false;
        java.util.Date fecha_inicio = null;
        java.util.Date fecha_fin = null;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT num_departamento,fecha_inicio,fecha_fin FROM Alquileres a join Departamentos d on d.id_departamento=a.id_departamento WHERE num_departamento=" + num_departamento + " and ((fecha_inicio <= DATEADD(day,1,'" + fi + "') and fecha_fin >= DATEADD(day,1,'" + fi + "')) or (fecha_inicio <= DATEADD(day,-1,'" + ff + "') and fecha_fin >= DATEADD(day,-1,'" + ff + "')) or (fecha_inicio between DATEADD(day,1,'" + fi + "') and DATEADD(day,-1,'" + ff + "')) or (fecha_fin between DATEADD(day,1,'" + fi + "') and DATEADD(day,-1,'" + ff + "')))");
            // ResultSet consulta = state.executeQuery("SELECT num_departamento,fecha_inicio,fecha_fin FROM Alquileres a join Departamentos d on d.id_departamento=a.id_departamento WHERE num_departamento=" + num_departamento + " and ((fecha_inicio <= DATEADD(day,1,'" + fi + "') and fecha_fin >= DATEADD(day,1,'" + fi + "')) OR (fecha_inicio <=  DATEADD(day,-1,'" + ff + "') and fecha_fin >=  DATEADD(day,-1,'" + ff + "'))) ");
            if (consulta.next()) {
                bandera = true;
                num_departamento = consulta.getInt("num_departamento");
                fecha_inicio = consulta.getDate("fecha_inicio");
                fecha_fin = consulta.getDate("fecha_fin");
            }

            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bandera;
    }

    public int traerAlquilerComprobante(int num_departamento, String fi, String ff) {
        int id_alquiler = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT id_alquiler FROM Alquileres a join Departamentos d on d.id_departamento=a.id_departamento WHERE num_departamento=" + num_departamento + " and ((fecha_inicio <= DATEADD(day,1,'" + fi + "') and fecha_fin >= DATEADD(day,1,'" + fi + "')) or (fecha_inicio <= DATEADD(day,-1,'" + ff + "') and fecha_fin >= DATEADD(day,-1,'" + ff + "')) or (fecha_inicio between DATEADD(day,1,'" + fi + "') and DATEADD(day,-1,'" + ff + "')) or (fecha_fin between DATEADD(day,1,'" + fi + "') and DATEADD(day,-1,'" + ff + "')))");
            //ResultSet consulta = state.executeQuery("SELECT id_alquiler FROM Alquileres a join Departamentos d on d.id_departamento=a.id_departamento WHERE num_departamento=" + num_departamento + " and ((fecha_inicio <= DATEADD(day,1,'" + fi + "') and fecha_fin >= DATEADD(day,1,'" + fi + "')) OR (fecha_inicio <=  DATEADD(day,-1,'" + ff + "') and fecha_fin >=  DATEADD(day,-1,'" + ff + "'))) ");
            if (consulta.next()) {
                id_alquiler = consulta.getInt("id_alquiler");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id_alquiler;
    }

    public ArrayList<dtoAlquilerCliente> filtrarAlquileres(String departamento, String cli, String año, String fi, String ff) {
        ArrayList<dtoAlquilerCliente> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @depto varchar(10)=" + departamento + ",\n"
                    + " @cli varchar(10) =" + cli + ",\n"
                    + " @año varchar(10)=" + año + ",\n"
                    + " @fechaI varchar(50)=" + fi + ",\n"
                    + " @fechaF varchar(50)=" + ff + "\n"
                    + "SELECT id_alquiler,a.id_departamento,num_departamento,fecha_inicio,fecha_fin,a.id_cliente,nombre +' '+ apellido as cliente,cantidad_personas,total FROM Alquileres a join Departamentos d on a.id_departamento=d.id_departamento join Clientes c on c.id_cliente=a.id_cliente\n"
                    + "where (num_departamento=@depto or @depto is null) and\n"
                    + "(a.id_cliente=@cli or @cli is null) and\n"
                    + "(@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)or @año is null) and\n"
                    + "(((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF))or @fechaI is null and @fechaF is null)and\n"
                    + "((num_departamento=@depto and a.id_cliente=@cli AND (@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)))or @depto is null or @cli is null or @año is null) and\n"
                    + "((num_departamento=@depto and a.id_cliente=@cli AND ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF)))or @depto is null or @cli is null or @fechaI is null or @fechaF is null) and\n"
                    + "((num_departamento=@depto and a.id_cliente=@cli)or @depto is null or @cli is null) and\n"
                    + "((num_departamento=@depto and(@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)))or @depto is null or @año is null) and\n"
                    + "((num_departamento=@depto and ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF)))or  @depto is null or @fechaI is null or @fechaF is null)and\n"
                    + "((a.id_cliente=@cli and (@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)))or @cli is null or @año is null)and\n"
                    + "((a.id_cliente=@cli and ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF)))or @cli is null or @fechaI is null or @fechaF is null)order by fecha_inicio");
            while (consulta.next()) {
                int id_alquiler = consulta.getInt("id_alquiler");
                int id_departamento = consulta.getInt("id_departamento");
                int num_departamento = consulta.getInt("num_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                int id_cliente = consulta.getInt("id_cliente");
                String cliente = consulta.getString("cliente");
                int cantidad_personas = consulta.getInt("cantidad_personas");
                Float total = consulta.getFloat("total");
                dtoAlquilerCliente c = new dtoAlquilerCliente(id_alquiler, id_departamento, num_departamento, fecha_inicio, fecha_fin, id_cliente, cliente, cantidad_personas, total);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public ArrayList<dtoAlquilerCliente> filtrarAlquileresDeCobros(String departamento, String cli, String año, String fi, String ff) {
        ArrayList<dtoAlquilerCliente> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @depto varchar(10)=" + departamento + ",\n"
                    + " @cli varchar(10) =" + cli + ",\n"
                    + " @año varchar(10)=" + año + ",\n"
                    + " @fechaI varchar(50)=" + fi + ",\n"
                    + " @fechaF varchar(50)=" + ff + "\n"
                    + "SELECT id_alquiler,num_departamento,fecha_inicio,fecha_fin,nombre +' '+ apellido as cliente,documento,total FROM Alquileres a join Departamentos d on a.id_departamento=d.id_departamento join Clientes c on c.id_cliente=a.id_cliente\n"
                    + "where (num_departamento=@depto or @depto is null) and\n"
                    + "(a.id_cliente=@cli or @cli is null) and\n"
                    + "(@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)or @año is null) and\n"
                    + "(((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF))or @fechaI is null and @fechaF is null)and\n"
                    + "((num_departamento=@depto and a.id_cliente=@cli AND (@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)))or @depto is null or @cli is null or @año is null) and\n"
                    + "((num_departamento=@depto and a.id_cliente=@cli AND ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF)))or @depto is null or @cli is null or @fechaI is null or @fechaF is null) and\n"
                    + "((num_departamento=@depto and a.id_cliente=@cli)or @depto is null or @cli is null) and\n"
                    + "((num_departamento=@depto and(@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)))or @depto is null or @año is null) and\n"
                    + "((num_departamento=@depto and ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF)))or  @depto is null or @fechaI is null or @fechaF is null)and\n"
                    + "((a.id_cliente=@cli and (@año=YEAR(fecha_inicio) or @año=YEAR(fecha_fin)))or @cli is null or @año is null)and\n"
                    + "((a.id_cliente=@cli and ((fecha_inicio <= @fechaI and fecha_fin >= @fechaI) or (fecha_inicio <= @fechaF and fecha_fin >= @fechaF) or (fecha_inicio between @fechaI and @fechaF) or (fecha_fin between @fechaI and @fechaF)))or @cli is null or @fechaI is null or @fechaF is null) order by fecha_inicio");
            while (consulta.next()) {
                int id_alquiler = consulta.getInt("id_alquiler");
                int num_departamento = consulta.getInt("num_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                String cliente = consulta.getString("cliente");
                long documento = consulta.getLong("documento");
                Float total = consulta.getFloat("total");
                dtoAlquilerCliente c = new dtoAlquilerCliente(id_alquiler, num_departamento, fecha_inicio, fecha_fin, cliente, documento, total);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public ArrayList<dtoAlquilerCliente> cargarAlquileres() {
        ArrayList<dtoAlquilerCliente> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT id_alquiler,a.id_departamento,num_departamento,fecha_inicio,fecha_fin,a.id_cliente,nombre +' '+ apellido as cliente,cantidad_personas,total FROM Alquileres a join Departamentos d on a.id_departamento=d.id_departamento join Clientes c on c.id_cliente=a.id_cliente where year(fecha_inicio)=year(getdate())or year(fecha_fin)=year(getdate()) order by fecha_inicio");
            while (consulta.next()) {
                int id_alquiler = consulta.getInt("id_alquiler");
                int id_departamento = consulta.getInt("id_departamento");
                int num_departamento = consulta.getInt("num_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                int id_cliente = consulta.getInt("id_cliente");
                String cliente = consulta.getString("cliente");
                int cantidad_personas = consulta.getInt("cantidad_personas");
                Float total = consulta.getFloat("total");
                dtoAlquilerCliente c = new dtoAlquilerCliente(id_alquiler, id_departamento, num_departamento, fecha_inicio, fecha_fin, id_cliente, cliente, cantidad_personas, total);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarAlquiler(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Alquileres WHERE id_alquiler =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showConfirmDialog(null, "No puedes eliminar este alquiler,Ya tiene habilitado un cobro o un contrato", "Alerta!", JOptionPane.CLOSED_OPTION);
        }
    }

    public void modificarAlquiler(Alquiler a, int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Alquileres SET id_departamento = ?,fecha_inicio = ?,fecha_fin = ?,id_cliente = ?,cantidad_personas= ?,total = ? WHERE id_alquiler=?");
            pState.setInt(1, a.getId_departamento());
            java.util.Date d = a.getFecha_inicio();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            java.util.Date d2 = a.getFecha_fin();
            pState.setDate(3, new java.sql.Date(d2.getTime()));
            pState.setInt(4, a.getId_cliente());
            pState.setInt(5, a.getCantidad_personas());
            pState.setFloat(6, a.getTotal());
            pState.setInt(7, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Alquiler cargarAlquilerId(int id) {
        Alquiler a = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Alquileres WHERE id_alquiler=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_alquiler = consulta.getInt("id_alquiler");
                int id_departamento = consulta.getInt("id_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                int id_cliente = consulta.getInt("id_cliente");
                int cantidad_personas = consulta.getInt("cantidad_personas");
                Float total = consulta.getFloat("total");
                a = new Alquiler(id_alquiler, id_departamento, fecha_inicio, fecha_fin, id_cliente, cantidad_personas, total);
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;
    }

    //----------------------CLIENTE---------------------------------
    public ArrayList<TipoDocumento> cargarTiposDocumento() {
        ArrayList<TipoDocumento> tiposDocumento = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            //ResultSet consulta = state.executeQuery("SELECT*FROM Tipos_documento");
            ResultSet consulta = state.executeQuery("Select 0 as id_tipo_documento, 'Seleccione' as tipo_documento union SELECT id_tipo_documento,tipo_documento FROM Tipos_documento");
            while (consulta.next()) {
                int id_tipo_documento = consulta.getInt("id_tipo_documento");
                String tipo_documento = consulta.getString("tipo_documento");
                TipoDocumento td = new TipoDocumento(id_tipo_documento, tipo_documento);

                tiposDocumento.add(td);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tiposDocumento;
    }

    public ArrayList<Provincia> cargarProvincias() {
        ArrayList<Provincia> provincias = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            //ResultSet consulta = state.executeQuery("SELECT*FROM Provincias");
            ResultSet consulta = state.executeQuery("Select 0 as id_provincia, 'Seleccione' as provincia union SELECT id_provincia,provincia FROM Provincias");
            while (consulta.next()) {
                int id_provincia = consulta.getInt("id_provincia");
                String provincia = consulta.getString("provincia");
                Provincia p = new Provincia(id_provincia, provincia);

                provincias.add(p);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return provincias;
    }

    public void agregarCliente(Cliente c) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Clientes(nombre,apellido,id_provincia,pueblo,telefono,id_tipo_documento,documento)VALUES (?,?,?,?,?,?,?)");
            pState.setString(1, c.getNombre());
            pState.setString(2, c.getApellido());
            pState.setInt(3, c.getId_provincia());
            pState.setString(4, c.getPueblo());
            pState.setLong(5, c.getTelefono());
            pState.setInt(6, c.getId_tipo_documento());
            pState.setLong(7, c.getDocumento());
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoClienteProvDoc> cargarClienteDto() {
        ArrayList<dtoClienteProvDoc> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT id_cliente,nombre+' '+apellido as nombreCompleto,c.id_provincia,provincia,pueblo,telefono,c.id_tipo_documento,tipo_documento,documento FROM Clientes c join Provincias p on c.id_provincia=p.id_provincia join Tipos_documento t on t.id_tipo_documento=c.id_tipo_documento");
            while (consulta.next()) {
                int id_cliente = consulta.getInt("id_cliente");
                String nombreCompleto = consulta.getString("nombreCompleto");
                int id_provincia = consulta.getInt("id_provincia");
                String provincia = consulta.getString("provincia");
                String pueblo = consulta.getString("pueblo");
                long telefono = consulta.getLong("telefono");
                int id_tipo_documento = consulta.getInt("id_tipo_documento");
                String tipo_documento = consulta.getString("tipo_documento");
                long documento = consulta.getLong("documento");
                dtoClienteProvDoc c = new dtoClienteProvDoc(id_cliente, nombreCompleto, id_provincia, provincia, pueblo, telefono, id_tipo_documento, tipo_documento, documento);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarCliente(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Clientes WHERE id_cliente =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarCliente(Cliente c, int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Clientes SET nombre = ?,apellido = ?,id_provincia = ?,pueblo = ?,telefono = ?,id_tipo_documento = ?,documento = ? WHERE id_cliente=?");
            pState.setString(1, c.getNombre());
            pState.setString(2, c.getApellido());
            pState.setInt(3, c.getId_provincia());
            pState.setString(4, c.getPueblo());
            pState.setLong(5, c.getTelefono());
            pState.setInt(6, c.getId_tipo_documento());
            pState.setLong(7, c.getDocumento());
            pState.setInt(8, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Cliente cargarClienteId(int id) {
        Cliente c = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Clientes WHERE id_cliente=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_cliente = consulta.getInt("id_cliente");
                String nombre = consulta.getString("nombre");
                String apellido = consulta.getString("apellido");
                int id_provincia = consulta.getInt("id_provincia");
                String pueblo = consulta.getString("pueblo");
                long telefono = consulta.getLong("telefono");
                int id_tipo_documento = consulta.getInt("id_tipo_documento");
                long documento = consulta.getLong("documento");
                c = new Cliente(id_cliente, nombre, apellido, id_provincia, pueblo, telefono, id_tipo_documento, documento);

            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    public long traerDocumento() {
        long documento = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select documento from Clientes");
            if (consulta.next()) {
                documento = consulta.getLong("documento");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return documento;
    }

    //------------------------------COBROS----------------------------------------------
    public ArrayList<TipoCobro> cargarTiposCobro() {
        ArrayList<TipoCobro> tiposCobro = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select 0 as id_tipo_cobro, 'Seleccione' as tipo_cobro union SELECT id_tipo_cobro,tipo_cobro FROM Tipos_cobro");
            //ResultSet consulta = state.executeQuery("SELECT*FROM Tipos_cobro");
            while (consulta.next()) {
                int id_tipo_cobro = consulta.getInt("id_tipo_cobro");
                String tipo_cobro = consulta.getString("tipo_cobro");
                TipoCobro tc = new TipoCobro(id_tipo_cobro, tipo_cobro);

                tiposCobro.add(tc);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tiposCobro;
    }

    public ArrayList<dtoAlquilerCliente> cargarAlquileresClientes() {
        ArrayList<dtoAlquilerCliente> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT id_alquiler,num_departamento,fecha_inicio,fecha_fin,nombre+' '+apellido as nombreApellido,documento,total FROM Alquileres a join Clientes c on a.id_cliente=c.id_cliente join Departamentos d on d.id_departamento=a.id_departamento where year(fecha_inicio)= year(GETDATE()) order by fecha_inicio");
            while (consulta.next()) {
                int id_alquiler = consulta.getInt("id_alquiler");
                int num_departamento = consulta.getInt("num_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                String nombreApellido = consulta.getString("nombreApellido");
                Long documento = consulta.getLong("documento");
                float total = consulta.getFloat("total");
                dtoAlquilerCliente c = new dtoAlquilerCliente(id_alquiler, num_departamento, fecha_inicio, fecha_fin, nombreApellido, documento, total);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void agregarCobro(Cobro c) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Cobros(id_tipo_cobro,id_alquiler,monto,fecha_cobro)VALUES(?,?,?,?)");
            pState.setInt(1, c.getId_tipo_cobro());
            pState.setInt(2, c.getId_alquiler());
            pState.setFloat(3, c.getMonto());
            java.util.Date d = c.getFecha_cobro();
            pState.setDate(4, new java.sql.Date(d.getTime()));
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoCobroAlqCliTipCob> cargarCobrosDto() {
        ArrayList<dtoCobroAlqCliTipCob> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("SELECT id_cobro,c.id_tipo_cobro,tipo_cobro,c.id_alquiler,a.id_departamento,num_departamento,fecha_inicio,fecha_fin,nombre+' '+apellido as nombreApellido,monto,fecha_cobro FROM Cobros c join Alquileres a on c.id_alquiler=a.id_alquiler join Clientes cli on a.id_cliente=cli.id_cliente join Tipos_cobro tp on tp.id_tipo_cobro=c.id_tipo_cobro join Departamentos d on d.id_departamento=a.id_departamento where year(fecha_cobro)=year(getdate()) order by fecha_cobro");
            while (consulta.next()) {
                int id_cobro = consulta.getInt("id_cobro");
                int id_tipo_cobro = consulta.getInt("id_tipo_cobro");
                String tipo_cobro = consulta.getString("tipo_cobro");
                int id_alquiler = consulta.getInt("id_alquiler");
                int id_departamento = consulta.getInt("id_departamento");
                int num_departamento = consulta.getInt("num_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                String nombreApellido = consulta.getString("nombreApellido");
                float monto = consulta.getFloat("monto");
                Date fecha_cobro = consulta.getDate("fecha_cobro");
                dtoCobroAlqCliTipCob c = new dtoCobroAlqCliTipCob(id_cobro, id_tipo_cobro, tipo_cobro, id_alquiler, id_departamento, num_departamento, fecha_inicio, fecha_fin, nombreApellido, monto, fecha_cobro);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarCobro(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Cobros WHERE id_cobro =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarCobro(Cobro c, int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Cobros SET id_tipo_cobro = ?,id_alquiler = ?,monto = ?,fecha_cobro = ? WHERE id_cobro=?");
            pState.setInt(1, c.getId_tipo_cobro());
            pState.setInt(2, c.getId_alquiler());
            pState.setFloat(3, c.getMonto());
            java.util.Date d = c.getFecha_cobro();
            pState.setDate(4, new java.sql.Date(d.getTime()));
            pState.setInt(5, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Cobro cargarCobroId(int id) {
        Cobro c = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Cobros WHERE id_cobro=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_cobro = consulta.getInt("id_cobro");
                int id_tipo_cobro = consulta.getInt("id_tipo_cobro");
                int id_alquiler = consulta.getInt("id_alquiler");
                float monto = consulta.getFloat("monto");
                Date fecha_cobro = consulta.getDate("fecha_cobro");
                c = new Cobro(id_cobro, id_tipo_cobro, id_alquiler, monto, fecha_cobro);

            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    public ArrayList<dtoCobroAlqCliTipCob> filtrarCobros(String año, String tipo) {
        ArrayList<dtoCobroAlqCliTipCob> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @tipo varchar(5)=" + tipo + ",\n"
                    + "@año varchar(10)=" + año + "\n"
                    + "SELECT id_cobro,c.id_tipo_cobro,tipo_cobro,c.id_alquiler,a.id_departamento,num_departamento,fecha_inicio,fecha_fin,nombre+' '+apellido as nombreApellido,monto,fecha_cobro FROM Cobros c join Alquileres a on c.id_alquiler=a.id_alquiler join Clientes cli on a.id_cliente=cli.id_cliente join Tipos_cobro tp on tp.id_tipo_cobro=c.id_tipo_cobro join Departamentos d on d.id_departamento=a.id_departamento\n"
                    + "where (YEAR(fecha_cobro)=@año or @año is null) and \n"
                    + "(c.id_tipo_cobro=@tipo or @tipo is null) and\n"
                    + "(YEAR(fecha_cobro)=@año or c.id_tipo_cobro=@tipo or @año is null or @tipo is null)order by fecha_cobro");
            while (consulta.next()) {
                int id_cobro = consulta.getInt("id_cobro");
                int id_tipo_cobro = consulta.getInt("id_tipo_cobro");
                String tipo_cobro = consulta.getString("tipo_cobro");
                int id_alquiler = consulta.getInt("id_alquiler");
                int id_departamento = consulta.getInt("id_departamento");
                int num_departamento = consulta.getInt("num_departamento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");
                String nombreApellido = consulta.getString("nombreApellido");
                float monto = consulta.getFloat("monto");
                Date fecha_cobro = consulta.getDate("fecha_cobro");
                dtoCobroAlqCliTipCob c = new dtoCobroAlqCliTipCob(id_cobro, id_tipo_cobro, tipo_cobro, id_alquiler, id_departamento, num_departamento, fecha_inicio, fecha_fin, nombreApellido, monto, fecha_cobro);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public boolean comprobarSeñaCobro(int id_alquiler) {
        boolean bandera = false;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select*from Cobros where id_tipo_cobro=1 and id_alquiler=" + id_alquiler + "");
            if (consulta.next()) {
                bandera = true;
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bandera;
    }

    //METODOS EXTRA PARA VALIDAR LOS COBROS AL REGISTRAR Y MODIFICAR------------------------------------------------
    public int ultimoIdCobro() {
        int id = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_cobro from Cobros where id_cobro=(select max(id_cobro) from Cobros)");
            if (consulta.next()) {
                id = consulta.getInt("id_cobro");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public int ultimoIdMovimientoBancario() {
        int id = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_movimiento_bancario from Movimientos_Bancarios where id_movimiento_bancario=(select max(id_movimiento_bancario) from Movimientos_Bancarios)");
            if (consulta.next()) {
                id = consulta.getInt("id_movimiento_bancario");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void agregarCobroMovimiento(CobroMovimiento c) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Cobros_Movimientos(id_cobro,id_movimiento_bancario)VALUES(?,?)");
            pState.setInt(1, c.getId_cobro());
            pState.setInt(2, c.getId_movimiento_bancario());
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public int ultimoIdBalanceGeneral() {
        int id = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_balance_general from Balance_General where id_balance_general=(select max(id_balance_general) from Balance_General)");
            if (consulta.next()) {
                id = consulta.getInt("id_balance_general");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void agregarCobroBalance(CobroBalance c) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Cobros_Balances(id_cobro,id_balance_general)VALUES(?,?)");
            pState.setInt(1, c.getId_cobro());
            pState.setInt(2, c.getId_balance_general());
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //--------------------------IMPUESTO----------------------------------------
    public ArrayList<TipoImpuesto> cargarTiposImpuestos() {
        ArrayList<TipoImpuesto> tiposImpuesto = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select 0 as id_tipo_impuesto, 'Seleccione' as tipo_impuesto union SELECT id_tipo_impuesto,tipo_impuesto FROM Tipos_impuesto");
            //ResultSet consulta = state.executeQuery("SELECT*FROM Tipos_impuesto");
            while (consulta.next()) {
                int id_tipo_impuesto = consulta.getInt("id_tipo_impuesto");
                String tipo_impuesto = consulta.getString("tipo_impuesto");
                TipoImpuesto ti = new TipoImpuesto(id_tipo_impuesto, tipo_impuesto);

                tiposImpuesto.add(ti);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tiposImpuesto;
    }

    public void agregarImpuesto(Impuesto i) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Impuestos(id_tipo_impuesto,fecha_impuesto,monto,fecha_impuesto_fin,fecha_pago)VALUES(?,?,?,?,?)");
            pState.setInt(1, i.getId_tipo_impuesto());
            java.util.Date d = i.getFecha_impuesto();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, i.getMonto());
            java.util.Date d2 = i.getFecha_impuesto_fin();
            pState.setDate(4, new java.sql.Date(d2.getTime()));
            java.util.Date d3 = i.getFecha_pago();
            pState.setDate(5, new java.sql.Date(d3.getTime()));
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoImpuestoTipo> cargarImpuestoDto() {
        ArrayList<dtoImpuestoTipo> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select id_impuesto,i.id_tipo_impuesto,tipo_impuesto,DateName(month,fecha_impuesto)+'/'+Convert(varchar(50),YEAR(fecha_impuesto)) as Mes,monto,fecha_impuesto_fin,fecha_pago from Impuestos i join Tipos_impuesto ti on i.id_tipo_impuesto=ti.id_tipo_impuesto where year(fecha_impuesto)=year(getdate()) order by fecha_impuesto");
            // ResultSet consulta = state.executeQuery("Select id_impuesto,i.id_tipo_impuesto,tipo_impuesto,DateName(month,fecha_impuesto)as Mes,monto,fecha_impuesto_fin,fecha_pago from Impuestos i join Tipos_impuesto ti on i.id_tipo_impuesto=ti.id_tipo_impuesto");
            while (consulta.next()) {
                int id_impuesto = consulta.getInt("id_impuesto");
                int id_tipo_impuesto = consulta.getInt("id_tipo_impuesto");
                String tipo_impuesto = consulta.getString("tipo_impuesto");
                String fecha_impuesto = consulta.getString("Mes");
                Date fecha_impuesto_fin = consulta.getDate("fecha_impuesto_fin");
                float monto = consulta.getFloat("monto");
                Date fecha_pago = consulta.getDate("fecha_pago");

                dtoImpuestoTipo i = new dtoImpuestoTipo(id_impuesto, id_tipo_impuesto, tipo_impuesto, fecha_impuesto, fecha_impuesto_fin, monto, fecha_pago);
                resultado.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarImpuesto(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Impuestos WHERE id_impuesto =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarImpuesto(Impuesto i, int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Impuestos SET id_tipo_impuesto = ?,fecha_impuesto = ?,monto = ?,fecha_impuesto_fin = ?,fecha_pago = ? WHERE id_impuesto=?");
            pState.setInt(1, i.getId_tipo_impuesto());
            java.util.Date d = i.getFecha_impuesto();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, i.getMonto());
            java.util.Date d2 = i.getFecha_impuesto_fin();
            pState.setDate(4, new java.sql.Date(d2.getTime()));
            java.util.Date d3 = i.getFecha_pago();
            pState.setDate(5, new java.sql.Date(d3.getTime()));
            pState.setInt(6, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Impuesto cargarImpuestoId(int id) {
        Impuesto i = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Impuestos WHERE id_impuesto=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_impuesto = consulta.getInt("id_impuesto");
                int id_tipo_impuesto = consulta.getInt("id_tipo_impuesto");
                Date fecha_impuesto = consulta.getDate("fecha_impuesto");
                float monto = consulta.getFloat("monto");
                Date fecha_impuesto_fin = consulta.getDate("fecha_impuesto_fin");
                Date fecha_pago = consulta.getDate("fecha_pago");
                i = new Impuesto(id_impuesto, id_tipo_impuesto, fecha_impuesto, fecha_impuesto_fin, fecha_pago, monto);
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i;
    }

    public ArrayList<dtoImpuestoTipo> filtrarImpuestos(String mes, String año) {
        ArrayList<dtoImpuestoTipo> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "Select id_impuesto,i.id_tipo_impuesto,tipo_impuesto,DateName(month,fecha_impuesto)+'/'+Convert(varchar(50),YEAR(fecha_impuesto)) as Mes,monto,fecha_impuesto_fin,fecha_pago from Impuestos i join Tipos_impuesto ti on i.id_tipo_impuesto=ti.id_tipo_impuesto\n"
                    + "where (DateName(month,fecha_impuesto)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha_impuesto)=@año or @año is null)and\n"
                    + "(DateName(month,fecha_impuesto)=@mes and YEAR(fecha_impuesto)=@año or @año is null or @mes is null) order by fecha_impuesto");
            while (consulta.next()) {
                int id_impuesto = consulta.getInt("id_impuesto");
                int id_tipo_impuesto = consulta.getInt("id_tipo_impuesto");
                String tipo_impuesto = consulta.getString("tipo_impuesto");
                String fecha_impuesto = consulta.getString("Mes");
                Date fecha_impuesto_fin = consulta.getDate("fecha_impuesto_fin");
                float monto = consulta.getFloat("monto");
                Date fecha_pago = consulta.getDate("fecha_pago");

                dtoImpuestoTipo i = new dtoImpuestoTipo(id_impuesto, id_tipo_impuesto, tipo_impuesto, fecha_impuesto, fecha_impuesto_fin, monto, fecha_pago);
                resultado.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    //IMPUESTOSBALANCE
    public int ultimoIdImpuesto() {
        int id = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_impuesto from Impuestos where id_impuesto=(select max(id_impuesto) from Impuestos)");
            if (consulta.next()) {
                id = consulta.getInt("id_impuesto");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void agregarImpuestoBalance(ImpuestoBalance i) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Impuestos_Balance(id_balance_general,id_impuesto)VALUES(?,?)");
            pState.setInt(1, i.getId_balance_general());
            pState.setInt(2, i.getId_impuesto());
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //------------------------SERVICIOS-------------------------------------
    public ArrayList<TipoServicio> cargarTiposServicios() {
        ArrayList<TipoServicio> tiposServicio = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select 0 as id_tipo_servicio, 'Seleccione' as tipo_servicio union SELECT id_tipo_servicio,tipo_servicio FROM Tipos_servicio");
            //ResultSet consulta = state.executeQuery("SELECT*FROM Tipos_servicio");
            while (consulta.next()) {
                int id_tipo_servicio = consulta.getInt("id_tipo_servicio");
                String tipo_servicio = consulta.getString("tipo_servicio");
                TipoServicio ts = new TipoServicio(id_tipo_servicio, tipo_servicio);

                tiposServicio.add(ts);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tiposServicio;
    }

    public void agregarServicio(Servicio s) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Servicios(id_tipo_servicio,fecha_servicio,monto,fecha_servicio_fin,fecha_pago)VALUES(?,?,?,?,?)");
            pState.setInt(1, s.getId_tipo_servicio());
            java.util.Date d = s.getFecha_servicio();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, s.getMonto());
            java.util.Date d2 = s.getFecha_servicio_fin();
            pState.setDate(4, new java.sql.Date(d2.getTime()));
            java.util.Date d3 = s.getFecha_pago();
            pState.setDate(5, new java.sql.Date(d3.getTime()));
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoServicioTipo> cargarServicioDto() {
        ArrayList<dtoServicioTipo> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select id_servicio,s.id_tipo_servicio,tipo_servicio,DateName(month,fecha_servicio)+'/'+Convert(varchar(50),YEAR(fecha_servicio))as Mes,fecha_servicio_fin,monto,fecha_pago from Servicios s join Tipos_servicio ts on s.id_tipo_servicio=ts.id_tipo_servicio where year(fecha_servicio)=year(getdate()) order by fecha_servicio");
            //ResultSet consulta = state.executeQuery("Select id_servicio,s.id_tipo_servicio,tipo_servicio,DateName(month,fecha_servicio)as Mes,fecha_servicio_fin,monto,fecha_pago from Servicios s join Tipos_servicio ts on s.id_tipo_servicio=ts.id_tipo_servicio");
            while (consulta.next()) {
                int id_servicio = consulta.getInt("id_servicio");
                int id_tipo_servicio = consulta.getInt("id_tipo_servicio");
                String tipo_servicio = consulta.getString("tipo_servicio");
                String fecha_servicio = consulta.getString("Mes");
                Date fecha_servicio_fin = consulta.getDate("fecha_servicio_fin");
                float monto = consulta.getFloat("monto");
                Date fecha_pago = consulta.getDate("fecha_pago");

                dtoServicioTipo s = new dtoServicioTipo(id_servicio, id_tipo_servicio, tipo_servicio, fecha_servicio, fecha_servicio_fin, monto, fecha_pago);
                resultado.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarServicio(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Servicios WHERE id_servicio =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarServicio(Servicio s, int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Servicios SET id_tipo_servicio = ?,fecha_servicio = ?,monto = ?,fecha_servicio_fin = ?,fecha_pago = ? WHERE id_servicio=?");
            pState.setInt(1, s.getId_tipo_servicio());
            java.util.Date d = s.getFecha_servicio();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, s.getMonto());
            java.util.Date d2 = s.getFecha_servicio_fin();
            pState.setDate(4, new java.sql.Date(d2.getTime()));
            java.util.Date d3 = s.getFecha_pago();
            pState.setDate(5, new java.sql.Date(d3.getTime()));
            pState.setInt(6, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Servicio cargarServicioId(int id) {
        Servicio s = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Servicios WHERE id_servicio=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_servicio = consulta.getInt("id_servicio");
                int id_tipo_servicio = consulta.getInt("id_tipo_servicio");
                Date fecha_servicio = consulta.getDate("fecha_servicio");
                Date fecha_servicio_fin = consulta.getDate("fecha_servicio_fin");
                float monto = consulta.getFloat("monto");
                Date fecha_pago = consulta.getDate("fecha_pago");
                s = new Servicio(id_servicio, id_tipo_servicio, fecha_servicio, fecha_servicio_fin, fecha_pago, monto);
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }

    public ArrayList<dtoServicioTipo> filtrarServicios(String mes, String año) {
        ArrayList<dtoServicioTipo> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "Select id_servicio,s.id_tipo_servicio,tipo_servicio,DateName(month,fecha_servicio)+'/'+Convert(varchar(50),YEAR(fecha_servicio))as Mes,fecha_servicio_fin,monto,fecha_pago from Servicios s join Tipos_servicio ts on s.id_tipo_servicio=ts.id_tipo_servicio\n"
                    + "where (DateName(month,fecha_servicio)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha_servicio)=@año or @año is null)and\n"
                    + "(DateName(month,fecha_servicio)=@mes and YEAR(fecha_servicio)=@año or @año is null or @mes is null) order by fecha_servicio");
            //ResultSet consulta = state.executeQuery("Select id_servicio,s.id_tipo_servicio,tipo_servicio,DateName(month,fecha_servicio)+'/'+Convert(varchar(50),YEAR(fecha_servicio))as Mes,fecha_servicio_fin,monto,fecha_pago from Servicios s join Tipos_servicio ts on s.id_tipo_servicio=ts.id_tipo_servicio");
            while (consulta.next()) {
                int id_servicio = consulta.getInt("id_servicio");
                int id_tipo_servicio = consulta.getInt("id_tipo_servicio");
                String tipo_servicio = consulta.getString("tipo_servicio");
                String fecha_servicio = consulta.getString("Mes");
                Date fecha_servicio_fin = consulta.getDate("fecha_servicio_fin");
                float monto = consulta.getFloat("monto");
                Date fecha_pago = consulta.getDate("fecha_pago");

                dtoServicioTipo s = new dtoServicioTipo(id_servicio, id_tipo_servicio, tipo_servicio, fecha_servicio, fecha_servicio_fin, monto, fecha_pago);
                resultado.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    //IMPUESTOSSERVICIO
    public int ultimoIdServicio() {
        int id = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_servicio from Servicios where id_servicio=(select max(id_servicio) from Servicios)");
            if (consulta.next()) {
                id = consulta.getInt("id_servicio");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void agregarServicioBalance(ServicioBalance s) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Servicios_Balance(id_servicio,id_balance_general)VALUES(?,?)");
            pState.setInt(1, s.getId_servicio());
            pState.setInt(2, s.getId_balance_general());
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //------------------------------MANTENIMIENTO----------------------------------
    public ArrayList<TipoMantenimiento> cargarTiposMantenimiento() {
        ArrayList<TipoMantenimiento> tiposMantenimiento = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select 0 as id_tipo_mantenimiento, 'Seleccione' as tipo_mantenimiento union SELECT id_tipo_mantenimiento,tipo_mantenimiento FROM Tipos_mantenimiento");
            //ResultSet consulta = state.executeQuery("SELECT*FROM Tipos_mantenimiento");
            while (consulta.next()) {
                int id_tipo_mantenimiento = consulta.getInt("id_tipo_mantenimiento");
                String tipo_mantenimiento = consulta.getString("tipo_mantenimiento");
                TipoMantenimiento tm = new TipoMantenimiento(id_tipo_mantenimiento, tipo_mantenimiento);

                tiposMantenimiento.add(tm);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tiposMantenimiento;
    }

    public void agregarMantenimiento(Mantenimiento m) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Mantenimientos(id_tipo_mantenimiento,fecha_mantenimiento,monto,agregado)VALUES(?,?,?,?)");
            pState.setInt(1, m.getId_tipo_mantenimiento());
            java.util.Date d = m.getFecha_mantenimiento();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, m.getMonto());
            pState.setString(4, m.getAgregado());
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoMantenimientoTipo> cargarMantenimientoDto() {
        ArrayList<dtoMantenimientoTipo> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("Select id_mantenimiento,m.id_tipo_mantenimiento,tipo_mantenimiento,fecha_mantenimiento,monto,agregado from Mantenimientos m join Tipos_mantenimiento tm on m.id_tipo_mantenimiento=tm.id_tipo_mantenimiento where year(fecha_mantenimiento)=year(getdate()) order by fecha_mantenimiento");
            while (consulta.next()) {
                int id_mantenimiento = consulta.getInt("id_mantenimiento");
                int id_tipo_mantenimiento = consulta.getInt("id_tipo_mantenimiento");
                String tipo_mantenimiento = consulta.getString("tipo_mantenimiento");
                Date fecha_mantenimiento = consulta.getDate("fecha_mantenimiento");
                float monto = consulta.getFloat("monto");
                String agregado = consulta.getString("agregado");
                dtoMantenimientoTipo m = new dtoMantenimientoTipo(id_mantenimiento, id_tipo_mantenimiento, tipo_mantenimiento, fecha_mantenimiento, monto, agregado);
                resultado.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarMantenimiento(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Mantenimientos WHERE id_mantenimiento =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarMantenimiento(Mantenimiento m, int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Mantenimientos SET id_tipo_mantenimiento = ?,fecha_mantenimiento = ?,monto = ?,agregado = ? WHERE id_mantenimiento=?");
            pState.setInt(1, m.getId_tipo_mantenimiento());
            java.util.Date d = m.getFecha_mantenimiento();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, m.getMonto());
            pState.setString(4, m.getAgregado());
            pState.setInt(5, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Mantenimiento cargarMantenimientoId(int id) {
        Mantenimiento m = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Mantenimientos WHERE id_mantenimiento=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_mantenimiento = consulta.getInt("id_mantenimiento");
                int id_tipo_mantenimiento = consulta.getInt("id_tipo_mantenimiento");
                Date fecha_mantenimiento = consulta.getDate("fecha_mantenimiento");
                float monto = consulta.getFloat("monto");
                String agregado = consulta.getString("agregado");
                m = new Mantenimiento(id_mantenimiento, id_tipo_mantenimiento, fecha_mantenimiento, monto, agregado);
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return m;
    }

    public ArrayList<dtoMantenimientoTipo> filtroMantenimiento(String mes, String año) {
        ArrayList<dtoMantenimientoTipo> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "Select id_mantenimiento,m.id_tipo_mantenimiento,tipo_mantenimiento,fecha_mantenimiento,monto,agregado from Mantenimientos m join Tipos_mantenimiento tm on m.id_tipo_mantenimiento=tm.id_tipo_mantenimiento\n"
                    + "where (MONTH(fecha_mantenimiento)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha_mantenimiento)=@año or @año is null)and\n"
                    + "(MONTH(fecha_mantenimiento)=@mes and YEAR(fecha_mantenimiento)=@año or @año is null or @mes is null) order by fecha_mantenimiento");
            while (consulta.next()) {
                int id_mantenimiento = consulta.getInt("id_mantenimiento");
                int id_tipo_mantenimiento = consulta.getInt("id_tipo_mantenimiento");
                String tipo_mantenimiento = consulta.getString("tipo_mantenimiento");
                Date fecha_mantenimiento = consulta.getDate("fecha_mantenimiento");
                float monto = consulta.getFloat("monto");
                String agregado = consulta.getString("agregado");
                dtoMantenimientoTipo m = new dtoMantenimientoTipo(id_mantenimiento, id_tipo_mantenimiento, tipo_mantenimiento, fecha_mantenimiento, monto, agregado);
                resultado.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    //MantenimientosBalance
    public int ultimoIdMantenimiento() {
        int id = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_mantenimiento from Mantenimientos where id_mantenimiento=(select max(id_mantenimiento) from Mantenimientos)");
            if (consulta.next()) {
                id = consulta.getInt("id_mantenimiento");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void agregarMantenimientoBalance(MantenimientoBalance m) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Mantenimientos_Balance(id_mantenimiento,id_balance_general)VALUES(?,?)");
            pState.setInt(1, m.getId_mantenimiento());
            pState.setInt(2, m.getId_balance_general());
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //--------------------------MOVIMIENTOS BANCARIOS------------------------------------------
    public void agregarMovimientoBancario(MovimientoBancario mb) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Movimientos_Bancarios(concepto,fecha_movimiento,entrada,salida,saldo)VALUES(?,?,?,?,?)");
            pState.setString(1, mb.getConcepto());
            java.util.Date d = mb.getFecha_movimiento();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, mb.getEntrada());
            pState.setFloat(4, mb.getSalida());
            pState.setFloat(5, mb.getSaldo());;
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
//
//    public float SaldoMovimientos() {
//        float saldo = 0;
//        try {
//            abrirConexion();
//            Statement state = conn.createStatement();
//            ResultSet consulta = state.executeQuery("select sum(entrada)-sum(salida) as saldo from Movimientos_Bancarios where YEAR(fecha_movimiento) = year(GETDATE())");
//            if (consulta.next()) {
//                saldo = consulta.getFloat("saldo");
//            }
//            consulta.close();
//            state.close();
//            cerrarConexion();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return saldo;
//    }

    public float SaldoMovimientos(String mes, String año) {
        float saldo = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "select sum(entrada)-sum(salida) as saldo from Movimientos_Bancarios \n"
                    + "where (MONTH(fecha_movimiento)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha_movimiento)=@año or @año is null)and\n"
                    + "(MONTH(fecha_movimiento)=@mes and YEAR(fecha_movimiento)=@año or @año is null or @mes is null)");
            if (consulta.next()) {
                saldo = consulta.getFloat("saldo");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return saldo;
    }

    //Saldo Anterior movimiento
    public float SaldoMovimientoId(int id) {
        float saldo = 0;
        id = id - 1;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("select saldo from Movimientos_Bancarios where id_movimiento_bancario=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                saldo = consulta.getFloat("saldo");
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return saldo;
    }

    public int movimientoCobroWhere(int id) {
        int id_movimiento_bancario = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_movimiento_bancario from Cobros_Movimientos where id_cobro=" + id + "");
            if (consulta.next()) {
                id_movimiento_bancario = consulta.getInt("id_movimiento_bancario");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id_movimiento_bancario;
    }

    public void modificarMovimientoBancario(MovimientoBancario mb, int id_movimiento_bancario) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Movimientos_Bancarios SET concepto = ?,fecha_movimiento = ?,entrada= ?,salida = ?,saldo = ? WHERE id_movimiento_bancario=?");
            pState.setString(1, mb.getConcepto());
            java.util.Date d = mb.getFecha_movimiento();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, mb.getEntrada());
            pState.setFloat(4, mb.getSalida());
            pState.setFloat(5, mb.getSaldo());
            pState.setInt(6, id_movimiento_bancario);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<MovimientoBancario> cargarMovimientos() {
        ArrayList<MovimientoBancario> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_movimiento_bancario,concepto,fecha_movimiento,entrada,salida,saldo from Movimientos_Bancarios where YEAR(fecha_movimiento) = year(GETDATE())");
            while (consulta.next()) {
                int id_movimiento_bancario = consulta.getInt("id_movimiento_bancario");
                String concepto = consulta.getString("concepto");
                Date fecha_movimiento = consulta.getDate("fecha_movimiento");
                float entrada = consulta.getFloat("entrada");
                float salida = consulta.getFloat("salida");
                float saldo = consulta.getFloat("saldo");
                MovimientoBancario m = new MovimientoBancario(id_movimiento_bancario, concepto, fecha_movimiento, entrada, salida, saldo);
                resultado.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarMovimiento(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Movimientos_Bancarios WHERE id_movimiento_bancario=?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public MovimientoBancario cargarMovimientoId(int id) {
        MovimientoBancario m = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Movimientos_Bancarios WHERE id_movimiento_bancario=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_movimiento_bancario = consulta.getInt("id_movimiento_bancario");
                String concepto = consulta.getString("concepto");
                Date fecha_movimiento = consulta.getDate("fecha_movimiento");
                float entrada = consulta.getFloat("entrada");
                float salida = consulta.getFloat("salida");
                float saldo = consulta.getFloat("saldo");
                m = new MovimientoBancario(id_movimiento_bancario, concepto, fecha_movimiento, entrada, salida, saldo);
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return m;
    }

    public ArrayList<MovimientoBancario> filtrarMovimientos(String mes, String año) {
        ArrayList<MovimientoBancario> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "select id_movimiento_bancario,concepto,fecha_movimiento,entrada,salida,saldo from Movimientos_Bancarios\n"
                    + "where (MONTH(fecha_movimiento)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha_movimiento)=@año or @año is null)and\n"
                    + "(MONTH(fecha_movimiento)=@mes and YEAR(fecha_movimiento)=@año or @año is null or @mes is null)");
            while (consulta.next()) {
                int id_movimiento_bancario = consulta.getInt("id_movimiento_bancario");
                String concepto = consulta.getString("concepto");
                Date fecha_movimiento = consulta.getDate("fecha_movimiento");
                float entrada = consulta.getFloat("entrada");
                float salida = consulta.getFloat("salida");
                float saldo = consulta.getFloat("saldo");
                MovimientoBancario m = new MovimientoBancario(id_movimiento_bancario, concepto, fecha_movimiento, entrada, salida, saldo);
                resultado.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    //------------------------BALANCE GENERAL-----------------------------------
    public void agregarBalance(BalanceGeneral bg) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Balance_General(concepto,fecha,entrada,salida,saldo)VALUES(?,?,?,?,?)");
            pState.setString(1, bg.getConcepto());
            java.util.Date d = bg.getFecha();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, bg.getEntrada());
            pState.setFloat(4, bg.getSalida());
            pState.setFloat(5, bg.getSaldo());;
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public float SaldoBalance(String mes, String año) {
        float saldo = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "select sum(entrada)-sum(salida) as saldo from Balance_General\n"
                    + "where (MONTH(fecha)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha)=@año or @año is null)and\n"
                    + "(MONTH(fecha)=@mes and YEAR(fecha)=@año or @año is null or @mes is null)");
            // ResultSet consulta = state.executeQuery("select sum(entrada)-sum(salida) as saldo from Balance_General where YEAR(fecha) = year(GETDATE())");
            if (consulta.next()) {
                saldo = consulta.getFloat("saldo");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return saldo;
    }

//    //SALDO ANTERIOR AL BALANCE GENERAL  
    public float SaldoBalanceId(int id_balance_general) {
        float saldo = 0;
        id_balance_general = id_balance_general - 1;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("select saldo from Balance_General where id_balance_general=?");
            pState.setInt(1, id_balance_general);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                saldo = consulta.getFloat("saldo");
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return saldo;
    }

    public void modificarBalanceGeneral(BalanceGeneral bg, int id_balance_general) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Balance_General SET concepto = ?,fecha = ?,entrada= ?,salida = ?,saldo = ? WHERE id_balance_general=?");
            pState.setString(1, bg.getConcepto());
            java.util.Date d = bg.getFecha();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.setFloat(3, bg.getEntrada());
            pState.setFloat(4, bg.getSalida());
            pState.setFloat(5, bg.getSaldo());
            pState.setInt(6, id_balance_general);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<BalanceGeneral> cargarBalances() {
        ArrayList<BalanceGeneral> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_balance_general,concepto,fecha,entrada,salida,saldo from Balance_General where YEAR(fecha) = year(GETDATE())");
            while (consulta.next()) {
                int id_balance_general = consulta.getInt("id_balance_general");
                String concepto = consulta.getString("concepto");
                Date fecha = consulta.getDate("fecha");
                float entrada = consulta.getFloat("entrada");
                float salida = consulta.getFloat("salida");
                float saldo = consulta.getFloat("saldo");
                BalanceGeneral m = new BalanceGeneral(id_balance_general, concepto, fecha, entrada, salida, saldo);
                resultado.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarBalance(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Balance_General WHERE id_balance_general=?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public BalanceGeneral cargarBalanceId(int id) {
        BalanceGeneral m = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Balance_General WHERE id_balance_general=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_balance_general = consulta.getInt("id_balance_general");
                String concepto = consulta.getString("concepto");
                Date fecha = consulta.getDate("fecha");
                float entrada = consulta.getFloat("entrada");
                float salida = consulta.getFloat("salida");
                float saldo = consulta.getFloat("saldo");
                m = new BalanceGeneral(id_balance_general, concepto, fecha, entrada, salida, saldo);
            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return m;
    }

    public ArrayList<BalanceGeneral> filtrarBalance(String mes, String año) {
        ArrayList<BalanceGeneral> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @mes varchar(100)=" + mes + ",\n"
                    + "@año varchar(50)=" + año + "\n"
                    + "select id_balance_general,concepto,fecha,entrada,salida,saldo from Balance_General\n"
                    + "where (MONTH(fecha)=@mes or @mes is null)and\n"
                    + "(YEAR(fecha)=@año or @año is null)and\n"
                    + "(MONTH(fecha)=@mes and YEAR(fecha)=@año or @año is null or @mes is null)");
            while (consulta.next()) {
                int id_balance_general = consulta.getInt("id_balance_general");
                String concepto = consulta.getString("concepto");
                Date fecha = consulta.getDate("fecha");
                float entrada = consulta.getFloat("entrada");
                float salida = consulta.getFloat("salida");
                float saldo = consulta.getFloat("saldo");
                BalanceGeneral m = new BalanceGeneral(id_balance_general, concepto, fecha, entrada, salida, saldo);
                resultado.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    //EXTRAS BALANCE
    public int balanceCobroWhere(int id) {
        int id_balance_general = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_balance_general from Cobros_Balances where id_cobro=" + id + "");
            if (consulta.next()) {
                id_balance_general = consulta.getInt("id_balance_general");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id_balance_general;
    }

    public int balanceImpuestoWhere(int id) {
        int id_balance_general = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_balance_general from Impuestos_Balance where id_impuesto=" + id + "");
            if (consulta.next()) {
                id_balance_general = consulta.getInt("id_balance_general");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id_balance_general;
    }

    public int balanceServicioWhere(int id) {
        int id_balance_general = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_balance_general from Servicios_Balance where id_servicio=" + id + "");
            if (consulta.next()) {
                id_balance_general = consulta.getInt("id_balance_general");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id_balance_general;
    }

    public int balanceMantenimientoWhere(int id) {
        int id_balance_general = 0;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_balance_general from Mantenimientos_Balance where id_mantenimiento=" + id + "");
            if (consulta.next()) {
                id_balance_general = consulta.getInt("id_balance_general");
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id_balance_general;
    }

    //---------------------CONTRATOS---------------------------------------
    public void agregarContrato(Contrato c) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Contratos(id_alquiler,fecha_contrato) VALUES(?,?)");
            pState.setInt(1, c.getId_alquiler());
            java.util.Date d = c.getFecha_contrato();
            pState.setDate(2, new java.sql.Date(d.getTime()));
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoContratoAlquiler> cargarContratosDto() {
        ArrayList<dtoContratoAlquiler> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_contrato,c.id_alquiler,fecha_contrato,num_departamento,nombre+' '+apellido as cliente,documento,fecha_inicio,fecha_fin from Contratos c join Alquileres a on c.id_alquiler=a.id_alquiler join Departamentos d on d.id_departamento=a.id_departamento join Clientes cli on cli.id_cliente=a.id_cliente where year(fecha_contrato)=year(getdate()) order by fecha_contrato");
            while (consulta.next()) {
                int id_contrato = consulta.getInt("id_contrato");
                int id_alquiler = consulta.getInt("id_alquiler");
                Date fecha_contrato = consulta.getDate("fecha_contrato");
                int num_departamento = consulta.getInt("num_departamento");
                String cliente = consulta.getString("cliente");
                long documento = consulta.getLong("documento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");

                dtoContratoAlquiler c = new dtoContratoAlquiler(id_contrato, id_alquiler, fecha_contrato, num_departamento, cliente, documento, fecha_inicio, fecha_fin);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void eliminarContrato(int id) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE FROM Contratos WHERE id_contrato =?");
            pState.setInt(1, id);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoContratoAlquiler> filtroContratos(String depto, String año) {
        ArrayList<dtoContratoAlquiler> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("declare @depto varchar(5)=" + depto + ",\n"
                    + "@año varchar(10)=" + año + "\n"
                    + "select id_contrato,c.id_alquiler,fecha_contrato,num_departamento,nombre+' '+apellido as cliente,documento,fecha_inicio,fecha_fin from Contratos c join Alquileres a on c.id_alquiler=a.id_alquiler join Departamentos d on d.id_departamento=a.id_departamento join Clientes cli on cli.id_cliente=a.id_cliente\n"
                    + "where (YEAR(fecha_contrato)=@año or @año is null) and \n"
                    + "(num_departamento=@depto or @depto is null) and\n"
                    + "(YEAR(fecha_contrato)=@año or num_departamento=@depto or @año is null or @depto is null) order by fecha_contrato");
            while (consulta.next()) {
                int id_contrato = consulta.getInt("id_contrato");
                int id_alquiler = consulta.getInt("id_alquiler");
                Date fecha_contrato = consulta.getDate("fecha_contrato");
                int num_departamento = consulta.getInt("num_departamento");
                String cliente = consulta.getString("cliente");
                long documento = consulta.getLong("documento");
                Date fecha_inicio = consulta.getDate("fecha_inicio");
                Date fecha_fin = consulta.getDate("fecha_fin");

                dtoContratoAlquiler c = new dtoContratoAlquiler(id_contrato, id_alquiler, fecha_contrato, num_departamento, cliente, documento, fecha_inicio, fecha_fin);

                resultado.add(c);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public boolean comprobarContrato(int id) {
        boolean bandera = false;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select*from Contratos where id_alquiler=" + id + "");
            if (consulta.next()) {
                bandera = true;
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bandera;
    }
    
        public boolean consultarSeñaContrato(int id_cliente, int id_alquiler) {
        boolean bandera = false;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select* from Cobros c join Alquileres a on c.id_alquiler=a.id_alquiler join Clientes cl on cl.id_cliente=a.id_cliente where id_tipo_cobro=1 and a.id_cliente ="+id_cliente+" and  c.id_alquiler="+id_alquiler+"");            
            if (consulta.next()) {
                bandera = true;
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bandera;
    }
    

    //--------------------------COBROS MOVIMIENTOS --------------------------------------
    public void eliminarCobroMovimiento(int id_cobro, int id_movimiento_bancario) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Cobros_Movimientos where id_cobro=? and id_movimiento_bancario=?");
            pState.setInt(1, id_cobro);
            pState.setInt(2, id_movimiento_bancario);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //-----------------------------COBRO BALANCE -------------------------------------------
    public void eliminarCobroBalance(int id_cobro, int id_balance_general) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Cobros_Balances where id_cobro=? and id_balance_general=?");
            pState.setInt(1, id_cobro);
            pState.setInt(2, id_balance_general);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //------------------------------IMPUESTO BALANCE -----------------------------
    public void eliminarImpuestoBalance(int id_impuesto, int id_balance_general) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Impuestos_Balance where id_impuesto=? and id_balance_general=?");
            pState.setInt(1, id_impuesto);
            pState.setInt(2, id_balance_general);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    //------------------------------SERVICIO BALANCE -----------------------------

    public void eliminarServicioBalance(int id_servicio, int id_balance_general) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Servicios_Balance where id_servicio=? and id_balance_general=?");
            pState.setInt(1, id_servicio);
            pState.setInt(2, id_balance_general);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    //------------------------------MANTENIMIENTO BALANCE -----------------------------

    public void eliminarMantenimientoBalance(int id_mantenimiento, int id_balance_general) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Mantenimientos_Balance where id_mantenimiento=? and id_balance_general=?");
            pState.setInt(1, id_mantenimiento);
            pState.setInt(2, id_balance_general);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //-------------------------------EMPLEADOS -------------------------------------
    public void agregarEmpleado(Empleado e) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Empleados(id_tipo_mantenimiento,nombre_completo,telefono,documento,direccion,tipo_edilicio) VALUES(?,?,?,?,?,?)");
            pState.setInt(1, e.getId_tipo_mantenimiento());
            pState.setString(2, e.getNombreCompleto());
            pState.setLong(3, e.getTelefono());
            pState.setLong(4, e.getDocumento());
            pState.setString(5, e.getDireccion());
            pState.setString(6, e.getTipo_edilicio());
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void eliminarEmpleado(int id_empleado) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Empleados where id_empleado=?");
            pState.setInt(1, id_empleado);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<dtoEmpleadosTipoMan> cargarEmpleadosDto() {
        ArrayList<dtoEmpleadosTipoMan> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select id_empleado,e.id_tipo_mantenimiento,tipo_mantenimiento,nombre_completo,telefono,documento,direccion,tipo_edilicio from Empleados e join Tipos_mantenimiento t on t.id_tipo_mantenimiento=e.id_tipo_mantenimiento");
            while (consulta.next()) {
                int id_empleado = consulta.getInt("id_empleado");
                int id_tipo_mantenimiento = consulta.getInt("id_tipo_mantenimiento");
                String tipo_mantenimiento = consulta.getString("tipo_mantenimiento");
                String nombre_completo = consulta.getString("nombre_completo");
                long telefono = consulta.getLong("telefono");
                long documento = consulta.getLong("documento");
                String direccion = consulta.getString("direccion");
                String tipo_edilicio = consulta.getString("tipo_edilicio");

                dtoEmpleadosTipoMan e = new dtoEmpleadosTipoMan(id_empleado, id_tipo_mantenimiento, tipo_mantenimiento, nombre_completo, telefono, documento, direccion, tipo_edilicio);

                resultado.add(e);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public Empleado cargarEmpleadoId(int id) {
        Empleado e = null;
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("SELECT*FROM Empleados WHERE id_empleado=?");
            pState.setInt(1, id);
            ResultSet consulta = pState.executeQuery();
            if (consulta.next()) {
                int id_empleado = consulta.getInt("id_empleado");
                int id_tipo_mantenimiento = consulta.getInt("id_tipo_mantenimiento");
                String nombre_completo = consulta.getString("nombre_completo");
                long telefono = consulta.getLong("telefono");
                long documento = consulta.getLong("documento");
                String direccion = consulta.getString("direccion");
                String tipo_edilicio = consulta.getString("tipo_edilicio");

                e = new Empleado(id_empleado, id_tipo_mantenimiento, nombre_completo, telefono, documento, direccion, tipo_edilicio);

            }
            consulta.close();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }

    public void modificarEmpleado(Empleado e, int id_empleado) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("UPDATE Empleados SET id_tipo_mantenimiento = ? ,nombre_completo = ?,telefono = ?,documento = ?,direccion = ?,tipo_edilicio = ? WHERE id_empleado=?");
            pState.setInt(1, e.getId_tipo_mantenimiento());
            pState.setString(2, e.getNombreCompleto());
            pState.setLong(3, e.getTelefono());
            pState.setLong(4, e.getDocumento());
            pState.setString(5, e.getDireccion());
            pState.setString(6, e.getTipo_edilicio());
            pState.setInt(7, id_empleado);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //-----------------------------GASTOS---------------------------------
    public ArrayList<dtoGastos> cargarGastosDto(String mes, String año) {
        ArrayList<dtoGastos> resultado = new ArrayList();
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select*from gastosMesAñoVerdadero(" + mes + "," + año + ") Order by year(Fecha),month(fecha),day(fecha)");
            while (consulta.next()) {
                String gasto = consulta.getString("Gasto de:");
                String fecha = consulta.getString("Fecha");
                String monto = consulta.getString("monto");
                Date fecha_pago = consulta.getDate("Fecha de pago");
                Date fecha_vencimiento = consulta.getDate("Fecha de vencimiento");
                String agregado = consulta.getString("agregado");

                dtoGastos g = new dtoGastos(gasto, fecha, monto, fecha_pago, fecha_vencimiento, agregado);

                resultado.add(g);
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    //-----------------------------------DEPARTAMENTOS------------------------------------
    public void agregarDepartamento(int num) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("INSERT INTO Departamentos(num_departamento) VALUES(?)");
            pState.setInt(1, num);
            pState.executeUpdate();
            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void eliminarDepartamento(int numero) {
        try {
            abrirConexion();
            PreparedStatement pState = conn.prepareStatement("DELETE from Departamentos where num_departamento=?");
            pState.setInt(1, numero);
            pState.executeUpdate();

            pState.close();
            cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Este departamento esta en uso", "ERROR!", JOptionPane.CANCEL_OPTION);
            System.out.println(ex);
        }
    }

    public boolean comprobarDepartamento(int num_departamento) {
        boolean bandera = false;
        try {
            abrirConexion();
            Statement state = conn.createStatement();
            ResultSet consulta = state.executeQuery("select*from Departamentos where num_departamento=" + num_departamento + "");
            if (consulta.next()) {
                bandera = true;
            }
            consulta.close();
            state.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bandera;
    }

}
