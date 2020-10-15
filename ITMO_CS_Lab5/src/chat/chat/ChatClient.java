package chat.chat;

import chat.client.AbstractClient;

import java.io.PrintWriter;
import java.util.Map;

import static chat.utils.Utils.parseXuniProtocol;

// Реализация чат-клиента
public class ChatClient extends AbstractClient {

    // Ожидается сообщение вида sender= <отправитель>;text= <текст сообщения>
    @Override
    protected void receiveMessage(String message) {
        Map<String, String> parsedMessage = parseXuniProtocol(message);
        String sender = parsedMessage.get("sender");
        String text = parsedMessage.get("text");
        if (sender == null || text == null) {
            System.err.println("Wrong message format");
            return;
        }
        System.out.println("From " + sender + ": " + text);
    }

    // Сервер ожидает сообщение вида to= <кому>;text = <текст сообщения>
    @Override
    protected void sendMessage(String message, PrintWriter out) {
        System.out.println("Me: " + message);
        out.println(message);
    }

    public static void main(String[] args) {
        new ChatClient().start();
    }
}
