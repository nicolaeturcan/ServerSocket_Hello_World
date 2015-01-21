/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket_hello_world;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSocket_Hello_world {
 
 public static void main(String[] args){
  ServerSocket serverSocket = null;
  Socket socket = null;
  DataInputStream dataInputStream = null;
  DataOutputStream dataOutputStream = null;
  
  try {
   serverSocket = new ServerSocket(8888);
   System.out.println("Listening :8888");
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  while(true){
   try {
    socket = serverSocket.accept();
    dataInputStream = new DataInputStream(socket.getInputStream());
    dataOutputStream = new DataOutputStream(socket.getOutputStream());
    System.out.println("ip: " + socket.getInetAddress());
    System.out.println("message: " + dataInputStream.readUTF());
    dataOutputStream.writeUTF("Hello!" + socket);
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   finally{
    if( socket!= null){
     try {
      socket.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    if( dataInputStream!= null){
     try {
      dataInputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    if( dataOutputStream!= null){
     try {
      dataOutputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
   }
  }
 }
}