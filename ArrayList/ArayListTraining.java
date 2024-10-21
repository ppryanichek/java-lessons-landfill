import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import simpleTimer.SimpleTimer;

public class ArayListTraining {
    public static void main(String[] args) {
        try (SimpleTimer stimer = new SimpleTimer()) {

            // creating shopping list
            List<String> shopping_List = new ArrayList<>();

            // add elements
            shopping_List.add("Cuccumbers");
            shopping_List.add("Tomatoes");
            shopping_List.add("Salad");

            System.out.print("Shopping list is: ");
            writeToConsole(shopping_List);

            // create additional list
            List<String> additional_List = new ArrayList<>();
            Collections.addAll(additional_List,"Milk","Bread","Eggs");

            // copy elements from additional list to shoppint list
            Collections.copy(shopping_List, additional_List);

            System.out.print("Now shopping list is: ");
            writeToConsole(shopping_List);

            // find Bread (BinarySearch)
            System.out.println("The index of Bread is: " + Collections.binarySearch(shopping_List, "Bread") + '\n');

            // sorted shopping list
            Collections.sort(shopping_List);
            System.out.print("Sorted shopping list is: ");
            writeToConsole(shopping_List);

            // find Bread (BinarySearch)
            System.out.println("The index of Bread is: " + Collections.binarySearch(shopping_List, "Bread"));
        }
    }

    static public void writeToConsole(List<String> ls) {
        for (int i = 0; i < ls.size() - 1; i++) {
            System.out.print(ls.get(i) + ", ");
        }
        System.out.println(ls.get(ls.size() - 1) + ".\n");
    }
}