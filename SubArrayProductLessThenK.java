class SubArrayProductLessThenK
 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0||k==1) return 0;
        int s=0,e=0;
        int tk=1;
        int ans=0;
        for(e=0;e<nums.length;e++){
            tk=tk*nums[e];
            while(tk>=k){
                tk=tk/nums[s];
                s++;
            }
            ans+=e-s+1;
            
        }
        return ans;
    }
}