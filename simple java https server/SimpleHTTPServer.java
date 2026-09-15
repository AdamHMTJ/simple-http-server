import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.spi.CharsetProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.text.DefaultCaret;
public class SimpleHTTPServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        final ServerSocket server = new ServerSocket(port);
        System.out.println("Listening for connection on port " + port + " ....");
        String videoPathSkl = "C:\\Users\\23231849\\Pictures\\Camera Roll\\WIN_20260914_13_10_15_Pro.mp4";
        String videoPathhome = "C:\\Users\\mroue\\Videos\\Roblox\\Roblox-2026-08-09T23_48_33.331Z.mp4";
        byte[] videoArray = Files.readAllBytes(Paths.get(videoPathhome));
        
       while (true){
        Socket client = server.accept();
        System.out.println("Connection to server found");
        InputStream inputs = client.getInputStream();
        int bytes = inputs.available();
        byte[] array = new byte[bytes];
        inputs.read(array);
        String str = new String(array, StandardCharsets.UTF_8);
        System.out.println(str);
        OutputStream output = client.getOutputStream();
        String data = "Output Test Message";
        String response = "HTTP/1.1 200 OK\r\nContent-Length: " + videoArray.length + "\r\nContent-Type: video/mp4" + "\r\n\r\n";
        System.out.println(response);
        output.write(response.getBytes());
        output.write(videoArray);
        output.flush();
       }


    }

}