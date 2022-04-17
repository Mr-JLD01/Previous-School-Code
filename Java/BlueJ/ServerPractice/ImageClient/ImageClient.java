import java.io.*;
import java.net.*;

public class ImageClient {
    public static void main(String[] args) {
        String host = "localhost";
        try {
            Socket socket = new Socket(host, 8008);
            BufferedInputStream in = new BufferedInputStream(
                    socket.getInputStream());
            PrintWriter out = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            
            /* Detailed requirement below*/
            
            // Step one: send the picture name "Koala.jpg" to the server
            out.println("Koalas.jpg");//incorrect, should return no image
            //out.println("Koala.jpg");//correct, should copy image
            out.flush();
            
            System.out.println("Sent!");
            
            // Step two: write the response from the server to a local file "Koala-1.jpg";
            
            int nRead = 0;
            byte[] inData = new byte[1000];
            File inPic = new File("Koala-1.jpg");
            FileOutputStream outFile = new FileOutputStream(inPic);
            
            while((nRead = in.read(inData)) != -1){
                outFile.write(inData);
            }
            
            System.out.println("Copied!");
            
            // Step three: close all the input/output streams and socket.
            outFile.close();
            
            out.close();
            in.close();
            socket.close();
            // Step four: try to read the file "Koala-1.jpg" using any picture viewer. If you can view the picture correctly, your download of picture is correct       
            // run the client code again and try to send a wrong picture name "Koala-wrong.jpg"
            // you will create a Koala-1.jpg again, this time use a normal text editor to open it, if you see "Sorry, no such picture", then your program is correct. 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
