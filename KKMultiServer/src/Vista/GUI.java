
package Vista;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import kkmultiserver.KKMultiServer;
/**
 *
 * @author David Prados
 */
public class GUI extends javax.swing.JFrame {
    
    private KKMultiServer server = new KKMultiServer();


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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Conexion = new javax.swing.JPanel();
        ConectButton = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoCT copia.png"))); // NOI18N

        javax.swing.GroupLayout ConexionLayout = new javax.swing.GroupLayout(Conexion);
        Conexion.setLayout(ConexionLayout);
        ConexionLayout.setHorizontalGroup(
            ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionLayout.createSequentialGroup()
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(ConectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ConexionLayout.setVerticalGroup(
            ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionLayout.createSequentialGroup()
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(ConectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        jTabbedPane1.addTab("Conexion", Conexion);

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

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Boton para salir

        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void ConectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConectButtonActionPerformed
        final SwingWorker worker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                server.serverOn();
                return null;
            }
        };
        worker.execute();
    }//GEN-LAST:event_ConectButtonActionPerformed

    
    
    
   
    
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
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables
}
