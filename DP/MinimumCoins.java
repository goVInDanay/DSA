import java.util.*;
public class MinimumCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int dp[][] = new int[n][target + 1];
        for(int i = 0; i <= target; i++){
            if(i % arr[0] == 0){
                dp[0][i] = i / arr[0];
            }
            else{
                dp[0][i] = 10 << 9;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE;
                if(arr[i] <= j){
                    take = 1 + dp[i][j - arr[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
    }
}
