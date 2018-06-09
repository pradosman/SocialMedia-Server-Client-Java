package knockknockclient;

import Vista.ReproductorVideo;
import Vista.GUI;
import Vista.Videos;
import java.io.*;
import java.net.*;
import java.util.Base64;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javax.swing.JTable;
import javax.swing.SwingWorker;

public class KnockKnockClient {
    
    String hostName;
    int portNumber;
    Socket kkSocket;
    PrintWriter out;
    BufferedReader in;
    BufferedReader stdIn;
    GUI ventana = new GUI();
    String login = null;
    int length = 0;
    String [] fromServerCut;
    File file;
    String idVideo = null;
    boolean exit = false;

    public KnockKnockClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }
    
    public KnockKnockClient(){
        this.hostName = "localhost";
        this.portNumber = 8080;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public File getFile(){
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public void clientOn(String cadena) {
        

        try {
            kkSocket = new Socket(hostName, portNumber);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
       
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            
            if(cadena != null){
                System.out.println(cadena);
                out.println(cadena);
                this.exit = false;
            }
                
            
            
            while ((fromServer = in.readLine()) != null && exit == false) {
                System.out.println(fromServer);
                String[] strings = fromServer.split("#");
                
                if(strings[1].equals("GET_ALL_RESPONSE")){
                    Videos ventana = new Videos(fromServer, this);
                    ventana.setVisible(true);
                    /*
                    byte[] decodedBytes = Base64.getDecoder().decode(strings[2].getBytes());

                    try {

                        FileOutputStream out = new FileOutputStream("niggalio.mp4");
                        out.write(decodedBytes);
                        out.close();
                    } catch (Exception e) {
                        // TODO: handle exception
                        //Log.e("Error", e.toString());

                    }
                    */
                }
                else if(strings[2].equals("VIDEO_FOUND")){
                    //System.out.println("Estoy mandando: PROTOCOLCRISTOTUBE1.0#OK#"+login+"#PREPARED_TO_RECEIVE#SIZE_PACKAGE");
                    out.println("PROTOCOLCRISTOTUBE1.0#OK#"+this.login+"#PREPARED_TO_RECEIVE#SIZE_PACKAGE");
                    
                    length = Integer.parseInt(strings[4]);
                }
                
                else if (strings[2].equals("USER_LOGGED")){
                    //System.out.println("Estoy mandando: PROTOCOLCRISTOTUBE1.0#" + strings[7] + "#GET_ALL");
                    out.println("PROTOCOLCRISTOTUBE1.0#" + strings[7] + "#GET_ALL");
                    login = strings[7];
                }
                else if(strings[1].equals("OK") && !(strings[2].equals("VIDEO_UP")) ){
                    
                    System.out.println("Vamos a descodificar");

                        fromServerCut = fromServer.split("#");
                        idVideo = fromServerCut[2];
                        int paquetes = 0;
                        byte[] bytes = new byte[1024];
                        //byte[] total_bytes;
                        int tam = length/1024;
                        int i = 0;
                        
                        File file = new File(new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime()) +".mp4");
                        //File file = new File("temp.mp4");
                        FileOutputStream fileout = new FileOutputStream(file);
                        //ByteArrayOutputStream output = new ByteArrayOutputStream(); 
                        
                        do{
                            System.out.println(fromServer);
                            if(fromServer.contains("BROADCAST")) {
                                if(strings[2].equals(idVideo)){
                                    System.out.println("Video encontrado");
                                    out.println("PROTOCOLCRISTOTUBE1.0#" + this.login + "#DELETE#" + fromServerCut[2] + "#BROADCASTING#OK");
                                    exit = true;
                                }
                            }
                            else if(exit == false){
                                //System.out.println("Paquetes: "+i);
                                bytes = java.util.Base64.getDecoder().decode(fromServerCut[3].getBytes()); 
                                fileout.write(bytes);
                                if(i == 500){
                                    /*
                                    ReproductorVideo r = new ReproductorVideo();
                                    r.setVisible(true);*/

                                    final SwingWorker worker = new SwingWorker(){

                                        @Override
                                        protected Object doInBackground() throws Exception {
                                            ReproductorVideo r = new ReproductorVideo(file);
                                            r.setVisible(true);
                                            return null;
                                        }
                                    };
                                    worker.execute();

                                }
                            }
                            
                            //System.out.println(output.size() + " " + length);
                            if((tam - paquetes) <= 0){
                                exit = true;
                            } 
                            else if (exit == false){
                                fromServer = in.readLine();
                                fromServerCut = fromServer.split("#");
                            }
                            
                            i++;
                            paquetes++;
                        }while(exit == false);
                        
                        try {
                            //total_bytes = output.toByteArray();
                            //out.write(total_bytes);
                            fileout.close();
                        } 
                        catch (Exception e) {}                   
                    
                }
                else if(strings[1].equals("OK") && strings[2].equals("VIDEO_UP")){
                    File tempFile = this.file;
                    String encodedString = null;
                    boolean borrar = false;

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
                        while ((bytesRead = inputStream.read(buffer)) != -1 && borrar == false) {
                            
                            output.write(buffer);
                            //bytes = output.toByteArray();
                            encodedString = Base64.getEncoder().encodeToString(buffer);
                            //theOutput = "PROTOCOLCRISTOTUBE1.0#OK#"+idVideo+"#"+ encodedString;
                            System.out.println("PROTOCOLCRISTOTUBE1.0#OK#"+ encodedString);
                            //System.out.println("Paquetes: "+i);
                            out.println("PROTOCOLCRISTOTUBE1.0#OK#"+ encodedString);
                            i++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        try {
                            inputStream.close();
                        } catch (IOException ex) {
                            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    System.out.println("Video enviado");
                    
                }
                else if(fromServer.contains("BROADCAST")) {
                    
                        out.println("PROTOCOLCRISTOTUBE1.0#" + this.login + "#DELETE#" + strings[2] + "#BROADCASTING#OK");
                        System.out.println("Video encontrado");
                        //this.exit = true;
                }
                else{
                    fromUser = stdIn.readLine();
                    

                    if (fromUser != null) {
                        System.out.println("Client: " + fromUser);
                        out.println(fromUser);
                    }
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
    
    public void enviarMensaje(String cadena){
        try {
            out = new PrintWriter(kkSocket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(cadena);
    }
    
    
    
}