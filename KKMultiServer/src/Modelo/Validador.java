/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.UsuarioController;
import javax.swing.JOptionPane;

/**
 *
 * @author David Prados
 */
public class Validador {
    
    private UsuarioController controlador;
    public static boolean validarbusqueda = false;
    public static boolean validarmodificacion = false;
    
    public void validarRegistro(Usuario u) {
		UsuarioModel uModel;
		if (u.getDni().length() == 9) {
			uModel = new UsuarioModel();
			uModel.registrarUsuario(u);						
		}else
                    JOptionPane.showMessageDialog(null,"EL dni debe ser de 9 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
    }
    
    public Usuario validarBusqueda(String login) {
		UsuarioModel uModel;
		
		try {
			uModel = new UsuarioModel();
			
			return uModel.buscarUsuario(login);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			validarbusqueda = false;
		}
					
		return null;
    }
    
    public void validarModificacion(Usuario u) {
		UsuarioModel uModel;
		if (u.getNombre().length() < 30 && u.getNombre().length() >= 3) {
			uModel = new UsuarioModel();
			uModel.modificarUsuario(u);	
			validarmodificacion = true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser menor a 30 digitos y mayor a 3","Advertencia",JOptionPane.WARNING_MESSAGE);
			validarmodificacion = false;
		}
    }
    
    public void validarEliminacion(String dni) {
		UsuarioModel uModel = new UsuarioModel();
                if(!dni.equals(""))
                    uModel.eliminarUsuario(dni);
                else
                    JOptionPane.showMessageDialog(null,"Introduzca un DNI correcto","Advertencia",JOptionPane.WARNING_MESSAGE);
    }
    
    public void setControlador(UsuarioController controlador) {
		this.controlador = controlador;
		
    }
    
}
