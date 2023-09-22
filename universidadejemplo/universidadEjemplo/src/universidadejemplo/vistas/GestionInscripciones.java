package universidadejemplo.vistas;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.accesoADatos.InscripcionData;
import universidadejemplo.entidades.Alumno;
import universidadejemplo.entidades.Inscripcion;
import universidadejemplo.entidades.Materia;

public class GestionInscripciones extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData = new AlumnoData();
    private InscripcionData inscripcionData = new InscripcionData();

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
        setTitle("Formulario de inscripciones");
        setPreferredSize(new java.awt.Dimension(340, 400));

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
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBanularInsc.setText("Anular Inscripción");
        jBanularInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBanularInscActionPerformed(evt);
            }
        });

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBmateriasInsc)
                    .addComponent(jRBmateriasNoInsc))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
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

            limpiarTabla();

            //Obtener el nombre del alumno 
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();

            //Obtener materias no inscriptas
            List<Materia> materiasNoInscriptas = inscripcionData.obtenerMateriasNoCursadas(selectedAlumno.getIdAlumno());
//            InscripcionData idata =new InscripcionData();
//            Alumno alumno=new Alumno();

            //Actualizar tabla:
            for (Materia materia : materiasNoInscriptas) {
                modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
            }
//            jCBalumno.getSelectedItem();

        } else {
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

            limpiarTabla();

            //Obtener el nombre del alumno 
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();

//Obtener materias inscriptas
            List<Materia> materiasInscriptas = inscripcionData.obtenerMateriasCursadas(selectedAlumno.getIdAlumno());

            // Actualizar tabla   
            for (Materia materia : materiasInscriptas) {
                modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
            }
        } else {
            limpiarTabla();
            jRBmateriasNoInsc.setEnabled(true);
            jBInscribir.setEnabled(true);
            jBanularInsc.setEnabled(true);
        }

    }//GEN-LAST:event_jRBmateriasInscActionPerformed

    private void jCBalumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBalumnoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //Obtiene el alumno
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();

            limpiarTabla();

            if (jRBmateriasInsc.isSelected()) {
                //Obtener materias inscriptas para el alumno
                List<Materia> materiasInscriptas = inscripcionData.obtenerMateriasCursadas(selectedAlumno.getIdAlumno());
                //Actualizar tabla
                for (Materia materia : materiasInscriptas) {
                    modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
                }
            } else if (jRBmateriasNoInsc.isSelected()) {
                //Obener las materias no inscriptas
                List<Materia> materiasNoInscriptas = inscripcionData.obtenerMateriasNoCursadas(selectedAlumno.getIdAlumno());

                //Actualizar tabla
                for (Materia materia : materiasNoInscriptas) {
                    modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
                }
            }
        }
    }//GEN-LAST:event_jCBalumnoItemStateChanged

    private void jBanularInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBanularInscActionPerformed
        int selectMateria = jTMaterias.getSelectedRow();

        if (selectMateria != -1) {
            //Obtener valores de la materia elegida
            int idMateria = (int) jTMaterias.getValueAt(selectMateria, 0);

            //Obtener el alumno seleccionado
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();
            int idAlumno = selectedAlumno.getIdAlumno();

            int respuesta = JOptionPane.showConfirmDialog(null, "Realmente anular la inscripción?");

            //Metodo
            if (respuesta == 0) {
                inscripcionData.borrarInscripcionMateriaAlumno(idAlumno, idMateria);
            }

        }
    }//GEN-LAST:event_jBanularInscActionPerformed

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        int selectMateria = jTMaterias.getSelectedRow();

        if (selectMateria != -1) {
            //Obtener valores de la materia elegida
            int idMateria = (int) jTMaterias.getValueAt(selectMateria, 0);
            String nombreMat =(String) jTMaterias.getValueAt(selectMateria, 1);
            boolean estadoMat =(boolean) jTMaterias.getValueAt(selectMateria, 2);

            //Obtener el alumno seleccionado
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();
            int idAlumno = selectedAlumno.getIdAlumno();

            int respuesta = JOptionPane.showConfirmDialog(null, "Desea inscribir al alumno " + idAlumno
                    + " a la materia: " + jTMaterias.getSelectedRow());

////////////// ERROR EN TIEMPO DE EJECUCCION

            //Metodo
            if (respuesta == 0) {
                Inscripcion i = new Inscripcion();
                Materia m = new Materia();
                                
                m.setIdMateria(idMateria);
                m.setNombre(nombreMat);
                m.setEstado(estadoMat); 
                                
                i.setMateria(m);
                i.setAlumno(selectedAlumno);
                i.setNota(0);
            
            //Hay que pasarle como parámetro una Inscripcion (Materia materia, Alumno alumno, nota)
                inscripcionData.guardarInscripcion(i);
                
            }else JOptionPane.showMessageDialog(null, "Se canceló la Inscripción");

        }


    }//GEN-LAST:event_jBInscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBanularInsc;
    private javax.swing.JComboBox<Alumno> jCBalumno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRBmateriasInsc;
    private javax.swing.JRadioButton jRBmateriasNoInsc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables

// Método para cargar el JComboBox con la lista de alumnos
    //Obtenemos el objeto alumno completo y podemos acceder a su ID. 
    private void cargarCombo() {
        // Obtener la lista de alumnos desde AlumnoData
        List<Alumno> alumnos = alumnoData.listarAlumno();
        for (Alumno alumno : alumnos) {
            jCBalumno.addItem(alumno);
        }
        jCBalumno.setRenderer(new AlumnoComboBox());
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

    //Personaliza como se muestra cada elemento en el JcomboBox como se hace con las tablas.
    private class AlumnoComboBox extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Alumno) {
                Alumno alumno = (Alumno) value;
                //Personaliza el jcombobox
                setText(alumno.toString());
            }
            return this;
        }
    }
}
