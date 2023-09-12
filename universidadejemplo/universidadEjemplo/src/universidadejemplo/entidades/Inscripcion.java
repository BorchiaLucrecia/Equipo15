package universidadejemplo.entidades;

public class Inscripcion {

    int idInscripcion;
    Materia materia;
    Alumno alumno;
    int nota;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, Materia materia, Alumno alumno, int nota) {
        this.idInscripcion = idInscripcion;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion(Materia materia, Alumno alumno, int nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion(int nota) {
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        String insc= "INSCRIPCIÓN: "+ alumno.getApellido()+", "+ alumno.getNombre()+", "+ materia.getNombre()+"";
        return insc;
    }
    
    

}