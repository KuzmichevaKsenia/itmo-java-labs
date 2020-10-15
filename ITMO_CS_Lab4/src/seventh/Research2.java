package seventh;

import java.util.*;

public class Research2 {
    public static void main(String[] args) {
        HashSet<Sample> hashSet = new HashSet<>();
        TreeSet<Sample> treeSet = new TreeSet<>();
        LinkedHashSet<Sample> linkedHashSet = new LinkedHashSet<>();

        int ID = 0;
        for (int i = 10; i < 10001; i *= 10) {
           while(hashSet.size() != i) {
                hashSet.add(new Sample(ID));
                treeSet.add(new Sample(ID));
                linkedHashSet.add(new Sample(ID++));
            }
            //добавление элемента в множество
            long start = System.currentTimeMillis();
            hashSet.add(new Sample(hashSet.size()));
            long time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): add(new Sample(" + hashSet.size() + ")): " + time + " мс");
            start = System.currentTimeMillis();
            treeSet.add(new Sample(treeSet.size()));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): add(new Sample(" + treeSet.size() + ")): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashSet.add(new Sample(linkedHashSet.size()));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): add(new Sample(" + linkedHashSet.size() + ")): " + time + " мс");
            //добавление значений коллекции в множество (на примере включения List в Set)
            List<Sample> list = new ArrayList<>();
            list.add(new Sample(hashSet.size()));
            start = System.currentTimeMillis();
            hashSet.addAll(list);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): addAll(list): " + time + " мс");
            start = System.currentTimeMillis();
            treeSet.addAll(list);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): addAll(list): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashSet.addAll(list);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): addAll(list): " + time + " мс");
            Set<Sample> set = new HashSet<>();
            set.add(new Sample(hashSet.size()));
            start = System.currentTimeMillis();
            hashSet.addAll(set);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): addAll(set): " + time + " мс");
            start = System.currentTimeMillis();
            treeSet.addAll(set);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): addAll(set): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashSet.addAll(set);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): addAll(set): " + time + " мс");
            //проверка наличия элемента в множестве
            boolean bool;
            Sample sample = new Sample(0);
            start = System.currentTimeMillis();
            bool = hashSet.contains(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): contains(sample): " + time + " мс");
            start = System.currentTimeMillis();
            bool = treeSet.contains(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): contains(sample): " + time + " мс");
            start = System.currentTimeMillis();
            bool = linkedHashSet.contains(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): contains(sample): " + time + " мс");
            //удаление элемента (по значению) из множества
            start = System.currentTimeMillis();
            hashSet.remove(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): remove(sample): " + time + " мс");
            start = System.currentTimeMillis();
            treeSet.remove(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): remove(sample): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashSet.remove(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): remove(sample): " + time + " мс");
            //вывод содержимого контейнера на экран
            start = System.currentTimeMillis();
            System.out.println(hashSet.toString());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): System.out.println(hashSet.toString()): " + time + " мс");
            start = System.currentTimeMillis();
            System.out.println(treeSet.toString());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): System.out.println(treeSet.toString()): " + time + " мс");
            start = System.currentTimeMillis();
            System.out.println(linkedHashSet.toString());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): System.out.println(linkedHashSet.toString()): " + time + " мс");
            //удаление коллекции элементов из списка (на примере использования List)
            list.addAll(hashSet);
            start = System.currentTimeMillis();
            hashSet.removeAll(list);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (HashSet<Sample>): removeAll(list): " + time + " мс");
            start = System.currentTimeMillis();
            treeSet.removeAll(list);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (TreeSet<Sample>): removeAll(list): " + time + " мс");
            start = System.currentTimeMillis();
            linkedHashSet.removeAll(list);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedHashSet<Sample>): removeAll(list): " + time + " мс");

            System.out.println();
        }
    }
}
