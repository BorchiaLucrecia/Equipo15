package universidadejemplo.vistas;

import java.util.List;
import universidadejemplo.accesoADatos.InscripcionData;
import universidadejemplo.entidades.Alumno;
import universidadejemplo.entidades.Materia;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.accesoADatos.MateriaData;

public class Consultas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private MateriaData materiaData = new MateriaData();

    public Consultas() {
        initComponents();
        this.setSize(500, 500);
        this.setTitle("Sistema de CONSULTAS");
        cargarCombo();
        armarCabecera();
        limpiarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbListaMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaAlumnos = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("Listado de alumnos por materia");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccionar una materia:");

        jcbListaMateria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbListaMateriaItemStateChanged(evt);
            }
        });

        jtListaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jtListaAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jcbListaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbListaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbListaMateriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbListaMateriaItemStateChanged
        limpiarTabla();
        Materia matSeleccionada = (Materia) jcbListaMateria.getSelectedItem();
        InscripcionData idata = new InscripcionData();
        List<Alumno> alumnos = idata.obtenerAlumnosXMateria(matSeleccionada.getIdMateria());
        for (Alumno alumno : alumnos) {

            int id = alumno.getIdAlumno();
            int dni = alumno.getDni();
            String apellido = alumno.getApellido();
            String nombre = alumno.getNombre();

            modelo.addRow(new Object[]{id, dni, apellido, nombre});
        }
    }

    private void cargarCombo() {
        // Obtener la lista de alumnos desde AlumnoData
        List<Materia> materias = materiaData.listarMaterias();
        for (Materia materia : materias) {
            jcbListaMateria.addItem(materia);
        }
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("NOMBRE");
        jtListaAlumnos.setModel(modelo);
    }

    private void limpiarTabla() {
        for (int f = modelo.getRowCount() - 1; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }//GEN-LAST:event_jcbListaMateriaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Materia> jcbListaMateria;
    private javax.swing.JTable jtListaAlumnos;
    // End of variables declaration//GEN-END:variables

}
