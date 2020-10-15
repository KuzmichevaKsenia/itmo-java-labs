package chat.echo;

import chat.server.AbstractServer;

import java.io.PrintWriter;
import java.util.Map;

// Пример реализации эхо-сервера с помощью написанных абстрактных классов.
public class EchoServer extends AbstractServer {
    public EchoServer(int port) {
        super(port);
    }

    @Override
    protected void processRequest(
            Map<String, String> request,
            PrintWriter out,
            String senderNickname) {
        out.println(request.get("message"));
    }

    public static void main(String[] args) {
        new EchoServer(6666).start();
    }
}
