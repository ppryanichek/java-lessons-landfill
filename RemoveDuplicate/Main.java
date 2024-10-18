import java.util.Arrays;

public class Main
{
     public static void main(String[] args) 
     {
         int[] arr = { 2, 4, 2, 4, 5, 3, 6, 2, 3, 6, 3 };
         arr = removeDuplicates(arr, arr.length);
         System.out.println(Arrays.toString(arr));
     }

    public static int[] removeDuplicates(int[] arr, int len)
    {
        Arrays.sort(arr);

        int[] temparr = new int[len];
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temparr[count++] = arr[i];
            }
        }
        
        temparr[count++] = arr[len - 1];

        return Arrays.copyOfRange(temparr, 0, count);
    }
}
   
