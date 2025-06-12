import java.util.Arrays;

public class SingleNumber3 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1, 5};
        System.out.println(Arrays.toString(number(arr)));
    }
    private static int[] number(int arr[]){
        int xor = 0;
        for(int i : arr){
            xor = xor ^ i;
        }
        int mask = xor & (-1 * xor);
        int a = 0;
        for(int i = 0; i < arr.length; i++){
            if((arr[i] & mask) != 0){
                a = a ^ arr[i];
            }
        }
        int b = xor ^ a;
        int ans[] = {a, b};
        return ans;
    }
}
