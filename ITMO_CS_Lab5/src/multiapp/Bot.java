package multiapp;


import chat.server.AbstractServer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bot extends AbstractServer {

    private final Map<String, Hotel> hotelMap = new HashMap<>();

    int state = 0;
    private final Map<String, Feedback> feedbackMap = new HashMap<>();

    public Bot(int port) {
        super(port);
    }

    @Override
    protected void processRequest(Map<String, String> request, PrintWriter out, String senderNickname) {
        if (request.containsKey("cmd")) {
            String cmd = request.get("cmd");
            if (cmd.equals("/show")) {
                out.println(hotelMap.keySet().toString());
                out.flush();
            } else if (cmd.equals("/write")) {
                state = 1;
                synchronized (feedbackMap) {
                    feedbackMap.put(senderNickname, new Feedback());
                }
                out.println("Enter hotel name");
            } else if (cmd.equals("/send")) {
                Feedback userFeedback = feedbackMap.get(senderNickname);
                hotelMap.get(userFeedback.hotel).feedbackMap.put(senderNickname, userFeedback);
            }
        } else if (request.containsKey("answer")) {
            String answer = request.get("answer");
            switch (state) {
                case 1:
                    if (hotelMap.containsKey(answer)) {
                        feedbackMap.get(senderNickname).hotel = answer;
                        state++;
                        out.println("Enter date and time of your last hotel visit");
                    } else out.println("No such hotel");
                    break;
                case 2:
                    feedbackMap.get(senderNickname).setDate(answer);
                    state++;
                    out.println("Enter your rating for hotel");
                    break;
                case 3:
                    feedbackMap.get(senderNickname).setRating(Integer.parseInt(answer));
                    state++;
                    out.println("Are you satisfied with the service? {yes, no}");
                    break;
                case 4:
                    boolean bool = answer.equals("yes");
                    feedbackMap.get(senderNickname).setService(bool);
                    state++;
                    out.println("Are you satisfied with the quality of the Internet connection? {yes, no}");
                    break;
                case 5:
                    bool = answer.equals("yes");
                    feedbackMap.get(senderNickname).setNetwork(bool);
                    state++;
                    out.println("Add describe");
                    break;
                case 6:
                    feedbackMap.get(senderNickname).setDescribe(answer);
                    state = 0;
                    out.println("Thank you for your feedback");
                    System.out.println("New feedback from " + senderNickname + feedbackMap.get(senderNickname).toString());
                    break;
                default:
                    System.err.println("Unknown command");
            }
        } else {
            System.err.println("Unknown command");
        }
    }

    @Override
    protected void firstMSG(PrintWriter out) {
        out.println("/show - show hotel list; /write - write feedback; /send - send feedback");
        out.flush();
    }

    public static void main(String[] args) {
        Bot bot = new Bot(6666);
        bot.hotelMap.put("Sleeping giant", new Hotel("Sleeping giant"));
        bot.hotelMap.put("California", new Hotel("California"));
        bot.hotelMap.put("Moscow", new Hotel("Moscow"));
        bot.hotelMap.put("Nick", new Hotel("Nick"));
        bot.hotelMap.put("Big house", new Hotel("Big house"));
        bot.hotelMap.put("Eliot", new Hotel("Eliot"));
        bot.hotelMap.put("Red Sun", new Hotel("Red Sun"));
        bot.hotelMap.put("Pumpkin", new Hotel("Pumpkin"));
        bot.hotelMap.put("Night gate", new Hotel("Night gate"));
        bot.hotelMap.put("Three rabbits", new Hotel("Three rabbits"));
        bot.start();
    }
}
