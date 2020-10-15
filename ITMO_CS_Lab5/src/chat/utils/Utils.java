package chat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// Утилиты разной степени полезности
public class Utils {

    // Протокол Ксюни - последовательность атрибутов и их значений.
    // В общем виде выглядит так: <атрибут=значение>;[[атрибут=значение]...]
    // Этот метод переводит строку в мапу, где в ключах атрибуты, а значениях их значения
    public static Map<String, String> parseXuniProtocol(String input) {
        String[] entries = input.split(";");
        Map<String, String> result = new HashMap<>();
        Arrays.stream(entries)
                .map(s -> s.split("="))
                .forEach(entry -> {
                    if (entry.length != 2) {
                        throw new IllegalArgumentException("Can't parse string: " + input);
                    }
                    result.put(entry[0].trim(), entry[1].trim());
                });

        return result;
    }

    // Этот метод возможно тебе не пригодится, но он делает обратное предыдущему методу - переводит мапу в строку
    public static String makeXuniProtocolMessage(Map<String, String> message) {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, String> entry : message.entrySet()) {
            res
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append(";");
        }
        return res.toString();
    }

    // Спрашивать у пользователя ввод, пока он не введет что-нибдуь нормальное.
    // Идея не очень удачная, можешь обойтись и без нее
    public static <T> T getUserInput(
            BufferedReader in,
            String prompt, String errorMsg, Function<String, T> parser
    ) throws IOException {
        try {
            if (prompt != null) {
                System.out.println(prompt);
            }
            System.out.print("> ");

            String userInput = in.readLine();

            return parser.apply(userInput);
        } catch (Exception e) {
            if (errorMsg != null) {
                System.err.println(errorMsg);
            } else {
                e.printStackTrace();
            }
            System.out.println("Try again");
            return getUserInput(in, prompt, errorMsg, parser);
        }
    }
}
