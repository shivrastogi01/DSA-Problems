class SuperEggDrop {
    public int superEggDrop(int K, int n) {
        int[][] dp = new int[K+1][n+1];  //dp means up to which floor can be determined
        int count = 0;
        while(dp[K][count] < n) {
            count++;
            for (int k = 1; k <= K; k++) {
                dp[k][count]= dp[k][count-1] + dp[k-1][count-1] + 1;
				//not break + break + this floor can be determined(1)
            }
        }
        return count;
    }
}