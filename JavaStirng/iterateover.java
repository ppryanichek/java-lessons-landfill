public class iterateover {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
            String str = "Hello my dear friend!";
            separateCh(str);
    }

    static void separateCh(String str)
    {
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            System.out.printf("%s ", ch[i]);
        }
        System.out.println("");
    }
}