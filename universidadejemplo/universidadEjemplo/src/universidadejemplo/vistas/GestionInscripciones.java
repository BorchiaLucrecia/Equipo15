package universidadejemplo.vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.entidades.Alumno;

public class GestionInscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();

    public GestionInscripciones() {
        initComponents();
        cargarCombo();
        armarCabecera();
        limpiarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBalumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jRBmateriasInsc = new javax.swing.JRadioButton();
        jRBmateriasNoInsc = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterias = new javax.swing.JTable();
        jBInscribir = new javax.swing.JButton();
        jBanularInsc = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(340, 400));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Formulario de Inscripción");

        jLabel2.setText("Alumno:");

        jCBalumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBalumnoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Listado de Materias");

        jRBmateriasInsc.setText("Materias Inscriptas");
        jRBmateriasInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBmateriasInscActionPerformed(evt);
            }
        });

        jRBmateriasNoInsc.setText("Materias no inscriptas");
        jRBmateriasNoInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBmateriasNoInscActionPerformed(evt);
            }
        });

        jTMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ));
        jTMaterias.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTMaterias);
        if (jTMaterias.getColumnModel().getColumnCount() > 0) {
            jTMaterias.getColumnModel().getColumn(2).setResizable(false);
        }

        jBInscribir.setText("Inscrbir");

        jBanularInsc.setText("Anular Inscripción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBInscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBanularInsc)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jCBalumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jRBmateriasInsc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jRBmateriasNoInsc)))
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBmateriasInsc)
                    .addComponent(jRBmateriasNoInsc))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBanularInsc)
                    .addComponent(jBInscribir))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Acción del botón MATERIAS NO INSCRIPTAS
    private void jRBmateriasNoInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBmateriasNoInscActionPerformed
        if (jRBmateriasNoInsc.isSelected()) {
            jRBmateriasInsc.setEnabled(false); //Desactiva el radio button de materias inscriptas
            jBInscribir.setEnabled(true); //Activa el boton de Inscribir
            jBanularInsc.setEnabled(false); //Desactiva el boton de Anular Inscripcion

            jCBalumno.getSelectedItem();
            
            ///////FALTA TERMINAR 

        }else{
            limpiarTabla();
            jRBmateriasInsc.setEnabled(true);
            jBInscribir.setEnabled(true); 
            jBanularInsc.setEnabled(true);
        }
    }//GEN-LAST:event_jRBmateriasNoInscActionPerformed
    //Acción del botón MATERIAS INSCRIPTAS
    private void jRBmateriasInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBmateriasInscActionPerformed
        if (jRBmateriasInsc.isSelected()) {
            jRBmateriasNoInsc.setEnabled(false);
            jBInscribir.setEnabled(false);
            jBanularInsc.setEnabled(true);
            
            ////////FALTA TERMINAR
        }

    }//GEN-LAST:event_jRBmateriasInscActionPerformed

    private void jCBalumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBalumnoItemStateChanged
            ////////FALTA TERMINAR
    }//GEN-LAST:event_jCBalumnoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBanularInsc;
    private javax.swing.JComboBox<String> jCBalumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRBmateriasInsc;
    private javax.swing.JRadioButton jRBmateriasNoInsc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        AlumnoData alum = new AlumnoData();
        for (Alumno alumno : alum.listarAlumno()) {
            jCBalumno.addItem(alumno.toString());
        }
        jCBalumno.setSelectedIndex(-1);

    }
    //Método para Armar la Cabecera de la Tabla
    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre de la Materia");
        modelo.addColumn("Año");

        jTMaterias.setModel(modelo);
    }

    private void limpiarTabla() {
        for (int f = modelo.getRowCount() - 1; f >= 0; f--) {
                modelo.removeRow(f);
        }
    }
}
