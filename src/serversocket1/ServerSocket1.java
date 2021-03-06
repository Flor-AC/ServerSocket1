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
        new Thread(){
            @Override
            public void run() {
                try {
                    ServerSocket servidor = new ServerSocket(5000);

                    System.out.println("Servidor Iniciado");
                    while (true) {
                        Socket cliente = servidor.accept();
                        System.out.println("Cliente aceptado");

                        InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
                        BufferedReader receptor = new BufferedReader(isr);
                        PrintWriter emisor = new PrintWriter(cliente.getOutputStream());
                        String msg = receptor.readLine();

                        System.out.println("Msg: " + msg);
                        emisor.println("Que tal ...");
                        emisor.flush();
                        cliente.close();
                        System.out.println("Cliente Desconectado");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServerSocket1.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
        }.start();

    }

}
