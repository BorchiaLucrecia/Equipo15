package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemplo.entidades.Alumno;
import universidadejemplo.entidades.Inscripcion;
import universidadejemplo.entidades.Materia;

public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
    }

    //GUARDAR INSCRIPCION (Inscripcion(Materia materia, Alumno alumno, nota)
    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inscripción Exitosa");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la Inscripción");
        }

    }

    //BORRAR UNA INSCRIPCIÓN
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE ? AND ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int borrar = ps.executeUpdate(sql);
            if (borrar == 1) {
                JOptionPane.showMessageDialog(null, "Inscripción Borrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar la Inscripción");
        }
    }

    //ACTUALIZAR UNA NOTA
    public void actualizarNota(int idAlumno, int idMateria, double nota) {

    }

    //ArrayList con las Inscripciones
    /*SELECT idInscripto, nota, alumno.nombre, alumno.apellido, alumno.dni, alumno.fechaNacimiento,alumno.estado, materia.nombre, materia.anio, materia.estado FROM `inscripcion`
    //JOIN alumno ON inscripcion.idInscripto=alumno.idAlumno
    //JOIN materia ON inscripcion.idMateria=materia.idMateria;*/
    
    public List<Inscripcion> obtenerInscripcion(){
     String sql="SELECT idInscripto, nota, alumno.nombre, alumno.apellido, alumno.dni, alumno.fechaNacimiento,alumno.estado, materia.nombre, materia.anio, materia.estado FROM `inscripcion`\n" +
    "JOIN alumno ON inscripcion.idInscripto=alumno.idAlumno\n" +
    "JOIN materia ON inscripcion.idMateria=materia.idMateria;";
      ArrayList<Inscripcion> inscripciones=new ArrayList<>();
      Alumno alm = new Alumno();
      Materia mat = new Materia();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
          
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              
               Inscripcion inscripcion=new Inscripcion();
               inscripcion.setIdInscripcion(rs.getInt("idInscripto"));
               inscripcion.setNota(rs.getInt("nota"));
               alm.setApellido(rs.getString("apellido"));
               alm.setNombre(rs.getString("nombre"));
               alm.setDni(rs.getInt("dni"));
               /*alm.setFechaNacimiento.(rs.getDate("fechaNacimiento"));*/
               alm.setEstado(true);
               mat.setNombre(rs.getString("nombre"));
               mat.setAnioMateria(rs.getInt("anio"));
               mat.setEstado(true);
               inscripcion.setAlumno(alm);
               inscripcion.setMateria(mat);
               
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERROR:No se puede acceder a la tabla alumno");
        }
        return inscripciones;
        
    }
    //ArrayList con Inscripciones por Alumno
    //ArrayList con Materias cursadas por Alumnos listadas por id
    //ArrayList con Materias NO Cursadas por Alumno listadas por id
    //ArrayList de Alumnos inscriptos a cada Materia
}
