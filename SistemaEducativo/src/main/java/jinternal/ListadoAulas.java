/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import bean.LlenarComboBox;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.ModeloDeAulas;

/**
 *
 * @author santoslopeztzoy
 */
public class ListadoAulas extends javax.swing.JInternalFrame {

    // necesario para recuperar el valor de la fila seleccionado
    private int row;
    
    
    private ModeloDeAulas modelo;
    
    public ModeloDeAulas getModelo(){
        return modelo;
    }
    
    
    private static ListadoAulas instancia;
    public static ListadoAulas getInstancia(){
        if(instancia==null){
            instancia=new ListadoAulas();
        }
        return instancia;
    }
    
    
    public void cargarComboboxEdificio(){
        String consulta = "SELECT * FROM Edificio";
        Object[] params={};
        LlenarComboBox.getInstancia().tipoCuenta(cboEdificio, consulta, params, "idEdificio","nombreEdificio");
    }
    
    /**
     * Creates new form ListadoAulas
     */
    public ListadoAulas() {
        initComponents();
        setClosable(true);
        cargarComboboxEdificio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedorPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListadoAulas = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreSalon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        cboEdificio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnActualizarDatos = new javax.swing.JButton();

        setTitle("Listado de aulas");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Listado de aulas");

        modelo = new ModeloDeAulas();
        jTableListadoAulas.setModel(modelo);
        jTableListadoAulas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoAulasMouseClicked(evt);
            }
        });
        jTableListadoAulas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableListadoAulasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListadoAulas);

        jLabel1.setText("Salón");

        jLabel2.setText("Edificio");

        cboEdificio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Nivel");

        jLabel4.setText("ID");

        txtID.setEditable(false);
        txtID.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNombreSalon)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNivel)
            .addComponent(cboEdificio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Aulas", jPanel1);

        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContenedorPrincipalLayout = new javax.swing.GroupLayout(jPanelContenedorPrincipal);
        jPanelContenedorPrincipal.setLayout(jPanelContenedorPrincipalLayout);
        jPanelContenedorPrincipalLayout.setHorizontalGroup(
            jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(btnActualizarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContenedorPrincipalLayout.setVerticalGroup(
            jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenedorPrincipalLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListadoAulasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoAulasMouseClicked
        // TODO add your handling code here:
        row = jTableListadoAulas.rowAtPoint(evt.getPoint());
        txtID.setText(jTableListadoAulas.getValueAt(row, 0).toString());
        txtNombreSalon.setText(jTableListadoAulas.getValueAt(row, 1).toString());
        
        cboEdificio.removeAllItems();
        cboEdificio.addItem(jTableListadoAulas.getValueAt(row, 2).toString());
        txtNivel.setText(jTableListadoAulas.getValueAt(row, 3).toString());
    }//GEN-LAST:event_jTableListadoAulasMouseClicked

    private void jTableListadoAulasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableListadoAulasKeyPressed
        // TODO add your handling code here:
        int fila = jTableListadoAulas.getSelectedRow();
        
        if (evt.getKeyCode()==KeyEvent.VK_UP && fila>0){
            fila--;
        }else if (evt.getKeyCode()==KeyEvent.VK_DOWN && fila <jTableListadoAulas.getRowCount() - 1){
            fila++;
        }else{
            return;
        }
        txtID.setText(jTableListadoAulas.getValueAt(fila, 0).toString());
        txtNombreSalon.setText(jTableListadoAulas.getValueAt(fila,1).toString());
        cboEdificio.removeAllItems();
        cboEdificio.addItem(jTableListadoAulas.getValueAt(fila, 2).toString());
        txtNivel.setText(jTableListadoAulas.getValueAt(fila, 3).toString());
        
        
    }//GEN-LAST:event_jTableListadoAulasKeyPressed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        
        String salon = txtNombreSalon.getText();
        
        String nivel = txtNivel.getText();
        
        
        if (id.length()<=0){
            JOptionPane.showMessageDialog(null,"Error no se puede actualizar. Debe seleccionar un dato","Mensaje",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        
    }//GEN-LAST:event_btnActualizarDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JComboBox<String> cboEdificio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContenedorPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableListadoAulas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombreSalon;
    // End of variables declaration//GEN-END:variables
}
