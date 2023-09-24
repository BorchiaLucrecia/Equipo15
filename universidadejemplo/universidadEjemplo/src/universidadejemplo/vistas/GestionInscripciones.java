package universidadejemplo.vistas;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.accesoADatos.InscripcionData;
import universidadejemplo.entidades.Alumno;
import universidadejemplo.entidades.Inscripcion;
import universidadejemplo.entidades.Materia;


public class GestionInscripciones extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData = new AlumnoData();
    private InscripcionData inscripcionData = new InscripcionData();
    private DefaultTableModel modelo = new DefaultTableModel();

    private boolean materiasInscriptasSelected = false;
    private boolean materiasNoInscriptasSelected = false;

    public GestionInscripciones() {
        initComponents();
        this.setSize(500,500);
        this.setTitle("Sistema de gestión de INSCRIPCIONES");
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
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Formulario de inscripciones");
        setPreferredSize(new java.awt.Dimension(340, 400));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccionar alumno:");

        jCBalumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBalumnoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Listado de Materias");

        jRBmateriasInsc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRBmateriasInsc.setText("Materias Inscriptas");
        jRBmateriasInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBmateriasInscActionPerformed(evt);
            }
        });

        jRBmateriasNoInsc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jButton1.setText("Nueva consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBInscribir)
                        .addGap(18, 18, 18)
                        .addComponent(jBanularInsc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jRBmateriasInsc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRBmateriasNoInsc)
                        .addGap(47, 47, 47))
                    .addComponent(jCBalumno, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBmateriasNoInsc)
                    .addComponent(jRBmateriasInsc))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBanularInsc)
                    .addComponent(jBInscribir)
                    .addComponent(jButton1))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Acción del botón MATERIAS NO INSCRIPTAS
    private void jRBmateriasNoInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBmateriasNoInscActionPerformed
        if (jRBmateriasNoInsc.isSelected()) {
           if (jRBmateriasInsc.isSelected()){
               JOptionPane.showMessageDialog(this, "Deseleccione 'Materias Inscriptas' para seleccionar 'Materias no inscriptas'.");
               jRBmateriasNoInsc.setSelected(false);
           } else{
            materiasNoInscriptasSelected = true;
            materiasInscriptasSelected = false;
            habilitarBotones(true,false,true);
            limpiarTabla();
            cargarMateriasNoInscriptas();
           }
        }else{
            materiasNoInscriptasSelected = false;
         // Solo habilitar el botón "Nueva consulta" cuando ninguna opción esté seleccionada.    
            habilitarBotones(true,!jRBmateriasInsc.isSelected(),true);
        }
        
    }//GEN-LAST:event_jRBmateriasNoInscActionPerformed

    //Acción del botón MATERIAS INSCRIPTAS
    private void jRBmateriasInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBmateriasInscActionPerformed
        if (jRBmateriasInsc.isSelected()) {
            if(jRBmateriasNoInsc.isSelected()){
                JOptionPane.showMessageDialog(this, "Deseleccione 'Materias no inscriptas' para seleccionar 'Materias inscriptas'.");
                jRBmateriasInsc.setSelected(false);
            }else{
            materiasInscriptasSelected = true;
            materiasNoInscriptasSelected = false;
            habilitarBotones(false,true,true);
            limpiarTabla();
            cargarMateriasInscriptas();
            }
        }else{
            materiasInscriptasSelected = false;
            habilitarBotones(true,!jRBmateriasNoInsc.isSelected(),true);
        }
    }//GEN-LAST:event_jRBmateriasInscActionPerformed

    private void jCBalumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBalumnoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //Obtiene el alumno
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();

            limpiarTabla();

            if (jRBmateriasInsc.isSelected()) {
                cargarMateriasInscriptas();
            } else if (jRBmateriasNoInsc.isSelected()) {
                cargarMateriasNoInscriptas();
                
            }
        }
    }//GEN-LAST:event_jCBalumnoItemStateChanged

    private void jBanularInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBanularInscActionPerformed
        int selectMateria = jTMaterias.getSelectedRow();

        if (selectMateria != -1) {
            //Obtener valores de la materia elegida
            int idMateria = (int) jTMaterias.getValueAt(selectMateria, 0);
            String nombreMat = (String) jTMaterias.getValueAt(selectMateria,1);
            boolean estadoMat=true;
            
            //Obtener el alumno seleccionado
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();
            int idAlumno = selectedAlumno.getIdAlumno();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente anular la inscripción?");

            //Metodo
            if (respuesta == 0) {
                inscripcionData.borrarInscripcionMateriaAlumno(idAlumno, idMateria);
                
            DefaultTableModel model = (DefaultTableModel) jTMaterias.getModel();
            model.removeRow(selectMateria);

            if (materiasNoInscriptasSelected) {
                DefaultTableModel modelNoInscriptas = (DefaultTableModel) jTMaterias.getModel();
                modelNoInscriptas.addRow(new Object[]{idMateria, nombreMat, estadoMat});
            }
            }
        }
    
    
    }//GEN-LAST:event_jBanularInscActionPerformed

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        int selectMateria = jTMaterias.getSelectedRow();

        if (selectMateria != -1) {
            //Obtener valores de la materia elegida
            int idMateria = (int) jTMaterias.getValueAt(selectMateria, 0);
            String nombreMat = (String) jTMaterias.getValueAt(selectMateria, 1);
            int anioMateria = (int) jTMaterias.getValueAt(selectMateria, 2);
            boolean estadoMat = true;

            //Obtener el alumno seleccionado
            Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();
            int idAlumno = selectedAlumno.getIdAlumno();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea inscribir al alumno "
                    + selectedAlumno.getApellido() + ", " + selectedAlumno.getNombre()
                    + " a la materia: " + nombreMat+" ?");

            //Metodo
            if (respuesta == 0) {
                Inscripcion i = new Inscripcion();
                Materia m = new Materia();

                m.setIdMateria(idMateria);
                m.setNombre(nombreMat);
                m.setAnioMateria(anioMateria);
                m.setEstado(estadoMat);

                i.setMateria(m);
                i.setAlumno(selectedAlumno);
                i.setNota(0);

                //Hay que pasarle como parámetro una Inscripcion (Materia materia, Alumno alumno, nota)
                inscripcionData.guardarInscripcion(i);

                // Aquí actualizamos la tabla de no inscriptas para pasarlas a las materias inscriptas 
                DefaultTableModel modelNoInscriptas = (DefaultTableModel) jTMaterias.getModel();
                modelNoInscriptas.removeRow(selectMateria);
                
                DefaultTableModel modelInscriptas = (DefaultTableModel) jTMaterias.getModel();
                modelInscriptas.addRow(new Object[]{idMateria, nombreMat, estadoMat});

            } else if (respuesta == 1) {
                JOptionPane.showMessageDialog(null, "Se canceló la inscripción.");
            }

        }


    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jCBalumno.setSelectedIndex(-1); 
        jRBmateriasInsc.setSelected(false);
        jRBmateriasNoInsc.setSelected(false);
        limpiarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBanularInsc;
    private javax.swing.JButton jButton1;
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
        modelo.setRowCount(0);
        }
    
    private void habilitarBotones(boolean inscribir, boolean anular,boolean nuevaConsulta){
       jBInscribir.setEnabled(inscribir);
       jBanularInsc.setEnabled(anular);
       jButton1.setEnabled(nuevaConsulta);
    }
    
    private void cargarMateriasNoInscriptas(){
        Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();
        List<Materia> materiasNoInscriptas = inscripcionData.obtenerMateriasNoCursadas(selectedAlumno.getIdAlumno());
        for (Materia materia : materiasNoInscriptas){
            modelo.addRow(new Object[]{materia.getIdMateria(),materia.getNombre(), materia.getAnioMateria()});
        }
    }
    
    private void cargarMateriasInscriptas(){
      Alumno selectedAlumno = (Alumno) jCBalumno.getSelectedItem();
      List<Materia> materiasInscriptas = inscripcionData.obtenerMateriasCursadas(selectedAlumno.getIdAlumno());
      for (Materia materia : materiasInscriptas){
          modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
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

