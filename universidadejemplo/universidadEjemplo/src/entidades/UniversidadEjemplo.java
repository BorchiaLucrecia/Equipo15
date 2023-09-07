package entidades;

import accesoadatos.Conexion;

public class UniversidadEjemplo {

    public static void main(String[] args) {
        Conexion ulp = new Conexion("jdbc:mariadb://localhost/universidadulp", "root", "");
        ulp.getConexion();
    }
}
