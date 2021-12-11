/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidades.Excepciones.LoginExcepcion;

import Entidades.Usuarios;
import Negocio.LoginNegocio;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Usuario
 */
public class JFrameLogin extends javax.swing.JFrame {

    private final LoginNegocio loginNegocio;

    /**
     * Creates new form JFrameLogin
     */
    public JFrameLogin() {
        initComponents();
        loginNegocio = new LoginNegocio();
    }

    private boolean validarFormulario() {
        boolean bandera = true;
        String mensaje = "";
        if (jTextField1Usuario.getText().isEmpty()) {
            mensaje += "Debe ingresar un usuario\n";
            bandera = false;

        }
        if (jPasswordField_Password.getText().isEmpty()) {
            mensaje += "Debe ingresar la contraseña";
            bandera = false;
        }
        if (jTextField1Usuario.getText().length() < 3) {
            mensaje += "El usuario debe tener al menos 3 caracteres\n";
            bandera = false;
        }
        if (jPasswordField_Password.getText().isEmpty()) {
            mensaje += "Debe ingresar un password\n";
            bandera = false;
        } else if (jPasswordField_Password.getText().length() < 5) {
            mensaje += "El password debe tener al menos 5 caracteres";
            bandera = false;
        }

        if (!mensaje.isEmpty()) {
            JOptionPane.showMessageDialog(this, mensaje, null, 0);
        }

        return bandera;

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1Usuario = new javax.swing.JLabel();
        jLabel2Password = new javax.swing.JLabel();
        jTextField1Usuario = new javax.swing.JTextField();
        jPasswordField_Password = new javax.swing.JTextField();
        jButton1Ingresar = new javax.swing.JButton();
        jButton2Salir = new javax.swing.JButton();
        jLabel_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1Usuario.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1Usuario.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1Usuario.setText("Usuario");
        getContentPane().add(jLabel1Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 171, -1, -1));

        jLabel2Password.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2Password.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2Password.setText("Password");
        getContentPane().add(jLabel2Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 241, -1, -1));
        getContentPane().add(jTextField1Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 165, 153, -1));

        jPasswordField_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField_PasswordKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordField_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 235, 153, -1));

        jButton1Ingresar.setBackground(new java.awt.Color(0, 102, 102));
        jButton1Ingresar.setText("Ingresar");
        jButton1Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 319, -1, -1));

        jButton2Salir.setBackground(new java.awt.Color(0, 102, 102));
        jButton2Salir.setText("Salir");
        jButton2Salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2SalirKeyPressed(evt);
            }
        });
        getContentPane().add(jButton2Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 319, -1, -1));

        jLabel_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/875px BG.png"))); // NOI18N
        getContentPane().add(jLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1IngresarActionPerformed
        Ingresar();
    }//GEN-LAST:event_jButton1IngresarActionPerformed

    private void jPasswordField_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_PasswordKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Ingresar();
        }
    }//GEN-LAST:event_jPasswordField_PasswordKeyPressed

    private void jButton2SalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2SalirKeyPressed
        System.exit(0);
    }//GEN-LAST:event_jButton2SalirKeyPressed
    private void Ingresar() {
        try {
            if (validarFormulario()) {
                Usuarios usuario = capturarLogin();
                Boolean validaLogin = loginNegocio.Validar(usuario);
                if (validaLogin) {
                    usuario = loginNegocio.Consultar(usuario.getUsuario());
                    JFramePrincipalAdmin jfPrincipal = new JFramePrincipalAdmin();
                    jfPrincipal.setLogin(usuario);
                    jfPrincipal.setVisible(true);
                    this.setVisible(false);
                } else {
                    throw new LoginExcepcion("Usuario o Password invalido");
                }

            }
        } catch (LoginExcepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), null, 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), null, 0);
        }
    }

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
            java.util.logging.Logger.getLogger(JFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Ingresar;
    private javax.swing.JButton jButton2Salir;
    private javax.swing.JLabel jLabel1Usuario;
    private javax.swing.JLabel jLabel2Password;
    private javax.swing.JLabel jLabel_Fondo;
    private javax.swing.JTextField jPasswordField_Password;
    private javax.swing.JTextField jTextField1Usuario;
    // End of variables declaration//GEN-END:variables

    private Usuarios capturarLogin() {
        Usuarios login = new Usuarios();
        login.setPassword(jPasswordField_Password.getText());
        login.setUsuario(jTextField1Usuario.getText());
        return login;
    }
}
