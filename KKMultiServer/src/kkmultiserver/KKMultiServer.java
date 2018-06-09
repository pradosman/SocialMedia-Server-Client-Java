package kkmultiserver;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class KKMultiServer {
    int portNumber = 4444;
    boolean listening = true;
    ArrayList<KKMultiServerThread> clientes = new ArrayList();
    
    
    
    public KKMultiServer(int port){
        this.portNumber = port;
        this.listening = true;
    }
    
    

    public KKMultiServer() {
        this.portNumber = 4444;
        this.listening = true;
    }
    public synchronized void serverOn() throws IOException {   
        
        System.out.println("Servidor conectado");
        
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
            while (listening) {
                this.clientes.add(new KKMultiServerThread(serverSocket.accept(),clientes));
	            this.clientes.get(this.clientes.size()-1).start();
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}