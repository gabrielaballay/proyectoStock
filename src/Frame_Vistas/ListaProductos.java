package Frame_Vistas;

import Clases_Modelos.Producto;
import Clases_Modelos.ProductoData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListaProductos extends javax.swing.JDialog {
    TableRowSorter rowSorter; 
    int IDBUSQUEDA=0;
    private DefaultTableModel mod = new DefaultTableModel();
    private ProductoData pData;
    private ArrayList<Producto> productos = new ArrayList<>();

    public ListaProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pData = new ProductoData();
        this.setLocationRelativeTo(MenuPrincipal.Opciones);
        titulosTabla();
        cargarTabla();
    }

    public void titulosTabla() {
        ArrayList<Object> col = new ArrayList<>();

        col.add("Codigo");
        col.add("Producto");
        col.add("Cantidad");
        col.add("Precio");

        for (Object i : col) {
            mod.addColumn(i);
        }

        tbProductos.setModel(mod);
        modela(tbProductos);
    }

    public void limpiarTabla() {

        int a = mod.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            mod.removeRow(i);
        }

    }

    public void cargarTabla() {
        productos = pData.listarProducto();
        limpiarTabla();

        for (Producto p : productos) {
            mod.addRow(new Object[]{p.getCodigo(), p.getProducto(), p.getCantidad(), +p.getPrecioGravamen()});
        }
        
        rowSorter=new TableRowSorter(mod);
        tbProductos.setRowSorter(rowSorter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnCargarPro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscarNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProductos);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x32-buscar.png"))); // NOI18N
        jLabel1.setText("Buscar Producto");

        buscar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 204), new java.awt.Color(153, 255, 153)));
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnCargarPro.setText("Cargar Producto");
        btnCargarPro.setName(""); // NOI18N
        btnCargarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarProActionPerformed(evt);
            }
        });

        jLabel2.setText("Por Codigo");

        jLabel3.setText("Por Nombre");

        buscarNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 204), new java.awt.Color(153, 255, 153)));
        buscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarNombreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargarPro)
                .addGap(90, 90, 90)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(buscarNombre)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnCargarPro))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) RegistrarVenta.tbVentas.getModel();
        int y = model.getRowCount();
        model.setRowCount(y + 1);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        rowSorter.setRowFilter(RowFilter.regexFilter(buscar.getText().toUpperCase(), IDBUSQUEDA));
    }//GEN-LAST:event_buscarKeyReleased

    private void btnCargarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarProActionPerformed
        double suma;
        double subTotal=0;
        double total=0;
        int cel = tbProductos.getSelectedRow();
        String cantidadHay = JOptionPane.showInputDialog("Ingrese Cantidad del Producto");
        if (cantidadHay != null && !cantidadHay.equalsIgnoreCase("") && cel >= 0) {
            int can = Integer.parseInt(cantidadHay);
            DefaultTableModel model = (DefaultTableModel) RegistrarVenta.tbVentas.getModel();

            String pre = tbProductos.getValueAt(cel, 3).toString();
            suma = Double.parseDouble(pre);
            suma = (suma * can);

            String[] datos = new String[5];
            datos[0] = tbProductos.getValueAt(cel, 0).toString();
            datos[1] = tbProductos.getValueAt(cel, 1).toString();
            datos[2] = can + "";
            datos[3] = pre;
            datos[4] = suma + "";
            model.addRow(datos);
            if(!RegistrarVenta.txtSubTotal.getText().isEmpty()){
                subTotal=Double.parseDouble(RegistrarVenta.txtSubTotal.getText());
                total=Double.parseDouble(RegistrarVenta.txtTotal.getText());
            }
            RegistrarVenta.txtSubTotal.setText((subTotal+suma) + "");
            RegistrarVenta.txtTotal.setText((total+suma) + "");
        }
    }//GEN-LAST:event_btnCargarProActionPerformed

    private void buscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarNombreKeyReleased
        rowSorter.setRowFilter(RowFilter.regexFilter(buscarNombre.getText().toString(), 1));
    }//GEN-LAST:event_buscarNombreKeyReleased

    public void modela(JTable tabla) {
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(90);
            tabla.getColumnModel().getColumn(1).setMaxWidth(220);
            tabla.getColumnModel().getColumn(2).setMaxWidth(60);
            tabla.getColumnModel().getColumn(3).setMaxWidth(60);
        }

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
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaProductos dialog = new ListaProductos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCargarPro;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField buscarNombre;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}
