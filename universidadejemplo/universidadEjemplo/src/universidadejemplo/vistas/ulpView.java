
package universidadejemplo.vistas;

import javax.swing.JOptionPane;

public class ulpView extends javax.swing.JFrame {

    public ulpView() {
        initComponents();
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema de gestión - ULP");
        this.setResizable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMformAlumno = new javax.swing.JMenu();
        jMformularioAlum = new javax.swing.JMenuItem();
        jMmateria = new javax.swing.JMenu();
        jMformularioMat = new javax.swing.JMenuItem();
        jMadministración = new javax.swing.JMenu();
        JMinscripciones = new javax.swing.JMenuItem();
        jMnotas = new javax.swing.JMenuItem();
        jMconsultas = new javax.swing.JMenu();
        jMalumxMateria = new javax.swing.JMenuItem();
        jMsalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane.setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jMformAlumno.setText("Alumno");

        jMformularioAlum.setText("Formulario Alumno");
        jMformularioAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMformularioAlumActionPerformed(evt);
            }
        });
        jMformAlumno.add(jMformularioAlum);

        jMenuBar1.add(jMformAlumno);

        jMmateria.setText("Materia");

        jMformularioMat.setText("Formulario Materia");
        jMformularioMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMformularioMatActionPerformed(evt);
            }
        });
        jMmateria.add(jMformularioMat);

        jMenuBar1.add(jMmateria);

        jMadministración.setText("Administración");

        JMinscripciones.setText("Inscripciones");
        JMinscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMinscripcionesActionPerformed(evt);
            }
        });
        jMadministración.add(JMinscripciones);

        jMnotas.setText("Notas");
        jMnotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnotasActionPerformed(evt);
            }
        });
        jMadministración.add(jMnotas);

        jMenuBar1.add(jMadministración);

        jMconsultas.setText("Consultas");

        jMalumxMateria.setText("Alumnos por Materia");
        jMalumxMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMalumxMateriaActionPerformed(evt);
            }
        });
        jMconsultas.add(jMalumxMateria);

        jMenuBar1.add(jMconsultas);

        jMsalir.setText("Salir");
        jMsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMsalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMsalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMformularioAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMformularioAlumActionPerformed
        // TODO add your handling code here:
        jDesktopPane.removeAll();
        jDesktopPane.repaint();

        // Crear una instancia del formulario de alumno
        GestionAlumno formularioAlumno = new GestionAlumno();
        formularioAlumno.setVisible(true);

        // Agregar el formulario de alumno al JDPEscritorio
        jDesktopPane.add(formularioAlumno);
        jDesktopPane.moveToFront(formularioAlumno);
    }//GEN-LAST:event_jMformularioAlumActionPerformed

    private void jMformularioMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMformularioMatActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();

        // Crear una instancia del formulario 
        GestionMateria formularioMateria = new GestionMateria();
        formularioMateria.setVisible(true);

        // Agregar el formulario de alumno al JDPEscritorio
        jDesktopPane.add(formularioMateria);
        jDesktopPane.moveToFront(formularioMateria);
    }//GEN-LAST:event_jMformularioMatActionPerformed

    private void JMinscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMinscripcionesActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();

        GestionInscripciones inscripcion = new GestionInscripciones();
        inscripcion.setVisible(true);

        jDesktopPane.add(inscripcion);
        jDesktopPane.moveToFront(inscripcion);
    }//GEN-LAST:event_JMinscripcionesActionPerformed

    private void jMnotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnotasActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();

        GestionNotas nota = new GestionNotas();
        nota.setVisible(true);

        // Agregar el formulario de alumno al JDPEscritorio
        jDesktopPane.add(nota);
        jDesktopPane.moveToFront(nota);
    }//GEN-LAST:event_jMnotasActionPerformed

    private void jMalumxMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMalumxMateriaActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();

        // Crear una instancia del formulario de alumno
        Consultas AlumnoxMat = new Consultas();
        AlumnoxMat.setVisible(true);

        // Agregar el formulario de alumno al JDPEscritorio
        jDesktopPane.add(AlumnoxMat);
        jDesktopPane.moveToFront(AlumnoxMat);
    }//GEN-LAST:event_jMalumxMateriaActionPerformed

    private void jMsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMsalirActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        int salir = JOptionPane.showConfirmDialog(null, "Desea Salir del Sistema? ");
        if (salir == 0) { //Si la opción es SI
            int exit = ulpView.EXIT_ON_CLOSE;
            System.exit(exit);
        }
    }//GEN-LAST:event_jMsalirActionPerformed

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
            java.util.logging.Logger.getLogger(ulpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ulpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ulpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ulpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ulpView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMinscripciones;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMadministración;
    private javax.swing.JMenuItem jMalumxMateria;
    private javax.swing.JMenu jMconsultas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMformAlumno;
    private javax.swing.JMenuItem jMformularioAlum;
    private javax.swing.JMenuItem jMformularioMat;
    private javax.swing.JMenu jMmateria;
    private javax.swing.JMenuItem jMnotas;
    private javax.swing.JMenu jMsalir;
    // End of variables declaration//GEN-END:variables
}
