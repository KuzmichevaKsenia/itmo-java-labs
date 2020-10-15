package chat.echo;

import chat.client.AbstractClient;

import java.io.PrintWriter;

// Пример реализации простейшего клиента, работающего с эхо-сервером с помощью написанных абстрактных классов
public class EchoClient extends AbstractClient{
    @Override
    protected void receiveMessage(String message) {
        System.out.println("Message from server: " + message);
    }

    @Override
    protected void sendMessage(String message, PrintWriter out) {
        out.println("message=" + message);
    }

    public static void main(String[] args) {
        new EchoClient().start();
    }
}
