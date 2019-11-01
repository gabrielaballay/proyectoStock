package Frame_Vistas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    public static String user;
    
    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        titulo.setSize(50, this.getExtendedState());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opciones = new javax.swing.JPanel();
        titulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuStock = new javax.swing.JMenu();
        mnuCargarStock = new javax.swing.JMenuItem();
        mnuAdministrarStock = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuRegistrarVenta = new javax.swing.JMenuItem();
        mnuListaVenta = new javax.swing.JMenuItem();
        mnuVentaCategoria = new javax.swing.JMenuItem();
        mnuEmpleados = new javax.swing.JMenu();
        mnuCargarEmpleado = new javax.swing.JMenuItem();
        mnuAdministrarEmpleado = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        mnuBuscarUsuario = new javax.swing.JMenuItem();
        mnuListaCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Image/icondeveloper.png")).getImage());
        setUndecorated(true);
        setResizable(false);

        Opciones.setBackground(new java.awt.Color(255, 255, 255));
        Opciones.setForeground(new java.awt.Color(255, 255, 255));
        Opciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(204, 204, 255));
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setPreferredSize(new java.awt.Dimension(1070, 53));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Control de Stock");

        javax.swing.GroupLayout tituloLayout = new javax.swing.GroupLayout(titulo);
        titulo.setLayout(tituloLayout);
        tituloLayout.setHorizontalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jLabel2)
                .addContainerGap(660, Short.MAX_VALUE))
        );
        tituloLayout.setVerticalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Opciones.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 50));

        mnuArchivo.setText("Archivo");
        mnuArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuArchivo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mnuArchivo.setMargin(new java.awt.Insets(2, 10, 2, 10));

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem1.setText("Minimizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuArchivo.add(jMenuItem1);

        mnuSalir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalir);

        jMenuBar1.add(mnuArchivo);

        mnuStock.setText("Stock");
        mnuStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuStock.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mnuStock.setMargin(new java.awt.Insets(2, 10, 2, 10));

        mnuCargarStock.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuCargarStock.setText("Cargar Stock");
        mnuCargarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCargarStockActionPerformed(evt);
            }
        });
        mnuStock.add(mnuCargarStock);

        mnuAdministrarStock.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuAdministrarStock.setText("Administrar Stock");
        mnuAdministrarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministrarStockActionPerformed(evt);
            }
        });
        mnuStock.add(mnuAdministrarStock);

        jMenuBar1.add(mnuStock);

        mnuVentas.setText("Ventas");
        mnuVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuVentas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mnuVentas.setMargin(new java.awt.Insets(2, 10, 2, 10));

        mnuRegistrarVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuRegistrarVenta.setText("Registrar Venta");
        mnuRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuRegistrarVenta);

        mnuListaVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuListaVenta.setText("Listado de Venta");
        mnuListaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuListaVenta);

        mnuVentaCategoria.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuVentaCategoria.setText("Ventas X Categoria");
        mnuVentaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentaCategoriaActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuVentaCategoria);

        jMenuBar1.add(mnuVentas);

        mnuEmpleados.setText("Empleados");
        mnuEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuEmpleados.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mnuEmpleados.setMargin(new java.awt.Insets(2, 10, 2, 10));

        mnuCargarEmpleado.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuCargarEmpleado.setText("Cargar Empleado");
        mnuCargarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCargarEmpleadoActionPerformed(evt);
            }
        });
        mnuEmpleados.add(mnuCargarEmpleado);

        mnuAdministrarEmpleado.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuAdministrarEmpleado.setText("Administrar");
        mnuAdministrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministrarEmpleadoActionPerformed(evt);
            }
        });
        mnuEmpleados.add(mnuAdministrarEmpleado);

        jMenuBar1.add(mnuEmpleados);

        mnuHerramientas.setText("Herramientas");
        mnuHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuHerramientas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mnuHerramientas.setMargin(new java.awt.Insets(2, 10, 2, 10));

        mnuBuscarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuBuscarUsuario.setText("Buscar Usuarios");
        mnuBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBuscarUsuarioActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuBuscarUsuario);

        mnuListaCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mnuListaCliente.setText("Listado de Clientes");
        mnuListaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaClienteActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuListaCliente);

        jMenuBar1.add(mnuHerramientas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//****************************NUEVO MENU*************************************//
    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        int con = JOptionPane.YES_NO_OPTION;
        int res = JOptionPane.showConfirmDialog(null, "Desea Salir?", "SALIR", con);
        if (res == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setState(MenuPrincipal.ICONIFIED);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuCargarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCargarStockActionPerformed
        CargarStock cs = new CargarStock(this, true);
        cs.setVisible(true);
    }//GEN-LAST:event_mnuCargarStockActionPerformed

    private void mnuAdministrarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministrarStockActionPerformed
        AdministrarStock as = new AdministrarStock(this, true);
        as.setVisible(true);
    }//GEN-LAST:event_mnuAdministrarStockActionPerformed

    private void mnuRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarVentaActionPerformed
        String us2=this.user;
        RegistrarVenta.usuario2=us2;        
        RegistrarVenta rv = new RegistrarVenta(this, true);
        rv.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarVentaActionPerformed

    private void mnuListaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaVentaActionPerformed
        AdministrarVenta av = new AdministrarVenta(this, true);
        av.setVisible(true);
    }//GEN-LAST:event_mnuListaVentaActionPerformed

    private void mnuVentaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentaCategoriaActionPerformed
        ListarVentas lv = new ListarVentas(this, true);
        lv.setVisible(true);        
    }//GEN-LAST:event_mnuVentaCategoriaActionPerformed

    private void mnuCargarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCargarEmpleadoActionPerformed
        CargarEmpleado ce = new CargarEmpleado(this, true);
        ce.setVisible(true);
    }//GEN-LAST:event_mnuCargarEmpleadoActionPerformed

    private void mnuAdministrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministrarEmpleadoActionPerformed
        AdministrarEmpleado ae = new AdministrarEmpleado(this, true);
        ae.setVisible(true);
    }//GEN-LAST:event_mnuAdministrarEmpleadoActionPerformed

    private void mnuBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBuscarUsuarioActionPerformed
        VistaControlUsuarios vcu = new VistaControlUsuarios(this, true);        
        vcu.setVisible(true);
    }//GEN-LAST:event_mnuBuscarUsuarioActionPerformed

    private void mnuListaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaClienteActionPerformed
        CargarCliente as = new CargarCliente(this, true);        
        as.setVisible(true);
    }//GEN-LAST:event_mnuListaClienteActionPerformed
      
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Opciones;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mnuAdministrarEmpleado;
    private javax.swing.JMenuItem mnuAdministrarStock;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem mnuBuscarUsuario;
    private javax.swing.JMenuItem mnuCargarEmpleado;
    private javax.swing.JMenuItem mnuCargarStock;
    private javax.swing.JMenu mnuEmpleados;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenuItem mnuListaCliente;
    private javax.swing.JMenuItem mnuListaVenta;
    private javax.swing.JMenuItem mnuRegistrarVenta;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuStock;
    private javax.swing.JMenuItem mnuVentaCategoria;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JPanel titulo;
    // End of variables declaration//GEN-END:variables
}
