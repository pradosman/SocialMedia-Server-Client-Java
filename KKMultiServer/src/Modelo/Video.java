/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author pradosmac
 */
public class Video {
    
    int idUsuario;
    int idVideo;
    String rutaserver;
    String titulo;
    Date fecha;
    String descripcion;
    String login;

    public Video(int idUsuario, String rutaserver, String titulo, Date fecha, String descripcion) {
        this.idUsuario = idUsuario;
        this.rutaserver = rutaserver;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Video(int idVideo, String login, String ruta, String titulo, Date fecha, String descripcion) {
        this.idVideo = idVideo;
        this.login = login;
        this.rutaserver = rutaserver;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Video() {
        
    }

    public Video(int idUsuario, String rutaserver, String titulo, String descripcion) {
        this.idUsuario = idUsuario;
        this.rutaserver = rutaserver;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRutaserver() {
        return rutaserver;
    }

    public void setRutaserver(String rutaserver) {
        this.rutaserver = rutaserver;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }
    
    
    
    
}
