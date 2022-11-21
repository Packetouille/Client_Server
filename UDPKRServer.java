import java.io.*;
import java.net.*;
class UDPKRServer22 {
 public static void main(String args[]) throws Exception
 { 
   DatagramSocket serverSocket = new DatagramSocket(9876);
   byte[] receiveData=new byte[1024];
   byte[] sendData=new byte[1024];
   while(true)
   {
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        InetAddress IPAddress = receivePacket.getAddress();             // Grabbing IP of receiving packet source. Of type InetAddress
        int port = receivePacket.getPort();                             // Grab port nubmer from receiving packet
        String capitalizedSentence = sentence.toUpperCase();
        sendData = capitalizedSentence.getBytes();
        DatagramPacket sendPacket= new DatagramPacket(sendData, sendData.length, IPAddress, port);  // use IP and port number grabbed from receiving packet
        serverSocket.send(sendPacket);
   }   
 }
}