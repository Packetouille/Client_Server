import java.io.*;
import java.net.*;

class TCPKRClient22{
    public static void main(String argv[]) throws Exception {
        String userInput;
        String serverResponse;

        // To read incoming character data from Client use BufferedReader
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        //Create socket, connection to hostid and port#. TCP connection setup
        Socket clientSocket = new Socket("localhost", 11111);

        // To send binary data use DataOutputStream, to read incoming character data use BufferedReader
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        do{
            System.out.println("enter an integer 1, 2, 3 or exit: ");     // Fulfills 1.1   
            userInput = inFromUser.readLine();                              // Fulfills 1.2
            outToServer.writeBytes(userInput + '\n');                       // Fulfills 1.3
            if(!userInput.equals("exit")){
                serverResponse = inFromServer.readLine();
                System.out.println(serverResponse);                         // Fulfills 1.4
            }

        } while (!userInput.equals("exit"));

        System.out.println("Goodbye");
        clientSocket.close();
    }
}