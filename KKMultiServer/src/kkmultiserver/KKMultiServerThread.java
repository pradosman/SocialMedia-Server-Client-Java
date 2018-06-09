package kkmultiserver;

import Controlador.UsuarioController;
import Modelo.Usuario;
import Modelo.UsuarioModel;
import java.net.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KKMultiServerThread extends Thread {
    private Socket socket = null;
    UsuarioController controlador = new UsuarioController();
    boolean borrar = false;
    String idVideo;
    ArrayList<KKMultiServerThread> clientes = new ArrayList();
    public PrintWriter broadcast;
    public KnockKnockProtocol kkp;

    public KKMultiServerThread(Socket socket, ArrayList<KKMultiServerThread> clientes) {
        super("KKMultiServerThread");
        this.socket = socket;
        this.clientes = clientes;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
    
    public void run() {

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
            broadcast = out;
            System.out.println("Server ON");
            String inputLine = null, outputLine = null;
            //KnockKnockProtocol kkp = new KnockKnockProtocol();
            kkp = new KnockKnockProtocol();
            /*outputLine = kkp.processInput(null);
            out.println(outputLine);*/
           
            while ((inputLine = in.readLine()) != null) { 
                System.out.println(inputLine);
                        try {
                            outputLine = kkp.processInput(inputLine,out,in,clientes);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(KKMultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(KKMultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.println(outputLine);
                        //System.out.println(outputLine);
                
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
