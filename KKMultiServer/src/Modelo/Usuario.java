/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David Prados
 */
public class Usuario{
    
    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String login;
    private String password;
    
    public Usuario(String dni,String nombre ,String apellido1,String apellido2,String login,String password){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.login = login;
        this.password = password;
    }

    public Usuario() {
        this.dni = null;
        this.nombre = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.login = null;
        this.password = null;
    }
    
    /********GETS*********/
    public String getDni(){
        return this.dni;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido1(){
        return this.apellido1;
    }
    
    public String getApellido2(){
        return this.apellido2;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    /*********SETS************/
    public void setDni( String dni){
        this.dni = dni;
    }
    
    public void setNombre( String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido1( String apellido1){
        this.apellido1 = apellido1;
    }
    
    public void setApellido2( String apellido2){
        this.apellido2 = apellido2;
    }
    
    public void setLogin( String login){
        this.login = login;
    }
    
    public void setPassword( String password){
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
