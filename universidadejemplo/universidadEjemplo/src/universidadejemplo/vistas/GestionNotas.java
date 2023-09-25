package universidadejemplo.vistas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.accesoADatos.InscripcionData;
import universidadejemplo.entidades.Alumno;
import universidadejemplo.entidades.Inscripcion;
import universidadejemplo.entidades.Materia;

public class GestionNotas extends javax.swing.JInternalFrame {
    
    private AlumnoData alumnoData = new AlumnoData();
    private InscripcionData inscripcionData = new InscripcionData();
    private DefaultTableModel modelo = new DefaultTableModel();
    private JFrame frame;
    
    public GestionNotas() {
        initComponents();
        this.setSize(500, 500);
        this.setTitle("Sistema de gestion de NOTAS");
        
        cargarComboAlumno();
        armarCabecera();
        limpiarTabla();
        this.frame = frame;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jcbListaAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaMateria = new javax.swing.JTable();
        jBActualizarNota = new javax.swing.JButton();
        jBNuevaConsulta = new javax.swing.JButton();

        setClosable(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccionar alumno:");

        jcbListaAlumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbListaAlumnosItemStateChanged(evt);
            }
        });

        jtListaMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre materia", "Nota"
            }
        ));
        jScrollPane1.setViewportView(jtListaMateria);

        jBActualizarNota.setText("Actualizar nota");
        jBActualizarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarNotaActionPerformed(evt);
            }
        });

        jBNuevaConsulta.setText("Nueva consulta");
        jBNuevaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevaConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jBNuevaConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBActualizarNota)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jcbListaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbListaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBActualizarNota)
                    .addComponent(jBNuevaConsulta))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbListaAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbListaAlumnosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //Obtiene el alumno del JComboBox
            Alumno selectedAlumno = (Alumno) jcbListaAlumnos.getSelectedItem();
            cargarMateriasInscriptas();
            
            jBActualizarNota.setEnabled(true);
            jBNuevaConsulta.setEnabled(true);
        }
    }//GEN-LAST:event_jcbListaAlumnosItemStateChanged

    private void jBActualizarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarNotaActionPerformed
        int fila = jtListaMateria.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showConfirmDialog(GestionNotas.this, "Selecciona una materia");
            return;
        }
        int idMateria = (int) modelo.getValueAt(fila, 0);
        Alumno selectedAlumno = (Alumno) jcbListaAlumnos.getSelectedItem();
        
        ActualizarNotaDialog dialog = new ActualizarNotaDialog(frame, idMateria, selectedAlumno);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

    }//GEN-LAST:event_jBActualizarNotaActionPerformed

    private void jBNuevaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevaConsultaActionPerformed
        limpiarTabla();
        jcbListaAlumnos.setSelectedIndex(0);
    }//GEN-LAST:event_jBNuevaConsultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizarNota;
    private javax.swing.JButton jBNuevaConsulta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Alumno> jcbListaAlumnos;
    private javax.swing.JTable jtListaMateria;
    // End of variables declaration//GEN-END:variables

    private void cargarComboAlumno() {
        // Obtener la lista de alumnos desde AlumnoData
        List<Alumno> alumnos = alumnoData.listarAlumno();
        for (Alumno alumno : alumnos) {
            jcbListaAlumnos.addItem(alumno);
        }
        jcbListaAlumnos.setRenderer(new AlumnoComboBox());
        jcbListaAlumnos.setSelectedIndex(-1);
        
    }
    
    private void armarCabecera() {
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOMBRE DE MATERIA");
        modelo.addColumn("NOTA");
        
        jtListaMateria.setModel(modelo);
    }
    
    private void limpiarTabla() {
        modelo.setRowCount(0);
    }
    
    private void actualizarTabla() {
        limpiarTabla();
        cargarMateriasInscriptas();
    }
    
    private void cargarMateriasInscriptas() {
        limpiarTabla();
        Alumno selectedAlumno = (Alumno) jcbListaAlumnos.getSelectedItem();
        double nota = 0;
        int idMateria = 0;
        
        List<Materia> matInscriptas = inscripcionData.obtenerMateriasCursadas(selectedAlumno.getIdAlumno());
        
        List<Inscripcion> inscrip = inscripcionData.obtenerInscripcion();
        
        for (Materia mat : matInscriptas) {
            idMateria = mat.getIdMateria();
            String nombreMat = mat.getNombre();
            for (Inscripcion inscripcion : inscrip) {
                if (inscripcion.getAlumno().getDni() == selectedAlumno.getDni()
                        && inscripcion.getMateria().getNombre().equals(nombreMat)) {
                    
                    nota = inscripcion.getNota(); //Se guarda en la variable la nota que tiene cargada la BD a traves del metodo obtenerInscripcion()
                }
            }

            // Agrega la fila a la tabla con el ID de la inscripción, nombre de la materia y nota
            modelo.addRow(new Object[]{idMateria, nombreMat, nota});
        }
        
    }
    
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
    
    private class ActualizarNotaDialog extends JDialog {
        
        private JButton guardar;
        private JButton cancelar;
        private JTextField JTnuevaNota;
        
        public ActualizarNotaDialog(JFrame parent, int idMateria, Alumno alumno) {
            super(parent, "Actualizar nota", true);
            
            guardar = new JButton("Guardar");
            guardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //Obtener nota ingresada
                        double nuevaNota = Double.parseDouble(JTnuevaNota.getText());
                        //Actualizar nota en la base de datos
                        inscripcionData.actualizarNota(alumno.getIdAlumno(), idMateria, nuevaNota);
                        //cerrar ventana
                        dispose();
                        // Actualizar la tabla en la ventana principal
                        actualizarTabla();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showConfirmDialog(ActualizarNotaDialog.this, "Ingrese una nota válida.");
                    }
                }
            });

            //botón cancelar 
            cancelar = new JButton("Cancelar ");
            cancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            
            JTnuevaNota = new JTextField(10);

            // Agregar componentes a la ventana emergente
            JPanel panel = new JPanel();
            panel.add(new JLabel("Nueva nota:"));
            panel.add(JTnuevaNota);
            panel.add(guardar);
            panel.add(cancelar);
            
            add(panel);
            
        }
    }
}
