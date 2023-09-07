package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private String url;
    private String usuario;
    private String pass;
    private static Connection conexion = null; // es importante crear una variable de tipo connection

    public Conexion(String url, String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
        this.url = url;
    }

    public Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, pass);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver " + ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Conectar a BD " + ex);
            }
        }
        return conexion;
    }
}
