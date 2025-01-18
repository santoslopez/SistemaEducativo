/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import bean.Facultad;
import db.Conexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import manejador.ManejadorDeFacultad;

/**
 *
 * @author santoslopeztzoy
 */
public class RegistrarFacultad extends javax.swing.JInternalFrame {

    
    private Facultad facultad=new Facultad();
    
    
    private static RegistrarFacultad instancia;
    public static RegistrarFacultad getInstancia(){
        if(instancia==null){
            instancia=new RegistrarFacultad();
        }
        return instancia;
    }
    
    /**
     * Creates new form RegistrarFacultad
     */
    public RegistrarFacultad() {
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreFacultad = new javax.swing.JLabel();
        txtNombreFacultad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setTitle("Registrar facultad");

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        lblTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblTitulo.setText("Registrar facultad");

        lblNombreFacultad.setText("Nombre facultad");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            .addComponent(lblNombreFacultad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNombreFacultad)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String nombreFacultad = txtNombreFacultad.getText();
        int confirmarGuardar = JOptionPane.showConfirmDialog(null,
                "¿Deseas guardar los datos?"
                ,"Mensaje"
                ,JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        
        if(confirmarGuardar==JOptionPane.YES_OPTION){
            
            /*
            Verificar si ya existe esta facultad
            */
            facultad = ManejadorDeFacultad.getInstancia().validarExistencia(nombreFacultad);
            
            
            if(facultad!=null){
                
                
                
                JOptionPane.showMessageDialog(null,"Nombre de facultad ya existe","Mensaje",JOptionPane.ERROR_MESSAGE);
              
            }else{

                String sentencia="INSERT INTO Facultad(nombre) VALUES(?)";

                Object[] params = {nombreFacultad};
                Conexion.getInstancia().ejecutarSentencia(sentencia, params);

                JOptionPane.showMessageDialog(null,"Registro exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);  
                
            }

        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombreFacultad;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombreFacultad;
    // End of variables declaration//GEN-END:variables
}
