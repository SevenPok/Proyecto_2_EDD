/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo.Viaje;

import Entidad.Cliente;
import Entidad.Conductor;
import Entidad.Ruta;
import Entidad.Vehiculo;
import Entidad.Viaje;
import Estructura.TablaHash.TablaHash;
import Estructura.BlockChain.ListaSimpleB;
import Estructura.ListaSimple.ListaSimple;
import java.sql.Timestamp;


/**
 *
 * @author Co
 */
public class MenuViaje extends javax.swing.JFrame {
    TablaHash tabla = TablaHash.getInstance();
    ListaSimpleB blockchain = ListaSimpleB.getInstance();
    
    /**
     * Creates new form MenuViaje
     */
    public MenuViaje() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtorigen = new javax.swing.JTextField();
        txtdestino = new javax.swing.JTextField();
        txtconductor = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        txtplaca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Viajes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setText("Lugar Origen");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setText("Lugar Destino");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel4.setText("Dpi Conductor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jLabel5.setText("Dpi Cliente");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel6.setText("placa");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));
        getContentPane().add(txtorigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 30));

        txtdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdestinoActionPerformed(evt);
            }
        });
        getContentPane().add(txtdestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 80, 30));
        getContentPane().add(txtconductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 120, 30));
        getContentPane().add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 40));
        getContentPane().add(txtplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 90, 30));

        jButton1.setText("Registrar Viaje");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 180, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Vehiculo vehiculo1 = Registro.Vehiculo.getRegistro().search(new Vehiculo(txtplaca.getText(),"","",0,"","",""));
        Conductor Conductor1 = Registro.Conductor.getRegistro().search(new Conductor(txtconductor.getText(),"","","","","","",""));
        Cliente cliente1 = tabla.buscarCli(Integer.parseInt(txtcliente.getText()));
        Timestamp tiempo = new Timestamp(System.currentTimeMillis());
        Viaje viajesito = new  Viaje(txtorigen.getText(),txtdestino.getText(),"",cliente1,Conductor1,vehiculo1,new ListaSimple<Ruta>());
        try {
            blockchain.agregarAlFinal(viajesito,"");
            Registro.Ruta.getRegistro().rutaMasCorta(txtorigen.getText(), txtdestino.getText(),viajesito );
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdestinoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuViaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtconductor;
    private javax.swing.JTextField txtdestino;
    private javax.swing.JTextField txtorigen;
    private javax.swing.JTextField txtplaca;
    // End of variables declaration//GEN-END:variables
}
