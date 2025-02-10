
package jinternal;


import db.Conexion;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import modelo.ModeloDeFacultad;

/**
 *
 * @author santoslopeztzoy
 */
public class ListadoFacultad extends javax.swing.JInternalFrame {
    
    // recuperar valor de jtable
    private int row;
    
    
    private TableRowSorter tablaSorter;
    
    private ModeloDeFacultad modelo;
    
    private static ListadoFacultad instancia;
    public static ListadoFacultad getInstancia(){
        if(instancia==null){
            instancia=new ListadoFacultad();
        }
        return instancia;
    }
    
    public ModeloDeFacultad getModelo(){
        return modelo;
    }
    
    /**
     * Creates new form ListadoFacultad
     */
    public ListadoFacultad() {
        initComponents();
        
        setClosable(true);
        
        tablaSorter = new TableRowSorter(jTableListadoFacultad.getModel());
        jTableListadoFacultad.setRowSorter(tablaSorter);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListadoFacultad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblNombreFacultad = new javax.swing.JLabel();
        txtNombreFacultad = new javax.swing.JTextField();
        btnModificarDatosFacultad = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setTitle("Listado de facultad");

        modelo = new ModeloDeFacultad();
        jTableListadoFacultad.setModel(modelo);
        jTableListadoFacultad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoFacultadMouseClicked(evt);
            }
        });
        jTableListadoFacultad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableListadoFacultadKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListadoFacultad);

        jLabel1.setText("Buscar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblID.setText("ID");

        txtID.setEditable(false);
        txtID.setEnabled(false);

        lblNombreFacultad.setText("Nombre de facultad");

        btnModificarDatosFacultad.setText("Actualizar datos");
        btnModificarDatosFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDatosFacultadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtID)
            .addComponent(txtNombreFacultad)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblNombreFacultad))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnModificarDatosFacultad, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreFacultad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnModificarDatosFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Facultades", jPanel1);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Listado de facultades");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String buscar = txtBuscar.getText();
        tablaSorter.setRowFilter(RowFilter.regexFilter("(?i)"+buscar));       
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarDatosFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDatosFacultadActionPerformed
        // TODO add your handling code here:
        
        String id = txtID.getText();
        
        int longitudIDSeleccionado = id.length();
        
        if (longitudIDSeleccionado<=0){
            JOptionPane.showMessageDialog(null, "Error, no se puede actualizar debe seleccionar un dato.","Mensaje",JOptionPane.ERROR_MESSAGE);
            return;           
        }
        
        int confirmarDatos= JOptionPane.showConfirmDialog(null, "¿Confirmar actualización de datos?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if (confirmarDatos==JOptionPane.YES_OPTION){
            
            int idFacultad = Integer.parseInt(id);
            
            String sentencia = "CALL modificarDatosFacultad(?,?)";
            
            Object[] params = {txtNombreFacultad.getText(),idFacultad};
            
            ResultSet consulta = Conexion.getInstancia().hacerConsulta(sentencia,params);
            
            try{
                if(consulta!=null){
                    if(consulta.next()){
                        String mensajeObtenido = consulta.getString("mensaje");
                                                
                        if(mensajeObtenido.equals("actualizado")){
                            JOptionPane.showMessageDialog(null, "Datos actualizado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                            
                            
                            // actualizamos el jtable
                            modelo.actualizarJTable();
        
                            // forzar actualización debido que jtable ya esta
                            //jTableListadoFacultad.repaint();
                        }else if (mensajeObtenido.equals("mismosdatos")){
                            JOptionPane.showMessageDialog(null, "No se efectuaron cambios","Mensaje",JOptionPane.ERROR_MESSAGE);
   
                        }else{
                            JOptionPane.showMessageDialog(null, "Error capturado","Mensaje",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnModificarDatosFacultadActionPerformed

    private void jTableListadoFacultadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoFacultadMouseClicked
        // TODO add your handling code here:
        
        row = jTableListadoFacultad.rowAtPoint(evt.getPoint());
        txtID.setText(jTableListadoFacultad.getValueAt(row, 0).toString());
        txtNombreFacultad.setText(jTableListadoFacultad.getValueAt(row, 1).toString());
        
    }//GEN-LAST:event_jTableListadoFacultadMouseClicked

    private void jTableListadoFacultadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableListadoFacultadKeyPressed
        // TODO add your handling code here:
        int fila = jTableListadoFacultad.getSelectedRow();
        
        if (evt.getKeyCode()==KeyEvent.VK_UP && fila>0){
            fila--;
        }else if (evt.getKeyCode()==KeyEvent.VK_DOWN && fila<jTableListadoFacultad.getRowCount()-1){
            fila++;
        }else{
            return;
        }
        
        txtID.setText(jTableListadoFacultad.getValueAt(fila, 0).toString());
        txtNombreFacultad.setText(jTableListadoFacultad.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_jTableListadoFacultadKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificarDatosFacultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableListadoFacultad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombreFacultad;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombreFacultad;
    // End of variables declaration//GEN-END:variables
}
