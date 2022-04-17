import java.nio.file.Files;
import java.io.*;
import java.net.*;
public class ImageServer {
   public static void main(String[] args) {
       try {       
         ServerSocket server = new ServerSocket(8008);
         
         while (true) {  
            System.out.println("server is waiting for connection request from clients");
            
            Socket s = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));               
            DataOutputStream  out = new DataOutputStream (s.getOutputStream());                  
            
            /* Detailed requirement below*/         
            System.out.println("Checking!");
            //Step one: check the picture name sent from the client, if the picture name equals "Koala.jpg", go to step two, otherwise go to step three
            String line = in.readLine();
            if(line.equals("Koala.jpg")){
                //Step two, read the picture "Koala.jpg" from the local disk, and send the content back to the client.
                File koala = new File("Koala.jpg");
                byte[] bytes = Files.readAllBytes(koala.toPath());
                out.write(bytes);
            }
            else{
                //step three, then reply to the client with "Sorry, no such picture",
                out.writeUTF("Sorry, No such picture");
            }
            
            System.out.println("Sent!");
            //step four, close the input/output streams, close the socket. 
            out.close();
            in.close();
            s.close();
         }
       } catch (Exception e) { e.printStackTrace(); } 
   }
}
