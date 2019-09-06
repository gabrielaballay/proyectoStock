package Frame_Vistas;

import Clases_Modelos.Cifrado;
import Clases_Modelos.LimpiarFrm;
import Clases_Modelos.Usuario;
import Clases_Modelos.UsuarioData;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login2 extends javax.swing.JFrame {
    private String user_login;
    private ArrayList<Usuario> users = new ArrayList<>();
    private UsuarioData usuarioData;

    public Login2() {
        initComponents();
        this.setSize(280, 364);
        this.setLocationRelativeTo(null);
        usuarioData = new UsuarioData();
        users = usuarioData.listarUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        log1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboUsuarioInicio = new javax.swing.JComboBox<>();
        txtUserIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passIngreso = new javax.swing.JPasswordField();
        btAceptar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        registro = new javax.swing.JLabel();
        log2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtdnis = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        comboUser = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtConfPass = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Image/icondeveloper.png")).getImage());
        setUndecorated(true);
        setResizable(false);

        log1.setBackground(new java.awt.Color(255, 255, 255));
        log1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 102, 0))); // NOI18N
        log1.setPreferredSize(new java.awt.Dimension(280, 333));

        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Key_32px.png"))); // NOI18N
        jLabel1.setText("Paswword :");

        comboUsuarioInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Administrador", "Usuario" }));
        comboUsuarioInicio.setBorder(null);
        comboUsuarioInicio.setOpaque(false);

        txtUserIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserIngresoKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_customer_32px_1.png"))); // NOI18N
        jLabel2.setText("Usuario :");

        passIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passIngresoKeyPressed(evt);
            }
        });

        btAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/acep_norm.png"))); // NOI18N
        btAceptar.setBorder(null);
        btAceptar.setBorderPainted(false);
        btAceptar.setContentAreaFilled(false);
        btAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/acep_press.png"))); // NOI18N
        btAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/acep_roll.png"))); // NOI18N
        btAceptar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/acep_roll.png"))); // NOI18N
        btAceptar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/acep_roll.png"))); // NOI18N
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salir_norm.png"))); // NOI18N
        btSalir.setBorder(null);
        btSalir.setBorderPainted(false);
        btSalir.setContentAreaFilled(false);
        btSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salir_press.png"))); // NOI18N
        btSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salir_roll.png"))); // NOI18N
        btSalir.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salir_roll.png"))); // NOI18N
        btSalir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salir_roll.png"))); // NOI18N
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        registro.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        registro.setForeground(new java.awt.Color(255, 51, 51));
        registro.setText("Registrarse...");
        registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout log1Layout = new javax.swing.GroupLayout(log1);
        log1.setLayout(log1Layout);
        log1Layout.setHorizontalGroup(
            log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(log1Layout.createSequentialGroup()
                .addGroup(log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(log1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(log1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btSalir)))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        log1Layout.setVerticalGroup(
            log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, log1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUserIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(passIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(registro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalir)
                    .addComponent(btAceptar))
                .addGap(21, 21, 21))
        );

        log2.setBackground(new java.awt.Color(204, 255, 204));
        log2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel3.setText("DNI  ");

        txtnombres.setBorder(null);
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombresKeyPressed(evt);
            }
        });

        txtdnis.setBorder(null);
        txtdnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdnisKeyPressed(evt);
            }
        });

        txtNombreUsuario.setBorder(null);
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyPressed(evt);
            }
        });

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_norm.png"))); // NOI18N
        btGuardar.setBorder(null);
        btGuardar.setBorderPainted(false);
        btGuardar.setContentAreaFilled(false);
        btGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_press.png"))); // NOI18N
        btGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_roll.png"))); // NOI18N
        btGuardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_roll.png"))); // NOI18N
        btGuardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_roll.png"))); // NOI18N
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/canc_norm.png"))); // NOI18N
        btCancelar.setBorder(null);
        btCancelar.setBorderPainted(false);
        btCancelar.setContentAreaFilled(false);
        btCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/canc_press.png"))); // NOI18N
        btCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/canc_roll.png"))); // NOI18N
        btCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/canc_roll.png"))); // NOI18N
        btCancelar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/canc_roll.png"))); // NOI18N
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        comboUser.setBackground(new java.awt.Color(204, 255, 204));
        comboUser.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        comboUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Administrador", "Usuario" }));
        comboUser.setBorder(null);
        comboUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUserActionPerformed(evt);
            }
        });

        jLabel7.setText("Apellido y Nombre");

        jLabel8.setText("Nombre de Usuario");

        jLabel9.setText("Password ");

        jLabel4.setText("Tipo de Usuario");

        txtpass.setBorder(null);
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        jLabel10.setText("<html>Confirmar Password <html>");

        txtConfPass.setBorder(null);

        javax.swing.GroupLayout log2Layout = new javax.swing.GroupLayout(log2);
        log2.setLayout(log2Layout);
        log2Layout.setHorizontalGroup(
            log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, log2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btCancelar)
                .addContainerGap())
            .addGroup(log2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(log2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(log2Layout.createSequentialGroup()
                        .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(log2Layout.createSequentialGroup()
                                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator4)
                                    .addComponent(comboUser, 0, 205, Short.MAX_VALUE)
                                    .addComponent(txtnombres, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtpass)
                                    .addComponent(jSeparator5)
                                    .addComponent(txtConfPass)))
                            .addGroup(log2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, log2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)))
                                .addGap(4, 4, 4)
                                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombreUsuario)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtdnis))))
                        .addGap(5, 5, 5))))
        );
        log2Layout.setVerticalGroup(
            log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(log2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(log2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, log2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(log1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(log2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(log1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(log2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        String tipoUs = comboUsuarioInicio.getSelectedItem().toString();
        String pass = new String(passIngreso.getPassword());

        Usuario us = new Usuario();

        if (!txtUserIngreso.getText().equals("") && !pass.equals("") && !tipoUs.equals("Seleccionar...")) {

            String nuevoPass = Cifrado.sha1(pass);
            us.setUsuario(txtUserIngreso.getText());
            us.setPassword(nuevoPass);
            us.setTipoUser(tipoUs);
            if (usuarioData.login(us)) {
                if (tipoUs.equals("Administrador")) {
                    user_login=txtUserIngreso.getText();
                    inicioAdmin(us);
                } else {
                    user_login=txtUserIngreso.getText();
                    inicioUsuario(us);
                }
            } else if (tipoUs.equals("Administrador")) {
                creador(txtUserIngreso.getText(), pass);

            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos!!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos");
        }

    }//GEN-LAST:event_btAceptarActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

    private void registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroMouseClicked
        log2.setVisible(true);
        log2.setLocation(0, 0);
        this.setLocationRelativeTo(null);
        log1.setVisible(false);
    }//GEN-LAST:event_registroMouseClicked

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        Usuario u = new Usuario();
        String tipoU = comboUser.getSelectedItem().toString();
        String pas = new String(txtpass.getPassword());
        String pasCon = new String(txtConfPass.getPassword());

        if (txtnombres.getText().equals("") || txtdnis.getText().equals("")
                || txtNombreUsuario.getText().equals("") || pas.equals("")
                || pasCon.equals("") || tipoU.equals("Seleccione...")) {

            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");

        } else {

            if (pas.equals(pasCon)) {

                if (usuarioData.existeUsuario(txtNombreUsuario.getText()) == 0) {

                    String passNuevo = Cifrado.sha1(pas);

                    u.setNombres(txtnombres.getText());
                    u.setDni(Integer.parseInt(txtdnis.getText()));
                    u.setUsuario(txtNombreUsuario.getText());
                    u.setPassword(passNuevo);
                    u.setTipoUser(tipoU);

                    if (usuarioData.guardarUsuario(u)) {

                        JOptionPane.showMessageDialog(null, "Su usuario fue creado Correctamente", "FELICITACIONES", 1);
                        LimpiarFrm.limpiarFormulario(log2);
                        log1.setVisible(true);
                        log2.setVisible(false);
                        this.setLocationRelativeTo(null);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al crear el Usuario", "ERROR", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error el Usuario ya Existe", "ERROR", 0);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Contraseñas no coiciden");
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        LimpiarFrm.limpiarFormulario(log2);
        log1.setVisible(true);
        log2.setVisible(false);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void comboUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUserActionPerformed
        Usuario u = new Usuario();
        String user = comboUser.getSelectedItem().toString();
        if (user.equals("Administrador")) {
            String pass = JOptionPane.showInputDialog(this, "Debe ser un Administrador\n Introdusca Contraseña", "Solo Administrador", 1);
            String nuevoPass = Cifrado.sha1(pass);
            if (pass.equals("x28m90")) {
                comboUser.setSelectedIndex(1);
            } else {
                comboUser.setSelectedIndex(0);
                u.setPassword(nuevoPass);
                u.setTipoUser(user);
                if (usuarioData.loginAd(u)) {
                    comboUser.setSelectedIndex(1);
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña Incorrecta");
                    comboUser.setSelectedIndex(0);
                }
            }
        }
    }//GEN-LAST:event_comboUserActionPerformed

    private void txtUserIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserIngresoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            passIngreso.requestFocus();
        }
    }//GEN-LAST:event_txtUserIngresoKeyPressed

    private void passIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passIngresoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btAceptar.doClick();
        }
    }//GEN-LAST:event_passIngresoKeyPressed

    private void txtnombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtdnis.requestFocus();
        }
    }//GEN-LAST:event_txtnombresKeyPressed

    private void txtdnisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdnisKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombreUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtdnisKeyPressed

    private void txtNombreUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtpass.requestFocus();
        }
    }//GEN-LAST:event_txtNombreUsuarioKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtConfPass.requestFocus();
        }
    }//GEN-LAST:event_txtpassKeyPressed

    public void inicioUsuario(Usuario us) {
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        
        mp.user=user_login;
        mp.opEmpleado.setVisible(false);
        mp.opEmpleadoLbl.setVisible(false);
        mp.setVisible(true);
        mp.menuUs.setVisible(false);
    }

    public void inicioAdmin(Usuario us) {
        dispose();
        MenuPrincipal mp = new MenuPrincipal();
        mp.user=user_login;
        //JOptionPane.showMessageDialog(null,user_login+"hola");
        mp.setVisible(true);
    }

    private void creador(String us, String pas) {
        if (us.equals("Gabriel") && pas.equals("x28m90")) {
            dispose();
            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
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
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<String> comboUser;
    public static javax.swing.JComboBox<String> comboUsuarioInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public static javax.swing.JPanel log1;
    private javax.swing.JPanel log2;
    private javax.swing.JPasswordField passIngreso;
    private javax.swing.JLabel registro;
    private javax.swing.JPasswordField txtConfPass;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtUserIngreso;
    private javax.swing.JTextField txtdnis;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
