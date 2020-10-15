package seventh;

import java.util.*;

public class Research3 {
    public static void main(String[] args) {
        HashMap<String, Sample> hashMap = new HashMap<>();
        TreeMap<String, Sample> treeMap = new TreeMap<>();
        LinkedHashMap<String, Sample> linkedHashMap = new LinkedHashMap<>();

        Random random = new Random();

        int ID = 0;
        for (int i = 10; i < 10001; i *= 10) {
            while (hashMap.size() != i) {
                hashMap.put("k" + ID, new Sample(random.nextInt(i)));
                treeMap.put("k" + ID, new Sample(random.nextInt(i)));
                linkedHashMap.put("k" + ID++, new Sample(random.nextInt(i)));
            }
            //вставка пары ключ-значение
            long start = System.currentTimeMillis();
            hashMap.put("k" + ID, new Sample(0));
            long time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): put(\"k\" + " + ID + ", new Sample(0)): " + time + " мс");
            start = System.currentTimeMillis();
            treeMap.put("k" + ID, new Sample(0));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): put(\"k\" + " + ID + ", new Sample(0)): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashMap.put("k" + ID++, new Sample(0));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): put(\"k\" + " + ID + ", new Sample(0)): " + time + " мс");
            //получение множества пар ключ-значение
            List list = new ArrayList();
            start = System.currentTimeMillis();
            list = new ArrayList(hashMap.entrySet());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): entrySet(): " + time + " мс");
            start = System.currentTimeMillis();
            list = new ArrayList(treeMap.entrySet());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): entrySet(): " + time + " мс");
            start = System.currentTimeMillis();
            list = new ArrayList(linkedHashMap.entrySet());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): entrySet(): " + time + " мс");
            //получение значения по ключу
            Sample sample;
            start = System.currentTimeMillis();
            sample = hashMap.get("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): get(\"k0\"): " + time + " мс");
            start = System.currentTimeMillis();
            sample = treeMap.get("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): get(\"k0\"): " + time + " мс");
            start = System.currentTimeMillis();
            sample = linkedHashMap.get("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): get(\"k0\"): " + time + " мс");
            //проверка наличия ключа в контейнере
            boolean bool;
            start = System.currentTimeMillis();
            bool = hashMap.containsKey("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): containsKey(\"k0\"): " + time + " мс");
            start = System.currentTimeMillis();
            bool = treeMap.containsKey("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): containsKey(\"k0\"): " + time + " мс");
            start = System.currentTimeMillis();
            bool = linkedHashMap.containsKey("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): containsKey(\"k0\"): " + time + " мс");
            //проверка наличия значения в контейнере
            start = System.currentTimeMillis();
            bool = hashMap.containsValue(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): containsValue(sample): " + time + " мс");
            start = System.currentTimeMillis();
            bool = treeMap.containsValue(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): containsValue(sample): " + time + " мс");
            start = System.currentTimeMillis();
            bool = linkedHashMap.containsValue(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): containsValue(sample): " + time + " мс");
            //удаление пары ключ-значение по ключу
            start = System.currentTimeMillis();
            hashMap.remove("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): remove(\"k0\"): " + time + " мс");
            start = System.currentTimeMillis();
            treeMap.remove("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): remove(\"k0\"): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashMap.remove("k0");
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): remove(\"k0\"): " + time + " мс");
            //получение множества ключей контейнера
            start = System.currentTimeMillis();
            list = new ArrayList(hashMap.keySet());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): keySet(): " + time + " мс");
            start = System.currentTimeMillis();
            list = new ArrayList(treeMap.keySet());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): keySet(): " + time + " мс");
            start = System.currentTimeMillis();
            list = new ArrayList(linkedHashMap.keySet());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): keySet(): " + time + " мс");
            //получение множества значений контейнера
            start = System.currentTimeMillis();
            list = new ArrayList(hashMap.values());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashMap<String, Sample>): values(): " + time + " мс");
            start = System.currentTimeMillis();
            list = new ArrayList(treeMap.values());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeMap<String, Sample>): values(): " + time + " мс");
            start = System.currentTimeMillis();
            list = new ArrayList(linkedHashMap.values());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashMap<String, Sample>): values(): " + time + " мс");

            System.out.println();
        }
    }
}
