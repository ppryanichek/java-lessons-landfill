
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class MyClass {
    private final int id;

    public MyClass(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

class MapOfFunctions {
    private final Map<String, Function<MyClass, String>> functions = new HashMap<>();

    public MapOfFunctions() {
        functions.put("print_it", MyClass::toString);
        functions.put("print_id", myclass -> Integer.toString(myclass.getId()));
        functions.put("id_to_hash", myclass -> {
            int i = myclass.getId();
            return String.format("0x%x%n", i);
        });
    }

    public String doFunctionalWork(MyClass myclass, String key) {
        return functions.get(key).apply(myclass);
    }
}

public class FunctionsInVariables {
    public static void main(String[] args) {
        MapOfFunctions mof = new MapOfFunctions();
        MyClass mc = new MyClass(12345353);

        System.out.println("Id_to_hash: \t" + mof.doFunctionalWork(mc, "id_to_hash"));
        System.out.println("Obj info: \t" + mof.doFunctionalWork(mc, "print_it"));
        System.out.println("ID: \t\t" + mof.doFunctionalWork(mc, "print_id"));
    }

}
