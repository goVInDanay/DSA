import java.util.*;
public class RodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        for(int i = 0; i < n; i++){
            val[i] = sc.nextInt();
        }
        int wt[] = new int[n];
        for(int i = 0; i < n; i++){
            wt[i] = sc.nextInt();
        }
        int W = sc.nextInt();

        //Memoization
        int mdp[][] = new int[n][W + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(mdp[i], -1);
        }
        int memo = memoSol(n, wt, val, W, n - 1, mdp);
        
        //Tabulation
        int tab = tabSol(n, wt, val, W);
    }
    private static int memoSol(int n, int wt[], int val[], int W, int idx, int dp[][]){
        if(idx == 0){
            return (((int)(W / wt[0])) * val[0]);
        }
        if(dp[idx][W] != -1){
            return dp[idx][W];
        }
        int notTake = memoSol(n, wt, val, W, idx - 1, dp);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= W){
            take = memoSol(n, wt, val, W - wt[idx], idx - 1, dp);
        }
        return dp[idx][W] = Math.max(take, notTake);
    }

    private static int tabSol(int n, int wt[], int val[], int W){
        int dp[][] = new int[n][W + 1];
        for(int i = wt[0]; i <= W; i++){
            dp[0][i] = ((int)(i / wt[0])) * val[0];
        }
        for(int i = 1; i < n; i++){
            for(int w = 0; w <= W; w++){
                int notTake = dp[i - 1][w];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + dp[i][w - wt[i]];
                }
                dp[i][w] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][W];
    }
}
