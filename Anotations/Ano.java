
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface Words {
    String word() default "Hello";

    int value() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    Words[] value();
}

@Target(ElementType.TYPE_USE)
@interface TypeAnnoDemo {
}

public class Ano {

    @Words(word = "First", value = 1)
    @Words(word = "Second", value = 2)

    public static void newMethod() {
        Ano obj = new Ano();

        try {
            Annotation anno = obj.getClass().getMethod("newMethod").getAnnotation(MyRepeatedAnnos.class);

            System.out.println(anno);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    static @TypeAnnoDemo int abc() {
        System.out.println("return type is annotated");

        return 0;
    }

    public static void main(String[] args) {

        newMethod();

        {
            @TypeAnnoDemo
            String string = "Annotated with a type annotation";

            System.out.println(string);
            abc();
        }
    }
}