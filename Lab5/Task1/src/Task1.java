import java.util.*;

public class Task1 {
    private static long time_of_add(Collection<Integer> col, Integer elem) {
        long time = System.nanoTime();
        col.add(elem);
        time = System.nanoTime() - time;
        return time;
    }

    private static long time_of_search(Collection<Integer> col, Integer elem) {
        long time = System.nanoTime();
        col.contains(elem);
        time = System.nanoTime() - time;
        return time;
    }

    private static long time_of_remove(Collection<Integer> col, Integer elem) {
        long time = System.nanoTime();
        col.remove(elem);
        time = System.nanoTime() - time;
        return time;
    }

    public static void main(String args[]) {
        List<Collection<Integer>> collections = new ArrayList<>();
        collections.add(new LinkedList<>());
        collections.add(new ArrayList<>());
        collections.add(new TreeSet<>());
        collections.add(new HashSet<>());
        System.out.println("Time for adding items into collections:");
        for (Collection<Integer> collection : collections) {
            List<Long> add_time_list = new ArrayList<>();
            for(int i=0; i<1000000; i++) {
                add_time_list.add(time_of_add(collection, i));
            }
            System.out.println(collection.getClass().toString() + " " + add_time_list.stream().mapToLong(val -> val).average().orElse(0) + " ns.");
        }

        System.out.println("Time for searching items in collections:");
        for (Collection<Integer> collection : collections) {
            List<Long> search_time_list = new ArrayList<>();
            for(int i=100; i<10000; i++) {
                search_time_list.add(time_of_search(collection, i));
            }
            System.out.println(collection.getClass().toString() + " " + search_time_list.stream().mapToLong(val -> val).average().orElse(0) + " ns.");
        }

        System.out.println("Time for removing items from collections:");
        for (Collection<Integer> collection : collections) {
            List<Long> remove_time_list = new ArrayList<>();
            for(int i=1000; i<10000; i++) {
                remove_time_list.add(time_of_remove(collection, i));
            }
            System.out.println(collection.getClass().toString() + " " + remove_time_list.stream().mapToLong(val -> val).average().orElse(0) + " ns.");
        }
    }
}
