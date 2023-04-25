class XORQueriesOfSubArray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefixXor[i] = prefixXor[i-1] ^ arr[i];
        }
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0){
                ans[i] = prefixXor[r];
            }
            else{
                ans[i] = prefixXor[r] ^ prefixXor[l-1];
            }
        }
        return ans;
    }
}