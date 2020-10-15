package multithreading.task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ThreadTextAnalisis {
    private volatile TreeMap<String, Integer> map = new TreeMap<>();

    private Thread getAnalizingTask(String path) {
        return new Thread(() -> {
            synchronized(map) {
                map.clear();
                try {
                    FileInputStream in = new FileInputStream(path);
                    int c;
                    String s = "";
                    while ((c = in.read()) != -1) {
                        s += (char) c;
                        if (map.containsKey(s)) {
                            int value = map.get(s);
                            map.put(s, ++value);
                        } else map.put(s, 1);
                        s = "";
                    }
                } catch (IOException e) {
                    System.out.println("Exception caught:");
                    e.printStackTrace();
                }
                System.out.println("Work with the document is over");
            }
        });
    }

    private Thread getPrintingTask() {
        return new Thread(() -> {
            synchronized (map) {
                ArrayList<Integer> list = new ArrayList<>(map.values());
                Collections.sort(list);

                ArrayList<Integer> rareList = new ArrayList<>();
                for (int i = 0; i < 3; ++i) rareList.add(list.get(i));

                ArrayList<Integer> frequentList = new ArrayList<>();
                for (int i = list.size() - 3; i < list.size(); ++i) frequentList.add(list.get(i));

                TreeMap<String, Integer> bufferMap = new TreeMap<>(map);

                System.out.print("Rare characters:");
                for (int i = 0; i < rareList.size(); ++i) {
                    for (Map.Entry<String, Integer> entry : bufferMap.entrySet()) {
                        if (entry.getValue() == rareList.get(i)) {
                            System.out.print(" '" + entry.getKey() + "'=" + entry.getValue());
                            bufferMap.remove(entry.getKey());
                            break;
                        }
                    }
                }
                System.out.print("\nFrequent characters:");
                for (int i = 0; i < frequentList.size(); ++i) {
                    for (Map.Entry<String, Integer> entry : bufferMap.entrySet()) {
                        if (entry.getValue() == frequentList.get(i)) {
                            System.out.print(" '" + entry.getKey() + "'=" + entry.getValue());
                            bufferMap.remove(entry.getKey());
                            break;
                        }
                    }
                }
                System.out.println("\nWork with the document is over");
            }
        });


    }

    public void runAll(String path) {
        getAnalizingTask(path).start();
        getPrintingTask().start();
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/multithreading/task/text.txt";
        new ThreadTextAnalisis().runAll(path);
    }
}