# Client_Server

A basic socket program written in Java that connects a Client and Server, and makes an https request using the HttpURLConnection method

Assignment: Write a Java TCP socket program consisting of one client C and one local server S (localhost). Since we are testing behavior with no threads, the code should not have threads. Do not use System.exit() in your code.

The client C
1.1 prints the message “enter an integer 1, 2 or 3
1.2 reads the integer entered by the user
1.3 sends the integer to the server S
1.4 receives and prints the message received from the server S

The local server S (localhost)
1.5 listens for and accepts the connection from C on port 11111
1.6 receives and prints the integer received from the client
1.7 uses the class HttpURLConnection to connect to the web server W on port 443
if integer is 1 W=ieee.org; if integer is 2 W=3gpp.org; if integer is 3 W=eecs.mit.edu
1.8 prints the message “request sent to” followed by the web server name
1.9 receives W’s page from the web server W
1.10 prints the page contents
1.11 sends the message to the client C “content received from” followed by the web server name.
