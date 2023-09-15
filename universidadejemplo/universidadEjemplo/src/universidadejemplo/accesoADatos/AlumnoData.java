/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.entidades.Alumno;

/**
 *
 * @author borch
 */
//Esta clase va a tener metodos para interactuar con la tabla ALUMNO. 
public class AlumnoData {

    //objeto que van a usar TODOS LOS METODOS de la clase data para 
    // interactuar : eliminar, modificar, etc. 
    private Connection con = null;

    // Constructor que inicializa la variable: con
    public AlumnoData() {
        con = Conexion.getConexion();
    }

    //TAREA: HACER INSERT    
    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento,estado) VALUE(?,?,?,?,?)";

        //Genero el objeto preparedStatement y me devuelve las listas de las claves(id)
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Reemplazo los (???) con los datos que necesito:
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            // Transformo LocalDate en Date(paquete java.sql) con valueOF.
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            //Ejecuto:
            ps.executeUpdate();

            //Tabla con los id de la cant. de alumnos.
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                // 1(uno): refiere a la columna de los id.
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno registrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: No se puede acceder a la tabla alumno");
        }

    }

    //Actualizar informacion de un alumno de la BD. 
    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //Modifico las (?)  
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());

            //Devuelve un entero   
            int modAlumno = ps.executeUpdate();
            if (modAlumno == 1) {
                JOptionPane.showMessageDialog(null, "Cambios cargados en alumno");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: No se puede acceder a la tabla alumno");
        }
    }

    //Remove logico, solo cambia el estado del alumno 
    //          1(activo) or 0 (Desactivado).
    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno =?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int elimAlumno = ps.executeUpdate();
            if (elimAlumno == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede acceder a la tabla alumno");
        }

    }

    // Recupera un alumno-Verifica que el estado se 1(activo)
    public Alumno buscarAlumno(int id) {

        String sql = "SELECT dni, apellido,nombre, fechaNacimiento FROM alumno WHERE idAlumno =? AND estado =1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "El alumno indicado no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede acceder a la tabla alumno");
        }
        return alumno;
    }

    // Busca un alumno por su número de documento (DNI) y devuelve un objeto Alumno.
    public Alumno buscarAlumnoPorDni(int dni) {

        String sql = "SELECT idAlumno, dni, apellido, nombre,fechaNacimiento FROM alumno WHERE dni=? AND estado=1 ";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "El alumno indicado no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede acceder a la tabla alumno");
        }
        return alumno;
    }

// Devuelve una lista de todos los alumnos activos en la base de datos. 
    public List<Alumno> listarAlumno() {
        String sql = "SELECT idAlumno, dni, apellido, nombre,fechaNacimiento FROM alumno WHERE estado=1 ";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:No se puede acceder a la tabla alumno");
        }
        return alumnos;
    }
}
