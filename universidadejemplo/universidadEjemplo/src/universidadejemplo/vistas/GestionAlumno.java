/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.vistas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import universidadejemplo.accesoADatos.AlumnoData;
import universidadejemplo.entidades.Alumno;

/**
 *
 * @author borch
 */
public class GestionAlumno extends javax.swing.JInternalFrame {
      private AlumnoData alumnoData = new AlumnoData();
      private Alumno alumno=null;
      private int idAlumno;
    /**
     * Creates new form cargarAlumno
     */
    public GestionAlumno() {
        initComponents();
        this.setSize(500,500);
        this.setTitle("Sistema de gestión ALUMNOS");
        limpiarCampos();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jDateChooser1.setDateFormatString("dd/MM/yyyy");
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFDni = new javax.swing.JTextField();
        jTFapellido = new javax.swing.JTextField();
        jTFnombre = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jBbuscarAlum = new javax.swing.JButton();
        jBguardarAlum = new javax.swing.JButton();
        jBeliminarAlum = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Sistema de gestión de Alumnos");
        setPreferredSize(new java.awt.Dimension(360, 380));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Ingresar documento del alumno:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        jBbuscarAlum.setText("Buscar");
        jBbuscarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarAlumActionPerformed(evt);
            }
        });

        jBguardarAlum.setText("Guardar");
        jBguardarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarAlumActionPerformed(evt);
            }
        });

        jBeliminarAlum.setText("Eliminar");
        jBeliminarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarAlumActionPerformed(evt);
            }
        });

        jButton1.setText("Nueva consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Ingresar datos personales del alumno:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 179, Short.MAX_VALUE)
                                .addComponent(jBeliminarAlum)
                                .addGap(44, 44, 44)
                                .addComponent(jBguardarAlum))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBbuscarAlum)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(jTFapellido)
                                    .addComponent(jTFnombre))))
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBbuscarAlum)
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBeliminarAlum)
                    .addComponent(jBguardarAlum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBbuscarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarAlumActionPerformed
        // TODO add your handling code here:
        int dni;
        String doc =jTFDni.getText();
        
      // Verifica si el campo de texto está vacío  
        if(doc.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Por favor ingrese un DNI valido");
        return;
        }
        try{
      // valor del campo de texto a un entero
            dni=Integer.parseInt(doc);
            if(doc.length()!=8){
                JOptionPane.showMessageDialog(null,"El dni debe tener ocho digitos");
                return;
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "El dni debe ser un numero entero");
            return;
        }
        
         Alumno estudiante = new AlumnoData().buscarAlumnoPorDni(dni);
         if (estudiante!=null){
          alumno = estudiante;
          jTFapellido.setText(estudiante.getApellido());
          jTFnombre.setText(estudiante.getNombre());
         
         //devuelve fecha en el Chooser
          LocalDate fechaNacimiento=estudiante.getFechaNacimiento();
          java.util.Date fechaUtil=java.sql.Date.valueOf(fechaNacimiento);
          
          jDateChooser1.setDate(fechaUtil);
        
     // Habilitar el botón "Eliminar" una vez que se encuentra un alumno
          jBeliminarAlum.setEnabled(true);     
        }else{
            JOptionPane.showMessageDialog(null,"No se encontro al alumno");
        }
    }//GEN-LAST:event_jBbuscarAlumActionPerformed

    private void jBguardarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarAlumActionPerformed
        // TODO add your handling code here:
        
    //Obtengo los datos del formulario:
     try{  
         String dniText = jTFDni.getText();
        if ( dniText.length() !=8){
            JOptionPane.showConfirmDialog(this, "El DNI debe tener ocho números, sin puntos ni espacios.");
            return;
        }
        int dni = Integer.parseInt(dniText);
        String apellido = jTFapellido.getText();
        String nombre = jTFnombre.getText();
        
        if (nombre.isEmpty()|| apellido.isEmpty()){
            JOptionPane.showMessageDialog(this,"No pueden haber campos vacios");
            return;
        }
        
        LocalDate fechaNacimiento = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        boolean estado = true;
        
        if (alumno == null){
            int respuesta =  JOptionPane.showConfirmDialog(this, "¿Desea guardar un nuevo alumno?",
                                                          "Confirmar Guardar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
            Alumno alumno = new Alumno(dni, apellido, nombre, fechaNacimiento,estado);
            alumnoData.guardarAlumno(alumno);
            JOptionPane.showMessageDialog(this, "Alumno guardado exitosamente");
            }
        }else{
             int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar los datos del alumno?\n\n" +
                                                          "Datos anteriores:\n" +
                                                          "DNI: " + alumno.getDni() + "\n" +
                                                          "Apellido: " + alumno.getApellido() + "\n" +
                                                          "Nombre: " + alumno.getNombre() + "\n" +
                                                          "Fecha de Nacimiento: " + alumno.getFechaNacimiento() + "\n\n" +
                                                          "Nuevos datos:\n" +
                                                          "DNI: " + dni + "\n" +
                                                          "Apellido: " + apellido + "\n" +
                                                          "Nombre: " + nombre + "\n" +
                                                          "Fecha de Nacimiento: " + fechaNacimiento,
                                                          "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                alumno.setDni(dni);
                alumno.setApellido(apellido);
                alumno.setNombre(nombre);
                alumno.setFechaNacimiento(fechaNacimiento);
                alumnoData.modificarAlumno(alumno);
                JOptionPane.showMessageDialog(this, "Alumno modificado exitosamente");
            }
        }
     }catch(NumberFormatException nfe){
         JOptionPane.showMessageDialog(this, "Debe ingresar un DNI valido");
     }catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al procesar la solicitud: " + e.getMessage());
    }
       
       // Limpio los campos de texto:
       limpiarCampos();
        
    }//GEN-LAST:event_jBguardarAlumActionPerformed

    
    private void jBeliminarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarAlumActionPerformed
        // TODO add your handling code here:
      // Verificar si hay un alumno cargado para eliminar
    if (alumno != null) {
        // Preguntar al usuario si está seguro de eliminar al alumno
        String mensaje = "¿Seguro que desea eliminar al alumno?\n\n" +
                "DNI: " + alumno.getDni() + "\n" +
                "Apellido: " + alumno.getApellido() + "\n" +
                "Nombre: " + alumno.getNombre() + "\n" +
                "Fecha de nacimiento: " + jDateChooser1.getDate();

        int respuesta = JOptionPane.showOptionDialog(null, mensaje, "Confirmar Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Aceptar", "Cancelar"}, "Aceptar");

        if (respuesta == JOptionPane.YES_OPTION) {
            // Eliminar el alumno de la base de datos
            AlumnoData alumnoData = new AlumnoData();
            alumnoData.eliminarAlumno(alumno.getIdAlumno());

            // Mostrar un mensaje de confirmación
            JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado de la base de datos");

            // Limpiar campos después de eliminar
            jTFDni.setText("");
            jTFapellido.setText("");
            jTFnombre.setText("");
            jDateChooser1.setDate(null);
            alumno = null;
            jBeliminarAlum.setEnabled(false); // Desactivar el botón de eliminar
        }
    } else {
        // Si no hay un alumno cargado, mostrar un mensaje de advertencia
        JOptionPane.showMessageDialog(null, "No hay ningún alumno cargado para eliminar");
    }
    
    }//GEN-LAST:event_jBeliminarAlumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         limpiarCampos();
         alumno = null;
    }//GEN-LAST:event_jButton1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscarAlum;
    private javax.swing.JButton jBeliminarAlum;
    private javax.swing.JButton jBguardarAlum;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFapellido;
    private javax.swing.JTextField jTFnombre;
    // End of variables declaration//GEN-END:variables

private String formatDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(date);
}

private void limpiarCampos(){
    jTFDni.setText("");
    jTFnombre.setText("");
    jTFapellido.setText("");
    jDateChooser1.setDate(null);
}

}
