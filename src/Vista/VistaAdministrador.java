/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControllerAdministrador;
import Control.ControllerSolicitud;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;

import Logic.Solicitud;
import Control.ControllerSolicitud;
import Modelo.ModeloAdministrador;
import java.util.Observer;

/**
 *
 * @author Fernando
 */
public class VistaAdministrador extends javax.swing.JFrame implements Observer {

    
    public javax.swing.JTextField getCampoFecha() {
        return campoFecha;
    }

    
    public void setCampoFecha(javax.swing.JTextField campoFecha) {
        this.campoFecha = campoFecha;
    }

    
    public javax.swing.JTextField getCampoNumeroComprobante() {
        return campoNumeroComprobante;
    }

    
    public void setCampoNumeroComprobante(javax.swing.JTextField campoNumeroComprobante) {
        this.campoNumeroComprobante = campoNumeroComprobante;
    }

   
    public javax.swing.JComboBox<String> getCampoTipoAdqui() {
        return campoTipoAdqui;
    }

    
    public void setCampoTipoAdqui(javax.swing.JComboBox<String> campoTipoAdqui) {
        this.campoTipoAdqui = campoTipoAdqui;
    }


    public javax.swing.JTextPane getCampoMontoTotal() {
        return campoMontoTotal;
    }


    public void setCampoMontoTotal(javax.swing.JTextPane campoMontoTotal) {
        this.campoMontoTotal = campoMontoTotal;
    }

   
    ControllerSolicitud controller = null;    
    public DefaultTableModel dtm = new DefaultTableModel();
     
      
    
    public VistaAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);   
        
        String [] titulo1 = new String []{"Descripcion", "Modelo", "Serial", "Precio", "Cantidad"};     
        
        tablaBienesSolicitudes.setModel(dtm);
        dtm.setColumnIdentifiers(titulo1);
         
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        solictud = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campoTipoAdquicicion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoMontoTotal = new javax.swing.JTextPane();
        btnGuardarSolicitud = new javax.swing.JButton();
        campoNumeroComprobante = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBienesSolicitudes = new javax.swing.JTable();
        btnAgregarBien = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoTipoAdqui = new javax.swing.JComboBox<>();
        campoFecha = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Funcionarios = new javax.swing.JMenu();
        cambiarUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        solictud.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        solictud.setText("Solicitud de Bienes Muebles");

        campoTipoAdquicicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-vacio-", "Donacion", "Compra", "Produccion Institucional", " " }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${undecorated}"), campoTipoAdquicicion, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        campoTipoAdquicicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoAdquicicionActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("NUMERO DE COMPROBANTE");

        jLabel5.setText("Monto Total");

        campoMontoTotal.setEditable(false);
        jScrollPane1.setViewportView(campoMontoTotal);

        btnGuardarSolicitud.setText("Guardar Solicitud");
        btnGuardarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSolicitudActionPerformed(evt);
            }
        });

        campoNumeroComprobante.setEditable(false);

        tablaBienesSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Modelo", "Serial", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBienesSolicitudes.getTableHeader().setReorderingAllowed(false);
        tablaBienesSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBienesSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBienesSolicitudes);
        if (tablaBienesSolicitudes.getColumnModel().getColumnCount() > 0) {
            tablaBienesSolicitudes.getColumnModel().getColumn(0).setResizable(false);
        }

        btnAgregarBien.setText("Agregar Bien");
        btnAgregarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBienActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Tipo de Adquisicion");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Fecha");

        campoTipoAdqui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra", "Donación", "Produccion Institucional" }));

        Funcionarios.setText("Funcionarios");

        cambiarUsuario.setText("Cambiar Usuario");
        cambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarUsuarioActionPerformed(evt);
            }
        });
        Funcionarios.add(cambiarUsuario);

        jMenuBar1.add(Funcionarios);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Salir");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarSolicitud))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(campoTipoAdqui, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarBien))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(91, 91, 91)
                                .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(campoNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(campoNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarBien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoTipoAdqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarSolicitud)
                            .addComponent(btnCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoTipoAdquicicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoAdquicicionActionPerformed
        
    }//GEN-LAST:event_campoTipoAdquicicionActionPerformed

    private void btnAgregarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBienActionPerformed
     }//GEN-LAST:event_btnAgregarBienActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarSolicitudActionPerformed

    private void tablaBienesSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBienesSolicitudesMouseClicked
   
    }//GEN-LAST:event_tablaBienesSolicitudesMouseClicked

    private void cambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarUsuarioActionPerformed
        this.controlador.actionPerformed(evt);
    }//GEN-LAST:event_cambiarUsuarioActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Funcionarios;
    private javax.swing.JButton btnAgregarBien;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarSolicitud;
    public javax.swing.JMenuItem cambiarUsuario;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextPane campoMontoTotal;
    private javax.swing.JTextField campoNumeroComprobante;
    private javax.swing.JComboBox<String> campoTipoAdqui;
    private javax.swing.JComboBox<String> campoTipoAdquicicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel solictud;
    private javax.swing.JTable tablaBienesSolicitudes;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    
    ModeloAdministrador modelo;     
    
    ControllerAdministrador controlador;
    
    
    public void setModelo(ModeloAdministrador model){
        this.modelo=model;
        model.addObserver(this);
    } 
    
    public void setControlador(ControllerAdministrador aThis) {
        this.controlador = aThis;
        btnAgregarBien.addActionListener(aThis);
        btnCancelar.addActionListener(aThis);
        btnGuardarSolicitud.addActionListener(aThis);
        cambiarUsuario.addActionListener(aThis);
        
    }
    
//    public void agregarFila(String descripcion,String serial,String nombre, String marca){
//      dtm.addRow(new Object [] {serial, nombre, marca});
//    }
    
    @Override
    public void update(Observable updatedModel,Object param){
        
    }

    
}
