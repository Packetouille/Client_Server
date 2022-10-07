// To compile and run the code use commands "javac .java" followed by java .java in the command line.

import java.io.*;
import java.net.*;

class TCPKRClient22{
    public static void main(String argv[]) throws Exception {
        String userInput;
        String serverResponse;

        // Create input stream
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        //Create socket, connection to server (hostid and port#). TCP connection setup
        Socket clientSocket = new Socket("localhost", 11111);

        // Create input (BufferedReader) & output (DataOutputStream) stream attached to socket
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        do{
            System.out.println("enter an integer 1, 2, 3, or exit: ");     // Fulfills 1.1   
            userInput = inFromUser.readLine();                              // Fulfills 1.2
            outToServer.writeBytes(userInput + '\n');                       // Fulfills 1.3. Send line to server
            if(!userInput.equals("exit")){
                serverResponse = inFromServer.readLine();                   // Read line from server
                System.out.println(serverResponse);                         // Fulfills 1.4
            }

        } while (!userInput.equals("exit"));

        System.out.println("Goodbye");
        clientSocket.close();
    }
}