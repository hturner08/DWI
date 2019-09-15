package com.example.dwi;

import java.net.*;
import java.io.*;
public class PhoneClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public int startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            return 1;
        }catch(Exception e){
            System.out.println("Connection Failed!!!");
            return 0;
        }
    }

    public String sendMessage(String msg) {
        try {
            out.println(msg);
            String resp = in.readLine();
            return resp;
        }catch(Exception e){
            System.out.println("I CANT HEAR YOUUUUUUU");
            return("" + e);
        }
    }

    public int stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}