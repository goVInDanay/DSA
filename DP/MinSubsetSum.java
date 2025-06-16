import java.util.*;
public class MinSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        boolean dp[][] = new boolean[n][sum + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if(arr[i] <= target){
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++){
            if(dp[n - 1][i]){
                int diff = Math.abs(i - (sum - i));
                min = Math.min(min, diff);
            }
        }
        System.out.println(min);
    }
}
