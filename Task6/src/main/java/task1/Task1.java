package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class Task1 {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] intArr = {4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7};
        IntStream.of(intArr).forEach(arrayList::add);
        arrayList.forEach(p -> map.put(p, Collections.frequency(arrayList, p)));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }
}
