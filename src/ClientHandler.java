import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
	Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		System.out.println("run");
		try {
			String query = "";
			
			InputStream in = socket.getInputStream();
			String total = "";
			int c = in.read();
			while(c!=-1) {
				total +=(char)c;
				if(total.equals("\r")){
					System.out.println("near break");
					break;
				}
				
				if(c=='\n') {
					System.out.println(total);
					total = "";
					if(total.contains("GET ")) {
						String[] words = total.split(" ");
						query = words[1].substring(1);
						//break;
					}
				
				}
				
				c=in.read();
			}
			System.out.println(query);
	
			BufferedReader read = new BufferedReader(new FileReader("Home.html"));
			String line = read.readLine();
			String file = "";
			while(line!=null) {
			file+=line;
			line = read.readLine();
			}
			OutputStream out = socket.getOutputStream();
			out.write("HTTP/1.0 200 OK\r\n".getBytes());
			String input = "Content-Length: "+file.length()+"\r\n";
			out.write(input.getBytes());
			out.write("Content-Type: text/html\r\n\r\n".getBytes());
			out.write(file.getBytes());
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
