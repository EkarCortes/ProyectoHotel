/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.Servicios;

import Controller.Servicio.ServicioController;
import Models.Servicio.Servicio;
import View.View;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author wendy
 */
public class FrmServicios extends javax.swing.JInternalFrame implements View<Servicio>{
    private ServicioController servicioController;
    private Servicio servicioSeleccionado;
    //private Controller controller;
    public FrmServicios() {
        initComponents();
        servicioController = new ServicioController(this);
        servicioController.readAll();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCodigo = new javax.swing.JLabel();
        jNombre = new javax.swing.JLabel();
        jDescripcion = new javax.swing.JLabel();
        jPrecio = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JFormattedTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Servicios/escoba.png"))); // NOI18N
        btnClear.setToolTipText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearbtnClearActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Servicios/disco.png"))); // NOI18N
        btnSave.setToolTipText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavebtnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Servicios/basura (1).png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletebtnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Servicios/busqueda.png"))); // NOI18N
        btnSearch.setToolTipText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchbtnSearchActionPerformed(evt);
            }
        });

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Servicios/actualizar.png"))); // NOI18N
        btnupdate.setToolTipText("Limpiar");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatebtnupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCodigo.setText("Código:");

        jNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jNombre.setText("Nombre:");

        jDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jDescripcion.setText("Descripción:");

        jPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPrecio.setText("Precio:");

        txtCodigo.setEditable(false);
        txtCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPrecio))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigo)
                    .addComponent(jNombre)
                    .addComponent(jDescripcion)
                    .addComponent(jPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearbtnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearbtnClearActionPerformed

    private void btnSavebtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavebtnSaveActionPerformed
    String nombre = txtNombre.getText();
    String descripcion = txtDescripcion.getText();
    String precioStr = txtPrecio.getText();
    try{
       double precio = Double.parseDouble(precioStr);
    if (nombre.isEmpty()|| descripcion.isEmpty()|| precio<=0) {
      displayErrorMessage("Todos los campos son requeridos y el precio debe ser mayor que 0.");
    }else{
    servicioController.addNewService(nombre, descripcion, precio);     
    clear();
    servicioController.readAll();
    }
    }catch (NumberFormatException e){
       displayErrorMessage("El precio debe ser un numero valido");
    }
    }//GEN-LAST:event_btnSavebtnSaveActionPerformed

    private void btnDeletebtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletebtnDeleteActionPerformed
    if (servicioSeleccionado != null) {
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este servicio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            servicioController.delete(servicioSeleccionado);
            clear();
            servicioController.readAll();
        }
    }
    }//GEN-LAST:event_btnDeletebtnDeleteActionPerformed

    private void btnSearchbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchbtnSearchActionPerformed
    FrmBuscarServicio buscarServicioFrame = new FrmBuscarServicio(this); 
    JDesktopPane desktopPane = getDesktopPane(); 
    desktopPane.add(buscarServicioFrame);
    this.servicioController.setSearch(buscarServicioFrame);
    buscarServicioFrame.setServicioController(servicioController);
    buscarServicioFrame.setVisible(true);
    }//GEN-LAST:event_btnSearchbtnSearchActionPerformed

    private void btnupdatebtnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatebtnupdateActionPerformed
        if (servicioSeleccionado != null) {
        System.out.println("Actualizando servicio...");
        String nombre = txtNombre.getText(); 
        String descripcion = txtDescripcion.getText();
        String precioStr = txtPrecio.getText();
        if (!nombre.isEmpty() || !descripcion.isEmpty() || !precioStr.isEmpty()) {
            if (!nombre.isEmpty()) {
                servicioSeleccionado.setNombre(nombre);
            }
            if (!descripcion.isEmpty()) {
                servicioSeleccionado.setDescripcion(descripcion);
            }
            if (!precioStr.isEmpty()) {
                try{
                double precio = Double.parseDouble(precioStr);
                if (precio>0) {
            servicioSeleccionado.setPrecio(precio);
                }else{
                    displayErrorMessage("El precio debe ser mayor a 0");
                    return;
                }
            }catch(NumberFormatException e){
            displayErrorMessage("El precio debe ser un numero valido");
             return;
            }
            }
        }
        servicioController.update(servicioSeleccionado);
        clear();
        servicioController.readAll();
        }else{
           displayErrorMessage("Seleccione un campo de la tabla.");
               }
    }//GEN-LAST:event_btnupdatebtnupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jCodigo;
    private javax.swing.JLabel jDescripcion;
    private javax.swing.JLabel jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPrecio;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clear() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
    }

    @Override
    public void display(Servicio obj) {
    txtCodigo.setText(String.valueOf(obj.getCodigo()));
    txtNombre.setText(obj.getNombre());
    txtDescripcion.setText(obj.getDescripcion());
    txtPrecio.setText(String.valueOf(obj.getPrecio()));
    }

    

    @Override
    public void displayMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public boolean displayConfirmMessage(String message) {
         int option = JOptionPane.showConfirmDialog(this, message, "Confirmación", JOptionPane.YES_NO_OPTION);
    return option == JOptionPane.YES_OPTION;
    }

    @Override
    public void displayErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void setServicioSeleccionado(Servicio servicioSeleccionado) {
    this.servicioSeleccionado = servicioSeleccionado;
    display(servicioSeleccionado); // Esto actualiza los campos en FrmServicios
}

}
