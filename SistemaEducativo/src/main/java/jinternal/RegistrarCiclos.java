/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import bean.Ciclos;
import db.Conexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author santoslopeztzoy
 */
public class RegistrarCiclos extends javax.swing.JInternalFrame {
    
    private static RegistrarCiclos instancia;
    public static RegistrarCiclos getInstancia(){
        if(instancia==null){
            instancia=new RegistrarCiclos();
        }
        return instancia;
    }
    
    /**
     * Creates new form RegistrarCiclos
     */
    public RegistrarCiclos() {
        initComponents();
        setClosable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();
        txtNombreCiclo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setTitle("Registrar ciclos");

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Listado de ciclos");

        lblCiclo.setText("Nombre ciclo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lblCiclo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNombreCiclo)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String nombreCiclo=txtNombreCiclo.getText();
        
        
        int longitudNombreCiclo = nombreCiclo.length();
        
        if (longitudNombreCiclo<=0){
            
            JOptionPane.showMessageDialog(null, "Error, debes ingresar un nombre del ciclo","Mensaje",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        int confirmarGuardar = JOptionPane.showConfirmDialog(null,"¿Confirmar registrar ciclo?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(confirmarGuardar==JOptionPane.YES_OPTION){
            
            Object[] params={nombreCiclo};
            String consulta = "CALL agregarCiclo(?)";
            
            // se utiliza esto debido a que el INSERT se hace directamnete desde el procedimiento almacenado
            ResultSet resultado= Conexion.getInstancia().hacerConsulta(consulta, params);
            
            try{

                if(resultado!=null){
                    if(resultado.next()){
                        String mensajeObtenido = resultado.getString("mensaje");

                        if (mensajeObtenido.equals("enuso")){
                            JOptionPane.showMessageDialog(null,"Error, registro no efectuado, ya existe el nombre","Mensaje",JOptionPane.ERROR_MESSAGE);
                        
                        }if (mensajeObtenido.equals("registrado")){
                            JOptionPane.showMessageDialog(null,"Registro exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                            txtNombreCiclo.setText("");

                            ListadoDeCiclos.getInstancia().getModelo().actualizarJTable();
                        }else{
                            
                        }
                    }
                }                
            }catch(Exception ex){
                ex.printStackTrace();
            }
                        
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JLabel lblCiclo;
    private javax.swing.JTextField txtNombreCiclo;
    // End of variables declaration//GEN-END:variables
}
