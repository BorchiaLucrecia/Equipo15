package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

        //Hay que hacer el for y el if para que no se duplique una inscripcion
        for (Inscripcion ins : obtenerInscripcion()) {

        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, insc.getNota());
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
        String sql = "UPDATE inscripcion SET nota= ? WHERE idAlumno= ?,idMateria= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int actualizar = ps.executeUpdate(sql);
            if (actualizar == 1) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada Correctamente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar la Nota");
        }
    }

    //ArrayList con las Inscripciones
    public List<Inscripcion> obtenerInscripcion() {
        Inscripcion insc = null;
        List<Inscripcion> listaInscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
            while (rs.next()) {
                insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getDouble("nota"));
                insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
                insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
                listaInscripciones.add(insc);
                
                stp.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), 
                    "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
        }

        return listaInscripciones;

    }

    //ArrayList con Inscripciones por Alumno (A qué materias se ha inscripto un alumno)
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        String sql = "SELECT alumno.nombre, alumno.apellido, alumno.dni, "
                + "materia.nombre, materia.anio "
                + "FROM `inscripcion` JOIN alumno ON inscripcion.idInscripto= ? "
                + "JOIN materia ON inscripcion.idMateria=materia.idMateria";

        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        Alumno alm = new Alumno();
        Materia mat = new Materia();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();
                alm.setNombre(rs.getString("nombre"));
                alm.setApellido(rs.getString("apellido"));
                alm.setDni(rs.getInt("dni"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));
                inscripcion.setAlumno(alm);
                inscripcion.setMateria(mat);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede cargar una o más inscripciones");
        }
        return inscripciones;

    }

    //ArrayList con Materias cursadas por Alumnos listadas por id
    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();
        String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, "
                + "materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede cargar una o más inscripciones");
        }
        return materias;
    }
    //ArrayList con Materias NO Cursadas por Alumno listadas por id

    //ArrayList de Alumnos inscriptos a cada Materia
}
