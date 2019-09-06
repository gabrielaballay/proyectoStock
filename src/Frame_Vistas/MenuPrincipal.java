package Frame_Vistas;

import AppPackage.AnimationClass;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    public static String user;
    
    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        titulo.setSize(50, this.getExtendedState());
        //this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpIngreso = new javax.swing.JPanel();
        menuUs = new javax.swing.JLabel();
        clientes = new javax.swing.JLabel();
        borrarUser = new javax.swing.JLabel();
        opStock = new javax.swing.JLabel();
        opStockLbl = new javax.swing.JLabel();
        opVentas = new javax.swing.JLabel();
        opVentasLbl = new javax.swing.JLabel();
        opEmpleado = new javax.swing.JLabel();
        opEmpleadoLbl = new javax.swing.JLabel();
        buscar1 = new javax.swing.JLabel();
        clientes2 = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        boton1 = new org.edisoncor.gui.button.ButtonTask();
        boton2 = new org.edisoncor.gui.button.ButtonTask();
        btnVenta1 = new org.edisoncor.gui.button.ButtonTask();
        btnVenta2 = new org.edisoncor.gui.button.ButtonTask();
        empleado1 = new org.edisoncor.gui.button.ButtonTask();
        empleado2 = new org.edisoncor.gui.button.ButtonTask();
        titulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnVenta3 = new org.edisoncor.gui.button.ButtonTask();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Image/icondeveloper.png")).getImage());
        setUndecorated(true);
        setResizable(false);

        jpIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jpIngreso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jpIngreso.setForeground(new java.awt.Color(255, 255, 255));
        jpIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Menu_32px.png"))); // NOI18N
        menuUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuUs.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Menu_32px_1.png"))); // NOI18N
        menuUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUsMouseClicked(evt);
            }
        });
        jpIngreso.add(menuUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x32-clientes.png"))); // NOI18N
        clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesMouseClicked(evt);
            }
        });
        jpIngreso.add(clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 100, 40, 40));

        borrarUser.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        borrarUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrarUser.setText("<html>Buscar Usuarios<html>");
        borrarUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrarUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpIngreso.add(borrarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 70, 40, 40));

        opStock.setBackground(new java.awt.Color(255, 255, 255));
        opStock.setForeground(new java.awt.Color(255, 255, 255));
        opStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x128-almacen.png"))); // NOI18N
        opStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opStock.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                opStockMouseMoved(evt);
            }
        });
        opStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opStockMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opStockMouseExited(evt);
            }
        });
        jpIngreso.add(opStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 140, 140));

        opStockLbl.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        opStockLbl.setForeground(new java.awt.Color(204, 51, 0));
        opStockLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opStockLbl.setText("Stock");
        jpIngreso.add(opStockLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 40, -1));

        opVentas.setBackground(new java.awt.Color(255, 255, 255));
        opVentas.setForeground(new java.awt.Color(255, 255, 255));
        opVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x128-caja.png"))); // NOI18N
        opVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opVentas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                opVentasMouseMoved(evt);
            }
        });
        opVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opVentasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opVentasMouseExited(evt);
            }
        });
        jpIngreso.add(opVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 140, 140));

        opVentasLbl.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        opVentasLbl.setForeground(new java.awt.Color(204, 51, 0));
        opVentasLbl.setText("Ventas");
        jpIngreso.add(opVentasLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 50, -1));

        opEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        opEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        opEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x128-empleado.png"))); // NOI18N
        opEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                opEmpleadoMouseMoved(evt);
            }
        });
        opEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opEmpleadoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opEmpleadoMouseExited(evt);
            }
        });
        jpIngreso.add(opEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 140, 140));

        opEmpleadoLbl.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        opEmpleadoLbl.setForeground(new java.awt.Color(204, 51, 0));
        opEmpleadoLbl.setText("Empleados");
        jpIngreso.add(opEmpleadoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 80, -1));

        buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x32-buscar.png"))); // NOI18N
        buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscar1MouseClicked(evt);
            }
        });
        jpIngreso.add(buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 40, 40, 40));

        clientes2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        clientes2.setText("Clientes");
        clientes2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpIngreso.add(clientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 134, -1, 20));

        Opciones.setBackground(new java.awt.Color(255, 255, 255));
        Opciones.setForeground(new java.awt.Color(255, 255, 255));
        Opciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-carrito.png"))); // NOI18N
        boton1.setText("Cargar");
        boton1.setDescription("Stock");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        Opciones.add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 90, 150, -1));

        boton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-editar_doc.png"))); // NOI18N
        boton2.setText("Administrar");
        boton2.setDescription("Stock");
        boton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton2MouseClicked(evt);
            }
        });
        Opciones.add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 170, 150, -1));

        btnVenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-caja.png"))); // NOI18N
        btnVenta1.setText("Registrar");
        btnVenta1.setDescription("Ventas");
        btnVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVenta1MouseClicked(evt);
            }
        });
        Opciones.add(btnVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 280, 150, -1));

        btnVenta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-listar.png"))); // NOI18N
        btnVenta2.setText("Listado");
        btnVenta2.setDescription("Ventas");
        btnVenta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVenta2MouseClicked(evt);
            }
        });
        Opciones.add(btnVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 360, 150, -1));

        empleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-empleado.png"))); // NOI18N
        empleado1.setText("Cargar");
        empleado1.setDescription("Empleado");
        empleado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empleado1MouseClicked(evt);
            }
        });
        Opciones.add(empleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 460, 150, -1));

        empleado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-clientes.png"))); // NOI18N
        empleado2.setText("Administrar");
        empleado2.setDescription("Empleados");
        empleado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empleado2MouseClicked(evt);
            }
        });
        Opciones.add(empleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 540, 150, -1));

        titulo.setBackground(new java.awt.Color(204, 204, 255));
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setPreferredSize(new java.awt.Dimension(1070, 53));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Control de Stock");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Multiply_32px.png"))); // NOI18N
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tituloLayout = new javax.swing.GroupLayout(titulo);
        titulo.setLayout(tituloLayout);
        tituloLayout.setHorizontalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap())
        );
        tituloLayout.setVerticalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Opciones.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        btnVenta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/x26-listar.png"))); // NOI18N
        btnVenta3.setText("Ventas por");
        btnVenta3.setToolTipText("");
        btnVenta3.setDescription("Categoria");
        btnVenta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVenta3MouseClicked(evt);
            }
        });
        Opciones.add(btnVenta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 440, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsMouseClicked
        controlUsuario();
    }//GEN-LAST:event_menuUsMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.setState(MenuPrincipal.ICONIFIED);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        int con = JOptionPane.YES_NO_OPTION;
        int res = JOptionPane.showConfirmDialog(null, "Desea Salir?", "SALIR", con);
        if (res == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void opStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opStockMouseClicked
        if (btnVenta1.getX() == 30) {
            botonesVentas();
        } else if (empleado1.getX() == 30) {
            botonesEmpleados();
        }
        botonesStock();
    }//GEN-LAST:event_opStockMouseClicked

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        botonesStock();
        CargarStock cs = new CargarStock(this, true);
        cs.setVisible(true);
    }//GEN-LAST:event_boton1ActionPerformed

    private void opVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opVentasMouseClicked
        if (boton1.getX() == 30) {
            botonesStock();
        } else if (empleado1.getX() == 30) {
            botonesEmpleados();
        }
        botonesVentas();
    }//GEN-LAST:event_opVentasMouseClicked

    private void opEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opEmpleadoMouseClicked
        if (btnVenta1.getX() == 30) {
            botonesVentas();
        } else if (boton1.getX() == 30) {
            botonesStock();
        }
        botonesEmpleados();
    }//GEN-LAST:event_opEmpleadoMouseClicked

    private void boton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseClicked
        botonesStock();
        AdministrarStock as = new AdministrarStock(this, true);
        as.setVisible(true);
    }//GEN-LAST:event_boton2MouseClicked

    private void btnVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenta1MouseClicked
        String us2=this.user;
        //JOptionPane.showMessageDialog(null, us2+"MenuPrincipal");
        RegistrarVenta.usuario2=us2;
        botonesVentas();
        RegistrarVenta rv = new RegistrarVenta(this, true);
        rv.setVisible(true);
    }//GEN-LAST:event_btnVenta1MouseClicked

    private void empleado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleado1MouseClicked
        botonesEmpleados();
        CargarEmpleado ce = new CargarEmpleado(this, true);
        ce.setVisible(true);
    }//GEN-LAST:event_empleado1MouseClicked

    private void empleado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleado2MouseClicked
        botonesEmpleados();
        AdministrarEmpleado ae = new AdministrarEmpleado(this, true);
        ae.setVisible(true);
    }//GEN-LAST:event_empleado2MouseClicked

    private void btnVenta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenta2MouseClicked
        botonesVentas();
        AdministrarVenta av = new AdministrarVenta(this, true);
        av.setVisible(true);
    }//GEN-LAST:event_btnVenta2MouseClicked

    private void clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMouseClicked
        CargarCliente as = new CargarCliente(this, true);
        controlUsuario();
        as.setVisible(true);

    }//GEN-LAST:event_clientesMouseClicked

    private void opStockMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opStockMouseMoved
        opStock.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
    }//GEN-LAST:event_opStockMouseMoved

    private void opStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opStockMouseExited
        opStock.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_opStockMouseExited

    private void opVentasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opVentasMouseMoved
        opVentas.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
    }//GEN-LAST:event_opVentasMouseMoved

    private void opEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opEmpleadoMouseMoved
        opEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
    }//GEN-LAST:event_opEmpleadoMouseMoved

    private void opVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opVentasMouseExited
        opVentas.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_opVentasMouseExited

    private void opEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opEmpleadoMouseExited
        opEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_opEmpleadoMouseExited

    private void buscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscar1MouseClicked
        VistaControlUsuarios vcu = new VistaControlUsuarios(this, true);
        controlUsuario();
        vcu.setVisible(true);
    }//GEN-LAST:event_buscar1MouseClicked

    private void btnVenta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenta3MouseClicked
        botonesVentas();
        ListarVentas lv = new ListarVentas(this, true);
        lv.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnVenta3MouseClicked

    public void botonesStock() {
        AnimationClass ops = new AnimationClass();
        //---->
        ops.jButtonXRight(-150, 30, 10, 5, boton1);
        ops.jButtonXRight(-150, 30, 10, 5, boton2);
        //<----
        ops.jButtonXLeft(30, -150, 10, 5, boton1);
        ops.jButtonXLeft(30, -150, 10, 5, boton2);
    }

    public void botonesVentas() {
        AnimationClass bv = new AnimationClass();
        //---->
        bv.jButtonXRight(-150, 30, 10, 5, btnVenta1);
        bv.jButtonXRight(-150, 30, 10, 5, btnVenta2);
        bv.jButtonXRight(-150, 30, 10, 5, btnVenta3);
        //<----
        bv.jButtonXLeft(30, -150, 10, 5, btnVenta1);
        bv.jButtonXLeft(30, -150, 10, 5, btnVenta2);
        bv.jButtonXLeft(30, -150, 10, 5, btnVenta3);
    }

    public void botonesEmpleados() {
        AnimationClass be = new AnimationClass();
        //---->
        be.jButtonXRight(-150, 30, 10, 5, empleado1);
        be.jButtonXRight(-150, 30, 10, 5, empleado2);
        //<----
        be.jButtonXLeft(30, -150, 10, 5, empleado1);
        be.jButtonXLeft(30, -150, 10, 5, empleado2);
    }

    public void controlUsuario() {
        //----->
        AnimationClass internet = new AnimationClass();
        internet.jLabelXRight(-40, 10, 10, 2, borrarUser);
        internet.jLabelXRight(-40, 10, 10, 2, clientes);
        internet.jLabelXRight(-40, 10, 10, 2, buscar1);
        internet.jLabelXRight(-40, 10, 10, 2, clientes2);

        //<-----
        AnimationClass internett = new AnimationClass();
        internett.jLabelXLeft(10, -40, 10, 2, borrarUser);
        internett.jLabelXLeft(10, -40, 10, 2, clientes);
        internett.jLabelXLeft(10, -40, 10, 2, buscar1);
        internett.jLabelXLeft(10, -40, 10, 2, clientes2);
    }

      
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
    private javax.swing.JLabel borrarUser;
    private org.edisoncor.gui.button.ButtonTask boton1;
    private org.edisoncor.gui.button.ButtonTask boton2;
    private org.edisoncor.gui.button.ButtonTask btnVenta1;
    private org.edisoncor.gui.button.ButtonTask btnVenta2;
    private org.edisoncor.gui.button.ButtonTask btnVenta3;
    private javax.swing.JLabel buscar1;
    private javax.swing.JLabel clientes;
    private javax.swing.JLabel clientes2;
    private org.edisoncor.gui.button.ButtonTask empleado1;
    private org.edisoncor.gui.button.ButtonTask empleado2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jpIngreso;
    public static javax.swing.JLabel menuUs;
    public static javax.swing.JLabel opEmpleado;
    public static javax.swing.JLabel opEmpleadoLbl;
    public static javax.swing.JLabel opStock;
    public static javax.swing.JLabel opStockLbl;
    private javax.swing.JLabel opVentas;
    private javax.swing.JLabel opVentasLbl;
    private javax.swing.JPanel titulo;
    // End of variables declaration//GEN-END:variables
}
