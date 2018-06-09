package kkmultiserver;

import Controlador.UsuarioController;
import Modelo.Usuario;
import Modelo.Video;
import java.net.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnockKnockProtocol {

    UsuarioController controlador = new UsuarioController();
    ArrayList<Video> videos = new ArrayList();
    String idVideo;
    String[] fromClientCut;
    int length = 0;
    boolean readyToUp = false;
    int idUsuario;
    String login;
    String rutaserver;
    String titulo;
    String descripcion;

    public String processInput(String theInput, PrintWriter out, BufferedReader in, ArrayList<KKMultiServerThread> clientes) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        String theOutput = null;

        if (theInput.equals(null)) {
            theOutput = "Conectado";
        }

        String[] strings = theInput.split("#");
        
        if(theInput.contains("DELETE_VIDEO")){
                idVideo = strings[2];
                broadcast(clientes,idVideo);
        }
        
        if(theInput.contains("BROADCASTING")){
            controlador.borrarVideo(strings[3]);
        }

        if (readyToUp == true) {
            fromClientCut = theInput.split("#");

            byte[] bytes;
            byte[] total_bytes;
            boolean exit = true;
            
            
            rutaserver = "users/"+controlador.buscarUsuario(login).getId()+"/videos/"+titulo;

            FileOutputStream fileout = new FileOutputStream(rutaserver+".mp4");

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            do {
                System.out.println(theInput);
                bytes = java.util.Base64.getDecoder().decode(fromClientCut[2].getBytes());
                output.write(bytes);
                //System.out.println(output.size() + " " + length);
                if ((length - output.size()) <= 0) {
                    exit = false;
                } else {
                    theInput = in.readLine();
                    fromClientCut = theInput.split("#");
                }
            } while (exit);

            try {
                total_bytes = output.toByteArray();
                fileout.write(total_bytes);
                fileout.close();
                readyToUp = false;
            } catch (Exception e) {
            }
            
           
            Video v = new Video(controlador.buscarUsuario(login).getId(),rutaserver,titulo,descripcion);
            this.controlador.subirVideo(v);
            theOutput = "Video subido";

        } else {

            if (strings[1].equals("REGISTER")) {
                Usuario u = new Usuario();
                u.setDni(strings[2]);
                u.setNombre(strings[3]);
                u.setApellido1(strings[4]);
                u.setApellido2(strings[5]);
                u.setLogin(strings[6]);
                u.setPassword(strings[7]);

                controlador.registrarUsuario(u);

                theOutput = "PROTOCOLCRISTOTUBE1.0#OK#REGISTERED";
            } else if (strings[1].equals("LOGIN")) {
                boolean logeado = false;
                Usuario u = controlador.buscarUsuario(strings[2]);
                
                if (u.getLogin().equals(strings[2]) && u.getPassword().equals(strings[3])) {
                    logeado = true;
                }

                if (logeado) {
                    theOutput = "PROTOCOLCRISTOTUBE1.0#OK#USER_LOGGED#" + u.getDni()
                            + "#" + u.getNombre()
                            + "#" + u.getApellido1()
                            + "#" + u.getApellido2()
                            + "#" + u.getLogin();
                    login = u.getLogin();
                    this.idUsuario = u.getId();
                } else {
                    theOutput = "PROTOCOLCRISTOTUBE1.0#ERROR#BAD_LOGIN";
                }
            } else if (strings[2].equals("GETVIDEO")) {
                Video v = controlador.buscarVideo(Integer.parseInt(strings[3]));
                idVideo = strings[3];
                File tempFile = new File(v.getRutaserver());
                theOutput = "PROTOCOLCRISTOTUBE1.0#OK#VIDEO_FOUND#" + v.getIdVideo() + "#" + tempFile.length() + "#" + 1024;
            } else if (strings[2].equals("GET_ALL")) {
                videos = controlador.getVideos();
                String mensaje = "";
                for (int i = 0; i < videos.size(); i++) {
                    mensaje = mensaje + "#" + videos.get(i).getLogin()
                            + "@" + videos.get(i).getIdVideo() + "&" + videos.get(i).getTitulo() + "&" + videos.get(i).getDescripcion();
                }

                mensaje = "PROTOCOLCRISTOTUBE1.0#GET_ALL_RESPONSE#" + strings[1] + mensaje;

                theOutput = mensaje;
            } else if (strings.length > 4 && strings[3].equals("PREPARED_TO_RECEIVE")) {
                
                Video v = controlador.buscarVideo(Integer.parseInt(idVideo));
                File tempFile = new File(v.getRutaserver());
                String encodedString = null;

                InputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(tempFile);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                //byte[] bytes;
                byte[] buffer = new byte[1024];
                int bytesRead;
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                System.out.println("Vamos a enviar el video");
                int i = 0;
                try {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        output.write(buffer);
                        //bytes = output.toByteArray();
                        encodedString = Base64.getEncoder().encodeToString(buffer);
                        //theOutput = "PROTOCOLCRISTOTUBE1.0#OK#"+idVideo+"#"+ encodedString;
                        System.out.println("PROTOCOLCRISTOTUBE1.0#OK#" + idVideo + "#" + encodedString);
                        out.println("PROTOCOLCRISTOTUBE1.0#OK#" + idVideo + "#" + encodedString);
                        //System.out.println("Paquetes: "+i);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(KnockKnockProtocol.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Video enviado");
                theOutput = "Video Transmitido Satisfactoriamente";
            } else if (strings[1].equals("VIDEO_UP")) {
                length = Integer.parseInt(strings[2]);
                login = strings[5];
                titulo = strings[6];
                descripcion = strings[7];
                theOutput = "PROTOCOLCRISTOTUBE1.0#OK#VIDEO_UP#PREPARED_TO_RECEIVE#" + strings[3];
                readyToUp = true;
            }

        }

        return theOutput;
    }
    
    synchronized void broadcast(ArrayList<KKMultiServerThread> clientes, String idVideo){
        for(KKMultiServerThread cliente : clientes){
                        cliente.broadcast.println("PROTOCOLCRISTOTUBE1.0#BROADCAST#"+idVideo+"#DELETED");
                }
    }
}
