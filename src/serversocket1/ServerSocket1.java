/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flor
 */
public class ServerSocket1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor=null;
        Socket cliente=null;
        final int puerto=5000;
        try {
            servidor=new ServerSocket(puerto);
            System.out.println("Servidor Iniciado");
            while(true){
                cliente=servidor.accept();
                System.out.println("Cliente aceptado");
                
                InputStreamReader  isr= new InputStreamReader(cliente.getInputStream());
                BufferedReader receptor=new BufferedReader(isr);
                PrintWriter emisor= new PrintWriter(cliente.getOutputStream());
                String msg=receptor.readLine();
                
                System.out.println("Msg: "+msg);
                emisor.println("Que tal ...");
                emisor.flush();
                cliente.close();
                System.out.println("Cliente Desconectado");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
