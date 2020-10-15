package sixth;

import java.util.*;

public class MapCheck {
    public static Map<Integer, ArrayList<Person>> setMap (List<Person> list) {
        Map<Integer, ArrayList<Person>> map = new HashMap<>();
        for (Person l : list)  {
            int year = l.getBirthday().get(Calendar.YEAR);
            if (map.containsKey(year)) {
                map.get(year).add(l);
            } else {
                map.put(year, new ArrayList<>());
                map.get(year).add(l);
            }
        }
        return map;
    }

    public static void compareMaps(HashMap<Integer, ArrayList<Person>> hm, TreeMap<Integer, ArrayList<Person>> tm, LinkedHashMap<Integer,ArrayList<Person>> lhm) {
        System.out.println("     HashMap            |     TreeMap            |     LinkedHashMap      ");
        Set<Integer> hmKeys = hm.keySet();
        for (Integer k : hmKeys) {
            for (int i = 0 ; i < 3; ++i) {
                if (i == 0) {
                    System.out.format("%5d%19s%c%5d%19s%c%5d%19s%n", k, hm.get(k).get(i).getFIO(), '|' , k, tm.get(k).get(i).getFIO(), '|' , k, lhm.get(k).get(i).getFIO());
                } else System.out.format("%5c%19s%-6c%19s%-6c%19s%n", ' ', hm.get(k).get(i).getFIO(), '|', tm.get(k).get(i).getFIO(), '|', lhm.get(k).get(i).getFIO());
            }
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        Person p = new Person();
        p.setBirthday(new GregorianCalendar(1948, 7, 21));
        p.setLastname("Задорнов");
        p.setFirstname("Михаил");
        p.setMiddlename("Николаевич");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1948, 1, 14));
        p.setLastname("Харламов");
        p.setFirstname("Валерий");
        p.setMiddlename("Борисович");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1948, 2, 29));
        p.setLastname("Купченко");
        p.setFirstname("Ирина");
        p.setMiddlename("Петровна");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1970, 1, 29));
        p.setLastname("Маликов");
        p.setFirstname("Дмитрий");
        p.setMiddlename("Юрьевич");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1970, 8, 4));
        p.setLastname("Самойлов");
        p.setFirstname("Глеб");
        p.setMiddlename("Рудольфович");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1970, 8, 6));
        p.setLastname("Могилевская");
        p.setFirstname("Марина");
        p.setMiddlename("Олеговна");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1860, 3, 23));
        p.setLastname("Абаканович");
        p.setFirstname("Станислав");
        p.setMiddlename("Константинович");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1860, 2, 9));
        p.setLastname("Аггеенко");
        p.setFirstname("Владимир");
        p.setMiddlename("Наумович");
        list.add(p);

        p = new Person();
        p.setBirthday(new GregorianCalendar(1860, 2, 5));
        p.setLastname("Адлерберг");
        p.setFirstname("Александр");
        p.setMiddlename("Васильевич");
        list.add(p);


        HashMap<Integer, ArrayList<Person>> hashMap = new HashMap<>(setMap(list));
        TreeMap<Integer, ArrayList<Person>> treeMap = new TreeMap<>(setMap(list));
        LinkedHashMap<Integer, ArrayList<Person>> linkedHashMap = new LinkedHashMap<>(setMap(list));



        compareMaps(hashMap, treeMap, linkedHashMap);

    }
}
