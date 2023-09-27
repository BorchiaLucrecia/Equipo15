package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.entidades.Alumno;
import universidadejemplo.entidades.Inscripcion;
import universidadejemplo.entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData matData= new MateriaData();
    private AlumnoData aluData=new AlumnoData();

    public InscripcionData() {
        con = Conexion.getConexion();
        matData= new MateriaData();
        aluData = new AlumnoData();
    }

    //GUARDAR INSCRIPCION (Inscripcion(Materia materia, Alumno alumno, nota)
    public void guardarInscripcion(Inscripcion insc) {
        try{
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";        
        
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción Exitosa");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al guardar la Inscripción");
        }
    }


//BORRAR UNA INSCRIPCIÓN
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int borrar = ps.executeUpdate();
            if (borrar == 1) {
                JOptionPane.showMessageDialog(null, "Inscripción Borrada");
            
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripción");
        }
    }

    //ACTUALIZAR UNA NOTA
    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota= ? WHERE idAlumno= ? AND idMateria= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int actualizar = ps.executeUpdate();
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
        
        ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getDouble("nota"));
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                listaInscripciones.add(insc);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(),
                    "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
        }

        return listaInscripciones;

    }

    //ArrayList con Inscripciones por Alumno (A qué materias se ha inscripto un alumno)
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
       
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getDouble("nota"));
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                inscripciones.add(insc);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede cargar una o más inscripciones");
        }
        return inscripciones;

    }

    //ArrayList con Materias cursadas por Alumnos listadas por id
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, "
                + "materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
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
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria NOT IN "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al mostrar materias NO cursadas");
        }

        return materias;

    }

    //ArrayList de Alumnos inscriptos a cada Materia
    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        
        ArrayList<Alumno> alumnosMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, apellido,nombre, fechaNacimiento, estado "
                + " FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado =1 ";
               
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al listar alumnos inscriptos a la materia " + idMateria);

        }
        return alumnosMateria;
    }
}
