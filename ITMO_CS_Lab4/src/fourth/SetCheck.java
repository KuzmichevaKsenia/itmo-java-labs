package fourth;

import java.util.*;

public class SetCheck {
    public static Set<String> setFromString(String str){
        HashSet<String> hashSet = new HashSet<>();
        String[] stringArray = str.split(" ");
        for (String i : stringArray) hashSet.add(i);
        return hashSet;
    }

    public static void printSet (Set<String> set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next().toString() + ' ');
        System.out.println();
    }

    public static Set<String> union (Set<String> set1, Set<String> set2) {
        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }

    public static Set<String> intersection (Set<String> set1, Set<String> set2) {
        Set<String> set = new LinkedHashSet<>();
        for (String i : set1)
            for (String j : set2)
                if (i.contains(j)) set.add(i);
        return set;
    }

    public static Set<String> subtraction (Set<String> set1, Set<String> set2) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(set1);
        set.removeAll(set2);
        return set;
    }

    public static void main(String[] args) {

        HashSet<String> set1 = new HashSet<>(setFromString("A computer's memory can be viewed as a list of cells into which numbers can be placed or read."));
        TreeSet<String> set2 = new TreeSet<>(setFromString("Each cell has a numbered address and can store a single number."));
        LinkedHashSet<String> set3 = new LinkedHashSet<>(setFromString("The computer can be instructed to put the number 123 into the cell numbered 1357 or to add the number that is in cell 1357 to the number that is in cell 2468 and put the answer into cell 1595."));

        printSet(set1);
        printSet(set2);
        printSet(set3);

        printSet(union(set1, set2));
        printSet(intersection(set2, set3));
        printSet(subtraction(set1, set3));
    }
}
