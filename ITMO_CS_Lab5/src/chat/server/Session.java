package chat.server;

import java.io.PrintWriter;

// Расширение класса Thread, в котором дополнительно хранится ник клиента, с которым связана сессия
// и имеется возможность получить поток вывода для отправки сообщений этому клиенту
class Session extends Thread {
    private final PrintWriter out;
    private final Runnable task;

    final String userNickname;

    Session(PrintWriter out, String userNickname, Runnable task) {
        this.out = out;
        this.userNickname = userNickname;
        this.task = task;
    }

    @Override
    public synchronized void run() {
        task.run();
    }

    PrintWriter getPrintWriter() {
        return out;
    }
}
