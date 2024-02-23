package arraylists_linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysAndArrayLists {
    public static void main(String[] args) {

        String[] originalArray = {"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray); //pass by reference měni to i originalArray, //NOT resizable but mutable

        originalList.set(0, "one");
        System.out.println(originalList);
        System.out.println(Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder());
        System.out.println("array: " + Arrays.toString(originalArray));

        //  originalList.remove(1); //error
        // originalList.add("fourth"); //error

        List<String> newList = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday"));
        System.out.println(newList);
        newList.add("ah");
        System.out.println(newList);

        ArrayList<String> stringList = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
        String[] stringArray = stringList.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray));

        //   var listOne = List.of("Sunday","Monday","tuesday");
        String[] days = new String[]{"Sunday", "Monday", "tuesday"};
        List<String> listOne = List.of(days); //IMMUTABLE
        // listOne.add("hey"); //error
        System.out.println("list one: " + listOne);
        List<String> listTwo = Arrays.asList("hoho", "haha");
        listTwo.set(0, "ahojki");
        System.out.println("list two: " + listTwo);
        List<String> listThree = new ArrayList<>(List.of("days", "a")); //pres new arraylist funguje
        listThree.add("funguje");
        System.out.println(listThree);

    }
}
