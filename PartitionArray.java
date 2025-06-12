import java.util.*;
public class PartitionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if((sum & 1) != 0){
            System.out.println("false");
        }
        else{
            int x = sum / 2;

            //Memoization
            int dp[][] = new int[n][x + 1];
            for(int i[] : dp){
                Arrays.fill(i, -1);
            }
            System.out.println(canPartitionMemo(n - 1, x, arr, dp));

            //Tabulation
            System.out.println(canPartitionTab(n, x, arr));
        }
    }
    private static boolean canPartitionMemo(int idx, int k, int arr[], int dp[][]){
        if(k == 0){
            return true;
        }
        if(idx == 0){
            return arr[0] == k;
        }
        if(dp[idx][k] != -1){
            return dp[idx][k] == 0 ? false : true;
        }
        boolean notTake = canPartitionMemo(idx - 1, k, arr, dp);
        boolean take = false;
        if(arr[idx] <= k){
            take = canPartitionMemo(idx - 1, k - arr[idx], arr, dp);
        }
        return take || notTake;
    }
    private static boolean canPartitionTab(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if(arr[i] <= j){
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n - 1][k];
    }
}
