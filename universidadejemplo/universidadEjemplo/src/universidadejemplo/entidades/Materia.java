
package universidadejemplo.entidades;

public class Materia {
    int idMateria;
    String nombre;
    int anioMateria;
    boolean estado;

    public Materia() {
    }

    public Materia(String nombre, int anioMateria, boolean estado) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.estado = estado;
        if(estado==true){
    estadoString="Activa";
}else estadoString="Inactiva";
    }

    
    public Materia(int idMateria, String nombre, int anioMateria, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.estado = estado;
        if(estado==true){
    estadoString="Activa";
}else estadoString="Inactiva";
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public boolean isEstado() {
        
        if(estado==true){
    estadoString="Activa";
}else estadoString="Inactiva";
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
        if(estado==true){
    estadoString="Activa";
}else estadoString="Inactiva";
    }   
String estadoString;

    @Override
    public String toString() {
        return idMateria + " - " + nombre + " - Año: " + anioMateria + " - Estado: " + estadoString;
    }
    
}
