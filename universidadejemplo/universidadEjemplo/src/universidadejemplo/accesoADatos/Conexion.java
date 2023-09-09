package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private String url;
    private String usuario;
    private String pass;
    public static Connection conexion = null; // es importante crear una variable de tipo connection

    public Conexion(String url, String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
        this.url = url;
    }

    public Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                //Aqui se establece la conexion por el método estático getConnection(), retornando un objeto 
                //de tipo Connection que se asigna a la variable conexion
                conexion = DriverManager.getConnection(url, usuario, pass);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver " + ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Conectar a BD " + ex);
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
}
