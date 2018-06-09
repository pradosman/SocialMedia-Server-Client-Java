
package Vista;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import knockknockclient.KnockKnockClient;
/**
 *
 * @author David Prados
 */
public class GUI extends javax.swing.JFrame {

    static KnockKnockClient client;
    String cadena;

    public GUI(String cadena) {
        this.cadena = cadena;
    }
    /**
     * Creates new form Interfaz
     */
    public GUI() {
        initComponents();
        this.setLocationRelativeTo(null);/*
        // PrintStream around it to support the println/printf methods.
        PrintStream out = new PrintStream( new TextAreaOutputStream( txtConsole) );

        // redirect standard output stream to the TextAreaOutputStream
        System.setOut( out );

        // redirect standard error stream to the TextAreaOutputStream
        System.setErr( out );*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Conexion = new javax.swing.JPanel();
        ConectButton = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        cadenaConexion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextLogin = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jTextPassword = new javax.swing.JTextField();
        jLabelLogin = new javax.swing.JLabel();
        jLabelUrl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AddUser = new javax.swing.JPanel();
        textPassword = new javax.swing.JTextField();
        textDni = new javax.swing.JTextField();
        textApellido1 = new javax.swing.JTextField();
        textApellido2 = new javax.swing.JTextField();
        textLogin = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        dni = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        apellido1 = new javax.swing.JLabel();
        apellido2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Insertar = new javax.swing.JButton();
        jButtonSalir2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        jTabbedPane1.setToolTipText("");

        ConectButton.setText("Conectar");
        ConectButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConectButtonActionPerformed(evt);
            }
        });

        jButtonSalir.setText("SALIR");
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        cadenaConexion.setText("localhost");
        cadenaConexion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cadenaConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadenaConexionActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCT copia.png"))); // NOI18N

        jTextLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLoginActionPerformed(evt);
            }
        });

        jLabelPassword.setText("PASSWORD");

        jLabelLogin.setText("LOGIN");

        jLabelUrl.setText("URL");

        javax.swing.GroupLayout ConexionLayout = new javax.swing.GroupLayout(Conexion);
        Conexion.setLayout(ConexionLayout);
        ConexionLayout.setHorizontalGroup(
            ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ConexionLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConexionLayout.createSequentialGroup()
                        .addComponent(jLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConexionLayout.createSequentialGroup()
                        .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addComponent(jLabelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadenaConexion)))
                .addGap(64, 64, 64)
                .addComponent(ConectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConexionLayout.setVerticalGroup(
            ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionLayout.createSequentialGroup()
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(46, 46, 46)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadenaConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Conexion", Conexion);

        AddUser.setToolTipText("");
        AddUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });
        AddUser.add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 150, 30));

        textDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDniActionPerformed(evt);
            }
        });
        AddUser.add(textDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 130, 30));

        textApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellido1ActionPerformed(evt);
            }
        });
        AddUser.add(textApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 150, 30));

        textApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellido2ActionPerformed(evt);
            }
        });
        AddUser.add(textApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 150, 30));

        textLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLoginActionPerformed(evt);
            }
        });
        AddUser.add(textLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 150, 30));

        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        AddUser.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 150, 30));

        dni.setText("DNI");
        AddUser.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, 40));

        login.setText("LOGIN");
        AddUser.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 80, 30));

        password.setText("PASSWORD");
        AddUser.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 80, 30));

        nombre.setText("NOMBRE");
        AddUser.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 80, 40));

        apellido1.setText("APELLIDO1");
        AddUser.add(apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 80, 30));

        apellido2.setText("APELLIDO2");
        AddUser.add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCT copia.png"))); // NOI18N
        AddUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        Insertar.setText("INSERTAR");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        AddUser.add(Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 140, 40));

        jButtonSalir2.setText("SALIR");
        jButtonSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalir2ActionPerformed(evt);
            }
        });
        AddUser.add(jButtonSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 130, 60));

        jTabbedPane1.addTab("Añadir Usuario", AddUser);

        txtConsole.setColumns(20);
        txtConsole.setRows(5);
        jScrollPane5.setViewportView(txtConsole);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jScrollPane5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLoginActionPerformed

    private void cadenaConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadenaConexionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadenaConexionActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Boton para salir

        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void ConectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConectButtonActionPerformed

        client = new KnockKnockClient(cadenaConexion.getText().trim(),4444);
        String mensajeCliente = "PROTOCOLCRISTOTUBE1.0#LOGIN#" +
        jTextLogin.getText().trim() + "#" +
        jTextPassword.getText().trim();

        final SwingWorker worker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                client.clientOn(mensajeCliente);
                return null;
            }
        };
        worker.execute();

    }//GEN-LAST:event_ConectButtonActionPerformed

    private void jButtonSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalir2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalir2ActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:

        final SwingWorker worker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                insertarDatos();
                return null;
            }
        };
        worker.execute();
        
        //jLabel1.setText("User: " + client.getLogin());
    }//GEN-LAST:event_InsertarActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void textLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLoginActionPerformed

    private void textApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textApellido2ActionPerformed

    private void textApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textApellido1ActionPerformed

    private void textDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDniActionPerformed

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPasswordActionPerformed
    
    
    
    public void insertarDatos(){
            String mensajeCliente = "PROTOCOLCRISTOTUBE1.0#REGISTER#" +
                                    textDni.getText().trim() + "#" +
                                    textNombre.getText().trim() + "#" +
                                    textApellido1.getText().trim() + "#" +
                                    textApellido2.getText().trim() + "#" +
                                    textLogin.getText().trim() + "#" +
                                    textPassword.getText().trim();
            
            client.enviarMensaje(mensajeCliente);
    }
    
    public void comprobarLogin(){
            String mensajeCliente = "PROTOCOLCRISTOTUBE1.0#LOGIN#" +
                                    jTextLogin.getText().trim() + "#" +
                                    jTextPassword.getText().trim();
            
            client.enviarMensaje(mensajeCliente);
        
    }
    /*
    public void mostrarVideos(){
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.setColumnIdentifiers(new Object[]{"DNI","NOMBRE","APELLIDO1",
                                                "APELLIDO2","LOGIN","PASSWORD"});
        for(int i=0; i < usuarios.size(); i++){
            modeloTabla.addRow(new Object[]{usuarios.get(i).getDni(),
                                usuarios.get(i).getNombre(),
                                usuarios.get(i).getApellido1(),
                                usuarios.get(i).getApellido2(),
                                usuarios.get(i).getLogin(),
                                usuarios.get(i).getPassword()});
            }
        jTable1.setModel(modeloTabla);
    }
    */
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddUser;
    private javax.swing.JButton ConectButton;
    private javax.swing.JPanel Conexion;
    private javax.swing.JButton Insertar;
    private javax.swing.JLabel apellido1;
    private javax.swing.JLabel apellido2;
    private javax.swing.JTextField cadenaConexion;
    private javax.swing.JLabel dni;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSalir2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUrl;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextLogin;
    private javax.swing.JTextField jTextPassword;
    private javax.swing.JLabel login;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel password;
    private javax.swing.JTextField textApellido1;
    private javax.swing.JTextField textApellido2;
    private javax.swing.JTextField textDni;
    private javax.swing.JTextField textLogin;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables

    
    
    /*
    public void mostrarTabla( JTable jTable1) throws ClassNotFoundException, SQLException{
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.setColumnIdentifiers(new Object[]{"DNI","NOMBRE","APELLIDO1",
                                                "APELLIDO2","LOGIN","PASSWORD"});
        for(int i=0; i < usuarios.size(); i++){
            modeloTabla.addRow(new Object[]{usuarios.get(i).getDni(),
                                usuarios.get(i).getNombre(),
                                usuarios.get(i).getApellido1(),
                                usuarios.get(i).getApellido2(),
                                usuarios.get(i).getLogin(),
                                usuarios.get(i).getPassword()});
            }
        jTable1.setModel(modeloTabla);
               
    }
*/
}
