/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidades.HistoricoFacturas;
import Negocio.HistoricoFacturasNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author deada
 */
public class JFrameHistoricoCompras extends javax.swing.JFrame {

    private final HistoricoFacturasNegocio facturasNegocio;

    public JFrameHistoricoCompras() {
        initComponents();
        facturasNegocio = new HistoricoFacturasNegocio();
        TableModel tableModel = this.completarHistoricoModel();
        jTable_Historico.setModel(tableModel);
        
    }

    private TableModel completarHistoricoModel() {
        try {
            List<HistoricoFacturas> listaFacturas = facturasNegocio.consultarTodasLasFacturas();
            Object[] columnas = new Object[]{"Factura No", "Usuario", "Total", "Costo de Envío", "IVA", "Neto Pagado", "Fecha de la Compra"};
            Object[][] datos = new Object[listaFacturas.size()][columnas.length];
            for (int i = 0; i < listaFacturas.size(); i++) {
                datos[i][0] = listaFacturas.get(i).getCodigoFactura();
                datos[i][1] = listaFacturas.get(i).getUsuario();
                datos[i][2] = listaFacturas.get(i).getTotal();
                datos[i][3] = listaFacturas.get(i).getCostoEnvio();
                datos[i][4] = listaFacturas.get(i).getIva();
                datos[i][5] = listaFacturas.get(i).getTotalFinal();
                datos[i][6] = listaFacturas.get(i).getHoraCompra();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Historico = new javax.swing.JTable();
        jLabel_Fondo = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102, 90));

        jTable_Historico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Factura No", "Usuario", "Total", "Costo de Envío", "IVA", "Neto Pagado", "Fecha de la Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Historico);
        if (jTable_Historico.getColumnModel().getColumnCount() > 0) {
            jTable_Historico.getColumnModel().getColumn(1).setResizable(false);
            jTable_Historico.getColumnModel().getColumn(6).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 60, 1130, -1));

        jLabel_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1230px BG.png"))); // NOI18N
        getContentPane().add(jLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JFramePrincipalAdmin jfPrincipal = new JFramePrincipalAdmin();
        jfPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(JFrameHistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameHistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameHistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameHistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameHistoricoCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_Fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Historico;
    // End of variables declaration//GEN-END:variables
}
