/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextArea;

/**
 *
 * @author David Prados
 */
public class UsuarioModel {
    
    public void registrarUsuario(Usuario u){
        Conexion conn = new Conexion();	
	try {
            
                String sql = "INSERT INTO usuarios (DNI, NAME, LASTNAME1, LASTNAME2, LOGIN, PASSWORD) VALUES (?,?,?,?,?,?)";
		PreparedStatement st = conn.getConnection().prepareStatement(sql);
                
		st.setString(1, u.getDni());
                st.setString(2, u.getNombre());
                st.setString(3, u.getApellido1());
                st.setString(4, u.getApellido2());
                st.setString(5,u.getLogin());
                st.setString(6, u.getPassword());
                st.executeUpdate();
		//JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conn.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "No se ha registrado");
	}
    }
    
    public Usuario buscarUsuario(String login){
        
	Conexion conn = new Conexion();
	Usuario u = new Usuario();
	boolean existe = false;
	try {
		//Statement update = conn.getConnection().createStatement();
            PreparedStatement consulta = conn.getConnection().prepareStatement("SELECT * FROM usuarios where login = ? ");
            consulta.setString(1, login);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
                existe = true;
                u.setId(rs.getInt("ID"));
                u.setDni(rs.getString("DNI"));
                u.setNombre(rs.getString("NAME"));
                u.setApellido1(rs.getString("LASTNAME1"));
                u.setApellido2(rs.getString("LASTNAME2"));
                u.setLogin(rs.getString("LOGIN"));
                u.setPassword(rs.getString("PASSWORD"));
            }
            rs.close();
            conn.desconectar();
			
					
	} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
	}
	if (existe) {
            return u;
	}else 
            return null;				
    }
    
    public void modificarUsuario(Usuario u) {
		
	Conexion conex = new Conexion();
	try{
            String consulta="UPDATE usuarios SET DNI= ? ,NAME = ? , LASTNAME1=? , LASTNAME2=? , LOGIN= ?, PASSWORD= ? WHERE DNI= ?";
            PreparedStatement update = conex.getConnection().prepareStatement(consulta);
			
            update.setString(1, u.getDni());
            update.setString(2, u.getNombre());
            update.setString(3, u.getApellido1());
            update.setString(4, u.getApellido2());
            update.setString(5,u.getLogin());
            update.setString(6, u.getPassword());
            update.setString(7, u.getDni());
            update.executeUpdate();

            JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void eliminarUsuario(String dni){
	Conexion conex= new Conexion();
	try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("DELETE FROM usuarios WHERE dni='"+dni+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Elimino");
	}
    }
    
}
