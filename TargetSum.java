class TargetSum {
   
    public int findTargetSumWays(int[] arr, int diff) {
        
        int sumofArray = 0;
        for(int i=0;i<arr.length;i++){
            sumofArray+= arr[i];
        }
        
        int sum = (diff+sumofArray)/2;
        
        if(sumofArray+diff<0 || (sumofArray+diff)%2==1){ // point 1.  
            return 0;
        }
        
        return countofSubsetSum(arr,sum);
    }
    
    public int countofSubsetSum(int[] arr, int sum){
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }
        
        // 'j' started from zero to handle multiple zeros input edge case
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){  // point 3.
                if(arr[i-1]<= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
}