package Frame_Vistas;

import Clases_Modelos.Cliente;
import Clases_Modelos.ClienteData;
import Clases_Modelos.Conexion;
import Clases_Modelos.Usuario;
import Clases_Modelos.UsuarioData;
import Clases_Modelos.LimpiarFrm;
import Clases_Modelos.ModelarTabla;
import Clases_Modelos.Producto;
import Clases_Modelos.ProductoData;
import Clases_Modelos.Venta;
import Clases_Modelos.VentaData;
import Clases_Modelos.Venta_Detalle;
import Clases_Modelos.Venta_Detalle_Data;
import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class RegistrarVenta extends javax.swing.JDialog {
    private int controldecambio=-1;
    private int cambio=-1;
    public static String usuario2;
    private int control;//variable que me controla la creacion de una factura nueva
    private boolean cargaCliente = false;//Variable que controla la carga de un cliente
    private DefaultTableModel modelo;
    private UsuarioData userData = new UsuarioData();
    private ProductoData pDat = new ProductoData();
    private VentaData venData = new VentaData();
    private Venta_Detalle_Data detalleData = new Venta_Detalle_Data();
    private ArrayList<Venta> ventas = new ArrayList<>();
    private Cliente cl = new Cliente();
    private ClienteData clData = new ClienteData();
    private ArrayList<Producto> productos=new ArrayList<>();
    

    public RegistrarVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(MenuPrincipal.Opciones);
        txtFecha.setText(fechaActual());
        cargarEmpleado(this.usuario2);
        cargarProductos();
    }

    public void limpiarTabla() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void modeloTabla(){
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col == 0);
            }
        };
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Importe");
        modelo.setRowCount(1);
        tbVentas.setModel(modelo);
        tbVentas.setFont(new java.awt.Font("Times New Roman", 1, 14));
        ModelarTabla mt=new ModelarTabla();
        mt.modelaVent(tbVentas);        
    }
    
    public void cargarProductos() {
        generarNroFac();
                
        modeloTabla();
        
        productos=pDat.listarProducto();
        
        tbVentas.setCellSelectionEnabled(true);
        
        tbVentas.getInputMap(javax.swing.JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextRow");
        
        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int selecion = e.getFirstRow();
                int controla = 0;

                if (e.getType() == TableModelEvent.UPDATE) {
                    
                    String codigo = modelo.getValueAt(selecion, 0).toString();
                    String[] registros = new String[6];
                    
                    for (Producto rs : productos) {
                        if (rs.getCodigo().equals(codigo)) {
                            registros[0] = rs.getCodigo();
                            registros[1] = rs.getProducto()+" "+rs.getMarca();
                            int canti = Integer.parseInt(JOptionPane.showInputDialog(tbVentas, "Ingrese Cantidad para \n " + rs.getProducto()));
                            registros[2] = canti + "";
                            registros[3] = rs.getPrecioGravamen()+"";
                            if(canti==1){
                                registros[4] = rs.getPrecioGravamen()+"";
                            }else{
                                registros[4] =(canti * rs.getPrecioGravamen()) + "";
                            }
                            if(controldecambio>-1){
                                modelo.insertRow(selecion, registros);
                                modelo.removeRow(cambio+1);
                                cambio=-1;
                                controldecambio=-1;
                            }else{
                                modelo.removeRow(selecion);
                                modelo.addRow(registros);
                                int y = modelo.getRowCount();
                                modelo.setRowCount(y + 1);
                            }
                            controla++;
                        }
                    }
                    if (controla == 0) {
                        JOptionPane.showMessageDialog(tbVentas, "Producto no existe o codigo incorrecto");
                    }else{
                        calcular();
                    }                    
                }
            }
        });
    }
    
    public void calcular(){//Calculamos el importe
        if(modelo.getRowCount()>-1){
            String imp;
            int a = modelo.getRowCount() - 1;
            double importes = 0;

            for (int i = 0; i < a; i++) {
                imp = modelo.getValueAt(i, 4).toString();
                importes =Math.round(Math.nextUp(importes + (Double.parseDouble(imp))));
            }
            
            txtSubTotal.setText(importes + "");
            if ((!txtInteres.getText().isEmpty())&& importes>0) {
                double inter = Double.parseDouble(txtInteres.getText());
                double parcial = importes * inter / 100;
                importes =Math.ceil(importes + parcial);
            }
            if ((!txtDescuento.getText().isEmpty())&& importes>0) {
                double des = Double.parseDouble(txtDescuento.getText());
                double desPar =Math.ceil(importes * des / 100);
                importes = importes - desPar;
            }
            txtTotal.setText(importes + "");
        }
    }

    public void generarNroFac() {
        int fnum = -1;
        int numFac = 0;
        ventas = venData.listarVentas();
        for (Venta v : ventas) {
            fnum = v.getNro_Factura();
            if (fnum < 0) {
                numFac = 1000000;
                NroFac.setText(numFac + "");
            } else {
                numFac = fnum + 1;
                NroFac.setText(numFac + "");
            }
        }
    }

    public void cargarEmpleado(String usu) {
        String us=this.usuario2;
        Usuario user=userData.buscarUsuario(us);
        cbEmpleado.addItem(user);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        botones = new javax.swing.JPanel();
        btRealizarV = new javax.swing.JButton();
        btNuevaV = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        btCambiarCantidad = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        DatosVenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClNombre = new javax.swing.JTextField();
        txtClDni = new javax.swing.JTextField();
        txtClDire = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btCargarCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCl_Id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        NroFac = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        cbEmpleado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        txtSubTotal = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Factura N°");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Fecha");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tbVentas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Precio", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tbVentas);
        if (tbVentas.getColumnModel().getColumnCount() > 0) {
            tbVentas.getColumnModel().getColumn(0).setMaxWidth(60);
            tbVentas.getColumnModel().getColumn(2).setMaxWidth(60);
            tbVentas.getColumnModel().getColumn(3).setMaxWidth(60);
            tbVentas.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("SubTotal $");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Interes Tarjeta %");

        txtInteres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInteresKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Total $");

        botones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        btRealizarV.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btRealizarV.setText("Realizar Venta");
        btRealizarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRealizarVActionPerformed(evt);
            }
        });

        btNuevaV.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btNuevaV.setText("Nueva Venta");
        btNuevaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevaVActionPerformed(evt);
            }
        });

        btSalir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btSalir.setText("SALIR");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        btCambiarCantidad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btCambiarCantidad.setForeground(new java.awt.Color(0, 0, 255));
        btCambiarCantidad.setText("Cambiar Cantidad");
        btCambiarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCambiarCantidadActionPerformed(evt);
            }
        });

        btnQuitar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(204, 0, 0));
        btnQuitar.setText("Quitar Producto");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCambiarCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRealizarV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevaV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCambiarCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRealizarV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btNuevaV)
                .addGap(10, 10, 10)
                .addComponent(btnQuitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalir)
                .addContainerGap())
        );

        DatosVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Señor(a)");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("D.N.I.");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Dirección");

        txtClNombre.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtClDni.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtClDire.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Consultar Productos");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btCargarCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCargarCliente.setForeground(new java.awt.Color(204, 0, 0));
        btCargarCliente.setText("Cargar Cliente");
        btCargarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("ID");

        txtCl_Id.setEditable(false);
        txtCl_Id.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout DatosVentaLayout = new javax.swing.GroupLayout(DatosVenta);
        DatosVenta.setLayout(DatosVentaLayout);
        DatosVentaLayout.setHorizontalGroup(
            DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosVentaLayout.createSequentialGroup()
                .addGroup(DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DatosVentaLayout.createSequentialGroup()
                        .addComponent(txtClDni, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCl_Id, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addComponent(txtClNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(txtClDire))
                .addGap(54, 54, 54)
                .addGroup(DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCargarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        DatosVentaLayout.setVerticalGroup(
            DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btCargarCliente))
                .addGap(5, 5, 5)
                .addGroup(DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(DatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClDire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("01-");

        NroFac.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        NroFac.setText("1000000");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Descuento %");

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("-Usuario-");

        txtTotal.setEditable(false);
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.0"))));
        txtTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtSubTotal.setEditable(false);
        txtSubTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.0"))));
        txtSubTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("Ingrese Interes o Descuento");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel14.setText("Nombre o Razon Social");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatosVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(39, 39, 39)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(38, 38, 38)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NroFac)
                                .addGap(25, 25, 25))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel9)
                .addGap(29, 29, 29)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(DatosVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(NroFac)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rows=tbVentas.getRowCount()-1;
        modelo.removeRow(rows);
        ListaProductos lp = new ListaProductos(null, true);
        lp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btCambiarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCambiarCantidadActionPerformed
        //Cambia la cantidad de un producto
        cambio = tbVentas.getSelectedRow();
        if(cambio>-1){
            if(modelo.getValueAt(cambio, 0)!=null){
                controldecambio=1;
                modelo.setValueAt(cambio,cambio, 3);
            }
        }
    }//GEN-LAST:event_btCambiarCantidadActionPerformed

    private void btNuevaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevaVActionPerformed
        int a = modelo.getRowCount() - 1;
        if (a >= 0) {
            LimpiarFrm.limpiarFormulario(DatosVenta);
            LimpiarFrm.limpiarFormulario(jPanel1);
            limpiarTabla();
            modelo.setRowCount(1);
            txtFecha.setText(fechaActual());
            if (control == 1) {
                generarNroFac();
            }
        } else {
            LimpiarFrm.limpiarFormulario(DatosVenta);
            LimpiarFrm.limpiarFormulario(jPanel1);
            txtFecha.setText(fechaActual());
        }
    }//GEN-LAST:event_btNuevaVActionPerformed

    private void btRealizarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRealizarVActionPerformed
        int una = modelo.getRowCount() - 1;
        modelo.removeRow(una);
        int sel = tbVentas.getRowCount();
        Venta ve = new Venta();
        Venta_Detalle vd = new Venta_Detalle();
        Producto pt = new Producto();
        if (sel > 0) {
            //Carga los datos en la tabla ventas

            if(txtCl_Id.getText().equals("")){
                cl.setId_cliente(1);
            }else{
                cl.setId_cliente(Integer.parseInt(txtCl_Id.getText()));
            }

            int numFac = Integer.parseInt(NroFac.getText());
            ve.setNro_Factura(numFac);
            ve.setFecha(txtFecha.getText());
            if (txtInteres.getText().equals("")) {
                ve.setIn_tarjeta(0);
            } else {
                float intar = Float.parseFloat(txtInteres.getText());
                ve.setIn_tarjeta(intar);
            }
            if (txtDescuento.getText().equals("")) {
                ve.setDescuento(0);
            } else {
                float desc = Float.parseFloat(txtDescuento.getText());
                ve.setDescuento(desc);
            }
            double tot = Double.parseDouble(txtTotal.getText());
            double subt = Double.parseDouble(txtSubTotal.getText());
            ve.setSub_total(subt);
            ve.setTotal(tot);
            Usuario a = userData.buscarUsuario(this.usuario2);
            ve.setId_emp(a);
            ve.setCl(cl);
            venData.cargarVenta(ve);

            //Carga los datos en la tabla detalleventas
            int count = tbVentas.getRowCount() - 1;
            for (int i = count; i >= 0; i--) {

                int can = Integer.parseInt(tbVentas.getValueAt(i, 2).toString());
                double it = Double.parseDouble(tbVentas.getValueAt(i, 4).toString());
                String codi = tbVentas.getValueAt(i, 0).toString();
                pt = pDat.buscarProducto(codi);
                vd.setNroFact(ve);
                vd.setCantFact(can);
                vd.setImpTotal(it);
                vd.setId_pro(pt);
                detalleData.cargarDetalleV(vd);

                int canRestante = pt.getCantidad() - can;
                pDat.actiualizarProductoVenta(canRestante, codi);

            }
            JOptionPane.showMessageDialog(this, "La venta se realizo con exito");
            control = 1;
            LimpiarFrm.limpiarFormulario(DatosVenta);
            LimpiarFrm.limpiarFormulario(jPanel1);
            limpiarTabla();
            modelo.setRowCount(1);
            txtFecha.setText(fechaActual());
            if (control == 1) {
                generarNroFac();
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Debe Cargar Producto(s)", "Advertencia", 0);
            if (sel<1){
                modelo.setRowCount(1);
            }
        }
    }//GEN-LAST:event_btRealizarVActionPerformed

    private void btCargarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarClienteActionPerformed
        if (txtClNombre.getText().equals("") || txtClDni.getText().equals("")
                || txtClDire.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe Completar Todos los Campos!");
        } else{
            cl=clData.buscarCliente(Integer.parseInt(txtClDni.getText()));
            
            if (cl==null){
                cl=new Cliente();
                cl.setCl_nombre(txtClNombre.getText());
                cl.setCl_dni(Integer.parseInt(txtClDni.getText()));
                cl.setCl_direccion(txtClDire.getText());
                if(clData.guardarCliente(cl)==1){
                    JOptionPane.showMessageDialog(null, "Cliente Guardado");
                    cl=clData.buscarCliente(cl.getCl_dni());
                }
            }
        }
        txtCl_Id.setText(cl.getId_cliente()+"");
    }//GEN-LAST:event_btCargarClienteActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int sel = tbVentas.getSelectedRow();
        if(sel>-1){
            if(modelo.getValueAt(sel, 0)!=null){
                int una = tbVentas.getSelectedRow();
                modelo.removeRow(una);
                calcular();
            }
            int row=modelo.getRowCount();
            if (sel<1){
                modelo.setRowCount(row);
            }
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtInteresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInteresKeyReleased
        calcular();//Calculamos el interes
    }//GEN-LAST:event_txtInteresKeyReleased

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        calcular();//Calculamos el descuento
    }//GEN-LAST:event_txtDescuentoKeyReleased

    public String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String f = formatoFecha.format(fecha);
        return f;
    }

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
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarVenta dialog = new RegistrarVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel DatosVenta;
    private javax.swing.JLabel NroFac;
    private javax.swing.JPanel botones;
    private javax.swing.JButton btCambiarCantidad;
    private javax.swing.JButton btCargarCliente;
    private javax.swing.JButton btNuevaV;
    private javax.swing.JButton btRealizarV;
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<Usuario> cbEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbVentas;
    private javax.swing.JTextField txtClDire;
    private javax.swing.JTextField txtClDni;
    private javax.swing.JTextField txtClNombre;
    private javax.swing.JTextField txtCl_Id;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtInteres;
    public static javax.swing.JFormattedTextField txtSubTotal;
    public static javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
