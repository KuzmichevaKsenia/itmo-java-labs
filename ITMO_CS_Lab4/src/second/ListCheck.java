package second;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListCheck {
    /**
     * Prints element's information of Device objects
     *
     * Method is executed in {@link #main(String[])}
     *
     * @param list - List of Device objects
     *
     */
    public static void printList(List<Device> list) {
        for (Device i : list) i.getInf();
    }

    /**
     * Checks the multiplicity of the Device element identifier to transmitted number
     *
     * Method is executed in {@link #main(String[])}
     *
     * @param list - List of Device objects
     * @param device - Device object
     * @param number - check number
     * @return information string about multiplicity or error message
     *
     */
    public static String checkElement(List<Device> list, Device device, int number) {
        if (!list.contains(device)) return "NO SUCH ELEMENT";
        if (device.id % number == 0) return "Identifier is a multiple of " + number;
        else return "Identifier is not a multiple of " + number;
    }

    public static void printListWithIterator(List<Device> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Device elem = (Device) iterator.next();
            elem.getInf();
        }
    }

    public static void main(String[] args) {
        ArrayList<Device> list1 = new ArrayList<>();
        LinkedList<Device> list2 = new LinkedList<>();
        Device device = new Device();
        for (int i = 0; i < 50; ++i) {
            device.id = i;
            device.c = (int) (Math.random() * 241 + 20) * 100;
            list1.add(device);
            list2.add(device);
            device = new Device();
        }

        printList(list1);

        System.out.println(checkElement(list2, device, 8));
        System.out.println(checkElement(list2, list1.get(40), 8));
        System.out.println(checkElement(list2, list1.get(40), 9));

        printListWithIterator(list2);
    }
}
