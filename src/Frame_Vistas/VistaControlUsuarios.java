package Frame_Vistas;

import Clases_Modelos.LimpiarFrm;
import Clases_Modelos.ModelarTabla;
import Clases_Modelos.Usuario;
import Clases_Modelos.UsuarioData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaControlUsuarios extends javax.swing.JDialog {
    private int denis;
    private UsuarioData ud=new UsuarioData();
    private DefaultTableModel modelo=new DefaultTableModel();
    private ArrayList<Usuario> usuarios=new ArrayList<>();
    
    public VistaControlUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(MenuPrincipal.Opciones);
        colTabla();
        cargarTabla();
    }

    public void colTabla(){
        ArrayList<Object> col=new ArrayList<>();
        col.add("DNI");
        col.add("Apellido y Nombre");
        col.add("Usuario");
        for(Object i:col){
            modelo.addColumn(i);
        }
        tbUsuario.setModel(modelo);
        ModelarTabla mt=new ModelarTabla();
        mt.modelaUser(tbUsuario);
    }
    public void limpiarTabla(){
        int a =modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
    }
    public void cargarTabla(){
        usuarios=ud.listarUsuario();
        limpiarTabla();
        for (Usuario u:usuarios){
            modelo.addRow(new Object[]{u.getDni(),u.getNombres(),u.getUsuario()});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpusers = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtdnis = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btEliminar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jpusers.setBackground(new java.awt.Color(204, 255, 204));
        jpusers.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control de Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel3.setText("DNI  ");

        txtnombres.setBorder(null);

        txtdnis.setBorder(null);

        txtNombreUsuario.setBorder(null);

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar_norm.png"))); // NOI18N
        btEliminar.setBorder(null);
        btEliminar.setBorderPainted(false);
        btEliminar.setContentAreaFilled(false);
        btEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar_press.png"))); // NOI18N
        btEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar_roll.png"))); // NOI18N
        btEliminar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar_roll.png"))); // NOI18N
        btEliminar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar_roll.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
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

        jLabel7.setText("Apellido y Nombre");

        jLabel8.setText("Nombre de Usuario");

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        javax.swing.GroupLayout jpusersLayout = new javax.swing.GroupLayout(jpusers);
        jpusers.setLayout(jpusersLayout);
        jpusersLayout.setHorizontalGroup(
            jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpusersLayout.createSequentialGroup()
                .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpusersLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpusersLayout.createSequentialGroup()
                        .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdnis, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpusersLayout.createSequentialGroup()
                                .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btEliminar)
                                    .addComponent(btSalir))))))
                .addGap(10, 10, 10))
        );
        jpusersLayout.setVerticalGroup(
            jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpusersLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpusersLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdnis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpusersLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btSalir))
                    .addGroup(jpusersLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jpusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int confirma=JOptionPane.showConfirmDialog(this, "Esta seguro de Eliminar este Usuario?","ATENCION",0);
        if(confirma==0){
            ud.eliminarUsuario(denis);
            JOptionPane.showMessageDialog(this, "El Usuario fue Eliminado","Atencion",1);
            cargarTabla();
            LimpiarFrm.limpiarFormulario(jpusers);
        }
        
    }//GEN-LAST:event_btEliminarActionPerformed

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        int selec=tbUsuario.getSelectedRow();
        txtdnis.setText(tbUsuario.getValueAt(selec, 0).toString());
        txtNombreUsuario.setText(tbUsuario.getValueAt(selec, 1).toString());
        txtnombres.setText(tbUsuario.getValueAt(selec, 2).toString());
        denis=Integer.parseInt(tbUsuario.getValueAt(selec, 0).toString());
    }//GEN-LAST:event_tbUsuarioMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VistaControlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaControlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaControlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaControlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaControlUsuarios dialog = new VistaControlUsuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jpusers;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtdnis;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables
}
