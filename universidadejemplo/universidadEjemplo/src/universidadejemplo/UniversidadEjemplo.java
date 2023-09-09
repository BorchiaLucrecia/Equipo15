package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import universidadejemplo.accesoADatos.Conexion;

public class UniversidadEjemplo {

    public static void main(String[] args) {
        //Se crea una nueva conexión utilizando la clase Conexion y el método getConexion()
        Conexion ulp = new Conexion("jdbc:mariadb://localhost/universidadulp", "root", "");
        ulp.getConexion();

        //Inserción de PRUEBA EN LA CLASE TEST de la Base de Datos
        try {
            String insertar = "INSERT INTO test(nombre, estado) VALUES ('Juan Perez',true)";
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp", "root", "");
            Statement sql = conexion.createStatement();
            sql.executeUpdate(insertar);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar Base de Datos " + ex);
        }
    }
}
