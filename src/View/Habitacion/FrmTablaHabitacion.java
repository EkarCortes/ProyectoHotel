/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.Habitacion;

import Controller.Controller;
import Controller.Habitación.HabitacionController;
import Models.Habitación.Habitación;
import View.Tabla;
import View.View;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ekard
 */
public class FrmTablaHabitacion extends javax.swing.JInternalFrame implements View<Habitación>{

    private Habitación habitacion;
    private HabitacionController habitacioncontroller;
    private Controller controller;
    
    public FrmTablaHabitacion() {
        initComponents();
        this.habitacioncontroller = new HabitacionController(this);
        this.habitacioncontroller.readAll();
        
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
        tblHabitaciones = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();

        setClosable(true);

        tblHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N#Habitacion", "Tipo", "Estado", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHabitaciones.setColumnSelectionAllowed(true);
        tblHabitaciones.getTableHeader().setReorderingAllowed(false);
        tblHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHabitacionesMouseClicked(evt);
            }
        });
        tblHabitaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblHabitacionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblHabitaciones);
        tblHabitaciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblHabitaciones.getColumnModel().getColumnCount() > 0) {
            tblHabitaciones.getColumnModel().getColumn(2).setResizable(false);
        }

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
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

    private void tblHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHabitacionesMouseClicked
        //HACER DESPUES
    }//GEN-LAST:event_tblHabitacionesMouseClicked

    private void tblHabitacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblHabitacionesKeyReleased
        //HACER DUEPUES
    }//GEN-LAST:event_tblHabitacionesKeyReleased

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        Tabla.filter(tblHabitaciones,txtFiltro.getText());
    }//GEN-LAST:event_txtFiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblHabitaciones;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void display(Habitación regs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayAll(Habitación[] regs) {
        DefaultTableModel tableModel=(DefaultTableModel) tblHabitaciones.getModel();
       tableModel.setNumRows(0);
       for(Habitación habitacion:regs){
           Object[] Data=habitacion.toArrayObject();
            tableModel.addRow(Data);
        }   
        tblHabitaciones.setModel(tableModel);
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
}
   