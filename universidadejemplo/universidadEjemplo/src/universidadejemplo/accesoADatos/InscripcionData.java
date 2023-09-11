
package universidadejemplo.accesoADatos;

import java.sql.Connection;
import universidadejemplo.entidades.Inscripcion;

public class InscripcionData {
    private Connection conexion;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
    }
    
    //GUARDAR INSCRIPCION
    public void guardarInscripcion(Inscripcion insc){
        
    }
    
    //BORRAR UNA INSCRIPCIÓN
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
    }
    
    //ACTUALIZAR UNA NOTA
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
    }
    
    //ArrayList con las Inscripciones
    
    //ArrayList con Inscripciones por Alumno
    
    //ArrayList con Materias cursadas por Alumnos listadas por id
    
    //ArrayList con Materias NO Cursadas por Alumno listadas por id
    
    //ArrayList de Alumnos inscriptos a cada Materia
    
}
