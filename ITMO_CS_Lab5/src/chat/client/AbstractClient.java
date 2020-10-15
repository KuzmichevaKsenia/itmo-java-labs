package chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static chat.utils.Utils.getUserInput;

public abstract class AbstractClient {
    private static final String EXIT_CMD = ":q";

    // Тут нужно реализовать логику обработки сообщений от сервера
    protected abstract void receiveMessage(String message);

    // Тут преобразовать пользовательский ввод в подходящий для сервера формат и отправить
    protected abstract void sendMessage(String message, PrintWriter out);

    // Регистрирует пользователя на сервере
    private void logIn(BufferedReader in, PrintWriter out, BufferedReader keyboard) throws IOException {
        System.out.println(in.readLine());

        String nickname = keyboard.readLine();

        out.println(nickname);
        out.flush();

        // Если серверу что-то не нравится, нет смысла продолжать
        String response = in.readLine();
        if (!"OK".equals(response)) {
            throw new IllegalArgumentException("Can't log in: " + response);
        }

        printMenu(in);

    }

    protected void printMenu(BufferedReader in){}

    // Посылает серверу сообщение об отключении
    private void disconnect(PrintWriter out) {
        out.println(EXIT_CMD);
        out.flush();
    }

    // Подключение к серверу
    private void connect(
            String serverHost,
            int serverPort,
            BufferedReader keyboard) {
        try (
                Socket socket = new Socket(serverHost, serverPort);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            // Логинимся
            logIn(in, out, keyboard);

            // Запускаем поток, который будет читать сообщения, приходящие от сервера.
            // Если не создавать под эту задачу отдельный поток, мы не сможем
            // прочитать сообщение от сервера, пока сами что-нибдуь не введем
            Thread reader = new Thread(() -> {
                String messageFromServer;
                try {
                    while (!Thread.currentThread().isInterrupted() &&
                            (messageFromServer = in.readLine()) != null) {
                        // Посылаем полученный от сервера текст обработчику, который
                        // необходимо переопределить для каждой задачи
                        receiveMessage(messageFromServer);
                    }
                } catch (IOException ignored) {

                }
            });
            reader.start();

            // Вводим сообщения с консоли и отправляем серверу
            String messageFromClient;
            while ((messageFromClient = keyboard.readLine()) != null) {
                // Обработка команды выхода
                if (messageFromClient.equals(EXIT_CMD)) {
                    reader.interrupt();
                    disconnect(out);
                    System.out.println("Bye.");
                    return;
                }
                // Послылаем набранный текст обработчику, который необходимо переопределить для каждой задачи
                sendMessage(messageFromClient, out);
                out.flush();
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHost);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Запускает  клиент
    public void start() {
        try (BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
//            String host = getUserInput(
//                    keyboard,
//                    "Please enter server host",
//                    null,
//                    x -> x);
//            int port = getUserInput(
//                    keyboard,
//                    "Please enter server port",
//                    "invalid port",
//                    Integer::parseInt
//            );
//            String nickname = getUserInput(
//                    keyboard,
//                    "Please enter your nickname",
//                    null,
//                    x -> x);
            String host = "localhost";
            int port = 6666;
//            String nickname = "X$enya";

            connect(host, port, keyboard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
