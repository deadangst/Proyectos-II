/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidades.Categoria;
import Entidades.Excepciones.CategoriaExcepcion;
import Negocio.CategoriaNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author deada
 */
public class JFrameCategorias extends javax.swing.JFrame {

    /**
     * Creates new form JFrameCategorias
     */
    private final CategoriaNegocio categoriaNegocio;

    public JFrameCategorias() {
        initComponents();
        categoriaNegocio = new CategoriaNegocio();
        TableModel tableModel = this.completarCategoriaModel();
        jTable_Categoria.setModel(tableModel);
    }

    private TableModel completarCategoriaModel() {
        try {
            List<Categoria> listaCategoria = categoriaNegocio.consultarTodasLasCategorias();
            Object[] columnas = new Object[]{"Categoria"};
            Object[][] datos = new Object[listaCategoria.size()][columnas.length];
            for (int i = 0; i < listaCategoria.size(); i++) {
                datos[i][0] = listaCategoria.get(i).getCategoria();
            }
            DefaultTableModel model = new DefaultTableModel(datos, columnas);
            return model;
        } catch (Exception ex) {
            Logger.getLogger(JFrameInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Categoria = new javax.swing.JTable();
        jLabel_NombreCategoria = new javax.swing.JLabel();
        jTextField_CategoriaProducto = new javax.swing.JTextField();
        jButton_AgreggarCategoria = new javax.swing.JButton();
        jButton_EliminatCat = new javax.swing.JButton();
        jLabel_ErrorCat = new javax.swing.JLabel();
        jLabel_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Categoria.setBackground(new java.awt.Color(0, 102, 153));
        jTable_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Categoria.setColumnSelectionAllowed(true);
        jTable_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Categoria);
        jTable_Categoria.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_Categoria.getColumnModel().getColumnCount() > 0) {
            jTable_Categoria.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 6, 750, 260));

        jLabel_NombreCategoria.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel_NombreCategoria.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_NombreCategoria.setText("Nombre Categoria del Producto");
        getContentPane().add(jLabel_NombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 314, -1, -1));

        jTextField_CategoriaProducto.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_CategoriaProducto.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jTextField_CategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 308, 417, -1));

        jButton_AgreggarCategoria.setBackground(new java.awt.Color(0, 102, 102));
        jButton_AgreggarCategoria.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton_AgreggarCategoria.setText("Agregar Categoria");
        jButton_AgreggarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgreggarCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AgreggarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 369, -1, -1));

        jButton_EliminatCat.setBackground(new java.awt.Color(0, 102, 102));
        jButton_EliminatCat.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton_EliminatCat.setLabel("Eliminar Categoria");
        jButton_EliminatCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminatCatActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_EliminatCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 369, -1, -1));

        jLabel_ErrorCat.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel_ErrorCat.setForeground(new java.awt.Color(255, 153, 0));
        jLabel_ErrorCat.setText("Error");
        getContentPane().add(jLabel_ErrorCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 426, 765, 143));

        jLabel_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1230px BG.png"))); // NOI18N
        getContentPane().add(jLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 790, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AgreggarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgreggarCategoriaActionPerformed
        if (ValidarFormularioCat()) {
            Categoria categoria = capturaCategoria();
            try {
                String insertar = categoriaNegocio.insertar(categoria);
                if (insertar.equals("Error")) {
                    throw new CategoriaExcepcion("Ocurrió un error al ingresar la Categoría");
                } else {
                    JOptionPane.showMessageDialog(this, "Categoría Creada Satisfactoriamente: " + insertar, null, 1);
                    RefrescarTabla();
                    LimpiarCampos();
                }
            } catch (CategoriaExcepcion ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), null, 2);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), null, 2);
            }
        }
    }//GEN-LAST:event_jButton_AgreggarCategoriaActionPerformed

    private void jTable_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CategoriaMouseClicked
        int seleccionada = jTable_Categoria.rowAtPoint(evt.getPoint());
        jTextField_CategoriaProducto.setText(String.valueOf(jTable_Categoria.getValueAt(seleccionada, 0)));
        
    }//GEN-LAST:event_jTable_CategoriaMouseClicked

    private void jButton_EliminatCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminatCatActionPerformed
        if (ValidarFormularioCat()) {
            Categoria categoria = capturaCategoria();
            try {
                String eliminar = categoriaNegocio.eliminar(categoria);
                if (eliminar.equals("Error")) {
                    throw new CategoriaExcepcion("Ocurrió un error al eliminar la Categoría");
                } else {
                    JOptionPane.showMessageDialog(this, "Categoría Eliminada Satisfactoriamente: " + eliminar, null, 1);
                    RefrescarTabla();
                    LimpiarCampos();
                }
            } catch (CategoriaExcepcion ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), null, 2);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), null, 2);
            }
        }
    }//GEN-LAST:event_jButton_EliminatCatActionPerformed
    private boolean ValidarFormularioCat() {
        boolean bandera = true;
        String mensaje = "";
        jLabel_ErrorCat.setVisible(false);
        jLabel_ErrorCat.setText("");

        if (jTextField_CategoriaProducto.getText().length() < 3) {
            mensaje += "* El nombre debe tener al menos 3 caracteres";
            bandera = false;
        }
        if (jTextField_CategoriaProducto.getText().length() > 30) {
            mensaje += "* El nombre debe tener menos 30 caracteres";
            bandera = false;
        }

        jLabel_ErrorCat.setVisible(true);
        jLabel_ErrorCat.setText(mensaje);
        return bandera;
    }

    private Categoria capturaCategoria() {
        Categoria categoria = new Categoria();
        categoria.setCategoria(jTextField_CategoriaProducto.getText());
        return categoria;
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
            java.util.logging.Logger.getLogger(JFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AgreggarCategoria;
    private javax.swing.JButton jButton_EliminatCat;
    private javax.swing.JLabel jLabel_ErrorCat;
    private javax.swing.JLabel jLabel_Fondo;
    private javax.swing.JLabel jLabel_NombreCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Categoria;
    private javax.swing.JTextField jTextField_CategoriaProducto;
    // End of variables declaration//GEN-END:variables

    private void RefrescarTabla() {
        TableModel tableModel = this.completarCategoriaModel();
        jTable_Categoria.setModel(tableModel);
    }

    private void LimpiarCampos() {
       jTextField_CategoriaProducto.setText(""); 
    }
}