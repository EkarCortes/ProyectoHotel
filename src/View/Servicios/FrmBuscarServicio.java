
package View.Servicios;

import Controller.Servicio.ServicioController;
import Models.Servicio.Servicio;
import View.Search;
import View.Table;
import javax.swing.table.DefaultTableModel;
public class FrmBuscarServicio extends javax.swing.JInternalFrame implements Search<Servicio>{
  private ServicioController servicioController;
  private FrmServicios frmServicios;
  private boolean servicioSelected = false;
  private Servicio selectedServicio;

    public void setServicioController(ServicioController servicioController) {
        this.servicioController = servicioController;
        servicioController.readAll();
    }
  
  
    public FrmBuscarServicio(FrmServicios frmServicios){
        initComponents();        
        this.frmServicios = frmServicios;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        tblServicio.setColumnSelectionAllowed(true);
        tblServicio.getTableHeader().setReorderingAllowed(false);
        tblServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicioMouseClicked(evt);
            }
        });
        tblServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblServicioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblServicioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicio);
        tblServicio.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
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

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        Table.filter(tblServicio,txtFiltro.getText());
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tblServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicioMouseClicked
    if (evt.getClickCount() == 2) {
    int row = this.tblServicio.getSelectedRow();
    if (row > -1) {
        int adjustedRow = tblServicio.convertRowIndexToModel(row);
        DefaultTableModel model = (DefaultTableModel) tblServicio.getModel();
        int serviceCode = (int) model.getValueAt(adjustedRow, tblServicio.getColumn("Código").getModelIndex());
        Servicio servicioSeleccionado = servicioController.getServiceByCode(serviceCode);
        if (frmServicios != null && servicioSeleccionado != null) {
            frmServicios.setServicioSeleccionado(servicioSeleccionado);
            frmServicios.setVisible(true);
        }
    }
    }
    }//GEN-LAST:event_tblServicioMouseClicked

    private void tblServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblServicioKeyReleased

    }//GEN-LAST:event_tblServicioKeyReleased

    private void tblServicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblServicioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblServicioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicio;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    
   
    @Override
    public void displayAll(Servicio[] objs) {
    DefaultTableModel tableModel = (DefaultTableModel) tblServicio.getModel();
    tableModel.setRowCount(0);
    for (Servicio servicio : objs) {
        Object[] data = servicio.toArrayObject();
        tableModel.addRow(data);
    }
    }

    
    public void waitForClose() {
    setVisible(true); 
}

public boolean isServicioSelected() {
    return selectedServicio != null ;
}

public Servicio getSelectedServicio() {
    return selectedServicio;
}
 public void setFrmServicios(FrmServicios frmServicios) {
        this.frmServicios = frmServicios;
    }
}
