package seventh;

import java.util.*;

public class Research1 {
    public static void main(String[] args) {
        ArrayList<Sample> arrayList = new ArrayList<>();
        LinkedList<Sample> linkedList = new LinkedList<>();

        Random random = new Random();

        for (int i = 10; i < 10001; i *= 10) {
            while(arrayList.size() != i) {
                arrayList.add(new Sample(random.nextInt(i)));
                linkedList.add(new Sample(random.nextInt(i)));
            }
            //вставка элемента в конец списка
            long start = System.currentTimeMillis();
            arrayList.add(new Sample(0));
            long time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): add(new Sample(0)): " + time + " мс");
            start = System.currentTimeMillis();
            linkedList.add(new Sample(0));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): add(new Sample(0)): " + time + " мс");
            //вставка элемента в середину списка
            start = System.currentTimeMillis();
            arrayList.add(arrayList.size() / 2, new Sample(0));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): add(" + arrayList.size() / 2 + ", new Sample(0)): " + time + " мс");
            start = System.currentTimeMillis();
            linkedList.add(linkedList.size() / 2, new Sample(0));
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): add(" + linkedList.size() / 2 + ", new Sample(0)): " + time + " мс");
            //получение элемента с позиции в начале списка
            Sample sample;
            start = System.currentTimeMillis();
            sample = arrayList.get(0);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): get(0): " + time + " мс");
            start = System.currentTimeMillis();
            sample = linkedList.get(0);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): get(0): " + time + " мс");
            //получение элемента с позиции в середине списка
            start = System.currentTimeMillis();
            sample = arrayList.get(arrayList.size() / 2);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): get(" + arrayList.size() / 2 + "): " + time + " мс");
            start = System.currentTimeMillis();
            sample = linkedList.get(linkedList.size() / 2);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): get(" + linkedList.size() / 2 + "): " + time + " мс");
            //получение элемента с позиции в конце списка
            start = System.currentTimeMillis();
            sample = arrayList.get(arrayList.size() - 1);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): get(" + (arrayList.size() - 1) + "): " + time + " мс");
            start = System.currentTimeMillis();
            sample = linkedList.get(linkedList.size() - 1);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): get(" + (linkedList.size() - 1) + "): " + time + " мс");
            //проверка наличия элемента в списке
            boolean bool;
            start = System.currentTimeMillis();
            bool = arrayList.contains(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): contains(sample): " + time + " мс");
            start = System.currentTimeMillis();
            bool = linkedList.contains(sample);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): contains(sample): " + time + " мс");
            //вывода содержимого контейнера на экран
            start = System.currentTimeMillis();
            System.out.println(arrayList.toString());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): System.out.println(arrayList.toString()): " + time + " мс");
            start = System.currentTimeMillis();
            System.out.println(linkedList.toString());
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): System.out.println(linkedList.toString()): " + time + " мс");
            //удаление элемента (по значению) из списка
            start = System.currentTimeMillis();
            while(arrayList.remove(new Sample(0))){}
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): remove(new Sample(0)): " + time + " мс");
            start = System.currentTimeMillis();
            while(linkedList.remove(new Sample(0))){}
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): remove(new Sample(0)): " + time + " мс");
            //удаление элемента с позиции в начале списка
            start = System.currentTimeMillis();
            arrayList.remove(0);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): remove(0): " + time + " мс");
            start = System.currentTimeMillis();
            linkedList.remove(0);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): remove(0): " + time + " мс");
            //удаление элемента с позиции в середине списка
            start = System.currentTimeMillis();
            arrayList.remove(arrayList.size() / 2);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): remove(" + arrayList.size() / 2 + "): " + time + " мс");
            start = System.currentTimeMillis();
            linkedList.remove(linkedList.size() / 2);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): remove(" + linkedList.size() / 2 + "): " + time + " мс");
            //удаление элемента с позиции в конце списка
            start = System.currentTimeMillis();
            arrayList.remove(arrayList.size() - 1);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): remove(" + (arrayList.size() - 1) + "): " + time + " мс");
            start = System.currentTimeMillis();
            linkedList.remove(linkedList.size() - 1);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): remove(" + (linkedList.size() - 1) + "): " + time + " мс");
            //удаление коллекции элементов из спискаа (на примере использования Set)
            Set<Sample> setFromArrayList = new HashSet<>(arrayList);
            Set<Sample> setFromLinkedList = new HashSet<>(linkedList);
            start = System.currentTimeMillis();
            arrayList.removeAll(setFromLinkedList);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (ArrayList<Sample>): removeAll(setFromLinkedList): " + time + " мс");
            start = System.currentTimeMillis();
            linkedList.removeAll(setFromArrayList);
            time = System.currentTimeMillis() - start;
            System.out.println(i + " elements (LinkedList<Sample>): removeAll(setFromArrayList): " + time + " мс");

            System.out.println();
        }
    }
}