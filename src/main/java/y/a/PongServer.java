package y.a;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value="/ping")
public class PongServer {
	
	private static final Logger log = Logger.getLogger("PongServer");

	public void onOpen(Session session) throws IOException {
		session.getBasicRemote().sendText("Welcome to Ping Pong");
		log.info("Got request from " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		switch (message) {
		case "ping":
			break;
		case "bye":
			session.close();
		default:
			break;
		}
		session.getBasicRemote().sendText("Pong");
	}
	
	public void onClose(Session session) throws IOException {
		session.getBasicRemote().sendText("Hope you enjoyed the ping pong game, Goodbye");
	}
	
}
