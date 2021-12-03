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
			while (c != -1) {
				total += (char) c;
				if (total.equals("\r")) {
					System.out.println("near break");
					break;
				}

				if (c == '\n') {
					// System.out.println(total);
					if (total.contains("GET ")) {
						String[] words = total.split(" ");
						query = words[1].substring(1);
						// break;
					}
					total = "";

				}

				c = in.read();
			}
			System.out.println("        query " + query);
			if (query.equals("")) {
				BufferedReader read = new BufferedReader(new FileReader("Home.html"));
				String line = read.readLine();
				String file = "";
				while (line != null) {
					file += line;
					line = read.readLine();
				}
				OutputStream out = socket.getOutputStream();
				out.write("HTTP/1.0 200 OK\r\n".getBytes());
				String input = "Content-Length: " + file.length() + "\r\n";
				out.write(input.getBytes());
				out.write("Content-Type: text/html\r\n\r\n".getBytes());
				out.write(file.getBytes());
				out.close();
				in.close();
			}
			else if(query.contains("search=")) {
				String data = query.substring(6, query.length());
				String[] results = data.split("&");
				System.out.println("here");
				String send = "<html>here are your results</html>";
				OutputStream out = socket.getOutputStream();
				out.write("HTTP/1.0 200 OK\r\n".getBytes());
				String input = "Content-Length: " + send.length() + "\r\n";
				out.write(input.getBytes());
				out.write("Content-Type: text/html\r\n\r\n".getBytes());
				out.write(send.getBytes());
				out.close();
				in.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
