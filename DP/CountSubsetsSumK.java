import java.util.*;
public class CountSubsetsSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int dp[][] = new int[n][k + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                int notTake = dp[i - 1][j];
                int take = 0;
                if(arr[i] <= j){
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        System.out.println(dp[n - 1][k]);
    }
}
