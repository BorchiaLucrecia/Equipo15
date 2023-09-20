/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.entidades.Materia;

/**
 *
 * @author borch
 */
public class MateriaData {
    private Connection con =null;

    public MateriaData() {
        con= Conexion.getConexion();
    }
    public void guardarMateria(Materia materia){
        String sql= "INSERT INTO materia(nombre, anio, estado) VALUES ('?','?','?')";
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isEstado());
            
            ps.executeUpdate(); 
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia ingresada correctamente");
                
            }
            ps.close();
                    
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERROR: No se puede acceder a la tabla materia");
            
        }
    }
    
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre=?, anio=?, estado=? WHERE idMateria=?";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isEstado());
            
            int modMateria = ps.executeUpdate();
                if (modMateria==1) {
                    JOptionPane.showMessageDialog(null,"Cambios cargados en Materia");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar materia");
        }
       
        
    }
   public Materia buscarMateria (int id){
       Materia materia = null;
       
       String sql = "SELECT nombre, anio FROM materia WHERE idMateria=? AND estado =1 ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                materia =new Materia();
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));   
            }else JOptionPane.showMessageDialog(null,"No se encontro la materia en la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar buscar una materia");
        }
       
       return materia;
   }
   public void eliminarMateria (int id){
       String sql = "UPDATE `materia` SET estado=0 WHERE idMateria=? ";
       
       PreparedStatement ps;
        try {
            
            ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             int elimMateria = ps.executeUpdate();
             if(elimMateria==1){
                 JOptionPane.showMessageDialog(null, "Materia eliminada");
             }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar materia");
        }
      
   }
   public List <Materia> listarMaterias (){
       ArrayList <Materia> materias=new ArrayList<>();
       String sql = "SELECT nombre, anio FROM materia WHERE estado=1";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setEstado(true);
                materias.add(materia);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar Materia");
        }
       
       return materias;
   }
}
 
