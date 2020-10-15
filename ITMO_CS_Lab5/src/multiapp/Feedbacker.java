package multiapp;

import chat.client.AbstractClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Feedbacker extends AbstractClient {
    @Override
    protected void receiveMessage(String message) {
        System.out.println(message);
    }

    @Override
    protected void sendMessage(String message, PrintWriter out) {
        if (message.charAt(0) == '/') out.println("cmd=" + message);
        else out.println("answer=" + message);
    }

    @Override
    protected void printMenu(BufferedReader in) {
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Feedbacker().start();
    }
}
