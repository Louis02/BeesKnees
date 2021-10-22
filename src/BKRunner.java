import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.neovisionaries.ws.client.ThreadType;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketListener;
import com.neovisionaries.ws.client.WebSocketState;

public class BKRunner implements WebSocketListener {
	String token;
	WebSocket socket;
	public BKRunner(String t) {
		this.token=t;
	}
	public void makeNewConnection() {
		
		try {
			WebSocketFactory wsf = new WebSocketFactory();
			this.socket = wsf.createSocket(getGateway());
			socket.addListener(this);
			socket.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebSocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/league/Desktop/tokenn.txt"));
		String token = br.readLine();
		br.close();
		new BKRunner(token);
	}
	
	public String getGateway() {
		String ans = "";
		try {
			URL url = new URL("https://newsapi.org/v2/everything");
			HttpsURLConnection h = (HttpsURLConnection)url.openConnection();
			h.setRequestMethod("GET");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void handleCallbackError(WebSocket arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBinaryFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBinaryMessage(WebSocket arg0, byte[] arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCloseFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onConnectError(WebSocket arg0, WebSocketException arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onConnected(WebSocket arg0, Map<String, List<String>> arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onContinuationFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDisconnected(WebSocket arg0, WebSocketFrame arg1, WebSocketFrame arg2, boolean arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onError(WebSocket arg0, WebSocketException arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFrameError(WebSocket arg0, WebSocketException arg1, WebSocketFrame arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFrameSent(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFrameUnsent(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMessageDecompressionError(WebSocket arg0, WebSocketException arg1, byte[] arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMessageError(WebSocket arg0, WebSocketException arg1, List<WebSocketFrame> arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPingFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPongFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSendError(WebSocket arg0, WebSocketException arg1, WebSocketFrame arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSendingFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSendingHandshake(WebSocket arg0, String arg1, List<String[]> arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStateChanged(WebSocket arg0, WebSocketState arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextFrame(WebSocket arg0, WebSocketFrame arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextMessage(WebSocket arg0, String arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextMessageError(WebSocket arg0, WebSocketException arg1, byte[] arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onThreadCreated(WebSocket arg0, ThreadType arg1, Thread arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onThreadStarted(WebSocket arg0, ThreadType arg1, Thread arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onThreadStopping(WebSocket arg0, ThreadType arg1, Thread arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onUnexpectedError(WebSocket arg0, WebSocketException arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
