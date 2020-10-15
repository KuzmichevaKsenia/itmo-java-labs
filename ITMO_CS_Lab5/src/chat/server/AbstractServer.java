package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import static chat.utils.Utils.parseXuniProtocol;
// Сервер в наиболее общем виде для задач 10 и 11
public abstract class AbstractServer {
    // Порт, на котором сервер слушает соединения
    private final int port;
    // Для каждого подключенного клиента создается сессия. Каждая сессия
    // сохраняется в мапу и удаляется при отключении клиента
    private final Map<String, Session> sessions = new HashMap<>();

    public AbstractServer(int port) {
        this.port = port;
    }

    // Единственный метод, который нужно переопределить для решения задачи.
    // В нем должна быть реализована логика обработки запроса, приходящего от клиента.
    protected abstract void processRequest(
            Map<String, String> request,
            PrintWriter out,
            String senderNickname);

    protected void firstMSG(PrintWriter out){}

    // Обработка запроса на добавление нового клиента
    private void addClient(Socket socket) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            out.println("Please enter your login");
            out.flush();

            String nickname = in.readLine();

            // Проверяем, не зарегистрирован ли уже клиент с таким ником
            synchronized (sessions) {
                if (sessions.containsKey(nickname)) {
                    String errorMsg = "User " + nickname + " already exists";
                    out.println(errorMsg);
                    out.flush();
                    throw new IllegalArgumentException(errorMsg);
                }
            }

            // Если все ок, напишем об этом клиенту
            out.println("OK");

            firstMSG(out);

            // flush нужен, без него отправленный в поток текст останется в буфере и не дойдет до клиента
            out.flush();

            BufferedReader fromClient = in;
            PrintWriter toClient = out;
            Session session = new Session(toClient, nickname, () -> {
                try (socket;
                     fromClient;
                     toClient) {
                    String messageFromClient;
                    // Начинаем общаться с клиентом
                    while ((messageFromClient = fromClient.readLine()) != null) {
                        System.out.println("New message from client: " + messageFromClient);
                        // Обрабатываем специальный случай сообщения - запрос на отключение
                        if (messageFromClient.equals(":q")) {
                            System.out.println("Closing session with " + nickname);
                            break;
                        }
                        // Парсим сообщение клиента
                        Map<String, String> curRequest = parseXuniProtocol(messageFromClient);
                        synchronized (toClient) {
                            // Отправляем на обработку, которую мы должны переопределить для каждой конкретной задачи
                            processRequest(curRequest, toClient, nickname);
                        }
                        toClient.flush();
                    }
                } catch (Exception e) {
                    toClient.println("Can't add client: " + e.getMessage());
                } finally {
                    synchronized (sessions) {
                        sessions.remove(nickname);
                    }
                }
            });
            synchronized (session) {
                sessions.put(nickname, session);
            }
            session.start();
        } catch (Exception e) {
            System.err.println("Can't add client: " + e.getMessage());
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.println("Connection failed. Error: " + e.getMessage());
                    out.close();
                }
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // Метод для отправки сообщения произвольному клиенту. Наверное, нужен только в задаче 10
    public void writeToClient(String nickname, String message) {
        PrintWriter out = sessions.get(nickname).getPrintWriter();
        synchronized (out) {
            out.println(message);
            out.flush();
        }
    }

    // Запуск сервера
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New connection has been arrived!");
                    addClient(clientSocket);
                } catch (Exception e) {
                    System.err.println("Something went wrong, can't accept new client. Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Can't create server socket: " + e.getMessage());
        }

    }
}
