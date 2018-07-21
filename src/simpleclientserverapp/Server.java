/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientserverapp;

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
 * @author Nick Williams
 */
public class Server {

    public static void main(String[] args) {
        
        try {
            
            System.out.println("Sever started.");
            
            ServerSocket ss = new ServerSocket(9806);
            System.out.println("Waiting for client...");
            Socket soc = ss.accept();
            System.out.println("Connection established.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            
            PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
            
            
            while(true){
                
                String str[] = in.readLine().split(":");
                
                int option = Integer.parseInt(str[0]);
                int num1 = Integer.parseInt(str[1]);
                int num2 = Integer.parseInt(str[2]);
                String result = "";
                
                int flag = 0;
                
                switch(option){
                    case 1: result = num1 + " + " + num2 + " = " + (num1+num2);break;
                    case 2: result = num1 + " - " + num2 + " = " + + (num1-num2);break;
                    case 3: result = num1 + " * " + num2 + " = " + (num1*num2);break;
                    case 4: result = num1 + " / " + num2 + " = " + + (num1/num2);break;
                    case 5: flag = 1;break;
                    default:break;
                }
                
                if(flag == 1){
                    break;
                }
                
                out.println(result);
            }
            
            System.out.println("Sever terminated");
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    
    }
}