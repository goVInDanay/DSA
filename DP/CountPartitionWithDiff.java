import java.util.*;

public class CountPartitionWithDiff {
    static int mod =(int)(Math.pow(10,9)+7);
    static int findWays(int[] arr, int k){
        int n = arr.length;
        int dp[][] = new int[n][k+1];
        if(arr[0] == 0){
            dp[0][0] = 2; 
        }
        else{
            dp[0][0] = 1;
        }
        
        if(arr[0] !=0 && arr[0] <= k){
            dp[0][arr[0]] = 1;  
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j<=k; j++){
                int notTake = dp[i-1][j];
        
                int take = 0;
                    if(arr[i]<=j)
                        take = dp[i-1][j-arr[i]];
            
                dp[i][j]= (notTake + take) % mod;
            }
        }
        return dp[n-1][k];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for(int i =0 ; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int ans = 0;
        int k = sc.nextInt();
        if(sum - k < 0 || (sum - k) % 2 != 0){
            ans = -1;
        }
        else{
            ans = findWays(arr, (sum - k) / 2);
        }
        System.out.println(ans);
    }
}
