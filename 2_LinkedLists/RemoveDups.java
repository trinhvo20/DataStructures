import java.util.HashSet;
import java.util.LinkedList;

// 2.1
// Write code to remove duplicates from an unsorted linked list

public class RemoveDups {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("Before function call: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }

        deleteDups(list);
    }

    static void deleteDups(LinkedList node) {

        // a hash table will help us track duplicates
        HashSet<Integer> set = new HashSet<Integer>();

        LinkedList previous = new LinkedList<>();

        int i = 0;
        while (node.getLast() != null && i < node.size()) {
            int data = (int) node.get(i);
            // if this data is not duplicated, add it to set and previous linked list
            if (!set.contains(data)) {
                set.add(data);
                previous.add(data);
            }
            i++;
        }

        // Print the new previous linked list
        System.out.println("\nAfter function call: ");
        for (int j = 0; j < previous.size(); j++) {
            System.out.print(" " + previous.get(j));
        }
    }

}
