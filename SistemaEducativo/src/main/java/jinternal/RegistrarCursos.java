
package jinternal;

import db.Conexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author santoslopeztzoy
 */
public class RegistrarCursos extends javax.swing.JInternalFrame {
    // patron de diseno singleton para crear una sola instancia de la clase
    private static RegistrarCursos instancia;
    public static RegistrarCursos getInstancia(){
        if(instancia==null){
            
            instancia=new RegistrarCursos();
        }
        return instancia;
    }
    
    /**
     * Creates new form RegistrarCursos
     */
    public RegistrarCursos() {
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
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        btnGuardarCursos = new javax.swing.JButton();

        setTitle("Registrar cursos");

        lblTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registrar cursos");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("Código");

        lblNombre.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblNombre.setText("Nombre curso");

        btnGuardarCursos.setText("Guardar");
        btnGuardarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCodigo)
            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCurso)
            .addComponent(btnGuardarCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnGuardarCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(16, 16, 16))
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

    private void btnGuardarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCursosActionPerformed
        // TODO add your handling code here:
        String codigoCurso = txtCodigo.getText();
        
        String nombreCurso = txtCurso.getText();
        
        
        int longituCodigoCurso = codigoCurso.length();
        int longitudNombreCurso = nombreCurso.length();
        
        if ((longituCodigoCurso<=0) || (longitudNombreCurso<=0)){
            JOptionPane.showMessageDialog(null, "Error, el codigo de curso o nombre de curso no pueden estar vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        
        int confirmarGuardar = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el curso?","Mensaje",JOptionPane.YES_NO_OPTION);
        
        if (confirmarGuardar==JOptionPane.YES_OPTION){
            Object[] params = {codigoCurso,nombreCurso};
            
            String consulta = "CALL sp_agregarCursos(?,?)";
            
            
            ResultSet resultado = Conexion.getInstancia().hacerConsulta(consulta, params);
            
            try{
                if(resultado!=null){
                    if(resultado.next()){
                        String mensajeObtenido = resultado.getString("mensaje");
                        if (mensajeObtenido.equals("registrado")){
                           
                            JOptionPane.showMessageDialog(null, "Curso registrado.","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                            txtCodigo.setText("");
                            txtCurso.setText("");
                            
                            ListadoDeCursos.getInstancia().getModelo().actualizarJTable();
                            
                            
                        }else if (mensajeObtenido.equals("enuso")){
                            JOptionPane.showMessageDialog(null, "Curso o código en uso.","Mensaje",JOptionPane.ERROR_MESSAGE);

                        }else{
                            
                        }
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
                
    }//GEN-LAST:event_btnGuardarCursosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}
