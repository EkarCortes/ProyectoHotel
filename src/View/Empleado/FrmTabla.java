/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.Empleado;

import Controller.Controller;
import Controller.Empleado.EmpleadoController;
import Models.Empleado.Empleado;
import View.Tabla;
import View.View;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ekard
 */
public class FrmTabla extends javax.swing.JInternalFrame implements View<Empleado> {

    private Empleado empleado;
    private EmpleadoController empleadocontroller;
    private Controller controller;
    private FrmEmpleado frmempleado;
    
    public FrmTabla( ) {
        initComponents();
        
        this.empleadocontroller = new EmpleadoController(this);
        this.empleadocontroller.readAll();
        
        
        
        
    }
    public void setController(Controller controller) {
        this.controller = controller;

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Telefono", "Puesto", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setColumnSelectionAllowed(true);
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        tblEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblEmpleadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addComponent(txtFiltro))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
          if (evt.getClickCount() == 2) { // Verificar si hubo 2 clics (doble clic)
            int row = tblEmpleados.getSelectedRow();
            Object id = tblEmpleados.getValueAt(row, 0);
            
            this.controller.read(id); 
        }
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void tblEmpleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEmpleadosKeyReleased
         if (evt.getKeyCode()==KeyEvent.VK_DELETE){
            int row = tblEmpleados.getSelectedRow();
            if (row>-1){
                Object id = tblEmpleados.getValueAt(row, 0);
                this.controller.delete(new Empleado(id.toString()));
            }
        }
        
    }//GEN-LAST:event_tblEmpleadosKeyReleased

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
           Tabla.filter(tblEmpleados,txtFiltro.getText());
    }//GEN-LAST:event_txtFiltroKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void clear() {
      txtFiltro.setText(""); 
    }

   
     
   @Override
    public void displayAll(Empleado[] regs) {
       DefaultTableModel tableModel=(DefaultTableModel) tblEmpleados.getModel();
       tableModel.setNumRows(0);
       for(Empleado empleado:regs){
           Object[] Data=empleado.toArrayObject();
            tableModel.addRow(Data);
        }   
        tblEmpleados.setModel(tableModel);
    }

    @Override
    public void displayMessaje(String msj) {
       JOptionPane.showMessageDialog(this, msj, "Información Importante", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void displayErrorMessaje(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public boolean displayConfirmMessaje(String msj) {
       int result = JOptionPane.showConfirmDialog(this, msj, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    @Override
    public void display(Empleado regs) {
        
                
      /*  if (empleado != null) {
        txtCedula.setText(empleado.getIdentificacion());
        txtNombre.setText(empleado.getNombre());
        txtTelefono.setText(empleado.getTelefono());
        //txtSalario.setText(empleado.setSalario(double));
        txtPuesto.setSelectedItem(empleado.getPuesto().toString());
    } else {
        clear(); // Limpiar las cajas de texto si el miembro no se encuentra
    }
*/

}
    }