/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import Modelo.UsuarioModel;
import Modelo.Validador;
import Modelo.Video;
import Vista.GUI;
import java.io.File;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Prados
 */
public class UsuarioController {
    
    UsuarioModel uModel = new UsuarioModel();
    private static Conexion conexion;
    private static Validador validador = new Validador();
    private static GUI ventana = new GUI();
    ArrayList <Usuario> usuarios = new ArrayList();
    ArrayList <Video> videos = new ArrayList();
    
    
    
    public ArrayList<Usuario> getUsuarios() throws ClassNotFoundException, SQLException{
        
        conexion = new Conexion();
        java.sql.Connection conn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        
        String query = "SELECT * FROM usuarios";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String dni = rs.getString("DNI");
                String nombre = rs.getString("NAME");
                String apellido1 = rs.getString("LASTNAME1");
                String apellido2 = rs.getString("LASTNAME2");
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                
                Usuario u = new Usuario(dni,nombre,apellido1,apellido2,login,password);
                usuarios.add(u);
            }
            conn.close();
            rs.close();
            st.close();
            System.out.println("Usuarios recogidos");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public ArrayList<Video> getVideos() throws ClassNotFoundException, SQLException{
        
        conexion = new Conexion();
        java.sql.Connection conn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        
        String query = "SELECT * FROM usuarios u, videos v WHERE u.id = v.idusuario";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                int idVideo = rs.getInt("idvideo");
                System.out.println("idVideo: " + idVideo);
                String login = rs.getString("login");
                System.out.println("Login: " + login);
                String ruta = rs.getString("rutaserver");
                System.out.println("Ruta: " + ruta);
                String titulo = rs.getString("titulo");
                System.out.println("Titulo: " + titulo);
                Date fecha = rs.getDate("fecha");
                String descripcion = rs.getString("descripcion");
                System.out.println("Descripcion: " + descripcion);
                
                Video v = new Video(idVideo,login,ruta,titulo,fecha,descripcion);
                videos.add(v);
            }
            conn.close();
            rs.close();
            st.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
        return videos;
    }
    
    public String cadenaVideos(ArrayList<Video> videos){
        String cadena = null;
        
        
        
        return cadena;
    
    }
    
    public void mostrarTabla( JTable jTable1) throws ClassNotFoundException, SQLException{
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.setColumnIdentifiers(new Object[]{"DNI","NOMBRE","APELLIDO1",
                                                "APELLIDO2","LOGIN","PASSWORD"});
        for(int i=0; i < usuarios.size(); i++){
            modeloTabla.addRow(new Object[]{usuarios.get(i).getDni(),
                                usuarios.get(i).getNombre(),
                                usuarios.get(i).getApellido1(),
                                usuarios.get(i).getApellido2(),
                                usuarios.get(i).getLogin(),
                                usuarios.get(i).getPassword()});
            }
        jTable1.setModel(modeloTabla);
               
    }
    
    public GUI getVentana() {
	return ventana;
    }
    
    public void setVentana(GUI ventana) {
	this.ventana = ventana;
    }
    
    public Validador getValidador() {
	return validador;
    }
    
    public void setValidador(Validador validador) {
	this.validador = validador;
    }
    
    public void registrarUsuario(Usuario u) {
	validador.validarRegistro(u);
    }
	
    public Usuario buscarUsuario(String login) {
	return validador.validarBusqueda(login);
    }
	
    public void modificarUsuario(Usuario u) {
	validador.validarModificacion(u);
    }
    
    public void eliminarUsuario(String dni) {
    	validador.validarEliminacion(dni);
    }

    public void mostrarVideos(JTable jTable1, String cadena) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        String[] strings = cadena.split("#");
        String [] datosUsuario = new String[strings.length];
        
        for(int i = 0; i < strings.length; i++){
            datosUsuario = strings[i].split("@");
            for(int j = 1; j < datosUsuario.length; j++){
                String[] datosVideo = datosUsuario[j].split("&");
                String[] conjuntoDatos = {datosUsuario[0], datosVideo[0], datosVideo[1], datosVideo[2]};
                modelo.addRow(conjuntoDatos);
            }
        }
    }
    
    public Video buscarVideo(int id){
        Conexion conn = new Conexion();
	Video v = new Video();
	boolean existe = false;
	try {
		//Statement update = conn.getConnection().createStatement();
            PreparedStatement consulta = conn.getConnection().prepareStatement("SELECT * FROM videos where idvideo = ? ");
            consulta.setInt(1, id);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
                existe = true;
                v.setIdVideo(rs.getInt("idvideo"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setRutaserver(rs.getString("rutaserver"));
                v.setTitulo(rs.getString("titulo"));
                v.setFecha(rs.getDate("fecha"));
                v.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            conn.desconectar();
			
					
	} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
	}
	if (existe) {
            return v;
	}else 
            return null;
    }
    
    //public void enviarPaquetes()

    public void subirVideo(Video v) {
            Conexion conn = new Conexion();	
	try {
            
                String sql = "INSERT INTO videos (idusuario, rutaserver, titulo, descripcion) VALUES (?, ?, ?, ?)";
		PreparedStatement st = conn.getConnection().prepareStatement(sql);
                System.out.println("IDUSUARIO: " + v.getIdUsuario());
		st.setInt(1, v.getIdUsuario());
                st.setString(2, v.getRutaserver()+".mp4");
                st.setString(3, v.getTitulo());
                st.setString(4, v.getDescripcion());
                st.executeUpdate();
		//JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
		st.close();
		conn.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "No se ha registrado");
	}
    }

    public void borrarVideo(String idVideo) {
        /*
        Video v = buscarVideo(Integer.parseInt(idVideo));
        File file = new File(v.getRutaserver());
        if(file.exists())
            file.delete();
        */
        Conexion conex= new Conexion();
	try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("DELETE FROM videos WHERE idvideo='"+idVideo+"'");
            System.out.println("Video borrado correctamente");
            st.close();
            conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
	}
        
    }
    
}
