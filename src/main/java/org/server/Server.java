package org.server;

import servlet.MyServlet;
import servlet.Request;
import servlet.Response;
import servlet.Servlet;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<Class,Servlet> servletMap= new HashMap<>();
    public void start() throws IOException {
        ServerSocket serverSocket =new ServerSocket(8080);
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("accept 1");
            new Thread(()->{
                try{
                    Class<?> myClass = Class.forName("servlet.MyServlet");
                    if(!servletMap.containsKey(myClass)){
                        Constructor<?> constructor = myClass.getConstructor();
                        Servlet servlet = (Servlet) constructor.newInstance();
                        servletMap.put(myClass,servlet);
                        servlet.doGet(new Request(socket.getInputStream()),new Response(socket.getOutputStream()));
                    }else {
                        Servlet servlet = servletMap.get(myClass);
                        servlet.doGet(new Request(socket.getInputStream()),new Response(socket.getOutputStream()));
                    }
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
