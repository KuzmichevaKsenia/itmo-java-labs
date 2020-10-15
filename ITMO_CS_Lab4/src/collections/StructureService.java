package collections;

import java.util.*;

public class StructureService {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> rooms = new HashMap<>();
        String new_name;
        String old_name;
        String name;
        long start;
        long time;
        Scanner in = new Scanner(System.in);
        System.out.print("1 - добавить помещение\n2 - удалить помещение\n3 - изменить помещение\n4 - добавить оборудование" +
                "\n5 - удалить оборудование\n6 - изменить оборудование\n0 - завершить процесс");
        while (true) {
            System.out.print("\nВыберите пункт меню -> ");
            if (!in.hasNextInt()) {
                in.next();
                continue;
            }
            switch (in.nextInt()) {
                case 1:
                    in.nextLine();
                    System.out.print("\nВведите название нового помещения -> ");
                    new_name = in.nextLine();
                    start = System.currentTimeMillis();
                    rooms.put(new_name, new ArrayList());
                    time = System.currentTimeMillis() - start;
                    System.out.print("\nДобавлено новое помещение '" + new_name + "' за " + time + " мс\nТекущее состояние коллекции:\n" + rooms.toString());
                    break;
                case 2:
                    in.nextLine();
                    System.out.print("\nВведите название удаляемого помещения -> ");
                    old_name = in.nextLine();
                    if (!rooms.containsKey(old_name)) {
                        System.out.print("\nПомещения '" + old_name + "' не существует");
                        break;
                    }
                    start = System.currentTimeMillis();
                    rooms.remove(old_name);
                    time = System.currentTimeMillis() - start;
                    System.out.print("\nУдалено помещение '" + old_name + "' за " + time + " мс\nТекущее состояние коллекции:\n" + rooms.toString());
                    break;
                case 3:
                    in.nextLine();
                    System.out.print("\nВведите старое название помещения -> ");
                    old_name = in.nextLine();
                    if (!rooms.containsKey(old_name)) {
                        System.out.print("\nПомещения '" + old_name + "' не существует");
                        break;
                    }
                    System.out.print("\nВведите новое название помещения -> ");
                    new_name = in.nextLine();
                    start = System.currentTimeMillis();
                    rooms.put(new_name, rooms.get(old_name));
                    rooms.remove(old_name);
                    time = System.currentTimeMillis() - start;
                    System.out.print("\nПомещение '" + old_name + "' заменено на '" + new_name + "' за " + time + " мс\nТекущее состояние коллекции:\n" + rooms.toString());
                    break;
                case 4:
                    in.nextLine();
                    System.out.print("\nВведите название помещения для добавления нового оборудования -> ");
                    name = in.nextLine();
                    if (!rooms.containsKey(name)) {
                        System.out.print("\nПомещения '" + name + "' не существует");
                        break;
                    }
                    System.out.print("\nВведите название нового оборудования -> ");
                    new_name = in.nextLine();
                    start = System.currentTimeMillis();
                    rooms.get(name).add(new_name);
                    time = System.currentTimeMillis() - start;
                    System.out.print("\nДобавлено новое оборудование '" + new_name + "' в '" + name + "' за " + time + " мс\nТекущее состояние коллекции:\n" + rooms.toString());
                    break;
                case 5:
                    in.nextLine();
                    System.out.print("\nВведите название помещения для удаления оборудования -> ");
                    name = in.nextLine();
                    if (!rooms.containsKey(name)) {
                        System.out.print("\nПомещения '" + name + "' не существует");
                        break;
                    }
                    System.out.print("\nВведите название удаляемого оборудования -> ");
                    old_name = in.nextLine();
                    if (!rooms.get(name).contains(old_name)) {
                        System.out.print("\nОборудования '" + old_name + "' в '" + name + "' не существует");
                        break;
                    }
                    start = System.currentTimeMillis();
                    rooms.get(name).remove(old_name);
                    time = System.currentTimeMillis() - start;
                    System.out.print("\nУдалено оборудование '" + old_name + "' из '" + name + "' за " + time + " мс\nТекущее состояние коллекции:\n" + rooms.toString());
                    break;
                case 6:
                    in.nextLine();
                    System.out.print("\nВведите название помещения для изменения оборудования -> ");
                    name = in.nextLine();
                    if (!rooms.containsKey(name)) {
                        System.out.print("\nПомещения '" + name + "' не существует");
                        break;
                    }
                    System.out.print("\nВведите старое название оборудования -> ");
                    old_name = in.nextLine();
                    if (!rooms.get(name).contains(old_name)) {
                        System.out.print("\nОборудования '" + old_name + "' в '" + name + "' не существует");
                        break;
                    }
                    System.out.print("\nВведите новое название оборудования -> ");
                    new_name = in.nextLine();
                    start = System.currentTimeMillis();
                    rooms.get(name).remove(old_name);
                    rooms.get(name).add(new_name);
                    time = System.currentTimeMillis() - start;
                    System.out.print("\nОборудование '" + old_name + "' из '" + name + "' заменено на '"+ new_name + "' за " + time + " мс\nТекущее состояние коллекции:\n" + rooms.toString());
                    break;
                case 0:
                    return;
            }
        }
    }
}
