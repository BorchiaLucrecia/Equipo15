package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


// Cambios en el codigo segun las indicaciones de la guia y teoria. 
// Para crear un objeto PreparedStatement 
// usamos el patron de diseño singleton que permite crear una unica instancia de una clase
//  y acceder a ella de forma global.
   
public class Conexion {
//Esta clase debe tener una conexion y brindar un punto global de acceso.
    // LAS CONSTANTES VAN EN MAYUSCULA Y SON FINAL. 
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="universidadulp";
 // Por defecto el usuario es root.
    private static final String USUARIO="root";
    private static final String PASSWORD="";
 //Atributo que utilizan las clases data, para enviar secuencias sql a la BD.
    private static Connection connection;
    
    private Conexion(){}
    
 //Metodo que devuelve un objeto tipo Connection
    //FUNCION:
    public static Connection getConexion(){
     
      if(connection==null){
          
          try {
              Class.forName("org.mariadb.jdbc.Driver");
              connection= DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
          
          
          } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null,"ERROR: No se pueden cargar los driver");
              
          } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: No se puede conectar a la BASE DE DATOS");
          }     
      }
      return connection;
    }
}
