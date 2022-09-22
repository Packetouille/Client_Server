import java.io.*;
import java.net.*;

class TCPKRServer22{
    public static void main(String argv[]) throws Exception {
        String clientString;
        String urlSelection = "";
        String htmlReturnedData = "";

        ServerSocket welcomeSocket = new ServerSocket(11111);   // Fulfills 1.5
        Socket connectionSocket = welcomeSocket.accept();            // Fulfills 1.5

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        
        while(true){
        // Keeps server on until user inputs exit, at which point a break from the loop will occur
            clientString = inFromClient.readLine();
            System.out.println("Received from Client: " + clientString);    //Fulfills 1.6

            switch (clientString) {
                case "1":   urlSelection = "https://www.ieee.org";
                            break;
                case "2":   urlSelection = "https://www.3gpp.org";
                            break;
                case "3":   urlSelection = "https://www.eecs.mit.edu";
                            break;
                case "exit":    urlSelection = "exit"; 
                                welcomeSocket.close();
                                break;
                default:    urlSelection = "Invalid Selection!";
                            break;
            }

            if(!urlSelection.equals("Invalid Selection!") && !urlSelection.equals("exit")){
                htmlReturnedData = makeHTTPSRequest(urlSelection);                          // Fufills 1.7
                System.out.println("Returned Data: " + htmlReturnedData);                   // Fulfills 1.10
                outToClient.writeBytes("Contents received from " + urlSelection + '\n');    // Fulfills 1.11
            } else if(urlSelection == "exit"){
                System.out.println("Goodbye");
                break;
            } else{
                System.out.println(urlSelection);
                outToClient.writeBytes(urlSelection + '\n');
            }
        }
    }

    public static String makeHTTPSRequest(String urlRequest) throws Exception{
    //************************************************************************//
    //** PRE-CONDITION: urlRequest variable is populated with an https url. **//
    //** POST-CONDITION: htmlData variable is populated with the data       **//
    //**    received from the https request using HttpURLConnection object. **//
    //**    The data is then returned.                                      **//
    //************************************************************************//

        String htmlData = "";      // Variable that will store cummulative data html data
        String inputLine;          // Variable used to read incoming html line from https request

        System.out.println("Request sent to " + urlRequest);    // Fulfills 1.8
        
        URL obj = new URL(urlRequest);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        while((inputLine = in.readLine()) != null)
        //Populates htmlData variable line by line. Fulfills 1.9
            htmlData += inputLine + '\n';

        return htmlData;
    }
}
