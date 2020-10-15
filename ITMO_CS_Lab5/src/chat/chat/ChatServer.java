package chat.chat;

import chat.client.AbstractClient;
import chat.server.AbstractServer;

import java.io.PrintWriter;
import java.util.Map;

// Реализация чат-сервера
public class ChatServer extends AbstractServer {

    public ChatServer(int port) {
        super(port);
    }

    @Override
    protected void processRequest(
            Map<String, String> request,
            PrintWriter out,
            String senderNickname) {
        String to = request.get("to");
        String text = request.get("text");

        if (to == null || text == null) {
            System.err.println("Wrong message format");
            return;
        }

        System.out.println("Message from " + senderNickname + " received");
        System.out.println("to: " + to);
        System.out.println("text: " + text);

        String response = "sender=" + senderNickname + ";text=" + text;

        writeToClient(to, response);
    }

    public static void main(String[] args) {
        new ChatServer(6666).start();
    }
}
